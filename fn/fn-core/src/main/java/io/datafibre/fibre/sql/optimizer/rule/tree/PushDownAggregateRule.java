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

import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.rule.tree.pdagg.PushDownAggregateRewriter;
import io.datafibre.fibre.sql.optimizer.task.TaskContext;

public class PushDownAggregateRule implements TreeRewriteRule {

    private final PushDownAggregateRewriter rewriter;

    public PushDownAggregateRule(TaskContext taskContext) {
        this.rewriter = new PushDownAggregateRewriter(taskContext);
    }

    public PushDownAggregateRewriter getRewriter() {
        return rewriter;
    }

    @Override
    public OptExpression rewrite(OptExpression root, TaskContext taskContext) {
        return rewriter.rewrite(root);
    }
}
