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


package io.datafibre.fibre.sql.ast;

import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.ExprSubstitutionMap;
import io.datafibre.fibre.analysis.SlotRef;
import io.datafibre.fibre.analysis.TableName;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.ScalarType;
import io.datafibre.fibre.catalog.system.information.InfoSchemaDb;
import io.datafibre.fibre.qe.ShowResultSetMetaData;
import io.datafibre.fibre.sql.parser.NodePosition;

// Show database statement.
public class ShowDbStmt extends ShowStmt {
    private static final TableName TABLE_NAME = new TableName(InfoSchemaDb.DATABASE_NAME, "schemata");
    private static final String DB_COL = "Database";
    private static final ShowResultSetMetaData META_DATA =
            ShowResultSetMetaData.builder()
                    .addColumn(new Column(DB_COL, ScalarType.createVarchar(20)))
                    .build();
    private final String pattern;
    private Expr where;

    private String catalogName;

    public ShowDbStmt(String pattern) {
        this(pattern, null, null, NodePosition.ZERO);
    }

    public ShowDbStmt(String pattern, Expr where) {
        this(pattern, where, null, NodePosition.ZERO);
    }

    public ShowDbStmt(String pattern, String catalogName) {
        this(pattern, null, catalogName, NodePosition.ZERO);
    }

    public ShowDbStmt(String pattern, Expr where, String catalogName) {
        this(pattern, where, catalogName, NodePosition.ZERO);
    }

    public ShowDbStmt(String pattern, Expr where, String catalogName, NodePosition pos) {
        super(pos);
        this.pattern = pattern;
        this.where = where;
        this.catalogName = catalogName;
    }

    public String getPattern() {
        return pattern;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    @Override
    public QueryStatement toSelectStmt() {
        if (where == null) {
            return null;
        }
        // Columns
        SelectList selectList = new SelectList();
        ExprSubstitutionMap aliasMap = new ExprSubstitutionMap(false);
        SelectListItem item = new SelectListItem(new SlotRef(TABLE_NAME, "SCHEMA_NAME"), DB_COL);
        selectList.addItem(item);
        aliasMap.put(new SlotRef(null, DB_COL), item.getExpr().clone(null));
        where = where.substitute(aliasMap);
        return new QueryStatement(new SelectRelation(selectList, new TableRelation(TABLE_NAME),
                where, null, null), this.origStmt);
    }

    @Override
    public ShowResultSetMetaData getMetaData() {
        return META_DATA;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitShowDatabasesStatement(this, context);
    }
}
