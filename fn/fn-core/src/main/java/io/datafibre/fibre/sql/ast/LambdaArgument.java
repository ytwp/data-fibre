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

import com.google.common.base.Preconditions;
import io.datafibre.fibre.analysis.Analyzer;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.sql.common.ErrorType;
import io.datafibre.fibre.sql.common.StarRocksPlannerException;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.thrift.TExprNode;

public class LambdaArgument extends Expr {
    private String name;
    private boolean nullable;

    ColumnRefOperator transformedOp = null;

    public ColumnRefOperator getTransformed() {
        return transformedOp;
    }

    public void setTransformed(ColumnRefOperator op) {
        transformedOp = op;
    }

    public LambdaArgument(String name) {
        this.name = name;
    }

    public LambdaArgument(LambdaArgument rhs) {
        super(rhs);
        name = rhs.getName();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    @Override
    protected void analyzeImpl(Analyzer analyzer) throws AnalysisException {
        Preconditions.checkState(false, "unreachable");
    }

    @Override
    protected String toSqlImpl() {
        return name;
    }

    @Override
    protected void toThrift(TExprNode msg) {
        throw new StarRocksPlannerException("not support", ErrorType.INTERNAL_ERROR);
    }

    @Override
    public Expr clone() {
        return new LambdaArgument(this);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitLambdaArguments(this, context);
    }
}
