// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

public interface PFetchDataRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PFetchDataRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required .starrocks.PUniqueId finst_id = 1;</code>
   * @return Whether the finstId field is set.
   */
  boolean hasFinstId();
  /**
   * <code>required .starrocks.PUniqueId finst_id = 1;</code>
   * @return The finstId.
   */
  io.datafibre.fibre.proto.PUniqueId getFinstId();
  /**
   * <code>required .starrocks.PUniqueId finst_id = 1;</code>
   */
  io.datafibre.fibre.proto.PUniqueIdOrBuilder getFinstIdOrBuilder();
}