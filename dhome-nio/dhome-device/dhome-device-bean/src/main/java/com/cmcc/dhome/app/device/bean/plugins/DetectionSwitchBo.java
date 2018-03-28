package com.cmcc.dhome.app.device.bean.plugins;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.cmcc.zeus.base.core.BaseBo;

/**
 * 开关一键体检参数BO
 * 
 * @author 陈向君[chenxiangjun@chinamobile.com]
 * @date 2016年11月14日 - 上午11:40:15
 * @history
 *          2016年11月14日 - 上午11:40:15 陈向君[chenxiangjun@chinamobile.com] create.
 */
public class DetectionSwitchBo extends BaseBo {

    private static final long serialVersionUID = 2168335869013545915L;

    @NotNull(message = "缺少参数actionId")
    @NotBlank(message = "actionId不能为空")
    @Pattern(regexp = "[0-9]{10}", message = "actionId需为10位数字")
    private String            actionId;
    @NotNull(message = "缺少参数enable")
    @NotBlank(message = "enable不能为空")
    @Pattern(regexp = "[0,1]", message = "enable只能为0或1")
    private String            enable;

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

}
