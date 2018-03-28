package com.cmcc.dhome.app.device.bean.device;

import java.io.Serializable;

/**
 * 
 * 
 * @author lilu@chinamobile.com
 * @date 2017年4月12日 - 上午11:09:45
 * @history
 *          2017年4月12日 - 上午11:09:45 lilu@chinamobile.com create.
 */
public class GateWayBindBo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -521934322355637930L;

    private String            passid;
    private String            roleFlag;
    private String            mac;
    private String            gatewayBindStatus;
    private String            gatewayBindTime;
    private String            sn;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getGatewayBindStatus() {
        return gatewayBindStatus;
    }

    public void setGatewayBindStatus(String gatewayBindStatus) {
        this.gatewayBindStatus = gatewayBindStatus;
    }

    public String getGatewayBindTime() {
        return gatewayBindTime;
    }

    public void setGatewayBindTime(String gatewayBindTime) {
        this.gatewayBindTime = gatewayBindTime;
    }

    public String getPassid() {
        return passid;
    }

    public void setPassid(String passid) {
        this.passid = passid;
    }

    public String getRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(String roleFlag) {
        this.roleFlag = roleFlag;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

}
