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
import org.skywalking.apm.ui.service.EntryServiceService;
import org.skywalking.apm.ui.swgger.EntryService;
import org.skywalking.apm.ui.swgger.EntryServiceResponse;
import org.skywalking.apm.ui.web.ControllerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peng-yongsheng
 */
@RestController
public class EntryServiceController extends ControllerBase {

    private Logger logger = LogManager.getFormatterLogger(EntryServiceController.class);

    @Autowired
    private EntryServiceService service;

    @ApiOperation(value = "入口服务列表", notes = "分页显示服务调用链信息", httpMethod = "GET",produces = "application/json")
    @ApiResponses({
            @ApiResponse(code=200, message = "", response = EntryServiceResponse.class)
    })
    @GetMapping("/service/entry/entryServiceList")
    public void load(@ApiParam(value = "应用ID", required = true) @ModelAttribute("applicationId") int applicationId,
                     @ApiParam(value = "时间类型", required = true,allowableValues = "minute") @ModelAttribute("timeBucketType") String timeBucketType,
                     @ApiParam(value = "入口服务名") @ModelAttribute("entryServiceName") String entryServiceName,
                     @ApiParam(value = "开始时间", required = true) @ModelAttribute("startTime") long startTime,
                     @ApiParam(value = "结束时间", required = true) @ModelAttribute("endTime") long endTime,
                     @ApiParam(value = "起始下标", required = true) @ModelAttribute("from") int from,
                     @ApiParam(value = "数量", required = true) @ModelAttribute("size") int size,
        HttpServletResponse response) throws IOException {

        logger.info("load entry service list, applicationId: %s, entryServiceName: %s, timeBucketType: %s, startTime: %s, endTime: %s, from: %s, size: %s", applicationId, entryServiceName, timeBucketType, startTime, endTime, from, size);
        reply(service.load(applicationId, entryServiceName, startTime, endTime, from, size).toString(), response);
    }
}
