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

package io.datafibre.fibre.connector.iceberg;

import io.datafibre.fibre.connector.PartitionInfo;

public class Partition implements PartitionInfo {
    private final long modifiedTime;

    @Override
    public long getModifiedTime() {
        return modifiedTime;
    }

    public Partition(long modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
