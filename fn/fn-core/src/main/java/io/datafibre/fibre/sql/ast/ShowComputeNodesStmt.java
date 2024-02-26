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

package io.datafibre.fibre.sql.ast;

import io.datafibre.fibre.analysis.RedirectStatus;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.ScalarType;
import io.datafibre.fibre.common.proc.ComputeNodeProcDir;
import io.datafibre.fibre.qe.ShowResultSetMetaData;
import io.datafibre.fibre.sql.parser.NodePosition;

public class ShowComputeNodesStmt extends ShowStmt {

    public ShowComputeNodesStmt() {
        this(NodePosition.ZERO);
    }

    public ShowComputeNodesStmt(NodePosition pos) {
        super(pos);
    }

    public ShowResultSetMetaData getMetaData() {
        ShowResultSetMetaData.Builder builder = ShowResultSetMetaData.builder();
        for (String title : ComputeNodeProcDir.TITLE_NAMES) {
            builder.addColumn(new Column(title, ScalarType.createVarchar(30)));
        }
        return builder.build();
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitShowComputeNodes(this, context);
    }

    @Override
    public RedirectStatus getRedirectStatus() {
        return RedirectStatus.FORWARD_NO_SYNC;
    }
}
