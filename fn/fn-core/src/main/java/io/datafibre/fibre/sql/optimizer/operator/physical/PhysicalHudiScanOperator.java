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

package io.datafibre.fibre.sql.optimizer.operator.physical;

import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptExpressionVisitor;
import io.datafibre.fibre.sql.optimizer.base.ColumnRefSet;
import io.datafibre.fibre.sql.optimizer.operator.OperatorType;
import io.datafibre.fibre.sql.optimizer.operator.OperatorVisitor;
import io.datafibre.fibre.sql.optimizer.operator.ScanOperatorPredicates;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalHudiScanOperator;

public class PhysicalHudiScanOperator extends PhysicalScanOperator {
    private ScanOperatorPredicates predicates;

    public PhysicalHudiScanOperator(LogicalHudiScanOperator scanOperator) {
        super(OperatorType.PHYSICAL_HUDI_SCAN, scanOperator);
        this.predicates = scanOperator.getScanOperatorPredicates();
    }

    @Override
    public ScanOperatorPredicates getScanOperatorPredicates() {
        return this.predicates;
    }

    @Override
    public void setScanOperatorPredicates(ScanOperatorPredicates predicates) {
        this.predicates = predicates;
    }

    @Override
    public <R, C> R accept(OperatorVisitor<R, C> visitor, C context) {
        return visitor.visitPhysicalHudiScan(this, context);
    }

    @Override
    public <R, C> R accept(OptExpressionVisitor<R, C> visitor, OptExpression optExpression, C context) {
        return visitor.visitPhysicalHudiScan(optExpression, context);
    }

    @Override
    public ColumnRefSet getUsedColumns() {
        ColumnRefSet refs = super.getUsedColumns();
        predicates.getNoEvalPartitionConjuncts().forEach(d -> refs.union(d.getUsedColumns()));
        predicates.getPartitionConjuncts().forEach(d -> refs.union(d.getUsedColumns()));
        predicates.getMinMaxConjuncts().forEach(d -> refs.union(d.getUsedColumns()));
        predicates.getMinMaxColumnRefMap().keySet().forEach(refs::union);
        return refs;
    }
}
