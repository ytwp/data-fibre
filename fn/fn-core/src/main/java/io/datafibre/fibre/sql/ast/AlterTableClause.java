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

import io.datafibre.fibre.alter.AlterOpType;
import io.datafibre.fibre.sql.parser.NodePosition;

// alter table clause
public abstract class AlterTableClause extends AlterClause {

    protected AlterTableClause(AlterOpType opType, NodePosition pos) {
        super(opType, pos);
    }

    // if set to true, the corresponding table should be stable before processing this operation on it.
    protected boolean needTableStable = true;

    public boolean isNeedTableStable() {
        return needTableStable;
    }
}
