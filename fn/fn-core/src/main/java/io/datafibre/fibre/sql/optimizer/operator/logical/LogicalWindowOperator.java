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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import io.datafibre.fibre.analysis.AnalyticWindow;
import io.datafibre.fibre.sql.optimizer.ExpressionContext;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptExpressionVisitor;
import io.datafibre.fibre.sql.optimizer.RowOutputInfo;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefSet;
import io.datafibre.fibre.sql.optimizer.base.Ordering;
import io.datafibre.fibre.sql.optimizer.operator.ColumnOutputInfo;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.OperatorVisitor;
import io.datafibre.fibre.sql.optimizer.operator.scalar.CallOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LogicalWindowOperator extends LogicalOperator {
    private ImmutableMap<ColumnRefOperator, CallOperator> windowCall;
    private ImmutableList<ScalarOperator> partitionExpressions;
    private ImmutableList<Ordering> orderByElements;
    private AnalyticWindow analyticWindow;
    /**
     * Each LogicalWindowOperator will belong to a SortGroup,
     * so we need to record sortProperty to ensure that only one SortNode is enforced
     */
    private ImmutableList<Ordering> enforceSortColumns;

    /**
     * For window functions with only partition by column but without order by column,
     * we can perform hash-based partition according to hint.
     */
    private boolean useHashBasedPartition;
    private boolean isSkewed;

    private LogicalWindowOperator() {
        super(OperatorType.LOGICAL_WINDOW);
        this.partitionExpressions = ImmutableList.of();
        this.orderByElements = ImmutableList.of();
        this.enforceSortColumns = ImmutableList.of();
        this.useHashBasedPartition = false;
        this.isSkewed = false;
    }

    public Map<ColumnRefOperator, CallOperator> getWindowCall() {
        return windowCall;
    }

    public List<ScalarOperator> getPartitionExpressions() {
        return partitionExpressions;
    }

    public List<Ordering> getOrderByElements() {
        return orderByElements;
    }

    public AnalyticWindow getAnalyticWindow() {
        return analyticWindow;
    }

    public List<Ordering> getEnforceSortColumns() {
        return enforceSortColumns;
    }

    public boolean isUseHashBasedPartition() {
        return useHashBasedPartition;
    }

    public boolean isSkewed() {
        return isSkewed;
    }

    @Override
    public ColumnRefSet getOutputColumns(ExpressionContext expressionContext) {
        if (projection != null) {
            return new ColumnRefSet(new ArrayList<>(projection.getColumnRefMap().keySet()));
        } else {
            ColumnRefSet columns = new ColumnRefSet();
            columns.union(new ArrayList<>(windowCall.keySet()));
            columns.union(expressionContext.getChildLogicalProperty(0).getOutputColumns());
            return columns;
        }
    }

    @Override
    public RowOutputInfo deriveRowOutputInfo(List<OptExpression> inputs) {
        List<ColumnOutputInfo> columnOutputInfoList = Lists.newArrayList();
        for (Map.Entry<ColumnRefOperator, CallOperator> entry : windowCall.entrySet()) {
            columnOutputInfoList.add(new ColumnOutputInfo(entry.getKey(), entry.getValue()));
        }
        for (ColumnOutputInfo entry : inputs.get(0).getRowOutputInfo().getColumnOutputInfo()) {
            columnOutputInfoList.add(new ColumnOutputInfo(entry.getColumnRef(), entry.getColumnRef()));
        }
        return new RowOutputInfo(columnOutputInfoList);
    }

    @Override
    public <R, C> R accept(OperatorVisitor<R, C> visitor, C context) {
        return visitor.visitLogicalAnalytic(this, context);
    }

    @Override
    public <R, C> R accept(OptExpressionVisitor<R, C> visitor, OptExpression optExpression, C context) {
        return visitor.visitLogicalWindow(optExpression, context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!super.equals(o)) {
            return false;
        }

        LogicalWindowOperator that = (LogicalWindowOperator) o;
        return Objects.equals(windowCall, that.windowCall)
                && Objects.equals(partitionExpressions, that.partitionExpressions)
                && Objects.equals(orderByElements, that.orderByElements)
                && Objects.equals(analyticWindow, that.analyticWindow)
                && Objects.equals(useHashBasedPartition, that.useHashBasedPartition)
                && Objects.equals(isSkewed, that.isSkewed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), windowCall, partitionExpressions, orderByElements, analyticWindow,
                useHashBasedPartition, isSkewed);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends LogicalOperator.Builder<LogicalWindowOperator, Builder> {
        @Override
        protected LogicalWindowOperator newInstance() {
            return new LogicalWindowOperator();
        }

        @Override
        public Builder withOperator(LogicalWindowOperator windowOperator) {
            super.withOperator(windowOperator);

            builder.windowCall = windowOperator.windowCall;
            builder.partitionExpressions = windowOperator.partitionExpressions;
            builder.orderByElements = windowOperator.orderByElements;
            builder.analyticWindow = windowOperator.analyticWindow;
            builder.enforceSortColumns = windowOperator.enforceSortColumns;
            builder.useHashBasedPartition = windowOperator.useHashBasedPartition;
            builder.isSkewed = windowOperator.isSkewed;
            return this;
        }

        public Builder setWindowCall(Map<ColumnRefOperator, CallOperator> windowCall) {
            builder.windowCall = ImmutableMap.copyOf(windowCall);
            return this;
        }

        public Builder setPartitionExpressions(List<ScalarOperator> partitionExpressions) {
            builder.partitionExpressions = ImmutableList.copyOf(partitionExpressions);
            return this;
        }

        public Builder setOrderByElements(List<Ordering> orderByElements) {
            builder.orderByElements = ImmutableList.copyOf(orderByElements);
            return this;
        }

        public Builder setAnalyticWindow(AnalyticWindow analyticWindow) {
            builder.analyticWindow = analyticWindow;
            return this;
        }

        public Builder setEnforceSortColumns(List<Ordering> enforceSortColumns) {
            builder.enforceSortColumns = ImmutableList.copyOf(enforceSortColumns);
            return this;
        }

        public Builder setUseHashBasedPartition(boolean useHashBasedPartition) {
            builder.useHashBasedPartition = useHashBasedPartition;
            return this;
        }

        public Builder setIsSkewed(boolean isSkewed) {
            builder.isSkewed = isSkewed;
            return this;
        }
    }
}
