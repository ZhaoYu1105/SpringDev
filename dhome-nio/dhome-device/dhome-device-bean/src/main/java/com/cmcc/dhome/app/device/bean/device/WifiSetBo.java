/**
 * @ platform-base-bean
 * @ com.cmcc.zeus.base.bean.bo
 * @ WifiSetBo.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年3月29日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年3月29日 - 下午7:38:42
 * @history
 *          2016年3月29日 - 下午7:38:42 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class WifiSetBo {

    private String userId;
    private String did;
    private String sn;
    @NotNull(message = "缺少参数seqId")
    @Pattern(regexp = "[a-fA-F0-9]{8}", message = "seqId必须为8位16进制")
    private String seqId;
    @NotNull(message = "缺少参数ssidIndex")
    @Pattern(regexp = "[1-8]", message = "超出ssidIndex取值范围")
    private String ssidIndex;
    @NotNull(message = "缺少参数ssid")
    @NotBlank(message = "ssid不能为空")
    private String ssid;
    private String pwd;
    @NotNull(message = "缺少参数encrypt")
    @Pattern(regexp = "[0-5]", message = "超出encrypt取值范围")
    private String encrypt;
    @NotNull(message = "缺少参数powerLevel")
    @NotBlank(message = "powerLevel不能为空")
    private String powerLevel;
    @NotNull(message = "缺少参数guest")
    @Pattern(regexp = "[0-1]", message = "guest只能设置为0或1")
    private String guest;
    @NotNull(message = "缺少参数hidden")
    @Pattern(regexp = "[0-1]", message = "hidden只能设置为0或1")
    private String hidden;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

    public String getSsidIndex() {
        return ssidIndex;
    }

    public void setSsidIndex(String ssidIndex) {
        this.ssidIndex = ssidIndex;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(String powerLevel) {
        this.powerLevel = powerLevel;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

}
