package org.skywalking.apm.ui.swgger;/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 18:27
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 18:27
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年11月13日 18:27
 */
@ApiModel
public class Trace {
    @ApiModelProperty(value="主键ID",example="主键ID")
    public String DT_RowId;
    @ApiModelProperty(value="应用ID",example="应用ID")
    public long application_id;
    @ApiModelProperty(value="耗时,毫秒",example="耗时,毫秒")
    public long cost;
    @ApiModelProperty(value="结束时间,时间戳",example="结束时间,时间")
    public long end_time;
    @ApiModelProperty(value="全局跟踪链ID",example="全局跟踪链ID")
    public String  global_trace_id;
    @ApiModelProperty(value="是否报错",example="Failed,Success")
    public String is_error;
    @ApiModelProperty(value="分页序号",example="分页序号")
    public long num;
    @ApiModelProperty(value="调用链片段ID",example="调用链片段ID")
    public String segment_id;
    @ApiModelProperty(value="服务名称",example="服务名称")
    public String service_name;
    @ApiModelProperty(value="结束时间,时间戳",example="结束时间,时间")
    public long start_time;
}
