// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_common.proto

package com.starrocks.proto;

public interface DeltaColumnGroupSnapshotPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.DeltaColumnGroupSnapshotPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated int64 tablet_id = 1;</code>
   * @return A list containing the tabletId.
   */
  java.util.List<java.lang.Long> getTabletIdList();
  /**
   * <code>repeated int64 tablet_id = 1;</code>
   * @return The count of tabletId.
   */
  int getTabletIdCount();
  /**
   * <code>repeated int64 tablet_id = 1;</code>
   * @param index The index of the element to return.
   * @return The tabletId at the given index.
   */
  long getTabletId(int index);

  /**
   * <code>repeated string rowset_id = 2;</code>
   * @return A list containing the rowsetId.
   */
  java.util.List<java.lang.String>
      getRowsetIdList();
  /**
   * <code>repeated string rowset_id = 2;</code>
   * @return The count of rowsetId.
   */
  int getRowsetIdCount();
  /**
   * <code>repeated string rowset_id = 2;</code>
   * @param index The index of the element to return.
   * @return The rowsetId at the given index.
   */
  java.lang.String getRowsetId(int index);
  /**
   * <code>repeated string rowset_id = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the rowsetId at the given index.
   */
  com.google.protobuf.ByteString
      getRowsetIdBytes(int index);

  /**
   * <code>repeated uint32 segment_id = 3;</code>
   * @return A list containing the segmentId.
   */
  java.util.List<java.lang.Integer> getSegmentIdList();
  /**
   * <code>repeated uint32 segment_id = 3;</code>
   * @return The count of segmentId.
   */
  int getSegmentIdCount();
  /**
   * <code>repeated uint32 segment_id = 3;</code>
   * @param index The index of the element to return.
   * @return The segmentId at the given index.
   */
  int getSegmentId(int index);

  /**
   * <code>repeated .starrocks.DeltaColumnGroupListPB dcg_lists = 4;</code>
   */
  java.util.List<com.starrocks.proto.DeltaColumnGroupListPB> 
      getDcgListsList();
  /**
   * <code>repeated .starrocks.DeltaColumnGroupListPB dcg_lists = 4;</code>
   */
  com.starrocks.proto.DeltaColumnGroupListPB getDcgLists(int index);
  /**
   * <code>repeated .starrocks.DeltaColumnGroupListPB dcg_lists = 4;</code>
   */
  int getDcgListsCount();
  /**
   * <code>repeated .starrocks.DeltaColumnGroupListPB dcg_lists = 4;</code>
   */
  java.util.List<? extends com.starrocks.proto.DeltaColumnGroupListPBOrBuilder> 
      getDcgListsOrBuilderList();
  /**
   * <code>repeated .starrocks.DeltaColumnGroupListPB dcg_lists = 4;</code>
   */
  com.starrocks.proto.DeltaColumnGroupListPBOrBuilder getDcgListsOrBuilder(
      int index);
}
