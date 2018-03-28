/**
 * 10086.cn Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * 
 * @author lilu@chinamobile.com
 * @date 2017年4月20日 - 下午3:22:11
 * @history
 *          2017年4月20日 - 下午3:22:11 lilu@chinamobile.com create.
 */
public class ActiveGatewaysBo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7614638278443337016L;

    private Long              gid;
    private String            mac;
    @JsonProperty(value = "broadbandaccount")
    private String            broadBandAccount;
    private String            sn;
    private Date              createTime;
    private Date              updateTime;
    private int               status;
    private String            provinceCode;
    private String            phoneNumber;
    private String            nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getBroadBandAccount() {
        return broadBandAccount;
    }

    public void setBroadBandAccount(String broadBandAccount) {
        this.broadBandAccount = broadBandAccount;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
