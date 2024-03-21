// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: segment.proto

package io.datafibre.fibre.proto;

public interface IndexPageFooterPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.IndexPageFooterPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * required: number of index entries in this page
   * </pre>
   *
   * <code>optional uint32 num_entries = 1;</code>
   * @return Whether the numEntries field is set.
   */
  boolean hasNumEntries();
  /**
   * <pre>
   * required: number of index entries in this page
   * </pre>
   *
   * <code>optional uint32 num_entries = 1;</code>
   * @return The numEntries.
   */
  int getNumEntries();

  /**
   * <pre>
   * required: type of the index page
   * </pre>
   *
   * <code>optional .starrocks.IndexPageFooterPB.Type type = 2;</code>
   * @return Whether the type field is set.
   */
  boolean hasType();
  /**
   * <pre>
   * required: type of the index page
   * </pre>
   *
   * <code>optional .starrocks.IndexPageFooterPB.Type type = 2;</code>
   * @return The type.
   */
  io.datafibre.fibre.proto.IndexPageFooterPB.Type getType();
}