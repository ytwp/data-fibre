// Copyright 2021-present StarRocks, Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package io.datafibre.fibre.connector;

import com.google.common.collect.Lists;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.MaterializedIndexMeta;
import io.datafibre.fibre.catalog.PartitionKey;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.common.AlreadyExistsException;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.common.MetaNotFoundException;
import io.datafibre.fibre.common.Pair;
import io.datafibre.fibre.common.UserException;
import io.datafibre.fibre.common.profile.Tracers;
import io.datafibre.fibre.connector.exception.StarRocksConnectorException;
import io.datafibre.fibre.credential.CloudConfiguration;
import io.datafibre.fibre.sql.ast.AddPartitionClause;
import io.datafibre.fibre.sql.ast.AlterMaterializedViewStmt;
import io.datafibre.fibre.sql.ast.AlterTableCommentClause;
import io.datafibre.fibre.sql.ast.AlterTableStmt;
import io.datafibre.fibre.sql.ast.AlterViewStmt;
import io.datafibre.fibre.sql.ast.CreateMaterializedViewStatement;
import io.datafibre.fibre.sql.ast.CreateMaterializedViewStmt;
import io.datafibre.fibre.sql.ast.CreateTableLikeStmt;
import io.datafibre.fibre.sql.ast.CreateTableStmt;
import io.datafibre.fibre.sql.ast.CreateViewStmt;
import io.datafibre.fibre.sql.ast.DropMaterializedViewStmt;
import io.datafibre.fibre.sql.ast.DropPartitionClause;
import io.datafibre.fibre.sql.ast.DropTableStmt;
import io.datafibre.fibre.sql.ast.PartitionRenameClause;
import io.datafibre.fibre.sql.ast.RefreshMaterializedViewStatement;
import io.datafibre.fibre.sql.ast.TableRenameClause;
import io.datafibre.fibre.sql.ast.TruncateTableStmt;
import io.datafibre.fibre.sql.optimizer.OptimizerContext;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;
import io.datafibre.fibre.sql.optimizer.statistics.Statistics;
import io.datafibre.fibre.thrift.TSinkCommitInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public interface ConnectorMetadata {
    /**
     * Use connector type as a hint of table type.
     * Caveat: there are exceptions that hive connector may have non-hive(e.g. iceberg) tables.
     */
    default Table.TableType getTableType() {
        throw new StarRocksConnectorException("This connector doesn't support getting table type");
    }

    /**
     * List all database names of connector
     *
     * @return a list of string containing all database names of connector
     */
    default List<String> listDbNames() {
        return Lists.newArrayList();
    }

    /**
     * List all table names of the database specific by `dbName`
     *
     * @param dbName - the string of which all table names are listed
     * @return a list of string containing all table names of `dbName`
     */
    default List<String> listTableNames(String dbName) {
        return Lists.newArrayList();
    }

    /**
     * Return all partition names of the table.
     *
     * @param databaseName the name of the database
     * @param tableName the name of the table
     * @return a list of partition names
     */
    default List<String> listPartitionNames(String databaseName, String tableName) {
        return Lists.newArrayList();
    }

    /**
     * Return partial partition names of the table using partitionValues to filter.
     *
     * @param databaseName the name of the database
     * @param tableName the name of the table
     * @param partitionValues the partition value to filter
     * @return a list of partition names
     */
    default List<String> listPartitionNamesByValue(String databaseName, String tableName,
                                                   List<Optional<String>> partitionValues) {
        return Lists.newArrayList();
    }

    /**
     * Get Table descriptor for the table specific by `dbName`.`tblName`
     *
     * @param dbName - the string represents the database name
     * @param tblName - the string represents the table name
     * @return a Table instance
     */
    default Table getTable(String dbName, String tblName) {
        return null;
    }

    default boolean tableExists(String dbName, String tblName) {
        return listTableNames(dbName).contains(tblName);
    }

    /**
     * Get Table descriptor and materialized index for the materialized view index specific by `dbName`.`tblName`
     *
     * @param dbName - the string represents the database name
     * @param tblName - the string represents the table name
     * @return a Table instance
     */
    default Pair<Table, MaterializedIndexMeta> getMaterializedViewIndex(String dbName, String tblName) {
        return null;
    }

    /**
     * It is mainly used to generate ScanRange for scheduling.
     * There are two ways of current connector table.
     * 1. Get the remote files information from hdfs or s3 according to table or partition.
     * 2. Get file scan tasks for iceberg metadata by query predicate.
     *
     * @param table
     * @param partitionKeys selected partition columns
     * @param snapshotId selected snapshot id
     * @param predicate used to filter metadata for iceberg, etc
     * @param fieldNames all selected columns (including partition columns)
     * @param limit scan limit nums if needed
     *
     * @return the remote file information of the query to scan.
     */
    default List<RemoteFileInfo> getRemoteFileInfos(Table table, List<PartitionKey> partitionKeys,
                                                    long snapshotId, ScalarOperator predicate,
                                                    List<String> fieldNames, long limit) {
        return Lists.newArrayList();
    }

    default List<PartitionInfo> getPartitions(Table table, List<String> partitionNames) {
        return Lists.newArrayList();
    }

    /**
     * Get statistics for the table.
     *
     * @param session optimizer context
     * @param table
     * @param columns selected columns
     * @param partitionKeys selected partition keys
     * @param predicate used to filter metadata for iceberg, etc
     * @param limit scan limit if needed, default value is -1
     *
     * @return the table statistics for the table.
     */
    default Statistics getTableStatistics(OptimizerContext session,
                                          Table table,
                                          Map<ColumnRefOperator, Column> columns,
                                          List<PartitionKey> partitionKeys,
                                          ScalarOperator predicate,
                                          long limit) {
        return Statistics.builder().build();
    }

    default boolean prepareMetadata(MetaPreparationItem item, Tracers tracers) {
        return true;
    }

    default List<PartitionKey> getPrunedPartitions(Table table, ScalarOperator predicate, long limit) {
        throw new StarRocksConnectorException("This connector doesn't support pruning partitions");
    }

    /**
     * Clean the query level cache after the query.
     */
    default void clear() {
    }

    default void refreshTable(String srDbName, Table table, List<String> partitionNames, boolean onlyCachedPartitions) {
    }

    default void createDb(String dbName) throws DdlException, AlreadyExistsException {
        createDb(dbName, new HashMap<>());
    }

    default boolean dbExists(String dbName) {
        return listDbNames().contains(dbName.toLowerCase(Locale.ROOT));
    }

    default void createDb(String dbName, Map<String, String> properties) throws DdlException, AlreadyExistsException {
        throw new StarRocksConnectorException("This connector doesn't support creating databases");
    }

    default void dropDb(String dbName, boolean isForceDrop) throws DdlException, MetaNotFoundException {
        throw new StarRocksConnectorException("This connector doesn't support dropping databases");
    }

    default Database getDb(long dbId) {
        return null;
    }

    default Database getDb(String name) {
        return null;
    }

    default List<Long> getDbIds() {
        return Lists.newArrayList();
    }

    default boolean createTable(CreateTableStmt stmt) throws DdlException {
        throw new StarRocksConnectorException("This connector doesn't support creating tables");
    }

    default void dropTable(DropTableStmt stmt) throws DdlException {
        throw new StarRocksConnectorException("This connector doesn't support dropping tables");
    }

    default void finishSink(String dbName, String table, List<TSinkCommitInfo> commitInfos) {
        throw new StarRocksConnectorException("This connector doesn't support sink");
    }

    default void abortSink(String dbName, String table, List<TSinkCommitInfo> commitInfos) {
    }

    default void alterTable(AlterTableStmt stmt) throws UserException {
        throw new StarRocksConnectorException("This connector doesn't support alter table");
    }

    default void renameTable(Database db, Table table, TableRenameClause tableRenameClause) throws DdlException {
    }

    default void alterTableComment(Database db, Table table, AlterTableCommentClause clause) {
    }

    default void truncateTable(TruncateTableStmt truncateTableStmt) throws DdlException {
    }

    default void createTableLike(CreateTableLikeStmt stmt) throws DdlException {
    }

    default void addPartitions(Database db, String tableName, AddPartitionClause addPartitionClause)
            throws DdlException, AnalysisException {
    }

    default void dropPartition(Database db, Table table, DropPartitionClause clause) throws DdlException {
    }

    default void renamePartition(Database db, Table table, PartitionRenameClause renameClause) throws DdlException {
    }

    default void createMaterializedView(CreateMaterializedViewStmt stmt)
            throws AnalysisException, DdlException {
    }

    default void createMaterializedView(CreateMaterializedViewStatement statement) throws DdlException {
    }

    default void dropMaterializedView(DropMaterializedViewStmt stmt) throws DdlException, MetaNotFoundException {
    }

    default void alterMaterializedView(AlterMaterializedViewStmt stmt)
            throws DdlException, MetaNotFoundException, AnalysisException {
    }

    default String refreshMaterializedView(RefreshMaterializedViewStatement refreshMaterializedViewStatement)
            throws DdlException, MetaNotFoundException {
        return null;
    }

    default void cancelRefreshMaterializedView(String dbName, String mvName)
            throws DdlException, MetaNotFoundException {
    }

    default void createView(CreateViewStmt stmt) throws DdlException {
    }

    default void alterView(AlterViewStmt stmt) throws DdlException, UserException {
    }

    default CloudConfiguration getCloudConfiguration() {
        throw new StarRocksConnectorException("This connector doesn't support getting cloud configuration");
    }

    default List<PartitionInfo> getChangedPartitionInfo(Table table, long mvSnapShotID) {
        return Lists.newArrayList();
    }
}

