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

package io.datafibre.fibre.load.pipe.filelist;

import com.google.common.base.Preconditions;
import io.datafibre.fibre.common.AuditLog;
import io.datafibre.fibre.common.Pair;
import io.datafibre.fibre.common.Status;
import io.datafibre.fibre.common.util.DebugUtil;
import io.datafibre.fibre.common.util.UUIDUtil;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.qe.DDLStmtExecutor;
import io.datafibre.fibre.qe.StmtExecutor;
import io.datafibre.fibre.sql.StatementPlanner;
import io.datafibre.fibre.sql.analyzer.Analyzer;
import io.datafibre.fibre.sql.analyzer.SemanticException;
import io.datafibre.fibre.sql.ast.DmlStmt;
import io.datafibre.fibre.sql.ast.StatementBase;
import io.datafibre.fibre.sql.parser.SqlParser;
import io.datafibre.fibre.sql.plan.ExecPlan;
import io.datafibre.fibre.statistic.StatisticUtils;
import io.datafibre.fibre.thrift.TResultBatch;
import io.datafibre.fibre.thrift.TResultSinkType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Execute SQL
 */
public class RepoExecutor {

    private static final Logger LOG = LogManager.getLogger(RepoExecutor.class);

    private static class SingletonHolder {
        private static final RepoExecutor INSTANCE = new RepoExecutor();
    }

    public static RepoExecutor getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private RepoExecutor() {
    }

    public void executeDML(String sql) {
        try {
            ConnectContext context = createConnectContext();

            StatementBase parsedStmt = SqlParser.parseOneWithStarRocksDialect(sql, context.getSessionVariable());
            Preconditions.checkState(parsedStmt instanceof DmlStmt, "the statement should be dml");
            DmlStmt dmlStmt = (DmlStmt) parsedStmt;
            ExecPlan execPlan = StatementPlanner.plan(parsedStmt, context, TResultSinkType.HTTP_PROTOCAL);
            StmtExecutor executor = new StmtExecutor(context, parsedStmt);
            context.setExecutor(executor);
            context.setQueryId(UUIDUtil.genUUID());
            AuditLog.getInternalAudit().info("RepoExecutor execute SQL | Query_id {} | SQL {}",
                    DebugUtil.printId(context.getQueryId()), sql);
            executor.handleDMLStmt(execPlan, dmlStmt);
        } catch (Exception e) {
            LOG.error("RepoExecutor execute SQL {} failed: {}", sql, e.getMessage(), e);
            throw new SemanticException(String.format("execute sql failed: %s", e.getMessage()), e);
        } finally {
            ConnectContext.remove();
        }
    }

    public List<TResultBatch> executeDQL(String sql) {
        try {
            ConnectContext context = createConnectContext();

            // TODO: use json sink protocol, instead of statistic protocol
            StatementBase parsedStmt = SqlParser.parseOneWithStarRocksDialect(sql, context.getSessionVariable());
            ExecPlan execPlan = StatementPlanner.plan(parsedStmt, context, TResultSinkType.HTTP_PROTOCAL);
            StmtExecutor executor = new StmtExecutor(context, parsedStmt);
            context.setExecutor(executor);
            context.setQueryId(UUIDUtil.genUUID());
            AuditLog.getInternalAudit().info("RepoExecutor execute SQL | Query_id {} | SQL {}",
                    DebugUtil.printId(context.getQueryId()), sql);
            Pair<List<TResultBatch>, Status> sqlResult = executor.executeStmtWithExecPlan(context, execPlan);
            if (!sqlResult.second.ok()) {
                throw new SemanticException("execute sql failed with status: " + sqlResult.second.getErrorMsg());
            }
            return sqlResult.first;
        } catch (Exception e) {
            LOG.error("Repo execute SQL failed {}", sql, e);
            throw new SemanticException("execute sql failed: " + sql, e);
        } finally {
            ConnectContext.remove();
        }
    }

    public void executeDDL(String sql) {
        try {
            ConnectContext context = createConnectContext();

            StatementBase parsedStmt = SqlParser.parseOneWithStarRocksDialect(sql, context.getSessionVariable());
            Analyzer.analyze(parsedStmt, context);
            AuditLog.getInternalAudit().info("RepoExecutor execute DDL | SQL {}", sql);
            DDLStmtExecutor.execute(parsedStmt, context);
        } catch (Exception e) {
            LOG.error("execute DDL error: {}", sql, e);
            throw new RuntimeException(e);
        } finally {
            ConnectContext.remove();
        }
    }

    private static ConnectContext createConnectContext() {
        ConnectContext context = StatisticUtils.buildConnectContext();
        context.setThreadLocalInfo();
        context.setNeedQueued(false);
        return context;
    }

}
