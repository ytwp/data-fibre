// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_common.proto

package com.starrocks.proto;

public interface PNetworkAddressOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.PNetworkAddress)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string host = 1;</code>
   * @return Whether the host field is set.
   */
  boolean hasHost();
  /**
   * <code>optional string host = 1;</code>
   * @return The host.
   */
  java.lang.String getHost();
  /**
   * <code>optional string host = 1;</code>
   * @return The bytes for host.
   */
  com.google.protobuf.ByteString
      getHostBytes();

  /**
   * <code>optional int32 port = 2;</code>
   * @return Whether the port field is set.
   */
  boolean hasPort();
  /**
   * <code>optional int32 port = 2;</code>
   * @return The port.
   */
  int getPort();

  /**
   * <code>optional int64 node_id = 3;</code>
   * @return Whether the nodeId field is set.
   */
  boolean hasNodeId();
  /**
   * <code>optional int64 node_id = 3;</code>
   * @return The nodeId.
   */
  long getNodeId();
}
