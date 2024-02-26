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

package io.datafibre.fibre.analysis;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.common.AnalysisException;
import io.datafibre.fibre.sql.ast.AstVisitor;
import io.datafibre.fibre.sql.parser.NodePosition;

import java.util.List;
import java.util.Objects;

public class SubfieldExpr extends Expr {

    // We use fieldNames to extract subfield column from children[0],
    // children[0] must be an StructType.
    private List<String> fieldNames;
    private boolean copyFlag = true;

    // Only used in parser, in parser, we can't determine column's type
    public SubfieldExpr(Expr child, List<String> fieldNames) {
        this(child, null, fieldNames);
    }

    public SubfieldExpr(Expr child, List<String> fieldNames, NodePosition pos) {
        this(child, null, fieldNames, pos);
    }

    // In this constructor, we can determine column's type
    // child must be an StructType
    public SubfieldExpr(Expr child, Type type, List<String> fieldNames) {
        this(child, type, fieldNames, NodePosition.ZERO);
    }

    public SubfieldExpr(Expr child, Type type, List<String> fieldNames, NodePosition pos) {
        super(pos);
        if (type != null) {
            Preconditions.checkArgument(child.getType().isStructType());
        }
        children.add(child);
        this.type = type;
        this.fieldNames = ImmutableList.copyOf(fieldNames);
    }

    public SubfieldExpr(SubfieldExpr other) {
        super(other);
        fieldNames = other.fieldNames;
        copyFlag = other.copyFlag;
    }

    public void setFieldNames(List<String> fieldNames) {
        this.fieldNames = ImmutableList.copyOf(fieldNames);
    }

    public void setCopyFlag(boolean copyFlag) {
        this.copyFlag = copyFlag;
    }

    public List<String> getFieldNames() {
        return fieldNames;
    }

    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitSubfieldExpr(this, context);
    }

    @Override
    protected void analyzeImpl(Analyzer analyzer) throws AnalysisException {
        Preconditions.checkState(false, "unreachable");
    }

    @Override
    protected String toSqlImpl() {
        return getChild(0).toSqlImpl() + "." + Joiner.on('.').join(fieldNames) + '[' + copyFlag + ']';
    }

//    @Override
//    protected void toThrift(TExprNode msg) {
//        msg.setNode_type(TExprNodeType.SUBFIELD_EXPR);
//        msg.setUsed_subfield_names(fieldNames);
//        msg.setCopy_flag(copyFlag);
//    }

    @Override
    public Expr clone() {
        return new SubfieldExpr(this);
    }

    @Override
    public boolean isSelfMonotonic() {
        return children.get(0).isSelfMonotonic();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        SubfieldExpr that = (SubfieldExpr) o;
        return Objects.equals(fieldNames, that.fieldNames) && this.copyFlag == that.copyFlag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fieldNames, copyFlag);
    }
}
