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
import io.datafibre.fibre.analysis.FunctionName;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.Function;
import io.datafibre.fibre.catalog.FunctionSearchDesc;
import io.datafibre.fibre.catalog.MaterializedView;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.View;
import io.datafibre.fibre.catalog.system.SystemId;
import io.datafibre.fibre.catalog.system.information.InfoSchemaDb;
import io.datafibre.fibre.catalog.system.sys.SysDb;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.common.ErrorCode;
import io.datafibre.fibre.common.ErrorReport;
import io.datafibre.fibre.common.util.concurrent.lock.LockType;
import io.datafibre.fibre.common.util.concurrent.lock.Locker;
import io.datafibre.fibre.privilege.AccessDeniedException;
import io.datafibre.fibre.privilege.ObjectType;
import io.datafibre.fibre.privilege.PrivilegeType;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.ast.AstVisitor;
import io.datafibre.fibre.sql.ast.DdlStmt;
import io.datafibre.fibre.sql.ast.DropDbStmt;
import io.datafibre.fibre.sql.ast.DropFunctionStmt;
import io.datafibre.fibre.sql.ast.DropTableStmt;
import io.datafibre.fibre.sql.ast.FunctionArgsDef;
import io.datafibre.fibre.sql.common.MetaUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.datafibre.fibre.sql.common.ErrorMsgProxy.PARSER_ERROR_MSG;

public class DropStmtAnalyzer {
    private static final Logger LOG = LogManager.getLogger(DropStmtAnalyzer.class);

    public static void analyze(DdlStmt ddlStmt, ConnectContext session) {
        new DropStmtAnalyzerVisitor().analyze(ddlStmt, session);
    }

    static class DropStmtAnalyzerVisitor extends AstVisitor<Void, ConnectContext> {
        public void analyze(DdlStmt statement, ConnectContext session) {
            visit(statement, session);
        }

        @Override
        public Void visitDropTableStatement(DropTableStmt statement, ConnectContext context) {
            MetaUtils.normalizationTableName(context, statement.getTableNameObject());

            // check catalog
            String catalogName = statement.getCatalogName();
            try {
                MetaUtils.checkCatalogExistAndReport(catalogName);
            } catch (AnalysisException e) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_BAD_CATALOG_ERROR, catalogName);
            }

            String dbName = statement.getDbName();
            // check database
            Database db = GlobalStateMgr.getCurrentState().getMetadataMgr().getDb(catalogName, dbName);
            if (db == null) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_BAD_DB_ERROR, dbName);
            }
            Locker locker = new Locker();
            locker.lockDatabase(db, LockType.READ);
            Table table;
            String tableName = statement.getTableName();
            try {
                table = GlobalStateMgr.getCurrentState().getMetadataMgr().getTable(catalogName, dbName, tableName);
                if (table == null) {
                    if (statement.isSetIfExists()) {
                        LOG.info("drop table[{}] which does not exist", tableName);
                        return null;
                    } else {
                        ErrorReport.reportSemanticException(ErrorCode.ERR_BAD_TABLE_ERROR, tableName);
                    }
                } else {
                    if (table instanceof MaterializedView) {
                        throw new SemanticException(
                                "The data of '%s' cannot be dropped because '%s' is a materialized view," +
                                        "use 'drop materialized view %s' to drop it.",
                                tableName, tableName, tableName);
                    }
                }
            } finally {
                locker.unLockDatabase(db, LockType.READ);
            }
            // Check if a view
            if (statement.isView()) {
                if (!(table instanceof View)) {
                    ErrorReport.reportSemanticException(ErrorCode.ERR_WRONG_OBJECT, db.getOriginName(), tableName, "VIEW");
                }
            } else {
                if (table instanceof View) {
                    ErrorReport.reportSemanticException(ErrorCode.ERR_WRONG_OBJECT, db.getOriginName(), tableName, "TABLE");
                }
            }
            return null;
        }

        @Override
        public Void visitDropDbStatement(DropDbStmt statement, ConnectContext context) {
            if (Strings.isNullOrEmpty(statement.getCatalogName())) {
                if (Strings.isNullOrEmpty(context.getCurrentCatalog())) {
                    throw new SemanticException(PARSER_ERROR_MSG.noCatalogSelected());
                }
                statement.setCatalogName(context.getCurrentCatalog());
            }

            try {
                MetaUtils.checkCatalogExistAndReport(statement.getCatalogName());
            } catch (AnalysisException e) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_BAD_CATALOG_ERROR, statement.getCatalogName());
            }

            String dbName = statement.getDbName();
            if (dbName.equalsIgnoreCase(InfoSchemaDb.DATABASE_NAME)) {
                AccessDeniedException.reportAccessDenied(context.getCurrentCatalog(),
                        context.getCurrentUserIdentity(), context.getCurrentRoleIds(),
                        PrivilegeType.DROP.name(), ObjectType.DATABASE.name(), dbName);
            } else if (dbName.equalsIgnoreCase(SysDb.DATABASE_NAME)) {
                Database db = GlobalStateMgr.getCurrentState().getDb(SysDb.DATABASE_NAME.toLowerCase());
                if (db.getId() == SystemId.SYS_DB_ID) {
                    AccessDeniedException.reportAccessDenied(context.getCurrentCatalog(),
                            context.getCurrentUserIdentity(), context.getCurrentRoleIds(),
                            PrivilegeType.DROP.name(), ObjectType.DATABASE.name(), dbName);
                }
            }
            return null;
        }

        @Override
        public Void visitDropFunctionStatement(DropFunctionStmt statement, ConnectContext context) {
            try {
                // analyze function name
                FunctionName functionName = statement.getFunctionName();
                functionName.analyze(context.getDatabase());
                // analyze arguments
                FunctionArgsDef argsDef = statement.getArgsDef();
                argsDef.analyze();

                FunctionSearchDesc funcDesc = new FunctionSearchDesc(functionName, argsDef.getArgTypes(),
                        argsDef.isVariadic());
                statement.setFunctionSearchDesc(funcDesc);

                // check function existence
                Function func;
                if (functionName.isGlobalFunction()) {
                    func = GlobalStateMgr.getCurrentState().getGlobalFunctionMgr().getFunction(funcDesc);
                    if (func == null) {
                        ErrorReport.reportSemanticException(ErrorCode.ERR_BAD_FUNC_ERROR, funcDesc.toString());
                    }
                } else {
                    Database db = GlobalStateMgr.getCurrentState().getDb(functionName.getDb());
                    Locker locker = new Locker();
                    if (db != null) {
                        try {
                            locker.lockDatabase(db, LockType.READ);
                            func = db.getFunction(statement.getFunctionSearchDesc());
                            if (func == null) {
                                ErrorReport.reportSemanticException(ErrorCode.ERR_BAD_FUNC_ERROR, funcDesc.toString());
                            }
                        } finally {
                            locker.unLockDatabase(db, LockType.READ);
                        }
                    }
                }
            } catch (AnalysisException e) {
                throw new SemanticException(e.getMessage());
            }

            return null;
        }
    }

}
