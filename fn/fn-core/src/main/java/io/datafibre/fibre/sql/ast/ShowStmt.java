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

import io.datafibre.fibre.analysis.Predicate;
import io.datafibre.fibre.analysis.RedirectStatus;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.qe.ShowResultSetMetaData;
import io.datafibre.fibre.sql.parser.NodePosition;

public abstract class ShowStmt extends StatementBase {
    protected Predicate predicate;

    protected ShowStmt(NodePosition pos) {
        super(pos);
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public abstract ShowResultSetMetaData getMetaData();

    public QueryStatement toSelectStmt() throws AnalysisException {
        return null;
    }

    @Override
    public RedirectStatus getRedirectStatus() {
        return RedirectStatus.NO_FORWARD;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitShowStatement(this, context);
    }
}
