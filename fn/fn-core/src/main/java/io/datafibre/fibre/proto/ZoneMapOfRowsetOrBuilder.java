// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_file.proto

package io.datafibre.fibre.proto;

public interface ZoneMapOfRowsetOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.ZoneMapOfRowset)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required bytes min = 1;</code>
   * @return Whether the min field is set.
   */
  boolean hasMin();
  /**
   * <code>required bytes min = 1;</code>
   * @return The min.
   */
  com.google.protobuf.ByteString getMin();

  /**
   * <code>required bytes max = 2;</code>
   * @return Whether the max field is set.
   */
  boolean hasMax();
  /**
   * <code>required bytes max = 2;</code>
   * @return The max.
   */
  com.google.protobuf.ByteString getMax();

  /**
   * <code>optional bool null_flag = 3;</code>
   * @return Whether the nullFlag field is set.
   */
  boolean hasNullFlag();
  /**
   * <code>optional bool null_flag = 3;</code>
   * @return The nullFlag.
   */
  boolean getNullFlag();
}