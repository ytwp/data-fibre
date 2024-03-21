// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: descriptors.proto

package io.datafibre.fibre.proto;

public interface PTupleDescriptorOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PTupleDescriptor)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required int32 id = 1;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <code>required int32 id = 1;</code>
   * @return The id.
   */
  int getId();

  /**
   * <code>required int32 byte_size = 2;</code>
   * @return Whether the byteSize field is set.
   */
  boolean hasByteSize();
  /**
   * <code>required int32 byte_size = 2;</code>
   * @return The byteSize.
   */
  int getByteSize();

  /**
   * <code>required int32 num_null_bytes = 3;</code>
   * @return Whether the numNullBytes field is set.
   */
  boolean hasNumNullBytes();
  /**
   * <code>required int32 num_null_bytes = 3;</code>
   * @return The numNullBytes.
   */
  int getNumNullBytes();

  /**
   * <code>optional int64 table_id = 4;</code>
   * @return Whether the tableId field is set.
   */
  boolean hasTableId();
  /**
   * <code>optional int64 table_id = 4;</code>
   * @return The tableId.
   */
  long getTableId();

  /**
   * <code>optional int32 num_null_slots = 5;</code>
   * @return Whether the numNullSlots field is set.
   */
  boolean hasNumNullSlots();
  /**
   * <code>optional int32 num_null_slots = 5;</code>
   * @return The numNullSlots.
   */
  int getNumNullSlots();
}