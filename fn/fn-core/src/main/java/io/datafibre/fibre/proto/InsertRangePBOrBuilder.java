// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: binlog.proto

package com.starrocks.proto;

public interface InsertRangePBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.InsertRangePB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .starrocks.FileIdPB file_id = 1;</code>
   * @return Whether the fileId field is set.
   */
  boolean hasFileId();
  /**
   * <code>optional .starrocks.FileIdPB file_id = 1;</code>
   * @return The fileId.
   */
  com.starrocks.proto.FileIdPB getFileId();
  /**
   * <code>optional .starrocks.FileIdPB file_id = 1;</code>
   */
  com.starrocks.proto.FileIdPBOrBuilder getFileIdOrBuilder();

  /**
   * <code>optional int32 start_row_id = 2;</code>
   * @return Whether the startRowId field is set.
   */
  boolean hasStartRowId();
  /**
   * <code>optional int32 start_row_id = 2;</code>
   * @return The startRowId.
   */
  int getStartRowId();

  /**
   * <code>optional int32 num_rows = 3;</code>
   * @return Whether the numRows field is set.
   */
  boolean hasNumRows();
  /**
   * <code>optional int32 num_rows = 3;</code>
   * @return The numRows.
   */
  int getNumRows();
}
