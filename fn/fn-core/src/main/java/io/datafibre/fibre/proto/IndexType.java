// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tablet_schema.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf enum {@code starrocks.IndexType}
 */
public enum IndexType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>BITMAP = 0;</code>
   */
  BITMAP(0),
  /**
   * <code>GIN = 1;</code>
   */
  GIN(1),
  /**
   * <code>INDEX_UNKNOWN = 2;</code>
   */
  INDEX_UNKNOWN(2),
  ;

  /**
   * <code>BITMAP = 0;</code>
   */
  public static final int BITMAP_VALUE = 0;
  /**
   * <code>GIN = 1;</code>
   */
  public static final int GIN_VALUE = 1;
  /**
   * <code>INDEX_UNKNOWN = 2;</code>
   */
  public static final int INDEX_UNKNOWN_VALUE = 2;


  public final int getNumber() {
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static IndexType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static IndexType forNumber(int value) {
    switch (value) {
      case 0: return BITMAP;
      case 1: return GIN;
      case 2: return INDEX_UNKNOWN;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<IndexType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      IndexType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<IndexType>() {
          public IndexType findValueByNumber(int number) {
            return IndexType.forNumber(number);
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
    return io.datafibre.fibre.proto.TabletSchema.getDescriptor().getEnumTypes().get(1);
  }

  private static final IndexType[] VALUES = values();

  public static IndexType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private IndexType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:starrocks.IndexType)
}

