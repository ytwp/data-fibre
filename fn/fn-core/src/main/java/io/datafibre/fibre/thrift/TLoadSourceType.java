/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public enum TLoadSourceType implements org.apache.thrift.TEnum {
  RAW(0),
  KAFKA(1),
  PULSAR(2);

  private final int value;

  private TLoadSourceType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  @Override
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static TLoadSourceType findByValue(int value) { 
    switch (value) {
      case 0:
        return RAW;
      case 1:
        return KAFKA;
      case 2:
        return PULSAR;
      default:
        return null;
    }
  }
}
