/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public enum TAccessPathType implements org.apache.thrift.TEnum {
  ROOT(0),
  KEY(1),
  OFFSET(2),
  FIELD(3),
  INDEX(4),
  ALL(5);

  private final int value;

  private TAccessPathType(int value) {
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
  public static TAccessPathType findByValue(int value) { 
    switch (value) {
      case 0:
        return ROOT;
      case 1:
        return KEY;
      case 2:
        return OFFSET;
      case 3:
        return FIELD;
      case 4:
        return INDEX;
      case 5:
        return ALL;
      default:
        return null;
    }
  }
}