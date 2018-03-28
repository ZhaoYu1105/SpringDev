package com.cmcc.dhome.app.device.bean.device;

import java.io.Serializable;
import java.util.Date;

/**
 * 共享网关
 * 
 * @author 杨丽[yanglizd@chinamobile.com]
 * @date 2017年9月6日 - 下午2:14:19
 * @history
 *          2017年9月6日 - 下午2:14:19 杨丽[yanglizd@chinamobile.com] create.
 */
public class GatewayShareBo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String            mac;

    private String            userId;

    private String            phone;
    private byte              role;
    private Date              date;
    private String            sn;
    private String            shareTime;
    private byte              isDuplicate;

    public String getShareTime() {
        return shareTime;
    }

    public void setShareTime(String shareTime) {
        this.shareTime = shareTime;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte getRole() {
        return role;
    }

    public void setRole(byte role) {
        this.role = role;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte getIsDuplicate() {
        return isDuplicate;
    }

    public void setIsDuplicate(byte isDuplicate) {
        this.isDuplicate = isDuplicate;
    }

}
