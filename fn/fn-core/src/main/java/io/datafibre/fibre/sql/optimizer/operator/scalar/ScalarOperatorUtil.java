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

package io.datafibre.fibre.sql.optimizer.operator.scalar;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.FunctionName;
import io.datafibre.fibre.catalog.Function;
import io.datafibre.fibre.catalog.FunctionSet;
import io.datafibre.fibre.catalog.ScalarType;
import io.datafibre.fibre.catalog.Type;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.optimizer.rewrite.ScalarOperatorRewriter;

import static io.datafibre.fibre.catalog.Function.CompareMode.IS_IDENTICAL;
import static io.datafibre.fibre.catalog.Function.CompareMode.IS_NONSTRICT_SUPERTYPE_OF;
import static io.datafibre.fibre.sql.optimizer.rewrite.ScalarOperatorRewriter.DEFAULT_TYPE_CAST_RULE;

public class ScalarOperatorUtil {
    public static CallOperator buildMultiCountDistinct(CallOperator oldFunctionCall) {
        Function searchDesc = new Function(new FunctionName(FunctionSet.MULTI_DISTINCT_COUNT),
                oldFunctionCall.getFunction().getArgs(), Type.INVALID, false);
        Function fn = GlobalStateMgr.getCurrentState().getFunction(searchDesc, IS_NONSTRICT_SUPERTYPE_OF);
        if (fn == null) {
            return null;
        }

        ScalarOperatorRewriter scalarOpRewriter = new ScalarOperatorRewriter();
        return (CallOperator) scalarOpRewriter.rewrite(
                new CallOperator(FunctionSet.MULTI_DISTINCT_COUNT, fn.getReturnType(), oldFunctionCall.getChildren(),
                        fn),
                DEFAULT_TYPE_CAST_RULE);
    }

    public static CallOperator buildSum(ColumnRefOperator arg) {
        Preconditions.checkArgument(arg.getType() == Type.BIGINT);
        Function searchDesc = new Function(new FunctionName(FunctionSet.SUM),
                new Type[] {arg.getType()}, arg.getType(), false);
        Function fn = GlobalStateMgr.getCurrentState().getFunction(searchDesc, IS_NONSTRICT_SUPERTYPE_OF);
        ScalarOperatorRewriter scalarOpRewriter = new ScalarOperatorRewriter();
        return (CallOperator) scalarOpRewriter.rewrite(
                new CallOperator(FunctionSet.SUM, fn.getReturnType(), Lists.newArrayList(arg), fn),
                DEFAULT_TYPE_CAST_RULE);
    }

    public static Function findArithmeticFunction(CallOperator call, String fnName) {
        return findArithmeticFunction(call.getFunction().getArgs(), fnName);
    }

    public static Function findArithmeticFunction(Type[] argsType, String fnName) {
        return Expr.getBuiltinFunction(fnName, argsType, IS_IDENTICAL);
    }

    public static Function findSumFn(Type[] argTypes) {
        Function sumFn = findArithmeticFunction(argTypes, FunctionSet.SUM);
        Preconditions.checkState(sumFn != null);
        Function newFn = sumFn.copy();
        if (argTypes[0].isDecimalV3()) {
            newFn.setArgsType(argTypes);
            newFn.setRetType(ScalarType.createDecimalV3NarrowestType(38,
                    ((ScalarType) argTypes[0]).getScalarScale()));
        }
        return newFn;
    }
}
