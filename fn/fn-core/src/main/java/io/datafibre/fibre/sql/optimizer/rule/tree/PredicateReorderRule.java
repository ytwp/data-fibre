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


package io.datafibre.fibre.sql.optimizer.rule.tree;

import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.qe.SessionVariable;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptExpressionVisitor;
import io.datafibre.fibre.sql.optimizer.Utils;
import io.datafibre.fibre.sql.optimizer.operator.physical.PhysicalOlapScanOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.CompoundPredicateOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;
import io.datafibre.fibre.sql.optimizer.statistics.ColumnStatistic;
import io.datafibre.fibre.sql.optimizer.statistics.Statistics;
import io.datafibre.fibre.sql.optimizer.task.TaskContext;

import java.util.List;
import java.util.Set;

/**
 * Predicate reorder
 * Evaluate the selectivity of child.
 */
public class PredicateReorderRule implements TreeRewriteRule {
    public static final PredicateReorderVisitor HANDLER = new PredicateReorderVisitor();

    private final SessionVariable sessionVariable;

    public PredicateReorderRule(SessionVariable sessionVariable) {
        this.sessionVariable = sessionVariable;
    }

    @Override
    public OptExpression rewrite(OptExpression root, TaskContext taskContext) {
        if (sessionVariable.isEnablePredicateReorder()) {
            root.getOp().accept(HANDLER, root, null);
        }
        return root;
    }

    private static class PredicateReorderVisitor extends OptExpressionVisitor<OptExpression, Void> {
        @Override
        public OptExpression visit(OptExpression optExpression, Void context) {
            for (int i = 0; i < optExpression.arity(); i++) {
                OptExpression inputOptExpression = optExpression.inputAt(i);
                inputOptExpression.getOp().accept(this, inputOptExpression, null);
            }
            return predicateRewrite(optExpression);
        }

        private OptExpression predicateRewrite(OptExpression optExpression) {
            ScalarOperator predicate = optExpression.getOp().getPredicate();
            //check predicate type
            if (predicate == null || !(predicate instanceof CompoundPredicateOperator)) {
                return optExpression;
            }
            CompoundPredicateOperator compoundPredicateOperator = (CompoundPredicateOperator) predicate;
            // process statistics,
            List<OptExpression> childOptExpressions = optExpression.getInputs();
            Statistics.Builder statisticsBuilder = Statistics.builder();
            if (childOptExpressions != null && childOptExpressions.size() > 0) {
                childOptExpressions.forEach(child -> {
                    statisticsBuilder.addColumnStatistics(child.getStatistics().getColumnStatistics());
                });
            } else {
                if (optExpression.getOp() instanceof PhysicalOlapScanOperator) {
                    PhysicalOlapScanOperator olapScanOperator = (PhysicalOlapScanOperator) optExpression.getOp();
                    Table table = olapScanOperator.getTable();
                    Set<ColumnRefOperator> columnRefOperators =
                            optExpression.getStatistics().getColumnStatistics().keySet();
                    for (ColumnRefOperator column : columnRefOperators) {
                        ColumnStatistic columnStatistic = GlobalStateMgr.getCurrentState().getStatisticStorage().
                                getColumnStatistic(table, column.getName());
                        statisticsBuilder.addColumnStatistic(column, columnStatistic);
                    }
                } else {
                    //other scan no support
                    return optExpression;
                }
            }
            Statistics statistics = statisticsBuilder.build();
            //reorder predicate
            optExpression.getOp().setPredicate(predicateReorder(compoundPredicateOperator, statistics));
            return optExpression;
        }

        private ScalarOperator predicateReorder(ScalarOperator scalarOperator, Statistics statistics) {
            // todo need to think partition columns & distribution columns & index
            // get conjunctive predicate
            List<ScalarOperator> conjunctiveScalarOperators = Utils.extractConjuncts(scalarOperator);
            if (conjunctiveScalarOperators.size() <= 1) {
                return scalarOperator;
            } else {
                DefaultPredicateSelectivityEstimator selectivityEstimator = new DefaultPredicateSelectivityEstimator();
                conjunctiveScalarOperators.sort((o1, o2) -> {
                    if (selectivityEstimator.estimate(o1, statistics) > selectivityEstimator.estimate(o2, statistics)) {
                        return 1;
                    } else if (selectivityEstimator.estimate(o1, statistics) <
                            selectivityEstimator.estimate(o2, statistics)) {
                        return -1;
                    } else {
                        return 0;
                    }
                });
                return Utils.createCompound(CompoundPredicateOperator.CompoundType.AND, conjunctiveScalarOperators);
            }
        }
    }
}
