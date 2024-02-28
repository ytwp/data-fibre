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
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/http/rest/MigrationAction.java

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
import com.google.common.collect.Lists;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.LocalTablet;
import io.datafibre.fibre.catalog.MaterializedIndex;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.Partition;
import io.datafibre.fibre.catalog.Replica;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.Table.TableType;
import io.datafibre.fibre.catalog.Tablet;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.common.util.ListComparator;
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
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

/*
 * used to get table's sorted tablet info
 * eg:
 *  fe_host:http_port/api/_migration?db=xxx&tbl=yyy
 */
public class MigrationAction extends RestBaseAction {
    private static final Logger LOG = LogManager.getLogger(MigrationAction.class);
    private static final String DB_PARAM = "db";
    private static final String TABLE_PARAM = "tbl";

    public MigrationAction(ActionController controller) {
        super(controller);
    }

    public static void registerAction(ActionController controller) throws IllegalArgException {
        MigrationAction action = new MigrationAction(controller);
        controller.registerHandler(HttpMethod.GET, "/api/_migration", action);
    }

    @Override
    protected void executeWithoutPassword(BaseRequest request, BaseResponse response) throws DdlException, AccessDeniedException {
        UserIdentity currentUser = ConnectContext.get().getCurrentUserIdentity();
        checkUserOwnsAdminRole(currentUser);

        String dbName = request.getSingleParameter(DB_PARAM);
        String tableName = request.getSingleParameter(TABLE_PARAM);

        if (Strings.isNullOrEmpty(dbName)) {
            throw new DdlException("Missing params. Need database name");
        }

        Database db = GlobalStateMgr.getCurrentState().getDb(dbName);
        if (db == null) {
            throw new DdlException("Database[" + dbName + "] does not exist");
        }

        List<List<Comparable>> rows = Lists.newArrayList();
        Locker locker = new Locker();
        locker.lockDatabase(db, LockType.READ);
        try {
            if (!Strings.isNullOrEmpty(tableName)) {
                Table table = db.getTable(tableName);
                if (table == null) {
                    throw new DdlException("Table[" + tableName + "] does not exist");
                }

                if (table.getType() != TableType.OLAP) {
                    throw new DdlException("Table[" + tableName + "] is not OlapTable");
                }

                OlapTable olapTable = (OlapTable) table;

                for (Partition partition : olapTable.getPartitions()) {
                    String partitionName = partition.getName();
                    MaterializedIndex baseIndex = partition.getBaseIndex();
                    for (Tablet tablet : baseIndex.getTablets()) {
                        List<Comparable> row = Lists.newArrayList();
                        row.add(tableName);
                        row.add(partitionName);
                        row.add(tablet.getId());
                        row.add(olapTable.getSchemaHashByIndexId(baseIndex.getId()));
                        if (CollectionUtils.isNotEmpty(((LocalTablet) tablet).getImmutableReplicas())) {
                            Replica replica = ((LocalTablet) tablet).getImmutableReplicas().get(0);
                            row.add(replica.getBackendId());
                        }
                        rows.add(row);
                    }
                }
            } else {
                // get all olap table
                for (Table table : db.getTables()) {
                    if (table.getType() != TableType.OLAP) {
                        continue;
                    }

                    OlapTable olapTable = (OlapTable) table;
                    tableName = table.getName();

                    for (Partition partition : olapTable.getPartitions()) {
                        String partitionName = partition.getName();
                        MaterializedIndex baseIndex = partition.getBaseIndex();
                        for (Tablet tablet : baseIndex.getTablets()) {
                            List<Comparable> row = Lists.newArrayList();
                            row.add(tableName);
                            row.add(partitionName);
                            row.add(tablet.getId());
                            row.add(olapTable.getSchemaHashByIndexId(baseIndex.getId()));
                            if (CollectionUtils.isNotEmpty(((LocalTablet) tablet).getImmutableReplicas())) {
                                Replica replica = ((LocalTablet) tablet).getImmutableReplicas().get(0);
                                row.add(replica.getBackendId());
                            }
                            rows.add(row);
                        }
                    }
                }
            }

        } finally {
            locker.unLockDatabase(db, LockType.READ);
        }

        ListComparator<List<Comparable>> comparator = new ListComparator<List<Comparable>>(0, 1, 2);
        Collections.sort(rows, comparator);

        // to json response
        sendResultByJson(request, response, rows);
    }

    public static void print(String msg) {
        System.out.println(System.currentTimeMillis() + " " + msg);
    }
}
