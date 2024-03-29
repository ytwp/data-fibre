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

package io.datafibre.fibre.sql.analyzer;

import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.sql.ast.StatementBase;

public class Analyzer {
    private static final Analyzer INSTANCE = new Analyzer(new AnalyzerVisitor());

    public static Analyzer getInstance() {
        return INSTANCE;
    }

    private final AnalyzerVisitor analyzerVisitor;

    private Analyzer(AnalyzerVisitor analyzerVisitor) {
        this.analyzerVisitor = analyzerVisitor;
    }

    public static void analyze(StatementBase statement, ConnectContext context) {
        getInstance().analyzerVisitor.analyze(statement, context);
    }
}
