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

package io.datafibre.fibre.sql;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import io.datafibre.fibre.analysis.Analyzer;
import io.datafibre.fibre.analysis.BrokerDesc;
import io.datafibre.fibre.analysis.DescriptorTable;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.SlotDescriptor;
import io.datafibre.fibre.analysis.SlotRef;
import io.datafibre.fibre.analysis.TupleDescriptor;
import io.datafibre.fibre.catalog.AggregateType;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.KeysType;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.Partition;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.common.Config;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.common.IdGenerator;
import io.datafibre.fibre.common.LoadException;
import io.datafibre.fibre.common.Pair;
import io.datafibre.fibre.common.UserException;
import io.datafibre.fibre.common.util.DebugUtil;
import io.datafibre.fibre.load.BrokerFileGroup;
import io.datafibre.fibre.load.EtlJobType;
import io.datafibre.fibre.load.Load;
import io.datafibre.fibre.load.loadv2.LoadJob;
import io.datafibre.fibre.load.streamload.StreamLoadInfo;
import io.datafibre.fibre.planner.DataPartition;
import io.datafibre.fibre.planner.DataSink;
import io.datafibre.fibre.planner.ExchangeNode;
import io.datafibre.fibre.planner.FileScanNode;
import io.datafibre.fibre.planner.OlapTableSink;
import io.datafibre.fibre.planner.PlanFragment;
import io.datafibre.fibre.planner.PlanFragmentId;
import io.datafibre.fibre.planner.PlanNodeId;
import io.datafibre.fibre.planner.ScanNode;
import io.datafibre.fibre.planner.StreamLoadScanNode;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.analyzer.SemanticException;
import io.datafibre.fibre.sql.ast.ImportColumnDesc;
import io.datafibre.fibre.sql.ast.PartitionNames;
import io.datafibre.fibre.sql.optimizer.statistics.ColumnDict;
import io.datafibre.fibre.sql.optimizer.statistics.IDictManager;
import io.datafibre.fibre.thrift.TBrokerFileStatus;
import io.datafibre.fibre.thrift.TPartialUpdateMode;
import io.datafibre.fibre.thrift.TPartitionType;
import io.datafibre.fibre.thrift.TResultSinkType;
import io.datafibre.fibre.thrift.TRoutineLoadTask;
import io.datafibre.fibre.thrift.TUniqueId;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class LoadPlanner {
    private static Logger LOG = LogManager.getLogger(LoadPlanner.class);
    // Only for unit test
    public static boolean enableSingleReplicationShuffle = false;

    private long loadJobId;
    private TUniqueId loadId;
    private long txnId;
    private ConnectContext context;
    private EtlJobType etlJobType;
    private String timezone;
    private boolean partialUpdate;
    boolean isPrimaryKey;
    boolean enableDictOptimize;
    private long execMemLimit;
    private long loadMemLimit;
    private boolean strictMode;
    private long timeoutS;
    private int parallelInstanceNum;
    private long startTime;
    private long sqlMode;
    private String loadTransmissionCompressionType;
    private boolean enableReplicatedSorage;
    private Map<String, String> sessionVariables;

    private long dbId;
    private String dbName;
    private Table destTable;
    private DescriptorTable descTable;
    private TupleDescriptor tupleDesc;
    private List<Pair<Integer, ColumnDict>> globalDicts = Lists.newArrayList();

    private List<PlanFragment> fragments = Lists.newArrayList();
    private List<ScanNode> scanNodes = Lists.newArrayList();

    // Broker Load related structs
    private BrokerDesc brokerDesc;
    private List<BrokerFileGroup> fileGroups;
    private List<List<TBrokerFileStatus>> fileStatusesList;
    private int filesAdded;
    private Analyzer analyzer;

    IdGenerator<PlanNodeId> planNodeGenerator = PlanNodeId.createGenerator();

    // Routine/Stream load related structs
    List<ImportColumnDesc> columnDescs;
    private StreamLoadInfo streamLoadInfo;
    private boolean routimeStreamLoadNegative;

    // Stream load related structs
    private String label;
    // Routine load related structs
    TRoutineLoadTask routineLoadTask;
    private TPartialUpdateMode partialUpdateMode = TPartialUpdateMode.ROW_MODE;

    private LoadJob.JSONOptions jsonOptions = new LoadJob.JSONOptions();

    private Boolean missAutoIncrementColumn = Boolean.FALSE;

    private String mergeConditionStr;

    public LoadPlanner(long loadJobId, TUniqueId loadId, long txnId, long dbId, OlapTable destTable,
                       boolean strictMode, String timezone, long timeoutS,
                       long startTime, boolean partialUpdate, ConnectContext context,
                       Map<String, String> sessionVariables, long loadMemLimit, long execMemLimit,
                       BrokerDesc brokerDesc, List<BrokerFileGroup> brokerFileGroups,
                       List<List<TBrokerFileStatus>> fileStatusesList, int filesAdded) {
        this.loadJobId = loadJobId;
        this.loadId = loadId;
        this.txnId = txnId;
        this.dbId = dbId;
        this.destTable = destTable;
        this.strictMode = strictMode;
        this.timeoutS = timeoutS;
        this.partialUpdate = partialUpdate;
        this.startTime = startTime;
        if (context != null) {
            this.context = context;
        } else {
            this.context = new ConnectContext();
        }
        if (this.context.getSessionVariable().getEnableAdaptiveSinkDop()) {
            this.parallelInstanceNum = this.context.getSessionVariable().getSinkDegreeOfParallelism();
        } else {
            this.parallelInstanceNum = Config.load_parallel_instance_num;
        }
        this.analyzer = new Analyzer(GlobalStateMgr.getCurrentState(), this.context);
        this.analyzer.setTimezone(timezone);
        this.timezone = timezone;
        this.descTable = this.analyzer.getDescTbl();
        this.loadMemLimit = loadMemLimit;
        this.execMemLimit = execMemLimit;
        this.sessionVariables = sessionVariables;
        this.brokerDesc = brokerDesc;
        this.fileGroups = brokerFileGroups;
        this.fileStatusesList = fileStatusesList;
        this.filesAdded = filesAdded;
        this.isPrimaryKey = ((OlapTable) destTable).getKeysType() == KeysType.PRIMARY_KEYS;
        this.enableDictOptimize = true;
        this.routimeStreamLoadNegative = false;
        this.etlJobType = EtlJobType.BROKER;
    }

    public LoadPlanner(long loadJobId, TUniqueId loadId, long txnId, long dbId, String dbName, OlapTable destTable,
                       boolean strictMode, String timezone, boolean partialUpdate, ConnectContext context,
                       Map<String, String> sessionVariables, long loadMemLimit, long execMemLimit,
                       boolean routimeStreamLoadNegative, int parallelInstanceNum,
                       List<ImportColumnDesc> columnDescs, StreamLoadInfo streamLoadInfo) {
        this.loadJobId = loadJobId;
        this.loadId = loadId;
        this.txnId = txnId;
        this.dbId = dbId;
        this.dbName = dbName;
        this.destTable = destTable;
        this.strictMode = strictMode;
        this.timezone = timezone;
        this.partialUpdate = partialUpdate;
        if (context != null) {
            this.context = context;
        } else {
            this.context = new ConnectContext();
        }
        this.loadMemLimit = loadMemLimit;
        this.execMemLimit = execMemLimit;
        this.isPrimaryKey = ((OlapTable) destTable).getKeysType() == KeysType.PRIMARY_KEYS;
        this.routimeStreamLoadNegative = routimeStreamLoadNegative;
        this.parallelInstanceNum = parallelInstanceNum;
        this.columnDescs = columnDescs;
        this.streamLoadInfo = streamLoadInfo;
        this.analyzer = new Analyzer(GlobalStateMgr.getCurrentState(), this.context);
        this.descTable = analyzer.getDescTbl();
        this.enableDictOptimize = Config.enable_dict_optimize_stream_load;
        this.startTime = System.currentTimeMillis();
        this.sessionVariables = sessionVariables;
    }

    public LoadPlanner(long loadJobId, TUniqueId loadId, long txnId, long dbId, String dbName, OlapTable destTable,
                       boolean strictMode, String timezone, boolean partialUpdate, ConnectContext context,
                       Map<String, String> sessionVariables, long loadMemLimit, long execMemLimit,
                       boolean routimeStreamLoadNegative, int parallelInstanceNum, List<ImportColumnDesc> columnDescs,
                       StreamLoadInfo streamLoadInfo, String label, long timeoutS) {
        this(loadJobId, loadId, txnId, dbId, dbName, destTable, strictMode, timezone, partialUpdate, context,
                sessionVariables, loadMemLimit, execMemLimit, routimeStreamLoadNegative, parallelInstanceNum,
                columnDescs, streamLoadInfo);
        this.label = label;
        this.timeoutS = timeoutS;
        this.etlJobType = EtlJobType.STREAM_LOAD;
        this.context.getSessionVariable().setEnablePipelineEngine(true);
    }

    public void setPartialUpdateMode(TPartialUpdateMode mode) {
        this.partialUpdateMode = mode;
    }

    public void setMergeConditionStr(String mergeConditionStr) {
        this.mergeConditionStr = mergeConditionStr;
    }

    public void setJsonOptions(LoadJob.JSONOptions options) {
        this.jsonOptions = options;
    }

    public void plan() throws UserException {
        // 1. Generate tuple descriptor
        OlapTable olapDestTable = (OlapTable) destTable;
        List<Column> destColumns = Lists.newArrayList();
        if (isPrimaryKey && partialUpdate) {
            if (((OlapTable) destTable).hasRowStorageType() && partialUpdate &&
                    partialUpdateMode != TPartialUpdateMode.ROW_MODE) {
                throw new DdlException("column with row table only support row mode partial update");
            }
            if (this.etlJobType == EtlJobType.BROKER) {
                if (fileGroups.size() != 1) {
                    throw new DdlException("partial update only support single filegroup.");
                } else {
                    if (fileGroups.get(0).isNegative()) {
                        throw new DdlException("Primary key table does not support negative load");
                    }
                }
            } else {
                if (routimeStreamLoadNegative) {
                    throw new DdlException("Primary key table does not support negative load");
                }
            }
        } else if (!isPrimaryKey && partialUpdate) {
            throw new DdlException("Only primary key table support partial update");
        }
        List<Boolean> isMissAutoIncrementColumn = Lists.newArrayList();
        if (partialUpdate) {
            if (this.etlJobType == EtlJobType.BROKER) {
                destColumns = Load.getPartialUpateColumns(destTable, fileGroups.get(0).getColumnExprList(),
                        isMissAutoIncrementColumn);
            } else {
                destColumns = Load.getPartialUpateColumns(destTable, columnDescs, isMissAutoIncrementColumn);
            }
        } else {
            destColumns = destTable.getFullSchema();
        }

        if (isMissAutoIncrementColumn.size() != 0) {
            this.missAutoIncrementColumn = isMissAutoIncrementColumn.get(0);
        }

        generateTupleDescriptor(destColumns, isPrimaryKey);

        // 2. Prepare scan nodes
        ScanNode scanNode = prepareScanNodes();

        // 3. Exchange node for primary table
        PlanFragment sinkFragment = null;
        boolean needShufflePlan = false;
        boolean forceReplicatedStorage = false;
        if (Config.enable_shuffle_load && needShufflePlan()) {
            if (!Config.eliminate_shuffle_load_by_replicated_storage) {
                // scan fragment
                PlanFragment scanFragment = new PlanFragment(new PlanFragmentId(0), scanNode, DataPartition.RANDOM);
                scanFragment.setParallelExecNum(parallelInstanceNum);

                fragments.add(scanFragment);

                // Exchange node
                List<Column> keyColumns = olapDestTable.getKeyColumnsByIndexId(olapDestTable.getBaseIndexId());
                List<Expr> partitionExprs = Lists.newArrayList();
                keyColumns.forEach(column -> {
                    partitionExprs.add(new SlotRef(tupleDesc.getColumnSlot(column.getName())));
                });

                DataPartition dataPartition = new DataPartition(TPartitionType.HASH_PARTITIONED, partitionExprs);
                ExchangeNode exchangeNode = new ExchangeNode(new PlanNodeId(planNodeGenerator.getNextId().asInt()),
                        scanFragment.getPlanRoot(), dataPartition);

                // add exchange node to scan fragment and sink fragment
                sinkFragment = new PlanFragment(new PlanFragmentId(1), exchangeNode, dataPartition);
                exchangeNode.setFragment(sinkFragment);
                scanFragment.setDestination(exchangeNode);
                scanFragment.setOutputPartition(dataPartition);

                needShufflePlan = true;
            } else {
                forceReplicatedStorage = true;
            }
        }

        // 4. Prepare sink fragment
        List<Long> partitionIds = getAllPartitionIds();
        if (!needShufflePlan) {
            sinkFragment = new PlanFragment(new PlanFragmentId(0), scanNode, DataPartition.RANDOM);
        }
        prepareSinkFragment(sinkFragment, partitionIds, true, forceReplicatedStorage);
        if (this.context != null) {
            if (needShufflePlan) {
                sinkFragment.setPipelineDop(1);
                sinkFragment.setParallelExecNum(parallelInstanceNum);
                sinkFragment.setForceSetTableSinkDop();
            } else {
                sinkFragment.setPipelineDop(parallelInstanceNum);
                sinkFragment.setParallelExecNum(1);
            }
            sinkFragment.setHasOlapTableSink();
            sinkFragment.setForceAssignScanRangesPerDriverSeq();
        } else {
            sinkFragment.setPipelineDop(1);
            sinkFragment.setParallelExecNum(parallelInstanceNum);
        }
        fragments.add(sinkFragment);

        // 5. finalize
        for (PlanFragment fragment : fragments) {
            fragment.createDataSink(TResultSinkType.MYSQL_PROTOCAL);
        }
        Collections.reverse(fragments);
    }

    private void generateTupleDescriptor(List<Column> destColumns, boolean isPrimaryKey) throws UserException {
        this.tupleDesc = descTable.createTupleDescriptor("DestTableTupleDescriptor");
        // Add column slotDesc for dest table
        for (Column col : destColumns) {
            SlotDescriptor slotDesc = descTable.addSlotDescriptor(tupleDesc);
            slotDesc.setIsMaterialized(true);
            slotDesc.setType(col.getType());
            slotDesc.setColumn(col);
            slotDesc.setIsNullable(col.isAllowNull());
            if (routimeStreamLoadNegative && !col.isKey() && col.getAggregationType() != AggregateType.SUM) {
                throw new DdlException("Column is not SUM AggreateType. column:" + col.getName());
            }

            if (col.getType().isVarchar() && enableDictOptimize
                    && IDictManager.getInstance().hasGlobalDict(destTable.getId(),
                    col.getName())) {
                Optional<ColumnDict> dict = IDictManager.getInstance().getGlobalDict(destTable.getId(), col.getName());
                dict.ifPresent(columnDict -> globalDicts.add(new Pair<>(slotDesc.getId().asInt(), columnDict)));
            }
        }
        // Add op type slotdesc for primary tabale
        if (isPrimaryKey) {
            SlotDescriptor slotDesc = descTable.addSlotDescriptor(tupleDesc);
            slotDesc.setIsMaterialized(true);
            slotDesc.setColumn(new Column(Load.LOAD_OP_COLUMN, Type.TINYINT));
            slotDesc.setIsNullable(false);
        }
        descTable.computeMemLayout();
    }

    private ScanNode prepareScanNodes() throws UserException {
        ScanNode scanNode = null;
        if (this.etlJobType == EtlJobType.BROKER) {
            FileScanNode fileScanNode = new FileScanNode(new PlanNodeId(planNodeGenerator.getNextId().asInt()),
                    tupleDesc,
                    "FileScanNode", fileStatusesList, filesAdded);
            fileScanNode.setLoadInfo(loadJobId, txnId, destTable, brokerDesc, fileGroups, strictMode,
                    parallelInstanceNum);
            fileScanNode.setUseVectorizedLoad(true);
            fileScanNode.setJSONOptions(jsonOptions);
            fileScanNode.init(analyzer);
            fileScanNode.finalizeStats(analyzer);
            scanNode = fileScanNode;
        } else if (this.etlJobType == EtlJobType.STREAM_LOAD || this.etlJobType == EtlJobType.ROUTINE_LOAD) {
            StreamLoadScanNode streamScanNode = new StreamLoadScanNode(loadId, new PlanNodeId(0), tupleDesc,
                    destTable, streamLoadInfo, dbName, label, parallelInstanceNum, txnId);
            streamScanNode.setNeedAssignBE(true);
            streamScanNode.setUseVectorizedLoad(true);
            streamScanNode.init(analyzer);
            streamScanNode.finalizeStats(analyzer);
            scanNode = streamScanNode;
        }
        scanNodes.add(scanNode);
        return scanNode;
    }

    private boolean checkNullExprInAutoIncrement() {
        boolean nullExprInAutoIncrement = false;
        for (ScanNode node : scanNodes) {
            if (this.etlJobType == EtlJobType.BROKER) {
                if (((FileScanNode) node).nullExprInAutoIncrement()) {
                    nullExprInAutoIncrement = true;
                }
            } else if (this.etlJobType == EtlJobType.STREAM_LOAD || this.etlJobType == EtlJobType.ROUTINE_LOAD) {
                if (((StreamLoadScanNode) node).nullExprInAutoIncrement()) {
                    nullExprInAutoIncrement = true;
                }
            }

            if (nullExprInAutoIncrement) {
                break;
            }
        }

        return nullExprInAutoIncrement;
    }

    private void prepareSinkFragment(PlanFragment sinkFragment, List<Long> partitionIds,
                                     boolean completeTabletSink, boolean forceReplicatedStorage) throws UserException {
        DataSink dataSink = null;
        if (destTable instanceof OlapTable) {
            // 4. Olap table sink
            OlapTable olapTable = (OlapTable) destTable;
            boolean enableAutomaticPartition;
            if (fileGroups != null && fileGroups.stream().anyMatch(BrokerFileGroup::isSpecifyPartition)) {
                enableAutomaticPartition = false;
            } else {
                enableAutomaticPartition = olapTable.supportedAutomaticPartition();
            }
            Preconditions.checkState(!CollectionUtils.isEmpty(partitionIds));
            dataSink = new OlapTableSink(olapTable, tupleDesc, partitionIds,
                    olapTable.writeQuorum(),
                    forceReplicatedStorage ? true : ((OlapTable) destTable).enableReplicatedStorage(),
                    checkNullExprInAutoIncrement(), enableAutomaticPartition);
            if (this.missAutoIncrementColumn == Boolean.TRUE) {
                ((OlapTableSink) dataSink).setMissAutoIncrementColumn();
            }
            if (olapTable.getAutomaticBucketSize() > 0) {
                ((OlapTableSink) dataSink).setAutomaticBucketSize(olapTable.getAutomaticBucketSize());
            }
            if (completeTabletSink) {
                ((OlapTableSink) dataSink).init(loadId, txnId, dbId, timeoutS);
                ((OlapTableSink) dataSink).setPartialUpdateMode(partialUpdateMode);
                ((OlapTableSink) dataSink).complete(mergeConditionStr);
            }
            // if sink is OlapTableSink Assigned to Be execute this sql [cn execute OlapTableSink will crash]
            context.getSessionVariable().setPreferComputeNode(false);
            context.getSessionVariable().setUseComputeNodes(0);
        } else {
            throw new SemanticException("Unknown table type " + destTable.getType());
        }
        sinkFragment.setSink(dataSink);
        // After data loading, we need to check the global dict for low cardinality
        // string column
        // whether update.
        sinkFragment.setLoadGlobalDicts(globalDicts);
    }

    public void completeTableSink(long txnId) throws AnalysisException, UserException {
        if (destTable instanceof OlapTable) {
            OlapTableSink dataSink = (OlapTableSink) fragments.get(0).getSink();
            dataSink.init(loadId, txnId, dbId, timeoutS);
            dataSink.setPartialUpdateMode(partialUpdateMode);
            dataSink.complete(mergeConditionStr);
        }
        this.txnId = txnId;
    }

    private List<Long> getAllPartitionIds() throws LoadException {
        Set<Long> partitionIds = Sets.newHashSet();
        OlapTable olapDestTable = (OlapTable) destTable;
        if (this.etlJobType == EtlJobType.BROKER) {
            if (CollectionUtils.isNotEmpty(fileGroups)) {
                BrokerFileGroup brokerFileGroup = fileGroups.get(0);
                // all file group in fileGroups should have same partitions, so only need to get
                // partition ids
                // from one of these file groups
                if (brokerFileGroup.getPartitionIds() != null) {
                    partitionIds.addAll(brokerFileGroup.getPartitionIds());
                }
            }
        } else if (this.etlJobType == EtlJobType.STREAM_LOAD || this.etlJobType == etlJobType.ROUTINE_LOAD) {
            PartitionNames partitionNames = streamLoadInfo.getPartitions();
            if (partitionNames != null) {
                for (String partName : partitionNames.getPartitionNames()) {
                    Partition part = olapDestTable.getPartition(partName, partitionNames.isTemp());
                    if (part == null) {
                        throw new LoadException("unknown partition " + partName + " in table " + destTable.getName());
                    }
                    partitionIds.add(part.getId());
                }
            }
        }

        if (partitionIds.isEmpty()) {
            for (Partition partition : destTable.getPartitions()) {
                partitionIds.add(partition.getId());
            }
        }

        // If this is a dynamic partitioned table, it will take some time to create the
        // partition after the
        // table is created, a exception needs to be thrown here
        if (partitionIds.isEmpty()) {
            throw new LoadException("data cannot be inserted into table with empty partition. " +
                    "Use `SHOW PARTITIONS FROM " + destTable.getName() +
                    "` to see the currently partitions of this table. ");
        }

        return Lists.newArrayList(partitionIds);
    }

    public void updateLoadInfo(TUniqueId loadId) {
        for (PlanFragment planFragment : fragments) {
            if (!(planFragment.getSink() instanceof OlapTableSink
                    && planFragment.getPlanRoot() instanceof FileScanNode)) {
                continue;
            }

            // when retry load by reusing this plan in load process, the load_id should be
            // changed
            OlapTableSink olapTableSink = (OlapTableSink) planFragment.getSink();
            olapTableSink.updateLoadId(loadId);
            LOG.info("update olap table sink's load id to {}, job: {}", DebugUtil.printId(loadId), loadJobId);

            // update backend and broker
            FileScanNode fileScanNode = (FileScanNode) planFragment.getPlanRoot();
            fileScanNode.updateScanRangeLocations();
        }
    }

    public Boolean needShufflePlan() {
        OlapTable olapDestTable = (OlapTable) destTable;
        if (KeysType.DUP_KEYS.equals(olapDestTable.getKeysType())) {
            return false;
        }

        if (olapDestTable.getDefaultReplicationNum() <= 1) {
            return false;
        }

        if (olapDestTable.enableReplicatedStorage()) {
            return false;
        }

        if (KeysType.AGG_KEYS.equals(olapDestTable.getKeysType())) {
            for (Map.Entry<Long, List<Column>> entry : olapDestTable.getIndexIdToSchema().entrySet()) {
                List<Column> schema = entry.getValue();
                for (Column column : schema) {
                    if (column.getAggregationType() == AggregateType.REPLACE
                            || column.getAggregationType() == AggregateType.REPLACE_IF_NOT_NULL) {
                        return true;
                    }
                }
            }
            return false;
        }

        return true;
    }

    public ConnectContext getContext() {
        return context;
    }

    public DescriptorTable getDescTable() {
        return descTable;
    }

    public long getLoadJobId() {
        return loadJobId;
    }

    public void setLoadJobId(long loadJobId) {
        this.loadJobId = loadJobId;
    }

    public TUniqueId getLoadId() {
        return loadId;
    }

    public List<PlanFragment> getFragments() {
        return fragments;
    }

    public List<ScanNode> getScanNodes() {
        return scanNodes;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getTimeZone() {
        return timezone;
    }

    public long getTimeout() {
        return timeoutS;
    }

    public void setExecMemLimit(long execMemLimit) {
        this.execMemLimit = execMemLimit;
    }

    public long getExecMemLimit() {
        return execMemLimit;
    }

    public void setLoadMemLimit(long loadMemLimit) {
        this.loadMemLimit = loadMemLimit;
    }

    public long getLoadMemLimit() {
        return loadMemLimit;
    }

    public EtlJobType getEtlJobType() {
        return etlJobType;
    }

    public Map<String, String> getSessionVariables() {
        return sessionVariables;
    }
}
