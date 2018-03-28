package com.cmcc.dhome.app.device.bean.plugin;

/**
 * 从用户子系统获取的已安装的插件列表
 * 
 * @author 李露[lilu@chinamobile.com]
 * @date 2016年6月20日 - 下午12:18:31
 * @history
 *          2016年6月20日 - 下午12:18:31 李露[lilu@chinamobile.com] create.
 */
public class PluginInstalledList {
    private String pluginId;
    private String gatewayId;
    private String status;
    private String updateTime;
    private int    ops;

    public int getOps() {
        return ops;
    }

    public void setOps(int ops) {
        this.ops = ops;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}
