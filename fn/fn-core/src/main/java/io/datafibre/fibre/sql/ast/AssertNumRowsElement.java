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

import io.datafibre.fibre.thrift.TAssertion;

public class AssertNumRowsElement {
    public enum Assertion {
        EQ, // val1 == val2
        NE, // val1 != val2
        LT, // val1 < val2
        LE, // val1 <= val2
        GT, // val1 > val2
        GE; // val1 >= val2

        public TAssertion toThrift() {
            switch (this) {
                case EQ:
                    return TAssertion.EQ;
                case NE:
                    return TAssertion.NE;
                case LT:
                    return TAssertion.LT;
                case LE:
                    return TAssertion.LE;
                case GT:
                    return TAssertion.GT;
                case GE:
                    return TAssertion.GE;
                default:
                    return null;
            }
        }
    }

    private final long desiredNumOfRows;
    private final String subqueryString;
    private final Assertion assertion;

    public AssertNumRowsElement(long desiredNumOfRows, String subqueryString, Assertion assertion) {
        this.desiredNumOfRows = desiredNumOfRows;
        this.subqueryString = subqueryString;
        this.assertion = assertion;
    }

    public long getDesiredNumOfRows() {
        return desiredNumOfRows;
    }

    public String getSubqueryString() {
        return subqueryString;
    }

    public Assertion getAssertion() {
        return assertion;
    }
}
