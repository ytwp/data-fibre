// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package com.starrocks.proto;

public interface PTransmitChunkParamsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PTransmitChunkParams)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * non-change member
   * </pre>
   *
   * <code>optional .starrocks.PUniqueId finst_id = 1;</code>
   * @return Whether the finstId field is set.
   */
  boolean hasFinstId();
  /**
   * <pre>
   * non-change member
   * </pre>
   *
   * <code>optional .starrocks.PUniqueId finst_id = 1;</code>
   * @return The finstId.
   */
  com.starrocks.proto.PUniqueId getFinstId();
  /**
   * <pre>
   * non-change member
   * </pre>
   *
   * <code>optional .starrocks.PUniqueId finst_id = 1;</code>
   */
  com.starrocks.proto.PUniqueIdOrBuilder getFinstIdOrBuilder();

  /**
   * <code>optional int32 node_id = 2;</code>
   * @return Whether the nodeId field is set.
   */
  boolean hasNodeId();
  /**
   * <code>optional int32 node_id = 2;</code>
   * @return The nodeId.
   */
  int getNodeId();

  /**
   * <pre>
   * Id of this fragment in its role as a sender.
   * </pre>
   *
   * <code>optional int32 sender_id = 3;</code>
   * @return Whether the senderId field is set.
   */
  boolean hasSenderId();
  /**
   * <pre>
   * Id of this fragment in its role as a sender.
   * </pre>
   *
   * <code>optional int32 sender_id = 3;</code>
   * @return The senderId.
   */
  int getSenderId();

  /**
   * <code>optional int32 be_number = 4;</code>
   * @return Whether the beNumber field is set.
   */
  boolean hasBeNumber();
  /**
   * <code>optional int32 be_number = 4;</code>
   * @return The beNumber.
   */
  int getBeNumber();

  /**
   * <pre>
   * If set to true, indicates that no more row batches will be sent
   * for this dest_node_id.
   * </pre>
   *
   * <code>optional bool eos = 5;</code>
   * @return Whether the eos field is set.
   */
  boolean hasEos();
  /**
   * <pre>
   * If set to true, indicates that no more row batches will be sent
   * for this dest_node_id.
   * </pre>
   *
   * <code>optional bool eos = 5;</code>
   * @return The eos.
   */
  boolean getEos();

  /**
   * <pre>
   * RPC sequence number for the send channel.
   * Sever will check this number to see if some packet has lost.
   * </pre>
   *
   * <code>optional int64 sequence = 6;</code>
   * @return Whether the sequence field is set.
   */
  boolean hasSequence();
  /**
   * <pre>
   * RPC sequence number for the send channel.
   * Sever will check this number to see if some packet has lost.
   * </pre>
   *
   * <code>optional int64 sequence = 6;</code>
   * @return The sequence.
   */
  long getSequence();

  /**
   * <pre>
   * The protobuf data structure for column chunk.
   * </pre>
   *
   * <code>repeated .starrocks.ChunkPB chunks = 7;</code>
   */
  java.util.List<com.starrocks.proto.ChunkPB> 
      getChunksList();
  /**
   * <pre>
   * The protobuf data structure for column chunk.
   * </pre>
   *
   * <code>repeated .starrocks.ChunkPB chunks = 7;</code>
   */
  com.starrocks.proto.ChunkPB getChunks(int index);
  /**
   * <pre>
   * The protobuf data structure for column chunk.
   * </pre>
   *
   * <code>repeated .starrocks.ChunkPB chunks = 7;</code>
   */
  int getChunksCount();
  /**
   * <pre>
   * The protobuf data structure for column chunk.
   * </pre>
   *
   * <code>repeated .starrocks.ChunkPB chunks = 7;</code>
   */
  java.util.List<? extends com.starrocks.proto.ChunkPBOrBuilder> 
      getChunksOrBuilderList();
  /**
   * <pre>
   * The protobuf data structure for column chunk.
   * </pre>
   *
   * <code>repeated .starrocks.ChunkPB chunks = 7;</code>
   */
  com.starrocks.proto.ChunkPBOrBuilder getChunksOrBuilder(
      int index);

  /**
   * <pre>
   * Some statistics for the runing query.
   * </pre>
   *
   * <code>optional .starrocks.PQueryStatistics query_statistics = 8;</code>
   * @return Whether the queryStatistics field is set.
   */
  boolean hasQueryStatistics();
  /**
   * <pre>
   * Some statistics for the runing query.
   * </pre>
   *
   * <code>optional .starrocks.PQueryStatistics query_statistics = 8;</code>
   * @return The queryStatistics.
   */
  com.starrocks.proto.PQueryStatistics getQueryStatistics();
  /**
   * <pre>
   * Some statistics for the runing query.
   * </pre>
   *
   * <code>optional .starrocks.PQueryStatistics query_statistics = 8;</code>
   */
  com.starrocks.proto.PQueryStatisticsOrBuilder getQueryStatisticsOrBuilder();

  /**
   * <code>optional bool use_pass_through = 9 [default = false];</code>
   * @return Whether the usePassThrough field is set.
   */
  boolean hasUsePassThrough();
  /**
   * <code>optional bool use_pass_through = 9 [default = false];</code>
   * @return The usePassThrough.
   */
  boolean getUsePassThrough();

  /**
   * <pre>
   * Whether enable pipeline level shuffle.
   * </pre>
   *
   * <code>optional bool is_pipeline_level_shuffle = 10 [default = false];</code>
   * @return Whether the isPipelineLevelShuffle field is set.
   */
  boolean hasIsPipelineLevelShuffle();
  /**
   * <pre>
   * Whether enable pipeline level shuffle.
   * </pre>
   *
   * <code>optional bool is_pipeline_level_shuffle = 10 [default = false];</code>
   * @return The isPipelineLevelShuffle.
   */
  boolean getIsPipelineLevelShuffle();

  /**
   * <pre>
   * Driver sequences of pipeline level shuffle.
   * </pre>
   *
   * <code>repeated int32 driver_sequences = 11;</code>
   * @return A list containing the driverSequences.
   */
  java.util.List<java.lang.Integer> getDriverSequencesList();
  /**
   * <pre>
   * Driver sequences of pipeline level shuffle.
   * </pre>
   *
   * <code>repeated int32 driver_sequences = 11;</code>
   * @return The count of driverSequences.
   */
  int getDriverSequencesCount();
  /**
   * <pre>
   * Driver sequences of pipeline level shuffle.
   * </pre>
   *
   * <code>repeated int32 driver_sequences = 11;</code>
   * @param index The index of the element to return.
   * @return The driverSequences at the given index.
   */
  int getDriverSequences(int index);
}
