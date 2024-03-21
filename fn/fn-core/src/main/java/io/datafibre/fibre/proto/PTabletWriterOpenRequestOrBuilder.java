// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

public interface PTabletWriterOpenRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PTabletWriterOpenRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required .starrocks.PUniqueId id = 1;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <code>required .starrocks.PUniqueId id = 1;</code>
   * @return The id.
   */
  io.datafibre.fibre.proto.PUniqueId getId();
  /**
   * <code>required .starrocks.PUniqueId id = 1;</code>
   */
  io.datafibre.fibre.proto.PUniqueIdOrBuilder getIdOrBuilder();

  /**
   * <code>required int64 index_id = 2;</code>
   * @return Whether the indexId field is set.
   */
  boolean hasIndexId();
  /**
   * <code>required int64 index_id = 2;</code>
   * @return The indexId.
   */
  long getIndexId();

  /**
   * <code>required int64 txn_id = 3;</code>
   * @return Whether the txnId field is set.
   */
  boolean hasTxnId();
  /**
   * <code>required int64 txn_id = 3;</code>
   * @return The txnId.
   */
  long getTxnId();

  /**
   * <code>required .starrocks.POlapTableSchemaParam schema = 4;</code>
   * @return Whether the schema field is set.
   */
  boolean hasSchema();
  /**
   * <code>required .starrocks.POlapTableSchemaParam schema = 4;</code>
   * @return The schema.
   */
  io.datafibre.fibre.proto.POlapTableSchemaParam getSchema();
  /**
   * <code>required .starrocks.POlapTableSchemaParam schema = 4;</code>
   */
  io.datafibre.fibre.proto.POlapTableSchemaParamOrBuilder getSchemaOrBuilder();

  /**
   * <code>repeated .starrocks.PTabletWithPartition tablets = 5;</code>
   */
  java.util.List<io.datafibre.fibre.proto.PTabletWithPartition>
      getTabletsList();
  /**
   * <code>repeated .starrocks.PTabletWithPartition tablets = 5;</code>
   */
  io.datafibre.fibre.proto.PTabletWithPartition getTablets(int index);
  /**
   * <code>repeated .starrocks.PTabletWithPartition tablets = 5;</code>
   */
  int getTabletsCount();
  /**
   * <code>repeated .starrocks.PTabletWithPartition tablets = 5;</code>
   */
  java.util.List<? extends io.datafibre.fibre.proto.PTabletWithPartitionOrBuilder>
      getTabletsOrBuilderList();
  /**
   * <code>repeated .starrocks.PTabletWithPartition tablets = 5;</code>
   */
  io.datafibre.fibre.proto.PTabletWithPartitionOrBuilder getTabletsOrBuilder(
      int index);

  /**
   * <code>required int32 num_senders = 6;</code>
   * @return Whether the numSenders field is set.
   */
  boolean hasNumSenders();
  /**
   * <code>required int32 num_senders = 6;</code>
   * @return The numSenders.
   */
  int getNumSenders();

  /**
   * <pre>
   * Deprecated
   * </pre>
   *
   * <code>required bool need_gen_rollup = 7;</code>
   * @return Whether the needGenRollup field is set.
   */
  boolean hasNeedGenRollup();
  /**
   * <pre>
   * Deprecated
   * </pre>
   *
   * <code>required bool need_gen_rollup = 7;</code>
   * @return The needGenRollup.
   */
  boolean getNeedGenRollup();

  /**
   * <code>optional int64 load_mem_limit = 8;</code>
   * @return Whether the loadMemLimit field is set.
   */
  boolean hasLoadMemLimit();
  /**
   * <code>optional int64 load_mem_limit = 8;</code>
   * @return The loadMemLimit.
   */
  long getLoadMemLimit();

  /**
   * <code>optional int64 load_channel_timeout_s = 9;</code>
   * @return Whether the loadChannelTimeoutS field is set.
   */
  boolean hasLoadChannelTimeoutS();
  /**
   * <code>optional int64 load_channel_timeout_s = 9;</code>
   * @return The loadChannelTimeoutS.
   */
  long getLoadChannelTimeoutS();

  /**
   * <code>optional int64 node_id = 10;</code>
   * @return Whether the nodeId field is set.
   */
  boolean hasNodeId();
  /**
   * <code>optional int64 node_id = 10;</code>
   * @return The nodeId.
   */
  long getNodeId();

  /**
   * <pre>
   * Deprecate if we confirm all customer have upgrade to 2.1
   * </pre>
   *
   * <code>optional bool is_vectorized = 20;</code>
   * @return Whether the isVectorized field is set.
   */
  boolean hasIsVectorized();
  /**
   * <pre>
   * Deprecate if we confirm all customer have upgrade to 2.1
   * </pre>
   *
   * <code>optional bool is_vectorized = 20;</code>
   * @return The isVectorized.
   */
  boolean getIsVectorized();

  /**
   * <code>optional bool is_lake_tablet = 21;</code>
   * @return Whether the isLakeTablet field is set.
   */
  boolean hasIsLakeTablet();
  /**
   * <code>optional bool is_lake_tablet = 21;</code>
   * @return The isLakeTablet.
   */
  boolean getIsLakeTablet();

  /**
   * <code>optional string txn_trace_parent = 22;</code>
   * @return Whether the txnTraceParent field is set.
   */
  boolean hasTxnTraceParent();
  /**
   * <code>optional string txn_trace_parent = 22;</code>
   * @return The txnTraceParent.
   */
  java.lang.String getTxnTraceParent();
  /**
   * <code>optional string txn_trace_parent = 22;</code>
   * @return The bytes for txnTraceParent.
   */
  com.google.protobuf.ByteString
      getTxnTraceParentBytes();

  /**
   * <code>optional bool is_replicated_storage = 23;</code>
   * @return Whether the isReplicatedStorage field is set.
   */
  boolean hasIsReplicatedStorage();
  /**
   * <code>optional bool is_replicated_storage = 23;</code>
   * @return The isReplicatedStorage.
   */
  boolean getIsReplicatedStorage();

  /**
   * <code>optional int64 timeout_ms = 24;</code>
   * @return Whether the timeoutMs field is set.
   */
  boolean hasTimeoutMs();
  /**
   * <code>optional int64 timeout_ms = 24;</code>
   * @return The timeoutMs.
   */
  long getTimeoutMs();

  /**
   * <code>optional .starrocks.WriteQuorumTypePB write_quorum = 25;</code>
   * @return Whether the writeQuorum field is set.
   */
  boolean hasWriteQuorum();
  /**
   * <code>optional .starrocks.WriteQuorumTypePB write_quorum = 25;</code>
   * @return The writeQuorum.
   */
  io.datafibre.fibre.proto.WriteQuorumTypePB getWriteQuorum();

  /**
   * <code>optional string merge_condition = 26;</code>
   * @return Whether the mergeCondition field is set.
   */
  boolean hasMergeCondition();
  /**
   * <code>optional string merge_condition = 26;</code>
   * @return The mergeCondition.
   */
  java.lang.String getMergeCondition();
  /**
   * <code>optional string merge_condition = 26;</code>
   * @return The bytes for mergeCondition.
   */
  com.google.protobuf.ByteString
      getMergeConditionBytes();

  /**
   * <code>optional bool miss_auto_increment_column = 27;</code>
   * @return Whether the missAutoIncrementColumn field is set.
   */
  boolean hasMissAutoIncrementColumn();
  /**
   * <code>optional bool miss_auto_increment_column = 27;</code>
   * @return The missAutoIncrementColumn.
   */
  boolean getMissAutoIncrementColumn();

  /**
   * <pre>
   * Deprecated
   * </pre>
   *
   * <code>optional bool abort_delete = 28;</code>
   * @return Whether the abortDelete field is set.
   */
  boolean hasAbortDelete();
  /**
   * <pre>
   * Deprecated
   * </pre>
   *
   * <code>optional bool abort_delete = 28;</code>
   * @return The abortDelete.
   */
  boolean getAbortDelete();

  /**
   * <pre>
   * before data load, the all current partitions will be opened
   * When the data load in progress, the partition created by automatic partition needs incremental open
   * </pre>
   *
   * <code>optional bool is_incremental = 29 [default = false];</code>
   * @return Whether the isIncremental field is set.
   */
  boolean hasIsIncremental();
  /**
   * <pre>
   * before data load, the all current partitions will be opened
   * When the data load in progress, the partition created by automatic partition needs incremental open
   * </pre>
   *
   * <code>optional bool is_incremental = 29 [default = false];</code>
   * @return The isIncremental.
   */
  boolean getIsIncremental();

  /**
   * <code>optional int32 sender_id = 30;</code>
   * @return Whether the senderId field is set.
   */
  boolean hasSenderId();
  /**
   * <code>optional int32 sender_id = 30;</code>
   * @return The senderId.
   */
  int getSenderId();

  /**
   * <code>optional .starrocks.PartialUpdateMode partial_update_mode = 31;</code>
   * @return Whether the partialUpdateMode field is set.
   */
  boolean hasPartialUpdateMode();
  /**
   * <code>optional .starrocks.PartialUpdateMode partial_update_mode = 31;</code>
   * @return The partialUpdateMode.
   */
  io.datafibre.fibre.proto.PartialUpdateMode getPartialUpdateMode();

  /**
   * <code>optional int64 table_id = 32;</code>
   * @return Whether the tableId field is set.
   */
  boolean hasTableId();
  /**
   * <code>optional int64 table_id = 32;</code>
   * @return The tableId.
   */
  long getTableId();

  /**
   * <pre>
   * tablet's data size larger than this will mark as inmutable
   * </pre>
   *
   * <code>optional int64 immutable_tablet_size = 33 [default = 0];</code>
   * @return Whether the immutableTabletSize field is set.
   */
  boolean hasImmutableTabletSize();
  /**
   * <pre>
   * tablet's data size larger than this will mark as inmutable
   * </pre>
   *
   * <code>optional int64 immutable_tablet_size = 33 [default = 0];</code>
   * @return The immutableTabletSize.
   */
  long getImmutableTabletSize();
}