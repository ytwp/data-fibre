// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package com.starrocks.proto;

public interface PTabletReaderOpenResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PTabletReaderOpenResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   * @return Whether the status field is set.
   */
  boolean hasStatus();
  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   * @return The status.
   */
  com.starrocks.proto.StatusPB getStatus();
  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   */
  com.starrocks.proto.StatusPBOrBuilder getStatusOrBuilder();
}
