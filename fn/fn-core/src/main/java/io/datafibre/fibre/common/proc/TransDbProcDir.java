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
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/common/proc/TransDbProcDir.java

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

package io.datafibre.fibre.common.proc;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.common.util.ListComparator;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.transaction.GlobalTransactionMgr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransDbProcDir implements ProcDirInterface {
    public static final ImmutableList<String> TITLE_NAMES = new ImmutableList.Builder<String>()
            .add("DbId")
            .add("DbName")
            .build();

    public TransDbProcDir() {
    }

    @Override
    public ProcResult fetchResult() throws AnalysisException {
        BaseProcResult result = new BaseProcResult();
        result.setNames(TITLE_NAMES);
        GlobalTransactionMgr transactionMgr = GlobalStateMgr.getCurrentState().getGlobalTransactionMgr();
        List<List<Comparable>> infos = transactionMgr.getDbInfo();
        // order by dbId, asc
        ListComparator<List<Comparable>> comparator = new ListComparator<List<Comparable>>(0);
        Collections.sort(infos, comparator);
        for (List<Comparable> info : infos) {
            List<String> row = new ArrayList<String>(info.size());
            for (Comparable comparable : info) {
                row.add(comparable.toString());
            }
            result.addRow(row);
        }
        return result;

    }

    @Override
    public boolean register(String name, ProcNodeInterface node) {
        return false;
    }

    @Override
    public ProcNodeInterface lookup(String dbIdOrName) throws AnalysisException {
        if (Strings.isNullOrEmpty(dbIdOrName)) {
            throw new AnalysisException("Db id is null");
        }
        return new TransStateProcDir(dbIdOrName);
    }
}
