package org.skywalking.apm.ui.swgger;/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 16:11
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 16:11
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年11月13日 16:11
 */
@ApiModel
public class InstanceMetricResponse {
    @ApiModelProperty(value="cpu占用率/秒",example = "[本次cpu耗时-上次cpu耗时/((当前时间-上次收集时间) *cpu核数)]")
    public int[] cpu;
    @ApiModelProperty(value="到目前秒为止gc次数")
    public GCInfo gc;
    @ApiModelProperty(value="调用次数/秒",example = "[调用次数/秒]")
    public int[] tps;
    @ApiModelProperty(value="调用耗时毫秒/次",example = "[调用耗时毫秒/次]")
    public int[] resptime;
    @ApiModelProperty(value="堆内存信息")
    public Memory heapmemory;
    @ApiModelProperty(value="非堆内存信息")
    public Memory nonheapmemory;
    @ApiModelProperty(value="永久代内存信息")
    public Memory permgen;
    @ApiModelProperty(value="元空间内存信息")
    public Memory metaspace;
    @ApiModelProperty(value="新生代内存信息")
    public Memory newgen;
    @ApiModelProperty(value="老生代内存信息")
    public Memory oldgen;
    @ApiModelProperty(value="幸存区内存信息")
    public Memory survivor;
}
