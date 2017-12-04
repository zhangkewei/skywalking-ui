package org.skywalking.apm.ui.swgger;/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 17:35
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 17:35
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年11月13日 17:35
 */
@ApiModel
public class SpanInfo {
    @ApiModelProperty(value="开始时间，时间戳",example="开始时间，时间戳")
    public long startTime;
    @ApiModelProperty(value="结束时间，时间戳",example="结束时间，时间戳")
    public long endTime;
    @ApiModelProperty(value="日志数组",example="[日志]")
    public String[] logMessage;
    @ApiModelProperty(value="操作名称、服务名称、span名称",example="操作名称、服务名称、span名称")
    public String operationName;
    @ApiModelProperty(value="标签，K-V数组")
    public Tag[] tags;
}
