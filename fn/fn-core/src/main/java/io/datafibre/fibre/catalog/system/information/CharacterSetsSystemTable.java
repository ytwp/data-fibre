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

import static io.datafibre.fibre.catalog.system.SystemTable.builder;

public class CharacterSetsSystemTable {
    public static SystemTable create(String catalogName) {
        return new SystemTable(
                catalogName,
                SystemId.CHARACTER_SETS_ID,
                "character_sets",
                Table.TableType.SCHEMA,
                builder()
                        .column("CHARACTER_SET_NAME", ScalarType.createVarchar(512))
                        .column("DEFAULT_COLLATE_NAME", ScalarType.createVarchar(64))
                        .column("DESCRIPTION", ScalarType.createVarchar(64))
                        .column("MAXLEN", ScalarType.createType(PrimitiveType.BIGINT))
                        .build(), TSchemaTableType.SCH_CHARSETS);
    }
}
