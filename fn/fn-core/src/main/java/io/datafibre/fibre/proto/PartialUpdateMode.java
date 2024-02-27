// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_file.proto

package com.starrocks.proto;

/**
 * <pre>
 * some txn semantic information bind to a written rowset
 * i.e.
 *   1. partial update txn only provide and update a subset of columns,
 *      so it should add info about updated columns, whether to insert new
 *      rows if old row doesn't exists, and default values etc
 *   2. conditional update txn may add some meta to describe condition
 *   3. more general read-write txn may add complex expressions
 * </pre>
 *
 * Protobuf enum {@code starrocks.PartialUpdateMode}
 */
public enum PartialUpdateMode
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>UNKNOWN_MODE = 0;</code>
   */
  UNKNOWN_MODE(0),
  /**
   * <code>ROW_MODE = 1;</code>
   */
  ROW_MODE(1),
  /**
   * <code>COLUMN_UPSERT_MODE = 2;</code>
   */
  COLUMN_UPSERT_MODE(2),
  /**
   * <code>AUTO_MODE = 3;</code>
   */
  AUTO_MODE(3),
  /**
   * <code>COLUMN_UPDATE_MODE = 4;</code>
   */
  COLUMN_UPDATE_MODE(4),
  ;

  /**
   * <code>UNKNOWN_MODE = 0;</code>
   */
  public static final int UNKNOWN_MODE_VALUE = 0;
  /**
   * <code>ROW_MODE = 1;</code>
   */
  public static final int ROW_MODE_VALUE = 1;
  /**
   * <code>COLUMN_UPSERT_MODE = 2;</code>
   */
  public static final int COLUMN_UPSERT_MODE_VALUE = 2;
  /**
   * <code>AUTO_MODE = 3;</code>
   */
  public static final int AUTO_MODE_VALUE = 3;
  /**
   * <code>COLUMN_UPDATE_MODE = 4;</code>
   */
  public static final int COLUMN_UPDATE_MODE_VALUE = 4;


  public final int getNumber() {
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static PartialUpdateMode valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static PartialUpdateMode forNumber(int value) {
    switch (value) {
      case 0: return UNKNOWN_MODE;
      case 1: return ROW_MODE;
      case 2: return COLUMN_UPSERT_MODE;
      case 3: return AUTO_MODE;
      case 4: return COLUMN_UPDATE_MODE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<PartialUpdateMode>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      PartialUpdateMode> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<PartialUpdateMode>() {
          public PartialUpdateMode findValueByNumber(int number) {
            return PartialUpdateMode.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.starrocks.proto.OlapFile.getDescriptor().getEnumTypes().get(3);
  }

  private static final PartialUpdateMode[] VALUES = values();

  public static PartialUpdateMode valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private PartialUpdateMode(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:starrocks.PartialUpdateMode)
}

