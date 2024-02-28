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
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/http/rest/RowCountAction.java

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

package io.datafibre.fibre.http.rest;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.MaterializedIndex;
import io.datafibre.fibre.catalog.MaterializedIndex.IndexExtState;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.PhysicalPartition;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.Table.TableType;
import io.datafibre.fibre.catalog.Tablet;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.common.util.concurrent.lock.LockType;
import io.datafibre.fibre.common.util.concurrent.lock.Locker;
import io.datafibre.fibre.http.ActionController;
import io.datafibre.fibre.http.BaseRequest;
import io.datafibre.fibre.http.BaseResponse;
import io.datafibre.fibre.http.IllegalArgException;
import io.datafibre.fibre.privilege.AccessDeniedException;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.ast.UserIdentity;
import io.netty.handler.codec.http.HttpMethod;

import java.util.Map;

/*
 * calc row count from replica to table
 * fe_host:fe_http_port/api/rowcount?db=dbname&table=tablename
 */
public class RowCountAction extends RestBaseAction {

    public RowCountAction(ActionController controller) {
        super(controller);
    }

    public static void registerAction(ActionController controller) throws IllegalArgException {
        controller.registerHandler(HttpMethod.GET, "/api/rowcount", new RowCountAction(controller));
    }

    @Override
    protected void executeWithoutPassword(BaseRequest request, BaseResponse response) throws DdlException, AccessDeniedException {
        UserIdentity currentUser = ConnectContext.get().getCurrentUserIdentity();
        checkUserOwnsAdminRole(currentUser);

        String dbName = request.getSingleParameter(DB_KEY);
        if (Strings.isNullOrEmpty(dbName)) {
            throw new DdlException("No database selected.");
        }

        String tableName = request.getSingleParameter(TABLE_KEY);
        if (Strings.isNullOrEmpty(tableName)) {
            throw new DdlException("No table selected.");
        }

        Map<String, Long> indexRowCountMap = Maps.newHashMap();
        GlobalStateMgr globalStateMgr = GlobalStateMgr.getCurrentState();
        Database db = globalStateMgr.getDb(dbName);
        if (db == null) {
            throw new DdlException("Database[" + dbName + "] does not exist");
        }
        Locker locker = new Locker();
        locker.lockDatabase(db, LockType.WRITE);
        try {
            Table table = db.getTable(tableName);
            if (table == null) {
                throw new DdlException("Table[" + tableName + "] does not exist");
            }

            if (table.getType() != TableType.OLAP) {
                throw new DdlException("Table[" + tableName + "] is not OLAP table");
            }

            OlapTable olapTable = (OlapTable) table;
            for (PhysicalPartition partition : olapTable.getAllPhysicalPartitions()) {
                long version = partition.getVisibleVersion();
                for (MaterializedIndex index : partition.getMaterializedIndices(IndexExtState.VISIBLE)) {
                    long indexRowCount = 0L;
                    for (Tablet tablet : index.getTablets()) {
                        indexRowCount += tablet.getRowCount(version);
                    } // end for tablets
                    index.setRowCount(indexRowCount);
                    String indexName = olapTable.getIndexNameById(index.getId());
                    indexRowCountMap.put(indexName, indexRowCountMap.getOrDefault(indexName, 0L) + indexRowCount);
                } // end for indices
            } // end for partitions            
        } finally {
            locker.unLockDatabase(db, LockType.WRITE);
        }

        // to json response
        sendResultByJson(request, response, indexRowCountMap);
    }
}
