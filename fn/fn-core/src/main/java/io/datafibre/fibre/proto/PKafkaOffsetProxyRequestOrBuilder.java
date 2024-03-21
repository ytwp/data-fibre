// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

public interface PKafkaOffsetProxyRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PKafkaOffsetProxyRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .starrocks.PKafkaLoadInfo kafka_info = 1;</code>
   * @return Whether the kafkaInfo field is set.
   */
  boolean hasKafkaInfo();
  /**
   * <code>optional .starrocks.PKafkaLoadInfo kafka_info = 1;</code>
   * @return The kafkaInfo.
   */
  io.datafibre.fibre.proto.PKafkaLoadInfo getKafkaInfo();
  /**
   * <code>optional .starrocks.PKafkaLoadInfo kafka_info = 1;</code>
   */
  io.datafibre.fibre.proto.PKafkaLoadInfoOrBuilder getKafkaInfoOrBuilder();

  /**
   * <code>repeated int32 partition_ids = 2;</code>
   * @return A list containing the partitionIds.
   */
  java.util.List<java.lang.Integer> getPartitionIdsList();
  /**
   * <code>repeated int32 partition_ids = 2;</code>
   * @return The count of partitionIds.
   */
  int getPartitionIdsCount();
  /**
   * <code>repeated int32 partition_ids = 2;</code>
   * @param index The index of the element to return.
   * @return The partitionIds at the given index.
   */
  int getPartitionIds(int index);
}