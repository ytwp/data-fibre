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

import com.google.common.base.Strings;
import io.datafibre.fibre.authentication.AuthenticationMgr;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.sql.ast.SetUserPropertyStmt;

public class SetUserPropertyAnalyzer {

    public static void analyze(SetUserPropertyStmt statement, ConnectContext context) {
        String user = statement.getUser();
        if (Strings.isNullOrEmpty(user)) {
            // If param 'user' is not set, use the login username.
            // The login username is full-qualified with cluster name.
            statement.setUser(ConnectContext.get().getQualifiedUser());
        } else {
            // If param 'user' is set, check if it needs to be full-qualified
            if (!user.equals(AuthenticationMgr.ROOT_USER)) {
                statement.setUser(user);
            }
        }
    }

}