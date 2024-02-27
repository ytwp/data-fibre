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

package io.datafibre.fibre.sql;

import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.KeysType;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.Utils;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalScanOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;
import io.datafibre.fibre.sql.optimizer.statistics.IDictManager;

import java.util.List;
import java.util.stream.Collectors;

public class ShortCircuitPlannerHybrid {

    public static class LogicalPlanChecker extends ShortCircuitPlanner.LogicalPlanChecker {

        public LogicalPlanChecker(boolean allowFilter, boolean allowLimit, boolean allowProject, boolean allowSort,
                                  ScalarOperator predicate, List<String> orderByColumns, long limit) {
            super(allowFilter, allowLimit, allowProject, allowSort, predicate, orderByColumns, limit);
        }

        @Override
        public Boolean visitLogicalTableScan(OptExpression optExpression, Void context) {
            LogicalScanOperator scanOp = optExpression.getOp().cast();
            Table table = scanOp.getTable();
//            if (!(table instanceof OlapTable) && !(((OlapTable) table).getKeysType().equals(KeysType.PRIMARY_KEYS))) {
//                return false;
//            }

            for (Column column : table.getFullSchema()) {
                if (IDictManager.getInstance().hasGlobalDict(table.getId(), column.getName())) {
                    return false;
                }
            }

//            List<String> keyColumns = ((OlapTable) table).getKeyColumns().stream().map(Column::getName).collect(
//                    Collectors.toList());
//            List<ScalarOperator> conjuncts = Utils.extractConjuncts(predicate);
//            return isPointScan(table, keyColumns, conjuncts);

            return false;
        }
    }
}
