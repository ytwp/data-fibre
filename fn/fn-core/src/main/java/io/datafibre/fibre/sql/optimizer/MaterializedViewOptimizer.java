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


package io.datafibre.fibre.sql.optimizer;

import io.datafibre.fibre.catalog.MaterializedView;
import io.datafibre.fibre.catalog.MvPlanContext;
import io.datafibre.fibre.common.Pair;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefFactory;
import io.datafibre.fibre.sql.optimizer.rule.RuleSetType;
import io.datafibre.fibre.sql.optimizer.rule.RuleType;
import io.datafibre.fibre.sql.optimizer.rule.transformation.materialization.MvUtils;
import io.datafibre.fibre.sql.optimizer.transformer.LogicalPlan;

public class MaterializedViewOptimizer {
    public MvPlanContext optimize(MaterializedView mv,
                                  ConnectContext connectContext) {
        return optimize(mv, connectContext, true);
    }
    public MvPlanContext optimize(MaterializedView mv,
                                  ConnectContext connectContext,
                                  boolean inlineView) {
        // optimize the sql by rule and disable rule based materialized view rewrite
        OptimizerConfig optimizerConfig = new OptimizerConfig(OptimizerConfig.OptimizerAlgorithm.RULE_BASED);
        // Disable partition prune for mv's plan so no needs  to compensate pruned predicates anymore.
        // Only needs to compensate mv's ref-base-table's partition predicates when mv's freshness cannot be satisfied.
        optimizerConfig.disableRuleSet(RuleSetType.PARTITION_PRUNE);
        optimizerConfig.disableRuleSet(RuleSetType.ALL_MV_REWRITE);
        // INTERSECT_REWRITE is used for INTERSECT related plan optimize, which can not be SPJG;
        // And INTERSECT_REWRITE should be based on PARTITION_PRUNE rule set.
        // So exclude it
        optimizerConfig.disableRuleSet(RuleSetType.INTERSECT_REWRITE);
        optimizerConfig.disableRule(RuleType.TF_REWRITE_GROUP_BY_COUNT_DISTINCT);
        optimizerConfig.disableRule(RuleType.TF_PRUNE_EMPTY_SCAN);
        // For sync mv, no rewrite query by original sync mv rule to avoid useless rewrite.
        if (mv.getRefreshScheme().isSync()) {
            optimizerConfig.disableRule(RuleType.TF_MATERIALIZED_VIEW);
        }

        ColumnRefFactory columnRefFactory = new ColumnRefFactory();
        String mvSql = mv.getViewDefineSql();
        Pair<OptExpression, LogicalPlan> plans =
                MvUtils.getRuleOptimizedLogicalPlan(mv, mvSql, columnRefFactory, connectContext, optimizerConfig, inlineView);
        if (plans == null) {
            return new MvPlanContext(false, "No query plan for it");
        }
        OptExpression mvPlan = plans.first;
        if (!MvUtils.isValidMVPlan(mvPlan)) {
            return new MvPlanContext(false, MvUtils.getInvalidReason(mvPlan, inlineView));
        }
        return new MvPlanContext(mvPlan, plans.second.getOutputColumn(), columnRefFactory);
    }
}
