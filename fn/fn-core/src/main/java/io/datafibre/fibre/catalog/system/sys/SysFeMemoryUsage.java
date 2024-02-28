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

package io.datafibre.fibre.catalog.system.sys;

import io.datafibre.fibre.catalog.PrimitiveType;
import io.datafibre.fibre.catalog.ScalarType;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.system.SystemId;
import io.datafibre.fibre.catalog.system.SystemTable;
import io.datafibre.fibre.memory.MemoryUsageTracker;
import io.datafibre.fibre.privilege.AccessDeniedException;
import io.datafibre.fibre.privilege.PrivilegeType;
import io.datafibre.fibre.sql.analyzer.Authorizer;
import io.datafibre.fibre.sql.ast.UserIdentity;
import io.datafibre.fibre.thrift.TAuthInfo;
import io.datafibre.fibre.thrift.TFeMemoryItem;
import io.datafibre.fibre.thrift.TFeMemoryReq;
import io.datafibre.fibre.thrift.TFeMemoryRes;
import io.datafibre.fibre.thrift.TSchemaTableType;
import org.apache.thrift.TException;


public class SysFeMemoryUsage {


    public static final String NAME = "fe_memory_usage";

    public static SystemTable create() {
        return new SystemTable(SystemId.MEMORY_USAGE_ID, NAME,
                Table.TableType.SCHEMA,
                SystemTable.builder()
                        .column("module_name", ScalarType.createVarcharType(256))
                        .column("class_name", ScalarType.createVarcharType(256))
                        .column("current_consumption", ScalarType.createType(PrimitiveType.BIGINT))
                        .column("peak_consumption", ScalarType.createType(PrimitiveType.BIGINT))
                        .column("counter_info", ScalarType.createVarcharType(65532))
                        .build(),
                TSchemaTableType.SYS_FE_MEMORY_USAGE);
    }

    public static TFeMemoryRes listFeMemoryUsage(TFeMemoryReq request) throws TException {
        TAuthInfo auth = request.getAuth_info();
        UserIdentity currentUser;
        if (auth.isSetCurrent_user_ident()) {
            currentUser = UserIdentity.fromThrift(auth.getCurrent_user_ident());
        } else {
            currentUser = UserIdentity.createAnalyzedUserIdentWithIp(auth.getUser(), auth.getUser_ip());
        }

        try {
            Authorizer.checkSystemAction(currentUser, null, PrivilegeType.OPERATE);
        } catch (AccessDeniedException e) {
            throw new TException(e.getMessage(), e);
        }

        TFeMemoryRes response = new TFeMemoryRes();

        MemoryUsageTracker.MEMORY_USAGE.forEach((moduleName, module) -> {
            if (module != null) {
                module.forEach((className, memoryStat) -> {
                    TFeMemoryItem item = new TFeMemoryItem();
                    item.setModule_name(moduleName);
                    item.setClass_name(className);
                    item.setCurrent_consumption(memoryStat.getCurrentConsumption());
                    item.setPeak_consumption(memoryStat.getPeakConsumption());
                    item.setCounter_info(memoryStat.getCounterInfo());
                    response.addToItems(item);
                });
            }
        });

        return response;
    }

}
