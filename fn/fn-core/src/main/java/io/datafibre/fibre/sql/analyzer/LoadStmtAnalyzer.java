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
import io.datafibre.fibre.analysis.BrokerDesc;
import io.datafibre.fibre.analysis.LabelName;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.PartitionType;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.common.ErrorCode;
import io.datafibre.fibre.common.ErrorReport;
import io.datafibre.fibre.common.util.concurrent.lock.LockType;
import io.datafibre.fibre.common.util.concurrent.lock.Locker;
import io.datafibre.fibre.load.EtlJobType;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.ast.AstVisitor;
import io.datafibre.fibre.sql.ast.DataDescription;
import io.datafibre.fibre.sql.ast.LoadStmt;
import io.datafibre.fibre.sql.ast.ResourceDesc;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Map;

public class LoadStmtAnalyzer {

    private LoadStmtAnalyzer() {
    }

    public static void analyze(LoadStmt statement, ConnectContext context) {
        new LoadStmtAnalyzerVisitor().analyze(statement, context);
    }

    static class LoadStmtAnalyzerVisitor extends AstVisitor<Void, ConnectContext> {

        private static final String VERSION = "version";

        public void analyze(LoadStmt statement, ConnectContext context) {
            visit(statement, context);
        }

        @Override
        public Void visitLoadStatement(LoadStmt statement, ConnectContext context) {
            analyzeLabel(statement, context);
            analyzeDataDescriptions(statement);
            analyzeProperties(statement);
            return null;
        }

        private void analyzeLabel(LoadStmt statement, ConnectContext context) {
            LabelName label = statement.getLabel();
            String dbName = label.getDbName();
            if (Strings.isNullOrEmpty(dbName)) {
                dbName = context.getDatabase();
                if (Strings.isNullOrEmpty(dbName)) {
                    ErrorReport.reportSemanticException(ErrorCode.ERR_NO_DB_ERROR);
                }
            }
            label.setDbName(dbName);
            FeNameFormat.checkLabel(label.getLabelName());
        }

        private void analyzeDataDescriptions(LoadStmt statement) {
            List<DataDescription> dataDescriptions = statement.getDataDescriptions();
            BrokerDesc brokerDesc = statement.getBrokerDesc();
            ResourceDesc resourceDesc = statement.getResourceDesc();
            LabelName label = statement.getLabel();
            if (CollectionUtils.isEmpty(dataDescriptions)) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, "No data file in load statement.");
            }
            try {
                boolean isLoadFromTable = false;
                for (DataDescription dataDescription : dataDescriptions) {
                    if (brokerDesc == null && resourceDesc == null) {
                        dataDescription.setIsHadoopLoad(true);
                    }
                    dataDescription.analyze(label.getDbName());

                    if (dataDescription.isLoadFromTable()) {
                        isLoadFromTable = true;
                    }
                }
                if (isLoadFromTable) {
                    if (dataDescriptions.size() > 1) {
                        ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR,
                                "Only support one olap table load from one external table");
                    }
                    if (resourceDesc == null) {
                        ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR,
                                "Load from table should use Spark Load");
                    }
                }

                EtlJobType etlJobType;
                if (resourceDesc != null) {
                    resourceDesc.analyze();
                    etlJobType = resourceDesc.getEtlJobType();
                } else if (brokerDesc != null) {
                    etlJobType = EtlJobType.BROKER;
                } else {
                    // if cluster is null, use default hadoop cluster
                    // if cluster is not null, use this hadoop cluster
                    etlJobType = EtlJobType.HADOOP;
                }

                String database = ConnectContext.get().getDatabase();
                if (etlJobType == EtlJobType.SPARK && database != null) {
                    for (DataDescription dataDescription : dataDescriptions) {
                        String tableName = dataDescription.getTableName();
                        Database db = GlobalStateMgr.getCurrentState().getDb(database);
                        if (db == null) {
                            continue;
                        }
                        Locker locker = new Locker();
                        locker.lockDatabase(db, LockType.READ);
                        try {
                            Table table = db.getTable(tableName);
                            if (table == null) {
                                continue;
                            }
                            if (table.isOlapOrCloudNativeTable()) {
                                OlapTable olapTable = (OlapTable) table;
                                if (olapTable.getPartitionInfo().getType() == PartitionType.EXPR_RANGE) {
                                    ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR,
                                            "Currently spark load does not support automatic partition tables");
                                }
                            }
                        } finally {
                            locker.unLockDatabase(db, LockType.READ);
                        }
                    }
                }

                statement.setEtlJobType(etlJobType);
            } catch (AnalysisException e) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, e.getMessage());
            }
        }

        private void analyzeProperties(LoadStmt statement) {
            Map<String, String> properties = statement.getProperties();
            try {
                LoadStmt.checkProperties(properties);
            } catch (DdlException e) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, e.getMessage());
            }

            if (properties == null) {
                return;
            }
            final String versionProperty = properties.get(VERSION);
            if (versionProperty != null) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, "Do not support VERSION property");
            }
            statement.setUser(ConnectContext.get().getQualifiedUser());
        }
    }
}