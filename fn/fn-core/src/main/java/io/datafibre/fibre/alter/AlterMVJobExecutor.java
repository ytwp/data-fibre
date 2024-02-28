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

package io.datafibre.fibre.alter;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.datafibre.fibre.analysis.IntLiteral;
import io.datafibre.fibre.analysis.StringLiteral;
import io.datafibre.fibre.analysis.TableName;
import io.datafibre.fibre.catalog.ForeignKeyConstraint;
import io.datafibre.fibre.catalog.MaterializedView;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.TableProperty;
import io.datafibre.fibre.catalog.UniqueConstraint;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.common.MetaNotFoundException;
import io.datafibre.fibre.common.Pair;
import io.datafibre.fibre.common.util.DynamicPartitionUtil;
import io.datafibre.fibre.common.util.PropertyAnalyzer;
import io.datafibre.fibre.common.util.concurrent.lock.LockType;
import io.datafibre.fibre.common.util.concurrent.lock.Locker;
import io.datafibre.fibre.persist.AlterMaterializedViewStatusLog;
import io.datafibre.fibre.persist.ChangeMaterializedViewRefreshSchemeLog;
import io.datafibre.fibre.persist.ModifyTablePropertyOperationLog;
import io.datafibre.fibre.persist.RenameMaterializedViewLog;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.scheduler.Constants;
import io.datafibre.fibre.scheduler.Task;
import io.datafibre.fibre.scheduler.TaskBuilder;
import io.datafibre.fibre.scheduler.TaskManager;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.analyzer.SemanticException;
import io.datafibre.fibre.sql.analyzer.SetStmtAnalyzer;
import io.datafibre.fibre.sql.ast.AlterMaterializedViewStatusClause;
import io.datafibre.fibre.sql.ast.AsyncRefreshSchemeDesc;
import io.datafibre.fibre.sql.ast.IntervalLiteral;
import io.datafibre.fibre.sql.ast.ModifyTablePropertiesClause;
import io.datafibre.fibre.sql.ast.RefreshSchemeClause;
import io.datafibre.fibre.sql.ast.SetListItem;
import io.datafibre.fibre.sql.ast.SetStmt;
import io.datafibre.fibre.sql.ast.SystemVariable;
import io.datafibre.fibre.sql.ast.TableRenameClause;
import io.datafibre.fibre.sql.common.DmlException;
import io.datafibre.fibre.sql.optimizer.Utils;
import org.apache.commons.lang3.StringUtils;
import org.threeten.extra.PeriodDuration;

import java.util.List;
import java.util.Map;

import static io.datafibre.fibre.catalog.TableProperty.INVALID;

public class AlterMVJobExecutor extends AlterJobExecutor {
    @Override
    public Void visitTableRenameClause(TableRenameClause clause, ConnectContext context) {
        String newMvName = clause.getNewTableName();
        String oldMvName = table.getName();

        if (db.getTable(newMvName) != null) {
            throw new SemanticException("Materialized view [" + newMvName + "] is already used");
        }
        table.setName(newMvName);
        db.dropTable(oldMvName);
        db.registerTableUnlocked(table);
        final RenameMaterializedViewLog renameMaterializedViewLog =
                new RenameMaterializedViewLog(table.getId(), db.getId(), newMvName);
        updateTaskDefinition((MaterializedView) table);
        GlobalStateMgr.getCurrentState().getEditLog().logMvRename(renameMaterializedViewLog);
        LOG.info("rename materialized view[{}] to {}, id: {}", oldMvName, newMvName, table.getId());
        return null;
    }

    @Override
    public Void visitModifyTablePropertiesClause(ModifyTablePropertiesClause modifyTablePropertiesClause,
                                                 ConnectContext context) {
        MaterializedView materializedView = (MaterializedView) table;

        Map<String, String> properties = modifyTablePropertiesClause.getProperties();
        Map<String, String> propClone = Maps.newHashMap();
        propClone.putAll(properties);
        int partitionTTL = INVALID;
        if (properties.containsKey(PropertyAnalyzer.PROPERTIES_PARTITION_TTL_NUMBER)) {
            partitionTTL = PropertyAnalyzer.analyzePartitionTTLNumber(properties);
        }
        Pair<String, PeriodDuration> ttlDuration = null;
        if (properties.containsKey(PropertyAnalyzer.PROPERTIES_PARTITION_TTL)) {
            ttlDuration = PropertyAnalyzer.analyzePartitionTTL(properties);
        }
        int partitionRefreshNumber = INVALID;
        if (properties.containsKey(PropertyAnalyzer.PROPERTIES_PARTITION_REFRESH_NUMBER)) {
            partitionRefreshNumber = PropertyAnalyzer.analyzePartitionRefreshNumber(properties);
        }
        String resourceGroup = null;
        if (properties.containsKey(PropertyAnalyzer.PROPERTIES_RESOURCE_GROUP)) {
            resourceGroup = PropertyAnalyzer.analyzeResourceGroup(properties);
            properties.remove(PropertyAnalyzer.PROPERTIES_RESOURCE_GROUP);
        }
        int autoRefreshPartitionsLimit = INVALID;
        if (properties.containsKey(PropertyAnalyzer.PROPERTIES_AUTO_REFRESH_PARTITIONS_LIMIT)) {
            autoRefreshPartitionsLimit = PropertyAnalyzer.analyzeAutoRefreshPartitionsLimit(properties, materializedView);
        }
        List<TableName> excludedTriggerTables = Lists.newArrayList();
        if (properties.containsKey(PropertyAnalyzer.PROPERTIES_EXCLUDED_TRIGGER_TABLES)) {
            excludedTriggerTables = PropertyAnalyzer.analyzeExcludedTriggerTables(properties, materializedView);
        }
        int maxMVRewriteStaleness = INVALID;
        if (properties.containsKey(PropertyAnalyzer.PROPERTIES_MV_REWRITE_STALENESS_SECOND)) {
            maxMVRewriteStaleness = PropertyAnalyzer.analyzeMVRewriteStaleness(properties);
        }
        List<UniqueConstraint> uniqueConstraints = Lists.newArrayList();
        if (properties.containsKey(PropertyAnalyzer.PROPERTIES_UNIQUE_CONSTRAINT)) {
            uniqueConstraints = PropertyAnalyzer.analyzeUniqueConstraint(properties, db, materializedView);
            properties.remove(PropertyAnalyzer.PROPERTIES_UNIQUE_CONSTRAINT);
        }
        List<ForeignKeyConstraint> foreignKeyConstraints = Lists.newArrayList();
        if (properties.containsKey(PropertyAnalyzer.PROPERTIES_FOREIGN_KEY_CONSTRAINT)) {
            foreignKeyConstraints = PropertyAnalyzer.analyzeForeignKeyConstraint(properties, db, materializedView);
            properties.remove(PropertyAnalyzer.PROPERTIES_FOREIGN_KEY_CONSTRAINT);
        }
        TableProperty.QueryRewriteConsistencyMode oldExternalQueryRewriteConsistencyMode =
                materializedView.getTableProperty().getForceExternalTableQueryRewrite();
        if (properties.containsKey(PropertyAnalyzer.PROPERTIES_FORCE_EXTERNAL_TABLE_QUERY_REWRITE)) {
            String propertyValue = properties.get(PropertyAnalyzer.PROPERTIES_FORCE_EXTERNAL_TABLE_QUERY_REWRITE);
            oldExternalQueryRewriteConsistencyMode = TableProperty.analyzeExternalTableQueryRewrite(propertyValue);
            properties.remove(PropertyAnalyzer.PROPERTIES_FORCE_EXTERNAL_TABLE_QUERY_REWRITE);
        }
        TableProperty.QueryRewriteConsistencyMode oldQueryRewriteConsistencyMode =
                materializedView.getTableProperty().getQueryRewriteConsistencyMode();
        if (properties.containsKey(PropertyAnalyzer.PROPERTIES_QUERY_REWRITE_CONSISTENCY)) {
            String propertyValue = properties.get(PropertyAnalyzer.PROPERTIES_QUERY_REWRITE_CONSISTENCY);
            oldQueryRewriteConsistencyMode = TableProperty.analyzeQueryRewriteMode(propertyValue);
            properties.remove(PropertyAnalyzer.PROPERTIES_QUERY_REWRITE_CONSISTENCY);
        }

        if (!properties.isEmpty()) {
            if (propClone.containsKey(PropertyAnalyzer.PROPERTIES_COLOCATE_WITH)) {
                throw new SemanticException("Modify failed because unsupported properties: " +
                        "colocate group is not supported for materialized view");
            }
            // analyze properties
            List<SetListItem> setListItems = Lists.newArrayList();
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                if (!entry.getKey().startsWith(PropertyAnalyzer.PROPERTIES_MATERIALIZED_VIEW_SESSION_PREFIX)) {
                    throw new SemanticException("Modify failed because unknown properties: " + properties +
                            ", please add `session.` prefix if you want add session variables for mv(" +
                            "eg, \"session.query_timeout\"=\"30000000\").");
                }
                String varKey = entry.getKey().substring(PropertyAnalyzer.PROPERTIES_MATERIALIZED_VIEW_SESSION_PREFIX.length());
                SystemVariable variable = new SystemVariable(varKey, new StringLiteral(entry.getValue()));
                setListItems.add(variable);
            }
            SetStmtAnalyzer.analyze(new SetStmt(setListItems), null);
        }

        boolean isChanged = false;
        Map<String, String> curProp = materializedView.getTableProperty().getProperties();
        if (propClone.containsKey(PropertyAnalyzer.PROPERTIES_PARTITION_TTL) && ttlDuration != null &&
                !materializedView.getTableProperty().getPartitionTTL().equals(ttlDuration.second)) {
            curProp.put(PropertyAnalyzer.PROPERTIES_PARTITION_TTL, ttlDuration.first);
            materializedView.getTableProperty().setPartitionTTL(ttlDuration.second);
            isChanged = true;
        } else if (propClone.containsKey(PropertyAnalyzer.PROPERTIES_PARTITION_TTL_NUMBER) &&
                materializedView.getTableProperty().getPartitionTTLNumber() != partitionTTL) {
            curProp.put(PropertyAnalyzer.PROPERTIES_PARTITION_TTL_NUMBER, String.valueOf(partitionTTL));
            materializedView.getTableProperty().setPartitionTTLNumber(partitionTTL);
            isChanged = true;
        } else if (propClone.containsKey(PropertyAnalyzer.PROPERTIES_PARTITION_REFRESH_NUMBER) &&
                materializedView.getTableProperty().getPartitionRefreshNumber() != partitionRefreshNumber) {
            curProp.put(PropertyAnalyzer.PROPERTIES_PARTITION_REFRESH_NUMBER, String.valueOf(partitionRefreshNumber));
            materializedView.getTableProperty().setPartitionRefreshNumber(partitionRefreshNumber);
            isChanged = true;
        } else if (propClone.containsKey(PropertyAnalyzer.PROPERTIES_AUTO_REFRESH_PARTITIONS_LIMIT) &&
                materializedView.getTableProperty().getAutoRefreshPartitionsLimit() != autoRefreshPartitionsLimit) {
            curProp.put(PropertyAnalyzer.PROPERTIES_AUTO_REFRESH_PARTITIONS_LIMIT, String.valueOf(autoRefreshPartitionsLimit));
            materializedView.getTableProperty().setAutoRefreshPartitionsLimit(autoRefreshPartitionsLimit);
            isChanged = true;
        } else if (propClone.containsKey(PropertyAnalyzer.PROPERTIES_RESOURCE_GROUP) &&
                !StringUtils.equals(materializedView.getTableProperty().getResourceGroup(), resourceGroup)) {
            if (resourceGroup != null && !resourceGroup.isEmpty() &&
                    GlobalStateMgr.getCurrentState().getResourceGroupMgr().getResourceGroup(resourceGroup) == null) {
                throw new SemanticException(PropertyAnalyzer.PROPERTIES_RESOURCE_GROUP
                        + " " + resourceGroup + " does not exist.");
            }
            curProp.put(PropertyAnalyzer.PROPERTIES_RESOURCE_GROUP, resourceGroup);
            materializedView.getTableProperty().setResourceGroup(resourceGroup);
            isChanged = true;
        }
        if (propClone.containsKey(PropertyAnalyzer.PROPERTIES_EXCLUDED_TRIGGER_TABLES)) {
            curProp.put(PropertyAnalyzer.PROPERTIES_EXCLUDED_TRIGGER_TABLES,
                    propClone.get(PropertyAnalyzer.PROPERTIES_EXCLUDED_TRIGGER_TABLES));
            materializedView.getTableProperty().setExcludedTriggerTables(excludedTriggerTables);
            isChanged = true;
        }
        if (propClone.containsKey(PropertyAnalyzer.PROPERTIES_UNIQUE_CONSTRAINT)) {
            materializedView.setUniqueConstraints(uniqueConstraints);
            isChanged = true;
        }
        if (propClone.containsKey(PropertyAnalyzer.PROPERTIES_FOREIGN_KEY_CONSTRAINT)) {
            materializedView.setForeignKeyConstraints(foreignKeyConstraints);
            isChanged = true;
        }
        if (propClone.containsKey(PropertyAnalyzer.PROPERTIES_MV_REWRITE_STALENESS_SECOND)) {
            curProp.put(PropertyAnalyzer.PROPERTIES_MV_REWRITE_STALENESS_SECOND,
                    propClone.get(PropertyAnalyzer.PROPERTIES_MV_REWRITE_STALENESS_SECOND));
            materializedView.setMaxMVRewriteStaleness(maxMVRewriteStaleness);
            isChanged = true;
        }
        if (propClone.containsKey(PropertyAnalyzer.PROPERTIES_FORCE_EXTERNAL_TABLE_QUERY_REWRITE)) {
            materializedView.getTableProperty().getProperties().
                    put(PropertyAnalyzer.PROPERTIES_FORCE_EXTERNAL_TABLE_QUERY_REWRITE,
                            String.valueOf(oldExternalQueryRewriteConsistencyMode));
            materializedView.getTableProperty().setForceExternalTableQueryRewrite(oldExternalQueryRewriteConsistencyMode);
            isChanged = true;
        }
        if (propClone.containsKey(PropertyAnalyzer.PROPERTIES_QUERY_REWRITE_CONSISTENCY)) {
            materializedView.getTableProperty().getProperties().
                    put(PropertyAnalyzer.PROPERTIES_QUERY_REWRITE_CONSISTENCY,
                            String.valueOf(oldQueryRewriteConsistencyMode));
            materializedView.getTableProperty().setQueryRewriteConsistencyMode(oldQueryRewriteConsistencyMode);
            isChanged = true;
        }
        DynamicPartitionUtil.registerOrRemovePartitionTTLTable(materializedView.getDbId(), materializedView);
        if (!properties.isEmpty()) {
            // set properties if there are no exceptions
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                materializedView.getTableProperty().modifyTableProperties(entry.getKey(), entry.getValue());
            }
            isChanged = true;
        }

        if (isChanged) {
            ModifyTablePropertyOperationLog log = new ModifyTablePropertyOperationLog(materializedView.getDbId(),
                    materializedView.getId(), propClone);
            GlobalStateMgr.getCurrentState().getEditLog().logAlterMaterializedViewProperties(log);
        }
        LOG.info("alter materialized view properties {}, id: {}", propClone, materializedView.getId());
        return null;
    }

    @Override
    public Void visitRefreshSchemeClause(RefreshSchemeClause refreshSchemeDesc, ConnectContext context) {
        try {
            MaterializedView materializedView = (MaterializedView) table;
            String dbName = db.getFullName();

            MaterializedView.RefreshType newRefreshType = refreshSchemeDesc.getType();
            MaterializedView.RefreshType oldRefreshType = materializedView.getRefreshScheme().getType();

            TaskManager taskManager = GlobalStateMgr.getCurrentState().getTaskManager();
            Task currentTask = taskManager.getTask(TaskBuilder.getMvTaskName(materializedView.getId()));
            Task task;
            if (currentTask == null) {
                task = TaskBuilder.buildMvTask(materializedView, dbName);
                TaskBuilder.updateTaskInfo(task, refreshSchemeDesc, materializedView);
                taskManager.createTask(task, false);
            } else {
                Task changedTask = TaskBuilder.rebuildMvTask(materializedView, dbName, currentTask.getProperties());
                TaskBuilder.updateTaskInfo(changedTask, refreshSchemeDesc, materializedView);
                taskManager.alterTask(currentTask, changedTask, false);
                task = currentTask;
            }

            // for event triggered type, run task
            if (task.getType() == Constants.TaskType.EVENT_TRIGGERED) {
                taskManager.executeTask(task.getName());
            }

            final MaterializedView.MvRefreshScheme refreshScheme = materializedView.getRefreshScheme();
            Locker locker = new Locker();
            if (!locker.lockAndCheckExist(db, LockType.WRITE)) {
                throw new DmlException("update meta failed. database:" + db.getFullName() + " not exist");
            }
            try {
                // check
                Table mv = db.getTable(materializedView.getId());
                if (mv == null) {
                    throw new DmlException(
                            "update meta failed. materialized view:" + materializedView.getName() + " not exist");
                }
                refreshScheme.setType(newRefreshType);
                if (refreshSchemeDesc instanceof AsyncRefreshSchemeDesc) {
                    AsyncRefreshSchemeDesc asyncRefreshSchemeDesc = (AsyncRefreshSchemeDesc) refreshSchemeDesc;
                    IntervalLiteral intervalLiteral = asyncRefreshSchemeDesc.getIntervalLiteral();
                    if (intervalLiteral != null) {
                        final IntLiteral step = (IntLiteral) intervalLiteral.getValue();
                        final MaterializedView.AsyncRefreshContext asyncRefreshContext = refreshScheme.getAsyncRefreshContext();
                        asyncRefreshContext.setStartTime(
                                Utils.getLongFromDateTime(asyncRefreshSchemeDesc.getStartTime()));
                        asyncRefreshContext.setDefineStartTime(asyncRefreshSchemeDesc.isDefineStartTime());
                        asyncRefreshContext.setStep(step.getLongValue());
                        asyncRefreshContext.setTimeUnit(intervalLiteral.getUnitIdentifier().getDescription());
                    } else {
                        if (materializedView.getBaseTableInfos().stream().anyMatch(tableInfo ->
                                !tableInfo.getTableChecked().isNativeTableOrMaterializedView()
                        )) {
                            throw new DdlException("Materialized view which type is ASYNC need to specify refresh interval for " +
                                    "external table");
                        }
                        refreshScheme.setAsyncRefreshContext(new MaterializedView.AsyncRefreshContext());
                    }
                }

                final ChangeMaterializedViewRefreshSchemeLog log = new ChangeMaterializedViewRefreshSchemeLog(materializedView);
                GlobalStateMgr.getCurrentState().getEditLog().logMvChangeRefreshScheme(log);
            } finally {
                locker.unLockDatabase(db, LockType.WRITE);
            }
            LOG.info("change materialized view refresh type {} to {}, id: {}", oldRefreshType,
                    newRefreshType, materializedView.getId());
            return null;
        } catch (DdlException e) {
            throw new AlterJobException(e.getMessage(), e);
        }
    }

    @Override
    public Void visitAlterMaterializedViewStatusClause(AlterMaterializedViewStatusClause clause, ConnectContext context) {
        String status = clause.getStatus();
        MaterializedView materializedView = (MaterializedView) table;
        String dbName = db.getFullName();

        try {
            if (AlterMaterializedViewStatusClause.ACTIVE.equalsIgnoreCase(status)) {
                materializedView.fixRelationship();
                if (materializedView.isActive()) {
                    return null;
                }

                GlobalStateMgr.getCurrentState().getAlterJobMgr().
                        alterMaterializedViewStatus(materializedView, status, false);
                // for manual refresh type, do not refresh
                if (materializedView.getRefreshScheme().getType() != MaterializedView.RefreshType.MANUAL) {
                    GlobalStateMgr.getCurrentState().getLocalMetastore()
                            .refreshMaterializedView(dbName, materializedView.getName(), true, null,
                                    Constants.TaskRunPriority.NORMAL.value(), true, false);
                }
            } else if (AlterMaterializedViewStatusClause.INACTIVE.equalsIgnoreCase(status)) {
                if (!materializedView.isActive()) {
                    return null;
                }
                LOG.warn("Setting the materialized view {}({}) to inactive because " +
                                "user use alter materialized view set status to inactive",
                        materializedView.getName(), materializedView.getId());
                GlobalStateMgr.getCurrentState().getAlterJobMgr().
                        alterMaterializedViewStatus(materializedView, status, false);
            } else {
                throw new AlterJobException("Unsupported modification materialized view status:" + status);
            }
            AlterMaterializedViewStatusLog log = new AlterMaterializedViewStatusLog(materializedView.getDbId(),
                    materializedView.getId(), status);
            GlobalStateMgr.getCurrentState().getEditLog().logAlterMvStatus(log);
            return null;
        } catch (DdlException | MetaNotFoundException e) {
            throw new AlterJobException(e.getMessage(), e);
        }
    }

    private void updateTaskDefinition(MaterializedView materializedView) {
        Task currentTask = GlobalStateMgr.getCurrentState().getTaskManager().getTask(
                TaskBuilder.getMvTaskName(materializedView.getId()));
        if (currentTask != null) {
            currentTask.setDefinition(materializedView.getTaskDefinition());
            currentTask.setPostRun(TaskBuilder.getAnalyzeMVStmt(materializedView.getName()));
        }
    }
}
