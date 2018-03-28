/**
 * @ dhome-device-bean
 * @ com.cmcc.dhome.app.device.bean.device
 * @ GatewayNameBo.java
 * 
 * @author 杨丽[yanglizd@chinamobile.com] 2016年7月18日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author 杨丽[yanglizd@chinamobile.com]
 * @date 2016年7月18日 - 上午10:51:34
 * @history
 *          2016年7月18日 - 上午10:51:34 杨丽[yanglizd@chinamobile.com] create.
 */
public class GatewayNameBo {
    private String userId;
    private String did;
    @NotNull(message = "缺少参数seqId")
    @Pattern(regexp = "[a-fA-F0-9]{8}", message = "seqId必须为8位16进制")
    private String seqId;
    @NotNull(message = "缺少参数name")
    @NotBlank(message = "name不能为空")
    @Length(max = 128)
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
