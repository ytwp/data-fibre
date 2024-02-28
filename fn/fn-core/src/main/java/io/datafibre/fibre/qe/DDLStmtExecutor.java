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

package io.datafibre.fibre.qe;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import io.datafibre.fibre.analysis.FunctionName;
import io.datafibre.fibre.analysis.ParseNode;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.common.AlreadyExistsException;
import io.datafibre.fibre.common.Config;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.common.ErrorCode;
import io.datafibre.fibre.common.ErrorReport;
import io.datafibre.fibre.common.MetaNotFoundException;
import io.datafibre.fibre.common.UserException;
import io.datafibre.fibre.datacache.DataCacheMgr;
import io.datafibre.fibre.load.EtlJobType;
import io.datafibre.fibre.plugin.PluginInfo;
import io.datafibre.fibre.scheduler.Constants;
import io.datafibre.fibre.scheduler.Task;
import io.datafibre.fibre.scheduler.TaskManager;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.analyzer.SemanticException;
import io.datafibre.fibre.sql.ast.AdminCancelRepairTableStmt;
import io.datafibre.fibre.sql.ast.AdminCheckTabletsStmt;
import io.datafibre.fibre.sql.ast.AdminRepairTableStmt;
import io.datafibre.fibre.sql.ast.AdminSetConfigStmt;
import io.datafibre.fibre.sql.ast.AdminSetReplicaStatusStmt;
import io.datafibre.fibre.sql.ast.AlterCatalogStmt;
import io.datafibre.fibre.sql.ast.AlterDatabaseQuotaStmt;
import io.datafibre.fibre.sql.ast.AlterDatabaseRenameStatement;
import io.datafibre.fibre.sql.ast.AlterLoadStmt;
import io.datafibre.fibre.sql.ast.AlterMaterializedViewStmt;
import io.datafibre.fibre.sql.ast.AlterResourceGroupStmt;
import io.datafibre.fibre.sql.ast.AlterResourceStmt;
import io.datafibre.fibre.sql.ast.AlterRoleStmt;
import io.datafibre.fibre.sql.ast.AlterRoutineLoadStmt;
import io.datafibre.fibre.sql.ast.AlterStorageVolumeStmt;
import io.datafibre.fibre.sql.ast.AlterSystemStmt;
import io.datafibre.fibre.sql.ast.AlterTableStmt;
import io.datafibre.fibre.sql.ast.AlterUserStmt;
import io.datafibre.fibre.sql.ast.AlterViewStmt;
import io.datafibre.fibre.sql.ast.AstVisitor;
import io.datafibre.fibre.sql.ast.BackupStmt;
import io.datafibre.fibre.sql.ast.BaseGrantRevokePrivilegeStmt;
import io.datafibre.fibre.sql.ast.BaseGrantRevokeRoleStmt;
import io.datafibre.fibre.sql.ast.CancelAlterSystemStmt;
import io.datafibre.fibre.sql.ast.CancelAlterTableStmt;
import io.datafibre.fibre.sql.ast.CancelBackupStmt;
import io.datafibre.fibre.sql.ast.CancelCompactionStmt;
import io.datafibre.fibre.sql.ast.CancelExportStmt;
import io.datafibre.fibre.sql.ast.CancelLoadStmt;
import io.datafibre.fibre.sql.ast.CancelRefreshDictionaryStmt;
import io.datafibre.fibre.sql.ast.CancelRefreshMaterializedViewStmt;
import io.datafibre.fibre.sql.ast.ClearDataCacheRulesStmt;
import io.datafibre.fibre.sql.ast.CreateAnalyzeJobStmt;
import io.datafibre.fibre.sql.ast.CreateCatalogStmt;
import io.datafibre.fibre.sql.ast.CreateDataCacheRuleStmt;
import io.datafibre.fibre.sql.ast.CreateDbStmt;
import io.datafibre.fibre.sql.ast.CreateDictionaryStmt;
import io.datafibre.fibre.sql.ast.CreateFileStmt;
import io.datafibre.fibre.sql.ast.CreateFunctionStmt;
import io.datafibre.fibre.sql.ast.CreateMaterializedViewStatement;
import io.datafibre.fibre.sql.ast.CreateMaterializedViewStmt;
import io.datafibre.fibre.sql.ast.CreateRepositoryStmt;
import io.datafibre.fibre.sql.ast.CreateResourceGroupStmt;
import io.datafibre.fibre.sql.ast.CreateResourceStmt;
import io.datafibre.fibre.sql.ast.CreateRoleStmt;
import io.datafibre.fibre.sql.ast.CreateRoutineLoadStmt;
import io.datafibre.fibre.sql.ast.CreateSecurityIntegrationStatement;
import io.datafibre.fibre.sql.ast.CreateStorageVolumeStmt;
import io.datafibre.fibre.sql.ast.CreateTableLikeStmt;
import io.datafibre.fibre.sql.ast.CreateTableStmt;
import io.datafibre.fibre.sql.ast.CreateUserStmt;
import io.datafibre.fibre.sql.ast.CreateViewStmt;
import io.datafibre.fibre.sql.ast.DropAnalyzeJobStmt;
import io.datafibre.fibre.sql.ast.DropCatalogStmt;
import io.datafibre.fibre.sql.ast.DropDataCacheRuleStmt;
import io.datafibre.fibre.sql.ast.DropDbStmt;
import io.datafibre.fibre.sql.ast.DropDictionaryStmt;
import io.datafibre.fibre.sql.ast.DropFileStmt;
import io.datafibre.fibre.sql.ast.DropFunctionStmt;
import io.datafibre.fibre.sql.ast.DropMaterializedViewStmt;
import io.datafibre.fibre.sql.ast.DropRepositoryStmt;
import io.datafibre.fibre.sql.ast.DropResourceGroupStmt;
import io.datafibre.fibre.sql.ast.DropResourceStmt;
import io.datafibre.fibre.sql.ast.DropRoleStmt;
import io.datafibre.fibre.sql.ast.DropStorageVolumeStmt;
import io.datafibre.fibre.sql.ast.DropTableStmt;
import io.datafibre.fibre.sql.ast.DropTaskStmt;
import io.datafibre.fibre.sql.ast.DropUserStmt;
import io.datafibre.fibre.sql.ast.GrantPrivilegeStmt;
import io.datafibre.fibre.sql.ast.GrantRoleStmt;
import io.datafibre.fibre.sql.ast.InstallPluginStmt;
import io.datafibre.fibre.sql.ast.LoadStmt;
import io.datafibre.fibre.sql.ast.PauseRoutineLoadStmt;
import io.datafibre.fibre.sql.ast.RecoverDbStmt;
import io.datafibre.fibre.sql.ast.RecoverPartitionStmt;
import io.datafibre.fibre.sql.ast.RecoverTableStmt;
import io.datafibre.fibre.sql.ast.RefreshDictionaryStmt;
import io.datafibre.fibre.sql.ast.RefreshMaterializedViewStatement;
import io.datafibre.fibre.sql.ast.RefreshTableStmt;
import io.datafibre.fibre.sql.ast.RestoreStmt;
import io.datafibre.fibre.sql.ast.ResumeRoutineLoadStmt;
import io.datafibre.fibre.sql.ast.RevokePrivilegeStmt;
import io.datafibre.fibre.sql.ast.RevokeRoleStmt;
import io.datafibre.fibre.sql.ast.SetDefaultStorageVolumeStmt;
import io.datafibre.fibre.sql.ast.SetUserPropertyStmt;
import io.datafibre.fibre.sql.ast.StatementBase;
import io.datafibre.fibre.sql.ast.StopRoutineLoadStmt;
import io.datafibre.fibre.sql.ast.SubmitTaskStmt;
import io.datafibre.fibre.sql.ast.SyncStmt;
import io.datafibre.fibre.sql.ast.TruncateTableStmt;
import io.datafibre.fibre.sql.ast.UninstallPluginStmt;
import io.datafibre.fibre.sql.ast.pipe.AlterPipeStmt;
import io.datafibre.fibre.sql.ast.pipe.CreatePipeStmt;
import io.datafibre.fibre.sql.ast.pipe.DropPipeStmt;
import io.datafibre.fibre.statistic.AnalyzeJob;
import io.datafibre.fibre.statistic.ExternalAnalyzeJob;
import io.datafibre.fibre.statistic.NativeAnalyzeJob;
import io.datafibre.fibre.statistic.StatisticExecutor;
import io.datafibre.fibre.statistic.StatisticUtils;
import io.datafibre.fibre.statistic.StatsConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DDLStmtExecutor {

    /**
     * Execute various ddl statement
     */
    public static ShowResultSet execute(StatementBase stmt, ConnectContext context) throws Exception {
        try {
            return stmt.accept(StmtExecutorVisitor.getInstance(), context);
        } catch (RuntimeException re) {
            if (re.getCause() instanceof DdlException) {
                throw (DdlException) re.getCause();
            } else if (re.getCause() instanceof IOException) {
                throw (IOException) re.getCause();
            } else if (re.getCause() != null) {
                throw new DdlException(re.getCause().getMessage(), re);
            } else {
                throw re;
            }
        }
    }

    static class StmtExecutorVisitor extends AstVisitor<ShowResultSet, ConnectContext> {

        private static final Logger LOG = LogManager.getLogger(StmtExecutorVisitor.class);

        private static final StmtExecutorVisitor INSTANCE = new StmtExecutorVisitor();

        public static StmtExecutorVisitor getInstance() {
            return INSTANCE;
        }

        @Override
        public ShowResultSet visitNode(ParseNode node, ConnectContext context) {
            throw new RuntimeException(new DdlException("unsupported statement: " + node.toSql()));
        }

        @Override
        public ShowResultSet visitCreateDbStatement(CreateDbStmt stmt, ConnectContext context) {
            String fullDbName = stmt.getFullDbName();
            String catalogName = stmt.getCatalogName();
            Map<String, String> properties = stmt.getProperties();
            boolean isSetIfNotExists = stmt.isSetIfNotExists();
            ErrorReport.wrapWithRuntimeException(() -> {
                try {
                    context.getGlobalStateMgr().getMetadataMgr().createDb(catalogName, fullDbName, properties);
                } catch (AlreadyExistsException e) {
                    if (isSetIfNotExists) {
                        LOG.info("create database[{}] which already exists", fullDbName);
                    } else {
                        ErrorReport.reportDdlException(ErrorCode.ERR_DB_CREATE_EXISTS, fullDbName);
                    }
                }
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropDbStatement(DropDbStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                String catalogName = stmt.getCatalogName();
                String dbName = stmt.getDbName();
                boolean isForceDrop = stmt.isForceDrop();
                try {
                    context.getGlobalStateMgr().getMetadataMgr().dropDb(catalogName, dbName, isForceDrop);
                } catch (MetaNotFoundException e) {
                    if (stmt.isSetIfExists()) {
                        LOG.info("drop database[{}] which does not exist", dbName);
                    } else {
                        ErrorReport.reportDdlException(ErrorCode.ERR_DB_DROP_EXISTS, dbName);
                    }
                }
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateFunctionStatement(CreateFunctionStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                FunctionName name = stmt.getFunctionName();
                if (name.isGlobalFunction()) {
                    context.getGlobalStateMgr().getGlobalFunctionMgr().userAddFunction(stmt.getFunction());
                } else {
                    Database db = context.getGlobalStateMgr().getDb(name.getDb());
                    if (db == null) {
                        ErrorReport.reportDdlException(ErrorCode.ERR_BAD_DB_ERROR, name.getDb());
                    }
                    db.addFunction(stmt.getFunction());
                }
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropFunctionStatement(DropFunctionStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                FunctionName name = stmt.getFunctionName();
                if (name.isGlobalFunction()) {
                    context.getGlobalStateMgr().getGlobalFunctionMgr().userDropFunction(stmt.getFunctionSearchDesc());
                } else {
                    Database db = context.getGlobalStateMgr().getDb(name.getDb());
                    if (db == null) {
                        ErrorReport.reportDdlException(ErrorCode.ERR_BAD_DB_ERROR, name.getDb());
                    }
                    db.dropFunction(stmt.getFunctionSearchDesc());
                }
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateTableStatement(CreateTableStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getMetadataMgr().createTable(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateTableLikeStatement(CreateTableLikeStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getMetadataMgr().createTableLike(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropTableStatement(DropTableStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getMetadataMgr().dropTable(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateMaterializedViewStmt(CreateMaterializedViewStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().createMaterializedView(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateMaterializedViewStatement(CreateMaterializedViewStatement stmt,
                                                                  ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().createMaterializedView(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropMaterializedViewStatement(DropMaterializedViewStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().dropMaterializedView(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAlterMaterializedViewStatement(AlterMaterializedViewStmt stmt,
                                                                 ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().alterMaterializedView(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitRefreshMaterializedViewStatement(RefreshMaterializedViewStatement stmt,
                                                                   ConnectContext context) {
            List<String> info = Lists.newArrayList();
            ErrorReport.wrapWithRuntimeException(() -> {
                // The priority of manual refresh is higher than that of general refresh
                String taskRunId = context.getGlobalStateMgr().getLocalMetastore().refreshMaterializedView(stmt);
                info.add(taskRunId);
            });

            return new ShowResultSet(RefreshMaterializedViewStatement.META_DATA, Arrays.asList(info));
        }

        @Override
        public ShowResultSet visitCancelRefreshMaterializedViewStatement(CancelRefreshMaterializedViewStmt stmt,
                                                                         ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore()
                        .cancelRefreshMaterializedView(
                                stmt.getMvName().getDb(),
                                stmt.getMvName().getTbl());
            });
            return null;
        }

        @Override
        public ShowResultSet visitAlterTableStatement(AlterTableStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getMetadataMgr().alterTable(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAlterViewStatement(AlterViewStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().alterView(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCancelAlterTableStatement(CancelAlterTableStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().cancelAlter(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitLoadStatement(LoadStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                EtlJobType jobType = stmt.getEtlJobType();
                if (jobType == EtlJobType.UNKNOWN) {
                    throw new DdlException("Unknown load job type");
                }
                if (jobType == EtlJobType.HADOOP && Config.disable_hadoop_load) {
                    throw new DdlException("Load job by hadoop cluster is disabled."
                            + " Try using broker load. See 'help broker load;'");
                }

                context.getGlobalStateMgr().getLoadMgr().createLoadJobFromStmt(stmt, context);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCancelLoadStatement(CancelLoadStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLoadMgr().cancelLoadJob(stmt);
            });
            return null;
        }


        @Override
        public ShowResultSet visitCancelCompactionStatement(CancelCompactionStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getCompactionMgr().cancelCompaction(stmt.getTxnId());
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateRoutineLoadStatement(CreateRoutineLoadStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getRoutineLoadMgr().createRoutineLoadJob(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitPauseRoutineLoadStatement(PauseRoutineLoadStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getRoutineLoadMgr().pauseRoutineLoadJob(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitResumeRoutineLoadStatement(ResumeRoutineLoadStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getRoutineLoadMgr().resumeRoutineLoadJob(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitStopRoutineLoadStatement(StopRoutineLoadStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getRoutineLoadMgr().stopRoutineLoadJob(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAlterRoutineLoadStatement(AlterRoutineLoadStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getRoutineLoadMgr().alterRoutineLoadJob(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAlterLoadStatement(AlterLoadStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLoadMgr().alterLoadJob(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateUserStatement(CreateUserStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getAuthenticationMgr().createUser(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAlterUserStatement(AlterUserStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getAuthenticationMgr()
                        .alterUser(stmt.getUserIdentity(), stmt.getAuthenticationInfo());
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropUserStatement(DropUserStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getAuthenticationMgr().dropUser(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitGrantRevokeRoleStatement(BaseGrantRevokeRoleStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {

                if (stmt instanceof GrantRoleStmt) {
                    context.getGlobalStateMgr().getAuthorizationMgr().grantRole((GrantRoleStmt) stmt);
                } else {
                    context.getGlobalStateMgr().getAuthorizationMgr().revokeRole((RevokeRoleStmt) stmt);
                }
            });
            return null;
        }

        @Override
        public ShowResultSet visitGrantRevokePrivilegeStatement(BaseGrantRevokePrivilegeStmt stmt,
                                                                ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                if (stmt instanceof GrantPrivilegeStmt) {

                    context.getGlobalStateMgr().getAuthorizationMgr().grant((GrantPrivilegeStmt) stmt);

                } else {
                    context.getGlobalStateMgr().getAuthorizationMgr().revoke((RevokePrivilegeStmt) stmt);
                }
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateRoleStatement(CreateRoleStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getAuthorizationMgr().createRole(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAlterRoleStatement(AlterRoleStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getAuthorizationMgr().alterRole(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropRoleStatement(DropRoleStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getAuthorizationMgr().dropRole(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitSetUserPropertyStatement(SetUserPropertyStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getAuthenticationMgr().updateUserProperty(stmt.getUser(),
                        stmt.getPropertyPairList());

            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateSecurityIntegrationStatement(CreateSecurityIntegrationStatement stmt,
                                                                     ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getAuthenticationMgr().createSecurityIntegration(
                        stmt.getName(), stmt.getPropertyMap());
            });

            return null;
        }

        @Override
        public ShowResultSet visitAlterSystemStatement(AlterSystemStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getAlterJobMgr().processAlterCluster(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCancelAlterSystemStatement(CancelAlterSystemStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getAlterJobMgr().getClusterHandler().cancel(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAlterDatabaseQuotaStatement(AlterDatabaseQuotaStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().alterDatabaseQuota(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAlterDatabaseRenameStatement(AlterDatabaseRenameStatement stmt,
                                                               ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().renameDatabase(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitRecoverDbStatement(RecoverDbStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().recoverDatabase(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitRecoverTableStatement(RecoverTableStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().recoverTable(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitRecoverPartitionStatement(RecoverPartitionStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().recoverPartition(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateViewStatement(CreateViewStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                GlobalStateMgr.getCurrentState().getLocalMetastore().createView(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitBackupStatement(BackupStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getBackupHandler().process(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitRestoreStatement(RestoreStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getBackupHandler().process(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCancelBackupStatement(CancelBackupStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getBackupHandler().cancel(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateRepositoryStatement(CreateRepositoryStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getBackupHandler().createRepository(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropRepositoryStatement(DropRepositoryStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getBackupHandler().dropRepository(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitSyncStatement(SyncStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
            });
            return null;
        }

        @Override
        public ShowResultSet visitTruncateTableStatement(TruncateTableStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().truncateTable(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAdminRepairTableStatement(AdminRepairTableStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getTabletChecker().repairTable(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAdminCancelRepairTableStatement(AdminCancelRepairTableStmt stmt,
                                                                  ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getTabletChecker().cancelRepairTable(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAdminSetConfigStatement(AdminSetConfigStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getNodeMgr().setConfig(stmt);
                if (stmt.getConfig().containsKey("mysql_server_version")) {
                    String version = stmt.getConfig().getMap().get("mysql_server_version");
                    if (!Strings.isNullOrEmpty(version)) {
                        GlobalVariable.version = version;
                    }
                }
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateFileStatement(CreateFileStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getSmallFileMgr().createFile(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropFileStatement(DropFileStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getSmallFileMgr().dropFile(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitInstallPluginStatement(InstallPluginStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                try {
                    context.getGlobalStateMgr().getPluginMgr().installPlugin(stmt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            return null;
        }

        @Override
        public ShowResultSet visitUninstallPluginStatement(UninstallPluginStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                try {
                    PluginInfo info = context.getGlobalStateMgr().getPluginMgr().uninstallPlugin(stmt.getPluginName());
                    if (null != info) {
                        GlobalStateMgr.getCurrentState().getEditLog().logUninstallPlugin(info);
                    }
                    LOG.info("uninstall plugin = " + stmt.getPluginName());

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            return null;
        }

        @Override
        public ShowResultSet visitAdminCheckTabletsStatement(AdminCheckTabletsStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().checkTablets(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAdminSetReplicaStatusStatement(AdminSetReplicaStatusStmt stmt,
                                                                 ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getLocalMetastore().setReplicaStatus(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateResourceStatement(CreateResourceStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getResourceMgr().createResource(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropResourceStatement(DropResourceStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getResourceMgr().dropResource(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAlterResourceStatement(AlterResourceStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getResourceMgr().alterResource(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCancelExportStatement(CancelExportStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getExportMgr().cancelExportJob(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateAnalyzeJobStatement(CreateAnalyzeJobStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                AnalyzeJob analyzeJob;
                if (stmt.isNative()) {
                    analyzeJob = new NativeAnalyzeJob(stmt.getDbId(),
                            stmt.getTableId(),
                            stmt.getColumnNames(),
                            stmt.isSample() ? StatsConstants.AnalyzeType.SAMPLE : StatsConstants.AnalyzeType.FULL,
                            StatsConstants.ScheduleType.SCHEDULE,
                            stmt.getProperties(), StatsConstants.ScheduleStatus.PENDING,
                            LocalDateTime.MIN);
                } else {
                    analyzeJob = new ExternalAnalyzeJob(stmt.getTableName().getCatalog(), stmt.getTableName().getDb(),
                            stmt.getTableName().getTbl(), stmt.getColumnNames(),
                            stmt.isSample() ? StatsConstants.AnalyzeType.SAMPLE : StatsConstants.AnalyzeType.FULL,
                            StatsConstants.ScheduleType.SCHEDULE,
                            stmt.getProperties(), StatsConstants.ScheduleStatus.PENDING,
                            LocalDateTime.MIN);
                }
                context.getGlobalStateMgr().getAnalyzeMgr().addAnalyzeJob(analyzeJob);

                ConnectContext statsConnectCtx = StatisticUtils.buildConnectContext();
                // from current session, may execute analyze stmt
                statsConnectCtx.getSessionVariable().setStatisticCollectParallelism(
                        context.getSessionVariable().getStatisticCollectParallelism());
                Thread thread = new Thread(() -> {
                    statsConnectCtx.setThreadLocalInfo();
                    StatisticExecutor statisticExecutor = new StatisticExecutor();
                    analyzeJob.run(statsConnectCtx, statisticExecutor);
                });
                thread.start();
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropAnalyzeStatement(DropAnalyzeJobStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(
                    () -> context.getGlobalStateMgr().getAnalyzeMgr().removeAnalyzeJob(stmt.getId()));
            return null;
        }

        @Override
        public ShowResultSet visitRefreshTableStatement(RefreshTableStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().refreshExternalTable(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateResourceGroupStatement(CreateResourceGroupStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getResourceGroupMgr().createResourceGroup(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropResourceGroupStatement(DropResourceGroupStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getResourceGroupMgr().dropResourceGroup(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAlterResourceGroupStatement(AlterResourceGroupStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getResourceGroupMgr().alterResourceGroup(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitCreateCatalogStatement(CreateCatalogStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getCatalogMgr().createCatalog(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropCatalogStatement(DropCatalogStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getCatalogMgr().dropCatalog(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitAlterCatalogStatement(AlterCatalogStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getCatalogMgr().alterCatalog(stmt);
            });
            return null;
        }

        @Override
        public ShowResultSet visitSubmitTaskStatement(SubmitTaskStmt stmt, ConnectContext context) {
            try {
                return context.getGlobalStateMgr().getTaskManager().handleSubmitTaskStmt(stmt);
            } catch (UserException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public ShowResultSet visitDropTaskStmt(DropTaskStmt dropTaskStmt, ConnectContext context) {
            TaskManager taskManager = context.getGlobalStateMgr().getTaskManager();
            String taskName = dropTaskStmt.getTaskName().getName();
            if (!taskManager.containTask(taskName)) {
                throw new SemanticException("Task " + taskName + " is not exist");
            }
            Task task = taskManager.getTask(taskName);
            if (task.getSource() == Constants.TaskSource.MV && !dropTaskStmt.isForce()) {
                throw new RuntimeException("Can not drop task generated by materialized view. You can use " +
                        "DROP MATERIALIZED VIEW to drop task, when the materialized view is deleted, " +
                        "the related task will be deleted automatically.");
            }
            taskManager.dropTasks(Collections.singletonList(task.getId()), false);
            return null;
        }

        @Override
        public ShowResultSet visitCreateStorageVolumeStatement(CreateStorageVolumeStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                try {
                    context.getGlobalStateMgr().getStorageVolumeMgr().createStorageVolume(stmt);
                } catch (AlreadyExistsException e) {
                    if (stmt.isSetIfNotExists()) {
                        LOG.info("create storage volume[{}] which already exists", stmt.getName());
                    } else {
                        throw e;
                    }
                }
            });
            return null;
        }

        @Override
        public ShowResultSet visitAlterStorageVolumeStatement(AlterStorageVolumeStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() ->
                    context.getGlobalStateMgr().getStorageVolumeMgr().updateStorageVolume(stmt)
            );
            return null;
        }

        @Override
        public ShowResultSet visitDropStorageVolumeStatement(DropStorageVolumeStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                try {
                    context.getGlobalStateMgr().getStorageVolumeMgr().removeStorageVolume(stmt);
                } catch (MetaNotFoundException e) {
                    if (stmt.isSetIfExists()) {
                        LOG.info("drop storage volume[{}] which does not exist", stmt.getName());
                    } else {
                        throw e;
                    }
                }
            });
            return null;
        }

        @Override
        public ShowResultSet visitSetDefaultStorageVolumeStatement(SetDefaultStorageVolumeStmt stmt,
                                                                   ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() ->
                    context.getGlobalStateMgr().getStorageVolumeMgr().setDefaultStorageVolume(stmt)
            );
            return null;
        }

        //=========================================== Pipe Statement ==================================================
        @Override
        public ShowResultSet visitCreatePipeStatement(CreatePipeStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() ->
                    context.getGlobalStateMgr().getPipeManager().createPipe(stmt)
            );
            return null;
        }

        @Override
        public ShowResultSet visitDropPipeStatement(DropPipeStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() ->
                    context.getGlobalStateMgr().getPipeManager().dropPipe(stmt)
            );
            return null;
        }

        @Override
        public ShowResultSet visitAlterPipeStatement(AlterPipeStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() ->
                    context.getGlobalStateMgr().getPipeManager().alterPipe(stmt)
            );
            return null;
        }

        // ==========================================Data Cache Management==============================================
        @Override
        public ShowResultSet visitCreateDataCacheRuleStatement(CreateDataCacheRuleStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                DataCacheMgr.getInstance().createCacheRule(stmt.getTarget(), stmt.getPredicates(), stmt.getPriority(),
                        stmt.getProperties());
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropDataCacheRuleStatement(DropDataCacheRuleStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                DataCacheMgr.getInstance().dropCacheRule(stmt.getCacheRuleId());
            });
            return null;
        }

        @Override
        public ShowResultSet visitClearDataCacheRulesStatement(ClearDataCacheRulesStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                DataCacheMgr.getInstance().clearRules();
            });
            return null;
        }

        //=========================================== Dictionary Statement ==================================================
        @Override
        public ShowResultSet visitCreateDictionaryStatement(CreateDictionaryStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getDictionaryMgr().createDictionary(stmt, context.getDatabase());
            });
            return null;
        }

        @Override
        public ShowResultSet visitDropDictionaryStatement(DropDictionaryStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getDictionaryMgr().dropDictionary(stmt.getDictionaryName(),
                        stmt.isCacheOnly(), false);
            });
            return null;
        }

        @Override
        public ShowResultSet visitRefreshDictionaryStatement(RefreshDictionaryStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getDictionaryMgr().refreshDictionary(stmt.getDictionaryName());
            });
            return null;
        }

        @Override
        public ShowResultSet visitCancelRefreshDictionaryStatement(CancelRefreshDictionaryStmt stmt, ConnectContext context) {
            ErrorReport.wrapWithRuntimeException(() -> {
                context.getGlobalStateMgr().getDictionaryMgr().cancelRefreshDictionary(stmt.getDictionaryName());
            });
            return null;
        }
    }

}
