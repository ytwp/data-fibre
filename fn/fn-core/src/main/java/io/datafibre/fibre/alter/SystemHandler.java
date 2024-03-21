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
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/alter/SystemHandler.java

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

package io.datafibre.fibre.alter;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import io.datafibre.fibre.catalog.*;
import io.datafibre.fibre.common.Config;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.common.Pair;
import io.datafibre.fibre.common.UserException;
import io.datafibre.fibre.common.util.concurrent.lock.LockType;
import io.datafibre.fibre.common.util.concurrent.lock.Locker;
import io.datafibre.fibre.ha.FrontendNodeType;
import io.datafibre.fibre.qe.ShowResultSet;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.server.LocalMetastore;
import io.datafibre.fibre.server.RunMode;
import io.datafibre.fibre.sql.ast.*;
import io.datafibre.fibre.system.Backend;
import io.datafibre.fibre.system.SystemInfoService;
import org.apache.commons.lang.NotImplementedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * SystemHandler is for
 * 1. add/drop/decommission backends
 * 2. add/drop frontends
 * 3. add/drop/modify brokers
 * <p>
 * 1.添加/删除/停用 后端
 * 2.添加/删除 前端
 * 3.添加/删除/修改 代理
 */
public class SystemHandler extends AlterHandler {
    private static final Logger LOG = LogManager.getLogger(SystemHandler.class);

    private static final long MAX_REMAINED_TABLET_TO_CHECK_ON_DECOMM = 1000;

    public SystemHandler() {
        super("cluster");
    }

    @Override
    protected void runAfterCatalogReady() {
        super.runAfterCatalogReady();
        runAlterJobV2();
    }

    private void dropDecommissionedBackend(SystemInfoService systemInfoService, long beId) {
        try {
            systemInfoService.dropBackend(beId);
            LOG.info("no tablet on decommission backend {}, drop it", beId);
        } catch (DdlException e) {
            // does not matter, maybe backend not exists
            LOG.info("backend {} drop failed after decommission {}", beId, e.getMessage());
        }
    }

    // check all decommissioned backends, if there is no tablet on that backend, drop it.
    private void runAlterJobV2() {
        SystemInfoService systemInfoService = GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo();
        TabletInvertedIndex invertedIndex = GlobalStateMgr.getCurrentState().getTabletInvertedIndex();
        // check if decommission is finished
        for (Long beId : systemInfoService.getBackendIds(false)) {
            Backend backend = systemInfoService.getBackend(beId);
            if (backend == null || !backend.isDecommissioned()) {
                continue;
            }

            List<Long> backendTabletIds = invertedIndex.getTabletIdsByBackendId(beId);
            if (backendTabletIds.isEmpty()) {
                if (Config.drop_backend_after_decommission) {
                    dropDecommissionedBackend(systemInfoService, beId);
                }
            } else {
                LOG.info("backend {} lefts {} replicas to decommission(show up to 20): {}", beId,
                        backendTabletIds.size(),
                        backendTabletIds.stream().limit(20).collect(Collectors.toList()));
            }
        }
    }

    @Override
    public List<List<Comparable>> getAlterJobInfosByDb(Database db) {
        throw new NotImplementedException();
    }

    @Override
    // add synchronized to avoid process 2 or more stmts at same time
    public synchronized ShowResultSet process(List<AlterClause> alterClauses, Database dummyDb,
                                              OlapTable dummyTbl) throws UserException {
        Preconditions.checkArgument(alterClauses.size() == 1);
        AlterClause alterClause = alterClauses.get(0);
        if (alterClause instanceof AddBackendClause) {
            // add backend
            AddBackendClause addBackendClause = (AddBackendClause) alterClause;
            GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo().addBackends(addBackendClause.getHostPortPairs());
        } else if (alterClause instanceof ModifyBackendClause) {
            // update Backend Address
            ModifyBackendClause modifyBackendClause = (ModifyBackendClause) alterClause;
            return GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo().modifyBackend(modifyBackendClause);
        } else if (alterClause instanceof DropBackendClause) {
            // drop backend
            DropBackendClause dropBackendClause = (DropBackendClause) alterClause;
            GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo().dropBackends(dropBackendClause);
        } else if (alterClause instanceof DecommissionBackendClause) {
            // decommission
            DecommissionBackendClause decommissionBackendClause = (DecommissionBackendClause) alterClause;
            // check request
            List<Backend> decommissionBackends = checkDecommission(decommissionBackendClause);

            // set backend's state as 'decommissioned'
            // for decommission operation, here is no decommission job. the system handler will check
            // all backend in decommission state
            for (Backend backend : decommissionBackends) {
                backend.setDecommissioned(true);
                GlobalStateMgr.getCurrentState().getEditLog().logBackendStateChange(backend);
                LOG.info("set backend {} to decommission", backend.getId());
            }

        } else if (alterClause instanceof AddObserverClause) {
            AddObserverClause clause = (AddObserverClause) alterClause;
            GlobalStateMgr.getCurrentState().getNodeMgr()
                    .addFrontend(FrontendNodeType.OBSERVER, clause.getHost(), clause.getPort());
        } else if (alterClause instanceof DropObserverClause) {
            DropObserverClause clause = (DropObserverClause) alterClause;
            GlobalStateMgr.getCurrentState().getNodeMgr()
                    .dropFrontend(FrontendNodeType.OBSERVER, clause.getHost(), clause.getPort());
        } else if (alterClause instanceof AddFollowerClause) {
            AddFollowerClause clause = (AddFollowerClause) alterClause;
            GlobalStateMgr.getCurrentState().getNodeMgr()
                    .addFrontend(FrontendNodeType.FOLLOWER, clause.getHost(), clause.getPort());
        } else if (alterClause instanceof ModifyFrontendAddressClause) {
            // update Frontend Address
            ModifyFrontendAddressClause modifyFrontendAddressClause = (ModifyFrontendAddressClause) alterClause;
            GlobalStateMgr.getCurrentState().getNodeMgr().modifyFrontendHost(modifyFrontendAddressClause);
        } else if (alterClause instanceof DropFollowerClause) {
            DropFollowerClause clause = (DropFollowerClause) alterClause;
            GlobalStateMgr.getCurrentState().getNodeMgr()
                    .dropFrontend(FrontendNodeType.FOLLOWER, clause.getHost(), clause.getPort());
        } else if (alterClause instanceof ModifyBrokerClause) {
            ModifyBrokerClause clause = (ModifyBrokerClause) alterClause;
            GlobalStateMgr.getCurrentState().getBrokerMgr().execute(clause);
        } else if (alterClause instanceof AlterLoadErrorUrlClause) {
            AlterLoadErrorUrlClause clause = (AlterLoadErrorUrlClause) alterClause;
            GlobalStateMgr.getCurrentState().getLoadInstance().setLoadErrorHubInfo(clause.getProperties());
        } else if (alterClause instanceof AddComputeNodeClause) {
            AddComputeNodeClause addComputeNodeClause = (AddComputeNodeClause) alterClause;
            GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo()
                    .addComputeNodes(addComputeNodeClause.getHostPortPairs());
        } else if (alterClause instanceof DropComputeNodeClause) {
            DropComputeNodeClause dropComputeNodeClause = (DropComputeNodeClause) alterClause;
            GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo()
                    .dropComputeNodes(dropComputeNodeClause.getHostPortPairs());
        } else if (alterClause instanceof CreateImageClause) {
            GlobalStateMgr.getCurrentState().triggerNewImage();
        } else if (alterClause instanceof CleanTabletSchedQClause) {
            GlobalStateMgr.getCurrentState().getTabletScheduler().forceCleanSchedQ();
        } else {
            Preconditions.checkState(false, alterClause.getClass());
        }
        return null;
    }

    private List<Backend> checkDecommission(DecommissionBackendClause decommissionBackendClause)
            throws DdlException {
        return checkDecommission(decommissionBackendClause.getHostPortPairs());
    }

    /*
     * check if the specified backends can be decommissioned
     * 1. backend should exist.
     * 2. after decommission, the remaining backend num should meet the replication num.
     * 3. after decommission, The remaining space capacity can store data on decommissioned backends.
     */
    public static List<Backend> checkDecommission(List<Pair<String, Integer>> hostPortPairs)
            throws DdlException {
        SystemInfoService infoService = GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo();
        List<Backend> decommissionBackends = Lists.newArrayList();
        Set<Long> decommissionIds = new HashSet<>();

        long needCapacity = 0L;
        long releaseCapacity = 0L;
        // check if exist
        for (Pair<String, Integer> pair : hostPortPairs) {
            Backend backend = infoService.getBackendWithHeartbeatPort(pair.first, pair.second);
            if (backend == null) {
                throw new DdlException("Backend does not exist[" + pair.first + ":" + pair.second + "]");
            }
            if (backend.isDecommissioned()) {
                // already under decommission, ignore it
                LOG.info(backend.getAddress() + " has already been decommissioned and will be ignored.");
                continue;
            }
            needCapacity += backend.getDataUsedCapacityB();
            releaseCapacity += backend.getAvailableCapacityB();
            decommissionBackends.add(backend);
            decommissionIds.add(backend.getId());
        }

        if (decommissionBackends.isEmpty()) {
            LOG.info("No backends will be decommissioned.");
            return decommissionBackends;
        }

        // when decommission backends in shared_data mode, unnecessary to check clusterCapacity or table replica
        if (RunMode.isSharedDataMode()) {
            return decommissionBackends;
        }

        if (infoService.getClusterAvailableCapacityB() - releaseCapacity < needCapacity) {
            decommissionBackends.clear();
            throw new DdlException("It will cause insufficient disk space if these BEs are decommissioned.");
        }

        long availableBackendCnt = infoService.getAvailableBackendIds()
                .stream()
                .filter(beId -> !decommissionIds.contains(beId))
                .count();
        short maxReplicationNum = 0;
        LocalMetastore localMetastore = GlobalStateMgr.getCurrentState().getLocalMetastore();
        for (long dbId : localMetastore.getDbIds()) {
            Database db = localMetastore.getDb(dbId);
            if (db == null) {
                continue;
            }
            Locker locker = new Locker();
            locker.lockDatabase(db, LockType.READ);
            try {
                for (Table table : db.getTables()) {
                    if (table instanceof OlapTable) {
                        OlapTable olapTable = (OlapTable) table;
                        PartitionInfo partitionInfo = olapTable.getPartitionInfo();
                        for (long partitionId : olapTable.getAllPartitionIds()) {
                            short replicationNum = partitionInfo.getReplicationNum(partitionId);
                            if (replicationNum > maxReplicationNum) {
                                maxReplicationNum = replicationNum;
                                if (availableBackendCnt < maxReplicationNum) {
                                    decommissionBackends.clear();
                                    throw new DdlException(
                                            "It will cause insufficient BE number if these BEs are decommissioned " +
                                            "because the table " + db.getFullName() + "." + olapTable.getName() +
                                            " requires " + maxReplicationNum + " replicas.");

                                }
                            }
                        }
                    }
                }
            } finally {
                locker.unLockDatabase(db, LockType.READ);
            }
        }

        return decommissionBackends;
    }

    @Override
    public synchronized void cancel(CancelStmt stmt) throws DdlException {
        CancelAlterSystemStmt cancelAlterSystemStmt = (CancelAlterSystemStmt) stmt;

        SystemInfoService infoService = GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo();
        // check if backends is under decommission
        List<Backend> backends = Lists.newArrayList();
        List<Pair<String, Integer>> hostPortPairs = cancelAlterSystemStmt.getHostPortPairs();
        for (Pair<String, Integer> pair : hostPortPairs) {
            // check if exist
            Backend backend = infoService.getBackendWithHeartbeatPort(pair.first, pair.second);
            if (backend == null) {
                throw new DdlException("Backend does not exists[" + pair.first + "]");
            }

            if (!backend.isDecommissioned()) {
                // it's ok. just log
                LOG.info("backend is not decommissioned[{}]", pair.first);
                continue;
            }

            backends.add(backend);
        }

        for (Backend backend : backends) {
            if (backend.setDecommissioned(false)) {
                GlobalStateMgr.getCurrentState().getEditLog().logBackendStateChange(backend);
            } else {
                LOG.info("backend is not decommissioned[{}]", backend.getHost());
            }
        }
    }

}