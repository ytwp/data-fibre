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

package io.datafibre.fibre.sql.ast;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.LiteralExpr;
import io.datafibre.fibre.analysis.NullLiteral;
import io.datafibre.fibre.analysis.Subquery;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.common.Pair;
import io.datafibre.fibre.common.Status;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.qe.QueryState;
import io.datafibre.fibre.qe.StmtExecutor;
import io.datafibre.fibre.sql.StatementPlanner;
import io.datafibre.fibre.sql.analyzer.AstToSQLBuilder;
import io.datafibre.fibre.sql.analyzer.SemanticException;
import io.datafibre.fibre.sql.parser.NodePosition;
import io.datafibre.fibre.sql.plan.ExecPlan;
import io.datafibre.fibre.thrift.TResultBatch;
import io.datafibre.fibre.thrift.TResultSinkType;
import io.datafibre.fibre.thrift.TVariableData;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UserVariable extends SetListItem {
    private final String variable;
    private Expr unevaluatedExpression;
    private LiteralExpr evaluatedExpression;

    private final boolean isFromHint;
    public UserVariable(String variable, Expr unevaluatedExpression, NodePosition pos) {
        this(variable, unevaluatedExpression, false, pos);
    }

    public UserVariable(String variable, Expr unevaluatedExpression, boolean isFromHint, NodePosition pos) {
        super(pos);
        this.variable = variable;
        this.unevaluatedExpression = unevaluatedExpression;
        if (unevaluatedExpression instanceof LiteralExpr) {
            this.evaluatedExpression = (LiteralExpr) unevaluatedExpression;
        }
        this.isFromHint = isFromHint;
    }



    public String getVariable() {
        return variable;
    }

    public Expr getUnevaluatedExpression() {
        return unevaluatedExpression;
    }

    public void setUnevaluatedExpression(Expr unevaluatedExpression) {
        this.unevaluatedExpression = unevaluatedExpression;
    }

    public LiteralExpr getEvaluatedExpression() {
        return evaluatedExpression;
    }

    public void setEvaluatedExpression(LiteralExpr evaluatedExpression) {
        this.evaluatedExpression = evaluatedExpression;
    }

    public boolean isFromHint() {
        return isFromHint;
    }

    @Override
    public String toSql() {
        return AstToSQLBuilder.toSQL(unevaluatedExpression);
    }

    public void deriveUserVariableExpressionResult(ConnectContext ctx) {
        QueryStatement queryStatement = ((Subquery) unevaluatedExpression).getQueryStatement();
        ExecPlan execPlan = StatementPlanner.plan(queryStatement,
                ConnectContext.get(), TResultSinkType.VARIABLE);
        StmtExecutor executor = new StmtExecutor(ctx, queryStatement);
        Pair<List<TResultBatch>, Status> sqlResult = executor.executeStmtWithExecPlan(ctx, execPlan);
        if (!sqlResult.second.ok()) {
            throw new SemanticException(sqlResult.second.getErrorMsg());
        } else {
            try {
                List<TVariableData> result = deserializerVariableData(sqlResult.first);
                LiteralExpr resultExpr;
                if (result.isEmpty()) {
                    resultExpr = new NullLiteral();
                } else {
                    Preconditions.checkState(result.size() == 1);
                    if (result.get(0).isIsNull()) {
                        resultExpr = new NullLiteral();
                    } else {
                        Type userVariableType = unevaluatedExpression.getType();
                        //JSON type will be stored as string type
                        if (userVariableType.isJsonType()) {
                            userVariableType = Type.VARCHAR;
                        }
                        resultExpr = LiteralExpr.create(
                                StandardCharsets.UTF_8.decode(result.get(0).result).toString(), userVariableType);
                    }
                }
                evaluatedExpression = resultExpr;
            } catch (TException | AnalysisException e) {
                throw new SemanticException(e.getMessage());
            }
        }

        if (ctx.getState().getStateType() == QueryState.MysqlStateType.ERR) {
            throw new SemanticException(ctx.getState().getErrorMessage());
        }
    }
    private static List<TVariableData> deserializerVariableData(List<TResultBatch> sqlResult) throws TException {
        List<TVariableData> statistics = Lists.newArrayList();

        TDeserializer deserializer = new TDeserializer(new TCompactProtocol.Factory());
        for (TResultBatch resultBatch : sqlResult) {
            for (ByteBuffer bb : resultBatch.rows) {
                TVariableData sd = new TVariableData();
                byte[] bytes = new byte[bb.limit() - bb.position()];
                bb.get(bytes);
                deserializer.deserialize(sd, bytes);
                statistics.add(sd);
            }
        }

        return statistics;
    }
}
