// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

public interface PPulsarMetaProxyResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PPulsarMetaProxyResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated string partitions = 1;</code>
   * @return A list containing the partitions.
   */
  java.util.List<java.lang.String>
      getPartitionsList();
  /**
   * <code>repeated string partitions = 1;</code>
   * @return The count of partitions.
   */
  int getPartitionsCount();
  /**
   * <code>repeated string partitions = 1;</code>
   * @param index The index of the element to return.
   * @return The partitions at the given index.
   */
  java.lang.String getPartitions(int index);
  /**
   * <code>repeated string partitions = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the partitions at the given index.
   */
  com.google.protobuf.ByteString
      getPartitionsBytes(int index);
}