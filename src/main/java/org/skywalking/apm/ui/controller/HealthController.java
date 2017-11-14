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
import org.skywalking.apm.ui.service.HealthService;
import org.skywalking.apm.ui.swgger.ApplicationResponse;
import org.skywalking.apm.ui.swgger.InstancesResponse;
import org.skywalking.apm.ui.web.ControllerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxin
 */
@RestController
public class HealthController extends ControllerBase {

    private Logger logger = LogManager.getFormatterLogger(HealthController.class);

    @Autowired
    private HealthService service;
    @ApiOperation(value = "查询应用实例列表",notes="返回指定时间某个应用的实例列表",httpMethod = "GET",produces="application/json")
    @ApiResponses({
            @ApiResponse(code=200, message = "",response = InstancesResponse.class)
    })
    @GetMapping("/health/instances")
    public void loadInstanceHealth(@ApiParam(value="时间,yyyyMMddHHmmss",required = true) @ModelAttribute("timeBucket") long timeBucket,
                                   @ApiParam(value="应用ID") @RequestParam(value = "applicationIds[]", required = false) String[] applicationIds,
        HttpServletResponse response) throws IOException {

        logger.info("load Instance Health, timeBucket: %d, applicationIds: %s", timeBucket, applicationIds);
        reply(service.loadInstances(timeBucket, applicationIds).toString(), response);
    }
}
