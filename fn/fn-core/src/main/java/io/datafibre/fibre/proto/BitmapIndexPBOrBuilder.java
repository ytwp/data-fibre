// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: segment.proto

package com.starrocks.proto;

public interface BitmapIndexPBOrBuilder extends
    // @@protoc_insertion_point(interface_extends:starrocks.BitmapIndexPB)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .starrocks.BitmapIndexPB.BitmapType bitmap_type = 1 [default = ROARING_BITMAP];</code>
   * @return Whether the bitmapType field is set.
   */
  boolean hasBitmapType();
  /**
   * <code>optional .starrocks.BitmapIndexPB.BitmapType bitmap_type = 1 [default = ROARING_BITMAP];</code>
   * @return The bitmapType.
   */
  com.starrocks.proto.BitmapIndexPB.BitmapType getBitmapType();

  /**
   * <pre>
   * required: whether the index contains null key.
   * if true, the last bitmap (ordinal:dict_column.num_values) in bitmap_column is
   * the bitmap for null key. we don't store null key in dict_column.
   * </pre>
   *
   * <code>optional bool has_null = 2;</code>
   * @return Whether the hasNull field is set.
   */
  boolean hasHasNull();
  /**
   * <pre>
   * required: whether the index contains null key.
   * if true, the last bitmap (ordinal:dict_column.num_values) in bitmap_column is
   * the bitmap for null key. we don't store null key in dict_column.
   * </pre>
   *
   * <code>optional bool has_null = 2;</code>
   * @return The hasNull.
   */
  boolean getHasNull();

  /**
   * <pre>
   * required: meta for ordered dictionary part
   * </pre>
   *
   * <code>optional .starrocks.IndexedColumnMetaPB dict_column = 3;</code>
   * @return Whether the dictColumn field is set.
   */
  boolean hasDictColumn();
  /**
   * <pre>
   * required: meta for ordered dictionary part
   * </pre>
   *
   * <code>optional .starrocks.IndexedColumnMetaPB dict_column = 3;</code>
   * @return The dictColumn.
   */
  com.starrocks.proto.IndexedColumnMetaPB getDictColumn();
  /**
   * <pre>
   * required: meta for ordered dictionary part
   * </pre>
   *
   * <code>optional .starrocks.IndexedColumnMetaPB dict_column = 3;</code>
   */
  com.starrocks.proto.IndexedColumnMetaPBOrBuilder getDictColumnOrBuilder();

  /**
   * <pre>
   * required: meta for bitmaps part
   * </pre>
   *
   * <code>optional .starrocks.IndexedColumnMetaPB bitmap_column = 4;</code>
   * @return Whether the bitmapColumn field is set.
   */
  boolean hasBitmapColumn();
  /**
   * <pre>
   * required: meta for bitmaps part
   * </pre>
   *
   * <code>optional .starrocks.IndexedColumnMetaPB bitmap_column = 4;</code>
   * @return The bitmapColumn.
   */
  com.starrocks.proto.IndexedColumnMetaPB getBitmapColumn();
  /**
   * <pre>
   * required: meta for bitmaps part
   * </pre>
   *
   * <code>optional .starrocks.IndexedColumnMetaPB bitmap_column = 4;</code>
   */
  com.starrocks.proto.IndexedColumnMetaPBOrBuilder getBitmapColumnOrBuilder();
}
