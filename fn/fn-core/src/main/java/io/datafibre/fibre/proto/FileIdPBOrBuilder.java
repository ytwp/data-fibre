// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: binlog.proto

package io.datafibre.fibre.proto;

public interface FileIdPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.FileIdPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Unique id for a rowset used by a binlog file. It's the publish version
   * for duplicate key, and TabletUpdate#_next_rowset_id for primary key.
   * For duplicate key, the binlog file only uses incremental rowsets which
   * can be distinguished by the publish version, see Tablet#_inc_rs_version_map.
   * Compared to use the data structure RowsetId, this can save the space,
   * and use the existing index to get rowset_id -&gt; Rowset, that's,
   * Tablet#_inc_rs_version_map for duplicate key, and TabletUpdates#_rowsets
   * for primary key
   * </pre>
   *
   * <code>optional int64 rowset_id = 1;</code>
   * @return Whether the rowsetId field is set.
   */
  boolean hasRowsetId();
  /**
   * <pre>
   * Unique id for a rowset used by a binlog file. It's the publish version
   * for duplicate key, and TabletUpdate#_next_rowset_id for primary key.
   * For duplicate key, the binlog file only uses incremental rowsets which
   * can be distinguished by the publish version, see Tablet#_inc_rs_version_map.
   * Compared to use the data structure RowsetId, this can save the space,
   * and use the existing index to get rowset_id -&gt; Rowset, that's,
   * Tablet#_inc_rs_version_map for duplicate key, and TabletUpdates#_rowsets
   * for primary key
   * </pre>
   *
   * <code>optional int64 rowset_id = 1;</code>
   * @return The rowsetId.
   */
  long getRowsetId();

  /**
   * <code>optional int32 segment_index = 2;</code>
   * @return Whether the segmentIndex field is set.
   */
  boolean hasSegmentIndex();
  /**
   * <code>optional int32 segment_index = 2;</code>
   * @return The segmentIndex.
   */
  int getSegmentIndex();
}
