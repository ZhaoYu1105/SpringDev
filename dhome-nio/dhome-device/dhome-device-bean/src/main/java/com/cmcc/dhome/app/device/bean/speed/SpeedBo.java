package com.cmcc.dhome.app.device.bean.speed;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author 蔡洁[caijie@chinamobile.com]
 * @date 2016年12月2日 - 下午3:24:06
 * @history
 *          2016年12月2日 - 下午3:24:06 蔡洁[caijie@chinamobile.com] create.
 */
public class SpeedBo {
    @NotNull(message = "缺少参数account")
    @NotBlank(message = "缺少参数account")
    private String account;
    @NotNull(message = "缺少参数serviceId")
    @NotBlank(message = "缺少参数serviceId")
    @Pattern(regexp = "\\d+", message = "serviceId必须为数字")
    private String serviceId;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
