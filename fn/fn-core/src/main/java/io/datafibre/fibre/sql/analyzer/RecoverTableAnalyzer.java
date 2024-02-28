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

package io.datafibre.fibre.sql.analyzer;

import io.datafibre.fibre.analysis.TableName;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.sql.ast.RecoverTableStmt;
import io.datafibre.fibre.sql.common.MetaUtils;

public class RecoverTableAnalyzer {

    public static void analyze(RecoverTableStmt statement, ConnectContext context) {
        TableName tableName = statement.getTableNameObject();
        MetaUtils.normalizationTableName(context, tableName);
    }
}
