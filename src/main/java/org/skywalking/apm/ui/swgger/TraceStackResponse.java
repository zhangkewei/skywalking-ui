package org.skywalking.apm.ui.swgger;/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 18:37
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2017年11月13日 18:37
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2017年11月13日 18:37
 */
@ApiModel
public class TraceStackResponse {
    @ApiModelProperty(value="所属应用",example = "所属应用")
    public String applicationCode;
    @ApiModelProperty(value="当前调用耗时",example = "当前调用耗时")
    public long cost;
    @ApiModelProperty(value="是否入口调用",example = "是否入口调用,true、false")
    public String isRoot;
    @ApiModelProperty(value="当前调用的操作名称",example = "当前调用的操作名称")
    public String operationName;
    @ApiModelProperty(value="父级调用ID,如果是当前调用链片段起始调用,父级spanId就是上个调用片段EntrySpanId",example = "父级调用ID,如果是当前调用链片段起始调用,父级spanId就是上个调用片段EntrySpanId")
    public String parentSpanId;
    @ApiModelProperty(value="父级调用链片段ID",example = "父级调用链片段ID")
    public String segmentParentSpanId;
    @ApiModelProperty(value="当前调用链片段ID",example = "当前调用链片段ID")
    public String segmentSpanId;
    @ApiModelProperty(value="在当前调用链片段调用排序ID,标识与segmentSpanId的关系",example = "在当前调用链片段调用排序ID,标识与segmentSpanId的关系")
    public String spanId;
    @ApiModelProperty(value="开始时间，相对于本次调用请求，单位毫秒",example = "开始时间，相对于本次调用请求，单位毫秒")
    public long startTime;
}
