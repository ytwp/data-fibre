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

package io.datafibre.fibre.http.rest;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.datafibre.fibre.catalog.Database;
import io.datafibre.fibre.catalog.InternalCatalog;
import io.datafibre.fibre.common.DdlException;
import io.datafibre.fibre.http.ActionController;
import io.datafibre.fibre.http.BaseRequest;
import io.datafibre.fibre.http.BaseResponse;
import io.datafibre.fibre.http.IllegalArgException;
import io.datafibre.fibre.persist.gson.GsonUtils;
import io.datafibre.fibre.qe.ConnectContext;
import io.datafibre.fibre.qe.StmtExecutor;
import io.datafibre.fibre.server.GlobalStateMgr;
import io.datafibre.fibre.sql.ast.StatementBase;
import io.datafibre.fibre.sql.optimizer.dump.DumpInfo;
import io.datafibre.fibre.sql.optimizer.dump.QueryDumpDeserializer;
import io.datafibre.fibre.sql.optimizer.dump.QueryDumpInfo;
import io.datafibre.fibre.sql.optimizer.dump.QueryDumpSerializer;
import io.datafibre.fibre.sql.parser.SqlParser;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* Usage:
   eg:
        POST  /api/query_dump?db=test  post_data=query
 return:
        {"statement": "...", "table_meta" : {..}, "table_row_count" : {...}, "session_variables" : "...",
         "column_statistics" : {...}}
 */

public class QueryDumpAction extends RestBaseAction {
    private static final Logger LOG = LogManager.getLogger(QueryDumpAction.class);
    private static final String DB = "db";

    private static final String MOCK = "mock";

    private static final Gson GSON = new GsonBuilder()
            .addSerializationExclusionStrategy(new GsonUtils.HiddenAnnotationExclusionStrategy())
            .addDeserializationExclusionStrategy(new GsonUtils.HiddenAnnotationExclusionStrategy())
            .enableComplexMapKeySerialization()
            .disableHtmlEscaping()
            .registerTypeAdapter(QueryDumpInfo.class, new QueryDumpSerializer())
            .registerTypeAdapter(QueryDumpInfo.class, new QueryDumpDeserializer())
            .create();

    public QueryDumpAction(ActionController controller) {
        super(controller);
    }

    public static void registerAction(ActionController controller) throws IllegalArgException {
        controller.registerHandler(HttpMethod.POST, "/api/query_dump", new QueryDumpAction(controller));
    }

    @Override
    public void executeWithoutPassword(BaseRequest request, BaseResponse response) throws DdlException {
        ConnectContext context = ConnectContext.get();
        String catalogDbName = request.getSingleParameter(DB);
        boolean enableMock = request.getSingleParameter(MOCK) == null ||
                "true".equalsIgnoreCase(StringUtils.trim(request.getSingleParameter(MOCK)));

        if (!Strings.isNullOrEmpty(catalogDbName)) {
            String[] catalogDbNames = catalogDbName.split("\\.");

            String catalogName = InternalCatalog.DEFAULT_INTERNAL_CATALOG_NAME;
            if (catalogDbNames.length == 2) {
                catalogName = catalogDbNames[0];
            }
            String dbName = catalogDbNames[catalogDbNames.length - 1];
            context.setCurrentCatalog(catalogName);
            Database db = GlobalStateMgr.getCurrentState().getMetadataMgr().getDb(catalogName, dbName);
            if (db == null) {
                response.getContent().append("Database [" + dbName + "] does not exists");
                sendResult(request, response, HttpResponseStatus.NOT_FOUND);
                return;
            }
            context.setDatabase(db.getFullName());
        }
        context.setIsHTTPQueryDump(true);

        String query = request.getContent();
        if (Strings.isNullOrEmpty(query)) {
            response.getContent().append("not valid parameter");
            sendResult(request, response, HttpResponseStatus.BAD_REQUEST);
            return;
        }

        StatementBase parsedStmt;
        try {
            parsedStmt = SqlParser.parse(query, context.getSessionVariable()).get(0);
            StmtExecutor executor = new StmtExecutor(context, parsedStmt);
            executor.execute();
        } catch (Exception e) {
            LOG.warn("execute query failed. " + e);
            response.getContent().append("execute query failed. " + e.getMessage());
            sendResult(request, response, HttpResponseStatus.BAD_REQUEST);
            return;
        }

        DumpInfo dumpInfo = context.getDumpInfo();
        if (dumpInfo != null) {
            dumpInfo.setDesensitizedInfo(enableMock);
            response.getContent().append(GSON.toJson(dumpInfo, QueryDumpInfo.class));
            sendResult(request, response);
        } else {
            response.getContent().append("not use cbo planner, try again.");
            sendResult(request, response, HttpResponseStatus.BAD_REQUEST);
        }
    }
}
