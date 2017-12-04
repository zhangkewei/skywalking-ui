package org.skywalking.apm.ui.swgger;/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 17:55
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 17:55
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年11月13日 17:55
 */
@ApiModel
public class NodeRef {
    @ApiModelProperty(value="起始节点",example = "起始节点")
    public long from;
    @ApiModelProperty(value="目的节点",example = "目的节点")
    public long to;
    @ApiModelProperty(value="调用次数",example = "调用次数")
    public long resSum;
}
