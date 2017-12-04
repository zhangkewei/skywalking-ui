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
import org.skywalking.apm.ui.service.SpanService;
import org.skywalking.apm.ui.swgger.InstanceInfoResponse;
import org.skywalking.apm.ui.swgger.SpanInfo;
import org.skywalking.apm.ui.web.ControllerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

/**
 * @author peng-yongsheng
 */
@RestController
public class SpanController extends ControllerBase {

    private Logger logger = LogManager.getFormatterLogger(SpanController.class);

    @Autowired
    private SpanService service;
    @ApiOperation(value = "查询调用链片段信息", notes = "根据调用链片段ID查询该片段信息", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "", response = SpanInfo.class)
    })
    @GetMapping("spanDataLoad")
    public void spanDataLoad(
            @ApiParam(value = "调用链片段ID", required = true) @ModelAttribute("spanSegId") String spanSegId, HttpServletResponse response) throws IOException {
        logger.debug("costDataLoad spanSegId = %s", spanSegId);
        JsonObject dagJson = service.loadData(spanSegId);
        reply(dagJson.toString(), response);
    }
}
