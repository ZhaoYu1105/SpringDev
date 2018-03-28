/**
 * @ platform-base-bean
 * @ com.cmcc.zeus.base.bean.bo
 * @ DeviceRemindGetBO.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年5月9日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.cmcc.zeus.base.utils.StringUtil;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年5月9日 - 上午10:48:38
 * @history
 *          2016年5月9日 - 上午10:48:38 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class DeviceRemindGetBo {

    private String userId;
    private String did;
    private String id;
    @NotNull(message = "缺少参数mac")
    @NotBlank(message = "mac不能为空")
    private String mac;
    private String sn;

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

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = this.did + "_" + StringUtil.toUpper(this.mac);
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

}
