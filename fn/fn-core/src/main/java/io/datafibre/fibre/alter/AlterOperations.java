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
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/alter/AlterOperations.java

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

package io.datafibre.fibre.alter;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.sql.ast.AlterClause;

import java.util.List;
import java.util.Set;

/*
 * AlterOperations contains a set alter operations generated from a AlterStmt's alter clause.
 * This class is mainly used to integrate these operation types and check whether they have conflicts.
 */
public class AlterOperations {
    private Set<AlterOpType> currentOps = Sets.newHashSet();

    public AlterOperations() {
    }

    public Set<AlterOpType> getCurrentOps() {
        return currentOps;
    }

    // check the conflicts of the given list of alter clauses
    public void checkConflict(List<AlterClause> alterClauses) throws DdlException {
        for (AlterClause alterClause : alterClauses) {
            checkOp(alterClause.getOpType());
        }
    }

    // some operations take up disk space. so we need to check the disk capacity before processing.
    // return true if we see these kind of opertions.
    public boolean needCheckCapacity() {
        for (AlterOpType currentOp : currentOps) {
            if (currentOp.needCheckCapacity()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPartitionOp() {
        return currentOps.contains(AlterOpType.ADD_PARTITION) || currentOps.contains(AlterOpType.DROP_PARTITION)
                || currentOps.contains(AlterOpType.REPLACE_PARTITION) ||
                currentOps.contains(AlterOpType.MODIFY_PARTITION);
    }

    // MODIFY_TABLE_PROPERTY is also processed by SchemaChangeHandler
    public boolean hasSchemaChangeOp() {
        return currentOps.contains(AlterOpType.SCHEMA_CHANGE) || currentOps.contains(AlterOpType.MODIFY_TABLE_PROPERTY)
                || currentOps.contains(AlterOpType.OPTIMIZE);
    }

    public boolean hasRollupOp() {
        return currentOps.contains(AlterOpType.ADD_ROLLUP) || currentOps.contains(AlterOpType.DROP_ROLLUP);
    }

    public boolean hasRenameOp() {
        return currentOps.contains(AlterOpType.RENAME);
    }

    public boolean hasSwapOp() {
        return currentOps.contains(AlterOpType.SWAP);
    }

    public boolean hasTruncatePartitionOp() {
        return currentOps.contains(AlterOpType.TRUNCATE_PARTITION);
    }

    public boolean hasCompactOp() {
        return currentOps.contains(AlterOpType.COMPACT);
    }

    public boolean hasAlterCommentOp() {
        return currentOps.contains(AlterOpType.ALTER_COMMENT);
    }

    public boolean contains(AlterOpType op) {
        return currentOps.contains(op);
    }

    // throw exception if the given operation has conflict with current operations.,
    private void checkOp(AlterOpType opType) throws DdlException {
        if (currentOps.isEmpty()) {
            currentOps.add(opType);
            return;
        }

        for (AlterOpType currentOp : currentOps) {
            if (!AlterOpType.COMPATIBITLITY_MATRIX[currentOp.ordinal()][opType.ordinal()]) {
                throw new DdlException("Alter operation " + opType + " conflicts with operation " + currentOp);
            }
        }

        currentOps.add(opType);
    }

    @Override
    public String toString() {
        return Joiner.on(", ").join(currentOps);
    }

}
