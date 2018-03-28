/**
 * @ platform-base-bean
 * @ com.cmcc.zeus.base.bean.bo
 * @ WifiSwitchBo.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年3月29日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年3月29日 - 下午7:27:58
 * @history
 *          2016年3月29日 - 下午7:27:58 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class WifiSwitchBo {

    private String userId;
    private String did;
    private String sn;
    @NotNull(message = "缺少参数seqId")
    @Pattern(regexp = "[a-fA-F0-9]{8}", message = "seqId必须为8位16进制")
    private String seqId;
    @NotNull(message = "缺少参数ssidIndex")
    @Pattern(regexp = "[1-8]", message = "超出ssidIndex取值范围")
    private String ssidIndex;
    @NotNull(message = "缺少参数enable")
    @Pattern(regexp = "[0-1]", message = "enable只能设置为0或1")
    private String enable;

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

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

}
