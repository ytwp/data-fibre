// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_file.proto

package com.starrocks.proto;

public interface TabletMetaOpPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.TabletMetaOpPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .starrocks.TabletMetaOpType type = 1;</code>
   * @return Whether the type field is set.
   */
  boolean hasType();
  /**
   * <code>optional .starrocks.TabletMetaOpType type = 1;</code>
   * @return The type.
   */
  com.starrocks.proto.TabletMetaOpType getType();

  /**
   * <code>optional .starrocks.EditVersionMetaPB commit = 2;</code>
   * @return Whether the commit field is set.
   */
  boolean hasCommit();
  /**
   * <code>optional .starrocks.EditVersionMetaPB commit = 2;</code>
   * @return The commit.
   */
  com.starrocks.proto.EditVersionMetaPB getCommit();
  /**
   * <code>optional .starrocks.EditVersionMetaPB commit = 2;</code>
   */
  com.starrocks.proto.EditVersionMetaPBOrBuilder getCommitOrBuilder();

  /**
   * <code>optional .starrocks.EditVersionPB apply = 3;</code>
   * @return Whether the apply field is set.
   */
  boolean hasApply();
  /**
   * <code>optional .starrocks.EditVersionPB apply = 3;</code>
   * @return The apply.
   */
  com.starrocks.proto.EditVersionPB getApply();
  /**
   * <code>optional .starrocks.EditVersionPB apply = 3;</code>
   */
  com.starrocks.proto.EditVersionPBOrBuilder getApplyOrBuilder();
}
