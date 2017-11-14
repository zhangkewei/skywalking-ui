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

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skywalking.apm.ui.service.TraceStackService;
import org.skywalking.apm.ui.swgger.TopTraceResponse;
import org.skywalking.apm.ui.swgger.TraceStackResponse;
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
public class TraceStackController extends ControllerBase {

    private Logger logger = LogManager.getFormatterLogger(TraceStackController.class);

    @Autowired
    private TraceStackService service;

    @ApiOperation(value = "根据全局调用链ID生成一维带层次关系的调用树", notes = "根据全局调用链ID生成一维带层次关系的调用树", httpMethod = "GET",produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "", response = TraceStackResponse.class, responseContainer = "List")
    })
    @RequestMapping(value = "loadTraceStackData", method = RequestMethod.GET)
    @ResponseBody
    public void loadTraceStackData(
        @ApiParam(value = "全局调用链ID", required = true) @ModelAttribute("globalId") String globalId,
        HttpServletResponse response) throws IOException {
        logger.debug("costDataLoad globalId = %s", globalId);
        String globalTraceData = service.loadTraceStackData(globalId);
        reply(globalTraceData, response);
    }
}
