/**
 * Autogenerated by Thrift Compiler (0.19.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.datafibre.fibre.thrift;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.19.0)", date = "2024-02-22")
public enum TSchemaTableType implements org.apache.thrift.TEnum {
  SCH_AUTHORS(0),
  SCH_CHARSETS(1),
  SCH_COLLATIONS(2),
  SCH_COLLATION_CHARACTER_SET_APPLICABILITY(3),
  SCH_COLUMNS(4),
  SCH_COLUMN_PRIVILEGES(5),
  SCH_CREATE_TABLE(6),
  SCH_ENGINES(7),
  SCH_EVENTS(8),
  SCH_FILES(9),
  SCH_GLOBAL_STATUS(10),
  SCH_GLOBAL_VARIABLES(11),
  SCH_KEY_COLUMN_USAGE(12),
  SCH_MATERIALIZED_VIEWS(13),
  SCH_OPEN_TABLES(14),
  SCH_PARTITIONS(15),
  SCH_PLUGINS(16),
  SCH_PROCESSLIST(17),
  SCH_PROFILES(18),
  SCH_REFERENTIAL_CONSTRAINTS(19),
  SCH_PROCEDURES(20),
  SCH_SCHEMATA(21),
  SCH_SCHEMA_PRIVILEGES(22),
  SCH_SESSION_STATUS(23),
  SCH_SESSION_VARIABLES(24),
  SCH_STATISTICS(25),
  SCH_STATUS(26),
  SCH_TABLES(27),
  SCH_TABLES_CONFIG(28),
  SCH_TABLE_CONSTRAINTS(29),
  SCH_TABLE_NAMES(30),
  SCH_TABLE_PRIVILEGES(31),
  SCH_TRIGGERS(32),
  SCH_USER_PRIVILEGES(33),
  SCH_VARIABLES(34),
  SCH_VIEWS(35),
  SCH_TASKS(36),
  SCH_TASK_RUNS(37),
  SCH_VERBOSE_SESSION_VARIABLES(38),
  SCH_BE_TABLETS(39),
  SCH_BE_METRICS(40),
  SCH_BE_TXNS(41),
  SCH_BE_CONFIGS(42),
  SCH_LOADS(43),
  SCH_LOAD_TRACKING_LOGS(44),
  SCH_FE_TABLET_SCHEDULES(45),
  SCH_BE_COMPACTIONS(46),
  SCH_BE_THREADS(47),
  SCH_BE_LOGS(48),
  SCH_BE_BVARS(49),
  SCH_BE_CLOUD_NATIVE_COMPACTIONS(50),
  STARROCKS_ROLE_EDGES(51),
  STARROCKS_GRANT_TO_ROLES(52),
  STARROCKS_GRANT_TO_USERS(53),
  SCH_ROUTINE_LOAD_JOBS(54),
  SCH_STREAM_LOADS(55),
  SCH_PIPE_FILES(56),
  SCH_PIPES(57),
  SCH_FE_METRICS(58),
  STARROCKS_OBJECT_DEPENDENCIES(59),
  SYS_FE_LOCKS(60),
  SCH_BE_DATACACHE_METRICS(61),
  SCH_PARTITIONS_META(62),
  SYS_FE_MEMORY_USAGE(63);

  private final int value;

  private TSchemaTableType(int value) {
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
  public static TSchemaTableType findByValue(int value) { 
    switch (value) {
      case 0:
        return SCH_AUTHORS;
      case 1:
        return SCH_CHARSETS;
      case 2:
        return SCH_COLLATIONS;
      case 3:
        return SCH_COLLATION_CHARACTER_SET_APPLICABILITY;
      case 4:
        return SCH_COLUMNS;
      case 5:
        return SCH_COLUMN_PRIVILEGES;
      case 6:
        return SCH_CREATE_TABLE;
      case 7:
        return SCH_ENGINES;
      case 8:
        return SCH_EVENTS;
      case 9:
        return SCH_FILES;
      case 10:
        return SCH_GLOBAL_STATUS;
      case 11:
        return SCH_GLOBAL_VARIABLES;
      case 12:
        return SCH_KEY_COLUMN_USAGE;
      case 13:
        return SCH_MATERIALIZED_VIEWS;
      case 14:
        return SCH_OPEN_TABLES;
      case 15:
        return SCH_PARTITIONS;
      case 16:
        return SCH_PLUGINS;
      case 17:
        return SCH_PROCESSLIST;
      case 18:
        return SCH_PROFILES;
      case 19:
        return SCH_REFERENTIAL_CONSTRAINTS;
      case 20:
        return SCH_PROCEDURES;
      case 21:
        return SCH_SCHEMATA;
      case 22:
        return SCH_SCHEMA_PRIVILEGES;
      case 23:
        return SCH_SESSION_STATUS;
      case 24:
        return SCH_SESSION_VARIABLES;
      case 25:
        return SCH_STATISTICS;
      case 26:
        return SCH_STATUS;
      case 27:
        return SCH_TABLES;
      case 28:
        return SCH_TABLES_CONFIG;
      case 29:
        return SCH_TABLE_CONSTRAINTS;
      case 30:
        return SCH_TABLE_NAMES;
      case 31:
        return SCH_TABLE_PRIVILEGES;
      case 32:
        return SCH_TRIGGERS;
      case 33:
        return SCH_USER_PRIVILEGES;
      case 34:
        return SCH_VARIABLES;
      case 35:
        return SCH_VIEWS;
      case 36:
        return SCH_TASKS;
      case 37:
        return SCH_TASK_RUNS;
      case 38:
        return SCH_VERBOSE_SESSION_VARIABLES;
      case 39:
        return SCH_BE_TABLETS;
      case 40:
        return SCH_BE_METRICS;
      case 41:
        return SCH_BE_TXNS;
      case 42:
        return SCH_BE_CONFIGS;
      case 43:
        return SCH_LOADS;
      case 44:
        return SCH_LOAD_TRACKING_LOGS;
      case 45:
        return SCH_FE_TABLET_SCHEDULES;
      case 46:
        return SCH_BE_COMPACTIONS;
      case 47:
        return SCH_BE_THREADS;
      case 48:
        return SCH_BE_LOGS;
      case 49:
        return SCH_BE_BVARS;
      case 50:
        return SCH_BE_CLOUD_NATIVE_COMPACTIONS;
      case 51:
        return STARROCKS_ROLE_EDGES;
      case 52:
        return STARROCKS_GRANT_TO_ROLES;
      case 53:
        return STARROCKS_GRANT_TO_USERS;
      case 54:
        return SCH_ROUTINE_LOAD_JOBS;
      case 55:
        return SCH_STREAM_LOADS;
      case 56:
        return SCH_PIPE_FILES;
      case 57:
        return SCH_PIPES;
      case 58:
        return SCH_FE_METRICS;
      case 59:
        return STARROCKS_OBJECT_DEPENDENCIES;
      case 60:
        return SYS_FE_LOCKS;
      case 61:
        return SCH_BE_DATACACHE_METRICS;
      case 62:
        return SCH_PARTITIONS_META;
      case 63:
        return SYS_FE_MEMORY_USAGE;
      default:
        return null;
    }
  }
}
