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
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/http/rest/LoadAction.java

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
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.http.ActionController;
import io.datafibre.fibre.http.BaseRequest;
import io.datafibre.fibre.http.BaseResponse;
import io.datafibre.fibre.http.IllegalArgException;
import io.datafibre.fibre.privilege.AccessDeniedException;
import io.datafibre.fibre.privilege.PrivilegeType;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.server.RunMode;
import io.datafibre.fibre.sql.analyzer.Authorizer;
import io.datafibre.fibre.system.ComputeNode;
import io.datafibre.fibre.system.SystemInfoService;
import io.datafibre.fibre.thrift.TNetworkAddress;
import io.datafibre.fibre.warehouse.Warehouse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoadAction extends RestBaseAction {
    private static final Logger LOG = LogManager.getLogger(LoadAction.class);

    public LoadAction(ActionController controller) {
        super(controller);
    }

    public static void registerAction(ActionController controller) throws IllegalArgException {
        controller.registerHandler(HttpMethod.PUT,
                "/api/{" + DB_KEY + "}/{" + TABLE_KEY + "}/_stream_load",
                new LoadAction(controller));
    }

    @Override
    public void executeWithoutPassword(BaseRequest request, BaseResponse response) throws DdlException, AccessDeniedException {
        try {
            executeWithoutPasswordInternal(request, response);
        } catch (DdlException e) {
            TransactionResult resp = new TransactionResult();
            resp.status = ActionStatus.FAILED;
            resp.msg = e.getClass() + ": " + e.getMessage();
            LOG.warn(e);

            sendResult(request, response, resp);
        }
    }

    public void executeWithoutPasswordInternal(BaseRequest request, BaseResponse response) throws DdlException,
            AccessDeniedException {

        // A 'Load' request must have 100-continue header
        if (!request.getRequest().headers().contains(HttpHeaders.Names.EXPECT)) {
            throw new DdlException("There is no 100-continue header");
        }

        String dbName = request.getSingleParameter(DB_KEY);
        if (Strings.isNullOrEmpty(dbName)) {
            throw new DdlException("No database selected.");
        }

        String tableName = request.getSingleParameter(TABLE_KEY);
        if (Strings.isNullOrEmpty(tableName)) {
            throw new DdlException("No table selected.");
        }

        String label = request.getRequest().headers().get(LABEL_KEY);

        Authorizer.checkTableAction(ConnectContext.get().getCurrentUserIdentity(), ConnectContext.get().getCurrentRoleIds(),
                dbName, tableName, PrivilegeType.INSERT);

        // Choose a backend sequentially, or choose a cn in shared_data mode
        List<Long> nodeIds = new ArrayList<>();
        if (RunMode.isSharedDataMode()) {
            Warehouse warehouse = GlobalStateMgr.getCurrentState().getWarehouseMgr().getDefaultWarehouse();
            for (long nodeId : warehouse.getAnyAvailableCluster().getComputeNodeIds()) {
                ComputeNode node = GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo().getBackendOrComputeNode(nodeId);
                if (node != null && node.isAvailable()) {
                    nodeIds.add(nodeId);
                }
            }
            Collections.shuffle(nodeIds);
        } else {
            SystemInfoService systemInfoService = GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo();
            nodeIds = systemInfoService.getNodeSelector().seqChooseBackendIds(1, false, false, null);
        }
        
        if (CollectionUtils.isEmpty(nodeIds)) {
            throw new DdlException("No backend alive.");
        }

        // TODO: need to refactor after be split into cn + dn
        ComputeNode node = GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo().getBackendOrComputeNode(nodeIds.get(0));
        if (node == null) {
            throw new DdlException("No backend or compute node alive.");
        }

        TNetworkAddress redirectAddr = new TNetworkAddress(node.getHost(), node.getHttpPort());

        LOG.info("redirect load action to destination={}, db: {}, tbl: {}, label: {}",
                redirectAddr.toString(), dbName, tableName, label);
        redirectTo(request, response, redirectAddr);
    }
}

