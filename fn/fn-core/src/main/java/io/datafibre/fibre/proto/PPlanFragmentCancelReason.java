// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_service.proto

package io.datafibre.fibre.proto;

/**
 * Protobuf enum {@code starrocks.PPlanFragmentCancelReason}
 */
public enum PPlanFragmentCancelReason
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * 0 is reserved
   * </pre>
   *
   * <code>LIMIT_REACH = 1;</code>
   */
  LIMIT_REACH(1),
  /**
   * <code>USER_CANCEL = 2;</code>
   */
  USER_CANCEL(2),
  /**
   * <code>INTERNAL_ERROR = 3;</code>
   */
  INTERNAL_ERROR(3),
  /**
   * <code>TIMEOUT = 4;</code>
   */
  TIMEOUT(4),
  ;

  /**
   * <pre>
   * 0 is reserved
   * </pre>
   *
   * <code>LIMIT_REACH = 1;</code>
   */
  public static final int LIMIT_REACH_VALUE = 1;
  /**
   * <code>USER_CANCEL = 2;</code>
   */
  public static final int USER_CANCEL_VALUE = 2;
  /**
   * <code>INTERNAL_ERROR = 3;</code>
   */
  public static final int INTERNAL_ERROR_VALUE = 3;
  /**
   * <code>TIMEOUT = 4;</code>
   */
  public static final int TIMEOUT_VALUE = 4;


  public final int getNumber() {
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static PPlanFragmentCancelReason valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static PPlanFragmentCancelReason forNumber(int value) {
    switch (value) {
      case 1: return LIMIT_REACH;
      case 2: return USER_CANCEL;
      case 3: return INTERNAL_ERROR;
      case 4: return TIMEOUT;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<PPlanFragmentCancelReason>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      PPlanFragmentCancelReason> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<PPlanFragmentCancelReason>() {
          public PPlanFragmentCancelReason findValueByNumber(int number) {
            return PPlanFragmentCancelReason.forNumber(number);
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
    return io.datafibre.fibre.proto.InternalService.getDescriptor().getEnumTypes().get(0);
  }

  private static final PPlanFragmentCancelReason[] VALUES = values();

  public static PPlanFragmentCancelReason valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private PPlanFragmentCancelReason(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:starrocks.PPlanFragmentCancelReason)
}

