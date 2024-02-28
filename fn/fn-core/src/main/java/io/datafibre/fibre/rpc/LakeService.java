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


package io.datafibre.fibre.rpc;

import com.baidu.jprotobuf.pbrpc.ProtobufRPC;
import io.datafibre.fibre.proto.AbortCompactionRequest;
import io.datafibre.fibre.proto.AbortCompactionResponse;
import io.datafibre.fibre.proto.AbortTxnRequest;
import io.datafibre.fibre.proto.AbortTxnResponse;
import io.datafibre.fibre.proto.CompactRequest;
import io.datafibre.fibre.proto.CompactResponse;
import io.datafibre.fibre.proto.DeleteDataRequest;
import io.datafibre.fibre.proto.DeleteDataResponse;
import io.datafibre.fibre.proto.DeleteTabletRequest;
import io.datafibre.fibre.proto.DeleteTabletResponse;
import io.datafibre.fibre.proto.DeleteTxnLogRequest;
import io.datafibre.fibre.proto.DeleteTxnLogResponse;
import io.datafibre.fibre.proto.DropTableRequest;
import io.datafibre.fibre.proto.DropTableResponse;
import io.datafibre.fibre.proto.LockTabletMetadataRequest;
import io.datafibre.fibre.proto.LockTabletMetadataResponse;
import io.datafibre.fibre.proto.PublishLogVersionBatchRequest;
import io.datafibre.fibre.proto.PublishLogVersionRequest;
import io.datafibre.fibre.proto.PublishLogVersionResponse;
import io.datafibre.fibre.proto.PublishVersionRequest;
import io.datafibre.fibre.proto.PublishVersionResponse;
import io.datafibre.fibre.proto.RestoreSnapshotsRequest;
import io.datafibre.fibre.proto.RestoreSnapshotsResponse;
import io.datafibre.fibre.proto.TabletStatRequest;
import io.datafibre.fibre.proto.TabletStatResponse;
import io.datafibre.fibre.proto.UnlockTabletMetadataRequest;
import io.datafibre.fibre.proto.UnlockTabletMetadataResponse;
import io.datafibre.fibre.proto.UploadSnapshotsRequest;
import io.datafibre.fibre.proto.UploadSnapshotsResponse;
import io.datafibre.fibre.proto.VacuumRequest;
import io.datafibre.fibre.proto.VacuumResponse;

import java.util.concurrent.Future;

import static org.joda.time.DateTimeConstants.MILLIS_PER_DAY;
import static org.joda.time.DateTimeConstants.MILLIS_PER_HOUR;
import static org.joda.time.DateTimeConstants.MILLIS_PER_MINUTE;
import static org.joda.time.DateTimeConstants.MILLIS_PER_SECOND;

public interface LakeService {
    long TIMEOUT_PUBLISH_VERSION = MILLIS_PER_MINUTE;
    long TIMEOUT_GET_TABLET_STATS = 15 * MILLIS_PER_MINUTE;
    long TIMEOUT_COMPACT = MILLIS_PER_DAY;
    long TIMEOUT_ABORT = 5 * MILLIS_PER_SECOND;
    long TIMEOUT_DELETE_TABLET = 10 * MILLIS_PER_MINUTE;
    long TIMEOUT_DELETE_DATA = 5 * MILLIS_PER_MINUTE;
    long TIMEOUT_DROP_TABLE = 5 * MILLIS_PER_MINUTE;
    long TIMEOUT_PUBLISH_LOG_VERSION = MILLIS_PER_MINUTE;
    long TIMEOUT_PUBLISH_LOG_VERSION_BATCH = MILLIS_PER_MINUTE;
    long TIMEOUT_ABORT_COMPACTION = 5 * MILLIS_PER_SECOND;
    long TIMEOUT_VACUUM = MILLIS_PER_HOUR;

    @ProtobufRPC(serviceName = "LakeService", methodName = "publish_version", onceTalkTimeout = TIMEOUT_PUBLISH_VERSION)
    Future<PublishVersionResponse> publishVersion(PublishVersionRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "abort_txn", onceTalkTimeout = TIMEOUT_ABORT)
    Future<AbortTxnResponse> abortTxn(AbortTxnRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "compact", onceTalkTimeout = TIMEOUT_COMPACT)
    Future<CompactResponse> compact(CompactRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "delete_tablet", onceTalkTimeout = TIMEOUT_DELETE_TABLET)
    Future<DeleteTabletResponse> deleteTablet(DeleteTabletRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "delete_data", onceTalkTimeout = TIMEOUT_DELETE_DATA)
    Future<DeleteDataResponse> deleteData(DeleteDataRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "delete_txn_log", onceTalkTimeout = /*10m=*/600000)
    Future<DeleteTxnLogResponse> deleteTxnLog(DeleteTxnLogRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "get_tablet_stats", onceTalkTimeout = TIMEOUT_GET_TABLET_STATS)
    Future<TabletStatResponse> getTabletStats(TabletStatRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "drop_table", onceTalkTimeout = TIMEOUT_DROP_TABLE)
    Future<DropTableResponse> dropTable(DropTableRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "publish_log_version", onceTalkTimeout = TIMEOUT_PUBLISH_LOG_VERSION)
    Future<PublishLogVersionResponse> publishLogVersion(PublishLogVersionRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "publish_log_version_batch",
            onceTalkTimeout = TIMEOUT_PUBLISH_LOG_VERSION_BATCH)
    Future<PublishLogVersionResponse> publishLogVersionBatch(PublishLogVersionBatchRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "lock_tablet_metadata", onceTalkTimeout = 5000)
    Future<LockTabletMetadataResponse> lockTabletMetadata(LockTabletMetadataRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "unlock_tablet_metadata", onceTalkTimeout = 5000)
    Future<UnlockTabletMetadataResponse> unlockTabletMetadata(UnlockTabletMetadataRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "upload_snapshots", onceTalkTimeout = 5000)
    Future<UploadSnapshotsResponse> uploadSnapshots(UploadSnapshotsRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "restore_snapshots", onceTalkTimeout = 5000)
    Future<RestoreSnapshotsResponse> restoreSnapshots(RestoreSnapshotsRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "abort_compaction", onceTalkTimeout = TIMEOUT_ABORT_COMPACTION)
    Future<AbortCompactionResponse> abortCompaction(AbortCompactionRequest request);

    @ProtobufRPC(serviceName = "LakeService", methodName = "vacuum", onceTalkTimeout = TIMEOUT_VACUUM)
    Future<VacuumResponse> vacuum(VacuumRequest request);
}

