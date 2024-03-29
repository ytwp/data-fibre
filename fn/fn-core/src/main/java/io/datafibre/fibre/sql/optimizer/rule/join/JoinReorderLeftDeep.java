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


package io.datafibre.fibre.sql.optimizer.rule.join;

import com.google.common.base.Preconditions;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptimizerContext;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalScanOperator;

import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class JoinReorderLeftDeep extends JoinOrder {
    Optional<OptExpression> bestPlanRoot = Optional.empty();

    public JoinReorderLeftDeep(OptimizerContext context) {
        super(context);
    }

    public boolean isSameTableJoin(GroupInfo left, GroupInfo right) {
        if (!(left.bestExprInfo.expr.getOp() instanceof LogicalScanOperator)) {
            return false;
        }
        if (!(right.bestExprInfo.expr.getOp() instanceof LogicalScanOperator)) {
            return false;
        }
        LogicalScanOperator l = (LogicalScanOperator) left.bestExprInfo.expr.getOp();
        LogicalScanOperator r = (LogicalScanOperator) right.bestExprInfo.expr.getOp();
        return l.getTable().getId() == r.getTable().getId();
    }

    @Override
    protected void enumerate() {
        List<GroupInfo> atoms = joinLevels.get(1).groups;
        atoms.sort((a, b) -> {
            double diff = b.bestExprInfo.cost - a.bestExprInfo.cost;
            return (diff < 0 ? -1 : (diff > 0 ? 1 : 0));
        });

        boolean useHeuristic = true;
        boolean[] used = new boolean[atomSize];
        GroupInfo leftGroup = atoms.get(0);
        used[0] = true;
        int next = 1;
        while (next < atomSize) {
            if (used[next]) {
                next++;
                continue;
            }
            int index = next;
            Preconditions.checkState(!used[index]);
            if (useHeuristic) {
                // search the next group which:
                // 1. has never been used
                // 2. can inner join with leftGroup
                // 3. not same table inner join (happens only the first time).
                // inner join on same tables possibly degrades to cross join.
                for (; index < atomSize; ++index) {
                    GroupInfo rightGroup = atoms.get(index);
                    if (next == 1 && isSameTableJoin(leftGroup, rightGroup)) {
                        continue;
                    }
                    if (!used[index] && canBuildInnerJoinPredicate(leftGroup, rightGroup)) {
                        break;
                    }
                }
                // if not found, fallback to old strategy
                if (index == atomSize) {
                    index = next;
                }
            }
            Preconditions.checkState(!used[index]);
            used[index] = true;

            GroupInfo rightGroup = atoms.get(index);
            Optional<ExpressionInfo> joinExpr = buildJoinExpr(leftGroup, atoms.get(index));
            if (!joinExpr.isPresent()) {
                return;
            }
            joinExpr.get().expr.deriveLogicalPropertyItself();
            calculateStatistics(joinExpr.get().expr);
            computeCost(joinExpr.get());

            BitSet joinBitSet = new BitSet();
            joinBitSet.or(leftGroup.atoms);
            joinBitSet.or(rightGroup.atoms);

            leftGroup = new GroupInfo(joinBitSet);
            leftGroup.bestExprInfo = joinExpr.get();
            leftGroup.lowestExprCost = joinExpr.get().cost;
        }
        bestPlanRoot = Optional.of(leftGroup.bestExprInfo.expr);
    }

    @Override
    public List<OptExpression> getResult() {
        return bestPlanRoot.map(Collections::singletonList).orElse(Collections.emptyList());
    }
}
