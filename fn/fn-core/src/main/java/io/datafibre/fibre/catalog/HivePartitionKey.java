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


package io.datafibre.fibre.catalog;

import com.google.common.collect.ImmutableList;
import io.datafibre.fibre.connector.hive.HiveMetaClient;

import java.util.List;

public class HivePartitionKey extends PartitionKey implements NullablePartitionKey {
    public HivePartitionKey() {
        super();
    }

    @Override
    public List<String> nullPartitionValueList() {
        return ImmutableList.of(HiveMetaClient.PARTITION_NULL_VALUE);
    }
}
