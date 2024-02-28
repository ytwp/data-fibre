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

package io.datafibre.fibre.sql.analyzer;

import com.google.common.base.Joiner;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.ParseNode;
import io.datafibre.fibre.analysis.SlotRef;
import io.datafibre.fibre.analysis.TableName;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.common.util.ParseUtil;
import io.datafibre.fibre.sql.ast.ArrayExpr;
import io.datafibre.fibre.sql.ast.CTERelation;
import io.datafibre.fibre.sql.ast.FieldReference;
import io.datafibre.fibre.sql.ast.InsertStmt;
import io.datafibre.fibre.sql.ast.MapExpr;
import io.datafibre.fibre.sql.ast.NormalizedTableFunctionRelation;
import io.datafibre.fibre.sql.ast.SelectList;
import io.datafibre.fibre.sql.ast.SelectListItem;
import io.datafibre.fibre.sql.ast.SelectRelation;
import io.datafibre.fibre.sql.ast.StatementBase;
import io.datafibre.fibre.sql.ast.SubqueryRelation;
import io.datafibre.fibre.sql.ast.TableFunctionRelation;
import io.datafibre.fibre.sql.ast.TableRelation;
import io.datafibre.fibre.sql.ast.ViewRelation;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * AstToSQLBuilder inherits AstToStringBuilder and rewrites some special AST logic to
 * ensure that the generated SQL must be a legal SQL,
 * which can be used in some scenarios that require serialization and deserialization.
 * Such as string serialization of views
 */
public class AstToSQLBuilder {

    public static String buildSimple(StatementBase statement) {
        Map<TableName, Table> tables = AnalyzerUtils.collectAllTableAndViewWithAlias(statement);
        boolean sameCatalogDb = tables.keySet().stream().map(TableName::getCatalogAndDb).distinct().count() == 1;
        return new AST2SQLBuilderVisitor(sameCatalogDb, false).visit(statement);
    }

    public static String toSQL(ParseNode statement) {
        return new AST2SQLBuilderVisitor(false, false).visit(statement);
    }

    public static class AST2SQLBuilderVisitor extends AstToStringBuilder.AST2StringBuilderVisitor {

        protected final boolean simple;
        protected final boolean withoutTbl;

        public AST2SQLBuilderVisitor(boolean simple, boolean withoutTbl) {
            this.simple = simple;
            this.withoutTbl = withoutTbl;
        }

        private String buildColumnName(TableName tableName, String fieldName, String columnName) {
            String res = "";
            if (tableName != null && !withoutTbl) {
                if (!simple) {
                    res = tableName.toSql();
                } else {
                    res = "`" + tableName.getTbl() + "`";
                }
                res += ".";
            }

            res += '`' + fieldName + '`';
            if (!fieldName.equalsIgnoreCase(columnName)) {
                res += " AS `" + columnName + "`";
            }
            return res;
        }

        private String buildStructColumnName(TableName tableName, String fieldName, String columnName) {
            String res = "";
            if (tableName != null) {
                if (!simple) {
                    res = tableName.toSql();
                } else {
                    res = "`" + tableName.getTbl() + "`";
                }
                res += ".";
            }

            fieldName = handleColumnName(fieldName);
            columnName = handleColumnName(columnName);

            res += fieldName;
            if (!fieldName.equalsIgnoreCase(columnName)) {
                res += " AS " + columnName;
            }
            return res;
        }

        // Consider struct, like fieldName = a.b.c, columnName = a.b.c
        private String handleColumnName(String name) {
            String[] fields = name.split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < fields.length; i++) {
                sb.append("`");
                sb.append(fields[i]);
                sb.append("`");
                if (i < fields.length - 1) {
                    sb.append(".");
                }
            }
            return sb.toString();
        }

        @Override
        public String visitNode(ParseNode node, Void context) {
            return "";
        }

        @Override
        public String visitSelect(SelectRelation stmt, Void context) {
            StringBuilder sqlBuilder = new StringBuilder();
            SelectList selectList = stmt.getSelectList();
            sqlBuilder.append("SELECT ");

            // add hint
            if (selectList.getHintNodes() != null) {
                sqlBuilder.append(extractHintStr(selectList.getHintNodes()));
            }

            if (selectList.isDistinct()) {
                sqlBuilder.append("DISTINCT ");
            }

            List<String> selectListString = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(stmt.getOutputExpression())) {
                for (int i = 0; i < stmt.getOutputExpression().size(); ++i) {
                    Expr expr = stmt.getOutputExpression().get(i);
                    String columnName = stmt.getColumnOutputNames().get(i);

                    if (expr instanceof FieldReference) {
                        Field field = stmt.getScope().getRelationFields().getFieldByIndex(i);
                        selectListString.add(buildColumnName(field.getRelationAlias(), field.getName(), columnName));
                    } else if (expr instanceof SlotRef) {
                        SlotRef slot = (SlotRef) expr;
                        if (slot.getOriginType().isStructType()) {
                            selectListString.add(buildStructColumnName(slot.getTblNameWithoutAnalyzed(),
                                    slot.getColumnName(), columnName));
                        } else {
                            selectListString.add(buildColumnName(slot.getTblNameWithoutAnalyzed(), slot.getColumnName(),
                                    columnName));
                        }
                    } else {
                        selectListString.add(visit(expr) + " AS `" + columnName + "`");
                    }
                }
            } else {
                for (SelectListItem item : stmt.getSelectList().getItems()) {
                    if (item.isStar()) {
                        if (item.getTblName() != null) {
                            selectListString.add(item.getTblName() + ".*");
                        } else {
                            selectListString.add("*");
                        }
                    } else if (item.getExpr() != null) {
                        Expr expr = item.getExpr();
                        String str = visit(expr);
                        if (StringUtils.isNotEmpty(item.getAlias())) {
                            str += " AS " + ParseUtil.backquote(item.getAlias());
                        }
                        selectListString.add(str);
                    }
                }
            }

            sqlBuilder.append(Joiner.on(", ").join(selectListString));

            String fromClause = visit(stmt.getRelation());
            if (fromClause != null) {
                sqlBuilder.append("\nFROM ");
                sqlBuilder.append(fromClause);
            }

            if (stmt.hasWhereClause()) {
                sqlBuilder.append("\nWHERE ");
                sqlBuilder.append(visit(stmt.getWhereClause()));
            }

            if (stmt.hasGroupByClause()) {
                sqlBuilder.append("\nGROUP BY ");
                sqlBuilder.append(visit(stmt.getGroupByClause()));
            }

            if (stmt.hasHavingClause()) {
                sqlBuilder.append("\nHAVING ");
                sqlBuilder.append(visit(stmt.getHavingClause()));
            }

            return sqlBuilder.toString();
        }

        @Override
        public String visitCTE(CTERelation relation, Void context) {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("`" + relation.getName() + "`");

            if (relation.isResolvedInFromClause()) {
                if (relation.getAlias() != null) {
                    sqlBuilder.append(" AS ").append(relation.getAlias().getTbl());
                }
                return sqlBuilder.toString();
            }

            if (relation.getColumnOutputNames() != null) {
                sqlBuilder.append(" (")
                        .append(Joiner.on(", ").join(
                                relation.getColumnOutputNames().stream().map(c -> "`" + c + "`").collect(toList())))
                        .append(")");
            }
            sqlBuilder.append(" AS (").append(visit(relation.getCteQueryStatement())).append(") ");
            return sqlBuilder.toString();
        }

        @Override
        public String visitSubquery(SubqueryRelation node, Void context) {
            StringBuilder sqlBuilder = new StringBuilder("(" + visit(node.getQueryStatement()) + ")");

            if (node.getAlias() != null) {
                sqlBuilder.append(" ").append(ParseUtil.backquote(node.getAlias().getTbl()));

                if (node.getExplicitColumnNames() != null) {
                    List<String> explicitColNames = new ArrayList<>();
                    node.getExplicitColumnNames().forEach(e -> explicitColNames.add(ParseUtil.backquote(e)));
                    sqlBuilder.append("(");
                    sqlBuilder.append(Joiner.on(",").join(explicitColNames));
                    sqlBuilder.append(")");
                }
            }
            return sqlBuilder.toString();
        }

        @Override
        public String visitView(ViewRelation node, Void context) {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append(node.getName().toSql());

            if (node.getAlias() != null) {
                sqlBuilder.append(" AS ");
                sqlBuilder.append("`").append(node.getAlias().getTbl()).append("`");
            }
            return sqlBuilder.toString();
        }

        @Override
        public String visitTable(TableRelation node, Void outerScope) {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append(node.getName().toSql());

            for (TableRelation.TableHint hint : CollectionUtils.emptyIfNull(node.getTableHints())) {
                sqlBuilder.append(" [");
                sqlBuilder.append(hint.name());
                sqlBuilder.append("] ");
            }

            if (node.getPartitionNames() != null) {
                List<String> partitionNames = node.getPartitionNames().getPartitionNames();
                if (partitionNames != null && !partitionNames.isEmpty()) {
                    sqlBuilder.append(" PARTITION(");
                }
                for (String partitionName : partitionNames) {
                    sqlBuilder.append("`").append(partitionName).append("`").append(",");
                }
                sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
                sqlBuilder.append(")");
            }
            if (node.getAlias() != null) {
                sqlBuilder.append(" AS ");
                sqlBuilder.append("`").append(node.getAlias().getTbl()).append("`");
            }
            return sqlBuilder.toString();
        }

        @Override
        public String visitTableFunction(TableFunctionRelation node, Void scope) {
            StringBuilder sqlBuilder = new StringBuilder();

            sqlBuilder.append(node.getFunctionName());
            sqlBuilder.append("(");

            List<String> childSql = node.getChildExpressions().stream().map(this::visit).collect(toList());
            sqlBuilder.append(Joiner.on(",").join(childSql));

            sqlBuilder.append(")");
            if (node.getAlias() != null) {
                sqlBuilder.append(" ").append(node.getAlias().getTbl());

                if (node.getColumnOutputNames() != null) {
                    sqlBuilder.append("(");
                    String names = node.getColumnOutputNames().stream().map(c -> "`" + c + "`")
                            .collect(Collectors.joining(","));
                    sqlBuilder.append(names);
                    sqlBuilder.append(")");
                }
            }

            return sqlBuilder.toString();
        }

        @Override
        public String visitNormalizedTableFunction(NormalizedTableFunctionRelation node, Void scope) {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("TABLE(");

            TableFunctionRelation tableFunction = (TableFunctionRelation) node.getRight();
            sqlBuilder.append(tableFunction.getFunctionName());
            sqlBuilder.append("(");
            sqlBuilder.append(
                    tableFunction.getChildExpressions().stream().map(this::visit).collect(Collectors.joining(",")));
            sqlBuilder.append(")");
            sqlBuilder.append(")"); // TABLE(

            if (tableFunction.getAlias() != null) {
                sqlBuilder.append(" ").append(tableFunction.getAlias().getTbl());
                if (tableFunction.getColumnOutputNames() != null) {
                    sqlBuilder.append("(");
                    String names = tableFunction.getColumnOutputNames().stream().map(c -> "`" + c + "`")
                            .collect(Collectors.joining(","));
                    sqlBuilder.append(names);
                    sqlBuilder.append(")");
                }
            }

            return sqlBuilder.toString();
        }

        @Override
        public String visitExpression(Expr expr, Void context) {
            return expr.toSql();
        }

        @Override
        public String visitSlot(SlotRef expr, Void context) {
            if (expr.getOriginType().isStructType()) {
                return buildStructColumnName(expr.getTblNameWithoutAnalyzed(),
                        expr.getColumnName(), expr.getColumnName());
            } else {
                return buildColumnName(expr.getTblNameWithoutAnalyzed(),
                        expr.getColumnName(), expr.getColumnName());
            }
        }

        @Override
        public String visitInsertStatement(InsertStmt insert, Void context) {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT ");

            // add hint
            if (insert.getHintNodes() != null) {
                sb.append(extractHintStr(insert.getHintNodes()));
            }


            if (insert.isOverwrite()) {
                sb.append("OVERWRITE ");
            } else {
                sb.append("INTO ");
            }

            // target
            sb.append(insert.getTableName().toSql()).append(" ");

            // target partition
            if (insert.getTargetPartitionNames() != null &&
                    CollectionUtils.isNotEmpty(insert.getTargetPartitionNames().getPartitionNames())) {
                List<String> names = insert.getTargetPartitionNames().getPartitionNames();
                sb.append("PARTITION (").append(Joiner.on(",").join(names)).append(") ");
            }

            // label
            if (StringUtils.isNotEmpty(insert.getLabel())) {
                sb.append("WITH LABEL `").append(insert.getLabel()).append("` ");
            }

            // target column
            if (CollectionUtils.isNotEmpty(insert.getTargetColumnNames())) {
                String columns = insert.getTargetColumnNames().stream()
                        .map(x -> '`' + x + '`')
                        .collect(Collectors.joining(","));
                sb.append("(").append(columns).append(") ");
            }

            // source
            if (insert.getQueryStatement() != null) {
                sb.append(visit(insert.getQueryStatement()));
            }
            return sb.toString();
        }

        @Override
        public String visitArrayExpr(ArrayExpr node, Void context) {
            StringBuilder sb = new StringBuilder();
            Type type = AnalyzerUtils.replaceNullType2Boolean(node.getType());
            sb.append(type.toString());
            sb.append('[');
            sb.append(node.getChildren().stream().map(this::visit).collect(Collectors.joining(", ")));
            sb.append(']');
            return sb.toString();
        }

        @Override
        public String visitMapExpr(MapExpr node, Void context) {
            StringBuilder sb = new StringBuilder();
            Type type = AnalyzerUtils.replaceNullType2Boolean(node.getType());
            sb.append(type.toString());
            sb.append("{");
            for (int i = 0; i < node.getChildren().size(); i = i + 2) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(visit(node.getChild(i)) + ":" + visit(node.getChild(i + 1)));
            }
            sb.append("}");
            return sb.toString();
        }
    }
}
