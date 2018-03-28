package com.cmcc.dhome.app.device.bean.speed;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 亚信提速/恢复——内部 Request Bean
 * 
 * @author 蔡洁[caijie@chinamobile.com]
 * @date 2017年1月6日 - 下午2:11:01
 * @history
 *          2017年1月6日 - 下午2:11:01 蔡洁[caijie@chinamobile.com] create.
 */
@XStreamAlias("userinfo")
public class QosInnerBean {
    private String userip   = "";
    private String username;
    private String userport = "";
    private String callingstationid;

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserport() {
        return userport;
    }

    public void setUserport(String userport) {
        this.userport = userport;
    }

    public String getCallingstationid() {
        return callingstationid;
    }

    public void setCallingstationid(String callingstationid) {
        this.callingstationid = callingstationid;
    }

}
