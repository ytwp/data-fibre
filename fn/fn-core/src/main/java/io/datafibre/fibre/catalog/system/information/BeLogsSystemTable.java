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
package io.datafibre.fibre.catalog.system.information;

import io.datafibre.fibre.catalog.PrimitiveType;
import io.datafibre.fibre.catalog.ScalarType;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.system.SystemId;
import io.datafibre.fibre.catalog.system.SystemTable;
import io.datafibre.fibre.thrift.TSchemaTableType;

import static io.datafibre.fibre.catalog.system.SystemTable.NAME_CHAR_LEN;
import static io.datafibre.fibre.catalog.system.SystemTable.builder;

public class BeLogsSystemTable {
    public static SystemTable create() {
        return new SystemTable(SystemId.BE_LOGS_ID,
                "be_logs",
                Table.TableType.SCHEMA,
                builder()
                        .column("BE_ID", ScalarType.createType(PrimitiveType.BIGINT))
                        .column("LEVEL", ScalarType.createVarchar(NAME_CHAR_LEN))
                        .column("TIMESTAMP", ScalarType.createType(PrimitiveType.BIGINT))
                        .column("TID", ScalarType.createType(PrimitiveType.BIGINT))
                        .column("LOG", ScalarType.createVarchar(NAME_CHAR_LEN))
                        .build(), TSchemaTableType.SCH_BE_LOGS);
    }
}
