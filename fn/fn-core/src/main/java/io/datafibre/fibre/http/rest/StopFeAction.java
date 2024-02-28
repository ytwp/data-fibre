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

package io.datafibre.fibre.http.rest;

import io.datafibre.fibre.StarRocksFE;
import io.datafibre.fibre.http.ActionController;
import io.datafibre.fibre.http.BaseRequest;
import io.datafibre.fibre.http.BaseResponse;
import io.datafibre.fibre.http.IllegalArgException;
import io.datafibre.fibre.privilege.AccessDeniedException;
import io.datafibre.fibre.privilege.PrivilegeType;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.sql.analyzer.Authorizer;
import io.datafibre.fibre.sql.ast.UserIdentity;
import io.netty.handler.codec.http.HttpMethod;

public class StopFeAction extends RestBaseAction {
    public StopFeAction(ActionController controller) {
        super(controller);
    }

    public static void registerAction(ActionController controller)
            throws IllegalArgException {
        controller.registerHandler(HttpMethod.GET, "/api/stop", new StopFeAction(controller));
    }

    @Override
    public void executeWithoutPassword(BaseRequest request, BaseResponse response) throws AccessDeniedException {
        UserIdentity currentUser = ConnectContext.get().getCurrentUserIdentity();
        Authorizer.checkSystemAction(currentUser, null, PrivilegeType.OPERATE);

        response.setContentType("application/json");
        RestResult result = new RestResult();

        if (StarRocksFE.stopped) {
            result.addResultEntry("Message", "FE is shutting down");
        } else {
            StarRocksFE.stopped = true;
            result.addResultEntry("Message", "Stop success");
        }

        sendResult(request, response, result);
    }
}
