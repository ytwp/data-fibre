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
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptimizerContext;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalTableFunctionTableScanOperator;
import io.datafibre.fibre.sql.optimizer.operator.pattern.Pattern;
import io.datafibre.fibre.sql.optimizer.operator.physical.PhysicalTableFunctionTableScanOperator;
import io.datafibre.fibre.sql.optimizer.rule.RuleType;

import java.util.List;

public class TableFunctionTableScanImplementationRule extends ImplementationRule {
    public TableFunctionTableScanImplementationRule() {
        super(RuleType.IMP_TABLE_FUNCTION_TABLE_LSCAN_TO_PSCAN,
                Pattern.create(OperatorType.LOGICAL_TABLE_FUNCTION_TABLE_SCAN));
    }

    @Override
    public List<OptExpression> transform(OptExpression input, OptimizerContext context) {
        OptExpression result = null;
        LogicalTableFunctionTableScanOperator logicalScanOperator = (LogicalTableFunctionTableScanOperator) input.getOp();
        if (logicalScanOperator.getTable().getType() == Table.TableType.TABLE_FUNCTION) {
            PhysicalTableFunctionTableScanOperator physicalScanOperator = new PhysicalTableFunctionTableScanOperator(
                    logicalScanOperator.getTable(),
                    logicalScanOperator.getColRefToColumnMetaMap(),
                    logicalScanOperator.getScanOperatorPredicates(),
                    logicalScanOperator.getLimit(),
                    logicalScanOperator.getPredicate(),
                    logicalScanOperator.getProjection());

            result = new OptExpression(physicalScanOperator);
        }
        return Lists.newArrayList(result);
    }
}
