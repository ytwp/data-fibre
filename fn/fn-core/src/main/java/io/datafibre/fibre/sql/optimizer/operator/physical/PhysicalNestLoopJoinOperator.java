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


package io.datafibre.fibre.sql.optimizer.operator.physical;

import io.datafibre.fibre.analysis.JoinOperator;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptExpressionVisitor;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.OperatorVisitor;
import io.datafibre.fibre.sql.optimizer.operator.Projection;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;

public class PhysicalNestLoopJoinOperator extends PhysicalJoinOperator {

    public PhysicalNestLoopJoinOperator(JoinOperator joinType,
                                        ScalarOperator onPredicate,
                                        String joinHint,
                                        long limit,
                                        ScalarOperator predicate,
                                        Projection projection) {
        super(OperatorType.PHYSICAL_NESTLOOP_JOIN, joinType, onPredicate, joinHint, limit, predicate, projection);
    }


    @Override
    public <R, C> R accept(OperatorVisitor<R, C> visitor, C context) {
        return visitor.visitPhysicalNestLoopJoin(this, context);
    }

    @Override
    public <R, C> R accept(OptExpressionVisitor<R, C> visitor, OptExpression optExpression, C context) {
        return visitor.visitPhysicalNestLoopJoin(optExpression, context);
    }

    @Override
    public String toString() {
        return "PhysicalNestLoopJoinOperator{" +
                "joinType=" + joinType +
                ", joinPredicate=" + onPredicate +
                ", limit=" + limit +
                ", predicate=" + predicate +
                '}';
    }

    @Override
    public String getJoinAlgo() {
        return "NESTLOOP";
    }

}
