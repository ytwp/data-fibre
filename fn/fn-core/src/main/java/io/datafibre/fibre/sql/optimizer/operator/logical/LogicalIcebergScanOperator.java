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
import io.datafibre.fibre.catalog.IcebergTable;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.OperatorVisitor;
import io.datafibre.fibre.sql.optimizer.operator.ScanOperatorPredicates;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;

import java.util.Map;
import java.util.stream.Collectors;

public class LogicalIcebergScanOperator extends LogicalScanOperator {
    private ScanOperatorPredicates predicates = new ScanOperatorPredicates();

    private boolean hasUnknownColumn = true;

    public LogicalIcebergScanOperator(Table table,
                                      Map<ColumnRefOperator, Column> colRefToColumnMetaMap,
                                      Map<Column, ColumnRefOperator> columnMetaToColRefMap,
                                      long limit,
                                      ScalarOperator predicate) {
        super(OperatorType.LOGICAL_ICEBERG_SCAN,
                table,
                colRefToColumnMetaMap,
                columnMetaToColRefMap,
                limit,
                predicate, null);

        Preconditions.checkState(table instanceof IcebergTable);
        IcebergTable icebergTable = (IcebergTable) table;
        partitionColumns.addAll(icebergTable.getPartitionColumns().stream().map(x -> x.getName()).collect(Collectors.toList()));
    }

    private LogicalIcebergScanOperator() {
        super(OperatorType.LOGICAL_ICEBERG_SCAN);
    }

    @Override
    public ScanOperatorPredicates getScanOperatorPredicates() {
        return this.predicates;
    }

    @Override
    public void setScanOperatorPredicates(ScanOperatorPredicates predicates) {
        this.predicates = predicates;
    }

    @Override
    public boolean isEmptyOutputRows() {
        return !table.isUnPartitioned() &&
                !(((IcebergTable) table).hasPartitionTransformedEvolution()) &&
                predicates.getSelectedPartitionIds().isEmpty();
    }

    public boolean hasUnknownColumn() {
        return hasUnknownColumn;
    }

    public void setHasUnknownColumn(boolean hasUnknownColumn) {
        this.hasUnknownColumn = hasUnknownColumn;
    }

    @Override
    public <R, C> R accept(OperatorVisitor<R, C> visitor, C context) {
        return visitor.visitLogicalIcebergScan(this, context);
    }

    public static class Builder
            extends LogicalScanOperator.Builder<LogicalIcebergScanOperator, Builder> {

        @Override
        protected LogicalIcebergScanOperator newInstance() {
            return new LogicalIcebergScanOperator();
        }

        @Override
        public Builder withOperator(LogicalIcebergScanOperator scanOperator) {
            super.withOperator(scanOperator);

            builder.predicates = scanOperator.predicates.clone();
            return this;
        }
    }
}
