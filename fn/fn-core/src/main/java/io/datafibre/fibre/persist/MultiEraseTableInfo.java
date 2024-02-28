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

package io.datafibre.fibre.persist;

import com.google.gson.annotations.SerializedName;
import io.datafibre.fibre.common.io.Text;
import io.datafibre.fibre.common.io.Writable;
import io.datafibre.fibre.persist.gson.GsonUtils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;

public class MultiEraseTableInfo implements Writable {

    @SerializedName(value = "tableIds")
    private List<Long> tableIds;

    public MultiEraseTableInfo(List<Long> tableIds) {
        this.tableIds = tableIds;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        Text.writeString(out, GsonUtils.GSON.toJson(this));
    }

    public static MultiEraseTableInfo read(DataInput in) throws IOException {
        String json = Text.readString(in);
        return GsonUtils.GSON.fromJson(json, MultiEraseTableInfo.class);
    }

    public List<Long> getTableIds() {
        return tableIds;
    }
}
