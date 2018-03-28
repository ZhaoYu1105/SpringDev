package com.cmcc.dhome.app.device.bean.device;

import java.io.Serializable;
import java.util.Date;

/**
 * 网关绑定关系信息
 * 
 * @author 杨丽[yanglizd@chinamobile.com]
 * @date 2018年3月6日 - 下午5:00:58
 * @history
 *          2018年3月6日 - 下午5:00:58 杨丽[yanglizd@chinamobile.com] create.
 */
public class BindRelativeBo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String            phone;
    private String            mac;
    private String            sn;
    private int               flag;
    private Date              bindOrShareTime;

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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Date getBindOrShareTime() {
        return bindOrShareTime;
    }

    public void setBindOrShareTime(Date bindOrShareTime) {
        this.bindOrShareTime = bindOrShareTime;
    }

}
