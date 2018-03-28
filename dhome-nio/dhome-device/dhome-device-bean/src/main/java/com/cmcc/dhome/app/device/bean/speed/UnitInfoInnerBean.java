package com.cmcc.dhome.app.device.bean.speed;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 亚信获取初始带宽——内部 Request Bean
 * 
 * @author 蔡洁[caijie@chinamobile.com]
 * @date 2017年1月6日 - 下午2:12:31
 * @history
 *          2017年1月6日 - 下午2:12:31 蔡洁[caijie@chinamobile.com] create.
 */
public class UnitInfoInnerBean {
    @XStreamAlias("oper_id")
    private String operId;
    private String spcode;
    private String sppassword;
    @XStreamAlias("acct_ip")
    private String acctIp   = "";
    private String username;
    @XStreamAlias("user_port")
    private String userPort = "";

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public String getSpcode() {
        return spcode;
    }

    public void setSpcode(String spcode) {
        this.spcode = spcode;
    }

    public String getSppassword() {
        return sppassword;
    }

    public void setSppassword(String sppassword) {
        this.sppassword = sppassword;
    }

    public String getAcctIp() {
        return acctIp;
    }

    public void setAcctIp(String acctIp) {
        this.acctIp = acctIp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPort() {
        return userPort;
    }

    public void setUserPort(String userPort) {
        this.userPort = userPort;
    }
}
