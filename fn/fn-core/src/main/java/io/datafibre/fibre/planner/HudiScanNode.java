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

package io.datafibre.fibre.planner;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.datafibre.fibre.analysis.DescriptorTable;
import io.datafibre.fibre.analysis.SlotDescriptor;
import io.datafibre.fibre.analysis.TupleDescriptor;
import io.datafibre.fibre.catalog.HudiTable;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.connector.CatalogConnector;
import io.datafibre.fibre.connector.RemoteScanRangeLocations;
import io.datafibre.fibre.credential.CloudConfiguration;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.plan.HDFSScanNodePredicates;
import io.datafibre.fibre.thrift.TExplainLevel;
import io.datafibre.fibre.thrift.THdfsScanNode;
import io.datafibre.fibre.thrift.TPlanNode;
import io.datafibre.fibre.thrift.TPlanNodeType;
import io.datafibre.fibre.thrift.TScanRangeLocations;

import java.util.List;

public class HudiScanNode extends ScanNode {
    private final RemoteScanRangeLocations scanRangeLocations = new RemoteScanRangeLocations();

    private final HudiTable hudiTable;
    private final HDFSScanNodePredicates scanNodePredicates = new HDFSScanNodePredicates();
    private CloudConfiguration cloudConfiguration = null;

    private DescriptorTable descTbl;

    public HudiScanNode(PlanNodeId id, TupleDescriptor desc, String planNodeName) {
        super(id, desc, planNodeName);
        this.hudiTable = (HudiTable) desc.getTable();
        setupCloudCredential();
    }

    public HDFSScanNodePredicates getScanNodePredicates() {
        return scanNodePredicates;
    }

    public HudiTable getHudiTable() {
        return hudiTable;
    }

    @Override
    protected String debugString() {
        MoreObjects.ToStringHelper helper = MoreObjects.toStringHelper(this);
        helper.addValue(super.debugString());
        helper.addValue("hudiTable=" + hudiTable.getName());
        return helper.toString();
    }

    public void setupScanRangeLocations(DescriptorTable descTbl) {
        this.descTbl = descTbl;
        scanRangeLocations.setup(descTbl, hudiTable, scanNodePredicates);
    }

    private void setupCloudCredential() {
        String catalog = hudiTable.getCatalogName();
        if (catalog == null) {
            return;
        }
        CatalogConnector connector = GlobalStateMgr.getCurrentState().getConnectorMgr().getConnector(catalog);
        Preconditions.checkState(connector != null,
                String.format("connector of catalog %s should not be null", catalog));
        cloudConfiguration = connector.getMetadata().getCloudConfiguration();
        Preconditions.checkState(cloudConfiguration != null,
                String.format("cloudConfiguration of catalog %s should not be null", catalog));
    }

    @Override
    public List<TScanRangeLocations> getScanRangeLocations(long maxScanRangeLength) {
        return scanRangeLocations.getScanRangeLocations(descTbl, hudiTable, scanNodePredicates);
    }

    @Override
    protected String getNodeExplainString(String prefix, TExplainLevel detailLevel) {
        StringBuilder output = new StringBuilder();

        output.append(prefix).append("TABLE: ").append(hudiTable.getName()).append("\n");

        if (null != sortColumn) {
            output.append(prefix).append("SORT COLUMN: ").append(sortColumn).append("\n");
        }
        if (!scanNodePredicates.getPartitionConjuncts().isEmpty()) {
            output.append(prefix).append("PARTITION PREDICATES: ").append(
                    getExplainString(scanNodePredicates.getPartitionConjuncts())).append("\n");
        }
        if (!scanNodePredicates.getNonPartitionConjuncts().isEmpty()) {
            output.append(prefix).append("NON-PARTITION PREDICATES: ").append(
                    getExplainString(scanNodePredicates.getNonPartitionConjuncts())).append("\n");
        }
        if (!scanNodePredicates.getMinMaxConjuncts().isEmpty()) {
            output.append(prefix).append("MIN/MAX PREDICATES: ").append(
                    getExplainString(scanNodePredicates.getMinMaxConjuncts())).append("\n");
        }

        output.append(prefix).append(
                String.format("partitions=%s/%s", scanNodePredicates.getSelectedPartitionIds().size(),
                        scanNodePredicates.getIdToPartitionKey().size()));
        output.append("\n");

        output.append(prefix).append(String.format("cardinality=%s", cardinality));
        output.append("\n");

        output.append(prefix).append(String.format("avgRowSize=%s", avgRowSize));
        output.append("\n");

        if (detailLevel == TExplainLevel.VERBOSE) {
            for (SlotDescriptor slotDescriptor : desc.getSlots()) {
                Type type = slotDescriptor.getOriginType();
                if (type.isComplexType()) {
                    output.append(prefix)
                            .append(String.format("Pruned type: %d <-> [%s]\n", slotDescriptor.getId().asInt(), type));
                }
            }
        }

        return output.toString();
    }

    @Override
    public int getNumInstances() {
        return scanRangeLocations.getScanRangeLocationsSize();
    }

    @Override
    protected void toThrift(TPlanNode msg) {
        msg.node_type = TPlanNodeType.HDFS_SCAN_NODE;
        THdfsScanNode tHdfsScanNode = new THdfsScanNode();
        tHdfsScanNode.setTuple_id(desc.getId().asInt());
        msg.hdfs_scan_node = tHdfsScanNode;

        if (hudiTable != null) {
            msg.hdfs_scan_node.setHive_column_names(hudiTable.getDataColumnNames());
            msg.hdfs_scan_node.setTable_name(hudiTable.getName());
        }

        HdfsScanNode.setScanOptimizeOptionToThrift(tHdfsScanNode, this);
        HdfsScanNode.setCloudConfigurationToThrift(tHdfsScanNode, cloudConfiguration);
        HdfsScanNode.setNonEvalPartitionConjunctsToThrift(tHdfsScanNode, this, this.getScanNodePredicates());
        HdfsScanNode.setMinMaxConjunctsToThrift(tHdfsScanNode, this, this.getScanNodePredicates());
        HdfsScanNode.setNonPartitionConjunctsToThrift(msg, this, this.getScanNodePredicates());
    }

    @Override
    public boolean canUseRuntimeAdaptiveDop() {
        return true;
    }
}
