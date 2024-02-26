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
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptimizerContext;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalAggregationOperator;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalProjectOperator;
import io.datafibre.fibre.sql.optimizer.operator.pattern.Pattern;
import io.datafibre.fibre.sql.optimizer.operator.scalar.CallOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;
import io.datafibre.fibre.sql.optimizer.rule.RuleType;

import java.util.List;
import java.util.Map;
import java.util.Set;

// Rewrite sql:
// select bitmap_union_count(x), count(distinct x) from table having count(distinct x)
// reduce one calculation count(distinct)
public class RewriteDuplicateAggregateFnRule extends TransformationRule {
    public RewriteDuplicateAggregateFnRule() {
        super(RuleType.TF_REWRITE_DUPLICATE_AGGREGATE_FN,
                Pattern.create(OperatorType.LOGICAL_AGGR, OperatorType.PATTERN_LEAF));
    }

    @Override
    public boolean check(OptExpression input, OptimizerContext context) {
        LogicalAggregationOperator aggregation = (LogicalAggregationOperator) input.getOp();
        Set<CallOperator> duplicateCheck = Sets.newHashSet();
        duplicateCheck.addAll(aggregation.getAggregations().values());
        return duplicateCheck.size() != aggregation.getAggregations().size();
    }

    @Override
    public List<OptExpression> transform(OptExpression input, OptimizerContext context) {
        LogicalAggregationOperator aggregation = (LogicalAggregationOperator) input.getOp();

        Map<CallOperator, ColumnRefOperator> revertAggMap = Maps.newHashMap();

        Map<ColumnRefOperator, ScalarOperator> projectMap = Maps.newHashMap();
        aggregation.getGroupingKeys().forEach(g -> projectMap.put(g, g));

        for (Map.Entry<ColumnRefOperator, CallOperator> entry : aggregation.getAggregations().entrySet()) {
            if (revertAggMap.containsKey(entry.getValue())) {
                projectMap.put(entry.getKey(), revertAggMap.get(entry.getValue()));
            } else {
                projectMap.put(entry.getKey(), entry.getKey());
                revertAggMap.put(entry.getValue(), entry.getKey());
            }
        }

        LogicalProjectOperator projectOperator = new LogicalProjectOperator(projectMap);

        Map<ColumnRefOperator, CallOperator> newAggMap = Maps.newHashMap();
        revertAggMap.forEach((key, value) -> newAggMap.put(value, key));

        LogicalAggregationOperator newAggregation =
                new LogicalAggregationOperator(aggregation.getType(), aggregation.getGroupingKeys(), newAggMap);

        return Lists.newArrayList(OptExpression.create(projectOperator,
                OptExpression.create(newAggregation, input.getInputs())));
    }
}
