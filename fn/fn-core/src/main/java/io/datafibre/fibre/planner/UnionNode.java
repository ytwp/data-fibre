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

// This file is based on code available under the Apache license here:
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/planner/UnionNode.java

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package io.datafibre.fibre.planner;

import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.TupleId;
import io.datafibre.fibre.thrift.TPlanNode;
import io.datafibre.fibre.thrift.TPlanNodeType;

import java.util.List;

public class UnionNode extends SetOperationNode {
    public UnionNode(PlanNodeId id, TupleId tupleId) {
        super(id, tupleId, "UNION");
    }

    protected UnionNode(PlanNodeId id, TupleId tupleId,
                        List<Expr> setOpResultExprs, boolean isInSubplan) {
        super(id, tupleId, "UNION", setOpResultExprs, isInSubplan);
    }

    @Override
    protected void toThrift(TPlanNode msg) {
        toThrift(msg, TPlanNodeType.UNION_NODE);
    }

    @Override
    public boolean canUseRuntimeAdaptiveDop() {
        return getChildren().stream().allMatch(PlanNode::canUseRuntimeAdaptiveDop);
    }
}
