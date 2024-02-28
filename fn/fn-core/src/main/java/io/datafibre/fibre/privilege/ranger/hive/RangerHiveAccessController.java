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

package io.datafibre.fibre.privilege.ranger.hive;

import com.google.common.collect.Maps;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.TableName;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.privilege.AccessDeniedException;
import io.datafibre.fibre.privilege.PrivilegeType;
import io.datafibre.fibre.privilege.ranger.RangerAccessController;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.sql.ast.UserIdentity;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class RangerHiveAccessController extends RangerAccessController {
    public RangerHiveAccessController(String serviceName) {
        super("hive", serviceName);
    }

    @Override
    public void checkDbAction(UserIdentity currentUser, Set<Long> roleIds, String catalogName, String db,
                              PrivilegeType privilegeType) throws AccessDeniedException {
        hasPermission(RangerHiveResource.builder()
                        .setDatabase(db)
                        .build(),
                currentUser,
                privilegeType);
    }

    @Override
    public void checkAnyActionOnDb(UserIdentity currentUser, Set<Long> roleIds, String catalogName, String db)
            throws AccessDeniedException {
        hasPermission(RangerHiveResource.builder()
                        .setDatabase(db)
                        .build(),
                currentUser,
                PrivilegeType.ANY);
    }

    @Override
    public void checkTableAction(UserIdentity currentUser, Set<Long> roleIds, TableName tableName, PrivilegeType privilegeType)
            throws AccessDeniedException {
        hasPermission(RangerHiveResource.builder()
                        .setDatabase(tableName.getDb())
                        .setTable(tableName.getTbl())
                        .build(),
                currentUser,
                privilegeType);
    }

    @Override
    public void checkAnyActionOnTable(UserIdentity currentUser, Set<Long> roleIds, TableName tableName)
            throws AccessDeniedException {
        hasPermission(RangerHiveResource.builder()
                        .setDatabase(tableName.getDb())
                        .setTable(tableName.getTbl())
                        .build(),
                currentUser,
                PrivilegeType.ANY);
    }

    @Override
    public Map<String, Expr> getColumnMaskingPolicy(ConnectContext context, TableName tableName, List<Column> columns) {
        Map<String, Expr> maskingExprMap = Maps.newHashMap();
        for (Column column : columns) {
            Expr columnMaskingExpression = getColumnMaskingExpression(RangerHiveResource.builder()
                    .setDatabase(tableName.getDb())
                    .setTable(tableName.getTbl())
                    .setColumn(column.getName())
                    .build(), column, context);
            if (columnMaskingExpression != null) {
                maskingExprMap.put(column.getName(), columnMaskingExpression);
            }
        }

        return maskingExprMap;
    }

    @Override
    public Expr getRowAccessPolicy(ConnectContext context, TableName tableName) {
        return getRowAccessExpression(RangerHiveResource.builder()
                .setDatabase(tableName.getDb())
                .setTable(tableName.getTbl())
                .build(), context);
    }

    @Override
    public String convertToAccessType(PrivilegeType privilegeType) {
        HiveAccessType hiveAccessType;
        if (privilegeType == PrivilegeType.SELECT) {
            hiveAccessType = HiveAccessType.SELECT;
        } else {
            hiveAccessType = HiveAccessType.NONE;
        }

        return hiveAccessType.name().toLowerCase(Locale.ENGLISH);
    }
}
