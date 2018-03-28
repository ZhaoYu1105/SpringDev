/**
 * @ platform-base-bean
 * @ com.cmcc.zeus.base.bean.bo
 * @ DeviceRemindSetBo.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年5月5日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.cmcc.zeus.base.utils.StringUtil;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年5月5日 - 下午3:22:01
 * @history
 *          2016年5月5日 - 下午3:22:01 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class DeviceRemindSetBo {

    private String userId;
    private String did;
    private String sn;
    private String id;

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = this.did + "_" + StringUtil.toUpper(this.mac);
    }

    @NotNull(message = "缺少参数mac")
    @NotBlank(message = "mac不能为空")
    private String mac;
    @NotNull(message = "缺少参数enable")
    @Pattern(regexp = "[0-2]", message = "enable只能设置为0,1或2")
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

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

}
