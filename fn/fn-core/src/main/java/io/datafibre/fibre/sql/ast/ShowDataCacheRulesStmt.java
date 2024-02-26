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

package io.datafibre.fibre.sql.ast;

import com.starrocks.catalog.Column;
import com.starrocks.catalog.ScalarType;
import com.starrocks.qe.ShowResultSetMetaData;
import com.starrocks.sql.parser.NodePosition;

public class ShowDataCacheRulesStmt extends ShowStmt {

    private static final ShowResultSetMetaData META_DATA =
            ShowResultSetMetaData.builder()
                    .addColumn(new Column("Rule Id", ScalarType.createVarchar(20)))
                    .addColumn(new Column("Catalog", ScalarType.createVarchar(30)))
                    .addColumn(new Column("Database", ScalarType.createVarchar(30)))
                    .addColumn(new Column("Table", ScalarType.createVarchar(30)))
                    .addColumn(new Column("Priority", ScalarType.createVarchar(20)))
                    .addColumn(new Column("Predicates", ScalarType.createVarchar(30)))
                    .addColumn(new Column("Properties", ScalarType.createVarchar(30)))
                    .build();

    public ShowDataCacheRulesStmt(NodePosition pos) {
        super(pos);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitShowDataCacheRulesStatement(this, context);
    }

    @Override
    public ShowResultSetMetaData getMetaData() {
        return META_DATA;
    }
}
