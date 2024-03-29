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

import com.google.common.collect.ImmutableList;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.ScalarType;
import io.datafibre.fibre.qe.ShowResultSetMetaData;
import io.datafibre.fibre.sql.ast.AdminSetConfigStmt.ConfigType;
import io.datafibre.fibre.sql.parser.NodePosition;

// admin show frontend config;
public class AdminShowConfigStmt extends ShowStmt {
    public static final ImmutableList<String> TITLE_NAMES =
            new ImmutableList.Builder<String>().add("Key").add("AliasNames").add(
                    "Value").add("Type").add("IsMutable").add("Comment").build();

    private final ConfigType type;

    private final String pattern;

    public AdminShowConfigStmt(ConfigType type, String pattern) {
        this(type, pattern, NodePosition.ZERO);
    }

    public AdminShowConfigStmt(ConfigType type, String pattern, NodePosition pos) {
        super(pos);
        this.type = type;
        this.pattern = pattern;
    }

    public ConfigType getType() {
        return type;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public ShowResultSetMetaData getMetaData() {
        ShowResultSetMetaData.Builder builder = ShowResultSetMetaData.builder();
        for (String title : TITLE_NAMES) {
            builder.addColumn(new Column(title, ScalarType.createVarchar(30)));
        }
        return builder.build();
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitAdminShowConfigStatement(this, context);
    }
}
