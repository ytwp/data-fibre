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


package io.datafibre.fibre.sql.optimizer.rule.implementation;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptimizerContext;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalProjectOperator;
import io.datafibre.fibre.sql.optimizer.operator.pattern.Pattern;
import io.datafibre.fibre.sql.optimizer.operator.physical.PhysicalProjectOperator;
import io.datafibre.fibre.sql.optimizer.rule.RuleType;

import java.util.List;

public class ProjectImplementationRule extends ImplementationRule {
    public ProjectImplementationRule() {
        super(RuleType.IMP_PROJECT,
                Pattern.create(OperatorType.LOGICAL_PROJECT, OperatorType.PATTERN_LEAF));
    }

    @Override
    public List<OptExpression> transform(OptExpression input, OptimizerContext context) {
        LogicalProjectOperator projectOperator = (LogicalProjectOperator) input.getOp();
        PhysicalProjectOperator physicalProject = new PhysicalProjectOperator(
                projectOperator.getColumnRefMap(),
                Maps.newHashMap());
        return Lists.newArrayList(OptExpression.create(physicalProject, input.getInputs()));
    }
}
