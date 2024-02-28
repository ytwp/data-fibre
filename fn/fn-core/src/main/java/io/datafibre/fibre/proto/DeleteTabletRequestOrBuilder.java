// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_service.proto

package io.datafibre.fibre.proto;

public interface DeleteTabletRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.lake.DeleteTabletRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * All tablets must be in the same partition.
   * </pre>
   *
   * <code>repeated int64 tablet_ids = 1;</code>
   * @return A list containing the tabletIds.
   */
  java.util.List<java.lang.Long> getTabletIdsList();
  /**
   * <pre>
   * All tablets must be in the same partition.
   * </pre>
   *
   * <code>repeated int64 tablet_ids = 1;</code>
   * @return The count of tabletIds.
   */
  int getTabletIdsCount();
  /**
   * <pre>
   * All tablets must be in the same partition.
   * </pre>
   *
   * <code>repeated int64 tablet_ids = 1;</code>
   * @param index The index of the element to return.
   * @return The tabletIds at the given index.
   */
  long getTabletIds(int index);
}
