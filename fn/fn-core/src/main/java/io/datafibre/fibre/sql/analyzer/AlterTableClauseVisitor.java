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

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.datafibre.fibre.alter.AlterOpType;
import io.datafibre.fibre.analysis.ColumnPosition;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.FunctionCallExpr;
import io.datafibre.fibre.analysis.IndexDef;
import io.datafibre.fibre.analysis.IndexDef.IndexType;
import io.datafibre.fibre.analysis.IntLiteral;
import io.datafibre.fibre.analysis.KeysDesc;
import io.datafibre.fibre.analysis.SlotRef;
import io.datafibre.fibre.analysis.TableName;
import io.datafibre.fibre.catalog.AggregateType;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.DataProperty;
import io.datafibre.fibre.catalog.HashDistributionInfo;
import io.datafibre.fibre.catalog.Index;
import io.datafibre.fibre.catalog.KeysType;
import io.datafibre.fibre.catalog.MaterializedView;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.Partition;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.TableProperty;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.common.ErrorCode;
import io.datafibre.fibre.common.ErrorReport;
import io.datafibre.fibre.common.util.DynamicPartitionUtil;
import io.datafibre.fibre.common.util.PropertyAnalyzer;
import io.datafibre.fibre.common.util.TimeUtils;
import io.datafibre.fibre.common.util.WriteQuorum;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.server.RunMode;
import io.datafibre.fibre.sql.ast.AddColumnClause;
import io.datafibre.fibre.sql.ast.AddColumnsClause;
import io.datafibre.fibre.sql.ast.AddRollupClause;
import io.datafibre.fibre.sql.ast.AlterClause;
import io.datafibre.fibre.sql.ast.AlterMaterializedViewStatusClause;
import io.datafibre.fibre.sql.ast.AstVisitor;
import io.datafibre.fibre.sql.ast.AsyncRefreshSchemeDesc;
import io.datafibre.fibre.sql.ast.ColumnDef;
import io.datafibre.fibre.sql.ast.ColumnRenameClause;
import io.datafibre.fibre.sql.ast.CompactionClause;
import io.datafibre.fibre.sql.ast.CreateIndexClause;
import io.datafibre.fibre.sql.ast.DistributionDesc;
import io.datafibre.fibre.sql.ast.DropColumnClause;
import io.datafibre.fibre.sql.ast.DropRollupClause;
import io.datafibre.fibre.sql.ast.HashDistributionDesc;
import io.datafibre.fibre.sql.ast.IntervalLiteral;
import io.datafibre.fibre.sql.ast.ModifyColumnClause;
import io.datafibre.fibre.sql.ast.ModifyPartitionClause;
import io.datafibre.fibre.sql.ast.ModifyTablePropertiesClause;
import io.datafibre.fibre.sql.ast.OptimizeClause;
import io.datafibre.fibre.sql.ast.PartitionNames;
import io.datafibre.fibre.sql.ast.PartitionRenameClause;
import io.datafibre.fibre.sql.ast.RandomDistributionDesc;
import io.datafibre.fibre.sql.ast.RefreshSchemeClause;
import io.datafibre.fibre.sql.ast.ReorderColumnsClause;
import io.datafibre.fibre.sql.ast.ReplacePartitionClause;
import io.datafibre.fibre.sql.ast.RollupRenameClause;
import io.datafibre.fibre.sql.ast.TableRenameClause;

import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static io.datafibre.fibre.sql.common.ErrorMsgProxy.PARSER_ERROR_MSG;

public class AlterTableClauseVisitor extends AstVisitor<Void, ConnectContext> {

    private Table table;

    public void setTable(Table table) {
        this.table = table;
    }

    public Table getTable() {
        return table;
    }

    public void analyze(AlterClause statement, ConnectContext session) {
        visit(statement, session);
    }

    @Override
    public Void visitCreateIndexClause(CreateIndexClause clause, ConnectContext context) {
        IndexDef indexDef = clause.getIndexDef();
        indexDef.analyze();
        Index index;
        // Only assign meaningful indexId for OlapTable
        if (table.isOlapTableOrMaterializedView()) {
            long indexId = IndexType.isCompatibleIndex(indexDef.getIndexType()) ? ((OlapTable) table).incAndGetMaxIndexId() : -1;
            index = new Index(indexId, indexDef.getIndexName(), indexDef.getColumns(),
                    indexDef.getIndexType(), indexDef.getComment(), indexDef.getProperties());
        } else {
            index = new Index(indexDef.getIndexName(), indexDef.getColumns(),
                    indexDef.getIndexType(), indexDef.getComment(), indexDef.getProperties());
        }
        clause.setIndex(index);
        return null;
    }

    @Override
    public Void visitTableRenameClause(TableRenameClause clause, ConnectContext context) {
        String newTableName = clause.getNewTableName();
        if (Strings.isNullOrEmpty(newTableName)) {
            throw new SemanticException("New Table name is not set");
        }
        if (table.getName().equals(newTableName)) {
            throw new SemanticException("Same table name " + newTableName, clause.getPos());
        }
        FeNameFormat.checkTableName(newTableName);
        return null;
    }

    @Override
    public Void visitModifyTablePropertiesClause(ModifyTablePropertiesClause clause, ConnectContext context) {
        Map<String, String> properties = clause.getProperties();
        if (properties.isEmpty()) {
            ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, "Properties is not set");
        }

        if (table.isExternalTableWithFileSystem()) {
            return null;
        }

        if (properties.size() != 1
                && !(TableProperty.isSamePrefixProperties(properties, TableProperty.DYNAMIC_PARTITION_PROPERTY_PREFIX)
                || TableProperty.isSamePrefixProperties(properties, TableProperty.BINLOG_PROPERTY_PREFIX))) {
            ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, "Can only set one table property at a time");
        }

        if (properties.containsKey(PropertyAnalyzer.PROPERTIES_COLOCATE_WITH)) {
            clause.setNeedTableStable(false);
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_STORAGE_TYPE)) {
            ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, "Can't change storage type");
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_DISTRIBUTION_TYPE)) {
            if (!properties.get(PropertyAnalyzer.PROPERTIES_DISTRIBUTION_TYPE).equalsIgnoreCase("hash")) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, "Can only change distribution type to HASH");
            }
            clause.setNeedTableStable(false);
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_SEND_CLEAR_ALTER_TASK)) {
            if (!properties.get(PropertyAnalyzer.PROPERTIES_SEND_CLEAR_ALTER_TASK).equalsIgnoreCase("true")) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR,
                        "Property " + PropertyAnalyzer.PROPERTIES_SEND_CLEAR_ALTER_TASK + " should be set to true");
            }
            clause.setNeedTableStable(false);
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_BF_COLUMNS)
                || properties.containsKey(PropertyAnalyzer.PROPERTIES_BF_FPP)) {
            // do nothing, these 2 properties will be analyzed when creating alter job
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_WRITE_QUORUM)) {
            if (WriteQuorum.findTWriteQuorumByName(properties.get(PropertyAnalyzer.PROPERTIES_WRITE_QUORUM)) == null) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR,
                        "Property " + PropertyAnalyzer.PROPERTIES_WRITE_QUORUM + " not valid");
            }
            clause.setNeedTableStable(false);
            clause.setOpType(AlterOpType.MODIFY_TABLE_PROPERTY_SYNC);
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_LABELS_LOCATION)) {
            try {
                PropertyAnalyzer.analyzeLocation(properties, false);
            } catch (SemanticException e) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR,
                        "Property " + PropertyAnalyzer.PROPERTIES_LABELS_LOCATION + " not valid");
            }
            clause.setNeedTableStable(false);
        } else if (DynamicPartitionUtil.checkDynamicPartitionPropertiesExist(properties)) {
            // do nothing, dynamic properties will be analyzed in SchemaChangeHandler.process
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_PARTITION_LIVE_NUMBER)) {
            try {
                PropertyAnalyzer.analyzePartitionLiveNumber(properties, false);
            } catch (AnalysisException e) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, e.getMessage());
            }
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_REPLICATION_NUM)) {
            try {
                PropertyAnalyzer.analyzeReplicationNum(properties, false);
            } catch (AnalysisException e) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, e.getMessage());
            }
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_STORAGE_COOLDOWN_TTL)) {
            String storageCoolDownTTL = properties.get(PropertyAnalyzer.PROPERTIES_STORAGE_COOLDOWN_TTL);
            try {
                PropertyAnalyzer.analyzeStorageCoolDownTTL(properties, true);
            } catch (AnalysisException e) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, e.getMessage());
            }
            properties.put(PropertyAnalyzer.PROPERTIES_STORAGE_COOLDOWN_TTL, storageCoolDownTTL);
        } else if (properties.containsKey("default." + PropertyAnalyzer.PROPERTIES_REPLICATION_NUM)) {
            short defaultReplicationNum = 0;
            try {
                defaultReplicationNum = PropertyAnalyzer.analyzeReplicationNum(properties, true);
            } catch (AnalysisException e) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, e.getMessage());
            }
            properties.put(PropertyAnalyzer.PROPERTIES_REPLICATION_NUM, Short.toString(defaultReplicationNum));
        } else if (properties.containsKey("default." + PropertyAnalyzer.PROPERTIES_STORAGE_MEDIUM)) {
            String storageMedium = properties.remove("default." + PropertyAnalyzer.PROPERTIES_STORAGE_MEDIUM);
            properties.put(PropertyAnalyzer.PROPERTIES_STORAGE_MEDIUM, storageMedium);
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_INMEMORY)) {
            clause.setNeedTableStable(false);
            clause.setOpType(AlterOpType.MODIFY_TABLE_PROPERTY_SYNC);
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_PRIMARY_INDEX_CACHE_EXPIRE_SEC)) {
            String valStr = properties.get(PropertyAnalyzer.PROPERTIES_PRIMARY_INDEX_CACHE_EXPIRE_SEC);
            try {
                int val = Integer.parseInt(valStr);
                if (val < 0) {
                    ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, "Property "
                            + PropertyAnalyzer.PROPERTIES_PRIMARY_INDEX_CACHE_EXPIRE_SEC + " must not be less than 0");
                }
            } catch (NumberFormatException e) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, "Property "
                        + PropertyAnalyzer.PROPERTIES_PRIMARY_INDEX_CACHE_EXPIRE_SEC + " must be integer: " + valStr);
            }
            clause.setNeedTableStable(false);
            clause.setOpType(AlterOpType.MODIFY_TABLE_PROPERTY_SYNC);
        }  else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_ENABLE_PERSISTENT_INDEX)) {
            if (!properties.get(PropertyAnalyzer.PROPERTIES_ENABLE_PERSISTENT_INDEX).equalsIgnoreCase("true") &&
                    !properties.get(PropertyAnalyzer.PROPERTIES_ENABLE_PERSISTENT_INDEX).equalsIgnoreCase("false")) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR,
                        "Property " + PropertyAnalyzer.PROPERTIES_ENABLE_PERSISTENT_INDEX +
                                " must be bool type(false/true)");
            }
            clause.setNeedTableStable(false);
            clause.setOpType(AlterOpType.MODIFY_TABLE_PROPERTY_SYNC);
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_REPLICATED_STORAGE)) {
            if (!properties.get(PropertyAnalyzer.PROPERTIES_REPLICATED_STORAGE).equalsIgnoreCase("true") &&
                    !properties.get(PropertyAnalyzer.PROPERTIES_REPLICATED_STORAGE).equalsIgnoreCase("false")) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR,
                        "Property " + PropertyAnalyzer.PROPERTIES_REPLICATED_STORAGE +
                                " must be bool type(false/true)");
            }
            clause.setNeedTableStable(false);
            clause.setOpType(AlterOpType.MODIFY_TABLE_PROPERTY_SYNC);
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_BUCKET_SIZE)) {
            try {
                PropertyAnalyzer.analyzeBucketSize(properties);
            } catch (AnalysisException e) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, e.getMessage());
            }
            clause.setNeedTableStable(false);
            clause.setOpType(AlterOpType.MODIFY_TABLE_PROPERTY_SYNC);
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_BINLOG_ENABLE) ||
                properties.containsKey(PropertyAnalyzer.PROPERTIES_BINLOG_TTL) ||
                properties.containsKey(PropertyAnalyzer.PROPERTIES_BINLOG_MAX_SIZE)) {

            if (properties.containsKey(PropertyAnalyzer.PROPERTIES_BINLOG_ENABLE)) {
                String binlogEnable = properties.get(PropertyAnalyzer.PROPERTIES_BINLOG_ENABLE);
                if (!(binlogEnable.equals("false") || binlogEnable.equals("true"))) {
                    ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR,
                            "Property " + PropertyAnalyzer.PROPERTIES_BINLOG_ENABLE +
                                    " must be true of false");
                }
                if (properties.containsKey(PropertyAnalyzer.PROPERTIES_BINLOG_TTL)) {
                    try {
                        Long.parseLong(properties.get(PropertyAnalyzer.PROPERTIES_BINLOG_TTL));
                    } catch (NumberFormatException e) {
                        ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR,
                                "Property " + PropertyAnalyzer.PROPERTIES_BINLOG_TTL +
                                        " must be long");
                    }
                }
                if (properties.containsKey(PropertyAnalyzer.PROPERTIES_BINLOG_MAX_SIZE)) {
                    try {
                        Long.parseLong(properties.get(PropertyAnalyzer.PROPERTIES_BINLOG_MAX_SIZE));
                    } catch (NumberFormatException e) {
                        ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR,
                                "Property " + PropertyAnalyzer.PROPERTIES_BINLOG_MAX_SIZE +
                                        " must be long");
                    }
                }
            }
            clause.setNeedTableStable(false);
            clause.setOpType(AlterOpType.MODIFY_TABLE_PROPERTY_SYNC);
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_TABLET_TYPE)) {
            ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, "Alter tablet type not supported");
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_FOREIGN_KEY_CONSTRAINT)
                || properties.containsKey(PropertyAnalyzer.PROPERTIES_UNIQUE_CONSTRAINT)) {
            clause.setNeedTableStable(false);
            clause.setOpType(AlterOpType.MODIFY_TABLE_PROPERTY_SYNC);
        } else if (properties.containsKey(PropertyAnalyzer.PROPERTIES_DATACACHE_PARTITION_DURATION)) {
            try {
                TimeUtils.parseHumanReadablePeriodOrDuration(
                        properties.get(PropertyAnalyzer.PROPERTIES_DATACACHE_PARTITION_DURATION));
            } catch (DateTimeParseException e) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, e.getMessage());
            }
            clause.setNeedTableStable(false);
        } else {
            ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, "Unknown properties: " + properties);
        }
        return null;
    }

    @Override
    public Void visitModifyPartitionClause(ModifyPartitionClause clause, ConnectContext context) {
        final List<String> partitionNames = clause.getPartitionNames();
        final boolean needExpand = clause.isNeedExpand();
        final Map<String, String> properties = clause.getProperties();
        if (partitionNames == null || (!needExpand && partitionNames.isEmpty())) {
            throw new SemanticException("Partition names is not set or empty");
        }

        if (partitionNames.stream().anyMatch(Strings::isNullOrEmpty)) {
            throw new SemanticException("there are empty partition name");
        }

        if (properties == null || properties.isEmpty()) {
            throw new SemanticException("Properties is not set");
        }

        // check properties here
        try {
            checkProperties(Maps.newHashMap(properties));
        } catch (AnalysisException e) {
            throw new SemanticException("check properties error: %s", e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitOptimizeClause(OptimizeClause clause, ConnectContext context) {
        if (!(table instanceof OlapTable)) {
            ErrorReport.reportSemanticException(ErrorCode.ERR_NOT_OLAP_TABLE, table.getName());
        }
        OlapTable olapTable = (OlapTable) table;
        if (olapTable.getColocateGroup() != null) {
            ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, "Optimize table in colocate group is not supported");
        }

        if (olapTable.isCloudNativeTableOrMaterializedView()) {
            ErrorReport.reportSemanticException(ErrorCode.ERR_COMMON_ERROR, "Optimize table in cloud native is not supported");
        }

        List<Integer> sortKeyIdxes = Lists.newArrayList();
        List<ColumnDef> columnDefs = olapTable.getColumns().stream().map(Column::toColumnDef).collect(Collectors.toList());
        if (clause.getSortKeys() != null) {
            List<String> columnNames = columnDefs.stream().map(ColumnDef::getName).collect(Collectors.toList());

            for (String column : clause.getSortKeys()) {
                int idx = columnNames.indexOf(column);
                if (idx == -1) {
                    throw new SemanticException("Unknown column '%s' does not exist", column);
                }
                sortKeyIdxes.add(idx);
            }
        }
        boolean hasReplace = false;
        Set<String> columnSet = Sets.newTreeSet(String.CASE_INSENSITIVE_ORDER);
        for (ColumnDef columnDef : columnDefs) {
            if (columnDef.getAggregateType() != null && columnDef.getAggregateType().isReplaceFamily()) {
                hasReplace = true;
            }
            if (!columnSet.add(columnDef.getName())) {
                ErrorReport.reportSemanticException(ErrorCode.ERR_DUP_FIELDNAME, columnDef.getName());
            }
        }

        // analyze key desc
        KeysType originalKeysType = olapTable.getKeysType();
        KeysDesc keysDesc = clause.getKeysDesc();
        if (keysDesc != null) {
            throw new SemanticException("not support change keys type when optimize table");
        }
        KeysType targetKeysType = keysDesc == null ? originalKeysType : keysDesc.getKeysType();

        // analyze distribution
        DistributionDesc distributionDesc = clause.getDistributionDesc();
        if (distributionDesc != null) {
            if (distributionDesc instanceof RandomDistributionDesc && targetKeysType != KeysType.DUP_KEYS
                    && !(targetKeysType == KeysType.AGG_KEYS && !hasReplace)) {
                throw new SemanticException(targetKeysType.toSql() + (hasReplace ? " with replace " : "")
                        + " must use hash distribution", distributionDesc.getPos());
            }
            distributionDesc.analyze(columnSet);
            clause.setDistributionDesc(distributionDesc);

            if (distributionDesc.getType() != olapTable.getDefaultDistributionInfo().getType()
                    && clause.getPartitionNames() != null) {
                throw new SemanticException("not support change distribution type when specify partitions");
            }
        }

        // analyze partitions
        PartitionNames partitionNames = clause.getPartitionNames();
        if (partitionNames != null) {
            if (clause.getSortKeys() != null || clause.getKeysDesc() != null) {
                throw new SemanticException("not support change sort keys or keys type when specify partitions");
            }
            if (partitionNames.isTemp()) {
                throw new SemanticException("not support optimize temp partition");
            }
            List<String> partitionNameList = partitionNames.getPartitionNames();
            if (partitionNameList == null || partitionNameList.isEmpty()) {
                throw new SemanticException("partition names is empty");
            }

            if (distributionDesc instanceof HashDistributionDesc
                    && olapTable.getDefaultDistributionInfo() instanceof HashDistributionInfo) {
                HashDistributionDesc hashDistributionDesc = (HashDistributionDesc) distributionDesc;
                HashDistributionInfo hashDistributionInfo = (HashDistributionInfo) olapTable.getDefaultDistributionInfo();
                Set<String> orginalPartitionColumn = hashDistributionInfo.getDistributionColumns()
                        .stream().map(Column::getName).collect(Collectors.toSet());
                Set<String> newPartitionColumn = hashDistributionDesc.getDistributionColumnNames()
                        .stream().collect(Collectors.toSet());
                if (!orginalPartitionColumn.equals(newPartitionColumn)) {
                    throw new SemanticException("not support change distribution column when specify partitions");
                }
            }

            List<Long> partitionIds = Lists.newArrayList();
            for (String partitionName : partitionNameList) {
                Partition partition = olapTable.getPartition(partitionName);
                if (partition == null) {
                    throw new SemanticException("partition %s does not exist", partitionName);
                }
                partitionIds.add(partition.getId());
            }
            clause.setSourcePartitionIds(partitionIds);
        } else {
            clause.setSourcePartitionIds(olapTable.getPartitions().stream().map(Partition::getId).collect(Collectors.toList()));
            clause.setTableOptimize(true);
        }


        return null;
    }

    @Override
    public Void visitAddColumnClause(AddColumnClause clause, ConnectContext context) {
        ColumnDef columnDef = clause.getColumnDef();
        if (columnDef == null) {
            throw new SemanticException("No column definition in add column clause.");
        }
        try {
            if (table.isOlapTable() && ((OlapTable) table).getKeysType() == KeysType.PRIMARY_KEYS) {
                columnDef.setAggregateType(AggregateType.REPLACE);
            }
            columnDef.analyze(true);
        } catch (AnalysisException e) {
            throw new SemanticException(PARSER_ERROR_MSG.invalidColumnDef(e.getMessage()), columnDef.getPos());
        }

        if (columnDef.getType().isTime()) {
            throw new SemanticException("Unsupported data type: TIME");
        }

        if (columnDef.isGeneratedColumn()) {
            if (!table.isOlapTable()) {
                throw new SemanticException("Generated Column only support olap table");
            }

            if (table.isCloudNativeTable()) {
                throw new SemanticException("Lake table does not support generated column");
            }

            if (((OlapTable) table).getKeysType() == KeysType.AGG_KEYS) {
                throw new SemanticException("Generated Column does not support AGG table");
            }

            clause.setRollupName(Strings.emptyToNull(clause.getRollupName()));

            Expr expr = columnDef.generatedColumnExpr();
            TableName tableName = new TableName(context.getDatabase(), table.getName());

            ExpressionAnalyzer.analyzeExpression(expr, new AnalyzeState(), new Scope(RelationId.anonymous(),
                    new RelationFields(table.getBaseSchema().stream().map(col -> new Field(col.getName(), col.getType(),
                                    tableName, null))
                            .collect(Collectors.toList()))), context);

            // check if contain aggregation
            List<FunctionCallExpr> funcs = Lists.newArrayList();
            expr.collect(FunctionCallExpr.class, funcs);
            for (FunctionCallExpr fn : funcs) {
                if (fn.isAggregateFunction()) {
                    throw new SemanticException("Generated Column don't support aggregation function");
                }
            }

            // check if the expression refers to other generated columns
            List<SlotRef> slots = Lists.newArrayList();
            expr.collect(SlotRef.class, slots);
            if (slots.size() != 0) {
                for (SlotRef slot : slots) {
                    Column refColumn = table.getColumn(slot.getColumnName());
                    if (refColumn.isGeneratedColumn()) {
                        throw new SemanticException("Expression can not refers to other generated columns: " +
                                refColumn.getName());
                    }
                    if (refColumn.isAutoIncrement()) {
                        throw new SemanticException("Expression can not refers to AUTO_INCREMENT columns: " +
                                refColumn.getName());
                    }
                }
            }

            if (!columnDef.getType().matchesType(expr.getType())) {
                throw new SemanticException("Illege expression type for Generated Column " +
                        "Column Type: " + columnDef.getType().toString() +
                        ", Expression Type: " + expr.getType().toString());
            }
            clause.setColumn(columnDef.toColumn());
            return null;
        }

        ColumnPosition colPos = clause.getColPos();
        if (colPos == null && table instanceof OlapTable && ((OlapTable) table).hasGeneratedColumn()) {
            List<Column> baseSchema = ((OlapTable) table).getBaseSchema();
            if (baseSchema.size() > 1) {
                for (int columnIdx = 0; columnIdx < baseSchema.size() - 1; ++columnIdx) {
                    if (!baseSchema.get(columnIdx).isGeneratedColumn() &&
                            baseSchema.get(columnIdx + 1).isGeneratedColumn()) {
                        clause.setColPos(new ColumnPosition(baseSchema.get(columnIdx).getName()));
                        break;
                    }
                }
            }
        }
        if (colPos != null) {
            try {
                colPos.analyze();
            } catch (AnalysisException e) {
                throw new SemanticException(PARSER_ERROR_MSG.invalidColumnPos(e.getMessage()), colPos.getPos());
            }
        }

        if (!columnDef.isAllowNull() && columnDef.defaultValueIsNull()) {
            throw new SemanticException(PARSER_ERROR_MSG.withOutDefaultVal(columnDef.getName()), columnDef.getPos());
        }

        if (columnDef.getAggregateType() != null && colPos != null && colPos.isFirst()) {
            throw new SemanticException("Cannot add value column[" + columnDef.getName() + "] at first",
                    columnDef.getPos());
        }

        // Make sure return null if rollup name is empty.
        clause.setRollupName(Strings.emptyToNull(clause.getRollupName()));

        clause.setColumn(columnDef.toColumn());
        return null;
    }

    @Override
    public Void visitAddColumnsClause(AddColumnsClause clause, ConnectContext context) {
        List<ColumnDef> columnDefs = clause.getColumnDefs();
        if (columnDefs == null || columnDefs.isEmpty()) {
            throw new SemanticException("Columns is empty in add columns clause.");
        }
        boolean hasGeneratedColumn = false;
        boolean hasNormalColumn = false;
        for (ColumnDef colDef : columnDefs) {
            try {
                if (table.isOlapTable() && ((OlapTable) table).getKeysType() == KeysType.PRIMARY_KEYS) {
                    colDef.setAggregateType(AggregateType.REPLACE);
                }
                colDef.analyze(true);
            } catch (AnalysisException e) {
                throw new SemanticException(PARSER_ERROR_MSG.invalidColumnDef(e.getMessage()), colDef.getPos());
            }
            if (!colDef.isAllowNull() && colDef.defaultValueIsNull()) {
                throw new SemanticException(PARSER_ERROR_MSG.withOutDefaultVal(colDef.getName()), colDef.getPos());
            }

            if (colDef.isGeneratedColumn()) {
                hasGeneratedColumn = true;

                if (!table.isOlapTable()) {
                    throw new SemanticException("Generated Column only support olap table");
                }

                if (table.isCloudNativeTable()) {
                    throw new SemanticException("Lake table does not support generated column");
                }

                if (((OlapTable) table).getKeysType() == KeysType.AGG_KEYS) {
                    throw new SemanticException("Generated Column does not support AGG table");
                }

                Expr expr = colDef.generatedColumnExpr();
                TableName tableName = new TableName(context.getDatabase(), table.getName());

                ExpressionAnalyzer.analyzeExpression(expr, new AnalyzeState(), new Scope(RelationId.anonymous(),
                        new RelationFields(table.getBaseSchema().stream().map(col -> new Field(col.getName(), col.getType(),
                                        tableName, null))
                                .collect(Collectors.toList()))), context);

                // check if contain aggregation
                List<FunctionCallExpr> funcs = Lists.newArrayList();
                expr.collect(FunctionCallExpr.class, funcs);
                for (FunctionCallExpr fn : funcs) {
                    if (fn.isAggregateFunction()) {
                        throw new SemanticException("Generated Column don't support aggregation function");
                    }
                }

                // check if the expression refers to other generated columns
                List<SlotRef> slots = Lists.newArrayList();
                expr.collect(SlotRef.class, slots);
                if (slots.size() != 0) {
                    for (SlotRef slot : slots) {
                        Column refColumn = table.getColumn(slot.getColumnName());
                        if (refColumn.isGeneratedColumn()) {
                            throw new SemanticException("Expression can not refers to other generated columns");
                        }
                        if (refColumn.isAutoIncrement()) {
                            throw new SemanticException("Expression can not refers to AUTO_INCREMENT columns");
                        }
                    }
                }

                if (!colDef.getType().matchesType(expr.getType())) {
                    throw new SemanticException("Illege expression type for Generated Column " +
                            "Column Type: " + colDef.getType().toString() +
                            ", Expression Type: " + expr.getType().toString());
                }
            } else {
                hasNormalColumn = true;
            }
        }

        if (hasGeneratedColumn && hasNormalColumn) {
            throw new SemanticException("Can not add normal column and Generated Column in the same time");
        }

        if (hasNormalColumn && table instanceof OlapTable && ((OlapTable) table).hasGeneratedColumn()) {
            List<Column> baseSchema = ((OlapTable) table).getBaseSchema();
            if (baseSchema.size() > 1) {
                for (int columnIdx = 0; columnIdx < baseSchema.size() - 1; ++columnIdx) {
                    if (!baseSchema.get(columnIdx).isGeneratedColumn() &&
                            baseSchema.get(columnIdx + 1).isGeneratedColumn()) {
                        ColumnPosition pos = new ColumnPosition(baseSchema.get(columnIdx).getName());
                        clause.setGeneratedColumnPos(pos);
                        break;
                    }
                }
            }
        }

        // Make sure return null if rollup name is empty.
        clause.setRollupName(Strings.emptyToNull(clause.getRollupName()));

        columnDefs.forEach(columnDef -> clause.addColumn(columnDef.toColumn()));
        return null;
    }

    @Override
    public Void visitDropColumnClause(DropColumnClause clause, ConnectContext context) {
        if (Strings.isNullOrEmpty(clause.getColName())) {
            throw new SemanticException(PARSER_ERROR_MSG.invalidColFormat(clause.getColName()));
        }
        clause.setRollupName(Strings.emptyToNull(clause.getRollupName()));

        for (Column column : table.getFullSchema()) {
            if (column.isGeneratedColumn()) {
                List<SlotRef> slots = column.getGeneratedColumnRef();
                for (SlotRef slot : slots) {
                    if (slot.getColumnName().equals(clause.getColName())) {
                        throw new SemanticException("Column: " + clause.getColName() + " can not be dropped" +
                                ", because expression of Generated Column: " +
                                column.getName() + " will refer to it");
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Void visitModifyColumnClause(ModifyColumnClause clause, ConnectContext context) {
        ColumnDef columnDef = clause.getColumnDef();
        if (columnDef == null) {
            throw new SemanticException("No column definition in modify column clause.");
        }
        try {
            if (table.isOlapTable() && ((OlapTable) table).getKeysType() == KeysType.PRIMARY_KEYS) {
                columnDef.setAggregateType(AggregateType.REPLACE);
            }
            columnDef.analyze(true);
        } catch (AnalysisException e) {
            throw new SemanticException(PARSER_ERROR_MSG.invalidColumnDef(e.getMessage()), columnDef.getPos());
        }

        if (columnDef.getType().isTime()) {
            throw new SemanticException("Unsupported data type: TIME");
        }

        if (columnDef.isGeneratedColumn()) {
            if (!(table instanceof OlapTable)) {
                throw new SemanticException("Generated Column only support olap table");
            }

            if (table.isCloudNativeTable()) {
                throw new SemanticException("Lake table does not support generated column");
            }

            if (((OlapTable) table).getKeysType() == KeysType.AGG_KEYS) {
                throw new SemanticException("Generated Column does not support AGG table");
            }

            clause.setRollupName(Strings.emptyToNull(clause.getRollupName()));

            Expr expr = columnDef.generatedColumnExpr();
            TableName tableName = new TableName(context.getDatabase(), table.getName());

            ExpressionAnalyzer.analyzeExpression(expr, new AnalyzeState(), new Scope(RelationId.anonymous(),
                    new RelationFields(table.getBaseSchema().stream().map(col -> new Field(col.getName(), col.getType(),
                                    tableName, null))
                            .collect(Collectors.toList()))), context);

            // check if contain aggregation
            List<FunctionCallExpr> funcs = Lists.newArrayList();
            expr.collect(FunctionCallExpr.class, funcs);
            for (FunctionCallExpr fn : funcs) {
                if (fn.isAggregateFunction()) {
                    throw new SemanticException("Generated Column don't support aggregation function");
                }
            }

            // check if the expression refers to other generated columns
            List<SlotRef> slots = Lists.newArrayList();
            expr.collect(SlotRef.class, slots);
            if (slots.size() != 0) {
                for (SlotRef slot : slots) {
                    Column refColumn = table.getColumn(slot.getColumnName());
                    if (refColumn.isGeneratedColumn()) {
                        throw new SemanticException("Expression can not refers to other generated columns: " +
                                refColumn.getName());
                    }
                    if (refColumn.isAutoIncrement()) {
                        throw new SemanticException("Expression can not refers to AUTO_INCREMENT columns: " +
                                refColumn.getName());
                    }
                }
            }

            if (!columnDef.getType().matchesType(expr.getType())) {
                throw new SemanticException("Illege expression type for Generated Column " +
                        "Column Type: " + columnDef.getType().toString() +
                        ", Expression Type: " + expr.getType().toString());
            }
            clause.setColumn(columnDef.toColumn());
            return null;
        }

        ColumnPosition colPos = clause.getColPos();
        if (colPos != null) {
            try {
                colPos.analyze();
            } catch (AnalysisException e) {
                throw new SemanticException(PARSER_ERROR_MSG.invalidColumnPos(e.getMessage()), colPos.getPos());
            }
        }
        if (colPos != null && table instanceof OlapTable && colPos.getLastCol() != null) {
            Column afterColumn = table.getColumn(colPos.getLastCol());
            if (afterColumn.isGeneratedColumn()) {
                throw new SemanticException("Can not modify column after Generated Column");
            }
        }

        clause.setRollupName(Strings.emptyToNull(clause.getRollupName()));

        clause.setColumn(columnDef.toColumn());
        return null;
    }

    @Override
    public Void visitColumnRenameClause(ColumnRenameClause clause, ConnectContext context) {
        if (Strings.isNullOrEmpty(clause.getColName())) {
            throw new SemanticException("Column name is not set");
        }

        if (Strings.isNullOrEmpty(clause.getNewColName())) {
            throw new SemanticException("New column name is not set");
        }

        FeNameFormat.checkColumnName(clause.getNewColName());
        return null;
    }

    @Override
    public Void visitReorderColumnsClause(ReorderColumnsClause clause, ConnectContext context) {
        List<String> columnsByPos = clause.getColumnsByPos();
        if (columnsByPos == null || columnsByPos.isEmpty()) {
            throw new SemanticException("No column in reorder columns clause.");
        }
        for (String col : columnsByPos) {
            if (Strings.isNullOrEmpty(col)) {
                throw new SemanticException("Empty column in reorder columns.");
            }
        }
        clause.setRollupName(Strings.emptyToNull(clause.getRollupName()));
        return null;
    }

    // Check the following properties' legality before modifying partition.
    // 1. replication_num
    // 2. storage_medium && storage_cooldown_time
    // 3. in_memory
    // 4. tablet type
    private void checkProperties(Map<String, String> properties) throws AnalysisException {
        // 1. data property
        DataProperty newDataProperty = null;
        newDataProperty = PropertyAnalyzer.analyzeDataProperty(properties,
                DataProperty.getInferredDefaultDataProperty(), false);
        Preconditions.checkNotNull(newDataProperty);

        // 2. replication num
        short newReplicationNum;
        newReplicationNum = PropertyAnalyzer.analyzeReplicationNum(properties, RunMode.defaultReplicationNum());
        Preconditions.checkState(newReplicationNum != (short) -1);

        // 3. in memory
        PropertyAnalyzer.analyzeBooleanProp(properties, PropertyAnalyzer.PROPERTIES_INMEMORY, false);

        // 4. tablet type
        PropertyAnalyzer.analyzeTabletType(properties);
    }

    @Override
    public Void visitReplacePartitionClause(ReplacePartitionClause clause, ConnectContext context) {
        if (clause.getPartitionNames().stream().anyMatch(String::isEmpty)) {
            throw new SemanticException("there are empty partition name", clause.getPartition().getPos());
        }

        if (clause.getTempPartitionNames().stream().anyMatch(String::isEmpty)) {
            throw new SemanticException("there are empty partition name", clause.getTempPartition().getPos());
        }


        if (clause.getPartition().isTemp()) {
            throw new SemanticException("Only support replace partitions with temp partitions",
                    clause.getPartition().getPos());
        }

        if (!clause.getTempPartition().isTemp()) {
            throw new SemanticException("Only support replace partitions with temp partitions",
                    clause.getTempPartition().getPos());
        }

        clause.setStrictRange(PropertyAnalyzer.analyzeBooleanProp(
                clause.getProperties(), PropertyAnalyzer.PROPERTIES_STRICT_RANGE, true));
        clause.setUseTempPartitionName(PropertyAnalyzer.analyzeBooleanProp(
                clause.getProperties(), PropertyAnalyzer.PROPERTIES_USE_TEMP_PARTITION_NAME, false));

        if (clause.getProperties() != null && !clause.getProperties().isEmpty()) {
            throw new SemanticException("Unknown properties: " + clause.getProperties());
        }
        return null;
    }

    @Override
    public Void visitPartitionRenameClause(PartitionRenameClause clause, ConnectContext context) {
        try {
            if (Strings.isNullOrEmpty(clause.getPartitionName())) {
                throw new AnalysisException("Partition name is not set");
            }

            if (Strings.isNullOrEmpty(clause.getNewPartitionName())) {
                throw new AnalysisException("New partition name is not set");
            }
            FeNameFormat.checkPartitionName(clause.getNewPartitionName());
        } catch (AnalysisException e) {
            throw new SemanticException(e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitAddRollupClause(AddRollupClause clause, ConnectContext context) {
        try {
            clause.analyze(null);
        } catch (AnalysisException e) {
            throw new SemanticException(e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitDropRollupClause(DropRollupClause clause, ConnectContext context) {
        try {
            clause.analyze(null);
        } catch (AnalysisException e) {
            throw new SemanticException(e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitRollupRenameClause(RollupRenameClause clause, ConnectContext context) {
        try {
            clause.analyze(null);
        } catch (AnalysisException e) {
            throw new SemanticException(e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitCompactionClause(CompactionClause clause, ConnectContext context) {
        final List<String> partitionNames = clause.getPartitionNames();
        if (partitionNames.stream().anyMatch(Strings::isNullOrEmpty)) {
            throw new SemanticException("there are empty partition name");
        }
        return null;
    }

    @Override
    public Void visitRefreshSchemeClause(RefreshSchemeClause refreshSchemeDesc, ConnectContext context) {
        if (refreshSchemeDesc.getType() == MaterializedView.RefreshType.SYNC) {
            throw new SemanticException("Unsupported change to SYNC refresh type", refreshSchemeDesc.getPos());
        }
        if (refreshSchemeDesc instanceof AsyncRefreshSchemeDesc) {
            AsyncRefreshSchemeDesc async = (AsyncRefreshSchemeDesc) refreshSchemeDesc;
            final IntervalLiteral intervalLiteral = async.getIntervalLiteral();
            if (intervalLiteral != null) {
                long step = ((IntLiteral) intervalLiteral.getValue()).getLongValue();
                if (step <= 0) {
                    throw new SemanticException("Unsupported negative or zero step value: " + step,
                            async.getPos());
                }
                final String unit = intervalLiteral.getUnitIdentifier().getDescription().toUpperCase();
                try {
                    MaterializedViewAnalyzer.MaterializedViewAnalyzerVisitor.RefreshTimeUnit.valueOf(unit);
                } catch (IllegalArgumentException e) {
                    String msg = String.format("Unsupported interval unit: %s, only timeunit %s are supported", unit,
                            Arrays.asList(MaterializedViewAnalyzer.MaterializedViewAnalyzerVisitor.RefreshTimeUnit.values()));
                    throw new SemanticException(msg, intervalLiteral.getUnitIdentifier().getPos());
                }
            }
        }
        return null;
    }

    @Override
    public Void visitAlterMaterializedViewStatusClause(AlterMaterializedViewStatusClause clause, ConnectContext context) {
        String status = clause.getStatus();
        if (!AlterMaterializedViewStatusClause.SUPPORTED_MV_STATUS.contains(status)) {
            throw new SemanticException("Unsupported modification for materialized view status:" + status);
        }
        return null;
    }
}
