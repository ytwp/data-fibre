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

import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptimizerContext;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefSet;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalSetOperator;
import io.datafibre.fibre.sql.optimizer.operator.pattern.Pattern;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.rule.RuleType;

import java.util.Collections;
import java.util.List;

public class PruneExceptColumnsRule extends TransformationRule {
    public PruneExceptColumnsRule() {
        super(RuleType.TF_PRUNE_EXCEPT_COLUMNS,
                Pattern.create(OperatorType.LOGICAL_EXCEPT)
                        .addChildren(Pattern.create(OperatorType.PATTERN_MULTI_LEAF)));
    }

    @Override
    public List<OptExpression> transform(OptExpression input, OptimizerContext context) {
        ColumnRefSet requiredOutputColumns = context.getTaskContext().getRequiredColumns();

        LogicalSetOperator lso = (LogicalSetOperator) input.getOp();
        List<ColumnRefOperator> outputs = lso.getOutputColumnRefOp();

        for (int idx = 0; idx < outputs.size(); ++idx) {
            for (int childIdx = 0; childIdx < input.arity(); ++childIdx) {
                requiredOutputColumns.union(lso.getChildOutputColumns().get(childIdx).get(idx));
            }
        }

        return Collections.emptyList();
    }
}
