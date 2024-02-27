// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package com.starrocks.proto;

public interface PProxyResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PProxyResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required .starrocks.StatusPB status = 1;</code>
   * @return Whether the status field is set.
   */
  boolean hasStatus();
  /**
   * <code>required .starrocks.StatusPB status = 1;</code>
   * @return The status.
   */
  com.starrocks.proto.StatusPB getStatus();
  /**
   * <code>required .starrocks.StatusPB status = 1;</code>
   */
  com.starrocks.proto.StatusPBOrBuilder getStatusOrBuilder();

  /**
   * <code>optional .starrocks.PKafkaMetaProxyResult kafka_meta_result = 2;</code>
   * @return Whether the kafkaMetaResult field is set.
   */
  boolean hasKafkaMetaResult();
  /**
   * <code>optional .starrocks.PKafkaMetaProxyResult kafka_meta_result = 2;</code>
   * @return The kafkaMetaResult.
   */
  com.starrocks.proto.PKafkaMetaProxyResult getKafkaMetaResult();
  /**
   * <code>optional .starrocks.PKafkaMetaProxyResult kafka_meta_result = 2;</code>
   */
  com.starrocks.proto.PKafkaMetaProxyResultOrBuilder getKafkaMetaResultOrBuilder();

  /**
   * <code>optional .starrocks.PKafkaOffsetProxyResult kafka_offset_result = 101;</code>
   * @return Whether the kafkaOffsetResult field is set.
   */
  boolean hasKafkaOffsetResult();
  /**
   * <code>optional .starrocks.PKafkaOffsetProxyResult kafka_offset_result = 101;</code>
   * @return The kafkaOffsetResult.
   */
  com.starrocks.proto.PKafkaOffsetProxyResult getKafkaOffsetResult();
  /**
   * <code>optional .starrocks.PKafkaOffsetProxyResult kafka_offset_result = 101;</code>
   */
  com.starrocks.proto.PKafkaOffsetProxyResultOrBuilder getKafkaOffsetResultOrBuilder();

  /**
   * <code>optional .starrocks.PKafkaOffsetBatchProxyResult kafka_offset_batch_result = 102;</code>
   * @return Whether the kafkaOffsetBatchResult field is set.
   */
  boolean hasKafkaOffsetBatchResult();
  /**
   * <code>optional .starrocks.PKafkaOffsetBatchProxyResult kafka_offset_batch_result = 102;</code>
   * @return The kafkaOffsetBatchResult.
   */
  com.starrocks.proto.PKafkaOffsetBatchProxyResult getKafkaOffsetBatchResult();
  /**
   * <code>optional .starrocks.PKafkaOffsetBatchProxyResult kafka_offset_batch_result = 102;</code>
   */
  com.starrocks.proto.PKafkaOffsetBatchProxyResultOrBuilder getKafkaOffsetBatchResultOrBuilder();
}
