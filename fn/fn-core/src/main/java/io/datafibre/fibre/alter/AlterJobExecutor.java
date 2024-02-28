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

package io.datafibre.fibre.alter;

import com.google.common.base.Preconditions;
import io.datafibre.fibre.analysis.ParseNode;
import io.datafibre.fibre.analysis.TableName;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.MaterializedView;
import io.datafibre.fibre.catalog.OlapTable;
import io.datafibre.fibre.catalog.Table;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.common.MaterializedViewExceptions;
import io.datafibre.fibre.common.util.concurrent.lock.LockType;
import io.datafibre.fibre.common.util.concurrent.lock.Locker;
import io.datafibre.fibre.persist.AlterViewInfo;
import io.datafibre.fibre.persist.SwapTableOperationLog;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.scheduler.mv.MaterializedViewMgr;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.server.LocalMetastore;
import io.datafibre.fibre.sql.analyzer.SemanticException;
import io.datafibre.fibre.sql.ast.AddColumnClause;
import io.datafibre.fibre.sql.ast.AddColumnsClause;
import io.datafibre.fibre.sql.ast.AddPartitionClause;
import io.datafibre.fibre.sql.ast.AddRollupClause;
import io.datafibre.fibre.sql.ast.AlterClause;
import io.datafibre.fibre.sql.ast.AlterMaterializedViewStmt;
import io.datafibre.fibre.sql.ast.AlterTableCommentClause;
import io.datafibre.fibre.sql.ast.AlterTableStmt;
import io.datafibre.fibre.sql.ast.AlterViewClause;
import io.datafibre.fibre.sql.ast.AlterViewStmt;
import io.datafibre.fibre.sql.ast.AstVisitor;
import io.datafibre.fibre.sql.ast.ColumnRenameClause;
import io.datafibre.fibre.sql.ast.CompactionClause;
import io.datafibre.fibre.sql.ast.CreateIndexClause;
import io.datafibre.fibre.sql.ast.DropColumnClause;
import io.datafibre.fibre.sql.ast.DropIndexClause;
import io.datafibre.fibre.sql.ast.DropPartitionClause;
import io.datafibre.fibre.sql.ast.DropRollupClause;
import io.datafibre.fibre.sql.ast.ModifyColumnClause;
import io.datafibre.fibre.sql.ast.ModifyPartitionClause;
import io.datafibre.fibre.sql.ast.ModifyTablePropertiesClause;
import io.datafibre.fibre.sql.ast.OptimizeClause;
import io.datafibre.fibre.sql.ast.PartitionRenameClause;
import io.datafibre.fibre.sql.ast.ReorderColumnsClause;
import io.datafibre.fibre.sql.ast.ReplacePartitionClause;
import io.datafibre.fibre.sql.ast.RollupRenameClause;
import io.datafibre.fibre.sql.ast.StatementBase;
import io.datafibre.fibre.sql.ast.SwapTableClause;
import io.datafibre.fibre.sql.ast.TableRenameClause;
import io.datafibre.fibre.sql.ast.TruncatePartitionClause;
import io.datafibre.fibre.sql.common.MetaUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.datafibre.fibre.sql.common.UnsupportedException.unsupportedException;

public class AlterJobExecutor extends AstVisitor<Void, ConnectContext> {
    protected static final Logger LOG = LogManager.getLogger(AlterJobExecutor.class);
    protected Database db;
    protected Table table;

    public AlterJobExecutor() {

    }

    public void process(StatementBase statement, ConnectContext context) {
        visit(statement, context);
    }

    //Alter system clause

    @Override
    public Void visitNode(ParseNode node, ConnectContext context) {
        throw new AlterJobException("Not support alter table operation : " + node.getClass().getName());
    }

    //Alter table clause

    @Override
    public Void visitCreateIndexClause(CreateIndexClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitDropIndexClause(DropIndexClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitTableRenameClause(TableRenameClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitAlterTableCommentClause(AlterTableCommentClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitSwapTableClause(SwapTableClause clause, ConnectContext context) {
        // must hold db write lock
        Locker locker = new Locker();
        Preconditions.checkState(locker.isWriteLockHeldByCurrentThread(db));

        OlapTable origTable = (OlapTable) table;

        String origTblName = origTable.getName();
        String newTblName = clause.getTblName();
        Table newTbl = db.getTable(newTblName);
        if (newTbl == null || !(newTbl.isOlapOrCloudNativeTable() || newTbl.isMaterializedView())) {
            throw new AlterJobException("Table " + newTblName + " does not exist or is not OLAP/LAKE table");
        }
        OlapTable olapNewTbl = (OlapTable) newTbl;

        // First, we need to check whether the table to be operated on can be renamed
        try {
            olapNewTbl.checkAndSetName(origTblName, true);
            origTable.checkAndSetName(newTblName, true);

            if (origTable.isMaterializedView() || newTbl.isMaterializedView()) {
                if (!(origTable.isMaterializedView() && newTbl.isMaterializedView())) {
                    throw new AlterJobException("Materialized view can only SWAP WITH materialized view");
                }
            }

            // inactive the related MVs
            LocalMetastore.inactiveRelatedMaterializedView(db, origTable,
                    MaterializedViewExceptions.inactiveReasonForBaseTableSwapped(origTblName));
            LocalMetastore.inactiveRelatedMaterializedView(db, olapNewTbl,
                    MaterializedViewExceptions.inactiveReasonForBaseTableSwapped(newTblName));

            SwapTableOperationLog log = new SwapTableOperationLog(db.getId(), origTable.getId(), olapNewTbl.getId());
            GlobalStateMgr.getCurrentState().getAlterJobMgr().swapTableInternal(log);
            GlobalStateMgr.getCurrentState().getEditLog().logSwapTable(log);

            LOG.info("finish swap table {}-{} with table {}-{}", origTable.getId(), origTblName, newTbl.getId(),
                    newTblName);
            return null;
        } catch (DdlException e) {
            throw new AlterJobException(e.getMessage(), e);
        }
    }

    @Override
    public Void visitModifyTablePropertiesClause(ModifyTablePropertiesClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitOptimizeClause(OptimizeClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitAddColumnClause(AddColumnClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitAddColumnsClause(AddColumnsClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitDropColumnClause(DropColumnClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitModifyColumnClause(ModifyColumnClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitColumnRenameClause(ColumnRenameClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitReorderColumnsClause(ReorderColumnsClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitAddRollupClause(AddRollupClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitDropRollupClause(DropRollupClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitRollupRenameClause(RollupRenameClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitCompactionClause(CompactionClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    //Alter partition clause

    @Override
    public Void visitModifyPartitionClause(ModifyPartitionClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitAddPartitionClause(AddPartitionClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitDropPartitionClause(DropPartitionClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitTruncatePartitionClause(TruncatePartitionClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitReplacePartitionClause(ReplacePartitionClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    @Override
    public Void visitPartitionRenameClause(PartitionRenameClause clause, ConnectContext context) {
        unsupportedException("Not support");
        return null;
    }

    // Alter View
    @Override
    public Void visitAlterViewClause(AlterViewClause alterViewClause, ConnectContext ctx) {
        AlterViewInfo alterViewInfo = new AlterViewInfo(db.getId(), table.getId(),
                alterViewClause.getInlineViewDef(),
                alterViewClause.getColumns(),
                ctx.getSessionVariable().getSqlMode(), alterViewClause.getComment());

        GlobalStateMgr.getCurrentState().getAlterJobMgr().alterView(alterViewInfo);
        GlobalStateMgr.getCurrentState().getEditLog().logModifyViewDef(alterViewInfo);
        return null;
    }

    @Override
    public Void visitAlterTableStatement(AlterTableStmt statement, ConnectContext context) {
        TableName tableName = statement.getTbl();
        Database db = MetaUtils.getDatabase(context, tableName);
        Table table = MetaUtils.getTable(tableName);

        if (table.getType() == Table.TableType.VIEW || table.getType() == Table.TableType.MATERIALIZED_VIEW) {
            throw new SemanticException("The specified table [" + tableName + "] is not a table");
        }

        this.db = db;
        this.table = table;
        for (AlterClause alterClause : statement.getOps()) {
            visit(alterClause, context);
        }
        return null;
    }

    @Override
    public Void visitAlterViewStatement(AlterViewStmt statement, ConnectContext context) {
        TableName tableName = statement.getTableName();
        Database db = MetaUtils.getDatabase(context, tableName);
        Table table = MetaUtils.getTable(tableName);

        if (table.getType() != Table.TableType.VIEW) {
            throw new SemanticException("The specified table [" + tableName + "] is not a view");
        }

        this.db = db;
        this.table = table;
        AlterViewClause alterViewClause = (AlterViewClause) statement.getAlterClause();
        visit(alterViewClause, context);
        return null;
    }

    @Override
    public Void visitAlterMaterializedViewStatement(AlterMaterializedViewStmt stmt, ConnectContext context) {
        // check db
        final TableName mvName = stmt.getMvName();
        Database db = MetaUtils.getDatabase(context, mvName);

        Locker locker = new Locker();
        if (!locker.lockAndCheckExist(db, LockType.WRITE)) {
            throw new AlterJobException("alter materialized failed. database:" + db.getFullName() + " not exist");
        }

        try {
            Table table = MetaUtils.getTable(mvName);
            if (!table.isMaterializedView()) {
                throw new SemanticException("The specified table [" + mvName + "] is not a view");
            }
            this.db = db;
            this.table = table;

            MaterializedView materializedView = (MaterializedView) table;
            // check materialized view state
            if (materializedView.getState() != OlapTable.OlapTableState.NORMAL) {
                throw new AlterJobException("Materialized view [" + materializedView.getName() + "]'s state is not NORMAL. "
                        + "Do not allow to do ALTER ops");
            }

            MaterializedViewMgr.getInstance().stopMaintainMV(materializedView);
            visit(stmt.getAlterTableClause());
            MaterializedViewMgr.getInstance().rebuildMaintainMV(materializedView);
            return null;
        } finally {
            locker.unLockDatabase(db, LockType.WRITE);
        }
    }
}
