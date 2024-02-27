// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lake_types.proto

package com.starrocks.proto;

public interface TabletMetadataPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.lake.TabletMetadataPB)
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
   * <code>optional int64 version = 2;</code>
   * @return Whether the version field is set.
   */
  boolean hasVersion();
  /**
   * <code>optional int64 version = 2;</code>
   * @return The version.
   */
  long getVersion();

  /**
   * <code>optional .starrocks.TabletSchemaPB schema = 3;</code>
   * @return Whether the schema field is set.
   */
  boolean hasSchema();
  /**
   * <code>optional .starrocks.TabletSchemaPB schema = 3;</code>
   * @return The schema.
   */
  com.starrocks.proto.TabletSchemaPB getSchema();
  /**
   * <code>optional .starrocks.TabletSchemaPB schema = 3;</code>
   */
  com.starrocks.proto.TabletSchemaPBOrBuilder getSchemaOrBuilder();

  /**
   * <code>repeated .starrocks.lake.RowsetMetadataPB rowsets = 4;</code>
   */
  java.util.List<com.starrocks.proto.RowsetMetadataPB> 
      getRowsetsList();
  /**
   * <code>repeated .starrocks.lake.RowsetMetadataPB rowsets = 4;</code>
   */
  com.starrocks.proto.RowsetMetadataPB getRowsets(int index);
  /**
   * <code>repeated .starrocks.lake.RowsetMetadataPB rowsets = 4;</code>
   */
  int getRowsetsCount();
  /**
   * <code>repeated .starrocks.lake.RowsetMetadataPB rowsets = 4;</code>
   */
  java.util.List<? extends com.starrocks.proto.RowsetMetadataPBOrBuilder> 
      getRowsetsOrBuilderList();
  /**
   * <code>repeated .starrocks.lake.RowsetMetadataPB rowsets = 4;</code>
   */
  com.starrocks.proto.RowsetMetadataPBOrBuilder getRowsetsOrBuilder(
      int index);

  /**
   * <code>optional uint32 next_rowset_id = 5;</code>
   * @return Whether the nextRowsetId field is set.
   */
  boolean hasNextRowsetId();
  /**
   * <code>optional uint32 next_rowset_id = 5;</code>
   * @return The nextRowsetId.
   */
  int getNextRowsetId();

  /**
   * <pre>
   * cumulative point rowset index
   * </pre>
   *
   * <code>optional uint32 cumulative_point = 6;</code>
   * @return Whether the cumulativePoint field is set.
   */
  boolean hasCumulativePoint();
  /**
   * <pre>
   * cumulative point rowset index
   * </pre>
   *
   * <code>optional uint32 cumulative_point = 6;</code>
   * @return The cumulativePoint.
   */
  int getCumulativePoint();

  /**
   * <code>optional .starrocks.lake.DelvecMetadataPB delvec_meta = 7;</code>
   * @return Whether the delvecMeta field is set.
   */
  boolean hasDelvecMeta();
  /**
   * <code>optional .starrocks.lake.DelvecMetadataPB delvec_meta = 7;</code>
   * @return The delvecMeta.
   */
  com.starrocks.proto.DelvecMetadataPB getDelvecMeta();
  /**
   * <code>optional .starrocks.lake.DelvecMetadataPB delvec_meta = 7;</code>
   */
  com.starrocks.proto.DelvecMetadataPBOrBuilder getDelvecMetaOrBuilder();

  /**
   * <pre>
   * May not be empty if this metadata was generated by a compaction task
   * The data files in the compaction input rowsets would be deleted before
   * the metadata was deleted by the GC module.
   * </pre>
   *
   * <code>repeated .starrocks.lake.RowsetMetadataPB compaction_inputs = 8;</code>
   */
  java.util.List<com.starrocks.proto.RowsetMetadataPB> 
      getCompactionInputsList();
  /**
   * <pre>
   * May not be empty if this metadata was generated by a compaction task
   * The data files in the compaction input rowsets would be deleted before
   * the metadata was deleted by the GC module.
   * </pre>
   *
   * <code>repeated .starrocks.lake.RowsetMetadataPB compaction_inputs = 8;</code>
   */
  com.starrocks.proto.RowsetMetadataPB getCompactionInputs(int index);
  /**
   * <pre>
   * May not be empty if this metadata was generated by a compaction task
   * The data files in the compaction input rowsets would be deleted before
   * the metadata was deleted by the GC module.
   * </pre>
   *
   * <code>repeated .starrocks.lake.RowsetMetadataPB compaction_inputs = 8;</code>
   */
  int getCompactionInputsCount();
  /**
   * <pre>
   * May not be empty if this metadata was generated by a compaction task
   * The data files in the compaction input rowsets would be deleted before
   * the metadata was deleted by the GC module.
   * </pre>
   *
   * <code>repeated .starrocks.lake.RowsetMetadataPB compaction_inputs = 8;</code>
   */
  java.util.List<? extends com.starrocks.proto.RowsetMetadataPBOrBuilder> 
      getCompactionInputsOrBuilderList();
  /**
   * <pre>
   * May not be empty if this metadata was generated by a compaction task
   * The data files in the compaction input rowsets would be deleted before
   * the metadata was deleted by the GC module.
   * </pre>
   *
   * <code>repeated .starrocks.lake.RowsetMetadataPB compaction_inputs = 8;</code>
   */
  com.starrocks.proto.RowsetMetadataPBOrBuilder getCompactionInputsOrBuilder(
      int index);

  /**
   * <pre>
   * The previous metadata version containing garbage file records, i.e,  the
   * pervious metadata version whose "compaction_inputs" or "orphan_files" is
   * not empty.
   * </pre>
   *
   * <code>optional int64 prev_garbage_version = 9;</code>
   * @return Whether the prevGarbageVersion field is set.
   */
  boolean hasPrevGarbageVersion();
  /**
   * <pre>
   * The previous metadata version containing garbage file records, i.e,  the
   * pervious metadata version whose "compaction_inputs" or "orphan_files" is
   * not empty.
   * </pre>
   *
   * <code>optional int64 prev_garbage_version = 9;</code>
   * @return The prevGarbageVersion.
   */
  long getPrevGarbageVersion();

  /**
   * <code>repeated .starrocks.lake.FileMetaPB orphan_files = 10;</code>
   */
  java.util.List<com.starrocks.proto.FileMetaPB> 
      getOrphanFilesList();
  /**
   * <code>repeated .starrocks.lake.FileMetaPB orphan_files = 10;</code>
   */
  com.starrocks.proto.FileMetaPB getOrphanFiles(int index);
  /**
   * <code>repeated .starrocks.lake.FileMetaPB orphan_files = 10;</code>
   */
  int getOrphanFilesCount();
  /**
   * <code>repeated .starrocks.lake.FileMetaPB orphan_files = 10;</code>
   */
  java.util.List<? extends com.starrocks.proto.FileMetaPBOrBuilder> 
      getOrphanFilesOrBuilderList();
  /**
   * <code>repeated .starrocks.lake.FileMetaPB orphan_files = 10;</code>
   */
  com.starrocks.proto.FileMetaPBOrBuilder getOrphanFilesOrBuilder(
      int index);

  /**
   * <code>optional bool enable_persistent_index = 11;</code>
   * @return Whether the enablePersistentIndex field is set.
   */
  boolean hasEnablePersistentIndex();
  /**
   * <code>optional bool enable_persistent_index = 11;</code>
   * @return The enablePersistentIndex.
   */
  boolean getEnablePersistentIndex();

  /**
   * <code>optional .starrocks.lake.PersistentIndexTypePB persistent_index_type = 12;</code>
   * @return Whether the persistentIndexType field is set.
   */
  boolean hasPersistentIndexType();
  /**
   * <code>optional .starrocks.lake.PersistentIndexTypePB persistent_index_type = 12;</code>
   * @return The persistentIndexType.
   */
  com.starrocks.proto.PersistentIndexTypePB getPersistentIndexType();

  /**
   * <pre>
   * The commit time on the FE for the transaction that created this tablet metadata.
   * Meansured as the number of seconds since the Epoch, 1970-01-01 00:00:00 +0000 (UTC).
   * </pre>
   *
   * <code>optional int64 commit_time = 13;</code>
   * @return Whether the commitTime field is set.
   */
  boolean hasCommitTime();
  /**
   * <pre>
   * The commit time on the FE for the transaction that created this tablet metadata.
   * Meansured as the number of seconds since the Epoch, 1970-01-01 00:00:00 +0000 (UTC).
   * </pre>
   *
   * <code>optional int64 commit_time = 13;</code>
   * @return The commitTime.
   */
  long getCommitTime();

  /**
   * <pre>
   * If the tablet is replicated from another cluster, the source_schema saved the schema in the cluster
   * </pre>
   *
   * <code>optional .starrocks.TabletSchemaPB source_schema = 14;</code>
   * @return Whether the sourceSchema field is set.
   */
  boolean hasSourceSchema();
  /**
   * <pre>
   * If the tablet is replicated from another cluster, the source_schema saved the schema in the cluster
   * </pre>
   *
   * <code>optional .starrocks.TabletSchemaPB source_schema = 14;</code>
   * @return The sourceSchema.
   */
  com.starrocks.proto.TabletSchemaPB getSourceSchema();
  /**
   * <pre>
   * If the tablet is replicated from another cluster, the source_schema saved the schema in the cluster
   * </pre>
   *
   * <code>optional .starrocks.TabletSchemaPB source_schema = 14;</code>
   */
  com.starrocks.proto.TabletSchemaPBOrBuilder getSourceSchemaOrBuilder();
}
