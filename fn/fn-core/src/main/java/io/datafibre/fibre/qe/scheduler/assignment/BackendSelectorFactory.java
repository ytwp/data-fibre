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

package io.datafibre.fibre.qe.scheduler.assignment;

import com.starrocks.planner.*;
import com.starrocks.qe.*;
import com.starrocks.qe.scheduler.WorkerProvider;
import com.starrocks.qe.scheduler.dag.ExecutionFragment;
import com.starrocks.thrift.TScanRangeLocations;

import java.util.List;
import java.util.Set;

public class BackendSelectorFactory {
    private BackendSelectorFactory() {
    }

    public static BackendSelector create(ScanNode scanNode,
                                         boolean isLoadType,
                                         ExecutionFragment execFragment,
                                         WorkerProvider workerProvider,
                                         ConnectContext connectContext,
                                         Set<Integer> destReplicatedScanIds) {
        // The parameters of getScanRangeLocations may ignore, It doesn't take effect.
        List<TScanRangeLocations> locations = scanNode.getScanRangeLocations(0);
        if (locations == null) {
            return new NoopBackendSelector();
        }

        SessionVariable sessionVariable = connectContext.getSessionVariable();
        FragmentScanRangeAssignment assignment = execFragment.getScanRangeAssignment();

        if (scanNode instanceof SchemaScanNode) {
            return new NormalBackendSelector(scanNode, locations, assignment, workerProvider, false);
        } else if (scanNode instanceof HdfsScanNode || scanNode instanceof IcebergScanNode ||
                scanNode instanceof HudiScanNode || scanNode instanceof DeltaLakeScanNode ||
                scanNode instanceof FileTableScanNode || scanNode instanceof PaimonScanNode
                || scanNode instanceof OdpsScanNode) {
            return new HDFSBackendSelector(scanNode, locations, assignment, workerProvider,
                    sessionVariable.getForceScheduleLocal(),
                    sessionVariable.getHDFSBackendSelectorScanRangeShuffle());
        } else {
            boolean hasColocate = execFragment.isColocated();
            boolean hasBucket = execFragment.isLocalBucketShuffleJoin();
            boolean hasReplicated = execFragment.isReplicated();
            if (!assignment.isEmpty() && hasReplicated && scanNode.canDoReplicatedJoin()) {
                destReplicatedScanIds.add(scanNode.getId().asInt());
                return new ReplicatedBackendSelector(scanNode, locations, assignment,
                        execFragment.getColocatedAssignment());
            } else if (hasColocate || hasBucket) {
                ColocatedBackendSelector.Assignment colocatedAssignment =
                        execFragment.getOrCreateColocatedAssignment((OlapScanNode) scanNode);
                boolean isRightOrFullBucketShuffleFragment = execFragment.isRightOrFullBucketShuffle();
                return new ColocatedBackendSelector((OlapScanNode) scanNode, assignment,
                        colocatedAssignment, isRightOrFullBucketShuffleFragment, workerProvider,
                        sessionVariable.getMaxBucketsPerBeToUseBalancerAssignment());
            } else {
                return new NormalBackendSelector(scanNode, locations, assignment, workerProvider, isLoadType);
            }
        }
    }
}
