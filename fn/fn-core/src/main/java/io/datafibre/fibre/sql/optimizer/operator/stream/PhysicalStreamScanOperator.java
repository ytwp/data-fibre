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

package io.datafibre.fibre.sql.optimizer.operator.stream;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptExpressionVisitor;
import io.datafibre.fibre.sql.optimizer.RowOutputInfo;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.OperatorVisitor;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalScanOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PhysicalStreamScanOperator extends PhysicalStreamOperator {

    protected final Table table;
    protected List<ColumnRefOperator> outputColumns;
    protected final ImmutableMap<ColumnRefOperator, Column> colRefToColumnMetaMap;

    public PhysicalStreamScanOperator(LogicalScanOperator scanOperator) {
        super(OperatorType.PHYSICAL_STREAM_SCAN);
        this.table = Objects.requireNonNull(scanOperator.getTable(), "table is null");
        this.colRefToColumnMetaMap = ImmutableMap.copyOf(scanOperator.getColRefToColumnMetaMap());
        this.predicate = scanOperator.getPredicate();
        this.projection = scanOperator.getProjection();
        if (this.projection != null) {
            outputColumns = projection.getOutputColumns();
        } else {
            outputColumns = ImmutableList.copyOf(colRefToColumnMetaMap.keySet());
        }
    }

    public List<ColumnRefOperator> getOutputColumns() {
        return outputColumns;
    }

    public Map<ColumnRefOperator, Column> getColRefToColumnMetaMap() {
        return colRefToColumnMetaMap;
    }

    public Table getTable() {
        return table;
    }

    @Override
    public RowOutputInfo deriveRowOutputInfo(List<OptExpression> inputs) {
        return new RowOutputInfo(colRefToColumnMetaMap.keySet().stream()
                .collect(Collectors.toMap(Function.identity(), Function.identity())));
    }

    @Override
    public <R, C> R accept(OperatorVisitor<R, C> visitor, C context) {
        return visitor.visitPhysicalStreamScan(this, context);
    }

    @Override
    public <R, C> R accept(OptExpressionVisitor<R, C> visitor, OptExpression optExpression, C context) {
        return visitor.visitPhysicalStreamScan(optExpression, context);
    }

    @Override
    public String toString() {
        return "PhysicalStreamScanOperator";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PhysicalStreamScanOperator that = (PhysicalStreamScanOperator) o;
        return Objects.equals(table, that.table) && Objects.equals(outputColumns, that.outputColumns) &&
                Objects.equals(colRefToColumnMetaMap, that.colRefToColumnMetaMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), table, outputColumns, colRefToColumnMetaMap);
    }
}
