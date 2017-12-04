package org.skywalking.apm.ui.swgger;/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 14:17
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 14:17
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年11月13日 14:17
 */
@ApiModel("服务")
public class EntryService {
        @ApiModelProperty(value="应用名称",example="应用名称")
        public String applicationCode;
        @ApiModelProperty(value="服务名称",example="服务名称")
        public String entryServiceName;
        @ApiModelProperty(value="应用ID",example="应用ID")
        public int applicationId;
        @ApiModelProperty(value="服务ID",example="服务ID")
        public int entryServiceId;
}
