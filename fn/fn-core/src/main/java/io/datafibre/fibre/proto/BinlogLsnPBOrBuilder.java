// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: binlog.proto

package io.datafibre.fibre.proto;

public interface BinlogLsnPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.BinlogLsnPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int64 version = 1;</code>
   * @return Whether the version field is set.
   */
  boolean hasVersion();
  /**
   * <code>optional int64 version = 1;</code>
   * @return The version.
   */
  long getVersion();

  /**
   * <code>optional int64 seq_id = 2;</code>
   * @return Whether the seqId field is set.
   */
  boolean hasSeqId();
  /**
   * <code>optional int64 seq_id = 2;</code>
   * @return The seqId.
   */
  long getSeqId();
}
