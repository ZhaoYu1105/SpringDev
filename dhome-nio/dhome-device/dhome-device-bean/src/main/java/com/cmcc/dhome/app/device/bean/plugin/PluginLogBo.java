package com.cmcc.dhome.app.device.bean.plugin;

import java.io.Serializable;

/**
 * 插件操作记录
 * 
 * @author chenxian@chinamobile.com
 * @date 2016年5月30日 - 下午4:35:07
 * @history
 *          2016年5月30日 - 下午4:35:07 chenxian@chinamobile.com create.
 */
public class PluginLogBo implements Serializable {

    private static final long serialVersionUID = -7944447026465899428L;

    private String            passid;
    private String            pluginId;
    private String            gatewayId;
    private String            reqType;

    public String getPassid() {
        return passid;
    }

    public void setPassid(String passid) {
        this.passid = passid;
    }

    public String getPluginId() {
        return pluginId;
    }

    public void setPluginId(String pluginId) {
        this.pluginId = pluginId;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }
}
