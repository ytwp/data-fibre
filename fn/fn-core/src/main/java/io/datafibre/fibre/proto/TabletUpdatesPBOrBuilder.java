// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_file.proto

package io.datafibre.fibre.proto;

public interface TabletUpdatesPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.TabletUpdatesPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .starrocks.EditVersionMetaPB versions = 1;</code>
   */
  java.util.List<io.datafibre.fibre.proto.EditVersionMetaPB>
      getVersionsList();
  /**
   * <code>repeated .starrocks.EditVersionMetaPB versions = 1;</code>
   */
  io.datafibre.fibre.proto.EditVersionMetaPB getVersions(int index);
  /**
   * <code>repeated .starrocks.EditVersionMetaPB versions = 1;</code>
   */
  int getVersionsCount();
  /**
   * <code>repeated .starrocks.EditVersionMetaPB versions = 1;</code>
   */
  java.util.List<? extends io.datafibre.fibre.proto.EditVersionMetaPBOrBuilder>
      getVersionsOrBuilderList();
  /**
   * <code>repeated .starrocks.EditVersionMetaPB versions = 1;</code>
   */
  io.datafibre.fibre.proto.EditVersionMetaPBOrBuilder getVersionsOrBuilder(
      int index);

  /**
   * <code>optional .starrocks.EditVersionPB apply_version = 2;</code>
   * @return Whether the applyVersion field is set.
   */
  boolean hasApplyVersion();
  /**
   * <code>optional .starrocks.EditVersionPB apply_version = 2;</code>
   * @return The applyVersion.
   */
  io.datafibre.fibre.proto.EditVersionPB getApplyVersion();
  /**
   * <code>optional .starrocks.EditVersionPB apply_version = 2;</code>
   */
  io.datafibre.fibre.proto.EditVersionPBOrBuilder getApplyVersionOrBuilder();

  /**
   * <code>optional uint32 next_rowset_id = 3;</code>
   * @return Whether the nextRowsetId field is set.
   */
  boolean hasNextRowsetId();
  /**
   * <code>optional uint32 next_rowset_id = 3;</code>
   * @return The nextRowsetId.
   */
  int getNextRowsetId();

  /**
   * <code>optional uint64 next_log_id = 4;</code>
   * @return Whether the nextLogId field is set.
   */
  boolean hasNextLogId();
  /**
   * <code>optional uint64 next_log_id = 4;</code>
   * @return The nextLogId.
   */
  long getNextLogId();
}
