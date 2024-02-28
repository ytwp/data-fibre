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

package io.datafibre.fibre.common.util;

import io.datafibre.fibre.common.NoAliveBackendException;
import io.datafibre.fibre.common.UserException;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.server.RunMode;

public class AutoInferUtil {
    public static int calDefaultReplicationNum() throws UserException {
        if (RunMode.isSharedDataMode()) {
            return 1;
        }

        int defaultReplicationNum =
                Math.min(3, GlobalStateMgr.getCurrentState().getNodeMgr().getClusterInfo().getTotalBackendNumber());
        if (defaultReplicationNum == 0) {
            throw new NoAliveBackendException("No alive backend");
        }
        return defaultReplicationNum;
    }
}

