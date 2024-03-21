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
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/common/proc/ClusterLoadStatisticProcDir.java

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

package io.datafibre.fibre.common.proc;

import com.google.common.collect.ImmutableList;
import io.datafibre.fibre.clone.ClusterLoadStatistic;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.system.Backend;
import io.datafibre.fibre.thrift.TStorageMedium;

// show proc "/cluster_balance/cluster_load_stat";
public class ClusterLoadStatisticProcDir implements ProcDirInterface {
    public static final ImmutableList<String> TITLE_NAMES = new ImmutableList.Builder<String>()
            .add("BeId").add("Cluster").add("Available").add("UsedCapacity").add("Capacity")
            .add("UsedPercent").add("ReplicaNum").add("CapCoeff").add("ReplCoeff").add("Score")
            .add("Class")
            .build();

    private TStorageMedium medium;

    public ClusterLoadStatisticProcDir(TStorageMedium medium) {
        this.medium = medium;
    }

    @Override
    public ProcResult fetchResult() throws AnalysisException {
        BaseProcResult result = new BaseProcResult();
        result.setNames(TITLE_NAMES);

        ClusterLoadStatistic statistic = GlobalStateMgr.getCurrentState().getTabletScheduler().getLoadStatistic();
        statistic.getClusterStatistic(medium).forEach(result::addRow);

        return result;
    }

    @Override
    public boolean register(String name, ProcNodeInterface node) {
        return false;
    }

    @Override
    public ProcNodeInterface lookup(String beIdStr) throws AnalysisException {
        long beId = -1L;
        try {
            beId = Long.valueOf(beIdStr);
        } catch (NumberFormatException e) {
            throw new AnalysisException("Invalid be id format: " + beIdStr);
        }

        Backend be = GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo().getBackend(beId);
        if (be == null) {
            throw new AnalysisException("backend " + beId + " does not exist");
        }
        return new BackendProcNode(be);
    }

}