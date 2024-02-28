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

package io.datafibre.fibre.alter;


import com.google.gson.annotations.SerializedName;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.common.io.Text;
import io.datafibre.fibre.common.util.PropertyAnalyzer;
import io.datafibre.fibre.lake.LakeTable;
import io.datafibre.fibre.persist.gson.GsonUtils;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.task.TabletMetadataUpdateAgentTask;
import io.datafibre.fibre.task.TabletMetadataUpdateAgentTaskFactory;
import io.datafibre.fibre.thrift.TTabletMetaType;

import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LakeTableAlterMetaJob extends LakeTableAlterMetaJobBase {
    @SerializedName(value = "metaType")
    private TTabletMetaType metaType;

    @SerializedName(value = "metaValue")
    private boolean metaValue;

    public LakeTableAlterMetaJob(long jobId, long dbId, long tableId, String tableName,
                                 long timeoutMs, TTabletMetaType metaType, boolean metaValue) {
        super(jobId, JobType.SCHEMA_CHANGE, dbId, tableId, tableName, timeoutMs);
        this.metaType = metaType;
        this.metaValue = metaValue;
    }

    @Override
    protected TabletMetadataUpdateAgentTask createTask(long backend, Set<Long> tablets) {
        return TabletMetadataUpdateAgentTaskFactory.createGenericBooleanPropertyUpdateTask(backend, tablets,
                metaValue, metaType);
    }

    @Override
    protected void updateCatalog(Database db, LakeTable table) {
        if (metaType == TTabletMetaType.ENABLE_PERSISTENT_INDEX) {
            Map<String, String> tempProperties = new HashMap<>();
            tempProperties.put(PropertyAnalyzer.PROPERTIES_ENABLE_PERSISTENT_INDEX, String.valueOf(metaValue));
            GlobalStateMgr.getCurrentState().getLocalMetastore()
                    .modifyTableMeta(db, table, tempProperties, metaType);
        }
    }

    @Override
    protected void restoreState(LakeTableAlterMetaJobBase job) {
        LakeTableAlterMetaJob other = (LakeTableAlterMetaJob) job;
        this.metaType = other.metaType;
        this.metaValue = other.metaValue;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        String json = GsonUtils.GSON.toJson(this, AlterJobV2.class);
        Text.writeString(out, json);
    }
}
