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

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import io.datafibre.fibre.analysis.BinaryPredicate;
import io.datafibre.fibre.analysis.CompoundPredicate;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.InPredicate;
import io.datafibre.fibre.analysis.IntLiteral;
import io.datafibre.fibre.analysis.IsNullPredicate;
import io.datafibre.fibre.analysis.LiteralExpr;
import io.datafibre.fibre.analysis.NullLiteral;
import io.datafibre.fibre.analysis.Parameter;
import io.datafibre.fibre.analysis.Predicate;
import io.datafibre.fibre.analysis.SlotRef;
import io.datafibre.fibre.analysis.StringLiteral;
import io.datafibre.fibre.analysis.TableName;
import io.datafibre.fibre.analysis.VariableExpr;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.KeysType;
import io.datafibre.fibre.catalog.MaterializedView;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.common.Config;
import io.datafibre.fibre.load.Load;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.sql.ast.DeleteStmt;
import io.datafibre.fibre.sql.ast.JoinRelation;
import io.datafibre.fibre.sql.ast.PartitionNames;
import io.datafibre.fibre.sql.ast.QueryStatement;
import io.datafibre.fibre.sql.ast.Relation;
import io.datafibre.fibre.sql.ast.SelectList;
import io.datafibre.fibre.sql.ast.SelectListItem;
import io.datafibre.fibre.sql.ast.SelectRelation;
import io.datafibre.fibre.sql.ast.TableRelation;
import io.datafibre.fibre.sql.common.MetaUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DeleteAnalyzer {
    private static final Logger LOG = LogManager.getLogger(DeleteAnalyzer.class);

    public static List<Predicate> replaceParameterInExpr(List<Predicate> deleteConditions) {
        List<Predicate> result = Lists.newArrayList();
        for (Predicate exprOrig : deleteConditions) {
            Predicate expr = (Predicate) exprOrig.clone();
            result.add(expr);
            if (expr instanceof BinaryPredicate) {
                BinaryPredicate binaryPredicate = (BinaryPredicate) expr;
                Expr rightExpr = binaryPredicate.getChild(1);
                if (rightExpr instanceof Parameter) {
                    binaryPredicate.setChild(1, getLiteralFromParameter((Parameter) rightExpr));
                }
            } else if (expr instanceof InPredicate) {
                InPredicate inPredicate = (InPredicate) expr;
                int inElementNum = inPredicate.getInElementNum();
                for (int i = 1; i <= inElementNum; i++) {
                    Expr child = inPredicate.getChild(i);
                    if (child instanceof Parameter) {
                        inPredicate.setChild(i, getLiteralFromParameter((Parameter) child));
                    }
                }
            }
        }
        return result;
    }

    @NotNull
    private static Expr getLiteralFromParameter(Parameter p) {
        Expr e = p.getExpr();
        if (e == null) {
            throw new SemanticException("Parameter is not set", p.getPos());
        }
        if (e instanceof VariableExpr) {
            Object value = ((VariableExpr) e).getValue();
            e = value == null ? new NullLiteral() : new StringLiteral(value.toString());
        }
        return e;
    }

    private static void analyzePredicate(Expr predicate, List<Predicate> deleteConditions) {
        if (predicate instanceof BinaryPredicate) {
            BinaryPredicate binaryPredicate = (BinaryPredicate) predicate;
            Expr leftExpr = binaryPredicate.getChild(0);
            if (!(leftExpr instanceof SlotRef)) {
                throw new SemanticException("Left expr of binary predicate should be column name", leftExpr.getPos());
            }
            Expr rightExpr = binaryPredicate.getChild(1);
            if (!(rightExpr instanceof LiteralExpr || rightExpr instanceof Parameter)) {
                throw new SemanticException("Right expr of binary predicate should be value", rightExpr.getPos());
            }
            deleteConditions.add(binaryPredicate);
        } else if (predicate instanceof CompoundPredicate) {
            CompoundPredicate compoundPredicate = (CompoundPredicate) predicate;
            if (compoundPredicate.getOp() != CompoundPredicate.Operator.AND) {
                throw new SemanticException("Compound predicate's op should be AND", predicate.getPos());
            }

            analyzePredicate(compoundPredicate.getChild(0), deleteConditions);
            analyzePredicate(compoundPredicate.getChild(1), deleteConditions);
        } else if (predicate instanceof IsNullPredicate) {
            IsNullPredicate isNullPredicate = (IsNullPredicate) predicate;
            Expr leftExpr = isNullPredicate.getChild(0);
            if (!(leftExpr instanceof SlotRef)) {
                throw new SemanticException("Left expr of is_null predicate should be column name", leftExpr.getPos());
            }
            deleteConditions.add(isNullPredicate);
        } else if (predicate instanceof InPredicate) {
            InPredicate inPredicate = (InPredicate) predicate;
            Expr leftExpr = inPredicate.getChild(0);
            if (!(leftExpr instanceof SlotRef)) {
                throw new SemanticException("Left expr of binary predicate should be column name", leftExpr.getPos());
            }
            int inElementNum = inPredicate.getInElementNum();
            int maxAllowedInElementNumOfDelete = Config.max_allowed_in_element_num_of_delete;
            if (inElementNum > maxAllowedInElementNumOfDelete) {
                throw new SemanticException("Element num of predicate should not be more than " +
                        maxAllowedInElementNumOfDelete, inPredicate.getPos());
            }
            for (int i = 1; i <= inElementNum; i++) {
                Expr expr = inPredicate.getChild(i);
                if (!(expr instanceof LiteralExpr || expr instanceof Parameter)) {
                    throw new SemanticException("Child of in predicate should be value", expr.getPos());
                }
            }
            deleteConditions.add(inPredicate);
        } else {
            throw new SemanticException("Where clause only supports compound predicate, binary predicate, " +
                    "is_null predicate and in predicate", predicate.getPos());
        }
    }

    private static void analyzeNonPrimaryKey(DeleteStmt deleteStatement) {
        PartitionNames partitionNames = deleteStatement.getPartitionNames();
        if (partitionNames != null) {
            if (partitionNames.isTemp()) {
                throw new SemanticException("Do not support deleting temp partitions", partitionNames.getPos());
            }
            List<String> names = partitionNames.getPartitionNames();
            if (names.isEmpty()) {
                throw new SemanticException("No partition specifed in partition lists", partitionNames.getPos());
            }
            // check if partition name is not empty string
            if (names.stream().anyMatch(entity -> Strings.isNullOrEmpty(entity))) {
                throw new SemanticException("there are empty partition name", partitionNames.getPos());
            }
        }

        if (deleteStatement.getUsingRelations() != null) {
            throw new SemanticException("Do not support `using` clause in non-primary table");
        }

        if (deleteStatement.getWherePredicate() == null) {
            throw new SemanticException("Where clause is not set");
        }

        if (deleteStatement.getCommonTableExpressions() != null) {
            throw new SemanticException("Do not support `with` clause in non-primary table");
        }

        List<Predicate> deleteConditions = Lists.newLinkedList();
        analyzePredicate(deleteStatement.getWherePredicate(), deleteConditions);
        deleteStatement.setDeleteConditions(deleteConditions);
    }

    public static void analyze(DeleteStmt deleteStatement, ConnectContext session) {
        TableName tableName = deleteStatement.getTableName();
        MetaUtils.normalizationTableName(session, tableName);
        MetaUtils.checkNotSupportCatalog(tableName.getCatalog(), "DELETE");
        MetaUtils.getDatabase(session, tableName);
        Table table = MetaUtils.getTable(session, tableName);

        if (table instanceof MaterializedView) {
            String msg = String.format("The data of '%s' cannot be deleted because it is a materialized view," +
                    "and the data of materialized view must be consistent with the base table.", tableName.getTbl());
            throw new SemanticException(msg, tableName.getPos());
        }

        if (!(table instanceof OlapTable && ((OlapTable) table).getKeysType() == KeysType.PRIMARY_KEYS)) {
            analyzeNonPrimaryKey(deleteStatement);
            return;
        }

        deleteStatement.setTable(table);
        if (deleteStatement.getWherePredicate() == null) {
            throw new SemanticException("Delete must specify where clause to prevent full table delete");
        }
        if (deleteStatement.getPartitionNames() != null) {
            throw new SemanticException("Delete for primary key table do not support specifying partitions",
                    deleteStatement.getPartitionNames().getPos());
        }

        SelectList selectList = new SelectList();
        for (Column col : table.getBaseSchema()) {
            SelectListItem item;
            if (col.isKey()) {
                item = new SelectListItem(new SlotRef(tableName, col.getName()), col.getName());
            } else {
                break;
            }
            selectList.addItem(item);
        }
        try {
            selectList.addItem(new SelectListItem(new IntLiteral(1, Type.TINYINT), Load.LOAD_OP_COLUMN));
        } catch (Exception e) {
            throw new SemanticException("analyze delete failed", e);
        }

        Relation relation = new TableRelation(tableName);
        if (deleteStatement.getUsingRelations() != null) {
            for (Relation r : deleteStatement.getUsingRelations()) {
                relation = new JoinRelation(null, relation, r, null, false);
            }
        }
        SelectRelation selectRelation =
                new SelectRelation(selectList, relation, deleteStatement.getWherePredicate(), null, null);
        if (deleteStatement.getCommonTableExpressions() != null) {
            deleteStatement.getCommonTableExpressions().forEach(selectRelation::addCTERelation);
        }
        QueryStatement queryStatement = new QueryStatement(selectRelation);
        queryStatement.setIsExplain(deleteStatement.isExplain(), deleteStatement.getExplainLevel());
        new QueryAnalyzer(session).analyze(queryStatement);
        deleteStatement.setQueryStatement(queryStatement);
    }
}
