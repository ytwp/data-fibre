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

package io.datafibre.fibre.sql.ast.pipe;

import io.datafibre.fibre.analysis.ParseNode;
import io.datafibre.fibre.sql.ast.AstVisitor;
import io.datafibre.fibre.sql.parser.NodePosition;

public abstract class AlterPipeClause implements ParseNode {

    private final NodePosition nodePos;

    public AlterPipeClause(NodePosition pos) {
        this.nodePos = pos;
    }

    @Override
    public NodePosition getPos() {
        return nodePos;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitAlterPipeClause(this, context);
    }
}
