// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: types.proto

package com.starrocks.proto;

/**
 * Protobuf enum {@code starrocks.ReplicationTxnStatePB}
 */
public enum ReplicationTxnStatePB
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>TXN_PREPARED = 0;</code>
   */
  TXN_PREPARED(0),
  /**
   * <code>TXN_SNAPSHOTED = 1;</code>
   */
  TXN_SNAPSHOTED(1),
  /**
   * <code>TXN_REPLICATED = 2;</code>
   */
  TXN_REPLICATED(2),
  /**
   * <code>TXN_PUBLISHED = 3;</code>
   */
  TXN_PUBLISHED(3),
  ;

  /**
   * <code>TXN_PREPARED = 0;</code>
   */
  public static final int TXN_PREPARED_VALUE = 0;
  /**
   * <code>TXN_SNAPSHOTED = 1;</code>
   */
  public static final int TXN_SNAPSHOTED_VALUE = 1;
  /**
   * <code>TXN_REPLICATED = 2;</code>
   */
  public static final int TXN_REPLICATED_VALUE = 2;
  /**
   * <code>TXN_PUBLISHED = 3;</code>
   */
  public static final int TXN_PUBLISHED_VALUE = 3;


  public final int getNumber() {
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static ReplicationTxnStatePB valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static ReplicationTxnStatePB forNumber(int value) {
    switch (value) {
      case 0: return TXN_PREPARED;
      case 1: return TXN_SNAPSHOTED;
      case 2: return TXN_REPLICATED;
      case 3: return TXN_PUBLISHED;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ReplicationTxnStatePB>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ReplicationTxnStatePB> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ReplicationTxnStatePB>() {
          public ReplicationTxnStatePB findValueByNumber(int number) {
            return ReplicationTxnStatePB.forNumber(number);
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
    return com.starrocks.proto.Types.getDescriptor().getEnumTypes().get(3);
  }

  private static final ReplicationTxnStatePB[] VALUES = values();

  public static ReplicationTxnStatePB valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private ReplicationTxnStatePB(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:starrocks.ReplicationTxnStatePB)
}

