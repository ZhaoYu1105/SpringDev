package com.cmcc.dhome.app.device.bean.speed;

/**
 * 亚信提速/恢复 Request Bean
 * 
 * @author 蔡洁[caijie@chinamobile.com]
 * @date 2017年1月6日 - 下午2:06:46
 * @history
 *          2017年1月6日 - 下午2:06:46 蔡洁[caijie@chinamobile.com] create.
 */
public class QosBean {
    private String         accNbr;
    private String         area     = "0001";           // 本地网标识,不需区分默认为0001
    private String         policycode;
    private String         serverip = "218.205.115.242";// demo环境外网IP
    private String         spcode;
    private String         sppassword;
    private String         times;
    private String         type     = "0";              // 调用方式,0:同步方式,1:异步方式
    private QosInnerBean[] userinfos;

    public String getAccNbr() {
        return accNbr;
    }

    public void setAccNbr(String accNbr) {
        this.accNbr = accNbr;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPolicycode() {
        return policycode;
    }

    public void setPolicycode(String policycode) {
        this.policycode = policycode;
    }

    public String getServerip() {
        return serverip;
    }

    public void setServerip(String serverip) {
        this.serverip = serverip;
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

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public QosInnerBean[] getUserinfos() {
        return userinfos;
    }

    public void setUserinfos(QosInnerBean[] userinfos) {
        this.userinfos = userinfos;
    }
}
