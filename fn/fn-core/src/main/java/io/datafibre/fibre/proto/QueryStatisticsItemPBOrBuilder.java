// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: data.proto

package com.starrocks.proto;

public interface QueryStatisticsItemPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.QueryStatisticsItemPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int64 scan_rows = 1;</code>
   * @return Whether the scanRows field is set.
   */
  boolean hasScanRows();
  /**
   * <code>optional int64 scan_rows = 1;</code>
   * @return The scanRows.
   */
  long getScanRows();

  /**
   * <code>optional int64 scan_bytes = 2;</code>
   * @return Whether the scanBytes field is set.
   */
  boolean hasScanBytes();
  /**
   * <code>optional int64 scan_bytes = 2;</code>
   * @return The scanBytes.
   */
  long getScanBytes();

  /**
   * <code>optional int64 table_id = 3;</code>
   * @return Whether the tableId field is set.
   */
  boolean hasTableId();
  /**
   * <code>optional int64 table_id = 3;</code>
   * @return The tableId.
   */
  long getTableId();
}
