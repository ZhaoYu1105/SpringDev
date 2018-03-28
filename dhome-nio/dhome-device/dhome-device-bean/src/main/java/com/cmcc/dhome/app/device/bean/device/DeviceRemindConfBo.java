/**
 * @ dhome-device-bean
 * @ com.cmcc.dhome.app.device.bean.device
 * @ DeviceRemindConfBo.java
 * 
 * @author 杨丽[yanglizd@chinamobile.com] 2016年6月27日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author 杨丽[yanglizd@chinamobile.com]
 * @date 2016年6月27日 - 下午2:41:33
 * @history
 *          2016年6月27日 - 下午2:41:33 杨丽[yanglizd@chinamobile.com] create.
 */
public class DeviceRemindConfBo {
    private String userId;
    private String did;
    @NotNull(message = "缺少参数seqId")
    @Pattern(regexp = "[a-fA-F0-9]{8}", message = "seqId必须为8位16进制")
    private String seqId;
    @NotNull(message = "缺少参数enable")
    @Pattern(regexp = "[0-2]", message = "enable只能设置为0、1或者2")
    private String enable;
    @NotNull(message = "缺少参数devMac")
    @NotBlank(message = "devMac不能为空")
    private String devMac;

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

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getDevMac() {
        return devMac;
    }

    public void setDevMac(String devMac) {
        this.devMac = devMac;
    }
}
