package com.cmcc.dhome.app.device.bean.plan;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 * 
 * 
 * @author 蔡洁[caijie@chinamobile.com]
 * @date 2017年3月10日 - 上午9:41:23
 * @history
 *          2017年3月10日 - 上午9:41:23 蔡洁[caijie@chinamobile.com] create.
 */
public class DeviceUpdatePlanBo {
    @NotNull(message = "缺少参数reqType")
    @Range(min = 0, max = 1, message = "reqType只能设置为0或1")
    String   reqType;
    @NotNull(message = "缺少参数planId")
    @NotEmpty(message = "缺少参数planId")
    String   planId;
    @NotNull(message = "缺少参数beginTime")
    @Range(min = 0, message = "beginTime格式不正确")
    Long     beginTime;
    @NotNull(message = "缺少参数gatewayList")
    @NotEmpty(message = "缺少参数gatewayList")
    String[] gatewayList;

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public String[] getGatewayList() {
        return gatewayList;
    }

    public void setGatewayList(String[] gatewayList) {
        this.gatewayList = gatewayList;
    }
}
