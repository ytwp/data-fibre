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

package io.datafibre.fibre.sql.optimizer.rule.transformation.materialization.equivalent;

public class EquivalentShuttleContext {
    private boolean isRewrittenByEquivalent;
    private final boolean isRollup;

    public EquivalentShuttleContext(boolean isRollup) {
        this.isRollup = isRollup;
    }

    public boolean isRewrittenByEquivalent() {
        return isRewrittenByEquivalent;
    }

    public boolean isRollup() {
        return isRollup;
    }

    public void setRewrittenByEquivalent(boolean rewrittenByEquivalent) {
        isRewrittenByEquivalent = rewrittenByEquivalent;
    }
}