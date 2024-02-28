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

package io.datafibre.fibre.sql.optimizer.validate;

import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.sql.analyzer.SemanticException;
import io.datafibre.fibre.sql.optimizer.OptExpression;
import io.datafibre.fibre.sql.optimizer.OptExpressionVisitor;
import io.datafibre.fibre.sql.optimizer.operator.AggType;
import io.datafibre.fibre.sql.optimizer.operator.Operator;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalAggregationOperator;
import io.datafibre.fibre.sql.optimizer.operator.logical.LogicalWindowOperator;
import io.datafibre.fibre.sql.optimizer.operator.physical.PhysicalHashAggregateOperator;
import io.datafibre.fibre.sql.optimizer.operator.physical.PhysicalWindowOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.CallOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ColumnRefOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ConstantOperator;
import io.datafibre.fibre.sql.optimizer.operator.scalar.ScalarOperator;
import io.datafibre.fibre.sql.optimizer.operator.stream.PhysicalStreamAggOperator;
import io.datafibre.fibre.sql.optimizer.task.TaskContext;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static io.datafibre.fibre.catalog.FunctionSet.ANY_VALUE;
import static io.datafibre.fibre.catalog.FunctionSet.APPROX_COUNT_DISTINCT;
import static io.datafibre.fibre.catalog.FunctionSet.AVG;
import static io.datafibre.fibre.catalog.FunctionSet.BITMAP_UNION_INT;
import static io.datafibre.fibre.catalog.FunctionSet.COUNT;
import static io.datafibre.fibre.catalog.FunctionSet.HLL_RAW;
import static io.datafibre.fibre.catalog.FunctionSet.INTERSECT_COUNT;
import static io.datafibre.fibre.catalog.FunctionSet.MAX;
import static io.datafibre.fibre.catalog.FunctionSet.MAX_BY;
import static io.datafibre.fibre.catalog.FunctionSet.MIN;
import static io.datafibre.fibre.catalog.FunctionSet.MIN_BY;
import static io.datafibre.fibre.catalog.FunctionSet.NDV;
import static io.datafibre.fibre.catalog.FunctionSet.PERCENTILE_APPROX;
import static io.datafibre.fibre.catalog.FunctionSet.PERCENTILE_CONT;
import static io.datafibre.fibre.catalog.FunctionSet.PERCENTILE_UNION;
import static io.datafibre.fibre.catalog.FunctionSet.STDDEV;
import static io.datafibre.fibre.catalog.FunctionSet.SUM;

public class TypeChecker implements PlanValidator.Checker {

    private static final String PREFIX = "Type check failed.";

    private static final TypeChecker INSTANCE = new TypeChecker();

    private TypeChecker() {}

    public static TypeChecker getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(OptExpression physicalPlan, TaskContext taskContext) {
        TypeChecker.Visitor visitor = new TypeChecker.Visitor();
        physicalPlan.getOp().accept(visitor, physicalPlan, null);
    }

    private static class Visitor extends OptExpressionVisitor<Void, Void> {

        @Override
        public Void visit(OptExpression optExpression, Void context) {
            for (OptExpression input : optExpression.getInputs()) {
                Operator operator = input.getOp();
                operator.accept(this, input, null);
            }
            return null;
        }

        @Override
        public Void visitLogicalAggregate(OptExpression optExpression, Void context) {
            LogicalAggregationOperator operator = (LogicalAggregationOperator) optExpression.getOp();
            checkAggCall(operator.getAggregations(), operator.getType(), operator.isSplit(), operator.hasRemoveDistinctFunc());
            visit(optExpression, context);
            return null;
        }

        @Override
        public Void visitLogicalWindow(OptExpression optExpression, Void context) {
            LogicalWindowOperator operator = (LogicalWindowOperator) optExpression.getOp();
            checkFuncCall(operator.getWindowCall());
            visit(optExpression, context);
            return null;
        }


        @Override
        public Void visitPhysicalHashAggregate(OptExpression optExpression, Void context) {
            PhysicalHashAggregateOperator operator = (PhysicalHashAggregateOperator) optExpression.getOp();
            checkAggCall(operator.getAggregations(), operator.getType(), operator.isSplit(), operator.hasRemovedDistinctFunc());
            visit(optExpression, context);
            return null;
        }

        @Override
        public Void visitPhysicalAnalytic(OptExpression optExpression, Void context) {
            PhysicalWindowOperator operator = (PhysicalWindowOperator) optExpression.getOp();
            checkFuncCall(operator.getAnalyticCall());
            visit(optExpression, context);
            return null;
        }


        @Override
        public Void visitPhysicalStreamAgg(OptExpression optExpression, Void context) {
            PhysicalStreamAggOperator operator = (PhysicalStreamAggOperator) optExpression.getOp();
            checkFuncCall(operator.getAggregations());
            visit(optExpression, context);
            return null;
        }

        private void checkFuncCall(Map<ColumnRefOperator, CallOperator> functionCalls) {
            for (Map.Entry<ColumnRefOperator, CallOperator> entry : functionCalls.entrySet()) {
                ColumnRefOperator outputCol = entry.getKey();
                CallOperator callOperator = entry.getValue();
                checkColType(outputCol, outputCol, outputCol.getType(), callOperator.getType());

                if (callOperator.getArguments().size() != callOperator.getFunction().getArgs().length) {
                    // because of the default value in function, the number of argument in aggCall is not
                    // same as the function signature. For now, we just skip check this scene.
                    continue;
                }

                for (int i = 0; i < callOperator.getArguments().size(); i++) {
                    ScalarOperator arg = callOperator.getArguments().get(i);
                    checkColType(arg, callOperator, callOperator.getFunction().getArgs()[i], arg.getType());
                }
            }
        }


        private void checkAggCall(Map<ColumnRefOperator, CallOperator> aggregations, AggType aggType, boolean isSplit,
                                  boolean hasRemoveDistinctFunc) {
            for (Map.Entry<ColumnRefOperator, CallOperator> entry : aggregations.entrySet()) {
                ColumnRefOperator outputCol = entry.getKey();
                CallOperator aggCall = entry.getValue();
                boolean isMergeAggFn = false;
                switch (aggType) {
                    case LOCAL:
                        // In 3-phase agg, the global agg should set these not distinct agg callOperator to mergeAggFn.
                        // Sometimes we may further split the top global agg from a 3-phase agg into a two phase agg,
                        // For example, local agg -> distinct global agg -> exchange with group by keys -> global agg
                        // to
                        // local agg -> distinct global agg -> exchange with group by keys + distinct keys ->
                        // local agg -> exchange with group by keys -> global agg.
                        // The added exchange steps helps us distribute data more evenly across multiple machines.
                        // So we also need to set mergeAggFn flag into the second local agg for those not distinct
                        // agg callOperator.
                        isMergeAggFn = isSplit && hasRemoveDistinctFunc && !aggCall.isRemovedDistinct();
                        break;
                    case GLOBAL:
                        isMergeAggFn = isSplit && (!hasRemoveDistinctFunc || !aggCall.isRemovedDistinct());
                        break;
                    case DISTINCT_GLOBAL:
                        isMergeAggFn = true;
                        break;
                    case DISTINCT_LOCAL:
                        isMergeAggFn = !aggCall.isRemovedDistinct();
                }

                if (aggType.isGlobal()) {
                    // The type of col -> aggCall in intermediate phase is a bit of messy, check it may
                    // lead to forbid normal plan. For now, we are only verifying the final output
                    // type of the agg function.
                    checkColType(outputCol, outputCol, outputCol.getType(), aggCall.getType());
                }

                if (aggCall.getArguments().size() != aggCall.getFunction().getArgs().length) {
                    continue;
                }
                checkAggArguments(aggCall, isMergeAggFn);
            }
        }

        private void checkColType(ScalarOperator arg, ScalarOperator expr, Type defined, Type actual) {
            checkArgument(actual.matchesType(defined),
                    "%s the type of arg %s in expr '%s' is defined as %s, but the actual type is %s",
                    PREFIX, arg, expr, defined, actual);
        }

        private void checkPercentileApprox(List<ScalarOperator> arguments) {
            ScalarOperator arg1 = arguments.get(1);
            if (!(arguments.get(1) instanceof ConstantOperator)) {
                throw new IllegalArgumentException("percentile_approx " +
                        "requires the second parameter's type is numeric constant type");
            }
            ConstantOperator rate = (ConstantOperator) arg1;
            if (rate.getDouble() < 0 || rate.getDouble() > 1) {
                throw new SemanticException("percentile_approx second parameter'value must be between 0 and 1");
            }
        }

        private void checkAggArguments(CallOperator aggCall, boolean isMergeAggFn) {
            String functionName = aggCall.getFunction().functionName();
            List<ScalarOperator> arguments = aggCall.getArguments();
            Type[] definedTypes = aggCall.getFunction().getArgs();
            List<Type> argTypes = arguments.stream().map(ScalarOperator::getType).collect(Collectors.toList());
            switch (functionName) {
                case COUNT:
                case STDDEV:
                    break;
                case MIN:
                case MAX:
                case ANY_VALUE:
                    checkColType(arguments.get(0), aggCall, definedTypes[0], argTypes.get(0));
                    break;
                case MIN_BY:
                case MAX_BY:
                    if (!isMergeAggFn) {
                        checkArgument(definedTypes.length == 2 && argTypes.size() == 2,
                                "%s want 2 args in %s but found %s",
                                PREFIX, aggCall, definedTypes.length == 2 ? definedTypes.length : argTypes.size());
                        checkColType(arguments.get(1), aggCall, definedTypes[1], argTypes.get(1));
                    } else {
                        // check binary column
                    }
                    break;
                case NDV:
                case APPROX_COUNT_DISTINCT:
                case HLL_RAW:
                case AVG:
                case PERCENTILE_UNION:
                    if (!isMergeAggFn) {
                        checkColType(arguments.get(0), aggCall, definedTypes[0], argTypes.get(0));
                    } else {
                        // check args in merge phase
                    }
                    break;
                case PERCENTILE_APPROX:
                    checkPercentileApprox(arguments);
                    if (!isMergeAggFn) {
                        checkColType(arguments.get(0), aggCall, definedTypes[0], argTypes.get(0));
                    } else {
                        // check args in merge phase
                    }
                    break;
                case BITMAP_UNION_INT:
                case SUM:
                    if (!isMergeAggFn) {
                        checkArgument(argTypes.get(0).isNumericType() || argTypes.get(0).isBoolean(),
                                "%s want numeric type in %s, but input type is %s",
                                PREFIX, aggCall, argTypes.get(0));
                        checkColType(arguments.get(0), aggCall, definedTypes[0], argTypes.get(0));
                    } else {
                        // check args in merge phase
                    }
                    break;
                case INTERSECT_COUNT:
                    if (!isMergeAggFn) {
                        checkColType(arguments.get(0), aggCall, definedTypes[0], argTypes.get(0));
                        checkColType(arguments.get(1), aggCall, definedTypes[1], argTypes.get(1));
                    }
                    break;
                // check args in merge phase
                case PERCENTILE_CONT:
                    if (!isMergeAggFn) {
                        checkColType(arguments.get(0), aggCall, definedTypes[0], argTypes.get(0));
                        if (argTypes.size() == 2) {
                            checkArgument(aggCall.getArguments().get(1).isConstant(),
                                    "%s want constant arg in %s, but input is %s",
                                    PREFIX, aggCall, aggCall.getArguments().get(1));
                        }
                    }
                    break;
                default:
                    break;
            }
        }

    }
}
