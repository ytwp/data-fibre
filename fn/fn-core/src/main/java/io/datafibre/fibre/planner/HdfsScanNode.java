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
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.SlotDescriptor;
import io.datafibre.fibre.analysis.TupleDescriptor;
import io.datafibre.fibre.catalog.HiveTable;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.connector.CatalogConnector;
import io.datafibre.fibre.connector.RemoteScanRangeLocations;
import io.datafibre.fibre.credential.CloudConfiguration;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.optimizer.ScanOptimzeOption;
import io.datafibre.fibre.sql.plan.HDFSScanNodePredicates;
import io.datafibre.fibre.thrift.TCloudConfiguration;
import io.datafibre.fibre.thrift.TExplainLevel;
import io.datafibre.fibre.thrift.THdfsScanNode;
import io.datafibre.fibre.thrift.TPlanNode;
import io.datafibre.fibre.thrift.TPlanNodeType;
import io.datafibre.fibre.thrift.TScanRangeLocations;

import java.util.List;

import static io.datafibre.fibre.thrift.TExplainLevel.VERBOSE;

/**
 * Scan node for HDFS files, like hive table.
 * <p>
 * The class is responsible for
 * 1. Partition pruning: filter out irrelevant partitions based on the conjuncts
 * and table partition schema.
 * 2. Min-max pruning: creates an additional list of conjuncts that are used to
 * prune a row group if any fail the row group's min-max parquet::Statistics.
 * 3. Get scan range locations.
 * 4. Compute stats, like cardinality, avgRowSize.
 * <p>
 * TODO: Dictionary pruning
 */
public class HdfsScanNode extends ScanNode {
    private final RemoteScanRangeLocations scanRangeLocations = new RemoteScanRangeLocations();

    private HiveTable hiveTable = null;
    private CloudConfiguration cloudConfiguration = null;
    private final HDFSScanNodePredicates scanNodePredicates = new HDFSScanNodePredicates();

    private DescriptorTable descTbl;

    public HdfsScanNode(PlanNodeId id, TupleDescriptor desc, String planNodeName) {
        super(id, desc, planNodeName);
        hiveTable = (HiveTable) desc.getTable();
        setupCloudCredential();
    }

    public HDFSScanNodePredicates getScanNodePredicates() {
        return scanNodePredicates;
    }

    public HiveTable getHiveTable() {
        return hiveTable;
    }

    @Override
    protected String debugString() {
        MoreObjects.ToStringHelper helper = MoreObjects.toStringHelper(this);
        helper.addValue(super.debugString());
        helper.addValue("hiveTable=" + hiveTable.getName());
        return helper.toString();
    }

    public void setupScanRangeLocations(DescriptorTable descTbl) {
        this.descTbl = descTbl;
        scanRangeLocations.setup(descTbl, hiveTable, scanNodePredicates);
    }

    private void setupCloudCredential() {
        String catalog = hiveTable.getCatalogName();
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
        return scanRangeLocations.getScanRangeLocations(descTbl, hiveTable, scanNodePredicates);
    }

    @Override
    protected String getNodeExplainString(String prefix, TExplainLevel detailLevel) {
        StringBuilder output = new StringBuilder();

        output.append(prefix).append("TABLE: ").append(hiveTable.getName()).append("\n");

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
        if (!scanNodePredicates.getNoEvalPartitionConjuncts().isEmpty()) {
            output.append(prefix).append("NO EVAL-PARTITION PREDICATES: ").append(
                    getExplainString(scanNodePredicates.getNoEvalPartitionConjuncts())).append("\n");
        }
        if (!scanNodePredicates.getMinMaxConjuncts().isEmpty()) {
            output.append(prefix).append("MIN/MAX PREDICATES: ").append(
                    getExplainString(scanNodePredicates.getMinMaxConjuncts())).append("\n");
        }

        output.append(prefix).append(
                String.format("partitions=%s/%s", scanNodePredicates.getSelectedPartitionIds().size(),
                        scanNodePredicates.getIdToPartitionKey().size()));
        output.append("\n");

        // TODO: support it in verbose
        if (detailLevel != VERBOSE) {
            output.append(prefix).append(String.format("cardinality=%s", cardinality));
            output.append("\n");
        }

        output.append(prefix).append(String.format("avgRowSize=%s", avgRowSize));
        output.append("\n");

        if (detailLevel == TExplainLevel.VERBOSE) {
            for (SlotDescriptor slotDescriptor : desc.getSlots()) {
                Type type = slotDescriptor.getOriginType();
                if (type.isComplexType()) {
                    output.append(prefix)
                            .append(String.format("Pruned type: %d [%s] <-> [%s]\n", slotDescriptor.getId().asInt(), slotDescriptor.getColumn().getName(), type));
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

        if (hiveTable != null) {
            msg.hdfs_scan_node.setHive_column_names(hiveTable.getDataColumnNames());
            msg.hdfs_scan_node.setTable_name(hiveTable.getName());
        }

        setScanOptimizeOptionToThrift(tHdfsScanNode, this);
        setCloudConfigurationToThrift(tHdfsScanNode, cloudConfiguration);
        setNonEvalPartitionConjunctsToThrift(tHdfsScanNode, this, this.getScanNodePredicates());
        setMinMaxConjunctsToThrift(tHdfsScanNode, this, this.getScanNodePredicates());
        setNonPartitionConjunctsToThrift(msg, this, this.getScanNodePredicates());
    }

    public static void setScanOptimizeOptionToThrift(THdfsScanNode tHdfsScanNode, ScanNode scanNode) {
        ScanOptimzeOption option = scanNode.getScanOptimzeOption();
        tHdfsScanNode.setCan_use_any_column(option.getCanUseAnyColumn());
        tHdfsScanNode.setCan_use_min_max_count_opt(option.getCanUseMinMaxCountOpt());
        tHdfsScanNode.setUse_partition_column_value_only(option.getUsePartitionColumnValueOnly());
    }

    public static void setCloudConfigurationToThrift(THdfsScanNode tHdfsScanNode, CloudConfiguration cc) {
        if (cc != null) {
            TCloudConfiguration tCloudConfiguration = new TCloudConfiguration();
            cc.toThrift(tCloudConfiguration);
            tHdfsScanNode.setCloud_configuration(tCloudConfiguration);
        }
    }

    public static void setMinMaxConjunctsToThrift(THdfsScanNode tHdfsScanNode, ScanNode scanNode,
                                                  HDFSScanNodePredicates scanNodePredicates) {
        List<Expr> minMaxConjuncts = scanNodePredicates.getMinMaxConjuncts();
        if (!minMaxConjuncts.isEmpty()) {
            String minMaxSqlPredicate = scanNode.getExplainString(minMaxConjuncts);
            for (Expr expr : minMaxConjuncts) {
                tHdfsScanNode.addToMin_max_conjuncts(expr.treeToThrift());
            }
            tHdfsScanNode.setMin_max_tuple_id(scanNodePredicates.getMinMaxTuple().getId().asInt());
            tHdfsScanNode.setMin_max_sql_predicates(minMaxSqlPredicate);
        }
    }

    public static void setNonEvalPartitionConjunctsToThrift(THdfsScanNode tHdfsScanNode, ScanNode scanNode,
                                                            HDFSScanNodePredicates scanNodePredicates) {
        List<Expr> noEvalPartitionConjuncts = scanNodePredicates.getNoEvalPartitionConjuncts();
        String partitionSqlPredicate = scanNode.getExplainString(noEvalPartitionConjuncts);
        for (Expr expr : noEvalPartitionConjuncts) {
            tHdfsScanNode.addToPartition_conjuncts(expr.treeToThrift());
        }
        tHdfsScanNode.setPartition_sql_predicates(partitionSqlPredicate);
    }

    public static void setNonPartitionConjunctsToThrift(TPlanNode msg, ScanNode scanNode,
                                                        HDFSScanNodePredicates scanNodePredicates) {
        // put non-partition conjuncts into conjuncts
        if (msg.isSetConjuncts()) {
            msg.conjuncts.clear();
        }

        List<Expr> nonPartitionConjuncts = scanNodePredicates.getNonPartitionConjuncts();
        for (Expr expr : nonPartitionConjuncts) {
            msg.addToConjuncts(expr.treeToThrift());
        }
        String sqlPredicate = scanNode.getExplainString(nonPartitionConjuncts);
        msg.hdfs_scan_node.setSql_predicates(sqlPredicate);
    }

    @Override
    public boolean canUseRuntimeAdaptiveDop() {
        return true;
    }

    @Override
    protected boolean supportTopNRuntimeFilter() {
        return true;
    }
}
