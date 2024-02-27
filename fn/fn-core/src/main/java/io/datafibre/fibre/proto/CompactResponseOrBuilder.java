// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_service.proto

package com.starrocks.proto;

public interface CompactResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.lake.CompactResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated int64 failed_tablets = 1;</code>
   * @return A list containing the failedTablets.
   */
  java.util.List<java.lang.Long> getFailedTabletsList();
  /**
   * <code>repeated int64 failed_tablets = 1;</code>
   * @return The count of failedTablets.
   */
  int getFailedTabletsCount();
  /**
   * <code>repeated int64 failed_tablets = 1;</code>
   * @param index The index of the element to return.
   * @return The failedTablets at the given index.
   */
  long getFailedTablets(int index);

  /**
   * <pre>
   * optional int64 execution_time = 2; // ms
   * optional int64 num_input_bytes = 3;
   * optional int64 num_input_rows = 4;
   * optional int64 num_output_bytes = 5;
   * optional int64 num_output_rows = 6;
   * </pre>
   *
   * <code>optional .starrocks.StatusPB status = 7;</code>
   * @return Whether the status field is set.
   */
  boolean hasStatus();
  /**
   * <pre>
   * optional int64 execution_time = 2; // ms
   * optional int64 num_input_bytes = 3;
   * optional int64 num_input_rows = 4;
   * optional int64 num_output_bytes = 5;
   * optional int64 num_output_rows = 6;
   * </pre>
   *
   * <code>optional .starrocks.StatusPB status = 7;</code>
   * @return The status.
   */
  com.starrocks.proto.StatusPB getStatus();
  /**
   * <pre>
   * optional int64 execution_time = 2; // ms
   * optional int64 num_input_bytes = 3;
   * optional int64 num_input_rows = 4;
   * optional int64 num_output_bytes = 5;
   * optional int64 num_output_rows = 6;
   * </pre>
   *
   * <code>optional .starrocks.StatusPB status = 7;</code>
   */
  com.starrocks.proto.StatusPBOrBuilder getStatusOrBuilder();
}
