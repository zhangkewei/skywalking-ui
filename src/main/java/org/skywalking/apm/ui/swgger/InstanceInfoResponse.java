package org.skywalking.apm.ui.swgger;/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 15:08
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 15:08
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年11月13日 15:08
 */
@ApiModel
public class InstanceInfoResponse {
    @ApiModelProperty(value="操作系统",example = "操作系统")
    public String osName;
    @ApiModelProperty(value="主机名",example = "主机名")
    public String hostName;
    @ApiModelProperty(value="JVM进程ID",example = "JVM进程ID")
    public String processId;
    @ApiModelProperty(value="IPV4列表")
    public String[] ipv4s;
}
