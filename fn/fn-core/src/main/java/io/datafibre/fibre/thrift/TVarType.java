/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public enum TVarType implements org.apache.thrift.TEnum {
  SESSION(0),
  GLOBAL(1),
  VERBOSE(2);

  private final int value;

  private TVarType(int value) {
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
  public static TVarType findByValue(int value) { 
    switch (value) {
      case 0:
        return SESSION;
      case 1:
        return GLOBAL;
      case 2:
        return VERBOSE;
      default:
        return null;
    }
  }
}
