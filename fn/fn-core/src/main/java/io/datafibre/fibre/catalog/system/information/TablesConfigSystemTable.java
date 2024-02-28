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

import io.datafibre.fibre.catalog.ScalarType;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.catalog.system.SystemId;
import io.datafibre.fibre.catalog.system.SystemTable;
import io.datafibre.fibre.thrift.TSchemaTableType;

import static io.datafibre.fibre.catalog.system.SystemTable.MAX_FIELD_VARCHAR_LENGTH;
import static io.datafibre.fibre.catalog.system.SystemTable.NAME_CHAR_LEN;
import static io.datafibre.fibre.catalog.system.SystemTable.builder;

public class TablesConfigSystemTable {
    public static SystemTable create() {
        return new SystemTable(SystemId.TABLES_CONFIG_ID,
                "tables_config",
                Table.TableType.SCHEMA,
                builder()
                        .column("TABLE_SCHEMA", ScalarType.createVarchar(NAME_CHAR_LEN))
                        .column("TABLE_NAME", ScalarType.createVarchar(NAME_CHAR_LEN))
                        .column("TABLE_ENGINE", ScalarType.createVarchar(NAME_CHAR_LEN))
                        .column("TABLE_MODEL", ScalarType.createVarchar(NAME_CHAR_LEN))
                        .column("PRIMARY_KEY", ScalarType.createVarchar(NAME_CHAR_LEN))
                        .column("PARTITION_KEY", ScalarType.createVarchar(NAME_CHAR_LEN))
                        .column("DISTRIBUTE_KEY", ScalarType.createVarchar(NAME_CHAR_LEN))
                        .column("DISTRIBUTE_TYPE", ScalarType.createVarchar(NAME_CHAR_LEN))
                        .column("DISTRIBUTE_BUCKET", ScalarType.INT)
                        .column("SORT_KEY", ScalarType.createVarchar(NAME_CHAR_LEN))
                        .column("PROPERTIES", ScalarType.createVarchar(MAX_FIELD_VARCHAR_LENGTH))
                        .column("TABLE_ID", Type.BIGINT)
                        .build(), TSchemaTableType.SCH_TABLES_CONFIG);
    }
}
