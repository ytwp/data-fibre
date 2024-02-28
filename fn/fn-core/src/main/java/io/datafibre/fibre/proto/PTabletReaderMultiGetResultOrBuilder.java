// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

public interface PTabletReaderMultiGetResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PTabletReaderMultiGetResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   * @return Whether the status field is set.
   */
  boolean hasStatus();
  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   * @return The status.
   */
  io.datafibre.fibre.proto.StatusPB getStatus();
  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   */
  io.datafibre.fibre.proto.StatusPBOrBuilder getStatusOrBuilder();

  /**
   * <code>repeated bool found = 2;</code>
   * @return A list containing the found.
   */
  java.util.List<java.lang.Boolean> getFoundList();
  /**
   * <code>repeated bool found = 2;</code>
   * @return The count of found.
   */
  int getFoundCount();
  /**
   * <code>repeated bool found = 2;</code>
   * @param index The index of the element to return.
   * @return The found at the given index.
   */
  boolean getFound(int index);

  /**
   * <code>optional .starrocks.ChunkPB values = 3;</code>
   * @return Whether the values field is set.
   */
  boolean hasValues();
  /**
   * <code>optional .starrocks.ChunkPB values = 3;</code>
   * @return The values.
   */
  io.datafibre.fibre.proto.ChunkPB getValues();
  /**
   * <code>optional .starrocks.ChunkPB values = 3;</code>
   */
  io.datafibre.fibre.proto.ChunkPBOrBuilder getValuesOrBuilder();
}
