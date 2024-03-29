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

import com.google.common.collect.Lists;
import io.datafibre.fibre.analysis.AnalyticWindow;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptExpressionVisitor;
import io.datafibre.fibre.sql.optimizer.RowOutputInfo;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefSet;
import io.datafibre.fibre.sql.optimizer.base.Ordering;
import io.datafibre.fibre.sql.optimizer.operator.ColumnOutputInfo;
import io.datafibre.fibre.sql.optimizer.operator.OperatorVisitor;
import io.datafibre.fibre.sql.optimizer.operator.Projection;
import io.datafibre.fibre.sql.optimizer.operator.scalar.CallOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.datafibre.fibre.sql.optimizer.operator.OperatorType.PHYSICAL_WINDOW;

public class PhysicalWindowOperator extends PhysicalOperator {
    private final Map<ColumnRefOperator, CallOperator> analyticCall;
    private final List<ScalarOperator> partitionExpressions;
    private final List<Ordering> orderByElements;
    private final AnalyticWindow analyticWindow;
    private final List<Ordering> enforceOrderBy;
    private final boolean useHashBasedPartition;
    private final boolean isSkewed;

    public PhysicalWindowOperator(Map<ColumnRefOperator, CallOperator> analyticCall,
                                  List<ScalarOperator> partitionExpressions,
                                  List<Ordering> orderByElements,
                                  AnalyticWindow analyticWindow,
                                  List<Ordering> enforceOrderBy,
                                  boolean useHashBasedPartition,
                                  boolean isSkewed,
                                  long limit,
                                  ScalarOperator predicate,
                                  Projection projection) {
        super(PHYSICAL_WINDOW);
        this.analyticCall = analyticCall;
        this.partitionExpressions = partitionExpressions;
        this.orderByElements = orderByElements;
        this.analyticWindow = analyticWindow;
        this.enforceOrderBy = enforceOrderBy;
        this.useHashBasedPartition = useHashBasedPartition;
        this.isSkewed = isSkewed;
        this.limit = limit;
        this.predicate = predicate;
        this.projection = projection;
    }

    public Map<ColumnRefOperator, CallOperator> getAnalyticCall() {
        return analyticCall;
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

    public List<Ordering> getEnforceOrderBy() {
        return enforceOrderBy;
    }

    public boolean isUseHashBasedPartition() {
        return useHashBasedPartition;
    }

    public boolean isSkewed() {
        return isSkewed;
    }

    @Override
    public RowOutputInfo deriveRowOutputInfo(List<OptExpression> inputs) {
        List<ColumnOutputInfo> columnOutputInfoList = Lists.newArrayList();
        for (Map.Entry<ColumnRefOperator, CallOperator> entry : analyticCall.entrySet()) {
            columnOutputInfoList.add(new ColumnOutputInfo(entry.getKey(), entry.getValue()));
        }
        for (ColumnOutputInfo entry : inputs.get(0).getRowOutputInfo().getColumnOutputInfo()) {
            columnOutputInfoList.add(new ColumnOutputInfo(entry.getColumnRef(), entry.getColumnRef()));
        }
        return new RowOutputInfo(columnOutputInfoList);
    }

    @Override
    public <R, C> R accept(OperatorVisitor<R, C> visitor, C context) {
        return visitor.visitPhysicalAnalytic(this, context);
    }

    @Override
    public <R, C> R accept(OptExpressionVisitor<R, C> visitor, OptExpression optExpression, C context) {
        return visitor.visitPhysicalAnalytic(optExpression, context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!super.equals(o)) {
            return false;
        }

        PhysicalWindowOperator that = (PhysicalWindowOperator) o;
        return Objects.equals(analyticCall, that.analyticCall) &&
                Objects.equals(partitionExpressions, that.partitionExpressions) &&
                Objects.equals(orderByElements, that.orderByElements) &&
                Objects.equals(analyticWindow, that.analyticWindow) &&
                Objects.equals(useHashBasedPartition, that.useHashBasedPartition) &&
                Objects.equals(isSkewed, that.isSkewed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), analyticCall, partitionExpressions, orderByElements, analyticWindow,
                useHashBasedPartition, isSkewed);
    }

    @Override
    public ColumnRefSet getUsedColumns() {
        ColumnRefSet set = super.getUsedColumns();
        analyticCall.values().forEach(d -> set.union(d.getUsedColumns()));
        partitionExpressions.forEach(d -> set.union(d.getUsedColumns()));
        orderByElements.forEach(o -> set.union(o.getColumnRef()));
        return set;
    }
}
