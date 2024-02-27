// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_file.proto

package com.starrocks.proto;

public interface BinlogConfigPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.BinlogConfigPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Version of the configuration, and FE should deliver it to
   * the BE when executing 'ALTER TABLE'. The configuration with
   * a higher version can override that with a lower version.
   * </pre>
   *
   * <code>optional int64 version = 1;</code>
   * @return Whether the version field is set.
   */
  boolean hasVersion();
  /**
   * <pre>
   * Version of the configuration, and FE should deliver it to
   * the BE when executing 'ALTER TABLE'. The configuration with
   * a higher version can override that with a lower version.
   * </pre>
   *
   * <code>optional int64 version = 1;</code>
   * @return The version.
   */
  long getVersion();

  /**
   * <code>optional bool binlog_enable = 2;</code>
   * @return Whether the binlogEnable field is set.
   */
  boolean hasBinlogEnable();
  /**
   * <code>optional bool binlog_enable = 2;</code>
   * @return The binlogEnable.
   */
  boolean getBinlogEnable();

  /**
   * <code>optional int64 binlog_ttl_second = 3;</code>
   * @return Whether the binlogTtlSecond field is set.
   */
  boolean hasBinlogTtlSecond();
  /**
   * <code>optional int64 binlog_ttl_second = 3;</code>
   * @return The binlogTtlSecond.
   */
  long getBinlogTtlSecond();

  /**
   * <code>optional int64 binlog_max_size = 4;</code>
   * @return Whether the binlogMaxSize field is set.
   */
  boolean hasBinlogMaxSize();
  /**
   * <code>optional int64 binlog_max_size = 4;</code>
   * @return The binlogMaxSize.
   */
  long getBinlogMaxSize();
}
