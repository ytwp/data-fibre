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

package io.datafibre.fibre.sql.common;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.TableName;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.InternalCatalog;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.common.ErrorCode;
import io.datafibre.fibre.common.ErrorReport;
import io.datafibre.fibre.common.util.DebugUtil;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.qe.OriginStatement;
import io.datafibre.fibre.qe.SqlModeHelper;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.analyzer.SemanticException;
import io.datafibre.fibre.sql.ast.CreateMaterializedViewStmt;
import io.datafibre.fibre.sql.ast.StatementBase;
import io.datafibre.fibre.sql.optimizer.rule.mv.MVUtils;
import io.datafibre.fibre.sql.parser.SqlParser;
import io.datafibre.fibre.thrift.TUniqueId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class MetaUtils {

    private static final Logger LOG = LogManager.getLogger(MVUtils.class);

    public static void checkCatalogExistAndReport(String catalogName) throws AnalysisException {
        if (catalogName == null) {
            ErrorReport.reportAnalysisException("Catalog is null");
        }
//        if (!GlobalStateMgr.getCurrentState().getCatalogMgr().catalogExists(catalogName)) {
//            ErrorReport.reportAnalysisException(ErrorCode.ERR_BAD_CATALOG_ERROR, catalogName);
//        }
    }

    public static void checkDbNullAndReport(Database db, String name) throws AnalysisException {
        if (db == null) {
            ErrorReport.reportAnalysisException(ErrorCode.ERR_BAD_DB_ERROR, name);
        }
    }

    public static void checkNotSupportCatalog(String catalogName, String operation) {
        if (catalogName == null) {
            throw new SemanticException("Catalog is null");
        }
//        if (CatalogMgr.isInternalCatalog(catalogName)) {
//            return;
//        }
        if (operation == null) {
            throw new SemanticException("operation is null");
        }

//        Catalog catalog = GlobalStateMgr.getCurrentState().getCatalogMgr().getCatalogByName(catalogName);
//        if (catalog == null) {
//            throw new SemanticException("Catalog %s is not found", catalogName);
//        }
//
//        if (!operation.equals("ALTER") && catalog.getType().equalsIgnoreCase("iceberg")) {
//            throw new SemanticException("Table of iceberg catalog doesn't support [%s]", operation);
//        }
    }

    public static Database getDatabase(long dbId) {
        Database db = GlobalStateMgr.getCurrentState().getDb(dbId);
        if (db == null) {
            throw new SemanticException("Database %s is not found", dbId);
        }
        return db;
    }

    public static Table getTable(long dbId, long tableId) {
        Database db = GlobalStateMgr.getCurrentState().getDb(dbId);
        if (db == null) {
            throw new SemanticException("Database %s is not found", dbId);
        }
        Table table = db.getTable(tableId);
        if (table == null) {
            throw new SemanticException("Table %s is not found", tableId);
        }
        return table;
    }

    public static Database getDatabase(ConnectContext session, TableName tableName) {
//        if (Strings.isNullOrEmpty(tableName.getCatalog())) {
//            tableName.setCatalog(session.getCurrentCatalog());
//        }
//        Database db = session.getGlobalStateMgr().getMetadataMgr().getDb(tableName.getCatalog(), tableName.getDb());
//        if (db == null) {
//            throw new SemanticException("Database %s is not found", tableName.getCatalogAndDb());
//        }
//        return db;
        return null;
    }

    public static Database getDatabase(String catalogName, String dbName) {
//        Database db = GlobalStateMgr.getCurrentState().getMetadataMgr().getDb(catalogName, dbName);
//        if (db == null) {
//            ErrorReport.reportSemanticException(ErrorCode.ERR_BAD_DB_ERROR, dbName);
//        }
//        return db;
        return null;
    }

    public static Table getTable(TableName tableName) {
//        if (Strings.isNullOrEmpty(tableName.getCatalog())) {
//            tableName.setCatalog(InternalCatalog.DEFAULT_INTERNAL_CATALOG_NAME);
//        }
//        Table table = GlobalStateMgr.getCurrentState().getMetadataMgr().getTable(tableName.getCatalog(),
//                tableName.getDb(), tableName.getTbl());
//        if (table == null) {
//            throw new SemanticException("Table %s is not found", tableName);
//        }
//        return table;
        return null;
    }

    public static Table getTable(ConnectContext session, TableName tableName) {
        if (Strings.isNullOrEmpty(tableName.getCatalog())) {
            tableName.setCatalog(session.getCurrentCatalog());
        }
//        Table table = session.getGlobalStateMgr().getMetadataMgr().getTable(tableName.getCatalog(),
//                tableName.getDb(), tableName.getTbl());
//        if (table == null) {
//            throw new SemanticException("Table %s is not found", tableName.toString());
//        }
//        return table;
        return null;
    }

    public static Table getTable(String catalogName, String dbName, String tableName) {
//        Table table = GlobalStateMgr.getCurrentState().getMetadataMgr().getTable(catalogName, dbName, tableName);
//        if (table == null) {
//            throw new SemanticException("Table %s is not found", tableName);
//        }
//        return table;
        return null;
    }

    public static void normalizationTableName(ConnectContext connectContext, TableName tableName) {
        if (Strings.isNullOrEmpty(tableName.getCatalog())) {
            if (Strings.isNullOrEmpty(connectContext.getCurrentCatalog())) {
                throw new SemanticException("No catalog selected");
            }
            tableName.setCatalog(connectContext.getCurrentCatalog());
        }
        if (Strings.isNullOrEmpty(tableName.getDb())) {
            if (Strings.isNullOrEmpty(connectContext.getDatabase())) {
                throw new SemanticException("No database selected");
            }
            tableName.setDb(connectContext.getDatabase());
        }

        if (Strings.isNullOrEmpty(tableName.getTbl())) {
            throw new SemanticException("Table name is null");
        }
    }

    /**
     * Materialized view name is a little bit different from a normal table
     * 1. Use default catalog if not specified, actually it only support default catalog until now
     */
    public static void normalizeMVName(ConnectContext connectContext, TableName tableName) {
        if (Strings.isNullOrEmpty(tableName.getCatalog())) {
            tableName.setCatalog(InternalCatalog.DEFAULT_INTERNAL_CATALOG_NAME);
        }
        if (Strings.isNullOrEmpty(tableName.getDb())) {
            if (Strings.isNullOrEmpty(connectContext.getDatabase())) {
                throw new SemanticException("No database selected. " +
                                            "You could set the database name through `<database>.<table>` or `use <database>` statement");
            }
            tableName.setDb(connectContext.getDatabase());
        }

        if (Strings.isNullOrEmpty(tableName.getTbl())) {
            throw new SemanticException("Table name cannot be empty");
        }
    }

    public static Map<String, Expr> parseColumnNameToDefineExpr(OriginStatement originStmt) {
        CreateMaterializedViewStmt stmt;

        try {
            List<StatementBase> stmts = SqlParser.parse(originStmt.originStmt, SqlModeHelper.MODE_DEFAULT);
            stmt = (CreateMaterializedViewStmt) stmts.get(originStmt.idx);
            stmt.setIsReplay(true);
            return stmt.parseDefineExprWithoutAnalyze(originStmt.originStmt);
        } catch (Exception e) {
            LOG.warn("error happens when parsing create materialized view stmt [{}] use new parser",
                    originStmt, e);
        }

        // suggestion
        LOG.warn("The materialized view [{}] has encountered compatibility problems. " +
                 "It is best to delete the materialized view and rebuild it to maintain the best compatibility.",
                originStmt.originStmt);
        return Maps.newConcurrentMap();
    }

    public static String genInsertLabel(TUniqueId executionId) {
        return "insert_" + DebugUtil.printId(executionId);
    }

    public static String genDeleteLabel(TUniqueId executionId) {
        return "delete_" + DebugUtil.printId(executionId);
    }

    public static String genUpdateLabel(TUniqueId executionId) {
        return "update_" + DebugUtil.printId(executionId);
    }

//    public static ExternalOlapTable syncOLAPExternalTableMeta(ExternalOlapTable externalOlapTable) {
//        ExternalOlapTable copiedTable = new ExternalOlapTable();
//        externalOlapTable.copyOnlyForQuery(copiedTable);
//        new TableMetaSyncer().syncTable(copiedTable);
//        return copiedTable;
//    }
}
