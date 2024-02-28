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

package io.datafibre.fibre.catalog;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;
import io.datafibre.fibre.analysis.Expr;
import io.datafibre.fibre.analysis.FunctionCallExpr;
import io.datafibre.fibre.analysis.FunctionName;

import java.util.Set;

public class DefaultExpr {

    public static final Set<String> SUPPORTED_DEFAULT_FNS = ImmutableSet.of("now()", "uuid()", "uuid_numeric()");

    @SerializedName("expr")
    private String expr;

    public DefaultExpr(String expr) {
        this.expr = expr;
    }

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public Expr obtainExpr() {
        if (SUPPORTED_DEFAULT_FNS.contains(expr)) {
            String functionName = expr.replace("()", "");
            FunctionCallExpr functionCallExpr = new FunctionCallExpr(new FunctionName(functionName), Lists.newArrayList());
            Function fn = Expr.getBuiltinFunction(functionName, new Type[] {}, Function.CompareMode.IS_IDENTICAL);
            functionCallExpr.setFn(fn);
            functionCallExpr.setType(fn.getReturnType());
            return functionCallExpr;
        }
        return null;
    }
}
