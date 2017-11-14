package org.skywalking.apm.ui.swgger;/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 16:35
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 16:35
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年11月13日 16:35
 */
@ApiModel
public class GCInfo {
    @ApiModelProperty(value="老生代gc次数",example = "[到当前yyyyMMddHHmmss为止老生代gc总次数]")
    public int[] ogc;
    @ApiModelProperty(value="新生代gc次数",example = "[到当前yyyyMMddHHmmss为止新生代gc总次数]")
    public int[] ygc;
}
