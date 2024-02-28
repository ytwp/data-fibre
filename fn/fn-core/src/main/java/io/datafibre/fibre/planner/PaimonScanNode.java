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
import com.google.common.collect.Maps;
import io.datafibre.fibre.analysis.SlotDescriptor;
import io.datafibre.fibre.analysis.TupleDescriptor;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.PaimonTable;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.connector.CatalogConnector;
import io.datafibre.fibre.connector.RemoteFileDesc;
import io.datafibre.fibre.connector.RemoteFileInfo;
import io.datafibre.fibre.connector.paimon.PaimonSplitsInfo;
import io.datafibre.fibre.credential.CloudConfiguration;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;
import io.datafibre.fibre.sql.plan.HDFSScanNodePredicates;
import io.datafibre.fibre.thrift.TExplainLevel;
import io.datafibre.fibre.thrift.THdfsFileFormat;
import io.datafibre.fibre.thrift.THdfsScanNode;
import io.datafibre.fibre.thrift.THdfsScanRange;
import io.datafibre.fibre.thrift.TNetworkAddress;
import io.datafibre.fibre.thrift.TPlanNode;
import io.datafibre.fibre.thrift.TPlanNodeType;
import io.datafibre.fibre.thrift.TScanRange;
import io.datafibre.fibre.thrift.TScanRangeLocation;
import io.datafibre.fibre.thrift.TScanRangeLocations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.paimon.data.BinaryRow;
import org.apache.paimon.io.DataFileMeta;
import org.apache.paimon.table.source.DataSplit;
import org.apache.paimon.table.source.RawFile;
import org.apache.paimon.table.source.Split;
import org.apache.paimon.utils.InstantiationUtil;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static io.datafibre.fibre.thrift.TExplainLevel.VERBOSE;
import static java.nio.charset.StandardCharsets.UTF_8;

public class PaimonScanNode extends ScanNode {
    private static final Logger LOG = LogManager.getLogger(PaimonScanNode.class);
    private final AtomicLong partitionIdGen = new AtomicLong(0L);
    private final PaimonTable paimonTable;
    private final HDFSScanNodePredicates scanNodePredicates = new HDFSScanNodePredicates();
    private final List<TScanRangeLocations> scanRangeLocationsList = new ArrayList<>();
    private CloudConfiguration cloudConfiguration = null;

    public PaimonScanNode(PlanNodeId id, TupleDescriptor desc, String planNodeName) {
        super(id, desc, planNodeName);
        this.paimonTable = (PaimonTable) desc.getTable();
        setupCloudCredential();
    }

    public HDFSScanNodePredicates getScanNodePredicates() {
        return scanNodePredicates;
    }

    public PaimonTable getPaimonTable() {
        return paimonTable;
    }

    private void setupCloudCredential() {
        String catalog = paimonTable.getCatalogName();
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
    protected String debugString() {
        MoreObjects.ToStringHelper helper = MoreObjects.toStringHelper(this);
        helper.addValue(super.debugString());
        helper.addValue("paimonTable=" + paimonTable.getName());
        return helper.toString();
    }

    @Override
    public List<TScanRangeLocations> getScanRangeLocations(long maxScanRangeLength) {
        return scanRangeLocationsList;
    }

    public long getEstimatedLength(long rowCount, TupleDescriptor tupleDescriptor) {
        List<Column> dataColumns = tupleDescriptor.getSlots().stream().map(s -> s.getColumn())
                .collect(Collectors.toList());
        long rowSize = dataColumns.stream().mapToInt(column -> column.getType().getTypeSize()).sum();

        return rowCount * rowSize;
    }

    public void setupScanRangeLocations(TupleDescriptor tupleDescriptor, ScalarOperator predicate) {
        List<String> fieldNames =
                tupleDescriptor.getSlots().stream().map(s -> s.getColumn().getName()).collect(Collectors.toList());
        List<RemoteFileInfo> fileInfos = GlobalStateMgr.getCurrentState().getMetadataMgr().getRemoteFileInfos(
                paimonTable.getCatalogName(), paimonTable, null, -1, predicate, fieldNames, -1);
        RemoteFileDesc remoteFileDesc = fileInfos.get(0).getFiles().get(0);
        PaimonSplitsInfo splitsInfo = remoteFileDesc.getPaimonSplitsInfo();
        String predicateInfo = encodeObjectToString(splitsInfo.getPredicate());
        List<Split> splits = splitsInfo.getPaimonSplits();

        if (splits.isEmpty()) {
            LOG.warn("There is no paimon splits on {}.{} and predicate: [{}]",
                    paimonTable.getDbName(), paimonTable.getTableName(), predicate);
            return;
        }

        boolean forceJNIReader = ConnectContext.get().getSessionVariable().getPaimonForceJNIReader();
        Map<BinaryRow, Long> selectedPartitions = Maps.newHashMap();
        for (Split split : splits) {
            if (split instanceof DataSplit) {
                DataSplit dataSplit = (DataSplit) split;
                Optional<List<RawFile>> optionalRawFiles = dataSplit.convertToRawFiles();
                if (!forceJNIReader && optionalRawFiles.isPresent()) {
                    List<RawFile> rawFiles = optionalRawFiles.get();
                    boolean validFormat = rawFiles.stream().allMatch(p -> fromType(p.format()) != THdfsFileFormat.UNKNOWN);
                    if (validFormat) {
                        for (RawFile rawFile : rawFiles) {
                            addRowfileScanRangeLocations(rawFile);
                        }
                    } else {
                        long totalFileLength = getTotalFileLength(dataSplit);
                        addSplitScanRangeLocations(dataSplit, predicateInfo, totalFileLength);
                    }
                } else {
                    long totalFileLength = getTotalFileLength(dataSplit);
                    addSplitScanRangeLocations(dataSplit, predicateInfo, totalFileLength);
                }
                BinaryRow partitionValue = dataSplit.partition();
                if (!selectedPartitions.containsKey(partitionValue)) {
                    selectedPartitions.put(partitionValue, nextPartitionId());
                }
            } else {
                // paimon system table
                long length = getEstimatedLength(split.rowCount(), tupleDescriptor);
                addSplitScanRangeLocations(split, predicateInfo, length);
            }

        }
        scanNodePredicates.setSelectedPartitionIds(selectedPartitions.values());
    }

    private THdfsFileFormat fromType(String type) {
        THdfsFileFormat tHdfsFileFormat;
        switch (type) {
            case "orc":
                tHdfsFileFormat = THdfsFileFormat.ORC;
                break;
            case "parquet":
                tHdfsFileFormat = THdfsFileFormat.PARQUET;
                break;
            default:
                tHdfsFileFormat = THdfsFileFormat.UNKNOWN;
        }
        return tHdfsFileFormat;
    }

    private void addRowfileScanRangeLocations(RawFile rawFile) {
        TScanRangeLocations scanRangeLocations = new TScanRangeLocations();

        THdfsScanRange hdfsScanRange = new THdfsScanRange();
        hdfsScanRange.setUse_paimon_jni_reader(false);
        hdfsScanRange.setFull_path(rawFile.path());
        hdfsScanRange.setOffset(rawFile.offset());
        hdfsScanRange.setFile_length(rawFile.length());
        hdfsScanRange.setLength(rawFile.length());
        hdfsScanRange.setFile_format(fromType(rawFile.format()));

        TScanRange scanRange = new TScanRange();
        scanRange.setHdfs_scan_range(hdfsScanRange);
        scanRangeLocations.setScan_range(scanRange);

        TScanRangeLocation scanRangeLocation = new TScanRangeLocation(new TNetworkAddress("-1", -1));
        scanRangeLocations.addToLocations(scanRangeLocation);

        scanRangeLocationsList.add(scanRangeLocations);
    }

    private void addSplitScanRangeLocations(Split split, String predicateInfo, long totalFileLength) {
        TScanRangeLocations scanRangeLocations = new TScanRangeLocations();

        THdfsScanRange hdfsScanRange = new THdfsScanRange();
        hdfsScanRange.setUse_paimon_jni_reader(true);
        hdfsScanRange.setPaimon_split_info(encodeObjectToString(split));
        hdfsScanRange.setPaimon_predicate_info(predicateInfo);
        hdfsScanRange.setFile_length(totalFileLength);
        hdfsScanRange.setLength(totalFileLength);
        TScanRange scanRange = new TScanRange();
        scanRange.setHdfs_scan_range(hdfsScanRange);
        scanRangeLocations.setScan_range(scanRange);

        TScanRangeLocation scanRangeLocation = new TScanRangeLocation(new TNetworkAddress("-1", -1));
        scanRangeLocations.addToLocations(scanRangeLocation);

        scanRangeLocationsList.add(scanRangeLocations);
    }

    long getTotalFileLength(DataSplit split) {
        return split.dataFiles().stream().map(DataFileMeta::fileSize).reduce(0L, Long::sum);
    }

    private long nextPartitionId() {
        return partitionIdGen.getAndIncrement();
    }

    @Override
    protected String getNodeExplainString(String prefix, TExplainLevel detailLevel) {
        StringBuilder output = new StringBuilder();

        output.append(prefix).append("TABLE: ").append(paimonTable.getName()).append("\n");

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

        List<String> partitionNames = GlobalStateMgr.getCurrentState().getMetadataMgr().listPartitionNames(
                paimonTable.getCatalogName(), paimonTable.getDbName(), paimonTable.getTableName());

        output.append(prefix).append(
                String.format("partitions=%s/%s", scanNodePredicates.getSelectedPartitionIds().size(),
                        partitionNames.size() == 0 ? 1 : partitionNames.size()));
        output.append("\n");

        // TODO: support it in verbose
        if (detailLevel != VERBOSE) {
            output.append(prefix).append(String.format("cardinality=%s", cardinality));
            output.append("\n");
        }

        output.append(prefix).append(String.format("avgRowSize=%s\n", avgRowSize));

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
        return scanRangeLocationsList.size();
    }

    @Override
    protected void toThrift(TPlanNode msg) {
        msg.node_type = TPlanNodeType.HDFS_SCAN_NODE;
        THdfsScanNode tHdfsScanNode = new THdfsScanNode();
        tHdfsScanNode.setTuple_id(desc.getId().asInt());
        msg.hdfs_scan_node = tHdfsScanNode;

        String sqlPredicates = getExplainString(conjuncts);
        msg.hdfs_scan_node.setSql_predicates(sqlPredicates);

        if (paimonTable != null) {
            msg.hdfs_scan_node.setTable_name(paimonTable.getName());
        }

        HdfsScanNode.setScanOptimizeOptionToThrift(tHdfsScanNode, this);
        HdfsScanNode.setCloudConfigurationToThrift(tHdfsScanNode, cloudConfiguration);
        HdfsScanNode.setMinMaxConjunctsToThrift(tHdfsScanNode, this, this.getScanNodePredicates());
    }

    @Override
    public boolean canUseRuntimeAdaptiveDop() {
        return true;
    }

    private static final Base64.Encoder BASE64_ENCODER =
            java.util.Base64.getUrlEncoder().withoutPadding();

    public static <T> String encodeObjectToString(T t) {
        try {
            byte[] bytes = InstantiationUtil.serializeObject(t);
            return new String(BASE64_ENCODER.encode(bytes), UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
