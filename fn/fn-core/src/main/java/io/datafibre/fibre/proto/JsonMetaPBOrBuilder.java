// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: segment.proto

package io.datafibre.fibre.proto;

public interface JsonMetaPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.JsonMetaPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Format version
   * Version 1: encode each JSON datum individually, as so called row-oriented format
   * Version 2(WIP): columnar encoding for JSON
   * </pre>
   *
   * <code>optional uint32 format_version = 1;</code>
   * @return Whether the formatVersion field is set.
   */
  boolean hasFormatVersion();
  /**
   * <pre>
   * Format version
   * Version 1: encode each JSON datum individually, as so called row-oriented format
   * Version 2(WIP): columnar encoding for JSON
   * </pre>
   *
   * <code>optional uint32 format_version = 1;</code>
   * @return The formatVersion.
   */
  int getFormatVersion();
}