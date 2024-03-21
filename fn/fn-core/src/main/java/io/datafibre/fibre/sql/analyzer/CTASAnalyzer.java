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

package io.datafibre.fibre.sql.analyzer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.FunctionCallExpr;
import io.datafibre.fibre.analysis.KeysDesc;
import io.datafibre.fibre.analysis.SlotRef;
import io.datafibre.fibre.analysis.TableName;
import io.datafibre.fibre.analysis.TypeDef;
import io.datafibre.fibre.catalog.KeysType;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.common.Pair;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.server.RunMode;
import io.datafibre.fibre.sql.ast.ColumnDef;
import io.datafibre.fibre.sql.ast.CreateTableAsSelectStmt;
import io.datafibre.fibre.sql.ast.CreateTableStmt;
import io.datafibre.fibre.sql.ast.DistributionDesc;
import io.datafibre.fibre.sql.ast.ExpressionPartitionDesc;
import io.datafibre.fibre.sql.ast.HashDistributionDesc;
import io.datafibre.fibre.sql.ast.InsertStmt;
import io.datafibre.fibre.sql.ast.ListPartitionDesc;
import io.datafibre.fibre.sql.ast.MultiRangePartitionDesc;
import io.datafibre.fibre.sql.ast.PartitionDesc;
import io.datafibre.fibre.sql.ast.QueryStatement;
import io.datafibre.fibre.sql.ast.RandomDistributionDesc;
import io.datafibre.fibre.sql.ast.RangePartitionDesc;
import io.datafibre.fibre.sql.optimizer.statistics.ColumnStatistic;
import io.datafibre.fibre.sql.optimizer.statistics.StatisticStorage;
import io.datafibre.fibre.sql.parser.ParsingException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CTASAnalyzer {
    public static void analyze(CreateTableAsSelectStmt createTableAsSelectStmt, ConnectContext session) {
        List<String> columnNames = createTableAsSelectStmt.getColumnNames();
        QueryStatement queryStatement = createTableAsSelectStmt.getQueryStatement();
        CreateTableStmt createTableStmt = createTableAsSelectStmt.getCreateTableStmt();

        if (createTableStmt.isExternal()) {
            throw new SemanticException("CTAS does not support create external table");
        }

        Analyzer.analyze(queryStatement, session);

        // Pair<TableName, Pair<ColumnName, ColumnAlias>>
        Map<Pair<String, Pair<String, String>>, Table> columnNameToTable = Maps.newHashMap();
        Map<TableName, Table> tables = AnalyzerUtils.collectAllTableWithAlias(queryStatement);
        Map<String, Table> tableRefToTable = new HashMap<>();
        for (Map.Entry<TableName, Table> t : tables.entrySet()) {
            tableRefToTable.put(t.getKey().getTbl(), t.getValue());
        }

        List<Field> allFields = queryStatement.getQueryRelation().getRelationFields().getAllFields();
        List<String> finalColumnNames = Lists.newArrayList();

        if (columnNames != null) {
            if (columnNames.size() != allFields.size()) {
                throw new SemanticException("Number of select columns [%d] don't equal query statement's columns [%d]",
                        columnNames.size(), allFields.size());
            }
            finalColumnNames.addAll(columnNames);
        } else {
            for (Field allField : allFields) {
                finalColumnNames.add(allField.getName());
            }
        }

        boolean isPKTable = false;
        KeysDesc keysDesc = createTableStmt.getKeysDesc();
        if (keysDesc != null) {
            KeysType keysType = keysDesc.getKeysType();
            if (keysType == KeysType.PRIMARY_KEYS) {
                isPKTable = true;
            } else if (keysType != KeysType.DUP_KEYS) {
                throw new SemanticException("CTAS does not support %s table", keysDesc.getKeysType().toString());
            }
        }

        for (int i = 0; i < allFields.size(); i++) {
            Type type = AnalyzerUtils.transformTableColumnType(allFields.get(i).getType());
            Expr originExpression = allFields.get(i).getOriginExpression();
            ColumnDef columnDef = new ColumnDef(finalColumnNames.get(i), new TypeDef(type), false,
                    null, originExpression.isNullable(), ColumnDef.DefaultValueDef.NOT_SET, "");
            if (isPKTable && keysDesc.containsCol(finalColumnNames.get(i))) {
                columnDef.setAllowNull(false);
            }
            createTableStmt.addColumnDef(columnDef);
            if (originExpression instanceof SlotRef) {
                SlotRef slotRef = (SlotRef) originExpression;
                // lateral json_each(parse_json(c1)) will return null
                if (slotRef.getTblNameWithoutAnalyzed() == null) {
                    continue;
                }
                String tableName = slotRef.getTblNameWithoutAnalyzed().getTbl();
                Table table = tableRefToTable.get(tableName);
                if (!(table instanceof OlapTable)) {
                    continue;
                }
                columnNameToTable.put(new Pair<>(tableName,
                        new Pair<>(slotRef.getColumnName(), allFields.get(i).getName())), table);
            }
        }

        // For replication_num, The behavior is the same as creating a table
        int defaultReplicationNum = RunMode.defaultReplicationNum();

        Map<String, String> stmtProperties = createTableStmt.getProperties();
        if (null == stmtProperties) {
            Map<String, String> properties = Maps.newHashMap();
            properties.put("replication_num", String.valueOf(defaultReplicationNum));
            createTableStmt.setProperties(properties);
        } else if (!stmtProperties.containsKey("replication_num")) {
            stmtProperties.put("replication_num", String.valueOf(defaultReplicationNum));
        }

        if (null == createTableStmt.getDistributionDesc()) {
            if ((createTableStmt.getKeysDesc() != null && createTableStmt.getKeysDesc().getKeysType() != KeysType.DUP_KEYS)
                    || createTableStmt.getProperties().containsKey("colocate_with")) {
                // For HashDistributionDesc key
                // If we have statistics cache, we pick the column with the highest cardinality in the statistics,
                // if we don't, we pick the first column
                String defaultColumnName = finalColumnNames.get(0);
                double candidateDistinctCountCount = 1.0;
                StatisticStorage currentStatisticStorage = GlobalStateMgr.getCurrentState().getStatisticStorage();

                for (Map.Entry<Pair<String, Pair<String, String>>, Table> columnEntry : columnNameToTable.entrySet()) {
                    Pair<String, String> columnName = columnEntry.getKey().second;
                    ColumnStatistic columnStatistic = currentStatisticStorage.getColumnStatistic(
                            columnEntry.getValue(), columnName.first);
                    double curDistinctValuesCount = columnStatistic.getDistinctValuesCount();
                    if (curDistinctValuesCount > candidateDistinctCountCount) {
                        defaultColumnName = columnName.second;
                        candidateDistinctCountCount = curDistinctValuesCount;
                    }
                }

                DistributionDesc distributionDesc =
                        new HashDistributionDesc(0, Lists.newArrayList(defaultColumnName));
                createTableStmt.setDistributionDesc(distributionDesc);
            } else {
                // no specified distribution, use random distribution
                DistributionDesc distributionDesc = new RandomDistributionDesc();
                createTableStmt.setDistributionDesc(distributionDesc);
            }
        }

        PartitionDesc partitionDesc = createTableStmt.getPartitionDesc();
        List<ColumnDef> columnDefs = createTableStmt.getColumnDefs();

        if (partitionDesc instanceof ExpressionPartitionDesc) {
            ExpressionPartitionDesc expressionPartitionDesc = (ExpressionPartitionDesc) partitionDesc;
            FunctionCallExpr functionCallExpr = (FunctionCallExpr) expressionPartitionDesc.getExpr();
            AnalyzerUtils.checkAndExtractPartitionCol(functionCallExpr, columnDefs);
            String currentGranularity = null;
            RangePartitionDesc rangePartitionDesc = expressionPartitionDesc.getRangePartitionDesc();
            if (!rangePartitionDesc.getSingleRangePartitionDescs().isEmpty()) {
                throw new ParsingException("Automatic partition table creation only supports " +
                        "batch create partition syntax", rangePartitionDesc.getPos());
            }
            List<MultiRangePartitionDesc> multiRangePartitionDescs = rangePartitionDesc.getMultiRangePartitionDescs();
            for (MultiRangePartitionDesc multiRangePartitionDesc : multiRangePartitionDescs) {
                String descGranularity = multiRangePartitionDesc.getTimeUnit().toLowerCase();
                if (currentGranularity == null) {
                    currentGranularity = descGranularity;
                } else if (!currentGranularity.equals(descGranularity)) {
                    throw new ParsingException("The partition granularity of automatic partition table " +
                            "batch creation in advance should be consistent", rangePartitionDesc.getPos());
                }
            }
            AnalyzerUtils.checkAutoPartitionTableLimit(functionCallExpr, currentGranularity);
            rangePartitionDesc.setAutoPartitionTable(true);
        } else if (partitionDesc instanceof ListPartitionDesc) {
            for (ColumnDef columnDef : columnDefs) {
                for (String partitionColName : ((ListPartitionDesc) partitionDesc).getPartitionColNames()) {
                    if (columnDef.getName().equalsIgnoreCase(partitionColName)) {
                        columnDef.setAllowNull(false);
                    }
                }
            }
        }

        Analyzer.analyze(createTableStmt, session);

        InsertStmt insertStmt = createTableAsSelectStmt.getInsertStmt();
        insertStmt.setQueryStatement(queryStatement);
    }

}