// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tablet_schema.proto

package io.datafibre.fibre.proto;

public interface TabletSchemaPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.TabletSchemaPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .starrocks.KeysType keys_type = 1;</code>
   * @return Whether the keysType field is set.
   */
  boolean hasKeysType();
  /**
   * <code>optional .starrocks.KeysType keys_type = 1;</code>
   * @return The keysType.
   */
  io.datafibre.fibre.proto.KeysType getKeysType();

  /**
   * <code>repeated .starrocks.ColumnPB column = 2;</code>
   */
  java.util.List<io.datafibre.fibre.proto.ColumnPB>
      getColumnList();
  /**
   * <code>repeated .starrocks.ColumnPB column = 2;</code>
   */
  io.datafibre.fibre.proto.ColumnPB getColumn(int index);
  /**
   * <code>repeated .starrocks.ColumnPB column = 2;</code>
   */
  int getColumnCount();
  /**
   * <code>repeated .starrocks.ColumnPB column = 2;</code>
   */
  java.util.List<? extends io.datafibre.fibre.proto.ColumnPBOrBuilder>
      getColumnOrBuilderList();
  /**
   * <code>repeated .starrocks.ColumnPB column = 2;</code>
   */
  io.datafibre.fibre.proto.ColumnPBOrBuilder getColumnOrBuilder(
      int index);

  /**
   * <code>optional int32 num_short_key_columns = 3;</code>
   * @return Whether the numShortKeyColumns field is set.
   */
  boolean hasNumShortKeyColumns();
  /**
   * <code>optional int32 num_short_key_columns = 3;</code>
   * @return The numShortKeyColumns.
   */
  int getNumShortKeyColumns();

  /**
   * <code>optional int32 num_rows_per_row_block = 4;</code>
   * @return Whether the numRowsPerRowBlock field is set.
   */
  boolean hasNumRowsPerRowBlock();
  /**
   * <code>optional int32 num_rows_per_row_block = 4;</code>
   * @return The numRowsPerRowBlock.
   */
  int getNumRowsPerRowBlock();

  /**
   * <pre>
   * optional CompressKind compress_kind = 5; 
   * </pre>
   *
   * <code>optional double bf_fpp = 6;</code>
   * @return Whether the bfFpp field is set.
   */
  boolean hasBfFpp();
  /**
   * <pre>
   * optional CompressKind compress_kind = 5; 
   * </pre>
   *
   * <code>optional double bf_fpp = 6;</code>
   * @return The bfFpp.
   */
  double getBfFpp();

  /**
   * <code>optional uint32 next_column_unique_id = 7;</code>
   * @return Whether the nextColumnUniqueId field is set.
   */
  boolean hasNextColumnUniqueId();
  /**
   * <code>optional uint32 next_column_unique_id = 7;</code>
   * @return The nextColumnUniqueId.
   */
  int getNextColumnUniqueId();

  /**
   * <code>optional bool DEPRECATED_is_in_memory = 8 [default = false];</code>
   * @return Whether the dEPRECATEDIsInMemory field is set.
   */
  boolean hasDEPRECATEDIsInMemory();
  /**
   * <code>optional bool DEPRECATED_is_in_memory = 8 [default = false];</code>
   * @return The dEPRECATEDIsInMemory.
   */
  boolean getDEPRECATEDIsInMemory();

  /**
   * <pre>
   * deprecated
   * </pre>
   *
   * <code>optional int64 deprecated_id = 9;</code>
   * @return Whether the deprecatedId field is set.
   */
  boolean hasDeprecatedId();
  /**
   * <pre>
   * deprecated
   * </pre>
   *
   * <code>optional int64 deprecated_id = 9;</code>
   * @return The deprecatedId.
   */
  long getDeprecatedId();

  /**
   * <code>optional .starrocks.CompressionTypePB compression_type = 10 [default = LZ4_FRAME];</code>
   * @return Whether the compressionType field is set.
   */
  boolean hasCompressionType();
  /**
   * <code>optional .starrocks.CompressionTypePB compression_type = 10 [default = LZ4_FRAME];</code>
   * @return The compressionType.
   */
  io.datafibre.fibre.proto.CompressionTypePB getCompressionType();

  /**
   * <code>repeated uint32 sort_key_idxes = 11;</code>
   * @return A list containing the sortKeyIdxes.
   */
  java.util.List<java.lang.Integer> getSortKeyIdxesList();
  /**
   * <code>repeated uint32 sort_key_idxes = 11;</code>
   * @return The count of sortKeyIdxes.
   */
  int getSortKeyIdxesCount();
  /**
   * <code>repeated uint32 sort_key_idxes = 11;</code>
   * @param index The index of the element to return.
   * @return The sortKeyIdxes at the given index.
   */
  int getSortKeyIdxes(int index);

  /**
   * <code>optional int32 schema_version = 12;</code>
   * @return Whether the schemaVersion field is set.
   */
  boolean hasSchemaVersion();
  /**
   * <code>optional int32 schema_version = 12;</code>
   * @return The schemaVersion.
   */
  int getSchemaVersion();

  /**
   * <code>repeated uint32 sort_key_unique_ids = 13;</code>
   * @return A list containing the sortKeyUniqueIds.
   */
  java.util.List<java.lang.Integer> getSortKeyUniqueIdsList();
  /**
   * <code>repeated uint32 sort_key_unique_ids = 13;</code>
   * @return The count of sortKeyUniqueIds.
   */
  int getSortKeyUniqueIdsCount();
  /**
   * <code>repeated uint32 sort_key_unique_ids = 13;</code>
   * @param index The index of the element to return.
   * @return The sortKeyUniqueIds at the given index.
   */
  int getSortKeyUniqueIds(int index);

  /**
   * <code>repeated .starrocks.TabletIndexPB table_indices = 14;</code>
   */
  java.util.List<io.datafibre.fibre.proto.TabletIndexPB>
      getTableIndicesList();
  /**
   * <code>repeated .starrocks.TabletIndexPB table_indices = 14;</code>
   */
  io.datafibre.fibre.proto.TabletIndexPB getTableIndices(int index);
  /**
   * <code>repeated .starrocks.TabletIndexPB table_indices = 14;</code>
   */
  int getTableIndicesCount();
  /**
   * <code>repeated .starrocks.TabletIndexPB table_indices = 14;</code>
   */
  java.util.List<? extends io.datafibre.fibre.proto.TabletIndexPBOrBuilder>
      getTableIndicesOrBuilderList();
  /**
   * <code>repeated .starrocks.TabletIndexPB table_indices = 14;</code>
   */
  io.datafibre.fibre.proto.TabletIndexPBOrBuilder getTableIndicesOrBuilder(
      int index);

  /**
   * <code>optional int64 id = 50;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <code>optional int64 id = 50;</code>
   * @return The id.
   */
  long getId();
}
