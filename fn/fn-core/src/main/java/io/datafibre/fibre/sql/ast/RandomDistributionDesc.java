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

// This file is based on code available under the Apache license here:
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/analysis/RandomDistributionDesc.java

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package io.datafibre.fibre.sql.ast;

import com.starrocks.catalog.Column;
import com.starrocks.catalog.DistributionInfo;
import com.starrocks.catalog.DistributionInfo.DistributionInfoType;
import com.starrocks.catalog.RandomDistributionInfo;
import com.starrocks.sql.analyzer.SemanticException;
import com.starrocks.sql.parser.NodePosition;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class RandomDistributionDesc extends DistributionDesc {
    int numBucket;

    public RandomDistributionDesc() {
        this(0, NodePosition.ZERO);
    }

    public RandomDistributionDesc(int numBucket) {
        this(numBucket, NodePosition.ZERO);
    }

    public RandomDistributionDesc(int numBucket, NodePosition pos) {
        super(pos);
        type = DistributionInfoType.RANDOM;
        this.numBucket = numBucket;
    }

    @Override
    public void analyze(Set<String> colSet) {
        if (numBucket < 0) {
            throw new SemanticException("Number of random distribution is zero.");
        }
    }

    @Override
    public int getBuckets() {
        return numBucket;
    }

    @Override
    public DistributionInfo toDistributionInfo(List<Column> columns) {
        return new RandomDistributionInfo(numBucket);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        super.write(out);
        out.writeInt(numBucket);
    }

    public void readFields(DataInput in) throws IOException {
        numBucket = in.readInt();
    }

    @Override
    public String toString() {
        if (numBucket > 0) {
            return "DISTRIBUTED BY RANDOM BUCKETS " + numBucket;
        } else {
            return "DISTRIBUTED BY RANDOM";
        }
    }
}
