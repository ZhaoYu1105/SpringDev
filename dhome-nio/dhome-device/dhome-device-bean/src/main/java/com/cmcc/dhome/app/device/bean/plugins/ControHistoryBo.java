/**
 * @ dhome-device-bean
 * @ com.cmcc.dhome.app.device.bean.plugins
 * @ ControHistoryBo.java
 * 
 * @author  chenzhongya[chenzhongya@cmhi.chinamobile.com] 2017年10月12日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.plugins;

import java.util.Date;

/**
 * 响应信息实体类
 * 
 * @author chenzhongya[chenzhongya@cmhi.chinamobile.com]
 * @date 2017年10月12日 - 下午5:50:11
 * @history
 *          2017年10月12日 - 下午5:50:11
 *          chenzhongya[chenzhongya@cmhi.chinamobile.com] create.
 */
public class ControHistoryBo {

    private static final long serialVersionUID = 6036677654296344163L;
    private String            deviceMac;
    private String            devicename;
    private String            nickname;
    private String            icon;
    private String            deviceType;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    private Date date;

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
