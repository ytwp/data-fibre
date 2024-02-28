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

import com.google.common.collect.Lists;
import io.datafibre.fibre.analysis.DescriptorTable;
import io.datafibre.fibre.analysis.SlotDescriptor;
import io.datafibre.fibre.analysis.TableName;
import io.datafibre.fibre.analysis.TupleDescriptor;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.Partition;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.system.SystemTable;
import io.datafibre.fibre.common.Pair;
import io.datafibre.fibre.common.UserException;
import io.datafibre.fibre.planner.DataSink;
import io.datafibre.fibre.planner.OlapTableSink;
import io.datafibre.fibre.planner.PlanFragment;
import io.datafibre.fibre.planner.SchemaTableSink;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.analyzer.SemanticException;
import io.datafibre.fibre.sql.ast.QueryRelation;
import io.datafibre.fibre.sql.ast.UpdateStmt;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.Optimizer;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefFactory;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefSet;
import io.datafibre.fibre.sql.optimizer.base.PhysicalPropertySet;
import io.datafibre.fibre.sql.optimizer.statistics.ColumnDict;
import io.datafibre.fibre.sql.optimizer.statistics.IDictManager;
import io.datafibre.fibre.sql.optimizer.transformer.LogicalPlan;
import io.datafibre.fibre.sql.optimizer.transformer.RelationTransformer;
import io.datafibre.fibre.sql.plan.ExecPlan;
import io.datafibre.fibre.sql.plan.PlanFragmentBuilder;
import io.datafibre.fibre.thrift.TPartialUpdateMode;
import io.datafibre.fibre.thrift.TResultSinkType;

import java.util.List;
import java.util.Optional;

public class UpdatePlanner {
    public ExecPlan plan(UpdateStmt updateStmt, ConnectContext session) {
        QueryRelation query = updateStmt.getQueryStatement().getQueryRelation();
        List<String> colNames = query.getColumnOutputNames();
        ColumnRefFactory columnRefFactory = new ColumnRefFactory();
        LogicalPlan logicalPlan = new RelationTransformer(columnRefFactory, session).transform(query);

        // TODO: remove forceDisablePipeline when all the operators support pipeline engine.
        boolean isEnablePipeline = session.getSessionVariable().isEnablePipelineEngine();
        boolean canUsePipeline = isEnablePipeline && DataSink.canTableSinkUsePipeline(updateStmt.getTable());
        boolean forceDisablePipeline = isEnablePipeline && !canUsePipeline;
        boolean prevIsEnableLocalShuffleAgg = session.getSessionVariable().isEnableLocalShuffleAgg();
        try {
            if (forceDisablePipeline) {
                session.getSessionVariable().setEnablePipelineEngine(false);
            }
            // Non-query must use the strategy assign scan ranges per driver sequence, which local shuffle agg cannot use.
            session.getSessionVariable().setEnableLocalShuffleAgg(false);

            Table table = updateStmt.getTable();
            long tableId = table.getId();
            Optimizer optimizer = new Optimizer();
            optimizer.setUpdateTableId(tableId);
            OptExpression optimizedPlan = optimizer.optimize(
                    session,
                    logicalPlan.getRoot(),
                    new PhysicalPropertySet(),
                    new ColumnRefSet(logicalPlan.getOutputColumn()),
                    columnRefFactory);
            ExecPlan execPlan = PlanFragmentBuilder.createPhysicalPlan(optimizedPlan, session,
                    logicalPlan.getOutputColumn(), columnRefFactory, colNames, TResultSinkType.MYSQL_PROTOCAL, false);
            DescriptorTable descriptorTable = execPlan.getDescTbl();
            TupleDescriptor olapTuple = descriptorTable.createTupleDescriptor();

            List<Pair<Integer, ColumnDict>> globalDicts = Lists.newArrayList();
            for (Column column : table.getFullSchema()) {
                if (updateStmt.usePartialUpdate() && !column.isGeneratedColumn() &&
                        !updateStmt.isAssignmentColumn(column.getName()) && !column.isKey()) {
                    // When using partial update, skip columns which aren't key column and not be assign, except for
                    // generated column
                    continue;
                }
                SlotDescriptor slotDescriptor = descriptorTable.addSlotDescriptor(olapTuple);
                slotDescriptor.setIsMaterialized(true);
                slotDescriptor.setType(column.getType());
                slotDescriptor.setColumn(column);
                slotDescriptor.setIsNullable(column.isAllowNull());
                if (column.getType().isVarchar() &&
                        IDictManager.getInstance().hasGlobalDict(tableId, column.getName())) {
                    Optional<ColumnDict> dict = IDictManager.getInstance().getGlobalDict(tableId, column.getName());
                    dict.ifPresent(
                            columnDict -> globalDicts.add(new Pair<>(slotDescriptor.getId().asInt(), columnDict)));
                }
            }
            olapTuple.computeMemLayout();

            if (table instanceof OlapTable) {
                List<Long> partitionIds = Lists.newArrayList();
                for (Partition partition : table.getPartitions()) {
                    partitionIds.add(partition.getId());
                }
                OlapTable olapTable = (OlapTable) table;
                DataSink dataSink =
                        new OlapTableSink(olapTable, olapTuple, partitionIds, olapTable.writeQuorum(),
                                olapTable.enableReplicatedStorage(), false, olapTable.supportedAutomaticPartition());
                if (updateStmt.usePartialUpdate()) {
                    // using column mode partial update in UPDATE stmt
                    ((OlapTableSink) dataSink).setPartialUpdateMode(TPartialUpdateMode.COLUMN_UPDATE_MODE);
                }
                execPlan.getFragments().get(0).setSink(dataSink);
                execPlan.getFragments().get(0).setLoadGlobalDicts(globalDicts);

                // if sink is OlapTableSink Assigned to Be execute this sql [cn execute OlapTableSink will crash]
                session.getSessionVariable().setPreferComputeNode(false);
                session.getSessionVariable().setUseComputeNodes(0);
                OlapTableSink olapTableSink = (OlapTableSink) dataSink;
                TableName catalogDbTable = updateStmt.getTableName();
                Database db = GlobalStateMgr.getCurrentState().getMetadataMgr().getDb(catalogDbTable.getCatalog(),
                        catalogDbTable.getDb());
                try {
                    olapTableSink.init(session.getExecutionId(), updateStmt.getTxnId(), db.getId(),
                            ConnectContext.get().getSessionVariable().getQueryTimeoutS());
                    olapTableSink.complete();
                } catch (UserException e) {
                    throw new SemanticException(e.getMessage());
                }
            } else if (table instanceof SystemTable) {
                DataSink dataSink = new SchemaTableSink((SystemTable) table);
                execPlan.getFragments().get(0).setSink(dataSink);
            } else {
                throw new SemanticException("Unsupported table type: " + table.getClass().getName());
            }
            if (canUsePipeline) {
                PlanFragment sinkFragment = execPlan.getFragments().get(0);
                if (ConnectContext.get().getSessionVariable().getEnableAdaptiveSinkDop()) {
                    sinkFragment.setPipelineDop(ConnectContext.get().getSessionVariable().getSinkDegreeOfParallelism());
                } else {
                    sinkFragment
                            .setPipelineDop(ConnectContext.get().getSessionVariable().getParallelExecInstanceNum());
                }
                if (table instanceof OlapTable) {
                    sinkFragment.setHasOlapTableSink();
                }
                sinkFragment.setForceSetTableSinkDop();
                sinkFragment.setForceAssignScanRangesPerDriverSeq();
                sinkFragment.disableRuntimeAdaptiveDop();
            } else {
                execPlan.getFragments().get(0).setPipelineDop(1);
            }
            return execPlan;
        } finally {
            session.getSessionVariable().setEnableLocalShuffleAgg(prevIsEnableLocalShuffleAgg);
            if (forceDisablePipeline) {
                session.getSessionVariable().setEnablePipelineEngine(true);
            }
        }
    }
}
