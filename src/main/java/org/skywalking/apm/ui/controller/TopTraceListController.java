/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking-ui
 */

package org.skywalking.apm.ui.controller;

import com.google.gson.JsonObject;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skywalking.apm.ui.service.TopTraceListService;
import org.skywalking.apm.ui.swgger.TopTraceResponse;
import org.skywalking.apm.ui.web.ControllerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author peng-yongsheng
 */
@Controller
public class TopTraceListController extends ControllerBase {

    private Logger logger = LogManager.getFormatterLogger(TopTraceListController.class);

    @Autowired
    private TopTraceListService service;


    @ApiOperation(value = "分布式调用链列表", notes = "调用链入口片段列表", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "", response = TopTraceResponse.class)
    })
    @RequestMapping(value = "topTraceListDataLoad", method = RequestMethod.GET)
    @ResponseBody
    public void topTraceListDataLoad(
        @ApiParam(value = "开始时间,yyyyMMddHHmmss") @ModelAttribute("startTime") long startTime,
        @ApiParam(value = "结束时间,yyyyMMddHHmmss") @ModelAttribute("endTime") long endTime,
        @ApiParam(value = "查询数量，分页") @ModelAttribute("limit") int limit,
        @ApiParam(value = "起始数据下标，分页") @ModelAttribute("from") int from,
        @ApiParam(value = "最小耗时,毫秒") @ModelAttribute("minCost") int minCost,
        @ApiParam(value = "最大耗时,毫秒") @ModelAttribute("maxCost") int maxCost,
        @ApiParam(value = "全局跟踪ID") @ModelAttribute("globalTraceId") String globalTraceId,
        @ApiParam(value = "应用ID") @ModelAttribute("applicationId") int applicationId,
        @ApiParam(value = "是否报错", allowableValues = "None,True,False") @ModelAttribute("error") String error,
        @ApiParam(value = "操作名称、span名称、服务名称") @ModelAttribute("operationName") String operationName,
        @ApiParam(value = "排序,cost:耗时,time：时间", allowableValues = "cost,time") @ModelAttribute("sort") String sort,
        HttpServletResponse response) throws IOException {
        logger.debug("topTraceListDataLoad startTime = %s, endTime = %s, from=%s, minCost=%s, maxCost=%s, globalTraceId=%s, operationName=%s, applicationId=%s, error=%s, sort=%s", startTime, endTime, from, minCost, maxCost, globalTraceId, operationName, applicationId, error, sort);
        JsonObject topSegJson = service.topTraceListDataLoad(startTime, endTime, minCost, maxCost, limit, from, globalTraceId, operationName, applicationId, error, sort);
        reply(topSegJson.toString(), response);
    }
}
