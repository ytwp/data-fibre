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

package io.datafibre.fibre.sql.optimizer.operator.logical;

import com.google.common.base.Preconditions;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.HiveTable;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.OperatorVisitor;
import io.datafibre.fibre.sql.optimizer.operator.ScanOperatorPredicates;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;

import java.util.Map;

public class LogicalHiveScanOperator extends LogicalScanOperator {
    private ScanOperatorPredicates predicates = new ScanOperatorPredicates();
    private boolean hasUnknownColumn;

    public LogicalHiveScanOperator(Table table,
                                   Map<ColumnRefOperator, Column> colRefToColumnMetaMap,
                                   Map<Column, ColumnRefOperator> columnMetaToColRefMap,
                                   long limit,
                                   ScalarOperator predicate) {
        super(OperatorType.LOGICAL_HIVE_SCAN,
                table,
                colRefToColumnMetaMap,
                columnMetaToColRefMap,
                limit,
                predicate, null);

        Preconditions.checkState(table instanceof HiveTable);
        HiveTable hiveTable = (HiveTable) table;
        partitionColumns.addAll(hiveTable.getPartitionColumnNames());
    }

    private LogicalHiveScanOperator() {
        super(OperatorType.LOGICAL_HIVE_SCAN);
    }

    @Override
    public ScanOperatorPredicates getScanOperatorPredicates() {
        return this.predicates;
    }

    @Override
    public void setScanOperatorPredicates(ScanOperatorPredicates predicates) {
        this.predicates = predicates;
    }

    public boolean hasUnknownColumn() {
        return hasUnknownColumn;
    }

    public void setHasUnknownColumn(boolean hasUnknownColumn) {
        this.hasUnknownColumn = hasUnknownColumn;
    }

    public boolean isEmptyOutputRows() {
        return !table.isUnPartitioned() && predicates.getSelectedPartitionIds().isEmpty();
    }

    @Override
    public <R, C> R accept(OperatorVisitor<R, C> visitor, C context) {
        return visitor.visitLogicalHiveScan(this, context);
    }

    public static class Builder
            extends LogicalScanOperator.Builder<LogicalHiveScanOperator, LogicalHiveScanOperator.Builder> {

        @Override
        protected LogicalHiveScanOperator newInstance() {
            return new LogicalHiveScanOperator();
        }

        @Override
        public LogicalHiveScanOperator.Builder withOperator(LogicalHiveScanOperator scanOperator) {
            super.withOperator(scanOperator);

            builder.predicates = scanOperator.predicates.clone();
            builder.partitionColumns = scanOperator.partitionColumns;
            return this;
        }
    }
}
