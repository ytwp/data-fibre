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

package io.datafibre.fibre.lake.vacuum;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.PhysicalPartition;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.Tablet;
import io.datafibre.fibre.common.Config;
import io.datafibre.fibre.common.util.FrontendDaemon;
import io.datafibre.fibre.common.util.concurrent.lock.LockType;
import io.datafibre.fibre.common.util.concurrent.lock.Locker;
import io.datafibre.fibre.lake.LakeTablet;
import io.datafibre.fibre.lake.Utils;
import io.datafibre.fibre.proto.VacuumRequest;
import io.datafibre.fibre.proto.VacuumResponse;
import io.datafibre.fibre.rpc.BrpcProxy;
import io.datafibre.fibre.rpc.LakeService;
import io.datafibre.fibre.rpc.RpcException;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.system.ComputeNode;
import org.apache.hadoop.util.BlockingThreadPoolExecutorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class AutovacuumDaemon extends FrontendDaemon {
    private static final Logger LOG = LogManager.getLogger(AutovacuumDaemon.class);

    private static final long MILLISECONDS_PER_SECOND = 1000;
    private static final long SECONDS_PER_MINUTE = 60;
    private static final long MINUTES_PER_HOUR = 60;
    private static final long MILLISECONDS_PER_HOUR = MINUTES_PER_HOUR * SECONDS_PER_MINUTE * MILLISECONDS_PER_SECOND;

    private final Set<Long> vacuumingPartitions = Sets.newConcurrentHashSet();
    private final BlockingThreadPoolExecutorService executorService = BlockingThreadPoolExecutorService.newInstance(
            Config.lake_autovacuum_parallel_partitions, 0, 1, TimeUnit.HOURS, "autovacuum");

    public AutovacuumDaemon() {
        super("autovacuum", 2000);
    }

    @Override
    protected void runAfterCatalogReady() {
        List<Long> dbIds = GlobalStateMgr.getCurrentState().getLocalMetastore().getDbIds();
        for (Long dbId : dbIds) {
            Database db = GlobalStateMgr.getCurrentState().getDb(dbId);
            if (db == null) {
                continue;
            }

            List<Table> tables;
            Locker locker = new Locker();
            locker.lockDatabase(db, LockType.READ);
            try {
                tables = db.getTables().stream().filter(Table::isCloudNativeTableOrMaterializedView)
                        .collect(Collectors.toList());
            } finally {
                locker.unLockDatabase(db, LockType.READ);
            }

            for (Table table : tables) {
                vacuumTable(db, table);
            }
        }
    }

    private void vacuumTable(Database db, Table baseTable) {
        OlapTable table = (OlapTable) baseTable;
        List<PhysicalPartition> partitions;
        long current = System.currentTimeMillis();
        long staleTime = current - Config.lake_autovacuum_stale_partition_threshold * MILLISECONDS_PER_HOUR;

        Locker locker = new Locker();
        locker.lockDatabase(db, LockType.READ);
        try {
            partitions = table.getPhysicalPartitions().stream()
                    .filter(p -> p.getVisibleVersionTime() > staleTime)
                    .filter(p -> p.getVisibleVersion() > 1) // filter out empty partition
                    .filter(p -> current >=
                            p.getLastVacuumTime() + Config.lake_autovacuum_partition_naptime_seconds * 1000)
                    .collect(Collectors.toList());
        } finally {
            locker.unLockDatabase(db, LockType.READ);
        }

        for (PhysicalPartition partition : partitions) {
            if (vacuumingPartitions.add(partition.getId())) {
                executorService.execute(() -> vacuumPartition(db, table, partition));
            }
        }
    }

    private void vacuumPartition(Database db, OlapTable table, PhysicalPartition partition) {
        try {
            vacuumPartitionImpl(db, table, partition);
        } finally {
            vacuumingPartitions.remove(partition.getId());
        }
    }

    private void vacuumPartitionImpl(Database db, OlapTable table, PhysicalPartition partition) {
        List<Tablet> tablets;
        long visibleVersion;
        long minRetainVersion;
        long startTime = System.currentTimeMillis();
        long minActiveTxnId = computeMinActiveTxnId(db, table);
        Map<ComputeNode, List<Long>> nodeToTablets = new HashMap<>();

        Locker locker = new Locker();
        locker.lockDatabase(db, LockType.READ);
        try {
            tablets = partition.getBaseIndex().getTablets();
            visibleVersion = partition.getVisibleVersion();
            minRetainVersion = partition.getMinRetainVersion();
            if (minRetainVersion <= 0) {
                minRetainVersion = Math.max(1, visibleVersion - Config.lake_autovacuum_max_previous_versions);
            }
        } finally {
            locker.unLockDatabase(db, LockType.READ);
        }

        for (Tablet tablet : tablets) {
            ComputeNode node = Utils.chooseNode((LakeTablet) tablet);
            if (node == null) {
                return;
            }
            nodeToTablets.computeIfAbsent(node, k -> Lists.newArrayList()).add(tablet.getId());
        }

        boolean hasError = false;
        long vacuumedFiles = 0;
        long vacuumedFileSize = 0;
        boolean needDeleteTxnLog = true;
        List<Future<VacuumResponse>> responseFutures = Lists.newArrayListWithCapacity(nodeToTablets.size());
        for (Map.Entry<ComputeNode, List<Long>> entry : nodeToTablets.entrySet()) {
            ComputeNode node = entry.getKey();
            VacuumRequest vacuumRequest = new VacuumRequest();
            vacuumRequest.tabletIds = entry.getValue();
            vacuumRequest.minRetainVersion = minRetainVersion;
            vacuumRequest.graceTimestamp =
                    startTime / MILLISECONDS_PER_SECOND - Config.lake_autovacuum_grace_period_minutes * 60;
            vacuumRequest.minActiveTxnId = minActiveTxnId;
            vacuumRequest.partitionId = partition.getId();
            vacuumRequest.deleteTxnLog = needDeleteTxnLog;
            // Perform deletion of txn log on the first node only.
            needDeleteTxnLog = false;
            try {
                LakeService service = BrpcProxy.getLakeService(node.getHost(), node.getBrpcPort());
                responseFutures.add(service.vacuum(vacuumRequest));
            } catch (RpcException e) {
                LOG.error("failed to send vacuum request for partition {}.{}.{}", db.getFullName(), table.getName(),
                        partition.getId(), e);
                hasError = true;
                break;
            }
        }

        for (Future<VacuumResponse> responseFuture : responseFutures) {
            try {
                VacuumResponse response = responseFuture.get();
                if (response.status.statusCode != 0) {
                    hasError = true;
                    LOG.warn("Vacuumed {}.{}.{} with error: {}", db.getFullName(), table.getName(), partition.getId(),
                            response.status.errorMsgs.get(0));
                } else {
                    vacuumedFiles += response.vacuumedFiles;
                    vacuumedFileSize += response.vacuumedFileSize;
                }
            } catch (InterruptedException e) {
                LOG.warn("thread interrupted");
                Thread.currentThread().interrupt();
                hasError = true;
            } catch (ExecutionException e) {
                LOG.error("failed to vacuum {}.{}.{}: {}", db.getFullName(), table.getName(), partition.getId(),
                        e.getMessage());
                hasError = true;
            }
        }

        partition.setLastVacuumTime(startTime);
        LOG.info("Vacuumed {}.{}.{} hasError={} vacuumedFiles={} vacuumedFileSize={} " +
                        "visibleVersion={} minRetainVersion={} minActiveTxnId={} cost={}ms",
                db.getFullName(), table.getName(), partition.getId(), hasError, vacuumedFiles, vacuumedFileSize,
                visibleVersion, minRetainVersion, minActiveTxnId, System.currentTimeMillis() - startTime);
    }

    private static long computeMinActiveTxnId(Database db, Table table) {
        long a = GlobalStateMgr.getCurrentState().getGlobalTransactionMgr().getMinActiveTxnIdOfDatabase(db.getId());
        Optional<Long> b =
                GlobalStateMgr.getCurrentState().getSchemaChangeHandler().getActiveTxnIdOfTable(table.getId());
        return Math.min(a, b.orElse(Long.MAX_VALUE));
    }
}
