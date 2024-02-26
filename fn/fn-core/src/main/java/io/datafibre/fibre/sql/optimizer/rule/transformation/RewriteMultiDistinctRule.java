// Copyright 2021-present StarRocks, Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package io.datafibre.fibre.sql.optimizer.rule.transformation;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.datafibre.fibre.catalog.FunctionSet;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.sql.common.ErrorType;
import io.datafibre.fibre.sql.common.StarRocksPlannerException;
import io.datafibre.fibre.sql.optimizer.ExpressionContext;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptimizerContext;
import io.datafibre.fibre.sql.optimizer.Utils;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalAggregationOperator;
import io.datafibre.fibre.sql.optimizer.operator.pattern.Pattern;
import io.datafibre.fibre.sql.optimizer.operator.scalar.CallOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;
import io.datafibre.fibre.sql.optimizer.rule.RuleType;
import io.datafibre.fibre.sql.optimizer.statistics.Statistics;
import io.datafibre.fibre.sql.optimizer.statistics.StatisticsCalculator;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static io.datafibre.fibre.sql.optimizer.statistics.StatisticsEstimateCoefficient.LOW_AGGREGATE_EFFECT_COEFFICIENT;
import static io.datafibre.fibre.sql.optimizer.statistics.StatisticsEstimateCoefficient.MEDIUM_AGGREGATE_EFFECT_COEFFICIENT;

public class RewriteMultiDistinctRule extends TransformationRule {

    public RewriteMultiDistinctRule() {
        super(RuleType.TF_REWRITE_MULTI_DISTINCT,
                Pattern.create(OperatorType.LOGICAL_AGGR).addChildren(Pattern.create(
                        OperatorType.PATTERN_LEAF)));
    }

    @Override
    public boolean check(OptExpression input, OptimizerContext context) {
        LogicalAggregationOperator agg = (LogicalAggregationOperator) input.getOp();

        Optional<List<ColumnRefOperator>> distinctCols = Utils.extractCommonDistinctCols(agg.getAggregations().values());

        // all distinct function use the same distinct columns, we use the split rule to rewrite
        return !distinctCols.isPresent();
    }

    public List<OptExpression> transform(OptExpression input, OptimizerContext context) {
        if (useCteToRewrite(input, context)) {
            MultiDistinctByCTERewriter rewriter = new MultiDistinctByCTERewriter();
            return rewriter.transformImpl(input, context);
        } else {
            MultiDistinctByMultiFuncRewriter rewriter = new MultiDistinctByMultiFuncRewriter();
            return rewriter.transformImpl(input, context);
        }
    }

    private boolean useCteToRewrite(OptExpression input, OptimizerContext context) {
        LogicalAggregationOperator agg = (LogicalAggregationOperator) input.getOp();
        List<CallOperator> distinctAggOperatorList = agg.getAggregations().values().stream()
                .filter(CallOperator::isDistinct).collect(Collectors.toList());
        boolean hasMultiColumns = distinctAggOperatorList.stream().anyMatch(f -> f.getColumnRefs().size() > 1);
        // exist multiple distinct columns should enable cte use
        if (hasMultiColumns) {
            if (!context.getSessionVariable().isCboCteReuse()) {
                throw new StarRocksPlannerException(ErrorType.USER_ERROR,
                        "%s is unsupported when cbo_cte_reuse is disabled", distinctAggOperatorList);
            } else {
                return true;
            }
        }

        // respect prefer cte rewrite hint
        if (context.getSessionVariable().isCboCteReuse() && context.getSessionVariable().isPreferCTERewrite()) {
            return true;
        }

        // respect skew int
        if (context.getSessionVariable().isCboCteReuse() && agg.hasSkew() && !agg.getGroupingKeys().isEmpty()) {
            return true;
        }

        if (context.getSessionVariable().isCboCteReuse() &&
                isCTEMoreEfficient(input, context, distinctAggOperatorList)) {
            return true;
        }

        // all distinct one column function can be rewritten by multi distinct function
        boolean canRewriteByMultiFunc = true;
        for (CallOperator distinctCall : distinctAggOperatorList) {
            String fnName = distinctCall.getFnName();
            List<ScalarOperator> children = distinctCall.getChildren();
            Type type = children.get(0).getType();
            if (type.isComplexType()
                    || type.isJsonType()
                    || FunctionSet.GROUP_CONCAT.equalsIgnoreCase(fnName)
                    || (FunctionSet.ARRAY_AGG.equalsIgnoreCase(fnName) && type.isDecimalOfAnyVersion())) {
                canRewriteByMultiFunc = false;
                break;
            }
        }

        if (!context.getSessionVariable().isCboCteReuse() && !canRewriteByMultiFunc) {
            throw new StarRocksPlannerException(ErrorType.USER_ERROR,
                    "%s is unsupported when cbo_cte_reuse is disabled", distinctAggOperatorList);
        }

        return !canRewriteByMultiFunc;
    }

    private boolean isCTEMoreEfficient(OptExpression input, OptimizerContext context,
                                       List<CallOperator> distinctAggOperatorList) {
        LogicalAggregationOperator aggOp = input.getOp().cast();
        if (aggOp.hasLimit()) {
            return false;
        }
        calculateStatistics(input, context);

        Statistics inputStatistics = input.inputAt(0).getStatistics();
        List<ColumnRefOperator> neededCols = Lists.newArrayList(aggOp.getGroupingKeys());
        distinctAggOperatorList.stream().forEach(e -> neededCols.addAll(e.getColumnRefs()));

        // no statistics available, use cte for no group by or group by only one col scenes to avoid bad case of multiple_func
        if (neededCols.stream().anyMatch(e -> inputStatistics.getColumnStatistics().get(e).isUnknown())) {
            return aggOp.getGroupingKeys().size() < 2;
        }

        double inputRowCount = inputStatistics.getOutputRowCount();
        List<Double> deduplicateOutputRows = Lists.newArrayList();
        List<Double> distinctValueCounts = Lists.newArrayList();
        for (CallOperator callOperator : distinctAggOperatorList) {
            List<ColumnRefOperator> distinctColumns = callOperator.getColumnRefs();
            if (distinctColumns.isEmpty()) {
                continue;
            }
            Set<ColumnRefOperator> deduplicateKeys = Sets.newHashSet();
            deduplicateKeys.addAll(aggOp.getGroupingKeys());
            deduplicateKeys.addAll(distinctColumns);
            deduplicateOutputRows.add(StatisticsCalculator.computeGroupByStatistics(Lists.newArrayList(deduplicateKeys),
                    inputStatistics, Maps.newHashMap()));
            distinctValueCounts.add(inputStatistics.getColumnStatistics().get(distinctColumns.get(0)).getDistinctValuesCount());
        }

        if (distinctValueCounts.stream().allMatch(d -> d < MEDIUM_AGGREGATE_EFFECT_COEFFICIENT)) {
            // distinct key with an extreme low cardinality use multi_distinct_func maybe more efficient
            return false;
        } else if (deduplicateOutputRows.stream().allMatch(row -> row * LOW_AGGREGATE_EFFECT_COEFFICIENT < inputRowCount)) {
            return false;
        }
        return true;
    }

    private void calculateStatistics(OptExpression expr, OptimizerContext context) {
        // Avoid repeated calculate
        if (expr.getStatistics() != null) {
            return;
        }

        for (OptExpression child : expr.getInputs()) {
            calculateStatistics(child, context);
        }

        ExpressionContext expressionContext = new ExpressionContext(expr);
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(
                expressionContext, context.getColumnRefFactory(), context);
        statisticsCalculator.estimatorStats();
        expr.setStatistics(expressionContext.getStatistics());
    }
}
