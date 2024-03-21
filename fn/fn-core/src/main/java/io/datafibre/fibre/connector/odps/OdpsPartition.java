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

package io.datafibre.fibre.connector.odps;

import com.aliyun.odps.Partition;
import io.datafibre.fibre.connector.PartitionInfo;

public class OdpsPartition implements PartitionInfo {
    private Partition partition;

    public OdpsPartition(Partition partition) {
        this.partition = partition;
    }

    @Override
    public long getModifiedTime() {
        return partition.getLastDataModifiedTime().getTime();
    }
}