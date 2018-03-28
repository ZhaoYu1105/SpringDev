/**
 * @ dhome-device-api
 * @ com.cmcc.dhome.app.device.controller.plugins
 * @ HealthBo.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年11月11日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.plugins;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年11月11日 - 下午1:41:12
 * @history
 *          2016年11月11日 - 下午1:41:12 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class HealthSwitchBo extends com.cmcc.zeus.base.core.BaseBo {

    private static final long serialVersionUID = 7281526026907170331L;
    @NotNull(message = "缺少参数netTimeId")
    @NotBlank(message = "netTimeId不能为空")
    private String            netTimeId;
    @NotNull(message = "缺少参数enable")
    @Range(min = 0, max = 1, message = "enable只能设置为0或1")
    private Integer           enable;

    public String getNetTimeId() {
        return netTimeId;
    }

    public void setNetTimeId(String netTimeId) {
        this.netTimeId = netTimeId;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

}
