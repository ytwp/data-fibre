// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: olap_file.proto

package io.datafibre.fibre.proto;

/**
 * <pre>
 * indicate whether date between segments of a rowset is overlappinng
 * </pre>
 *
 * Protobuf enum {@code starrocks.SegmentsOverlapPB}
 */
public enum SegmentsOverlapPB
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>OVERLAP_UNKNOWN = 0;</code>
   */
  OVERLAP_UNKNOWN(0),
  /**
   * <code>OVERLAPPING = 1;</code>
   */
  OVERLAPPING(1),
  /**
   * <code>NONOVERLAPPING = 2;</code>
   */
  NONOVERLAPPING(2),
  ;

  /**
   * <code>OVERLAP_UNKNOWN = 0;</code>
   */
  public static final int OVERLAP_UNKNOWN_VALUE = 0;
  /**
   * <code>OVERLAPPING = 1;</code>
   */
  public static final int OVERLAPPING_VALUE = 1;
  /**
   * <code>NONOVERLAPPING = 2;</code>
   */
  public static final int NONOVERLAPPING_VALUE = 2;


  public final int getNumber() {
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static SegmentsOverlapPB valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static SegmentsOverlapPB forNumber(int value) {
    switch (value) {
      case 0: return OVERLAP_UNKNOWN;
      case 1: return OVERLAPPING;
      case 2: return NONOVERLAPPING;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<SegmentsOverlapPB>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      SegmentsOverlapPB> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<SegmentsOverlapPB>() {
          public SegmentsOverlapPB findValueByNumber(int number) {
            return SegmentsOverlapPB.forNumber(number);
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
    return io.datafibre.fibre.proto.OlapFile.getDescriptor().getEnumTypes().get(2);
  }

  private static final SegmentsOverlapPB[] VALUES = values();

  public static SegmentsOverlapPB valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private SegmentsOverlapPB(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:starrocks.SegmentsOverlapPB)
}
