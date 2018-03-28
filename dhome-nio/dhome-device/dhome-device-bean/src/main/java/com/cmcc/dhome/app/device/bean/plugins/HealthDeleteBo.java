package com.cmcc.dhome.app.device.bean.plugins;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.cmcc.zeus.base.core.BaseBo;

/**
 * 删除定时WiFi信息BO
 * 
 * @author 陈向君[chenxiangjun@chinamobile.com]
 * @date 2016年11月14日 - 上午9:28:10
 * @history
 *          2016年11月14日 - 上午9:28:10 陈向君[chenxiangjun@chinamobile.com] create.
 */
public class HealthDeleteBo extends BaseBo {

    private static final long serialVersionUID = -6497553859400585660L;
    @NotNull(message = "缺少参数netTimeId")
    @NotBlank(message = "netTimeId不能为空")
    private String            netTimeId;

    public String getNetTimeId() {
        return netTimeId;
    }

    public void setNetTimeId(String netTimeId) {
        this.netTimeId = netTimeId;
    }

}
