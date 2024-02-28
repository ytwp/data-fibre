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
import com.google.common.collect.Lists;
import io.datafibre.fibre.analysis.JoinOperator;
import io.datafibre.fibre.sql.optimizer.ExpressionContext;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptExpressionVisitor;
import io.datafibre.fibre.sql.optimizer.RowOutputInfo;
import io.datafibre.fibre.sql.optimizer.Utils;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefFactory;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefSet;
import io.datafibre.fibre.sql.optimizer.operator.ColumnOutputInfo;
import io.datafibre.fibre.sql.optimizer.operator.Operator;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.OperatorVisitor;
import io.datafibre.fibre.sql.optimizer.operator.Projection;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LogicalJoinOperator extends LogicalOperator {
    private JoinOperator joinType;
    private ScalarOperator onPredicate;
    private String joinHint;
    private ScalarOperator skewColumn;
    private List<ScalarOperator> skewValues;
    // For mark the node has been push down join on clause, avoid dead-loop
    private boolean hasPushDownJoinOnClause = false;
    private boolean hasDeriveIsNotNullPredicate = false;

    // NOTE: we keep the original onPredicate for MV's rewrite to distinguish on-predicates and
    // where-predicates. Take care to pass through original on-predicates when creating a new JoinOperator.
    private ScalarOperator originalOnPredicate;

    private int transformMask;

    public LogicalJoinOperator(JoinOperator joinType, ScalarOperator onPredicate) {
        this(joinType, onPredicate, "", Operator.DEFAULT_LIMIT, null, false, onPredicate);
    }

    public LogicalJoinOperator(JoinOperator joinType, ScalarOperator onPredicate, String joinHint) {
        this(joinType, onPredicate, joinHint, Operator.DEFAULT_LIMIT, null, false, onPredicate);
    }

    private LogicalJoinOperator(JoinOperator joinType, ScalarOperator onPredicate, String joinHint,
                                long limit, ScalarOperator predicate,
                                boolean hasPushDownJoinOnClause,
                                ScalarOperator originalOnPredicate) {
        super(OperatorType.LOGICAL_JOIN, limit, predicate, null);
        this.joinType = joinType;
        this.onPredicate = onPredicate;
        Preconditions.checkNotNull(joinHint);
        this.joinHint = StringUtils.upperCase(joinHint);

        this.hasPushDownJoinOnClause = hasPushDownJoinOnClause;
        this.hasDeriveIsNotNullPredicate = false;
        this.originalOnPredicate = originalOnPredicate;
    }

    public LogicalJoinOperator() {
        super(OperatorType.LOGICAL_JOIN);
        this.onPredicate = null;
        this.joinType = JoinOperator.INNER_JOIN;
        this.joinHint = "";
        this.originalOnPredicate = null;
    }

    public boolean hasPushDownJoinOnClause() {
        return hasPushDownJoinOnClause;
    }

    public void setHasPushDownJoinOnClause(boolean hasPushDownJoinOnClause) {
        this.hasPushDownJoinOnClause = hasPushDownJoinOnClause;
    }

    public boolean hasDeriveIsNotNullPredicate() {
        return hasDeriveIsNotNullPredicate;
    }

    public void setHasDeriveIsNotNullPredicate(boolean hasDeriveIsNotNullPredicate) {
        this.hasDeriveIsNotNullPredicate = hasDeriveIsNotNullPredicate;
    }

    public JoinOperator getJoinType() {
        return joinType;
    }

    public boolean isInnerOrCrossJoin() {
        return joinType.isInnerJoin() || joinType.isCrossJoin();
    }

    public ScalarOperator getOnPredicate() {
        return onPredicate;
    }

    public ScalarOperator getOriginalOnPredicate() {
        if (originalOnPredicate != null) {
            return originalOnPredicate;
        }
        // `onPredicate` maybe null first, but set by `setOnPredicate` later.
        return onPredicate;
    }

    public String getJoinHint() {
        return joinHint;
    }

    public ScalarOperator getSkewColumn() {
        return skewColumn;
    }
    public List<ScalarOperator> getSkewValues() {
        return skewValues;
    }

    public int getTransformMask() {
        return transformMask;
    }

    public ColumnRefSet getRequiredChildInputColumns() {
        ColumnRefSet result = new ColumnRefSet();
        if (onPredicate != null) {
            result.union(onPredicate.getUsedColumns());
        }
        if (predicate != null) {
            result.union(predicate.getUsedColumns());
        }

        if (projection != null) {
            projection.getColumnRefMap().values().forEach(s -> result.union(s.getUsedColumns()));
            result.except(new ColumnRefSet(new ArrayList<>(projection.getCommonSubOperatorMap().keySet())));
            projection.getCommonSubOperatorMap().values().forEach(s -> result.union(s.getUsedColumns()));
        }
        return result;
    }

    @Override
    public ColumnRefOperator getSmallestColumn(ColumnRefSet required, ColumnRefFactory columnRefFactory,
                                               OptExpression expr) {
        ColumnRefSet candidate;
        if (joinType.isLeftSemiAntiJoin()) {
            candidate = expr.getChildOutputColumns(0);
        } else if (joinType.isRightSemiAntiJoin()) {
            candidate = expr.getChildOutputColumns(1);
        } else {
            candidate = getOutputColumns(new ExpressionContext(expr));
        }
        if (required != null) {
            candidate.intersect(required);
        }
        return Utils.findSmallestColumnRef(
                candidate.getStream().map(columnRefFactory::getColumnRef).collect(Collectors.toList()));
    }

    @Override
    public ColumnRefSet getOutputColumns(ExpressionContext expressionContext) {
        if (projection != null) {
            return new ColumnRefSet(projection.getOutputColumns());
        } else {
            ColumnRefSet columns = new ColumnRefSet();
            for (int i = 0; i < expressionContext.arity(); ++i) {
                columns.union(expressionContext.getChildLogicalProperty(i).getOutputColumns());
            }
            return columns;
        }
    }

    @Override
    public RowOutputInfo deriveRowOutputInfo(List<OptExpression> inputs) {
        List<ColumnOutputInfo> entryList = Lists.newArrayList();
        for (OptExpression input : inputs) {
            for (ColumnOutputInfo entry : input.getRowOutputInfo().getColumnOutputInfo()) {
                entryList.add(new ColumnOutputInfo(entry.getColumnRef(), entry.getColumnRef()));
            }
        }
        return new RowOutputInfo(entryList);
    }

    @Override
    public <R, C> R accept(OperatorVisitor<R, C> visitor, C context) {
        return visitor.visitLogicalJoin(this, context);
    }

    @Override
    public <R, C> R accept(OptExpressionVisitor<R, C> visitor, OptExpression optExpression, C context) {
        return visitor.visitLogicalJoin(optExpression, context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!super.equals(o)) {
            return false;
        }

        LogicalJoinOperator rhs = (LogicalJoinOperator) o;

        return joinType == rhs.joinType && Objects.equals(onPredicate, rhs.onPredicate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), joinType, onPredicate);
    }

    @Override
    public String toString() {
        return "LOGICAL_JOIN" + " {" +
                joinType.toString() +
                ", onPredicate = " + onPredicate + ' ' +
                ", Predicate = " + predicate +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends LogicalOperator.Builder<LogicalJoinOperator, LogicalJoinOperator.Builder> {

        @Override
        protected LogicalJoinOperator newInstance() {
            return new LogicalJoinOperator();
        }

        @Override
        public LogicalJoinOperator.Builder withOperator(LogicalJoinOperator joinOperator) {
            super.withOperator(joinOperator);
            builder.joinType = joinOperator.joinType;
            builder.onPredicate = joinOperator.onPredicate;
            builder.joinHint = joinOperator.joinHint;
            builder.skewColumn = joinOperator.skewColumn;
            builder.skewValues = joinOperator.skewValues;
            builder.hasPushDownJoinOnClause = joinOperator.hasPushDownJoinOnClause;
            builder.hasDeriveIsNotNullPredicate = joinOperator.hasDeriveIsNotNullPredicate;
            builder.originalOnPredicate = joinOperator.originalOnPredicate;
            return this;
        }

        public Builder setJoinType(JoinOperator joinType) {
            builder.joinType = joinType;
            return this;
        }

        public Builder setOnPredicate(ScalarOperator onPredicate) {
            builder.onPredicate = onPredicate;
            return this;
        }

        public Builder setProjection(Projection projection) {
            builder.projection = projection;
            return this;
        }

        public Builder setJoinHint(String joinHint) {
            builder.joinHint = joinHint;
            return this;
        }

        public Builder setSkewColumn(ScalarOperator column) {
            builder.skewColumn = column;
            return this;
        }

        public Builder setSkewValues(List<ScalarOperator> values) {
            builder.skewValues = values;
            return this;
        }

        public Builder setOriginalOnPredicate(ScalarOperator originalOnPredicate) {
            builder.originalOnPredicate = originalOnPredicate;
            return this;
        }

        public Builder setTransformMask(int mask) {
            builder.transformMask = mask;
            return this;
        }
    }
}
