// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_service.proto

package io.datafibre.fibre.proto;

public interface DropTableRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.lake.DropTableRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * tablet_id can be the id of any of the tablet belongs to the table to be dropped.
   * </pre>
   *
   * <code>optional int64 tablet_id = 1;</code>
   * @return Whether the tabletId field is set.
   */
  boolean hasTabletId();
  /**
   * <pre>
   * tablet_id can be the id of any of the tablet belongs to the table to be dropped.
   * </pre>
   *
   * <code>optional int64 tablet_id = 1;</code>
   * @return The tabletId.
   */
  long getTabletId();
}
