// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_file.proto

package io.datafibre.fibre.proto;

public interface RowsetMetaIdPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.RowsetMetaIdPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * rowset id
   * </pre>
   *
   * <code>optional uint32 rowset_id = 1;</code>
   * @return Whether the rowsetId field is set.
   */
  boolean hasRowsetId();
  /**
   * <pre>
   * rowset id
   * </pre>
   *
   * <code>optional uint32 rowset_id = 1;</code>
   * @return The rowsetId.
   */
  int getRowsetId();

  /**
   * <code>optional .starrocks.RowsetMetaPB rowset_meta = 2;</code>
   * @return Whether the rowsetMeta field is set.
   */
  boolean hasRowsetMeta();
  /**
   * <code>optional .starrocks.RowsetMetaPB rowset_meta = 2;</code>
   * @return The rowsetMeta.
   */
  io.datafibre.fibre.proto.RowsetMetaPB getRowsetMeta();
  /**
   * <code>optional .starrocks.RowsetMetaPB rowset_meta = 2;</code>
   */
  io.datafibre.fibre.proto.RowsetMetaPBOrBuilder getRowsetMetaOrBuilder();
}
