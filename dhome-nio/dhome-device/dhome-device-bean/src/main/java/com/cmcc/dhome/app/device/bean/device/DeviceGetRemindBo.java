package com.cmcc.dhome.app.device.bean.device;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 获取设备上线提醒状态（到网关）
 * 
 * @author 李露[lilu@chinamobile.com]
 * @date 2016年6月27日 - 下午2:08:34
 * @history
 *          2016年6月27日 - 下午2:08:34 李露[lilu@chinamobile.com] create.
 */
public class DeviceGetRemindBo {
    private String userId;
    private String did;
    @NotNull(message = "缺少参数seqId")
    @Pattern(regexp = "[a-fA-F0-9]{8}", message = "seqId必须为8位16进制")
    private String seqId;

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

}
