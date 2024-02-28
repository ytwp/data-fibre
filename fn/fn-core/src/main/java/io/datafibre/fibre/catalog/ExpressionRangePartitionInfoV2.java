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

package io.datafibre.fibre.catalog;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.gson.annotations.SerializedName;
import io.datafibre.fibre.analysis.CastExpr;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.FunctionCallExpr;
import io.datafibre.fibre.analysis.SlotRef;
import io.datafibre.fibre.common.io.Text;
import io.datafibre.fibre.common.util.RangeUtils;
import io.datafibre.fibre.persist.gson.GsonPostProcessable;
import io.datafibre.fibre.persist.gson.GsonPreProcessable;
import io.datafibre.fibre.persist.gson.GsonUtils;
import io.datafibre.fibre.qe.SqlModeHelper;
import io.datafibre.fibre.server.RunMode;
import io.datafibre.fibre.sql.analyzer.AnalyzerUtils;
import io.datafibre.fibre.sql.analyzer.PartitionExprAnalyzer;
import io.datafibre.fibre.sql.parser.SqlParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ExprRangePartitionInfo is an enhanced version of ExpressionRangePartitionInfo
 * because ExpressionRangePartitionInfo is not easily scalable
 * and get more extensions by extracting objects
 * in the future this will replace all expr range partition info
 * As of 2023-09, it's used to describe range using expr like partition by range cast((substring(col, 3)) as int)
 */
public class ExpressionRangePartitionInfoV2 extends RangePartitionInfo
        implements GsonPreProcessable, GsonPostProcessable {

    private static final Logger LOG = LogManager.getLogger(ExpressionRangePartitionInfoV2.class);

    private List<Expr> partitionExprs;

    @SerializedName("serializedPartitionExprs")
    private List<String> serializedPartitionExprs;

    @SerializedName(value = "automaticPartition")
    private Boolean automaticPartition = false;

    @SerializedName(value = "sourcePartitionTypes")
    private List<Type> sourcePartitionTypes;

    public ExpressionRangePartitionInfoV2(List<Expr> partitionExprs, List<Column> columns) {
        super(columns);
        this.type = PartitionType.EXPR_RANGE_V2;
        this.partitionExprs = partitionExprs;
    }

    public static PartitionInfo read(DataInput in) throws IOException {
        String json = Text.readString(in);
        ExpressionRangePartitionInfoV2 expressionRangePartitionInfoV2 = GsonUtils.GSON.fromJson(json,
                ExpressionRangePartitionInfoV2.class);
        return expressionRangePartitionInfoV2;
    }

    @Override
    public void gsonPreProcess() throws IOException {
        super.gsonPreProcess();
        this.serializedPartitionExprs = new ArrayList<>();
        for (Expr partitionExpr : partitionExprs) {
            serializedPartitionExprs.add(partitionExpr.toSql());
        }
    }

    @Override
    public void gsonPostProcess() throws IOException {
        super.gsonPostProcess();
        partitionExprs = Lists.newArrayList();
        for (String expressionSql : serializedPartitionExprs) {
            Expr expr = SqlParser.parseSqlToExpr(expressionSql, SqlModeHelper.MODE_DEFAULT);
            partitionExprs.add(expr);
        }
        // Analyze partition expr
        SlotRef slotRef;
        for (Expr expr : partitionExprs) {
            if (expr instanceof FunctionCallExpr) {
                slotRef = AnalyzerUtils.getSlotRefFromFunctionCall(expr);
            } else if (expr instanceof CastExpr) {
                slotRef = AnalyzerUtils.getSlotRefFromCast(expr);
            } else if (expr instanceof SlotRef) {
                slotRef = (SlotRef) expr;
            } else {
                LOG.warn("Unknown expr type: {}", expr.toSql());
                continue;
            }

            try {
                // The current expression partition only supports 1 column
                slotRef.setType(sourcePartitionTypes.get(0));
                PartitionExprAnalyzer.analyzePartitionExpr(expr, slotRef);
            } catch (Throwable ex) {
                LOG.warn("Failed to analyze partition expr: {}", expr.toSql(), ex);
            }
        }
        serializedPartitionExprs = null;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        Text.writeString(out, GsonUtils.GSON.toJson(this));
    }

    @Override
    public String toSql(OlapTable table, List<Long> partitionId) {
        StringBuilder sb = new StringBuilder();
        sb.append("PARTITION BY ");
        if (table instanceof MaterializedView) {
            sb.append("(");
            for (Expr expr : partitionExprs) {
                if (expr instanceof SlotRef) {
                    SlotRef slotRef = (SlotRef) expr.clone();
                    sb.append("`").append(slotRef.getColumnName()).append("`").append(",");
                }
                if (expr instanceof FunctionCallExpr) {
                    Expr cloneExpr = expr.clone();
                    for (int i = 0; i < cloneExpr.getChildren().size(); i++) {
                        Expr child = cloneExpr.getChildren().get(i);
                        if (child instanceof SlotRef) {
                            cloneExpr.setChild(i, new SlotRef(null, ((SlotRef) child).getColumnName()));
                            break;
                        }
                    }
                    sb.append(cloneExpr.toSql()).append(",");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            return sb.toString();
        }
        if (!automaticPartition) {
            sb.append("RANGE(");
        }
        List<String> partitionExprDesc = Lists.newArrayList();
        for (Expr partitionExpr : partitionExprs) {
            if (partitionExpr instanceof CastExpr && isTimestampFunction(partitionExpr)) {
                partitionExprDesc.add(partitionExpr.getChild(0).toSql());
            } else {
                partitionExprDesc.add(partitionExpr.toSql());
            }
        }
        sb.append(Joiner.on(", ").join(partitionExprDesc));
        if (!automaticPartition) {
            sb.append(")\n(");
            // sort range
            List<Map.Entry<Long, Range<PartitionKey>>> entries = new ArrayList<>(this.idToRange.entrySet());
            entries.sort(RangeUtils.RANGE_MAP_ENTRY_COMPARATOR);

            int idx = 0;
            PartitionInfo tblPartitionInfo = table.getPartitionInfo();

            String replicationNumStr = table.getTableProperty().getProperties().get("replication_num");
            short replicationNum;
            if (replicationNumStr == null) {
                replicationNum = RunMode.defaultReplicationNum();
            } else {
                replicationNum = Short.parseShort(replicationNumStr);
            }

            for (Map.Entry<Long, Range<PartitionKey>> entry : entries) {
                Partition partition = table.getPartition(entry.getKey());
                String partitionName = partition.getName();
                Range<PartitionKey> range = entry.getValue();

                // print all partitions' range is fixed range, even if some of them is created by less than range
                sb.append("PARTITION ").append(partitionName).append(" VALUES [");
                sb.append(range.lowerEndpoint().toSql());
                sb.append(", ").append(range.upperEndpoint().toSql()).append(")");

                if (partitionId != null) {
                    partitionId.add(entry.getKey());
                    break;
                }
                short curPartitionReplicationNum = tblPartitionInfo.getReplicationNum(entry.getKey());
                if (curPartitionReplicationNum != replicationNum) {
                    sb.append("(").append("\"replication_num\" = \"").append(curPartitionReplicationNum).append("\")");
                }
                if (idx != entries.size() - 1) {
                    sb.append(",\n");
                }
                idx++;
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public static boolean isTimestampFunction(Expr partitionExpr) {
        if (partitionExpr instanceof CastExpr) {
            CastExpr castExpr = (CastExpr) partitionExpr;
            if (!castExpr.getChildren().isEmpty()) {
                Expr subExpr = castExpr.getChild(0);
                if (subExpr instanceof FunctionCallExpr) {
                    FunctionCallExpr functionCallExpr = (FunctionCallExpr) subExpr;
                    String functionName = functionCallExpr.getFnName().getFunction();
                    return FunctionSet.FROM_UNIXTIME.equals(functionName)
                            || FunctionSet.FROM_UNIXTIME_MS.equals(functionName);
                }
            }
        }
        return false;
    }

    public static boolean supportedDynamicPartition(Expr expr) {
        if (isTimestampFunction(expr)) {
            return true;
        }
        if (expr instanceof FunctionCallExpr) {
            FunctionCallExpr functionCallExpr = (FunctionCallExpr) expr;
            String functionName = functionCallExpr.getFnName().getFunction();
            return FunctionSet.STR2DATE.equals(functionName);
        }
        return false;
    }

    public List<Expr> getPartitionExprs() {
        return partitionExprs;
    }

    public void setPartitionExprs(List<Expr> partitionExprs) {
        this.partitionExprs = partitionExprs;
    }

    public List<String> getSerializedPartitionExprs() {
        return serializedPartitionExprs;
    }

    public void setSerializedPartitionExprs(List<String> serializedPartitionExprs) {
        this.serializedPartitionExprs = serializedPartitionExprs;
    }

    @Override
    public boolean isAutomaticPartition() {
        return automaticPartition;
    }

    public void setAutomaticPartition(Boolean automaticPartition) {
        this.automaticPartition = automaticPartition;
    }

    public List<Type> getSourcePartitionTypes() {
        return sourcePartitionTypes;
    }

    public void setSourcePartitionTypes(List<Type> sourcePartitionTypes) {
        this.sourcePartitionTypes = sourcePartitionTypes;
    }
}
