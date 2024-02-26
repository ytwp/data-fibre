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

package io.datafibre.fibre.sql.plan;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import io.datafibre.fibre.analysis.DescriptorTable;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.common.IdGenerator;
import io.datafibre.fibre.common.util.ProfilingExecPlan;
import io.datafibre.fibre.planner.PlanFragment;
import io.datafibre.fibre.planner.PlanFragmentId;
import io.datafibre.fibre.planner.PlanNodeId;
import io.datafibre.fibre.planner.ScanNode;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.sql.Explain;
import io.datafibre.fibre.sql.ast.StatementBase;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.thrift.TExplainLevel;

import java.util.*;

public class ExecPlan {
    private final ConnectContext connectContext;
    private final List<String> colNames;
    private final List<ScanNode> scanNodes = new ArrayList<>();
    private final List<Expr> outputExprs = new ArrayList<>();
    private final DescriptorTable descTbl = new DescriptorTable();
    private final Map<ColumnRefOperator, Expr> colRefToExpr = new HashMap<>();
    private final ArrayList<PlanFragment> fragments = new ArrayList<>();
    private final Map<Integer, PlanFragment> cteProduceFragments = Maps.newHashMap();
    private int planCount = 0;

    private final OptExpression physicalPlan;
    private final List<ColumnRefOperator> outputColumns;

    private final IdGenerator<PlanNodeId> nodeIdGenerator = PlanNodeId.createGenerator();
    private final IdGenerator<PlanFragmentId> fragmentIdGenerator = PlanFragmentId.createGenerator();
    private final Map<Integer, OptExpression> optExpressions = Maps.newHashMap();

    private volatile ProfilingExecPlan profilingPlan;

    @VisibleForTesting
    public ExecPlan() {
        connectContext = new ConnectContext();
        connectContext.setQueryId(new UUID(1, 2));
        colNames = new ArrayList<>();
        physicalPlan = null;
        outputColumns = new ArrayList<>();
    }

    public ExecPlan(ConnectContext connectContext, List<String> colNames,
                    OptExpression physicalPlan, List<ColumnRefOperator> outputColumns) {
        this.connectContext = connectContext;
        this.colNames = colNames;
        this.physicalPlan = physicalPlan;
        this.outputColumns = outputColumns;
    }

    public ConnectContext getConnectContext() {
        return connectContext;
    }

    public List<ScanNode> getScanNodes() {
        return scanNodes;
    }

    public List<Expr> getOutputExprs() {
        return outputExprs;
    }

    public ArrayList<PlanFragment> getFragments() {
        return fragments;
    }

    public PlanFragment getTopFragment() {
        return fragments.get(0);
    }

    public DescriptorTable getDescTbl() {
        return descTbl;
    }

    public List<String> getColNames() {
        return colNames;
    }

    public PlanNodeId getNextNodeId() {
        return nodeIdGenerator.getNextId();
    }

    public PlanFragmentId getNextFragmentId() {
        return fragmentIdGenerator.getNextId();
    }

    public Map<ColumnRefOperator, Expr> getColRefToExpr() {
        return colRefToExpr;
    }

    public void setPlanCount(int planCount) {
        this.planCount = planCount;
    }

    public int getPlanCount() {
        return planCount;
    }

    public Map<Integer, PlanFragment> getCteProduceFragments() {
        return cteProduceFragments;
    }

    public OptExpression getPhysicalPlan() {
        return physicalPlan;
    }

    public List<ColumnRefOperator> getOutputColumns() {
        return outputColumns;
    }

    public void recordPlanNodeId2OptExpression(int id, OptExpression optExpression) {
        optExpressions.put(id, optExpression);
    }

    public OptExpression getOptExpression(int planNodeId) {
        return optExpressions.get(planNodeId);
    }

    public ProfilingExecPlan getProfilingPlan() {
        if (profilingPlan == null) {
            synchronized (this) {
                if (profilingPlan == null) {
                    boolean needSetCtx = ConnectContext.get() == null && this.connectContext != null;
                    try {
                        if (needSetCtx) {
                            this.connectContext.setThreadLocalInfo();
                        }
                        profilingPlan = ProfilingExecPlan.buildFrom(this);
                    } finally {
                        if (needSetCtx) {
                            ConnectContext.remove();
                        }
                    }
                }
            }
        }
        return profilingPlan;
    }

    public String getExplainString(TExplainLevel level) {
        StringBuilder str = new StringBuilder();
        if (level == null) {
            str.append(Explain.toString(physicalPlan, outputColumns));
        } else {
            if (planCount != 0) {
                str.append("There are ").append(planCount).append(" plans in optimizer search space\n");
            }

            for (int i = 0; i < fragments.size(); ++i) {
                PlanFragment fragment = fragments.get(i);
                if (i > 0) {
                    // a blank line between plan fragments
                    str.append("\n");
                }
                if (level.equals(TExplainLevel.NORMAL)) {
                    str.append("PLAN FRAGMENT ").append(i).append("\n");
                    str.append(fragment.getExplainString(TExplainLevel.NORMAL));
                } else if (level.equals(TExplainLevel.COSTS)) {
                    str.append("PLAN FRAGMENT ").append(i).append("(").append(fragment.getFragmentId()).append(")\n");
                    str.append(fragment.getCostExplain());
                } else {
                    str.append("PLAN FRAGMENT ").append(i).append("(").append(fragment.getFragmentId()).append(")\n");
                    str.append(fragment.getVerboseExplain());
                }
            }
        }
        return str.toString();
    }

    public String getExplainString(StatementBase.ExplainLevel level) {
        TExplainLevel tlevel = null;
        switch (level) {
            case NORMAL:
                tlevel = TExplainLevel.NORMAL;
                break;
            case VERBOSE:
                tlevel = TExplainLevel.VERBOSE;
                break;
            case COST:
                tlevel = TExplainLevel.COSTS;
                break;
        }
        return getExplainString(tlevel);
    }
}