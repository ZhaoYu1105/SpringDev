package com.cmcc.dhome.app.device.bean.device;

import java.io.Serializable;

/**
 * 上线设备异常
 * 
 * @author 杨丽[yanglizd@chinamobile.com]
 * @date 2017年9月15日 - 下午12:47:00
 * @history
 *          2017年9月15日 - 下午12:47:00 杨丽[yanglizd@chinamobile.com] create.
 */
public class DeviceExceptionBo implements Serializable {

    private static final long serialVersionUID = -442016326064204355L;
    private Long              id;

    private String            mac;

    private String            sn;

    private String            deviceMac;

    private Boolean           exception;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac == null ? null : deviceMac.trim();
    }

    public Boolean getException() {
        return exception;
    }

    public void setException(Boolean exception) {
        this.exception = exception;
    }

}
