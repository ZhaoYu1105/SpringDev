package com.cmcc.dhome.app.device.bean.speed;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 华为获取初始带宽 Request Bean
 * 
 * @author 蔡洁[caijie@chinamobile.com]
 * @date 2017年1月6日 - 下午2:07:16
 * @history
 *          2017年1月6日 - 下午2:07:16 蔡洁[caijie@chinamobile.com] create.
 */
@XStreamAlias("queryOrderBean")
public class QueryOrderBean {
    private String version   = "01"; // 当前版本号默认为01
    private String servtype  = "1";  // 业务类型,1:WLAN注册帐户,2:WLAN临时帐户
    private String reqtype   = "112";// 请求的业务操作类型,指定为112
    private String sequence;
    private String priority  = "00"; // 请求优先级,指定为00
    private String reqtime;
    private String continued = "0";  // 是否还有后续包,0:没有,1:有
    @XStreamAlias("user_name")
    private String userName;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServtype() {
        return servtype;
    }

    public void setServtype(String servtype) {
        this.servtype = servtype;
    }

    public String getReqtype() {
        return reqtype;
    }

    public void setReqtype(String reqtype) {
        this.reqtype = reqtype;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getReqtime() {
        return reqtime;
    }

    public void setReqtime(String reqtime) {
        this.reqtime = reqtime;
    }

    public String getContinued() {
        return continued;
    }

    public void setContinued(String continued) {
        this.continued = continued;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
