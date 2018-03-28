package com.cmcc.dhome.app.device.bean.device;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 配置设备上报策略
 * 
 * @author 李露[lilu@chinamobile.com]
 * @date 2016年6月23日 - 下午3:50:56
 * @history
 *          2016年6月23日 - 下午3:50:56 李露[lilu@chinamobile.com] create.
 */
public class LanDeviceConfigBo {
    @NotNull(message = "缺少参数seqId")
    @Pattern(regexp = "[a-fA-F0-9]{8}", message = "seqId必须为8位16进制")
    private String seqId;
    private String userId;
    private String did;
    @NotNull(message = "缺少参数enable")
    @Pattern(regexp = "[0-1]", message = "enable只能设置为0或1")
    private String enable;
    @NotNull(message = "缺少参数seqId")
    private String time;

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

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

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
