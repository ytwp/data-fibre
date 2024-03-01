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

import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import io.datafibre.fibre.catalog.*;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.common.UserException;
import io.datafibre.fibre.common.util.concurrent.lock.LockType;
import io.datafibre.fibre.common.util.concurrent.lock.Locker;
import io.datafibre.fibre.lake.compaction.CompactionMgr;
import io.datafibre.fibre.lake.compaction.PartitionIdentifier;
import io.datafibre.fibre.qe.ShowResultSet;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.server.RunMode;
import io.datafibre.fibre.sql.ast.AlterClause;
import io.datafibre.fibre.sql.ast.CancelStmt;
import io.datafibre.fibre.sql.ast.CompactionClause;
import io.datafibre.fibre.task.*;
import org.apache.commons.lang.NotImplementedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

public class CompactionHandler extends AlterHandler {
    private static final Logger LOG = LogManager.getLogger(CompactionHandler.class);

    public CompactionHandler() {
        super("compaction");
    }


    @Override
    protected void runAfterCatalogReady() {
        super.runAfterCatalogReady();
    }

    @Override
    public List<List<Comparable>> getAlterJobInfosByDb(Database db) {
        throw new NotImplementedException();
    }

    @Override
    // add synchronized to avoid process 2 or more stmts at same time
    public synchronized ShowResultSet process(List<AlterClause> alterClauses, Database db,
                                              OlapTable olapTable) throws UserException {
        //alterClauses必须是一个，必须是CompactionClause
        Preconditions.checkArgument(alterClauses.size() == 1);
        AlterClause alterClause = alterClauses.get(0);
        Preconditions.checkState(alterClause instanceof CompactionClause);
        //
        CompactionClause compactionClause = (CompactionClause) alterClause;
        if (RunMode.isSharedDataMode()) {
            // 存算分离
            // 获取要压缩的分区（全部 or 指定）
            List<Partition> allPartitions = findAllPartitions(olapTable, compactionClause);
            for (Partition partition : allPartitions) {
                PartitionIdentifier partitionIdentifier =
                        new PartitionIdentifier(db.getId(), olapTable.getId(), partition.getId());
                CompactionMgr compactionManager = GlobalStateMgr.getCurrentState().getCompactionMgr();
                //触发手动压缩
                compactionManager.triggerManualCompaction(partitionIdentifier);
            }
        } else {
            // 存算一体
            // ArrayListMultimap是Google Guava库中的一种数据结构，允许你用一个键映射到多个值
            ArrayListMultimap<Long, Long> backendToTablets = ArrayListMultimap.create();
            // 安 backend 分组 task
            AgentBatchTask batchTask = new AgentBatchTask();

            Locker locker = new Locker();
            // Database 的读锁
            locker.lockDatabase(db, LockType.READ);
            try {
                List<Partition> allPartitions = findAllPartitions(olapTable, compactionClause);
                for (Partition partition : allPartitions) {
                    // 获取二级分区
                    for (PhysicalPartition physicalPartition : partition.getSubPartitions()) {
                        // 获取每个分区的索引
                        for (MaterializedIndex index : physicalPartition.getMaterializedIndices(
                                MaterializedIndex.IndexExtState.VISIBLE)) {
                            // 获取存储单位
                            for (Tablet tablet : index.getTablets()) {
                                //遍历 存储单位 的每个节点
                                for (Long backendId : ((LocalTablet) tablet).getBackendIds()) {
                                    backendToTablets.put(backendId, tablet.getId());
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                throw new UserException(e.getMessage());
            } finally {
                locker.unLockDatabase(db, LockType.READ);
            }

            for (Long backendId : backendToTablets.keySet()) {
                // 对每个节点的存储单位进行压缩
                CompactionTask task = new CompactionTask(null, backendId,
                        db.getId(),
                        olapTable.getId(),
                        backendToTablets.get(backendId),
                        ((CompactionClause) alterClause).isBaseCompaction()
                );

                // add task to send
                batchTask.addTask(task);
            }
            if (batchTask.getTaskNum() > 0) {
                for (AgentTask task : batchTask.getAllTasks()) {
                    AgentTaskQueue.addTask(task);
                }
                //去执行
                AgentTaskExecutor.submit(batchTask);
                LOG.debug("tablet[{}] send compaction task. num: {}", batchTask.getTaskNum());
            }
        }
        return null;
    }

    @NotNull
    private List<Partition> findAllPartitions(OlapTable olapTable, CompactionClause compactionClause) {
        List<Partition> allPartitions = new ArrayList<>();
        if (compactionClause.getPartitionNames().isEmpty()) {
            //没指定，返回全部分区
            allPartitions.addAll(olapTable.getPartitions());
        } else {
            // 返回指定分区，没找到报错
            compactionClause.getPartitionNames().stream()
                    .map(partitionName -> new SimpleEntry<>(partitionName, olapTable.getPartition(partitionName)))
                    .forEach(entry -> {
                        Partition p = entry.getValue();
                        if (p == null) {
                            throw new RuntimeException("Partition not found: " + entry.getKey());
                        }
                        allPartitions.add(p);
                    });
        }
        return allPartitions;
    }

    @Override
    public synchronized void cancel(CancelStmt stmt) throws DdlException {
        throw new NotImplementedException();
    }

}
