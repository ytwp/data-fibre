// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: binlog.proto

package io.datafibre.fibre.proto;

public interface BinlogFileMetaPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.BinlogFileMetaPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int64 id = 1;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <code>optional int64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <pre>
   * the version of the first change event in the file
   * </pre>
   *
   * <code>optional int64 start_version = 2;</code>
   * @return Whether the startVersion field is set.
   */
  boolean hasStartVersion();
  /**
   * <pre>
   * the version of the first change event in the file
   * </pre>
   *
   * <code>optional int64 start_version = 2;</code>
   * @return The startVersion.
   */
  long getStartVersion();

  /**
   * <pre>
   * the sequence number for the first change event in the file
   * </pre>
   *
   * <code>optional int64 start_seq_id = 3;</code>
   * @return Whether the startSeqId field is set.
   */
  boolean hasStartSeqId();
  /**
   * <pre>
   * the sequence number for the first change event in the file
   * </pre>
   *
   * <code>optional int64 start_seq_id = 3;</code>
   * @return The startSeqId.
   */
  long getStartSeqId();

  /**
   * <pre>
   * timestamp for the first change evnet in the file
   * </pre>
   *
   * <code>optional int64 start_timestamp_in_us = 4;</code>
   * @return Whether the startTimestampInUs field is set.
   */
  boolean hasStartTimestampInUs();
  /**
   * <pre>
   * timestamp for the first change evnet in the file
   * </pre>
   *
   * <code>optional int64 start_timestamp_in_us = 4;</code>
   * @return The startTimestampInUs.
   */
  long getStartTimestampInUs();

  /**
   * <pre>
   * the version of the last change event in the file
   * </pre>
   *
   * <code>optional int64 end_version = 5;</code>
   * @return Whether the endVersion field is set.
   */
  boolean hasEndVersion();
  /**
   * <pre>
   * the version of the last change event in the file
   * </pre>
   *
   * <code>optional int64 end_version = 5;</code>
   * @return The endVersion.
   */
  long getEndVersion();

  /**
   * <pre>
   * the sequence number for the last change event in the file
   * </pre>
   *
   * <code>optional int64 end_seq_id = 6;</code>
   * @return Whether the endSeqId field is set.
   */
  boolean hasEndSeqId();
  /**
   * <pre>
   * the sequence number for the last change event in the file
   * </pre>
   *
   * <code>optional int64 end_seq_id = 6;</code>
   * @return The endSeqId.
   */
  long getEndSeqId();

  /**
   * <pre>
   * timestamp for the last change evnet in the file
   * </pre>
   *
   * <code>optional int64 end_timestamp_in_us = 7;</code>
   * @return Whether the endTimestampInUs field is set.
   */
  boolean hasEndTimestampInUs();
  /**
   * <pre>
   * timestamp for the last change evnet in the file
   * </pre>
   *
   * <code>optional int64 end_timestamp_in_us = 7;</code>
   * @return The endTimestampInUs.
   */
  long getEndTimestampInUs();

  /**
   * <pre>
   * whether this file is end of end_version
   * </pre>
   *
   * <code>optional bool version_eof = 8;</code>
   * @return Whether the versionEof field is set.
   */
  boolean hasVersionEof();
  /**
   * <pre>
   * whether this file is end of end_version
   * </pre>
   *
   * <code>optional bool version_eof = 8;</code>
   * @return The versionEof.
   */
  boolean getVersionEof();

  /**
   * <pre>
   * number of pages in this file
   * </pre>
   *
   * <code>optional int64 num_pages = 9;</code>
   * @return Whether the numPages field is set.
   */
  boolean hasNumPages();
  /**
   * <pre>
   * number of pages in this file
   * </pre>
   *
   * <code>optional int64 num_pages = 9;</code>
   * @return The numPages.
   */
  long getNumPages();

  /**
   * <pre>
   * file size of the binlog file
   * </pre>
   *
   * <code>optional int64 file_size = 10;</code>
   * @return Whether the fileSize field is set.
   */
  boolean hasFileSize();
  /**
   * <pre>
   * file size of the binlog file
   * </pre>
   *
   * <code>optional int64 file_size = 10;</code>
   * @return The fileSize.
   */
  long getFileSize();

  /**
   * <pre>
   * rowsets that this binlog file uses
   * </pre>
   *
   * <code>repeated int64 rowsets = 11;</code>
   * @return A list containing the rowsets.
   */
  java.util.List<java.lang.Long> getRowsetsList();
  /**
   * <pre>
   * rowsets that this binlog file uses
   * </pre>
   *
   * <code>repeated int64 rowsets = 11;</code>
   * @return The count of rowsets.
   */
  int getRowsetsCount();
  /**
   * <pre>
   * rowsets that this binlog file uses
   * </pre>
   *
   * <code>repeated int64 rowsets = 11;</code>
   * @param index The index of the element to return.
   * @return The rowsets at the given index.
   */
  long getRowsets(int index);
}
