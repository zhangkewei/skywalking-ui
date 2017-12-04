package org.skywalking.apm.ui.swgger;/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 14:41
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * TODO
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 14:41
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年11月13日 14:41
 */
@ApiModel(value="实例列表")
public class Instances {
    @ApiModelProperty(value="应用名称",example="应用名称")
    public String applicationCode;
    @ApiModelProperty(value="应用ID",example="应用ID")
    public long applicationId;
    @ApiModelProperty(value="应用实例列表")
    public List<Instance> instances;
}
