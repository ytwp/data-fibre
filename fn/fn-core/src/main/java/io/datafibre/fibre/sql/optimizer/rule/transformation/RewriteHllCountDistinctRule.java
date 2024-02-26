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
import io.datafibre.fibre.analysis.FunctionName;
import io.datafibre.fibre.catalog.Function;
import io.datafibre.fibre.catalog.FunctionSet;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptimizerContext;
import io.datafibre.fibre.sql.optimizer.operator.AggType;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalAggregationOperator;
import io.datafibre.fibre.sql.optimizer.operator.pattern.Pattern;
import io.datafibre.fibre.sql.optimizer.operator.scalar.CallOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.rule.RuleType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.datafibre.fibre.catalog.Function.CompareMode.IS_NONSTRICT_SUPERTYPE_OF;

public class RewriteHllCountDistinctRule extends TransformationRule {
    public RewriteHllCountDistinctRule() {
        super(RuleType.TF_REWRITE_HLL_COUNT_DISTINCT,
                Pattern.create(OperatorType.LOGICAL_AGGR).addChildren(Pattern.create(
                        OperatorType.PATTERN_LEAF)));
    }

    @Override
    public boolean check(OptExpression input, OptimizerContext context) {
        LogicalAggregationOperator aggregationOperator = (LogicalAggregationOperator) input.getOp();

        return aggregationOperator.getAggregations().values().stream().anyMatch(
                agg -> agg.isDistinct() &&
                        agg.getFunction().getFunctionName().getFunction().equals(FunctionSet.COUNT) &&
                        agg.getChildren().size() == 1 &&
                        agg.getChildren().get(0).getType().isHllType());
    }

    @Override
    public List<OptExpression> transform(OptExpression input, OptimizerContext context) {
        LogicalAggregationOperator aggregationOperator = (LogicalAggregationOperator) input.getOp();

        Map<ColumnRefOperator, CallOperator> newAggMap = new HashMap<>();
        for (Map.Entry<ColumnRefOperator, CallOperator> aggMap : aggregationOperator.getAggregations().entrySet()) {
            CallOperator oldFunctionCall = aggMap.getValue();
            if (oldFunctionCall.isDistinct() &&
                    oldFunctionCall.getFunction().getFunctionName().getFunction().equals(FunctionSet.COUNT) &&
                    oldFunctionCall.getChildren().size() == 1 &&
                    oldFunctionCall.getChildren().get(0).getType().isHllType()) {
                Function searchDesc = new Function(new FunctionName(FunctionSet.HLL_UNION_AGG),
                        oldFunctionCall.getFunction().getArgs(), Type.INVALID, false);
                Function fn = GlobalStateMgr.getCurrentState().getFunction(searchDesc, IS_NONSTRICT_SUPERTYPE_OF);

                CallOperator c = new CallOperator(FunctionSet.HLL_UNION_AGG,
                        oldFunctionCall.getType(), oldFunctionCall.getChildren(), fn);
                newAggMap.put(aggMap.getKey(), c);
            } else {
                newAggMap.put(aggMap.getKey(), aggMap.getValue());
            }
        }
        return Lists.newArrayList(OptExpression.create(
                new LogicalAggregationOperator(AggType.GLOBAL, aggregationOperator.getGroupingKeys(), newAggMap),
                input.getInputs()));
    }
}
