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
import io.datafibre.fibre.sql.optimizer.Utils;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalOperator;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalValuesOperator;
import io.datafibre.fibre.sql.optimizer.operator.pattern.Pattern;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ConstantOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;
import io.datafibre.fibre.sql.optimizer.rule.RuleType;

import java.util.List;

public class CastToEmptyRule extends TransformationRule {
    private static final ConstantOperator FALSE_OPERATOR = ConstantOperator.createBoolean(false);

    public CastToEmptyRule() {
        super(RuleType.TF_CAST_TO_EMPTY, Pattern.create(OperatorType.PATTERN_LEAF));
    }

    @Override
    public boolean check(OptExpression input, OptimizerContext context) {
        LogicalOperator lo = (LogicalOperator) input.getOp();
        for (ScalarOperator op : Utils.extractConjuncts(lo.getPredicate())) {
            if (!(op.isConstantRef())) {
                continue;
            }

            ConstantOperator predicate = (ConstantOperator) op;
            if (FALSE_OPERATOR.equals(predicate) || predicate.isNull()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<OptExpression> transform(OptExpression input, OptimizerContext context) {
        List<ColumnRefOperator> refs =
                input.getOutputColumns().getColumnRefOperators(context.getColumnRefFactory());
        return Lists.newArrayList(OptExpression.create(new LogicalValuesOperator(refs)));
    }
}
