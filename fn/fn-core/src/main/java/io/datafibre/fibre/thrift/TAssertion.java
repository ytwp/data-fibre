/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public enum TAssertion implements org.apache.thrift.TEnum {
  EQ(0),
  NE(1),
  LT(2),
  LE(3),
  GT(4),
  GE(5);

  private final int value;

  private TAssertion(int value) {
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
  public static TAssertion findByValue(int value) { 
    switch (value) {
      case 0:
        return EQ;
      case 1:
        return NE;
      case 2:
        return LT;
      case 3:
        return LE;
      case 4:
        return GT;
      case 5:
        return GE;
      default:
        return null;
    }
  }
}
