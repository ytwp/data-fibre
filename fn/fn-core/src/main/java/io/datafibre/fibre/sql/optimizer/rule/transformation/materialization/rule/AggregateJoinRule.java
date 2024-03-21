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


package io.datafibre.fibre.sql.optimizer.rule.transformation.materialization.rule;

import io.datafibre.fibre.sql.optimizer.MvRewriteContext;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptimizerContext;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.pattern.Pattern;
import io.datafibre.fibre.sql.optimizer.rule.RuleType;
import io.datafibre.fibre.sql.optimizer.rule.transformation.materialization.AggregatedMaterializedViewRewriter;
import io.datafibre.fibre.sql.optimizer.rule.transformation.materialization.MaterializedViewRewriter;
import io.datafibre.fibre.sql.optimizer.rule.transformation.materialization.MvUtils;

/*
 *
 * Here is the rule for pattern Aggregate-Join
 *
 */
public class AggregateJoinRule extends BaseMaterializedViewRewriteRule {
    private static AggregateJoinRule INSTANCE = new AggregateJoinRule();

    public AggregateJoinRule() {
        super(RuleType.TF_MV_AGGREGATE_JOIN_RULE, Pattern.create(OperatorType.LOGICAL_AGGR)
                .addChildren(Pattern.create(OperatorType.PATTERN_MULTIJOIN)));
    }

    public static AggregateJoinRule getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean check(OptExpression input, OptimizerContext context) {
        if (!MvUtils.isLogicalSPJG(input)) {
            return false;
        }
        return super.check(input, context);
    }

    @Override
    public MaterializedViewRewriter getMaterializedViewRewrite(MvRewriteContext mvContext) {
        return new AggregatedMaterializedViewRewriter(mvContext);
    }
}