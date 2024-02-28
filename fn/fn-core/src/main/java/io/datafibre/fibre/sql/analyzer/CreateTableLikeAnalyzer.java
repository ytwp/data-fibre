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

import com.google.common.collect.Lists;
import io.datafibre.fibre.analysis.TableName;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.common.ErrorCode;
import io.datafibre.fibre.common.ErrorReport;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.sql.ast.CreateTableLikeStmt;
import io.datafibre.fibre.sql.ast.CreateTableStmt;
import io.datafibre.fibre.sql.ast.StatementBase;
import io.datafibre.fibre.sql.common.MetaUtils;
import io.datafibre.fibre.sql.parser.SqlParser;

import java.util.List;

public class CreateTableLikeAnalyzer {

    public static void analyze(CreateTableLikeStmt stmt, ConnectContext context) {
        TableName existedDbTbl = stmt.getExistedDbTbl();
        MetaUtils.normalizationTableName(context, stmt.getDbTbl());
        MetaUtils.normalizationTableName(context, existedDbTbl);
        String tableName = stmt.getTableName();
        FeNameFormat.checkTableName(tableName);

        MetaUtils.checkNotSupportCatalog(existedDbTbl.getCatalog(), "CREATE TABLE LIKE");
        Database db = MetaUtils.getDatabase(context, existedDbTbl);
        Table table = MetaUtils.getTable(existedDbTbl);

        List<String> createTableStmt = Lists.newArrayList();
        AstToStringBuilder.getDdlStmt(stmt.getDbName(), table, createTableStmt, null, null, false, false);
        if (createTableStmt.isEmpty()) {
            ErrorReport.reportSemanticException(ErrorCode.ERROR_CREATE_TABLE_LIKE_EMPTY, "CREATE");
        }

        StatementBase statementBase =
                SqlParser.parseOneWithStarRocksDialect(createTableStmt.get(0), context.getSessionVariable());
        if (statementBase instanceof CreateTableStmt) {
            CreateTableStmt parsedCreateTableStmt = (CreateTableStmt) statementBase;
            parsedCreateTableStmt.setTableName(stmt.getTableName());
            if (stmt.isSetIfNotExists()) {
                parsedCreateTableStmt.setIfNotExists();
            }
            if (stmt.getProperties() != null) {
                parsedCreateTableStmt.updateProperties(stmt.getProperties());
            }
            if (stmt.getDistributionDesc() != null) {
                parsedCreateTableStmt.setDistributionDesc(stmt.getDistributionDesc());
            }
            if (stmt.getPartitionDesc() != null) {
                parsedCreateTableStmt.setPartitionDesc(stmt.getPartitionDesc());
            }

            io.datafibre.fibre.sql.analyzer.Analyzer.analyze(parsedCreateTableStmt, context);
            stmt.setCreateTableStmt(parsedCreateTableStmt);
        } else {
            ErrorReport.reportSemanticException(ErrorCode.ERROR_CREATE_TABLE_LIKE_UNSUPPORTED_VIEW);
        }
    }
}