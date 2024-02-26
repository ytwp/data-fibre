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

package io.datafibre.fibre.sql.optimizer.task;

import com.google.common.collect.Lists;
import io.datafibre.fibre.common.Pair;
import io.datafibre.fibre.common.profile.Timer;
import io.datafibre.fibre.common.profile.Tracers;
import io.datafibre.fibre.qe.SessionVariable;
import io.datafibre.fibre.sql.common.ErrorType;
import io.datafibre.fibre.sql.common.StarRocksPlannerException;
import io.datafibre.fibre.sql.optimizer.GroupExpression;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.Optimizer;
import io.datafibre.fibre.sql.optimizer.OptimizerTraceUtil;
import io.datafibre.fibre.sql.optimizer.operator.pattern.Pattern;
import io.datafibre.fibre.sql.optimizer.rule.Binder;
import io.datafibre.fibre.sql.optimizer.rule.Rule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * ApplyRuleTask firstly applies a rule, then
 * <p>
 * If the rule is transformation rule and isExplore is true:
 * We need to explore (apply logical rules)
 * <p>
 * If the rule is transformation rule and isExplore is false:
 * We need to optimize (apply logical & physical rules)
 * <p>
 * If the rule is implementation rule:
 * We directly enforce and cost the physical expression
 */

public class ApplyRuleTask extends OptimizerTask {
    private static final Logger LOG = LogManager.getLogger(Optimizer.class);
    private final GroupExpression groupExpression;
    private final Rule rule;
    private final boolean isExplore;

    ApplyRuleTask(TaskContext context, GroupExpression groupExpression, Rule rule, boolean isExplore) {
        super(context);
        this.groupExpression = groupExpression;
        this.rule = rule;
        this.isExplore = isExplore;
    }

    @Override
    public String toString() {
        return "ApplyRuleTask" + (this.isExplore ? "[explore]" : "") + " for groupExpression " + groupExpression +
                "\n rule " + rule;
    }

    @Override
    public void execute() {
        if (groupExpression.hasRuleExplored(rule) || groupExpression.isUnused()) {
            return;
        }
        // Apply rule and get all new OptExpressions
        Pattern pattern = rule.getPattern();
        Binder binder = new Binder(pattern, groupExpression);
        OptExpression extractExpr = binder.next();
        List<OptExpression> newExpressions = Lists.newArrayList();
        List<OptExpression> extractExpressions = Lists.newArrayList();
        SessionVariable sessionVariable = context.getOptimizerContext().getSessionVariable();
        while (extractExpr != null) {
            if (!rule.check(extractExpr, context.getOptimizerContext())) {
                extractExpr = binder.next();
                continue;
            }
            extractExpressions.add(extractExpr);
            List<OptExpression> targetExpressions;
            try (Timer ignore = Tracers.watchScope(Tracers.Module.OPTIMIZER, rule.getClass().getSimpleName())) {
                targetExpressions = rule.transform(extractExpr, context.getOptimizerContext());
            } catch (StarRocksPlannerException e) {
                if (e.getType() == ErrorType.RULE_EXHAUSTED) {
                    break;
                } else {
                    throw e;
                }
            }
            if (rule.exhausted(context.getOptimizerContext())) {
                OptimizerTraceUtil.logRuleExhausted(context.getOptimizerContext(), rule);
                break;
            }

            newExpressions.addAll(targetExpressions);
            OptimizerTraceUtil.logApplyRule(context.getOptimizerContext(), rule, extractExpr, targetExpressions);

            extractExpr = binder.next();
        }

        for (OptExpression expression : newExpressions) {
            // Insert new OptExpression to memo
            Pair<Boolean, GroupExpression> result = context.getOptimizerContext().getMemo().
                    copyIn(groupExpression.getGroup(), expression);

            // The group has been merged
            if (groupExpression.hasEmptyRootGroup()) {
                return;
            }

            GroupExpression newGroupExpression = result.second;

            // Add this rule into `appliedRules` to mark rules which have already been applied.
            {
                // new bitset should derive old bitset's info to track the lineage of applied rules.
                newGroupExpression.mergeAppliedRules(groupExpression.getAppliedRuleMasks());
                // new bitset add new rule which it's derived from.
                newGroupExpression.addNewAppliedRule(rule);
            }

            if (newGroupExpression.getOp().isLogical()) {
                // For logic newGroupExpression, optimize it
                pushTask(new OptimizeExpressionTask(context, newGroupExpression, isExplore));
            } else {
                // For physical newGroupExpression, enforce and cost it,
                // Optimize its inputs if needed
                pushTask(new EnforceAndCostTask(context, newGroupExpression));
            }
        }

        groupExpression.setRuleExplored(rule);
    }
}