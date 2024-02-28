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

package io.datafibre.fibre.sql.optimizer.rule.transformation;

import io.datafibre.fibre.analysis.JoinOperator;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptimizerContext;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefFactory;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefSet;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalJoinOperator;
import io.datafibre.fibre.sql.optimizer.operator.pattern.Pattern;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;
import io.datafibre.fibre.sql.optimizer.rule.RuleType;
import io.datafibre.fibre.sql.optimizer.rule.join.JoinReorderHelper;
import io.datafibre.fibre.sql.optimizer.rule.join.JoinReorderProperty;
import org.apache.commons.lang3.StringUtils;

import static io.datafibre.fibre.sql.optimizer.rule.join.JoinReorderProperty.ASSOCIATIVITY_BOTTOM_MASK;
import static io.datafibre.fibre.sql.optimizer.rule.join.JoinReorderProperty.ASSOCIATIVITY_TOP_MASK;
import static io.datafibre.fibre.sql.optimizer.rule.join.JoinReorderProperty.LEFT_ASSCOM_BOTTOM_MASK;
import static io.datafibre.fibre.sql.optimizer.rule.join.JoinReorderProperty.LEFT_ASSCOM_TOP_MASK;

/*      Join            Join
 *      /    \          /    \
 *     Join   C   =>   Join   B
 *    /    \          /    \
 *   A      B        A      C
 *
 * The definition of asscom is ref from
 * Moerkotte G, Fender P, Eich M. On the correct and complete enumeration of the core search space[C].
 * A simple example is like (t1 ⋉ t2) ⋉ t3 to (t1 ⋉ t3) ⋉ t2, you cannot derive plan using associativity
 * and commutativity. So we need asscom to process it.
 */
public class JoinLeftAsscomRule extends JoinAssociateBaseRule {

    public static final JoinLeftAsscomRule INNER_JOIN_LEFT_ASSCOM_RULE = new JoinLeftAsscomRule(
            RuleType.TF_JOIN_LEFT_ASSCOM_INNER, true);

    public static final JoinLeftAsscomRule OUTER_JOIN_LEFT_ASSCOM_RULE = new JoinLeftAsscomRule(
            RuleType.TF_JOIN_LEFT_ASSCOM_OUTER, false);


    private JoinLeftAsscomRule(RuleType ruleType, boolean isInnerMode) {
        super(ruleType, Pattern.create(OperatorType.LOGICAL_JOIN)
                .addChildren(Pattern.create(OperatorType.LOGICAL_JOIN)
                        .addChildren(Pattern.create(OperatorType.PATTERN_LEAF, OperatorType.PATTERN_MULTI_LEAF))
                        .addChildren(Pattern.create(OperatorType.PATTERN_LEAF, OperatorType.PATTERN_MULTI_LEAF)))
                .addChildren(Pattern.create(OperatorType.PATTERN_LEAF)), JoinAssociateBaseRule.LEFTASSCOM_MODE,
                isInnerMode);
    }

    @Override
    public boolean check(final OptExpression input, OptimizerContext context) {
        LogicalJoinOperator topJoin = (LogicalJoinOperator) input.getOp();
        LogicalJoinOperator bottomJoin = (LogicalJoinOperator) input.inputAt(0).getOp();
        if ((topJoin.getTransformMask() & (ASSOCIATIVITY_TOP_MASK | LEFT_ASSCOM_TOP_MASK)) > 0 &&
                (bottomJoin.getTransformMask() & (ASSOCIATIVITY_BOTTOM_MASK | LEFT_ASSCOM_BOTTOM_MASK)) > 0) {
            return false;
        }

        if (StringUtils.isNotEmpty(topJoin.getJoinHint()) || StringUtils.isNotEmpty(bottomJoin.getJoinHint())) {
            return false;
        }

        if (bottomJoin.hasLimit()) {
            return false;
        }

        if (JoinReorderProperty.getLeftAsscomProperty(bottomJoin.getJoinType(), topJoin.getJoinType(), isInnerMode)
                != JoinReorderProperty.SUPPORTED) {
            return false;
        }

        return JoinReorderHelper.isLeftAsscom(input.inputAt(0), input, isInnerMode);
    }

    @Override
    public ScalarOperator rewriteNewTopOnCondition(JoinOperator topJoinType, ProjectionSplitter splitter,
                                                   ScalarOperator newTopOnCondition, ColumnRefSet newBotJoinOutputCols,
                                                   ColumnRefFactory columnRefFactory) {
        return newTopOnCondition;
    }

    @Override
    public OptExpression createNewTopJoinExpr(LogicalJoinOperator newTopJoin, OptExpression newTopJoinChild,
                                              OptExpression newBotJoinExpr) {
        return OptExpression.create(newTopJoin, newBotJoinExpr, newTopJoinChild);
    }

    @Override
    public int createTransformMask(boolean isTop) {
        return isTop ? JoinReorderProperty.LEFT_ASSCOM_TOP_MASK : JoinReorderProperty.LEFT_ASSCOM_BOTTOM_MASK;
    }
}
