// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

public interface PTransmitDataParamsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PTransmitDataParams)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * non-change member
   * </pre>
   *
   * <code>required .starrocks.PUniqueId finst_id = 1;</code>
   * @return Whether the finstId field is set.
   */
  boolean hasFinstId();
  /**
   * <pre>
   * non-change member
   * </pre>
   *
   * <code>required .starrocks.PUniqueId finst_id = 1;</code>
   * @return The finstId.
   */
  io.datafibre.fibre.proto.PUniqueId getFinstId();
  /**
   * <pre>
   * non-change member
   * </pre>
   *
   * <code>required .starrocks.PUniqueId finst_id = 1;</code>
   */
  io.datafibre.fibre.proto.PUniqueIdOrBuilder getFinstIdOrBuilder();

  /**
   * <code>required int32 node_id = 2;</code>
   * @return Whether the nodeId field is set.
   */
  boolean hasNodeId();
  /**
   * <code>required int32 node_id = 2;</code>
   * @return The nodeId.
   */
  int getNodeId();

  /**
   * <pre>
   * Id of this fragment in its role as a sender.
   * </pre>
   *
   * <code>required int32 sender_id = 3;</code>
   * @return Whether the senderId field is set.
   */
  boolean hasSenderId();
  /**
   * <pre>
   * Id of this fragment in its role as a sender.
   * </pre>
   *
   * <code>required int32 sender_id = 3;</code>
   * @return The senderId.
   */
  int getSenderId();

  /**
   * <code>required int32 be_number = 4;</code>
   * @return Whether the beNumber field is set.
   */
  boolean hasBeNumber();
  /**
   * <code>required int32 be_number = 4;</code>
   * @return The beNumber.
   */
  int getBeNumber();

  /**
   * <pre>
   * If set to true, indicates that no more row batches will be sent
   * for this dest_node_id.
   * </pre>
   *
   * <code>required bool eos = 5;</code>
   * @return Whether the eos field is set.
   */
  boolean hasEos();
  /**
   * <pre>
   * If set to true, indicates that no more row batches will be sent
   * for this dest_node_id.
   * </pre>
   *
   * <code>required bool eos = 5;</code>
   * @return The eos.
   */
  boolean getEos();

  /**
   * <code>optional .starrocks.PRowBatch row_batch = 6;</code>
   * @return Whether the rowBatch field is set.
   */
  boolean hasRowBatch();
  /**
   * <code>optional .starrocks.PRowBatch row_batch = 6;</code>
   * @return The rowBatch.
   */
  io.datafibre.fibre.proto.PRowBatch getRowBatch();
  /**
   * <code>optional .starrocks.PRowBatch row_batch = 6;</code>
   */
  io.datafibre.fibre.proto.PRowBatchOrBuilder getRowBatchOrBuilder();

  /**
   * <pre>
   * Different per packet.
   * </pre>
   *
   * <code>required int64 packet_seq = 7;</code>
   * @return Whether the packetSeq field is set.
   */
  boolean hasPacketSeq();
  /**
   * <pre>
   * Different per packet.
   * </pre>
   *
   * <code>required int64 packet_seq = 7;</code>
   * @return The packetSeq.
   */
  long getPacketSeq();

  /**
   * <code>optional .starrocks.PQueryStatistics query_statistics = 8;</code>
   * @return Whether the queryStatistics field is set.
   */
  boolean hasQueryStatistics();
  /**
   * <code>optional .starrocks.PQueryStatistics query_statistics = 8;</code>
   * @return The queryStatistics.
   */
  io.datafibre.fibre.proto.PQueryStatistics getQueryStatistics();
  /**
   * <code>optional .starrocks.PQueryStatistics query_statistics = 8;</code>
   */
  io.datafibre.fibre.proto.PQueryStatisticsOrBuilder getQueryStatisticsOrBuilder();
}