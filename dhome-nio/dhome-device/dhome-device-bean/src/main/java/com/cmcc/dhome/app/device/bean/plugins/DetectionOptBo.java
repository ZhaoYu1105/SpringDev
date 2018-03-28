package com.cmcc.dhome.app.device.bean.plugins;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.cmcc.zeus.base.core.BaseBo;

/**
 * 一键体检优化参数BO
 * 
 * @author 陈向君[chenxiangjun@chinamobile.com]
 * @date 2016年11月14日 - 上午11:41:34
 * @history
 *          2016年11月14日 - 上午11:41:34 陈向君[chenxiangjun@chinamobile.com] create.
 */
public class DetectionOptBo extends BaseBo {

    private static final long serialVersionUID = -1135149592874132121L;

    @NotNull(message = "缺少参数optId")
    @NotBlank(message = "optId不能为空")
    @Pattern(regexp = "^[1-9][0-9]*", message = "optId只能包含数字")
    private String            optId;
    @NotNull(message = "缺少参数actionId")
    @NotBlank(message = "actionId不能为空")
    @Pattern(regexp = "[0-9]{10}", message = "actionId需为10位数字")
    private String            actionId;
    @NotNull(message = "缺少参数enable")
    @NotBlank(message = "enable不能为空")
    @Pattern(regexp = "[0,1]", message = "enable只能为0或1")
    private String            enable;

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

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
