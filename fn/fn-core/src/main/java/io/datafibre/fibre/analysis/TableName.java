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

// This file is based on code available under the Apache license here:
//   https://github.com/apache/incubator-doris/blob/master/fe/fe-core/src/main/java/org/apache/doris/analysis/TableName.java

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package io.datafibre.fibre.analysis;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.gson.annotations.SerializedName;
import io.datafibre.fibre.cluster.ClusterNamespace;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.common.ErrorCode;
import io.datafibre.fibre.common.ErrorReport;
import io.datafibre.fibre.common.io.Text;
import io.datafibre.fibre.common.io.Writable;
import io.datafibre.fibre.persist.gson.GsonPostProcessable;
import io.datafibre.fibre.persist.gson.GsonPreProcessable;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.server.CatalogMgr;
import io.datafibre.fibre.sql.analyzer.SemanticException;
import io.datafibre.fibre.sql.parser.NodePosition;
import org.apache.commons.lang3.StringUtils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class TableName implements Writable, GsonPreProcessable, GsonPostProcessable {
    public static final String LAMBDA_FUNC_TABLE = "__LAMBDA_TABLE";
    private String catalog;
    @SerializedName(value = "tbl")
    private String tbl;
    private String db;
    @SerializedName(value = "fullDb")
    private String fullDb;

    private final NodePosition pos;

    public TableName() {
        pos = NodePosition.ZERO;
    }

    public TableName(String db, String tbl) {
        this(null, db, tbl, NodePosition.ZERO);
    }

    public TableName(String catalog, String db, String tbl) {
        this(catalog, db, tbl, NodePosition.ZERO);
    }

    public TableName(String catalog, String db, String tbl, NodePosition pos) {
        this.pos = pos;
        this.catalog = catalog;
        this.db = db;
        this.tbl = tbl;
    }

    public static TableName fromString(String name) {
        List<String> pieces = Splitter.on(".").splitToList(name);
        String catalog = ConnectContext.get().getCurrentCatalog();
        String db = ConnectContext.get().getDatabase();
        if (pieces.isEmpty()) {
            throw new IllegalArgumentException("empty table name");
        } else if (pieces.size() == 1) {
            if (StringUtils.isEmpty(db)) {
                throw new IllegalArgumentException("no database");
            }
            return new TableName(catalog, db, pieces.get(0));
        } else if (pieces.size() == 2) {
            return new TableName(catalog, pieces.get(0), pieces.get(1));
        } else if (pieces.size() == 3) {
            return new TableName(pieces.get(0), pieces.get(1), pieces.get(2));
        } else {
            throw new IllegalArgumentException("illegal table name: " + name);
        }
    }

    public void analyze(Analyzer analyzer) throws AnalysisException {
        if (Strings.isNullOrEmpty(catalog)) {
            catalog = analyzer.getDefaultCatalog();
        }

        if (Strings.isNullOrEmpty(db)) {
            db = analyzer.getDefaultDb();
            if (Strings.isNullOrEmpty(db)) {
                ErrorReport.reportAnalysisException(ErrorCode.ERR_NO_DB_ERROR);
            }
        }

        if (Strings.isNullOrEmpty(tbl)) {
            throw new AnalysisException("Table name is null");
        }
    }

    public void normalization(ConnectContext connectContext) {
        try {
            if (Strings.isNullOrEmpty(catalog)) {
                if (Strings.isNullOrEmpty(connectContext.getCurrentCatalog())) {
                    ErrorReport.reportAnalysisException(ErrorCode.ERR_BAD_CATALOG_ERROR, catalog);
                }
                catalog = connectContext.getCurrentCatalog();
            }

            if (Strings.isNullOrEmpty(db)) {
                db = connectContext.getDatabase();
                if (Strings.isNullOrEmpty(db)) {
                    ErrorReport.reportAnalysisException(ErrorCode.ERR_NO_DB_ERROR);
                }
            }

            if (Strings.isNullOrEmpty(tbl)) {
                throw new SemanticException("Table name is null");
            }
        } catch (AnalysisException e) {
            throw new SemanticException(e.getMessage());
        }
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getTbl() {
        return tbl;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    // for rename table
    public void setTbl(String tbl) {
        this.tbl = tbl;
    }

    public boolean isEmpty() {
        return tbl.isEmpty();
    }

    public String getCatalogAndDb() {
        return Joiner.on(".").skipNulls().join(catalog, db);
    }

    /**
     * Returns true if this name has a non-empty database field and a non-empty
     * table name.
     */
    public boolean isFullyQualified() {
        return db != null && !db.isEmpty() && !tbl.isEmpty();
    }

    public String getNoClusterString() {
        if (db == null) {
            return tbl;
        } else {
            return db + "." + tbl;
        }
    }

    public NodePosition getPos() {
        return pos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (catalog != null && !CatalogMgr.isInternalCatalog(catalog)) {
            stringBuilder.append(catalog).append(".");
        }
        if (db != null) {
            stringBuilder.append(db).append(".");
        }
        stringBuilder.append(tbl);
        return stringBuilder.toString();
    }

    public String toSql() {
        StringBuilder stringBuilder = new StringBuilder();
        if (catalog != null && !CatalogMgr.isInternalCatalog(catalog)) {
            stringBuilder.append("`").append(catalog).append("`.");
        }
        if (db != null) {
            stringBuilder.append("`").append(db).append("`.");
        }
        stringBuilder.append("`").append(tbl).append("`");
        return stringBuilder.toString();
    }

    @Override
    public void write(DataOutput out) throws IOException {
        // compatible with old version
        Text.writeString(out, ClusterNamespace.getFullName(db));
        Text.writeString(out, tbl);
    }

    public void readFields(DataInput in) throws IOException {
        db = ClusterNamespace.getNameFromFullName(Text.readString(in));
        tbl = Text.readString(in);
    }

    @Override
    public void gsonPostProcess() throws IOException {
        db = ClusterNamespace.getNameFromFullName(fullDb);
    }

    @Override
    public void gsonPreProcess() throws IOException {
        fullDb = ClusterNamespace.getFullName(db);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableName tableName = (TableName) o;
        return Objects.equals(catalog, tableName.catalog)
                && Objects.equals(tbl, tableName.tbl)
                && Objects.equals(db, tableName.db);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalog, tbl, db);
    }
}
