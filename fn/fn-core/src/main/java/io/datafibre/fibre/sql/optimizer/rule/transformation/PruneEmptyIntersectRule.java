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
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptimizerContext;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalIntersectOperator;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalValuesOperator;
import io.datafibre.fibre.sql.optimizer.operator.pattern.Pattern;
import io.datafibre.fibre.sql.optimizer.rule.RuleType;

import java.util.Collections;
import java.util.List;

/*
case:
        Intersect
      /    |     \       ->  Empty
   Empty  Child1  Child2
 */
public class PruneEmptyIntersectRule extends TransformationRule {
    public PruneEmptyIntersectRule() {
        super(RuleType.TF_PRUNE_EMPTY_INTERSECT,
                Pattern.create(OperatorType.LOGICAL_INTERSECT, OperatorType.PATTERN_MULTI_LEAF));
    }

    @Override
    public boolean check(OptExpression input, OptimizerContext context) {
        return input.getInputs().stream().map(OptExpression::getOp).filter(op -> op instanceof LogicalValuesOperator)
                .anyMatch(op -> ((LogicalValuesOperator) op).getRows().isEmpty());
    }

    @Override
    public List<OptExpression> transform(OptExpression input, OptimizerContext context) {
        LogicalIntersectOperator intersectOperator = (LogicalIntersectOperator) input.getOp();
        return Lists.newArrayList(OptExpression
                .create(new LogicalValuesOperator(intersectOperator.getOutputColumnRefOp(), Collections.emptyList())));
    }
}
