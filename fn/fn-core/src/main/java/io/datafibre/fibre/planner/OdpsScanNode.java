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

import com.aliyun.odps.table.read.split.InputSplit;
import com.aliyun.odps.table.read.split.impl.IndexedInputSplit;
import com.aliyun.odps.table.read.split.impl.RowRangeInputSplit;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.datafibre.fibre.analysis.TupleDescriptor;
import io.datafibre.fibre.catalog.OdpsTable;
import io.datafibre.fibre.catalog.PartitionKey;
import io.datafibre.fibre.connector.CatalogConnector;
import io.datafibre.fibre.connector.RemoteFileDesc;
import io.datafibre.fibre.connector.RemoteFileInfo;
import io.datafibre.fibre.connector.exception.StarRocksConnectorException;
import io.datafibre.fibre.connector.odps.OdpsSplitsInfo;
import io.datafibre.fibre.credential.CloudConfiguration;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;
import io.datafibre.fibre.sql.plan.HDFSScanNodePredicates;
import io.datafibre.fibre.thrift.TCloudConfiguration;
import io.datafibre.fibre.thrift.TCloudType;
import io.datafibre.fibre.thrift.TExplainLevel;
import io.datafibre.fibre.thrift.THdfsScanNode;
import io.datafibre.fibre.thrift.THdfsScanRange;
import io.datafibre.fibre.thrift.TPlanNode;
import io.datafibre.fibre.thrift.TPlanNodeType;
import io.datafibre.fibre.thrift.TScanRange;
import io.datafibre.fibre.thrift.TScanRangeLocations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * full scan on ODPS table.
 */
public class OdpsScanNode extends ScanNode {
    private static final Logger LOG = LogManager.getLogger(OdpsScanNode.class);
    private OdpsTable table;
    private CloudConfiguration cloudConfiguration = null;
    private final HDFSScanNodePredicates scanNodePredicates = new HDFSScanNodePredicates();

    private final List<TScanRangeLocations> scanRangeLocationsList = new ArrayList<>();

    public OdpsScanNode(PlanNodeId id, TupleDescriptor desc, String planNodeName) {
        super(id, desc, planNodeName);
        table = (OdpsTable) desc.getTable();
        setupCloudCredential();
    }

    public HDFSScanNodePredicates getScanNodePredicates() {
        return scanNodePredicates;
    }

    private void setupCloudCredential() {
        String catalog = table.getCatalogName();
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

    public void setupScanRangeLocations(TupleDescriptor tupleDescriptor, ScalarOperator predicate,
                                        List<PartitionKey> partitionKeys) {
        List<String> fieldNames =
                tupleDescriptor.getSlots().stream().map(s -> s.getColumn().getName()).collect(Collectors.toList());
        List<RemoteFileInfo> fileInfos = GlobalStateMgr.getCurrentState().getMetadataMgr().getRemoteFileInfos(
                table.getCatalogName(), table, partitionKeys, -1, predicate, fieldNames, -1);
        RemoteFileDesc remoteFileDesc = fileInfos.get(0).getFiles().get(0);
        OdpsSplitsInfo splitsInfo = remoteFileDesc.getOdpsSplitsInfo();
        if (splitsInfo.isEmpty()) {
            LOG.warn("There is no odps splits on {}.{} and predicate: [{}]",
                    table.getDbName(), table.getTableName(), predicate);
            return;
        }
        Map<String, String> commonSplitInfo = new HashMap<>();
        String serializeSession = splitsInfo.getSerializeSession();
        commonSplitInfo.put("read_session", serializeSession);
        commonSplitInfo.putAll(splitsInfo.getProperties());
        commonSplitInfo.put("split_policy", splitsInfo.getSplitPolicy().name().toLowerCase());
        for (InputSplit inputSplit : splitsInfo.getSplits()) {
            TScanRangeLocations scanRangeLocations = new TScanRangeLocations();
            THdfsScanRange hdfsScanRange = new THdfsScanRange();
            Map<String, String> splitInfo = new HashMap<>(commonSplitInfo);
            splitInfo.put("session_id", inputSplit.getSessionId());
            switch (splitsInfo.getSplitPolicy()) {
                case SIZE:
                    IndexedInputSplit split = (IndexedInputSplit) inputSplit;
                    splitInfo.put("split_index", String.valueOf(split.getSplitIndex()));
                    break;
                case ROW_OFFSET:
                    RowRangeInputSplit split1 = (RowRangeInputSplit) inputSplit;
                    splitInfo.put("start_index", String.valueOf(split1.getRowRange().getStartIndex()));
                    splitInfo.put("num_record", String.valueOf(split1.getRowRange().getNumRecord()));
                    break;
                default:
                    throw new StarRocksConnectorException(
                            "unsupported split policy: " + splitsInfo.getSplitPolicy().name());
            }
            hdfsScanRange.setOdps_split_infos(splitInfo);
            hdfsScanRange.setUse_odps_jni_reader(true);
            hdfsScanRange.setFile_length(1);
            // backend selector use length to load balancing
            hdfsScanRange.setLength(1);
            TScanRange scanRange = new TScanRange();
            scanRange.setHdfs_scan_range(hdfsScanRange);
            scanRangeLocations.setScan_range(scanRange);
            io.datafibre.fibre.thrift.TScanRangeLocation
                    scanRangeLocation =
                    new io.datafibre.fibre.thrift.TScanRangeLocation(new io.datafibre.fibre.thrift.TNetworkAddress("-1", -1));
            scanRangeLocations.addToLocations(scanRangeLocation);
            scanRangeLocationsList.add(scanRangeLocations);
        }
    }

    @Override
    public List<TScanRangeLocations> getScanRangeLocations(long maxScanRangeLength) {
        //TODO (zhangdingxin.zdx) support max scan range length ?
        return scanRangeLocationsList;
    }

    @Override
    protected String debugString() {
        MoreObjects.ToStringHelper helper = MoreObjects.toStringHelper(this);
        helper.addValue(super.debugString());
        helper.addValue("odpsTable=" + table.getName());
        return helper.toString();
    }


    @Override
    protected String getNodeExplainString(String prefix, TExplainLevel detailLevel) {
        StringBuilder output = new StringBuilder();
        output.append(prefix).append("TABLE: ").append(table.getDbName()).append(".").append(table.getTableName())
                .append("\n");
        return output.toString();
    }

    @Override
    public boolean canUseRuntimeAdaptiveDop() {
        return true;
    }

    @Override
    protected void toThrift(TPlanNode msg) {
        msg.node_type = TPlanNodeType.HDFS_SCAN_NODE;
        THdfsScanNode tHdfsScanNode = new THdfsScanNode();
        tHdfsScanNode.setTuple_id(desc.getId().asInt());
        tHdfsScanNode.setCan_use_min_max_count_opt(false);

        String explainString = getExplainString(conjuncts);
        LOG.info("Explain string: " + explainString);
        tHdfsScanNode.setSql_predicates(explainString);

        if (table != null) {
            tHdfsScanNode.setTable_name(table.getTableName());
        }
        HdfsScanNode.setScanOptimizeOptionToThrift(tHdfsScanNode, this);
        TCloudConfiguration tCloudConfiguration = new TCloudConfiguration();
        cloudConfiguration.toThrift(tCloudConfiguration);
        tCloudConfiguration.setCloud_type(TCloudType.ALIYUN);
        tHdfsScanNode.setCloud_configuration(tCloudConfiguration);
        msg.hdfs_scan_node = tHdfsScanNode;
    }

    @Override
    public int getNumInstances() {
        return scanRangeLocationsList.size();
    }

}
