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
import org.skywalking.apm.ui.service.InstanceMetricService;
import org.skywalking.apm.ui.swgger.ApplicationResponse;
import org.skywalking.apm.ui.swgger.InstanceInfoResponse;
import org.skywalking.apm.ui.swgger.InstanceMetricResponse;
import org.skywalking.apm.ui.web.ControllerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstanceMetricController extends ControllerBase {

    private static int count = 0;
    private Logger logger = LogManager.getFormatterLogger(InstanceMetricController.class);

    @Autowired
    private InstanceMetricService service;

    @ApiOperation(value = "查询实例硬件信息", notes = "返回指定实例的硬件信息", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "", response = InstanceInfoResponse.class)
    })
    @RequestMapping("/instanceInfo")
    public void instanceInfo(@ApiParam(value = "实例ID" , required = true) @RequestParam("instanceId") int instanceId,
        HttpServletResponse response) throws IOException {
        logger.info("load instance info : %d", instanceId);
        reply(service.getOsInfo(instanceId).toString(), response);
    }
    @ApiOperation(value = "查询实例JVM指标", notes = "返回指定实例的JVM性能指标", httpMethod = "GET", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "", response = InstanceMetricResponse.class)
    })
    @RequestMapping("/metricInfoWithTimeRange")
    public void metricInfoWithTimeRange(@ApiParam(value = "实例ID" ,required = true) @RequestParam("instanceId") int instanceId,
        @ApiParam(value = "查询类型",required = true, allowMultiple = true, allowableValues = "tps,cpu,resptime,heapMemory,gc,nonHeapMemory,permGen,metaSpace,newGen,oldGen,survivor") @RequestParam("metricNames[]") String[] metricNames,
        @ApiParam(value = "开始时间,yyyyMMddHHmmss", required = true) @RequestParam("startTime") long startTime,
        @ApiParam(value = "结束时间,yyyyMMddHHmmss", required = true) @RequestParam("endTime") long endTime,
        HttpServletResponse response) throws IOException {
        logger.info("load metric Info: %d, %d, %d, %s", instanceId, startTime, endTime, metricNames);
        reply(service.getMetric(instanceId, metricNames, startTime, endTime).toString(), response);
    }
}
