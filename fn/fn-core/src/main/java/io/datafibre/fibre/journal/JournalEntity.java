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

// This file is based on code available under the Apache license here:
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/journal/JournalEntity.java

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package io.datafibre.fibre.journal;

import com.google.common.base.Preconditions;
import io.datafibre.fibre.alter.AlterJobV2;
import io.datafibre.fibre.alter.BatchAlterJobPersistInfo;
import io.datafibre.fibre.authentication.UserPropertyInfo;
import io.datafibre.fibre.backup.AbstractJob;
import io.datafibre.fibre.backup.Repository;
import io.datafibre.fibre.catalog.BrokerMgr;
import io.datafibre.fibre.catalog.Catalog;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.Dictionary;
import io.datafibre.fibre.catalog.Function;
import io.datafibre.fibre.catalog.FunctionSearchDesc;
import io.datafibre.fibre.catalog.MetaVersion;
import io.datafibre.fibre.catalog.Resource;
import io.datafibre.fibre.cluster.Cluster;
import io.datafibre.fibre.common.Config;
import io.datafibre.fibre.common.io.Text;
import io.datafibre.fibre.common.io.Writable;
import io.datafibre.fibre.common.util.SmallFileMgr.SmallFile;
import io.datafibre.fibre.ha.LeaderInfo;
import io.datafibre.fibre.journal.bdbje.Timestamp;
import io.datafibre.fibre.leader.Checkpoint;
import io.datafibre.fibre.load.DeleteInfo;
import io.datafibre.fibre.load.ExportJob;
import io.datafibre.fibre.load.LoadErrorHub;
import io.datafibre.fibre.load.MultiDeleteInfo;
import io.datafibre.fibre.load.loadv2.LoadJob;
import io.datafibre.fibre.load.loadv2.LoadJob.LoadJobStateUpdateInfo;
import io.datafibre.fibre.load.loadv2.LoadJobFinalOperation;
import io.datafibre.fibre.load.routineload.RoutineLoadJob;
import io.datafibre.fibre.load.streamload.StreamLoadTask;
import io.datafibre.fibre.persist.AddPartitionsInfo;
import io.datafibre.fibre.persist.AddPartitionsInfoV2;
import io.datafibre.fibre.persist.AddSubPartitionsInfoV2;
import io.datafibre.fibre.persist.AlterCatalogLog;
import io.datafibre.fibre.persist.AlterLoadJobOperationLog;
import io.datafibre.fibre.persist.AlterMaterializedViewBaseTableInfosLog;
import io.datafibre.fibre.persist.AlterMaterializedViewStatusLog;
import io.datafibre.fibre.persist.AlterRoutineLoadJobOperationLog;
import io.datafibre.fibre.persist.AlterUserInfo;
import io.datafibre.fibre.persist.AlterViewInfo;
import io.datafibre.fibre.persist.AutoIncrementInfo;
import io.datafibre.fibre.persist.BackendIdsUpdateInfo;
import io.datafibre.fibre.persist.BackendTabletsInfo;
import io.datafibre.fibre.persist.BatchDeleteReplicaInfo;
import io.datafibre.fibre.persist.BatchDropInfo;
import io.datafibre.fibre.persist.BatchModifyPartitionsInfo;
import io.datafibre.fibre.persist.CancelDecommissionDiskInfo;
import io.datafibre.fibre.persist.CancelDisableDiskInfo;
import io.datafibre.fibre.persist.ChangeMaterializedViewRefreshSchemeLog;
import io.datafibre.fibre.persist.ColocatePersistInfo;
import io.datafibre.fibre.persist.ColumnRenameInfo;
import io.datafibre.fibre.persist.ConsistencyCheckInfo;
import io.datafibre.fibre.persist.CreateDbInfo;
import io.datafibre.fibre.persist.CreateInsertOverwriteJobLog;
import io.datafibre.fibre.persist.CreateTableInfo;
import io.datafibre.fibre.persist.CreateUserInfo;
import io.datafibre.fibre.persist.DatabaseInfo;
import io.datafibre.fibre.persist.DecommissionDiskInfo;
import io.datafibre.fibre.persist.DictionaryMgrInfo;
import io.datafibre.fibre.persist.DisableDiskInfo;
import io.datafibre.fibre.persist.DisableTableRecoveryInfo;
import io.datafibre.fibre.persist.DropCatalogLog;
import io.datafibre.fibre.persist.DropComputeNodeLog;
import io.datafibre.fibre.persist.DropDbInfo;
import io.datafibre.fibre.persist.DropDictionaryInfo;
import io.datafibre.fibre.persist.DropInfo;
import io.datafibre.fibre.persist.DropPartitionInfo;
import io.datafibre.fibre.persist.DropResourceOperationLog;
import io.datafibre.fibre.persist.DropStorageVolumeLog;
import io.datafibre.fibre.persist.GlobalVarPersistInfo;
import io.datafibre.fibre.persist.HbPackage;
import io.datafibre.fibre.persist.ImpersonatePrivInfo;
import io.datafibre.fibre.persist.InsertOverwriteStateChangeInfo;
import io.datafibre.fibre.persist.ModifyPartitionInfo;
import io.datafibre.fibre.persist.ModifyTableColumnOperationLog;
import io.datafibre.fibre.persist.ModifyTablePropertyOperationLog;
import io.datafibre.fibre.persist.MultiEraseTableInfo;
import io.datafibre.fibre.persist.OperationType;
import io.datafibre.fibre.persist.PartitionPersistInfo;
import io.datafibre.fibre.persist.PartitionPersistInfoV2;
import io.datafibre.fibre.persist.PipeOpEntry;
import io.datafibre.fibre.persist.RecoverInfo;
import io.datafibre.fibre.persist.RemoveAlterJobV2OperationLog;
import io.datafibre.fibre.persist.RenameMaterializedViewLog;
import io.datafibre.fibre.persist.ReplacePartitionOperationLog;
import io.datafibre.fibre.persist.ReplicaPersistInfo;
import io.datafibre.fibre.persist.ReplicationJobLog;
import io.datafibre.fibre.persist.ResourceGroupOpEntry;
import io.datafibre.fibre.persist.RolePrivilegeCollectionInfo;
import io.datafibre.fibre.persist.RoutineLoadOperation;
import io.datafibre.fibre.persist.SecurityIntegrationInfo;
import io.datafibre.fibre.persist.SetDefaultStorageVolumeLog;
import io.datafibre.fibre.persist.SetReplicaStatusOperationLog;
import io.datafibre.fibre.persist.ShardInfo;
import io.datafibre.fibre.persist.SwapTableOperationLog;
import io.datafibre.fibre.persist.TableAddOrDropColumnsInfo;
import io.datafibre.fibre.persist.TableInfo;
import io.datafibre.fibre.persist.TablePropertyInfo;
import io.datafibre.fibre.persist.TransactionIdInfo;
import io.datafibre.fibre.persist.TruncateTableInfo;
import io.datafibre.fibre.persist.UserPrivilegeCollectionInfo;
import io.datafibre.fibre.persist.gson.GsonUtils;
import io.datafibre.fibre.plugin.PluginInfo;
import io.datafibre.fibre.qe.SessionVariable;
import io.datafibre.fibre.scheduler.Task;
import io.datafibre.fibre.scheduler.mv.MVEpoch;
import io.datafibre.fibre.scheduler.mv.MVMaintenanceJob;
import io.datafibre.fibre.scheduler.persist.DropTaskRunsLog;
import io.datafibre.fibre.scheduler.persist.DropTasksLog;
import io.datafibre.fibre.scheduler.persist.TaskRunPeriodStatusChange;
import io.datafibre.fibre.scheduler.persist.TaskRunStatus;
import io.datafibre.fibre.scheduler.persist.TaskRunStatusChange;
import io.datafibre.fibre.sql.ast.UserIdentity;
import io.datafibre.fibre.staros.StarMgrJournal;
import io.datafibre.fibre.statistic.BasicStatsMeta;
import io.datafibre.fibre.statistic.ExternalAnalyzeJob;
import io.datafibre.fibre.statistic.ExternalAnalyzeStatus;
import io.datafibre.fibre.statistic.ExternalBasicStatsMeta;
import io.datafibre.fibre.statistic.HistogramStatsMeta;
import io.datafibre.fibre.statistic.NativeAnalyzeJob;
import io.datafibre.fibre.statistic.NativeAnalyzeStatus;
import io.datafibre.fibre.storagevolume.StorageVolume;
import io.datafibre.fibre.system.Backend;
import io.datafibre.fibre.system.ComputeNode;
import io.datafibre.fibre.system.Frontend;
import io.datafibre.fibre.transaction.TransactionState;
import io.datafibre.fibre.transaction.TransactionStateBatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

// this is the value written to bdb or local edit files. key is an auto-increasing long.
public class JournalEntity implements Writable {
    public static final Logger LOG = LogManager.getLogger(Checkpoint.class);

    private short opCode = OperationType.OP_INVALID;
    private Writable data;

    public short getOpCode() {
        return this.opCode;
    }

    public void setOpCode(short opCode) {
        this.opCode = opCode;
    }

    public Writable getData() {
        return this.data;
    }

    public void setData(Writable data) {
        this.data = data;
    }

    public String toString() {
        return " opCode=" + opCode + " " + data;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeShort(opCode);
        data.write(out);
    }

    public void readFields(DataInput in) throws IOException {
        opCode = in.readShort();
        // set it to true after the entity is truly read,
        // to avoid someone forget to call read method.
        boolean isRead;
        LOG.debug("get opcode: {}", opCode);
        switch (opCode) {
            case OperationType.OP_SAVE_NEXTID:
            case OperationType.OP_ERASE_DB:
            case OperationType.OP_ERASE_TABLE:
            case OperationType.OP_ERASE_PARTITION:
            case OperationType.OP_META_VERSION:
            case OperationType.OP_DROP_ALL_BROKER:
            case OperationType.OP_DROP_REPOSITORY: {
                data = new Text();
                ((Text) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_SAVE_TRANSACTION_ID_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), TransactionIdInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_SAVE_AUTO_INCREMENT_ID:
            case OperationType.OP_DELETE_AUTO_INCREMENT_ID: {
                data = new AutoIncrementInfo(null);
                ((AutoIncrementInfo) data).read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_DB: {
                data = new Database();
                ((Database) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_DB_V2: {
                data = CreateDbInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_DROP_DB: {
                data = DropDbInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ALTER_DB:
            case OperationType.OP_RENAME_DB: {
                data = new DatabaseInfo();
                ((DatabaseInfo) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ALTER_DB_V2:
            case OperationType.OP_RENAME_DB_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), DatabaseInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_MATERIALIZED_VIEW:
            case OperationType.OP_CREATE_TABLE: {
                data = new CreateTableInfo();
                ((CreateTableInfo) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_TABLE_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), CreateTableInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_DROP_TABLE:
            case OperationType.OP_DROP_ROLLUP: {
                data = new DropInfo();
                ((DropInfo) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_DROP_TABLE_V2:
            case OperationType.OP_DROP_ROLLUP_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), DropInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_ERASE_MULTI_TABLES: {
                data = MultiEraseTableInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_DISABLE_TABLE_RECOVERY: {
                data = DisableTableRecoveryInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_PARTITION_V2: {
                data = PartitionPersistInfoV2.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_SUB_PARTITIONS_V2: {
                data = AddSubPartitionsInfoV2.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_PARTITION: {
                data = new PartitionPersistInfo();
                ((PartitionPersistInfo) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_PARTITIONS: {
                data = AddPartitionsInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_PARTITIONS_V2: {
                data = AddPartitionsInfoV2.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_DROP_PARTITION: {
                data = DropPartitionInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_MODIFY_PARTITION: {
                data = new ModifyPartitionInfo();
                ((ModifyPartitionInfo) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_MODIFY_PARTITION_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), ModifyPartitionInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_BATCH_MODIFY_PARTITION: {
                data = BatchModifyPartitionsInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_RECOVER_DB:
            case OperationType.OP_RECOVER_TABLE:
            case OperationType.OP_RECOVER_PARTITION: {
                data = new RecoverInfo();
                ((RecoverInfo) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_RECOVER_DB_V2:
            case OperationType.OP_RECOVER_TABLE_V2:
            case OperationType.OP_RECOVER_PARTITION_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), RecoverInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_BATCH_DROP_ROLLUP: {
                data = BatchDropInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_RENAME_TABLE:
            case OperationType.OP_RENAME_ROLLUP:
            case OperationType.OP_RENAME_PARTITION: {
                data = new TableInfo();
                ((TableInfo) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_RENAME_TABLE_V2:
            case OperationType.OP_RENAME_ROLLUP_V2:
            case OperationType.OP_RENAME_PARTITION_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), TableInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_RENAME_COLUMN_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), ColumnRenameInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_MODIFY_VIEW_DEF: {
                data = AlterViewInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CHANGE_MATERIALIZED_VIEW_REFRESH_SCHEME:
                data = ChangeMaterializedViewRefreshSchemeLog.read(in);
                isRead = true;
                break;
            case OperationType.OP_ALTER_MATERIALIZED_VIEW_PROPERTIES:
                data = ModifyTablePropertyOperationLog.read(in);
                isRead = true;
                break;
            case OperationType.OP_RENAME_MATERIALIZED_VIEW:
                data = RenameMaterializedViewLog.read(in);
                isRead = true;
                break;
            case OperationType.OP_ALTER_MATERIALIZED_VIEW_STATUS:
                data = AlterMaterializedViewStatusLog.read(in);
                isRead = true;
                break;
            case OperationType.OP_ALTER_MATERIALIZED_VIEW_BASE_TABLE_INFOS:
                data = AlterMaterializedViewBaseTableInfosLog.read(in);
                isRead = true;
                break;
            case OperationType.OP_BACKUP_JOB: {
                data = AbstractJob.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_BACKUP_JOB_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), AbstractJob.class);
                isRead = true;
                break;
            }
            case OperationType.OP_RESTORE_JOB: {
                data = AbstractJob.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_RESTORE_JOB_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), AbstractJob.class);
                isRead = true;
                break;
            }
            case OperationType.OP_FINISH_CONSISTENCY_CHECK: {
                data = new ConsistencyCheckInfo();
                ((ConsistencyCheckInfo) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_FINISH_CONSISTENCY_CHECK_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), ConsistencyCheckInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_EXPORT_CREATE:
                data = new ExportJob();
                ((ExportJob) data).readFields(in);
                isRead = true;
                break;
            case OperationType.OP_EXPORT_CREATE_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), ExportJob.class);
                isRead = true;
                break;
            }
            case OperationType.OP_EXPORT_UPDATE_STATE:
                data = new ExportJob.StateTransfer();
                ((ExportJob.StateTransfer) data).readFields(in);
                isRead = true;
                break;
            case OperationType.OP_EXPORT_UPDATE_INFO:
                data = ExportJob.ExportUpdateInfo.read(in);
                isRead = true;
                break;
            case OperationType.OP_EXPORT_UPDATE_INFO_V2:
                data = GsonUtils.GSON.fromJson(Text.readString(in), ExportJob.ExportUpdateInfo.class);
                isRead = true;
                break;
            case OperationType.OP_FINISH_DELETE:
                data = new DeleteInfo();
                ((DeleteInfo) data).readFields(in);
                isRead = true;
                break;
            case OperationType.OP_FINISH_MULTI_DELETE: {
                data = MultiDeleteInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_REPLICA:
            case OperationType.OP_UPDATE_REPLICA:
            case OperationType.OP_DELETE_REPLICA:
            case OperationType.OP_CLEAR_ROLLUP_INFO: {
                data = ReplicaPersistInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_BATCH_DELETE_REPLICA: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), BatchDeleteReplicaInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_REPLICA_V2:
            case OperationType.OP_UPDATE_REPLICA_V2:
            case OperationType.OP_DELETE_REPLICA_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), ReplicaPersistInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_BACKEND:
            case OperationType.OP_DROP_BACKEND:
            case OperationType.OP_BACKEND_STATE_CHANGE: {
                data = new Backend();
                ((Backend) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_BACKEND_V2:
            case OperationType.OP_DROP_BACKEND_V2:
            case OperationType.OP_BACKEND_STATE_CHANGE_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), Backend.class);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_COMPUTE_NODE: {
                data = ComputeNode.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_DROP_COMPUTE_NODE: {
                data = DropComputeNodeLog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_FRONTEND:
            case OperationType.OP_ADD_FIRST_FRONTEND:
            case OperationType.OP_UPDATE_FRONTEND:
            case OperationType.OP_REMOVE_FRONTEND: {
                data = new Frontend();
                ((Frontend) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_FRONTEND_V2:
            case OperationType.OP_ADD_FIRST_FRONTEND_V2:
            case OperationType.OP_UPDATE_FRONTEND_V2:
            case OperationType.OP_REMOVE_FRONTEND_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), Frontend.class);
                isRead = true;
                break;
            }
            case OperationType.OP_SET_LOAD_ERROR_HUB: {
                data = new LoadErrorHub.Param();
                ((LoadErrorHub.Param) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_NEW_DROP_USER: {
                data = UserIdentity.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_UPDATE_USER_PROPERTY: {
                data = UserPropertyInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_LEADER_INFO_CHANGE: {
                data = new LeaderInfo();
                ((LeaderInfo) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_LEADER_INFO_CHANGE_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), LeaderInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_TIMESTAMP: {
                data = new Timestamp();
                ((Timestamp) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_TIMESTAMP_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), Timestamp.class);
                isRead = true;
                break;
            }
            case OperationType.OP_META_VERSION_V2: {
                data = MetaVersion.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_GLOBAL_VARIABLE: {
                data = new SessionVariable();
                ((SessionVariable) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_CLUSTER: {
                data = Cluster.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_BROKER:
            case OperationType.OP_DROP_BROKER: {
                data = new BrokerMgr.ModifyBrokerInfo();
                ((BrokerMgr.ModifyBrokerInfo) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_BROKER_V2:
            case OperationType.OP_DROP_BROKER_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), BrokerMgr.ModifyBrokerInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_UPDATE_CLUSTER_AND_BACKENDS: {
                data = new BackendIdsUpdateInfo();
                ((BackendIdsUpdateInfo) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_UPSERT_TRANSACTION_STATE_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), TransactionState.class);
                isRead = true;
                break;
            }
            case OperationType.OP_UPSERT_TRANSACTION_STATE_BATCH: {
                data = TransactionStateBatch.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_REPOSITORY: {
                data = Repository.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_REPOSITORY_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), Repository.class);
                isRead = true;
                break;
            }
            case OperationType.OP_TRUNCATE_TABLE: {
                data = TruncateTableInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_COLOCATE_ADD_TABLE:
            case OperationType.OP_COLOCATE_REMOVE_TABLE:
            case OperationType.OP_COLOCATE_BACKENDS_PER_BUCKETSEQ:
            case OperationType.OP_COLOCATE_MARK_UNSTABLE:
            case OperationType.OP_COLOCATE_MARK_STABLE: {
                data = new ColocatePersistInfo();
                ((ColocatePersistInfo) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_COLOCATE_ADD_TABLE_V2:
            case OperationType.OP_COLOCATE_BACKENDS_PER_BUCKETSEQ_V2:
            case OperationType.OP_COLOCATE_MARK_UNSTABLE_V2:
            case OperationType.OP_COLOCATE_MARK_STABLE_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), ColocatePersistInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_MODIFY_TABLE_COLOCATE: {
                data = new TablePropertyInfo();
                ((TablePropertyInfo) data).readFields(in);
                isRead = true;
                break;
            }
            case OperationType.OP_MODIFY_TABLE_COLOCATE_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), TablePropertyInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_HEARTBEAT: {
                data = HbPackage.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_HEARTBEAT_V2: {
                data = HbPackage.readV2(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_FUNCTION: {
                data = Function.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_FUNCTION_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), Function.class);
                isRead = true;
                break;
            }
            case OperationType.OP_DROP_FUNCTION: {
                data = FunctionSearchDesc.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_DROP_FUNCTION_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), FunctionSearchDesc.class);
                isRead = true;
                break;
            }
            case OperationType.OP_BACKEND_TABLETS_INFO: {
                data = BackendTabletsInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_BACKEND_TABLETS_INFO_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), BackendTabletsInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_ROUTINE_LOAD_JOB: {
                data = RoutineLoadJob.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_ROUTINE_LOAD_JOB_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), RoutineLoadJob.class);
                isRead = true;
                break;
            }
            case OperationType.OP_CHANGE_ROUTINE_LOAD_JOB:
            case OperationType.OP_REMOVE_ROUTINE_LOAD_JOB: {
                data = RoutineLoadOperation.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CHANGE_ROUTINE_LOAD_JOB_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), RoutineLoadOperation.class);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_STREAM_LOAD_TASK: {
                data = StreamLoadTask.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_STREAM_LOAD_TASK_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), StreamLoadTask.class);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_LOAD_JOB: {
                data = io.datafibre.fibre.load.loadv2.LoadJob.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_LOAD_JOB_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), LoadJob.class);
                isRead = true;
                break;
            }
            case OperationType.OP_END_LOAD_JOB: {
                data = LoadJobFinalOperation.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_END_LOAD_JOB_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), LoadJobFinalOperation.class);
                isRead = true;
                break;
            }
            case OperationType.OP_UPDATE_LOAD_JOB: {
                data = LoadJobStateUpdateInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_RESOURCE: {
                data = Resource.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_DROP_RESOURCE: {
                data = DropResourceOperationLog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_RESOURCE_GROUP: {
                data = ResourceGroupOpEntry.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_TASK:
            case OperationType.OP_ALTER_TASK:
                data = Task.read(in);
                isRead = true;
                break;
            case OperationType.OP_DROP_TASKS:
                data = DropTasksLog.read(in);
                isRead = true;
                break;
            case OperationType.OP_CREATE_TASK_RUN:
                data = TaskRunStatus.read(in);
                isRead = true;
                break;
            case OperationType.OP_UPDATE_TASK_RUN:
                data = TaskRunStatusChange.read(in);
                isRead = true;
                break;
            // only update the progress of task run
            case OperationType.OP_UPDATE_TASK_RUN_STATE:
                data = TaskRunPeriodStatusChange.read(in);
                isRead = true;
                break;
            case OperationType.OP_DROP_TASK_RUNS:
                data = DropTaskRunsLog.read(in);
                isRead = true;
                break;
            case OperationType.OP_CREATE_SMALL_FILE:
            case OperationType.OP_DROP_SMALL_FILE: {
                data = SmallFile.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_SMALL_FILE_V2:
            case OperationType.OP_DROP_SMALL_FILE_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), SmallFile.class);
                isRead = true;
                break;
            }
            case OperationType.OP_ALTER_JOB_V2: {
                data = AlterJobV2.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_BATCH_ADD_ROLLUP: {
                data = BatchAlterJobPersistInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_BATCH_ADD_ROLLUP_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), BatchAlterJobPersistInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_MODIFY_DISTRIBUTION_TYPE: {
                data = TableInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_MODIFY_DISTRIBUTION_TYPE_V2: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), TableInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_SET_REPLICA_STATUS: {
                data = SetReplicaStatusOperationLog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_DYNAMIC_PARTITION:
            case OperationType.OP_MODIFY_IN_MEMORY:
            case OperationType.OP_SET_FORBIDDEN_GLOBAL_DICT:
            case OperationType.OP_MODIFY_REPLICATION_NUM:
            case OperationType.OP_MODIFY_WRITE_QUORUM:
            case OperationType.OP_MODIFY_REPLICATED_STORAGE:
            case OperationType.OP_MODIFY_BUCKET_SIZE:
            case OperationType.OP_MODIFY_BINLOG_CONFIG:
            case OperationType.OP_MODIFY_BINLOG_AVAILABLE_VERSION:
            case OperationType.OP_MODIFY_ENABLE_PERSISTENT_INDEX:
            case OperationType.OP_MODIFY_PRIMARY_INDEX_CACHE_EXPIRE_SEC:
            case OperationType.OP_ALTER_TABLE_PROPERTIES:
            case OperationType.OP_MODIFY_TABLE_CONSTRAINT_PROPERTY: {
                data = ModifyTablePropertyOperationLog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_REPLACE_TEMP_PARTITION: {
                data = ReplacePartitionOperationLog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_INSTALL_PLUGIN: {
                data = PluginInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_UNINSTALL_PLUGIN: {
                data = PluginInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_REMOVE_ALTER_JOB_V2: {
                data = RemoveAlterJobV2OperationLog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ALTER_ROUTINE_LOAD_JOB: {
                data = AlterRoutineLoadJobOperationLog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ALTER_LOAD_JOB: {
                data = AlterLoadJobOperationLog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_GLOBAL_VARIABLE_V2: {
                data = GlobalVarPersistInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_SWAP_TABLE: {
                data = SwapTableOperationLog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_ANALYZER_JOB: {
                data = NativeAnalyzeJob.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_REMOVE_ANALYZER_JOB: {
                data = NativeAnalyzeJob.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_ANALYZE_STATUS: {
                data = NativeAnalyzeStatus.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_REMOVE_ANALYZE_STATUS: {
                data = NativeAnalyzeStatus.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_EXTERNAL_ANALYZE_STATUS: {
                data = ExternalAnalyzeStatus.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_REMOVE_EXTERNAL_ANALYZE_STATUS: {
                data = ExternalAnalyzeStatus.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_EXTERNAL_ANALYZER_JOB: {
                data = ExternalAnalyzeJob.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_REMOVE_EXTERNAL_ANALYZER_JOB: {
                data = ExternalAnalyzeJob.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_BASIC_STATS_META: {
                data = BasicStatsMeta.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_REMOVE_BASIC_STATS_META: {
                data = BasicStatsMeta.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_HISTOGRAM_STATS_META: {
                data = HistogramStatsMeta.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_REMOVE_HISTOGRAM_STATS_META: {
                data = HistogramStatsMeta.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_EXTERNAL_BASIC_STATS_META: {
                data = ExternalBasicStatsMeta.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_REMOVE_EXTERNAL_BASIC_STATS_META: {
                data = ExternalBasicStatsMeta.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_MODIFY_HIVE_TABLE_COLUMN: {
                data = ModifyTableColumnOperationLog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_GRANT_IMPERSONATE: {
                data = ImpersonatePrivInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_REVOKE_IMPERSONATE: {
                data = ImpersonatePrivInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_CATALOG: {
                data = Catalog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_DROP_CATALOG: {
                data = DropCatalogLog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ALTER_CATALOG: {
                data = AlterCatalogLog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_INSERT_OVERWRITE: {
                data = CreateInsertOverwriteJobLog.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_INSERT_OVERWRITE_STATE_CHANGE: {
                data = InsertOverwriteStateChangeInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ADD_UNUSED_SHARD: { // Deprecated
                data = ShardInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_DELETE_UNUSED_SHARD: { // Deprecated
                data = ShardInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_STARMGR: {
                data = StarMgrJournal.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_USER_V2: {
                data = CreateUserInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_ALTER_USER_V2: {
                data = AlterUserInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_UPDATE_USER_PROP_V2: {
                data = UserPropertyInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_UPDATE_USER_PROP_V3: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), UserPropertyInfo.class);
                isRead = true;
                break;
            }
            case OperationType.OP_DROP_USER_V2: {
                data = UserIdentity.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_DROP_USER_V3: {
                data = GsonUtils.GSON.fromJson(Text.readString(in), UserIdentity.class);
                isRead = true;
                break;
            }
            case OperationType.OP_CREATE_SECURITY_INTEGRATION: {
                data = SecurityIntegrationInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_UPDATE_USER_PRIVILEGE_V2: {
                data = UserPrivilegeCollectionInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_DROP_ROLE_V2:
            case OperationType.OP_UPDATE_ROLE_PRIVILEGE_V2: {
                data = RolePrivilegeCollectionInfo.read(in);
                isRead = true;
                break;
            }
            case OperationType.OP_MV_JOB_STATE:
                data = MVMaintenanceJob.read(in);
                isRead = true;
                break;
            case OperationType.OP_MV_EPOCH_UPDATE:
                data = MVEpoch.read(in);
                isRead = true;
                break;
            case OperationType.OP_MODIFY_TABLE_ADD_OR_DROP_COLUMNS:
                data = TableAddOrDropColumnsInfo.read(in);
                isRead = true;
                break;
            case OperationType.OP_SET_DEFAULT_STORAGE_VOLUME:
                data = SetDefaultStorageVolumeLog.read(in);
                isRead = true;
                break;
            case OperationType.OP_DROP_STORAGE_VOLUME:
                data = DropStorageVolumeLog.read(in);
                isRead = true;
                break;
            case OperationType.OP_CREATE_STORAGE_VOLUME:
            case OperationType.OP_UPDATE_STORAGE_VOLUME:
                data = StorageVolume.read(in);
                isRead = true;
                break;
            case OperationType.OP_PIPE:
                data = PipeOpEntry.read(in);
                isRead = true;
                break;
            case OperationType.OP_CREATE_DICTIONARY:
                data = Dictionary.read(in);
                isRead = true;
                break;
            case OperationType.OP_DROP_DICTIONARY:
                data = DropDictionaryInfo.read(in);
                isRead = true;
                break;
            case OperationType.OP_MODIFY_DICTIONARY_MGR:
                data = DictionaryMgrInfo.read(in);
                isRead = true;
                break;
            case OperationType.OP_DECOMMISSION_DISK:
                data = GsonUtils.GSON.fromJson(Text.readString(in), DecommissionDiskInfo.class);
                isRead = true;
                break;
            case OperationType.OP_CANCEL_DECOMMISSION_DISK:
                data = GsonUtils.GSON.fromJson(Text.readString(in), CancelDecommissionDiskInfo.class);
                isRead = true;
                break;
            case OperationType.OP_DISABLE_DISK:
                data = GsonUtils.GSON.fromJson(Text.readString(in), DisableDiskInfo.class);
                isRead = true;
                break;
            case OperationType.OP_CANCEL_DISABLE_DISK:
                data = GsonUtils.GSON.fromJson(Text.readString(in), CancelDisableDiskInfo.class);
                isRead = true;
                break;
            case OperationType.OP_REPLICATION_JOB:
                data = ReplicationJobLog.read(in);
                isRead = true;
                break;
            default: {
                if (Config.ignore_unknown_log_id) {
                    LOG.warn("UNKNOWN Operation Type {}", opCode);
                    isRead = true;
                } else {
                    throw new IOException("UNKNOWN Operation Type " + opCode);
                }
            }
        } // end switch
        Preconditions.checkState(isRead);
    }
}