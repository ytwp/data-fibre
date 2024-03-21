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
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.common.util.ParseUtil;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.sql.ast.AlterDatabaseQuotaStmt;

import static io.datafibre.fibre.sql.common.ErrorMsgProxy.PARSER_ERROR_MSG;

public class AlterDbQuotaAnalyzer {
    public static void analyze(AlterDatabaseQuotaStmt statement, ConnectContext context) {
        if (Strings.isNullOrEmpty(statement.getCatalogName())) {
            if (Strings.isNullOrEmpty(context.getCurrentCatalog())) {
                throw new SemanticException(PARSER_ERROR_MSG.noCatalogSelected());
            }
            statement.setCatalogName(context.getCurrentCatalog());
        }

        AlterDatabaseQuotaStmt.QuotaType quotaType = statement.getQuotaType();
        if (quotaType == AlterDatabaseQuotaStmt.QuotaType.DATA) {
            try {
                statement.setQuota(ParseUtil.analyzeDataVolume(statement.getQuotaValue()));
            } catch (AnalysisException e) {
                throw new SemanticException(e.getMessage());
            }
        } else if (quotaType == AlterDatabaseQuotaStmt.QuotaType.REPLICA) {
            try {
                statement.setQuota(ParseUtil.analyzeReplicaNumber(statement.getQuotaValue()));
            } catch (AnalysisException e) {
                throw new SemanticException(e.getMessage());
            }
        }
    }

}