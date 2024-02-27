// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package com.starrocks.proto;

public interface PTabletWriterOpenResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PTabletWriterOpenResult)
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
   * <code>optional bool is_repeated_chunk = 2 [default = false];</code>
   * @return Whether the isRepeatedChunk field is set.
   */
  boolean hasIsRepeatedChunk();
  /**
   * <code>optional bool is_repeated_chunk = 2 [default = false];</code>
   * @return The isRepeatedChunk.
   */
  boolean getIsRepeatedChunk();

  /**
   * <code>repeated int64 immutable_tablet_ids = 3;</code>
   * @return A list containing the immutableTabletIds.
   */
  java.util.List<java.lang.Long> getImmutableTabletIdsList();
  /**
   * <code>repeated int64 immutable_tablet_ids = 3;</code>
   * @return The count of immutableTabletIds.
   */
  int getImmutableTabletIdsCount();
  /**
   * <code>repeated int64 immutable_tablet_ids = 3;</code>
   * @param index The index of the element to return.
   * @return The immutableTabletIds at the given index.
   */
  long getImmutableTabletIds(int index);

  /**
   * <code>repeated int64 immutable_partition_ids = 4;</code>
   * @return A list containing the immutablePartitionIds.
   */
  java.util.List<java.lang.Long> getImmutablePartitionIdsList();
  /**
   * <code>repeated int64 immutable_partition_ids = 4;</code>
   * @return The count of immutablePartitionIds.
   */
  int getImmutablePartitionIdsCount();
  /**
   * <code>repeated int64 immutable_partition_ids = 4;</code>
   * @param index The index of the element to return.
   * @return The immutablePartitionIds at the given index.
   */
  long getImmutablePartitionIds(int index);
}
