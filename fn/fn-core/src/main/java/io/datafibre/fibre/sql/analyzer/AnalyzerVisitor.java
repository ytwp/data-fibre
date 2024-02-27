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

import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.sql.ast.*;

public class AnalyzerVisitor extends AstVisitor<Void, ConnectContext> {
    public void analyze(StatementBase statement, ConnectContext session) {
        visit(statement, session);
    }

    // ---------------------------------------- Database Statement -----------------------------------------------------

    @Override
    public Void visitUseDbStatement(UseDbStmt statement, ConnectContext context) {
        BasicDbStmtAnalyzer.analyze(statement, context);
        return null;
    }

    @Override
    public Void visitShowCreateDbStatement(ShowCreateDbStmt statement, ConnectContext context) {
        BasicDbStmtAnalyzer.analyze(statement, context);
        return null;
    }

    @Override
    public Void visitRecoverDbStatement(RecoverDbStmt statement, ConnectContext context) {
        BasicDbStmtAnalyzer.analyze(statement, context);
        return null;
    }

//    @Override
//    public Void visitCreateTableStatement(CreateTableStmt statement, ConnectContext context) {
//        CreateTableAnalyzer.analyze(statement, context);
//        return null;
//    }

//    @Override
//    public Void visitCreateTableLikeStatement(CreateTableLikeStmt statement, ConnectContext context) {
//        CreateTableLikeAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitAlterTableStatement(AlterTableStmt statement, ConnectContext context) {
//        AlterTableStatementAnalyzer.analyze(statement, context);
//        return null;
//    }

//    @Override
//    public Void visitCancelAlterTableStatement(CancelAlterTableStmt statement, ConnectContext context) {
//        CancelAlterTableStatementAnalyzer.analyze(statement, context);
//        return null;
//    }

    @Override
    public Void visitAlterResourceGroupStatement(AlterResourceGroupStmt statement, ConnectContext session) {
        statement.analyze();
        return null;
    }

    @Override
    public Void visitAdminSetReplicaStatusStatement(AdminSetReplicaStatusStmt statement, ConnectContext session) {
        AdminStmtAnalyzer.analyze(statement, session);
        return null;
    }

    @Override
    public Void visitAdminShowReplicaStatusStatement(AdminShowReplicaStatusStmt statement, ConnectContext session) {
        AdminStmtAnalyzer.analyze(statement, session);
        return null;
    }

    @Override
    public Void visitAdminShowReplicaDistributionStatement(AdminShowReplicaDistributionStmt statement,
                                                           ConnectContext session) {
        AdminStmtAnalyzer.analyze(statement, session);
        return null;
    }

    @Override
    public Void visitAdminRepairTableStatement(AdminRepairTableStmt statement, ConnectContext session) {
        AdminStmtAnalyzer.analyze(statement, session);
        return null;
    }

    @Override
    public Void visitAdminCancelRepairTableStatement(AdminCancelRepairTableStmt statement, ConnectContext session) {
        AdminStmtAnalyzer.analyze(statement, session);
        return null;
    }

    @Override
    public Void visitAdminCheckTabletsStatement(AdminCheckTabletsStmt statement, ConnectContext session) {
        AdminStmtAnalyzer.analyze(statement, session);
        return null;
    }

//    @Override
//    public Void visitShowUserPropertyStatement(ShowUserPropertyStmt statement, ConnectContext session) {
//        ShowUserPropertyAnalyzer.analyze(statement, session);
//        return null;
//    }

//    @Override
//    public Void visitSetUserPropertyStatement(SetUserPropertyStmt statement, ConnectContext session) {
//        SetUserPropertyAnalyzer.analyze(statement, session);
//        return null;
//    }

//    @Override
//    public Void visitCreateViewStatement(CreateViewStmt statement, ConnectContext session) {
//        ViewAnalyzer.analyze(statement, session);
//        return null;
//    }

//    @Override
//    public Void visitAlterViewStatement(AlterViewStmt statement, ConnectContext session) {
//        ViewAnalyzer.analyze(statement, session);
//        return null;
//    }

//    @Override
//    public Void visitCreateTableAsSelectStatement(CreateTableAsSelectStmt statement, ConnectContext session) {
//        // this phrase do not analyze insertStmt, insertStmt will analyze in
//        // StmtExecutor.handleCreateTableAsSelectStmt because planner will not do meta operations
//        CTASAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitSubmitTaskStatement(SubmitTaskStmt statement, ConnectContext context) {
//        if (statement.getCreateTableAsSelectStmt() != null) {
//            CreateTableAsSelectStmt createTableAsSelectStmt = statement.getCreateTableAsSelectStmt();
//            QueryStatement queryStatement = createTableAsSelectStmt.getQueryStatement();
//            Analyzer.analyze(queryStatement, context);
//        } else if (statement.getInsertStmt() != null) {
//            InsertStmt insertStmt = statement.getInsertStmt();
//            InsertAnalyzer.analyze(insertStmt, context);
//        } else {
//            throw new SemanticException("Submit task statement is not supported");
//        }
//        OriginStatement origStmt = statement.getOrigStmt();
//        String sqlText = origStmt.originStmt.substring(statement.getSqlBeginIndex());
//        statement.setSqlText(sqlText);
//        TaskAnalyzer.analyzeSubmitTaskStmt(statement, context);
//        return null;
//    }

    @Override
    public Void visitCreateResourceGroupStatement(CreateResourceGroupStmt statement, ConnectContext session) {
        statement.analyze();
        return null;
    }

//    @Override
//    public Void visitCreateResourceStatement(CreateResourceStmt stmt, ConnectContext session) {
//        ResourceAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitDropResourceStatement(DropResourceStmt stmt, ConnectContext session) {
//        ResourceAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitAlterResourceStatement(AlterResourceStmt stmt, ConnectContext session) {
//        ResourceAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitShowResourceStatement(ShowResourcesStmt stmt, ConnectContext session) {
//        ResourceAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitInsertStatement(InsertStmt statement, ConnectContext session) {
//        InsertAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitShowStatement(ShowStmt statement, ConnectContext session) {
//        ShowStmtAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitShowDynamicPartitionStatement(ShowDynamicPartitionStmt statement, ConnectContext session) {
//        ShowStmtAnalyzer.analyze(statement, session);
//        return null;
//    }

    @Override
    public Void visitAdminSetConfigStatement(AdminSetConfigStmt adminSetConfigStmt, ConnectContext session) {
        AdminStmtAnalyzer.analyze(adminSetConfigStmt, session);
        return null;
    }

//    @Override
//    public Void visitSetStatement(SetStmt setStmt, ConnectContext session) {
//        SetStmtAnalyzer.analyze(setStmt, session);
//        return null;
//    }

    @Override
    public Void visitAdminShowConfigStatement(AdminShowConfigStmt adminShowConfigStmt, ConnectContext session) {
        AdminStmtAnalyzer.analyze(adminShowConfigStmt, session);
        return null;
    }

//    @Override
//    public Void visitDropTableStatement(DropTableStmt statement, ConnectContext session) {
//        DropStmtAnalyzer.analyze(statement, session);
//        return null;
//    }

    @Override
    public Void visitQueryStatement(QueryStatement stmt, ConnectContext session) {
        new QueryAnalyzer(session).analyze(stmt);
        return null;
    }

//    @Override
//    public Void visitUpdateStatement(UpdateStmt node, ConnectContext context) {
//        UpdateAnalyzer.analyze(node, context);
//        return null;
//    }

//    @Override
//    public Void visitDeleteStatement(DeleteStmt node, ConnectContext context) {
//        DeleteAnalyzer.analyze(node, context);
//        return null;
//    }

//    @Override
//    public Void visitCreateMaterializedViewStatement(CreateMaterializedViewStatement statement,
//                                                     ConnectContext context) {
//        MaterializedViewAnalyzer.analyze(statement, context);
//        return null;
//    }

    @Override
    public Void visitCreateMaterializedViewStmt(CreateMaterializedViewStmt statement, ConnectContext context) {
        statement.analyze(context);
        return null;
    }

//    @Override
//    public Void visitDropMaterializedViewStatement(DropMaterializedViewStmt statement, ConnectContext context) {
//        MaterializedViewAnalyzer.analyze(statement, context);
//        return null;
//    }

//    @Override
//    public Void visitAlterMaterializedViewStatement(AlterMaterializedViewStmt statement,
//                                                    ConnectContext context) {
//        MaterializedViewAnalyzer.analyze(statement, context);
//        return null;
//    }

//    @Override
//    public Void visitRefreshMaterializedViewStatement(RefreshMaterializedViewStatement statement,
//                                                      ConnectContext context) {
//        MaterializedViewAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitCancelRefreshMaterializedViewStatement(CancelRefreshMaterializedViewStmt statement,
//                                                            ConnectContext context) {
//        MaterializedViewAnalyzer.analyze(statement, context);
//        return null;
//    }

//    @Override
//    public Void visitDropFunctionStatement(DropFunctionStmt statement, ConnectContext context) {
//        DropStmtAnalyzer.analyze(statement, context);
//        return null;
//    }

    @Override
    public Void visitCreateFunctionStatement(CreateFunctionStmt statement, ConnectContext context) {
        try {
            statement.analyze(context);
        } catch (AnalysisException e) {
            throw new SemanticException(e.getMessage());
        }
        return null;
    }

//    @Override
//    public Void visitRefreshTableStatement(RefreshTableStmt statement, ConnectContext context) {
//        RefreshTableStatementAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitAlterDatabaseQuotaStatement(AlterDatabaseQuotaStmt statement, ConnectContext context) {
//        AlterDbQuotaAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitCreateDbStatement(CreateDbStmt statement, ConnectContext context) {
//        CreateDbAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitDropDbStatement(DropDbStmt statement, ConnectContext context) {
//        DropStmtAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitAlterDatabaseRenameStatement(AlterDatabaseRenameStatement statement, ConnectContext context) {
//        AlterDatabaseRenameStatementAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitRecoverTableStatement(RecoverTableStmt statement, ConnectContext context) {
//        RecoverTableAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitTruncateTableStatement(TruncateTableStmt statement, ConnectContext context) {
//        TruncateTableAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitRecoverPartitionStatement(RecoverPartitionStmt statement, ConnectContext context) {
//        RecoverPartitionAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitCreateRoutineLoadStatement(CreateRoutineLoadStmt statement, ConnectContext session) {
//        CreateRoutineLoadAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    public Void visitAlterRoutineLoadStatement(AlterRoutineLoadStmt statement, ConnectContext session) {
//        AlterRoutineLoadAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitAlterLoadStatement(AlterLoadStmt statement, ConnectContext session) {
//        AlterLoadAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitStopRoutineLoadStatement(StopRoutineLoadStmt statement, ConnectContext session) {
//        StopRoutineLoadAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitResumeRoutineLoadStatement(ResumeRoutineLoadStmt statement, ConnectContext session) {
//        ResumeRoutineLoadAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitPauseRoutineLoadStatement(PauseRoutineLoadStmt statement, ConnectContext session) {
//        PauseRoutineLoadAnalyzer.analyze(statement, session);
//        return null;
//    }

    // ---------------------------------------- Catalog Statement -------------------------------------------

//    @Override
//    public Void visitCreateCatalogStatement(CreateCatalogStmt statement, ConnectContext context) {
//        CatalogAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitDropCatalogStatement(DropCatalogStmt statement, ConnectContext context) {
//        CatalogAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitShowCatalogsStatement(ShowCatalogsStmt statement, ConnectContext context) {
//        CatalogAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitUseCatalogStatement(UseCatalogStmt statement, ConnectContext context) {
//        CatalogAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitSetCatalogStatement(SetCatalogStmt statement, ConnectContext context) {
//        CatalogAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitAlterCatalogStatement(AlterCatalogStmt statement, ConnectContext context) {
//        CatalogAnalyzer.analyze(statement, context);
//        return null;
//    }

    // ------------------------------------------- Cluster Management Statement ----------------------------------------

//    @Override
//    public Void visitAlterSystemStatement(AlterSystemStmt statement, ConnectContext context) {
//        new AlterSystemStmtAnalyzer().analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitCancelAlterSystemStatement(CancelAlterSystemStmt statement, ConnectContext context) {
//        new AlterSystemStmtAnalyzer().analyze(statement, context);
//        return null;
//    }

    // ------------------------------------------- Analyze Statement ---------------------------------------------------

//    @Override
//    public Void visitAnalyzeStatement(AnalyzeStmt statement, ConnectContext session) {
//        AnalyzeStmtAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    public Void visitCreateAnalyzeJobStatement(CreateAnalyzeJobStmt statement, ConnectContext session) {
//        AnalyzeStmtAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitDropStatsStatement(DropStatsStmt statement, ConnectContext session) {
//        AnalyzeStmtAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitDropHistogramStatement(DropHistogramStmt statement, ConnectContext session) {
//        AnalyzeStmtAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitShowAnalyzeJobStatement(ShowAnalyzeJobStmt statement, ConnectContext session) {
//        ShowStmtAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitShowAnalyzeStatusStatement(ShowAnalyzeStatusStmt statement, ConnectContext session) {
//        ShowStmtAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitShowBasicStatsMetaStatement(ShowBasicStatsMetaStmt statement, ConnectContext session) {
//        ShowStmtAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitShowHistogramStatsMetaStatement(ShowHistogramStatsMetaStmt statement, ConnectContext session) {
//        ShowStmtAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitShowTransactionStatement(ShowTransactionStmt statement, ConnectContext session) {
//        ShowStmtAnalyzer.analyze(statement, session);
//        return null;
//    }
//
//    @Override
//    public Void visitLoadStatement(LoadStmt statement, ConnectContext context) {
//        LoadStmtAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitCancelLoadStatement(CancelLoadStmt statement, ConnectContext context) {
//        CancelLoadStmtAnalyzer.analyze(statement, context);
//        return null;
//    }

    // ---------------------------------------- Privilege Statement ------------------------------------------------

//    @Override
//    public Void visitBaseCreateAlterUserStmt(BaseCreateAlterUserStmt stmt, ConnectContext session) {
//        PrivilegeStmtAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitDropUserStatement(DropUserStmt stmt, ConnectContext session) {
//        PrivilegeStmtAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitShowAuthenticationStatement(ShowAuthenticationStmt statement, ConnectContext context) {
//        PrivilegeStmtAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitExecuteAsStatement(ExecuteAsStmt stmt, ConnectContext session) {
//        PrivilegeStmtAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitCreateRoleStatement(CreateRoleStmt stmt, ConnectContext session) {
//        PrivilegeStmtAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitDropRoleStatement(DropRoleStmt stmt, ConnectContext session) {
//        PrivilegeStmtAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitGrantRevokeRoleStatement(BaseGrantRevokeRoleStmt stmt, ConnectContext session) {
//        PrivilegeStmtAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitSetRoleStatement(SetRoleStmt stmt, ConnectContext session) {
//        PrivilegeStmtAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitSetDefaultRoleStatement(SetDefaultRoleStmt stmt, ConnectContext session) {
//        PrivilegeStmtAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitGrantRevokePrivilegeStatement(BaseGrantRevokePrivilegeStmt stmt, ConnectContext session) {
//        PrivilegeStmtAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitShowGrantsStatement(ShowGrantsStmt stmt, ConnectContext session) {
//        PrivilegeStmtAnalyzer.analyze(stmt, session);
//        return null;
//    }
//
//    @Override
//    public Void visitCreateSecurityIntegrationStatement(CreateSecurityIntegrationStatement statement,
//                                                        ConnectContext context) {
//        SecurityIntegrationStatementAnalyzer.analyze(statement, context);
//        return null;
//    }

    // -------------------------------------- Data Cache Management Statement -----------------------------------------

//    @Override
//    public Void visitCreateDataCacheRuleStatement(CreateDataCacheRuleStmt stmt, ConnectContext context) {
//        DataCacheStmtAnalyzer.analyze(stmt, context);
//        return null;
//    }
//
//    @Override
//    public Void visitShowDataCacheRulesStatement(ShowDataCacheRulesStmt stmt, ConnectContext context) {
//        DataCacheStmtAnalyzer.analyze(stmt, context);
//        return null;
//    }
//
//    @Override
//    public Void visitDropDataCacheRuleStatement(DropDataCacheRuleStmt statement, ConnectContext context) {
//        DataCacheStmtAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitClearDataCacheRulesStatement(ClearDataCacheRulesStmt statement, ConnectContext context) {
//        DataCacheStmtAnalyzer.analyze(statement, context);
//        return null;
//    }

    // ---------------------------------------- Backup Restore Statement -------------------------------------------

//    @Override
//    public Void visitBackupStatement(BackupStmt statement, ConnectContext context) {
//        BackupRestoreAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitRestoreStatement(RestoreStmt statement, ConnectContext context) {
//        BackupRestoreAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitShowBackupStatement(ShowBackupStmt statement, ConnectContext context) {
//        BackupRestoreAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitShowRestoreStatement(ShowRestoreStmt statement, ConnectContext context) {
//        BackupRestoreAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitShowSnapshotStatement(ShowSnapshotStmt statement, ConnectContext context) {
//        ShowSnapshotAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitCreateRepositoryStatement(CreateRepositoryStmt statement, ConnectContext context) {
//        RepositoryAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitDropRepositoryStatement(DropRepositoryStmt statement, ConnectContext context) {
//        RepositoryAnalyzer.analyze(statement, context);
//        return null;
//    }

    // ------------------------------------ Sql BlackList And WhiteList Statement ----------------------------------

    @Override
    public Void visitAddSqlBlackListStatement(AddSqlBlackListStmt statement, ConnectContext session) {
        statement.analyze();
        return null;
    }

    // ------------------------------------------- Export Statement ------------------------------------------------

//    @Override
//    public Void visitExportStatement(ExportStmt statement, ConnectContext context) {
//        ExportStmtAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitShowExportStatement(ShowExportStmt statement, ConnectContext context) {
//        ExportStmtAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitCancelExportStatement(CancelExportStmt statement, ConnectContext context) {
//        ExportStmtAnalyzer.analyze(statement, context);
//        return null;
//    }

    // ------------------------------------------- Plugin Statement ------------------------------------------------

//    public Void visitInstallPluginStatement(InstallPluginStmt statement, ConnectContext context) {
//        PluginAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    public Void visitUninstallPluginStatement(UninstallPluginStmt statement, ConnectContext context) {
//        PluginAnalyzer.analyze(statement, context);
//        return null;
//    }

    // --------------------------------------- File Statement ------------------------------------------------------

//    public Void visitCreateFileStatement(CreateFileStmt statement, ConnectContext context) {
//        FileAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    public Void visitDropFileStatement(DropFileStmt statement, ConnectContext context) {
//        FileAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    public Void visitShowSmallFilesStatement(ShowSmallFilesStmt statement, ConnectContext context) {
//        FileAnalyzer.analyze(statement, context);
//        return null;
//    }

    // ---------------------------------------- Storage Volume Statement -------------------------------------------
//    @Override
//    public Void visitCreateStorageVolumeStatement(CreateStorageVolumeStmt statement, ConnectContext context) {
//        StorageVolumeAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitAlterStorageVolumeStatement(AlterStorageVolumeStmt statement, ConnectContext context) {
//        StorageVolumeAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitDropStorageVolumeStatement(DropStorageVolumeStmt statement, ConnectContext context) {
//        StorageVolumeAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitShowStorageVolumesStatement(ShowStorageVolumesStmt statement, ConnectContext context) {
//        StorageVolumeAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitDescStorageVolumeStatement(DescStorageVolumeStmt statement, ConnectContext context) {
//        StorageVolumeAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitSetDefaultStorageVolumeStatement(SetDefaultStorageVolumeStmt statement, ConnectContext context) {
//        StorageVolumeAnalyzer.analyze(statement, context);
//        return null;
//    }

    // -------------------------------------------- Pipe Statement -------------------------------------------------
//    @Override
//    public Void visitCreatePipeStatement(CreatePipeStmt stmt, ConnectContext context) {
//        PipeAnalyzer.analyze(stmt, context);
//        return null;
//    }
//
//    @Override
//    public Void visitDropPipeStatement(DropPipeStmt stmt, ConnectContext context) {
//        PipeAnalyzer.analyze(stmt, context);
//        return null;
//    }
//
//    @Override
//    public Void visitAlterPipeStatement(AlterPipeStmt stmt, ConnectContext context) {
//        PipeAnalyzer.analyze(stmt, context);
//        return null;
//    }
//
//    @Override
//    public Void visitShowPipeStatement(ShowPipeStmt stmt, ConnectContext context) {
//        PipeAnalyzer.analyze(stmt, context);
//        return null;
//    }
//
//    @Override
//    public Void visitDescPipeStatement(DescPipeStmt stmt, ConnectContext context) {
//        PipeAnalyzer.analyze(stmt, context);
//        return null;
//    }

    // ---------------------------------------- Cancel Compaction Statement -------------------------------------------
//    @Override
//    public Void visitCancelCompactionStatement(CancelCompactionStmt statement, ConnectContext context) {
//        CancelCompactionStmtAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    // ---------------------------------------- Prepare Statement -------------------------------------------
//    @Override
//    public Void visitPrepareStatement(PrepareStmt statement, ConnectContext context) {
//        new PrepareAnalyzer(context).analyze(statement);
//        return null;
//    }
//
//    public Void visitExecuteStatement(ExecuteStmt statement, ConnectContext context) {
//        new PrepareAnalyzer(context).analyze(statement);
//        return null;
//    }

    // ---------------------------------------- Dictionary Statement -------------------------------------------
//    @Override
//    public Void visitCreateDictionaryStatement(CreateDictionaryStmt statement, ConnectContext context) {
//        DictionaryAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitDropDictionaryStatement(DropDictionaryStmt statement, ConnectContext context) {
//        DictionaryAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitRefreshDictionaryStatement(RefreshDictionaryStmt statement, ConnectContext context) {
//        DictionaryAnalyzer.analyze(statement, context);
//        return null;
//    }
//
//    @Override
//    public Void visitShowDictionaryStatement(ShowDictionaryStmt statement, ConnectContext context) {
//        DictionaryAnalyzer.analyze(statement, context);
//        return null;
//    }
}