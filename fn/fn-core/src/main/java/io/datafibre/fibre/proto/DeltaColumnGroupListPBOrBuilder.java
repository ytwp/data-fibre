// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_common.proto

package com.starrocks.proto;

public interface DeltaColumnGroupListPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.DeltaColumnGroupListPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .starrocks.DeltaColumnGroupPB dcgs = 1;</code>
   */
  java.util.List<com.starrocks.proto.DeltaColumnGroupPB> 
      getDcgsList();
  /**
   * <code>repeated .starrocks.DeltaColumnGroupPB dcgs = 1;</code>
   */
  com.starrocks.proto.DeltaColumnGroupPB getDcgs(int index);
  /**
   * <code>repeated .starrocks.DeltaColumnGroupPB dcgs = 1;</code>
   */
  int getDcgsCount();
  /**
   * <code>repeated .starrocks.DeltaColumnGroupPB dcgs = 1;</code>
   */
  java.util.List<? extends com.starrocks.proto.DeltaColumnGroupPBOrBuilder> 
      getDcgsOrBuilderList();
  /**
   * <code>repeated .starrocks.DeltaColumnGroupPB dcgs = 1;</code>
   */
  com.starrocks.proto.DeltaColumnGroupPBOrBuilder getDcgsOrBuilder(
      int index);

  /**
   * <code>repeated int64 versions = 2;</code>
   * @return A list containing the versions.
   */
  java.util.List<java.lang.Long> getVersionsList();
  /**
   * <code>repeated int64 versions = 2;</code>
   * @return The count of versions.
   */
  int getVersionsCount();
  /**
   * <code>repeated int64 versions = 2;</code>
   * @param index The index of the element to return.
   * @return The versions at the given index.
   */
  long getVersions(int index);
}
