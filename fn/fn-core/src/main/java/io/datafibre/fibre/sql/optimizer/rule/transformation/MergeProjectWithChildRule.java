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
import io.datafibre.fibre.sql.optimizer.ExpressionContext;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptimizerContext;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefSet;
import io.datafibre.fibre.sql.optimizer.operator.Operator;
import io.datafibre.fibre.sql.optimizer.operator.OperatorBuilderFactory;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.Projection;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalOperator;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalProjectOperator;
import io.datafibre.fibre.sql.optimizer.operator.pattern.Pattern;
import io.datafibre.fibre.sql.optimizer.rule.RuleType;

import java.util.List;

public class MergeProjectWithChildRule extends TransformationRule {
    public MergeProjectWithChildRule() {
        super(RuleType.TF_MERGE_PROJECT_WITH_CHILD,
                Pattern.create(OperatorType.LOGICAL_PROJECT).
                        addChildren(Pattern.create(OperatorType.PATTERN_LEAF, OperatorType.PATTERN_MULTI_LEAF)));
    }

    @Override
    public List<OptExpression> transform(OptExpression input, OptimizerContext context) {
        LogicalProjectOperator logicalProjectOperator = (LogicalProjectOperator) input.getOp();
        LogicalOperator child = (LogicalOperator) input.inputAt(0).getOp();
        boolean isPushLimit = logicalProjectOperator.hasLimit() && (!child.hasLimit() || child.getLimit() >
                logicalProjectOperator.getLimit());
        Operator.Builder builder = OperatorBuilderFactory.build(child);
        builder.withOperator(child);
        if (isPushLimit) {
            builder.setLimit(logicalProjectOperator.getLimit());
        }

        if (logicalProjectOperator.getColumnRefMap().isEmpty()) {
            return Lists.newArrayList(OptExpression.create(builder.build(), input.inputAt(0).getInputs()));
        }


        ColumnRefSet projectColumns = logicalProjectOperator.getOutputColumns(
                new ExpressionContext(input));
        ColumnRefSet childOutputColumns = child.getOutputColumns(new ExpressionContext(input.inputAt(0)));
        if (projectColumns.equals(childOutputColumns)) {
            return Lists.newArrayList(OptExpression.create(builder.build(), input.inputAt(0).getInputs()));
        }

        builder.setProjection(new Projection(logicalProjectOperator.getColumnRefMap()));

        return Lists.newArrayList(OptExpression.create(builder.build(), input.inputAt(0).getInputs()));
    }
}
