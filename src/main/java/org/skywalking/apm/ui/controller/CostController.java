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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skywalking.apm.ui.service.CostService;
import org.skywalking.apm.ui.web.ControllerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author peng-yongsheng
 */
@RestController
public class CostController extends ControllerBase {

    private Logger logger = LogManager.getFormatterLogger(CostController.class);

    @Autowired
    private CostService service;

    @ApiIgnore
    @GetMapping("costDataLoad")
    public void costDataLoad(@ModelAttribute("timeSliceType") String timeSliceType, @ModelAttribute("startTime") long startTime,
                             @ModelAttribute("endTime") long endTime, HttpServletResponse response) throws IOException {
        logger.debug("costDataLoad timeSliceType = %s, startTime = %s, endTime = %s", timeSliceType, startTime, endTime);
//        JsonObject dagJson = service.loadCostData(timeSliceType, startTime, endTime);
        reply("", response);
    }
}
