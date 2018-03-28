/**
 * @ platform-base-bean
 * @ com.cmcc.zeus.base.bean.bo
 * @ DeviceRemindBo.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年3月30日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年3月30日 - 上午9:25:43
 * @history
 *          2016年3月30日 - 上午9:25:43 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class DeviceRemindBo {

    private String userId;
    private String did;
    @NotNull(message = "缺少参数seqId")
    @Pattern(regexp = "[a-fA-F0-9]{8}", message = "seqId必须为8位16进制")
    private String seqId;
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

}
