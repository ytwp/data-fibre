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

package io.datafibre.fibre.statistic;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.InternalCatalog;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.Partition;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.common.AuditLog;
import io.datafibre.fibre.common.Config;
import io.datafibre.fibre.common.Pair;
import io.datafibre.fibre.common.Status;
import io.datafibre.fibre.common.util.DebugUtil;
import io.datafibre.fibre.common.util.UUIDUtil;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.qe.StmtExecutor;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.StatementPlanner;
import io.datafibre.fibre.sql.analyzer.SemanticException;
import io.datafibre.fibre.sql.ast.StatementBase;
import io.datafibre.fibre.sql.common.ErrorType;
import io.datafibre.fibre.sql.common.MetaUtils;
import io.datafibre.fibre.sql.common.StarRocksPlannerException;
import io.datafibre.fibre.sql.parser.SqlParser;
import io.datafibre.fibre.sql.plan.ExecPlan;
import io.datafibre.fibre.thrift.TResultBatch;
import io.datafibre.fibre.thrift.TResultSinkType;
import io.datafibre.fibre.thrift.TStatisticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class StatisticExecutor {
    private static final Logger LOG = LogManager.getLogger(StatisticExecutor.class);

    public List<TStatisticData> queryStatisticSync(ConnectContext context, String tableUUID, Table table,
                                                   List<String> columnNames) {
        if (table == null) {
            // Statistical information query is an unlocked operation,
            // so it is possible for the table to be deleted while the code is running
            return Collections.emptyList();
        }
        List<Column> columns = Lists.newArrayList();
        for (String colName : columnNames) {
            Column column = table.getColumn(colName);
            Preconditions.checkState(column != null);
            columns.add(column);
        }
        String sql = StatisticSQLBuilder.buildQueryExternalFullStatisticsSQL(tableUUID, columns);
        return executeStatisticDQL(context, sql);
    }

    public List<TStatisticData> queryStatisticSync(ConnectContext context,
                                                   Long dbId, Long tableId, List<String> columnNames) {
        String sql;
        BasicStatsMeta meta = GlobalStateMgr.getCurrentState().getAnalyzeMgr().getBasicStatsMetaMap().get(tableId);
        if (meta != null && meta.getType().equals(StatsConstants.AnalyzeType.FULL)) {
            Table table = null;
            if (dbId == null) {
                List<Long> dbIds = GlobalStateMgr.getCurrentState().getLocalMetastore().getDbIds();
                for (Long id : dbIds) {
                    Database db = GlobalStateMgr.getCurrentState().getDb(id);
                    if (db == null) {
                        continue;
                    }
                    table = db.getTable(tableId);
                    if (table == null) {
                        continue;
                    }
                    break;
                }
            } else {
                Database database = GlobalStateMgr.getCurrentState().getDb(dbId);
                table = database.getTable(tableId);
            }

            if (table == null) {
                // Statistical information query is an unlocked operation,
                // so it is possible for the table to be deleted while the code is running
                return Collections.emptyList();
            }

            List<Column> columns = Lists.newArrayList();
            for (String colName : columnNames) {
                Column column = table.getColumn(colName);
                Preconditions.checkState(column != null);
                columns.add(column);
            }

            sql = StatisticSQLBuilder.buildQueryFullStatisticsSQL(dbId, tableId, columns);
        } else {
            sql = StatisticSQLBuilder.buildQuerySampleStatisticsSQL(dbId, tableId, columnNames);
        }

        return executeStatisticDQL(context, sql);
    }

    public void dropTableStatistics(ConnectContext statsConnectCtx, Long tableIds,
                                    StatsConstants.AnalyzeType analyzeType) {
        String sql = StatisticSQLBuilder.buildDropStatisticsSQL(tableIds, analyzeType);
        LOG.debug("Expire statistic SQL: {}", sql);

        boolean result = executeDML(statsConnectCtx, sql);
        if (!result) {
            LOG.warn("Execute statistic table expire fail.");
        }
    }

    public void dropExternalTableStatistics(ConnectContext statsConnectCtx, String tableUUID) {
        String sql = StatisticSQLBuilder.buildDropExternalStatSQL(tableUUID);
        LOG.debug("Expire external statistic SQL: {}", sql);

        boolean result = executeDML(statsConnectCtx, sql);
        if (!result) {
            LOG.warn("Execute statistic table expire fail.");
        }
    }

    public boolean dropPartitionStatistics(ConnectContext statsConnectCtx, List<Long> pids) {
        String sql = StatisticSQLBuilder.buildDropPartitionSQL(pids);
        LOG.debug("Expire partition statistic SQL: {}", sql);
        return executeDML(statsConnectCtx, sql);
    }

    public boolean dropTableInvalidPartitionStatistics(ConnectContext statsConnectCtx, List<Long> tables,
                                                       List<Long> pids) {
        String sql = StatisticSQLBuilder.buildDropTableInvalidPartitionSQL(tables, pids);
        LOG.debug("Expire invalid partition statistic SQL: {}", sql);
        return executeDML(statsConnectCtx, sql);
    }

    public List<TStatisticData> queryHistogram(ConnectContext statsConnectCtx, Long tableId, List<String> columnNames) {
        String sql = StatisticSQLBuilder.buildQueryHistogramStatisticsSQL(tableId, columnNames);
        return executeStatisticDQL(statsConnectCtx, sql);
    }

    public List<TStatisticData> queryMCV(ConnectContext statsConnectCtx, String sql) {
        return executeStatisticDQL(statsConnectCtx, sql);
    }

    public void dropHistogram(ConnectContext statsConnectCtx, Long tableId, List<String> columnNames) {
        String sql = StatisticSQLBuilder.buildDropHistogramSQL(tableId, columnNames);
        boolean result = executeDML(statsConnectCtx, sql);
        if (!result) {
            LOG.warn("Execute statistic table expire fail.");
        }
    }

    // If you call this function, you must ensure that the db lock is added
    public static Pair<List<TStatisticData>, Status> queryDictSync(Long dbId, Long tableId, String column)
            throws Exception {
        if (dbId == -1) {
            return Pair.create(Collections.emptyList(), Status.OK);
        }

        Database db = MetaUtils.getDatabase(dbId);
        Table table = MetaUtils.getTable(dbId, tableId);
        if (!(table.isOlapOrCloudNativeTable() || table.isMaterializedView())) {
            throw new SemanticException("Table '%s' is not a OLAP table or LAKE table or Materialize View",
                    table.getName());
        }

        OlapTable olapTable = (OlapTable) table;
        long version = olapTable.getPartitions().stream().map(Partition::getVisibleVersionTime)
                .max(Long::compareTo).orElse(0L);
        String catalogName = InternalCatalog.DEFAULT_INTERNAL_CATALOG_NAME;
        String sql = "select cast(" + StatsConstants.STATISTIC_DICT_VERSION + " as Int), " +
                "cast(" + version + " as bigint), " +
                "dict_merge(" + StatisticUtils.quoting(column) + ") as _dict_merge_" + column +
                " from " + StatisticUtils.quoting(catalogName, db.getOriginName(), table.getName()) + " [_META_]";

        ConnectContext context = StatisticUtils.buildConnectContext();
        // The parallelism degree of low-cardinality dict collect task is uniformly set to 1 to
        // prevent collection tasks from occupying a large number of be execution threads and scan threads.
        context.getSessionVariable().setPipelineDop(1);
        context.setThreadLocalInfo();
        StatementBase parsedStmt = SqlParser.parseOneWithStarRocksDialect(sql, context.getSessionVariable());

        ExecPlan execPlan = StatementPlanner.plan(parsedStmt, context, TResultSinkType.STATISTIC);
        StmtExecutor executor = new StmtExecutor(context, parsedStmt);
        Pair<List<TResultBatch>, Status> sqlResult = executor.executeStmtWithExecPlan(context, execPlan);
        if (!sqlResult.second.ok()) {
            return Pair.create(Collections.emptyList(), sqlResult.second);
        } else {
            return Pair.create(deserializerStatisticData(sqlResult.first), sqlResult.second);
        }
    }

    public List<TStatisticData> queryTableStats(ConnectContext context, Long tableId) {
        String sql = StatisticSQLBuilder.buildQueryTableStatisticsSQL(tableId);
        return executeStatisticDQL(context, sql);
    }

    public List<TStatisticData> queryTableStats(ConnectContext context, Long tableId, Long partitionId) {
        String sql = StatisticSQLBuilder.buildQueryTableStatisticsSQL(tableId, partitionId);
        return executeStatisticDQL(context, sql);
    }

    private static List<TStatisticData> deserializerStatisticData(List<TResultBatch> sqlResult) throws TException {
        List<TStatisticData> statistics = Lists.newArrayList();

        if (sqlResult.size() < 1) {
            return statistics;
        }

        int version = sqlResult.get(0).getStatistic_version();
        if (sqlResult.stream().anyMatch(d -> d.getStatistic_version() != version)) {
            return statistics;
        }

        if (version == StatsConstants.STATISTIC_DATA_VERSION
                || version == StatsConstants.STATISTIC_DICT_VERSION
                || version == StatsConstants.STATISTIC_HISTOGRAM_VERSION
                || version == StatsConstants.STATISTIC_TABLE_VERSION
                || version == StatsConstants.STATISTIC_BATCH_VERSION
                || version == StatsConstants.STATISTIC_EXTERNAL_VERSION
                || version == StatsConstants.STATISTIC_EXTERNAL_QUERY_VERSION) {
            TDeserializer deserializer = new TDeserializer(new TCompactProtocol.Factory());
            for (TResultBatch resultBatch : sqlResult) {
                for (ByteBuffer bb : resultBatch.rows) {
                    TStatisticData sd = new TStatisticData();
                    byte[] bytes = new byte[bb.limit() - bb.position()];
                    bb.get(bytes);
                    deserializer.deserialize(sd, bytes);
                    statistics.add(sd);
                }
            }
        } else {
            throw new StarRocksPlannerException("Unknown statistics type " + version, ErrorType.INTERNAL_ERROR);
        }

        return statistics;
    }

    public AnalyzeStatus collectStatistics(ConnectContext statsConnectCtx,
                                           StatisticsCollectJob statsJob,
                                           AnalyzeStatus analyzeStatus,
                                           boolean refreshAsync) {
        Database db = statsJob.getDb();
        Table table = statsJob.getTable();

        try {
            statsConnectCtx.getSessionVariable().setEnableProfile(Config.enable_statistics_collect_profile);
            GlobalStateMgr.getCurrentState().getAnalyzeMgr().registerConnection(analyzeStatus.getId(), statsConnectCtx);
            // Only update running status without edit log, make restart job status is failed
            analyzeStatus.setStatus(StatsConstants.ScheduleStatus.RUNNING);
            GlobalStateMgr.getCurrentState().getAnalyzeMgr().replayAddAnalyzeStatus(analyzeStatus);

            statsConnectCtx.setStatisticsConnection(true);
            statsJob.collect(statsConnectCtx, analyzeStatus);
        } catch (Exception e) {
            LOG.warn("Collect statistics error ", e);
            analyzeStatus.setStatus(StatsConstants.ScheduleStatus.FAILED);
            analyzeStatus.setEndTime(LocalDateTime.now());
            analyzeStatus.setReason(e.getMessage());
            GlobalStateMgr.getCurrentState().getAnalyzeMgr().addAnalyzeStatus(analyzeStatus);
            return analyzeStatus;
        } finally {
            GlobalStateMgr.getCurrentState().getAnalyzeMgr().unregisterConnection(analyzeStatus.getId(), false);
        }

        analyzeStatus.setStatus(StatsConstants.ScheduleStatus.FINISH);
        analyzeStatus.setEndTime(LocalDateTime.now());
        GlobalStateMgr.getCurrentState().getAnalyzeMgr().addAnalyzeStatus(analyzeStatus);

        // update StatisticsCache
        statsConnectCtx.setStatisticsConnection(false);
        if (statsJob.getType().equals(StatsConstants.AnalyzeType.HISTOGRAM)) {
            for (String columnName : statsJob.getColumns()) {
                HistogramStatsMeta histogramStatsMeta = new HistogramStatsMeta(db.getId(),
                        table.getId(), columnName, statsJob.getType(), analyzeStatus.getEndTime(),
                        statsJob.getProperties());
                GlobalStateMgr.getCurrentState().getAnalyzeMgr().addHistogramStatsMeta(histogramStatsMeta);
                GlobalStateMgr.getCurrentState().getAnalyzeMgr().refreshHistogramStatisticsCache(
                        histogramStatsMeta.getDbId(), histogramStatsMeta.getTableId(),
                        Lists.newArrayList(histogramStatsMeta.getColumn()), refreshAsync);
            }
        } else {
            if (table.isNativeTableOrMaterializedView()) {
                long existUpdateRows = GlobalStateMgr.getCurrentState().getAnalyzeMgr().getExistUpdateRows(table.getId());
                BasicStatsMeta basicStatsMeta = new BasicStatsMeta(db.getId(), table.getId(),
                        statsJob.getColumns(), statsJob.getType(), analyzeStatus.getEndTime(),
                        statsJob.getProperties(), existUpdateRows);
                GlobalStateMgr.getCurrentState().getAnalyzeMgr().addBasicStatsMeta(basicStatsMeta);
                GlobalStateMgr.getCurrentState().getAnalyzeMgr().refreshBasicStatisticsCache(
                        basicStatsMeta.getDbId(), basicStatsMeta.getTableId(), basicStatsMeta.getColumns(),
                        refreshAsync);
            } else {
                // for external table
                ExternalBasicStatsMeta externalBasicStatsMeta = new ExternalBasicStatsMeta(statsJob.getCatalogName(),
                        db.getFullName(), table.getName(), statsJob.getColumns(), statsJob.getType(),
                        analyzeStatus.getStartTime(), statsJob.getProperties());
                GlobalStateMgr.getCurrentState().getAnalyzeMgr().addExternalBasicStatsMeta(externalBasicStatsMeta);
                GlobalStateMgr.getCurrentState().getAnalyzeMgr()
                        .refreshConnectorTableBasicStatisticsCache(statsJob.getCatalogName(),
                                db.getFullName(), table.getName(), statsJob.getColumns(), refreshAsync);
            }
        }
        return analyzeStatus;
    }

    public List<TStatisticData> executeStatisticDQL(ConnectContext context, String sql) {
        List<TResultBatch> sqlResult = executeDQL(context, sql);
        try {
            return deserializerStatisticData(sqlResult);
        } catch (TException e) {
            throw new SemanticException(e.getMessage());
        }
    }

    private List<TResultBatch> executeDQL(ConnectContext context, String sql) {
        StatementBase parsedStmt = SqlParser.parseOneWithStarRocksDialect(sql, context.getSessionVariable());
        ExecPlan execPlan = StatementPlanner.plan(parsedStmt, context, TResultSinkType.STATISTIC);
        StmtExecutor executor = new StmtExecutor(context, parsedStmt);
        context.setExecutor(executor);
        context.setQueryId(UUIDUtil.genUUID());
        context.getSessionVariable().setEnableMaterializedViewRewrite(false);
        AuditLog.getStatisticAudit().info("statistic execute query | QueryId [{}] | SQL: {}",
                DebugUtil.printId(context.getQueryId()), sql);
        Pair<List<TResultBatch>, Status> sqlResult = executor.executeStmtWithExecPlan(context, execPlan);
        if (!sqlResult.second.ok()) {
            throw new SemanticException("Statistics query fail | Error Message [%s] | QueryId [%s] | SQL [%s]",
                    context.getState().getErrorMessage(), DebugUtil.printId(context.getQueryId()), sql);
        } else {
            return sqlResult.first;
        }
    }

    private boolean executeDML(ConnectContext context, String sql) {
        StatementBase parsedStmt;
        try {
            parsedStmt = SqlParser.parseOneWithStarRocksDialect(sql, context.getSessionVariable());
            StmtExecutor executor = new StmtExecutor(context, parsedStmt);
            context.setExecutor(executor);
            context.setQueryId(UUIDUtil.genUUID());
            AuditLog.getStatisticAudit().info("statistic execute DML | QueryId [{}] | SQL: {}",
                    DebugUtil.printId(context.getQueryId()), sql);
            executor.execute();
            return true;
        } catch (Exception e) {
            LOG.warn("statistic DML fail | {} | SQL {}", DebugUtil.printId(context.getQueryId()), sql, e);
            return false;
        }
    }
}