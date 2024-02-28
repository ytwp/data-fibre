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

import static io.datafibre.fibre.catalog.system.SystemTable.MAX_FIELD_VARCHAR_LENGTH;
import static io.datafibre.fibre.catalog.system.SystemTable.builder;

public class TaskRunsSystemTable {
    public static SystemTable create() {
        return new SystemTable(SystemId.TASK_RUNS_ID,
                "task_runs",
                Table.TableType.SCHEMA,
                builder()
                        .column("QUERY_ID", ScalarType.createVarchar(64))
                        .column("TASK_NAME", ScalarType.createVarchar(64))
                        .column("CREATE_TIME", ScalarType.createType(PrimitiveType.DATETIME))
                        .column("FINISH_TIME", ScalarType.createType(PrimitiveType.DATETIME))
                        .column("STATE", ScalarType.createVarchar(16))
                        .column("DATABASE", ScalarType.createVarchar(64))
                        .column("DEFINITION", ScalarType.createVarchar(MAX_FIELD_VARCHAR_LENGTH))
                        .column("EXPIRE_TIME", ScalarType.createType(PrimitiveType.DATETIME))
                        .column("ERROR_CODE", ScalarType.createType(PrimitiveType.BIGINT))
                        .column("ERROR_MESSAGE", ScalarType.createVarchar(MAX_FIELD_VARCHAR_LENGTH))
                        .column("PROGRESS", ScalarType.createVarchar(64))
                        .column("EXTRA_MESSAGE", ScalarType.createVarchar(8192))
                        .column("PROPERTIES", ScalarType.createVarcharType(512))
                        .build(), TSchemaTableType.SCH_TASK_RUNS);
    }
}
