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

package io.datafibre.fibre.sql.ast;

import com.google.common.collect.Lists;
import io.datafibre.fibre.analysis.Predicate;
import io.datafibre.fibre.analysis.RedirectStatus;
import io.datafibre.fibre.catalog.Column;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.ScalarType;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.common.MetaNotFoundException;
import io.datafibre.fibre.privilege.AccessDeniedException;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.qe.ShowResultSetMetaData;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.analyzer.Authorizer;
import io.datafibre.fibre.sql.parser.NodePosition;
import io.datafibre.fibre.statistic.HistogramStatsMeta;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ShowHistogramStatsMetaStmt extends ShowStmt {

    public ShowHistogramStatsMetaStmt(Predicate predicate) {
        this(predicate, NodePosition.ZERO);
    }

    public ShowHistogramStatsMetaStmt(Predicate predicate, NodePosition pos) {
        super(pos);
        this.predicate = predicate;
    }

    private static final ShowResultSetMetaData META_DATA =
            ShowResultSetMetaData.builder()
                    .addColumn(new Column("Database", ScalarType.createVarchar(60)))
                    .addColumn(new Column("Table", ScalarType.createVarchar(60)))
                    .addColumn(new Column("Column", ScalarType.createVarchar(60)))
                    .addColumn(new Column("Type", ScalarType.createVarchar(20)))
                    .addColumn(new Column("UpdateTime", ScalarType.createVarchar(60)))
                    .addColumn(new Column("Properties", ScalarType.createVarchar(200)))
                    .build();

    public static List<String> showHistogramStatsMeta(ConnectContext context,
                                                      HistogramStatsMeta histogramStatsMeta) throws MetaNotFoundException {
        List<String> row = Lists.newArrayList("", "", "", "", "", "");
        long dbId = histogramStatsMeta.getDbId();
        long tableId = histogramStatsMeta.getTableId();

        Database db = GlobalStateMgr.getCurrentState().getDb(dbId);
        if (db == null) {
            throw new MetaNotFoundException("No found database: " + dbId);
        }
        row.set(0, db.getOriginName());
        Table table = db.getTable(tableId);
        if (table == null) {
            throw new MetaNotFoundException("No found table: " + tableId);
        }
        // In new privilege framework(RBAC), user needs any action on the table to show analysis status for it.
        try {
            Authorizer.checkAnyActionOnTableLikeObject(context.getCurrentUserIdentity(),
                    context.getCurrentRoleIds(), db.getFullName(), table);
        } catch (AccessDeniedException e) {
            return null;
        }

        row.set(1, table.getName());
        row.set(2, histogramStatsMeta.getColumn());
        row.set(3, histogramStatsMeta.getType().name());
        row.set(4, histogramStatsMeta.getUpdateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        row.set(5, histogramStatsMeta.getProperties() == null ? "{}" : histogramStatsMeta.getProperties().toString());

        return row;
    }

    @Override
    public ShowResultSetMetaData getMetaData() {
        return META_DATA;
    }

    @Override
    public RedirectStatus getRedirectStatus() {
        return RedirectStatus.FORWARD_NO_SYNC;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitShowHistogramStatsMetaStatement(this, context);
    }
}

