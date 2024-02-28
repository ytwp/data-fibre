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

package io.datafibre.fibre.server;

import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.MysqlTable;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.sql.ast.CreateTableStmt;

import java.util.List;
import javax.validation.constraints.NotNull;

public class MysqlTableFactory implements AbstractTableFactory {

    public static final MysqlTableFactory INSTANCE = new MysqlTableFactory();

    private MysqlTableFactory() {
    }

    @Override
    @NotNull
    public Table createTable(LocalMetastore metastore, Database database, CreateTableStmt stmt) throws DdlException {
        String tableName = stmt.getTableName();

        List<Column> columns = stmt.getColumns();

        long tableId = GlobalStateMgr.getCurrentState().getNextId();
        MysqlTable mysqlTable = new MysqlTable(tableId, tableName, columns, stmt.getProperties());
        mysqlTable.setComment(stmt.getComment());
        return mysqlTable;
    }
}
