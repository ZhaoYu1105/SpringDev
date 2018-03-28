/**
 * @ dhome-device-bean
 * @ com.cmcc.dhome.app.device.bean.user
 * @ UserBindInfoBO.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2017年3月21日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.user;

import com.cmcc.zeus.base.core.BaseBo;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年3月21日 - 上午9:39:21
 * @history 
 * 		 2017年3月21日 - 上午9:39:21 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class UserBindInfoBo extends BaseBo{

    /**
     * 
     */
    private static final long serialVersionUID = 3016173670708278738L;
    
    private String phone;
    private String mac;
    private String sn;
    private String userId;
    
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
}
