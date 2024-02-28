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

package io.datafibre.fibre.sql.optimizer.base;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.datafibre.fibre.analysis.CaseExpr;
import io.datafibre.fibre.analysis.CastExpr;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.FunctionCallExpr;
import io.datafibre.fibre.analysis.SlotRef;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.sql.optimizer.operator.scalar.CallOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.CaseWhenOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.CastOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ColumnRefFactory {
    private int nextId = 1;
    // The unique id for each scan operator
    // For table a join table a, the two unique ids for table a is different
    private int nextRelationId = 1;
    private final List<ColumnRefOperator> columnRefs = Lists.newArrayList();
    private final Map<Integer, Integer> columnToRelationIds = Maps.newHashMap();
    private final Map<ColumnRefOperator, Column> columnRefToColumns = Maps.newHashMap();
    private final Map<ColumnRefOperator, Table> columnRefToTable = Maps.newHashMap();

    public Map<ColumnRefOperator, Column> getColumnRefToColumns() {
        return columnRefToColumns;
    }

    public ColumnRefOperator create(Expr expression, Type type, boolean nullable) {
        String nameHint = "expr";
        if (expression instanceof SlotRef) {
            nameHint = ((SlotRef) expression).getColumnName();
        } else if (expression instanceof FunctionCallExpr) {
            nameHint = ((FunctionCallExpr) expression).getFnName().toString();
        } else if (expression instanceof CaseExpr) {
            nameHint = "case";
        } else if (expression instanceof CastExpr) {
            nameHint = "cast";
        }
        return create(nextId++, nameHint, type, nullable, false);
    }

    public ColumnRefOperator create(ScalarOperator operator, Type type, boolean nullable) {
        String nameHint = "expr";
        if (operator.isColumnRef()) {
            nameHint = ((ColumnRefOperator) operator).getName();
        } else if (operator instanceof CallOperator) {
            if (operator instanceof CaseWhenOperator) {
                nameHint = "case";
            } else if (operator instanceof CastOperator) {
                nameHint = "cast";
            } else {
                nameHint = ((CallOperator) operator).getFnName();
            }
        }
        return create(nextId++, nameHint, type, nullable, false);
    }

    public ColumnRefOperator create(String name, Type type, boolean nullable) {
        return create(nextId++, name, type, nullable, false);
    }

    public ColumnRefOperator create(String name, Type type, boolean nullable, boolean isLambdaArg) {
        return create(nextId++, name, type, nullable, isLambdaArg);
    }

    private ColumnRefOperator create(int id, String name, Type type, boolean nullable, boolean isLambdaArg) {
        ColumnRefOperator columnRef = new ColumnRefOperator(id, type, name, nullable, isLambdaArg);
        columnRefs.add(columnRef);
        return columnRef;
    }

    public ColumnRefOperator getColumnRef(int id) {
        return columnRefs.get(id - 1);
    }

    public Set<ColumnRefOperator> getColumnRefs(ColumnRefSet columnRefSet) {
        Set<ColumnRefOperator> columnRefOperators = Sets.newHashSet();
        for (int idx : columnRefSet.getColumnIds()) {
            columnRefOperators.add(getColumnRef(idx));
        }
        return columnRefOperators;
    }

    public List<ColumnRefOperator> getColumnRefs() {
        return columnRefs;
    }

    public void updateColumnRefToColumns(ColumnRefOperator columnRef, Column column, Table table) {
        columnRefToColumns.put(columnRef, column);
        columnRefToTable.put(columnRef, table);
    }

    public Column getColumn(ColumnRefOperator columnRef) {
        return columnRefToColumns.get(columnRef);
    }

    public void updateColumnToRelationIds(int columnId, int tableId) {
        columnToRelationIds.put(columnId, tableId);
    }

    public Integer getRelationId(int id) {
        return columnToRelationIds.getOrDefault(id, -1);
    }

    public int getNextRelationId() {
        return nextRelationId++;
    }

    public Map<Integer, Integer> getColumnToRelationIds() {
        return columnToRelationIds;
    }

    public Map<ColumnRefOperator, Table> getColumnRefToTable() {
        return columnRefToTable;
    }

    public Table getTableForColumn(int columnId) {
        return columnRefToTable.get(getColumnRef(columnId));
    }
}
