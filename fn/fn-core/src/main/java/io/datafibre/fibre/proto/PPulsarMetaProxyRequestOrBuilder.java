// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

public interface PPulsarMetaProxyRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PPulsarMetaProxyRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
   * @return Whether the pulsarInfo field is set.
   */
  boolean hasPulsarInfo();
  /**
   * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
   * @return The pulsarInfo.
   */
  io.datafibre.fibre.proto.PPulsarLoadInfo getPulsarInfo();
  /**
   * <code>optional .starrocks.PPulsarLoadInfo pulsar_info = 1;</code>
   */
  io.datafibre.fibre.proto.PPulsarLoadInfoOrBuilder getPulsarInfoOrBuilder();
}
