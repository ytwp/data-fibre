/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.starrocks.thrift;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public enum TResultSinkType implements org.apache.thrift.TEnum {
  MYSQL_PROTOCAL(0),
  FILE(1),
  STATISTIC(2),
  VARIABLE(3),
  HTTP_PROTOCAL(4);

  private final int value;

  private TResultSinkType(int value) {
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
  public static TResultSinkType findByValue(int value) { 
    switch (value) {
      case 0:
        return MYSQL_PROTOCAL;
      case 1:
        return FILE;
      case 2:
        return STATISTIC;
      case 3:
        return VARIABLE;
      case 4:
        return HTTP_PROTOCAL;
      default:
        return null;
    }
  }
}
