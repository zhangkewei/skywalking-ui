package org.skywalking.apm.ui.swgger;/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 17:55
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 17:55
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年11月13日 17:55
 */
public class Node {
    @ApiModelProperty(value="节点ID",example="节点ID")
    public int id;
    @ApiModelProperty(value="base64编码的图片",example="base64编码的图片")
    public String image;
    @ApiModelProperty(value="节点名称",example="节点名称")
    public String label;
    @ApiModelProperty(value="是否真实节点",example="是否真实节点,true或者false")
    public String real;
}
