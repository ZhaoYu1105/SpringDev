/**
 * @ platform-base-bean
 * @ com.cmcc.zeus.base.bean.bo
 * @ DeviceControlBo.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年3月30日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年3月30日 - 上午9:41:35
 * @history
 *          2016年3月30日 - 上午9:41:35 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class DeviceControlBo {

    private String userId;
    private String did;
    @NotNull(message = "缺少参数seqId")
    @Pattern(regexp = "[a-fA-F0-9]{8}", message = "seqId必须为8位16进制")
    private String seqId;
    @NotNull(message = "缺少参数mac")
    @NotBlank(message = "devMAC不能为空")
    private String devMAC;
    @NotNull(message = "缺少参数netAccessRight")
    @Pattern(regexp = "^ON|OFF$", message = "netAccessRight只能设置为ON或OFF")
    private String netAccessRight;

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

    public String getNetAccessRight() {
        return netAccessRight;
    }

    public void setNetAccessRight(String netAccessRight) {
        this.netAccessRight = netAccessRight;
    }

    public String getDevMAC() {
        return devMAC;
    }

    public void setDevMAC(String devMAC) {
        this.devMAC = devMAC;
    }

}
