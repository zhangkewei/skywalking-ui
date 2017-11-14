package org.skywalking.apm.ui.swgger;/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 17:18
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 17:18
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年11月13日 17:18
 */
@ApiModel
public class ServiceTreeResponse {
    @ApiModelProperty(value="被调用方服务ID,即当前服务ID",example="被调用方服务ID,即当前服务ID")
    public long behindServiceId;
    @ApiModelProperty(value="被调用方服务名称,即当前服务名称",example="被调用方服务ID,即当前服务名称")
    public String behindServiceName;
    @ApiModelProperty(value="总调用耗时，单位毫秒/分钟",example="总调用耗时，单位毫秒/分钟")
    public long costSummary;
    @ApiModelProperty(value="错误调用次数/分钟",example="错误调用次数/分钟")
    public long error;
    @ApiModelProperty(value="调用方服务ID,即父级服务ID",example="调用方服务ID,即父级服务ID")
    public long frontServiceId;
    @ApiModelProperty(value="调用方服务名称,即父级服务名称",example="调用方服务名称,即父级服务名称")
    public String frontServiceName;
    @ApiModelProperty(value="耗时1秒及内的调用次数",example="耗时1秒及内的调用次数")
    public long s1Lte;
    @ApiModelProperty(value="大于1秒小于等于3秒的调用次数",example="大于1秒小于等于3秒的调用次数")
    public long s3Lte;
    @ApiModelProperty(value="大于5秒的调用次数",example="大于5秒的调用次数")
    public long s5Gt;
    @ApiModelProperty(value="耗时大于3秒小于等于5秒的调用次数",example="耗时大于3秒小于等于5秒的调用次数")
    public long s5Lte;
    @ApiModelProperty(value="总调用次数/分钟",example="总调用次数/分钟")
    public long summary;
}
