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
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/http/rest/TableRowCountAction.java

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.common.StarRocksHttpException;
import io.datafibre.fibre.common.util.concurrent.lock.LockType;
import io.datafibre.fibre.common.util.concurrent.lock.Locker;
import io.datafibre.fibre.http.ActionController;
import io.datafibre.fibre.http.BaseRequest;
import io.datafibre.fibre.http.BaseResponse;
import io.datafibre.fibre.http.IllegalArgException;
import io.datafibre.fibre.privilege.AccessDeniedException;
import io.datafibre.fibre.privilege.PrivilegeType;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.analyzer.Authorizer;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for fetch the approximate row count of the specified table from cluster-meta data,
 * the approximate row maybe used for some computing system to decide use which compute-algorithm can be used
 * such as shuffle join or broadcast join.
 * <p>
 * This API is not intended to compute the exact row count of the specified table, if you need the exact row count,
 * please consider using the sql syntax `select count(*) from {table}`
 */
public class TableRowCountAction extends RestBaseAction {
    public TableRowCountAction(ActionController controller) {
        super(controller);
    }

    public static void registerAction(ActionController controller) throws IllegalArgException {
        controller.registerHandler(HttpMethod.GET,
                "/api/{" + DB_KEY + "}/{" + TABLE_KEY + "}/_count",
                new TableRowCountAction(controller));
    }

    @Override
    protected void executeWithoutPassword(BaseRequest request, BaseResponse response)
            throws DdlException, AccessDeniedException {
        // just allocate 2 slot for top holder map
        Map<String, Object> resultMap = new HashMap<>(4);
        String dbName = request.getSingleParameter(DB_KEY);
        String tableName = request.getSingleParameter(TABLE_KEY);
        try {
            if (Strings.isNullOrEmpty(dbName)
                    || Strings.isNullOrEmpty(tableName)) {
                throw new StarRocksHttpException(HttpResponseStatus.BAD_REQUEST, "{database}/{table} must be selected");
            }
            // check privilege for select, otherwise return HTTP 401
            Authorizer.checkTableAction(ConnectContext.get().getCurrentUserIdentity(), ConnectContext.get().getCurrentRoleIds(),
                    dbName, tableName, PrivilegeType.SELECT);
            Database db = GlobalStateMgr.getCurrentState().getDb(dbName);
            if (db == null) {
                throw new StarRocksHttpException(HttpResponseStatus.NOT_FOUND,
                        "Database [" + dbName + "] " + "does not exists");
            }
            Locker locker = new Locker();
            locker.lockDatabase(db, LockType.WRITE);
            try {
                Table table = db.getTable(tableName);
                if (table == null) {
                    throw new StarRocksHttpException(HttpResponseStatus.NOT_FOUND,
                            "Table [" + tableName + "] " + "does not exists");
                }
                // just only support OlapTable, ignore others such as ESTable
                if (!(table instanceof OlapTable)) {
                    // Forbidden
                    throw new StarRocksHttpException(HttpResponseStatus.FORBIDDEN, "Table [" + tableName + "] "
                            + "is not a OlapTable, only support OlapTable currently");
                }
                OlapTable olapTable = (OlapTable) table;
                resultMap.put("status", 200);
                resultMap.put("size", olapTable.proximateRowCount());
            } finally {
                locker.unLockDatabase(db, LockType.WRITE);
            }
        } catch (StarRocksHttpException e) {
            // status code  should conforms to HTTP semantic
            resultMap.put("status", e.getCode().code());
            resultMap.put("exception", e.getMessage());
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            String result = mapper.writeValueAsString(resultMap);
            // send result with extra information
            response.setContentType("application/json");
            response.getContent().append(result);
            sendResult(request, response,
                    HttpResponseStatus.valueOf(Integer.parseInt(String.valueOf(resultMap.get("status")))));
        } catch (Exception e) {
            // may be this never happen
            response.getContent().append(e.getMessage());
            sendResult(request, response, HttpResponseStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
