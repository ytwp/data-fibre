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

package io.datafibre.fibre.persist;

import com.google.gson.annotations.SerializedName;
import io.datafibre.fibre.common.io.Text;
import io.datafibre.fibre.common.io.Writable;
import io.datafibre.fibre.persist.gson.GsonUtils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AlterMaterializedViewStatusLog implements Writable {

    @SerializedName(value = "dbId")
    private long dbId;
    @SerializedName(value = "tableId")
    private long tableId;
    @SerializedName(value = "status")
    private String status;

    public AlterMaterializedViewStatusLog(long dbId, long tableId, String status) {
        this.dbId = dbId;
        this.tableId = tableId;
        this.status = status;
    }

    public long getDbId() {
        return dbId;
    }

    public void setDbId(long dbId) {
        this.dbId = dbId;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        Text.writeString(out, GsonUtils.GSON.toJson(this));
    }

    public static AlterMaterializedViewStatusLog read(DataInput in) throws IOException {
        return GsonUtils.GSON.fromJson(Text.readString(in), AlterMaterializedViewStatusLog.class);
    }

}