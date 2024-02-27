// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package com.starrocks.proto;

public interface PTabletReaderMultiGetRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PTabletReaderMultiGetRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int64 tablet_id = 1;</code>
   * @return Whether the tabletId field is set.
   */
  boolean hasTabletId();
  /**
   * <code>optional int64 tablet_id = 1;</code>
   * @return The tabletId.
   */
  long getTabletId();

  /**
   * <code>optional int64 version = 2;</code>
   * @return Whether the version field is set.
   */
  boolean hasVersion();
  /**
   * <code>optional int64 version = 2;</code>
   * @return The version.
   */
  long getVersion();

  /**
   * <code>optional .starrocks.ChunkPB keys = 3;</code>
   * @return Whether the keys field is set.
   */
  boolean hasKeys();
  /**
   * <code>optional .starrocks.ChunkPB keys = 3;</code>
   * @return The keys.
   */
  com.starrocks.proto.ChunkPB getKeys();
  /**
   * <code>optional .starrocks.ChunkPB keys = 3;</code>
   */
  com.starrocks.proto.ChunkPBOrBuilder getKeysOrBuilder();

  /**
   * <code>repeated string values_columns = 4;</code>
   * @return A list containing the valuesColumns.
   */
  java.util.List<java.lang.String>
      getValuesColumnsList();
  /**
   * <code>repeated string values_columns = 4;</code>
   * @return The count of valuesColumns.
   */
  int getValuesColumnsCount();
  /**
   * <code>repeated string values_columns = 4;</code>
   * @param index The index of the element to return.
   * @return The valuesColumns at the given index.
   */
  java.lang.String getValuesColumns(int index);
  /**
   * <code>repeated string values_columns = 4;</code>
   * @param index The index of the value to return.
   * @return The bytes of the valuesColumns at the given index.
   */
  com.google.protobuf.ByteString
      getValuesColumnsBytes(int index);
}
