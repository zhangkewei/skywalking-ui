package org.skywalking.apm.ui.swgger;/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 17:53
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 17:53
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年11月13日 17:53
 */
@ApiModel
public class NodeMapResponse {
    @ApiModelProperty("节点关系")
    public NodeRef[] nodeRefs;
    @ApiModelProperty("节点")
    public Node[] nodes;
}
