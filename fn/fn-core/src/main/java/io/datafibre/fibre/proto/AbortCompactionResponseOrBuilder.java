// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_service.proto

package io.datafibre.fibre.proto;

public interface AbortCompactionResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.lake.AbortCompactionResponse)
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
  io.datafibre.fibre.proto.StatusPB getStatus();
  /**
   * <code>optional .starrocks.StatusPB status = 1;</code>
   */
  io.datafibre.fibre.proto.StatusPBOrBuilder getStatusOrBuilder();
}