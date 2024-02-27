// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: snapshot.proto

package com.starrocks.proto;

/**
 * Protobuf enum {@code starrocks.SnapshotTypePB}
 */
public enum SnapshotTypePB
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>SNAPSHOT_TYPE_UNKNOWN = 0;</code>
   */
  SNAPSHOT_TYPE_UNKNOWN(0),
  /**
   * <code>SNAPSHOT_TYPE_INCREMENTAL = 1;</code>
   */
  SNAPSHOT_TYPE_INCREMENTAL(1),
  /**
   * <code>SNAPSHOT_TYPE_FULL = 2;</code>
   */
  SNAPSHOT_TYPE_FULL(2),
  ;

  /**
   * <code>SNAPSHOT_TYPE_UNKNOWN = 0;</code>
   */
  public static final int SNAPSHOT_TYPE_UNKNOWN_VALUE = 0;
  /**
   * <code>SNAPSHOT_TYPE_INCREMENTAL = 1;</code>
   */
  public static final int SNAPSHOT_TYPE_INCREMENTAL_VALUE = 1;
  /**
   * <code>SNAPSHOT_TYPE_FULL = 2;</code>
   */
  public static final int SNAPSHOT_TYPE_FULL_VALUE = 2;


  public final int getNumber() {
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static SnapshotTypePB valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static SnapshotTypePB forNumber(int value) {
    switch (value) {
      case 0: return SNAPSHOT_TYPE_UNKNOWN;
      case 1: return SNAPSHOT_TYPE_INCREMENTAL;
      case 2: return SNAPSHOT_TYPE_FULL;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<SnapshotTypePB>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      SnapshotTypePB> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<SnapshotTypePB>() {
          public SnapshotTypePB findValueByNumber(int number) {
            return SnapshotTypePB.forNumber(number);
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
    return com.starrocks.proto.Snapshot.getDescriptor().getEnumTypes().get(0);
  }

  private static final SnapshotTypePB[] VALUES = values();

  public static SnapshotTypePB valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private SnapshotTypePB(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:starrocks.SnapshotTypePB)
}

