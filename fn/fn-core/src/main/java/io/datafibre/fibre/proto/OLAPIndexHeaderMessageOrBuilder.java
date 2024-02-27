// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_file.proto

package com.starrocks.proto;

public interface OLAPIndexHeaderMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.OLAPIndexHeaderMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required int32 start_version = 1;</code>
   * @return Whether the startVersion field is set.
   */
  boolean hasStartVersion();
  /**
   * <code>required int32 start_version = 1;</code>
   * @return The startVersion.
   */
  int getStartVersion();

  /**
   * <code>required int32 end_version = 2;</code>
   * @return Whether the endVersion field is set.
   */
  boolean hasEndVersion();
  /**
   * <code>required int32 end_version = 2;</code>
   * @return The endVersion.
   */
  int getEndVersion();

  /**
   * <code>required int64 cumulative_version_hash = 3 [deprecated = true];</code>
   * @deprecated starrocks.OLAPIndexHeaderMessage.cumulative_version_hash is deprecated.
   *     See olap_file.proto;l=303
   * @return Whether the cumulativeVersionHash field is set.
   */
  @java.lang.Deprecated boolean hasCumulativeVersionHash();
  /**
   * <code>required int64 cumulative_version_hash = 3 [deprecated = true];</code>
   * @deprecated starrocks.OLAPIndexHeaderMessage.cumulative_version_hash is deprecated.
   *     See olap_file.proto;l=303
   * @return The cumulativeVersionHash.
   */
  @java.lang.Deprecated long getCumulativeVersionHash();

  /**
   * <code>required uint32 segment = 4;</code>
   * @return Whether the segment field is set.
   */
  boolean hasSegment();
  /**
   * <code>required uint32 segment = 4;</code>
   * @return The segment.
   */
  int getSegment();

  /**
   * <code>required uint32 num_rows_per_block = 5;</code>
   * @return Whether the numRowsPerBlock field is set.
   */
  boolean hasNumRowsPerBlock();
  /**
   * <code>required uint32 num_rows_per_block = 5;</code>
   * @return The numRowsPerBlock.
   */
  int getNumRowsPerBlock();

  /**
   * <code>optional bool null_supported = 6;</code>
   * @return Whether the nullSupported field is set.
   */
  boolean hasNullSupported();
  /**
   * <code>optional bool null_supported = 6;</code>
   * @return The nullSupported.
   */
  boolean getNullSupported();

  /**
   * <code>optional bool delete_flag = 7;</code>
   * @return Whether the deleteFlag field is set.
   */
  boolean hasDeleteFlag();
  /**
   * <code>optional bool delete_flag = 7;</code>
   * @return The deleteFlag.
   */
  boolean getDeleteFlag();
}
