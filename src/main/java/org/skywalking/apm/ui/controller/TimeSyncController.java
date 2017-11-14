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
import org.skywalking.apm.ui.service.TimeSyncService;
import org.skywalking.apm.ui.swgger.ServiceTreeResponse;
import org.skywalking.apm.ui.web.ControllerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peng-yongsheng
 */
@RestController
public class TimeSyncController extends ControllerBase {

    private Logger logger = LogManager.getFormatterLogger(TimeSyncController.class);

    @Autowired
    private TimeSyncService service;

    @ApiOperation(value = "应用实例最后心跳时间", notes = "应用实例最后心跳时间", httpMethod = "GET",produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "",response = Long.class)
    })
    @GetMapping("time/sync/allInstance")
    public void allInstance(HttpServletResponse response) throws IOException {
        logger.debug("load all instance last time");
        long timeBucket = service.allInstance();
        JsonObject result = new JsonObject();
        result.addProperty("timeBucket", timeBucket);
        reply(result.toString(), response);
    }

    @ApiOperation(value = "某应用实例最后心跳时间", notes = "根据instanceId获得指定应用实例最后心跳时间", httpMethod = "GET",produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "", response = Long.class)
    })
    @GetMapping("time/sync/oneInstance")
    public void oneInstance(
        @ApiParam(value = "应用实例", required = true) @ModelAttribute("instanceId") int instanceId,
        HttpServletResponse response) throws IOException {
        logger.debug("load one instance last time, instance id: %s", instanceId);
        long timeBucket = service.oneInstance(instanceId);
        JsonObject result = new JsonObject();
        result.addProperty("timeBucket", timeBucket);
        reply(result.toString(), response);
    }
}
