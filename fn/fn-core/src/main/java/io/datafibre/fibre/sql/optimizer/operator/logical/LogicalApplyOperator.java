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

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import io.datafibre.fibre.sql.optimizer.ExpressionContext;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptExpressionVisitor;
import io.datafibre.fibre.sql.optimizer.RowOutputInfo;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefSet;
import io.datafibre.fibre.sql.optimizer.operator.ColumnOutputInfo;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ExistsPredicateOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.InPredicateOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.MultiInPredicateOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;

import java.util.List;

public class LogicalApplyOperator extends LogicalOperator {
    /**
     * Expressions that use sub-query.
     * Indicates which expressions apply is constructed from
     * <p>
     * x in (select y from t) will convert to
     * col-ref1 in col-ref2(project by inner plan output)
     */
    private ScalarOperator subqueryOperator;

    /**
     * output columnRef for subqueryOperator
     */
    private ColumnRefOperator output;

    /**
     * Correlation column which from outer table and used in the filter of sub-query(inner table)
     */
    private List<ColumnRefOperator> correlationColumnRefs;

    /**
     * Correlation conjuncts, will fill if this is a correlation subquery when push down ApplyNode to Filter
     */
    private ScalarOperator correlationConjuncts;

    /**
     * For scalar subquery, mark isn't need check subquery's return rows
     */
    private boolean needCheckMaxRows;

    /**
     * Mark the subquery can be cast to Semi/Anti-Join
     */
    private boolean useSemiAnti;

    private boolean needOutputRightChildColumns;

    /**
     * Record un-correlation subquery outer table column, use for push down apply node
     * e.g.
     * SQL: select * from t1 where t1.v1 > (....);
     * OuterPredicateColumns: t1.v1
     */
    private ColumnRefSet unCorrelationSubqueryPredicateColumns;

    private LogicalApplyOperator() {
        super(OperatorType.LOGICAL_APPLY);
    }

    public ColumnRefOperator getOutput() {
        return output;
    }

    public boolean isQuantified() {
        return subqueryOperator instanceof InPredicateOperator || subqueryOperator instanceof MultiInPredicateOperator;
    }

    public boolean isExistential() {
        return subqueryOperator instanceof ExistsPredicateOperator;
    }

    public boolean isScalar() {
        return !isQuantified() && !isExistential();
    }

    public ScalarOperator getSubqueryOperator() {
        return subqueryOperator;
    }

    public List<ColumnRefOperator> getCorrelationColumnRefs() {
        return correlationColumnRefs;
    }

    public ScalarOperator getCorrelationConjuncts() {
        return correlationConjuncts;
    }

    public boolean isNeedCheckMaxRows() {
        return needCheckMaxRows;
    }

    public boolean isUseSemiAnti() {
        return useSemiAnti;
    }

    public ColumnRefSet getUnCorrelationSubqueryPredicateColumns() {
        return unCorrelationSubqueryPredicateColumns;
    }

    @Override
    public ColumnRefSet getOutputColumns(ExpressionContext expressionContext) {
        ColumnRefSet outputColumns = expressionContext.getChildLogicalProperty(0).getOutputColumns().clone();
        if (needOutputRightChildColumns) {
            outputColumns.union(expressionContext.getChildLogicalProperty(1).getOutputColumns());
        } else if (output != null) {
            outputColumns.union(output);
        }
        return outputColumns;
    }

    @Override
    public RowOutputInfo deriveRowOutputInfo(List<OptExpression> inputs) {
        List<ColumnOutputInfo> entryList = Lists.newArrayList();
        for (ColumnOutputInfo entry : inputs.get(0).getRowOutputInfo().getColumnOutputInfo()) {
            entryList.add(new ColumnOutputInfo(entry.getColumnRef(), entry.getColumnRef()));
        }

        if (needOutputRightChildColumns) {
            for (ColumnOutputInfo entry : inputs.get(1).getRowOutputInfo().getColumnOutputInfo()) {
                entryList.add(new ColumnOutputInfo(entry.getColumnRef(), entry.getColumnRef()));
            }
        } else if (output != null) {
            entryList.add(new ColumnOutputInfo(output, output));
        }

        return new RowOutputInfo(entryList, Sets.newHashSet(output));
    }

    @Override
    public <R, C> R accept(OptExpressionVisitor<R, C> visitor, OptExpression optExpression, C context) {
        return visitor.visitLogicalApply(optExpression, context);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends LogicalOperator.Builder<LogicalApplyOperator, Builder> {
        @Override
        protected LogicalApplyOperator newInstance() {
            return new LogicalApplyOperator();
        }

        public Builder setSubqueryOperator(ScalarOperator subqueryOperator) {
            builder.subqueryOperator = subqueryOperator;
            return this;
        }

        public Builder setOutput(ColumnRefOperator output) {
            builder.output = output;
            return this;
        }

        public Builder setCorrelationColumnRefs(List<ColumnRefOperator> correlationColumnRefs) {
            builder.correlationColumnRefs = correlationColumnRefs;
            return this;
        }

        public Builder setCorrelationConjuncts(ScalarOperator correlationConjuncts) {
            builder.correlationConjuncts = correlationConjuncts;
            return this;
        }

        public Builder setNeedCheckMaxRows(boolean needCheckMaxRows) {
            builder.needCheckMaxRows = needCheckMaxRows;
            return this;
        }

        public Builder setUseSemiAnti(boolean useSemiAnti) {
            builder.useSemiAnti = useSemiAnti;
            return this;
        }

        public Builder setNeedOutputRightChildColumns(boolean needOutputRightChildColumns) {
            builder.needOutputRightChildColumns = needOutputRightChildColumns;
            return this;
        }

        public Builder setUnCorrelationSubqueryPredicateColumns(ColumnRefSet unCorrelationSubqueryPredicateColumns) {
            builder.unCorrelationSubqueryPredicateColumns = unCorrelationSubqueryPredicateColumns;
            return this;
        }

        @Override
        public Builder withOperator(LogicalApplyOperator applyOperator) {
            super.withOperator(applyOperator);
            builder.subqueryOperator = applyOperator.subqueryOperator;
            builder.output = applyOperator.output;
            builder.correlationColumnRefs = applyOperator.correlationColumnRefs;
            builder.correlationConjuncts = applyOperator.correlationConjuncts;
            builder.needCheckMaxRows = applyOperator.needCheckMaxRows;
            builder.useSemiAnti = applyOperator.useSemiAnti;
            builder.needOutputRightChildColumns = applyOperator.needOutputRightChildColumns;
            builder.unCorrelationSubqueryPredicateColumns = applyOperator.unCorrelationSubqueryPredicateColumns;
            return this;
        }
    }
}
