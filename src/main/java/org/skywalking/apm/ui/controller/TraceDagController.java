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
import org.skywalking.apm.ui.service.TraceDagService;
import org.skywalking.apm.ui.swgger.NodeMapResponse;
import org.skywalking.apm.ui.swgger.SpanInfo;
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
public class TraceDagController extends ControllerBase {
    private Logger logger = LogManager.getFormatterLogger(TraceDagController.class);

    @Autowired
    private TraceDagService service;

    @ApiOperation(value = "应用调用关系图", notes = "查询应用调用关系图", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "", response = NodeMapResponse.class)
    })
    @RequestMapping(value = "dagNodesLoad", method = RequestMethod.GET)
    @ResponseBody
    public void dagNodesLoad(
        @ApiParam(value = "开始时间,yyyyMMddHHmm", required = true) @ModelAttribute("startTime") long startTime,
        @ApiParam(value = "结束时间,yyyyMMddHHmm", required = true) @ModelAttribute("endTime") long endTime, HttpServletResponse response) throws IOException {
        logger.debug("dagNodesLoad startTime = %s, endTime = %s", startTime, endTime);
        JsonObject dagJson = service.buildGraphData(startTime, endTime);
        reply(dagJson.toString(), response);
    }
}
