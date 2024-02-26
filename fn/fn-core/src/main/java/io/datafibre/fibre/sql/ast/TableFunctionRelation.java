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

import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.FunctionCallExpr;
import io.datafibre.fibre.analysis.FunctionName;
import io.datafibre.fibre.analysis.FunctionParams;
import io.datafibre.fibre.catalog.TableFunction;
import io.datafibre.fibre.sql.parser.NodePosition;

import java.util.List;

/**
 * Table Value Function resolved to relation
 */
public class TableFunctionRelation extends Relation {
    /**
     * functionName is created by parser
     * and will be converted to tableFunction in Analyzer
     */
    private final FunctionName functionName;
    /**
     * functionParams is created by parser
     * and will be converted to childExpressions in Analyzer
     */
    private final FunctionParams functionParams;
    private TableFunction tableFunction;
    private List<Expr> childExpressions;

    public TableFunctionRelation(FunctionCallExpr functionCallExpr) {
        this(functionCallExpr.getFnName().toString().toLowerCase(), functionCallExpr.getParams(), functionCallExpr.getPos());
    }

    public TableFunctionRelation(String functionName, FunctionParams functionParams, NodePosition pos) {
        super(pos);
        this.functionName = new FunctionName(functionName);
        this.functionParams = functionParams;
    }

    public FunctionName getFunctionName() {
        return functionName;
    }

    public FunctionParams getFunctionParams() {
        return functionParams;
    }

    public TableFunction getTableFunction() {
        return tableFunction;
    }

    public void setTableFunction(TableFunction tableFunction) {
        this.tableFunction = tableFunction;
    }

    public List<Expr> getChildExpressions() {
        return childExpressions;
    }

    public void setChildExpressions(List<Expr> childExpressions) {
        this.childExpressions = childExpressions;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitTableFunction(this, context);
    }
}