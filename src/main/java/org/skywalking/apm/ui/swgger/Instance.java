package org.skywalking.apm.ui.swgger;/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 14:44
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 14:44
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年11月13日 14:44
 */
@ApiModel(value="实例")
public class Instance {
    @ApiModelProperty(value="ID",example="ID")
    public int id;
    @ApiModelProperty(value="调用次数/秒",example="调用次数/秒")
    public int tps;
    @ApiModelProperty(value="平均耗时毫秒/次",example="平均耗时毫秒/次")
    public int avg;
    @ApiModelProperty(value="健康级别,avg>5s:0,avg>3s&&avg<=5s:1,avg>1s&&avg<=3s:2,other:3",example ="健康级别,avg>5s:0,avg>3s&&avg<=5s:1,avg>1s&&avg<=3s:2,other:3" )
    public int healthLevel;
    @ApiModelProperty(value="状态:1失活,0活,上次心跳>2分钟：失活",example = "状态:1失活,0活,上次心跳>2m：失活")
    public int status;
    @ApiModelProperty(value="新生代GC次数/秒",example="新生代GC次数/秒")
    public int ygc;
    @ApiModelProperty(value="老生代GC次数/秒",example="老生代GC次数/秒")
    public int ogc;
}
