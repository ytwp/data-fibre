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


package io.datafibre.fibre.sql.optimizer.base;

import io.datafibre.fibre.sql.optimizer.Group;
import io.datafibre.fibre.sql.optimizer.GroupExpression;

// The required physical property
public interface PhysicalProperty extends Property {
    boolean isSatisfy(PhysicalProperty other);

    // append enforcers to the child
    GroupExpression appendEnforcers(Group child);
}
