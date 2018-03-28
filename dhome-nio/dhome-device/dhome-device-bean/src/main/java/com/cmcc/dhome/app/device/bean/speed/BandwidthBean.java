package com.cmcc.dhome.app.device.bean.speed;

/**
 * 华为提速/恢复 Request Bean
 * 
 * @author 蔡洁[caijie@chinamobile.com]
 * @date 2017年1月6日 - 下午2:04:47
 * @history
 *          2017年1月6日 - 下午2:04:47 蔡洁[caijie@chinamobile.com] create.
 */
public class BandwidthBean {
    private String sequenceNo;
    private String srcDeviceType = "aaa";// 发送消息端设备类型,指定为aaa
    private String srcDeviceId   = "1";  // 发送消息端设备ID,指定为1
    private String userIP        = "";
    private String loginName;
    private String templateName  = "";
    private String userPort      = "";
    private String sessionTimeout;
    private String valueAddedServiceID;
    private String expireTime;

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getSrcDeviceType() {
        return srcDeviceType;
    }

    public void setSrcDeviceType(String srcDeviceType) {
        this.srcDeviceType = srcDeviceType;
    }

    public String getSrcDeviceId() {
        return srcDeviceId;
    }

    public void setSrcDeviceId(String srcDeviceId) {
        this.srcDeviceId = srcDeviceId;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getUserPort() {
        return userPort;
    }

    public void setUserPort(String userPort) {
        this.userPort = userPort;
    }

    public String getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(String sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public String getValueAddedServiceID() {
        return valueAddedServiceID;
    }

    public void setValueAddedServiceID(String valueAddedServiceID) {
        this.valueAddedServiceID = valueAddedServiceID;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

}
