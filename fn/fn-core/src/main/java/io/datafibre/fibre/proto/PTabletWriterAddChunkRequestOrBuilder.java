// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

public interface PTabletWriterAddChunkRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PTabletWriterAddChunkRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .starrocks.PUniqueId id = 1;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <code>optional .starrocks.PUniqueId id = 1;</code>
   * @return The id.
   */
  io.datafibre.fibre.proto.PUniqueId getId();
  /**
   * <code>optional .starrocks.PUniqueId id = 1;</code>
   */
  io.datafibre.fibre.proto.PUniqueIdOrBuilder getIdOrBuilder();

  /**
   * <code>optional int64 index_id = 2;</code>
   * @return Whether the indexId field is set.
   */
  boolean hasIndexId();
  /**
   * <code>optional int64 index_id = 2;</code>
   * @return The indexId.
   */
  long getIndexId();

  /**
   * <code>optional int32 sender_id = 3;</code>
   * @return Whether the senderId field is set.
   */
  boolean hasSenderId();
  /**
   * <code>optional int32 sender_id = 3;</code>
   * @return The senderId.
   */
  int getSenderId();

  /**
   * <pre>
   * Whether this is the last batch from this sender.
   * </pre>
   *
   * <code>optional bool eos = 4;</code>
   * @return Whether the eos field is set.
   */
  boolean hasEos();
  /**
   * <pre>
   * Whether this is the last batch from this sender.
   * </pre>
   *
   * <code>optional bool eos = 4;</code>
   * @return The eos.
   */
  boolean getEos();

  /**
   * <code>optional int64 packet_seq = 5;</code>
   * @return Whether the packetSeq field is set.
   */
  boolean hasPacketSeq();
  /**
   * <code>optional int64 packet_seq = 5;</code>
   * @return The packetSeq.
   */
  long getPacketSeq();

  /**
   * <code>repeated int64 tablet_ids = 6;</code>
   * @return A list containing the tabletIds.
   */
  java.util.List<java.lang.Long> getTabletIdsList();
  /**
   * <code>repeated int64 tablet_ids = 6;</code>
   * @return The count of tabletIds.
   */
  int getTabletIdsCount();
  /**
   * <code>repeated int64 tablet_ids = 6;</code>
   * @param index The index of the element to return.
   * @return The tabletIds at the given index.
   */
  long getTabletIds(int index);

  /**
   * <pre>
   * Unset if and only if eos is true.
   * </pre>
   *
   * <code>optional .starrocks.ChunkPB chunk = 7;</code>
   * @return Whether the chunk field is set.
   */
  boolean hasChunk();
  /**
   * <pre>
   * Unset if and only if eos is true.
   * </pre>
   *
   * <code>optional .starrocks.ChunkPB chunk = 7;</code>
   * @return The chunk.
   */
  io.datafibre.fibre.proto.ChunkPB getChunk();
  /**
   * <pre>
   * Unset if and only if eos is true.
   * </pre>
   *
   * <code>optional .starrocks.ChunkPB chunk = 7;</code>
   */
  io.datafibre.fibre.proto.ChunkPBOrBuilder getChunkOrBuilder();

  /**
   * <pre>
   * only valid when eos is true
   * valid partition ids that would write in this writer
   * </pre>
   *
   * <code>repeated int64 partition_ids = 8;</code>
   * @return A list containing the partitionIds.
   */
  java.util.List<java.lang.Long> getPartitionIdsList();
  /**
   * <pre>
   * only valid when eos is true
   * valid partition ids that would write in this writer
   * </pre>
   *
   * <code>repeated int64 partition_ids = 8;</code>
   * @return The count of partitionIds.
   */
  int getPartitionIdsCount();
  /**
   * <pre>
   * only valid when eos is true
   * valid partition ids that would write in this writer
   * </pre>
   *
   * <code>repeated int64 partition_ids = 8;</code>
   * @param index The index of the element to return.
   * @return The partitionIds at the given index.
   */
  long getPartitionIds(int index);

  /**
   * <code>optional int64 txn_id = 9;</code>
   * @return Whether the txnId field is set.
   */
  boolean hasTxnId();
  /**
   * <code>optional int64 txn_id = 9;</code>
   * @return The txnId.
   */
  long getTxnId();

  /**
   * <code>optional int64 timeout_ms = 10;</code>
   * @return Whether the timeoutMs field is set.
   */
  boolean hasTimeoutMs();
  /**
   * <code>optional int64 timeout_ms = 10;</code>
   * @return The timeoutMs.
   */
  long getTimeoutMs();

  /**
   * <pre>
   * wait all sender close before rpc returning
   * this is used for automatic partition creation
   * </pre>
   *
   * <code>optional bool wait_all_sender_close = 11 [default = false];</code>
   * @return Whether the waitAllSenderClose field is set.
   */
  boolean hasWaitAllSenderClose();
  /**
   * <pre>
   * wait all sender close before rpc returning
   * this is used for automatic partition creation
   * </pre>
   *
   * <code>optional bool wait_all_sender_close = 11 [default = false];</code>
   * @return The waitAllSenderClose.
   */
  boolean getWaitAllSenderClose();
}
