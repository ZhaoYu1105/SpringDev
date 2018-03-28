/**
 * @ dhome-device-bean
 * @ com.cmcc.dhome.app.device.bean.device
 * @ DeviceNicknameSetBo.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2017年7月15日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年7月15日 - 下午4:31:32
 * @history
 *          2017年7月15日 - 下午4:31:32 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class DeviceNicknameSetBo {

    private String nickname;
    @NotNull(message = "缺少参数deviceMac")
    @NotBlank(message = "deviceMac不能为空")
    private String deviceMac;
    private String sn;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

}
