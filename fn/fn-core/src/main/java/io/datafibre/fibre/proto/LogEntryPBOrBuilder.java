// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: binlog.proto

package com.starrocks.proto;

public interface LogEntryPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.LogEntryPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .starrocks.LogEntryTypePB entry_type = 1;</code>
   * @return Whether the entryType field is set.
   */
  boolean hasEntryType();
  /**
   * <code>optional .starrocks.LogEntryTypePB entry_type = 1;</code>
   * @return The entryType.
   */
  com.starrocks.proto.LogEntryTypePB getEntryType();

  /**
   * <code>optional .starrocks.InsertRangePB insert_range_data = 2;</code>
   * @return Whether the insertRangeData field is set.
   */
  boolean hasInsertRangeData();
  /**
   * <code>optional .starrocks.InsertRangePB insert_range_data = 2;</code>
   * @return The insertRangeData.
   */
  com.starrocks.proto.InsertRangePB getInsertRangeData();
  /**
   * <code>optional .starrocks.InsertRangePB insert_range_data = 2;</code>
   */
  com.starrocks.proto.InsertRangePBOrBuilder getInsertRangeDataOrBuilder();

  /**
   * <code>optional .starrocks.UpdatePB update_data = 3;</code>
   * @return Whether the updateData field is set.
   */
  boolean hasUpdateData();
  /**
   * <code>optional .starrocks.UpdatePB update_data = 3;</code>
   * @return The updateData.
   */
  com.starrocks.proto.UpdatePB getUpdateData();
  /**
   * <code>optional .starrocks.UpdatePB update_data = 3;</code>
   */
  com.starrocks.proto.UpdatePBOrBuilder getUpdateDataOrBuilder();

  /**
   * <code>optional .starrocks.DeletePB delete_data = 4;</code>
   * @return Whether the deleteData field is set.
   */
  boolean hasDeleteData();
  /**
   * <code>optional .starrocks.DeletePB delete_data = 4;</code>
   * @return The deleteData.
   */
  com.starrocks.proto.DeletePB getDeleteData();
  /**
   * <code>optional .starrocks.DeletePB delete_data = 4;</code>
   */
  com.starrocks.proto.DeletePBOrBuilder getDeleteDataOrBuilder();
}
