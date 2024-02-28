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

import io.datafibre.fibre.analysis.LabelName;
import io.datafibre.fibre.sql.parser.NodePosition;

/*
  Resume routine load job by name

  syntax:
      RESUME ROUTINE LOAD [database.]name
 */
public class ResumeRoutineLoadStmt extends DdlStmt {

    private LabelName labelName;

    public ResumeRoutineLoadStmt(LabelName labelName) {
        this(labelName, NodePosition.ZERO);
    }

    public ResumeRoutineLoadStmt(LabelName labelName, NodePosition pos) {
        super(pos);
        this.labelName = labelName;
    }

    public String getName() {
        return labelName.getLabelName();
    }

    public String getDbFullName() {
        return labelName.getDbName();
    }

    public void setLabelName(LabelName labelName) {
        this.labelName = labelName;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitResumeRoutineLoadStatement(this, context);
    }
}
