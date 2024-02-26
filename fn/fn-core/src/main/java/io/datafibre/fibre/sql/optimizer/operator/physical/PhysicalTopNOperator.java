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

package io.datafibre.fibre.sql.optimizer.operator.physical;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptExpressionVisitor;
import io.datafibre.fibre.sql.optimizer.RowOutputInfo;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefSet;
import io.datafibre.fibre.sql.optimizer.base.OrderSpec;
import io.datafibre.fibre.sql.optimizer.base.Ordering;
import io.datafibre.fibre.sql.optimizer.operator.ColumnOutputInfo;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.OperatorVisitor;
import io.datafibre.fibre.sql.optimizer.operator.Projection;
import io.datafibre.fibre.sql.optimizer.operator.SortPhase;
import io.datafibre.fibre.sql.optimizer.operator.TopNType;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PhysicalTopNOperator extends PhysicalOperator {
    private long offset;
    private List<ColumnRefOperator> partitionByColumns;
    private long partitionLimit;
    private SortPhase sortPhase;
    private TopNType topNType;
    private boolean isSplit;
    private boolean isEnforced;

    private PhysicalTopNOperator() {
        super(OperatorType.PHYSICAL_TOPN);
    }

    // If limit is -1, means global sort
    public PhysicalTopNOperator(OrderSpec spec, long limit, long offset,
                                List<ColumnRefOperator> partitionByColumns,
                                long partitionLimit,
                                SortPhase sortPhase,
                                TopNType topNType,
                                boolean isSplit,
                                boolean isEnforced,
                                ScalarOperator predicate,
                                Projection projection) {
        super(OperatorType.PHYSICAL_TOPN, spec);
        this.limit = limit;
        this.offset = offset;
        this.partitionByColumns = partitionByColumns;
        this.partitionLimit = partitionLimit;
        this.sortPhase = sortPhase;
        this.topNType = topNType;
        this.isSplit = isSplit;
        this.isEnforced = isEnforced;
        this.predicate = predicate;
        this.projection = projection;
    }

    public List<ColumnRefOperator> getPartitionByColumns() {
        return partitionByColumns;
    }

    public long getPartitionLimit() {
        return partitionLimit;
    }

    public SortPhase getSortPhase() {
        return sortPhase;
    }

    public TopNType getTopNType() {
        return topNType;
    }

    public boolean isSplit() {
        return isSplit;
    }

    public long getOffset() {
        return offset;
    }

    public boolean isEnforced() {
        return isEnforced;
    }

    @Override
    public RowOutputInfo deriveRowOutputInfo(List<OptExpression> inputs) {
        List<ColumnOutputInfo> entryList = Lists.newArrayList();
        for (ColumnOutputInfo entry : inputs.get(0).getRowOutputInfo().getColumnOutputInfo()) {
            entryList.add(new ColumnOutputInfo(entry.getColumnRef(), entry.getColumnRef()));
        }
        for (Ordering ordering : orderSpec.getOrderDescs()) {
            entryList.add(new ColumnOutputInfo(ordering.getColumnRef(), ordering.getColumnRef()));
        }
        return new RowOutputInfo(entryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderSpec, offset, sortPhase, topNType, isSplit, isEnforced);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!super.equals(o)) {
            return false;
        }

        PhysicalTopNOperator that = (PhysicalTopNOperator) o;

        return partitionLimit == that.partitionLimit && offset == that.offset && isSplit == that.isSplit &&
                Objects.equals(partitionByColumns, that.partitionByColumns) &&
                Objects.equals(orderSpec, that.orderSpec) &&
                sortPhase == that.sortPhase && topNType == that.topNType && isEnforced == that.isEnforced;
    }

    @Override
    public <R, C> R accept(OperatorVisitor<R, C> visitor, C context) {
        return visitor.visitPhysicalTopN(this, context);
    }

    @Override
    public <R, C> R accept(OptExpressionVisitor<R, C> visitor, OptExpression optExpression, C context) {
        return visitor.visitPhysicalTopN(optExpression, context);
    }

    public void fillDisableDictOptimizeColumns(ColumnRefSet resultSet, Set<Integer> dictColIds) {
        // nothing to do
    }

    public boolean couldApplyStringDict(Set<Integer> childDictColumns) {
        Preconditions.checkState(!childDictColumns.isEmpty());
        ColumnRefSet dictSet = ColumnRefSet.createByIds(childDictColumns);

        for (Ordering orderDesc : orderSpec.getOrderDescs()) {
            if (orderDesc.getColumnRef().getUsedColumns().isIntersect(dictSet)) {
                return true;
            }
        }

        return false;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends PhysicalOperator.Builder<PhysicalTopNOperator, Builder> {
        @Override
        protected PhysicalTopNOperator newInstance() {
            return new PhysicalTopNOperator();
        }

        @Override
        public Builder withOperator(PhysicalTopNOperator operator) {
            super.withOperator(operator);
            builder.offset = operator.offset;
            builder.partitionByColumns = operator.partitionByColumns;
            builder.partitionLimit = operator.partitionLimit;
            builder.sortPhase = operator.sortPhase;
            builder.topNType = operator.topNType;
            builder.isSplit = operator.isSplit;
            builder.isEnforced = operator.isEnforced;
            return this;
        }

        public Builder setPartitionByColumns(
                List<ColumnRefOperator> partitionByColumns) {
            builder.partitionByColumns = partitionByColumns;
            return this;
        }
    }
}
