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
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/http/rest/StorageTypeCheckAction.java

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
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.MaterializedIndexMeta;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.Table.TableType;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.common.util.concurrent.lock.LockType;
import io.datafibre.fibre.common.util.concurrent.lock.Locker;
import io.datafibre.fibre.http.ActionController;
import io.datafibre.fibre.http.BaseRequest;
import io.datafibre.fibre.http.BaseResponse;
import io.datafibre.fibre.http.IllegalArgException;
import io.datafibre.fibre.privilege.AccessDeniedException;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.sql.ast.UserIdentity;
import io.datafibre.fibre.thrift.TStorageType;
import io.netty.handler.codec.http.HttpMethod;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class StorageTypeCheckAction extends RestBaseAction {
    public StorageTypeCheckAction(ActionController controller) {
        super(controller);
    }

    public static void registerAction(ActionController controller) throws IllegalArgException {
        StorageTypeCheckAction action = new StorageTypeCheckAction(controller);
        controller.registerHandler(HttpMethod.GET, "/api/_check_storagetype", action);
    }

    @Override
    protected void executeWithoutPassword(BaseRequest request, BaseResponse response) throws DdlException, AccessDeniedException {
        UserIdentity currentUser = ConnectContext.get().getCurrentUserIdentity();
        checkUserOwnsAdminRole(currentUser);

        String dbName = request.getSingleParameter(DB_KEY);
        if (Strings.isNullOrEmpty(dbName)) {
            throw new DdlException("Parameter db is missing");
        }

        Database db = globalStateMgr.getDb(dbName);
        if (db == null) {
            throw new DdlException("Database " + dbName + " does not exist");
        }

        JSONObject root = new JSONObject();
        Locker locker = new Locker();
        locker.lockDatabase(db, LockType.READ);
        try {
            List<Table> tbls = db.getTables();
            for (Table tbl : tbls) {
                if (tbl.getType() != TableType.OLAP) {
                    continue;
                }

                OlapTable olapTbl = (OlapTable) tbl;
                JSONObject indexObj = new JSONObject();
                for (Map.Entry<Long, MaterializedIndexMeta> entry : olapTbl.getIndexIdToMeta().entrySet()) {
                    MaterializedIndexMeta indexMeta = entry.getValue();
                    if (indexMeta.getStorageType() == TStorageType.ROW) {
                        indexObj.put(olapTbl.getIndexNameById(entry.getKey()), indexMeta.getStorageType().name());
                    }
                }
                root.put(tbl.getName(), indexObj);
            }
        } finally {
            locker.unLockDatabase(db, LockType.READ);
        }

        // to json response
        String result = root.toString();

        // send result
        response.setContentType("application/json");
        response.getContent().append(result);
        sendResult(request, response);
    }
}
