package com.cmcc.dhome.app.device.bean.plugin;

/**
 * 插件列表
 * 
 * @author 李露[lilu@chinamobile.com]
 * @date 2016年6月20日 - 下午12:19:11
 * @history
 *          2016年6月20日 - 下午12:19:11 李露[lilu@chinamobile.com] create.
 */
public class PluginList {
    private String pluginId;      // 插件ID
    private String pluginName;    // 插件名称
    private String description;   // 插件描述
    private String vendor;        // 生产厂家
    private int    pluginType;    // 插件类型,1:智能硬件，2：非智能硬件
    private Object icon;          // 插件图标
    private String currentVersion;// 当前版本
    private String createTime;    // 创建时间
    private String gwType;        // 网关类型
    private String appType;       // 客户端类型
    private String gwUrl;         // 网管地址
    private String appUrl;        // 客户端地址
    private String appExtraParam; // 附加参数。用逗号隔开
    private String installLoc;    // 1表示仅安装在客户端，2表示网关客户端都安装，3表示仅安装在网关，若为1则gw开头的字段都无意义，若为3则app开头的字段都无意义
    private int    area;          // 所在省份
    private String status;        // 启用用"on"表示，停用用"off"表示
    private int    isInstall;     // 是否安装(1已安装，0未安装)
    // private int ops; // 操作者

    public int getPluginType() {
        return pluginType;
    }

    public void setPluginType(int pluginType) {
        this.pluginType = pluginType;
    }

    public String getPluginId() {
        return pluginId;
    }

    public void setPluginId(String pluginId) {
        this.pluginId = pluginId;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Object getIcon() {
        return icon;
    }

    public void setIcon(Object icon) {
        this.icon = icon;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getGwType() {
        return gwType;
    }

    public void setGwType(String gwType) {
        this.gwType = gwType;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getGwUrl() {
        return gwUrl;
    }

    public void setGwUrl(String gwUrl) {
        this.gwUrl = gwUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getAppExtraParam() {
        return appExtraParam;
    }

    public void setAppExtraParam(String appExtraParam) {
        this.appExtraParam = appExtraParam;
    }

    public String getInstallLoc() {
        return installLoc;
    }

    public void setInstallLoc(String installLoc) {
        this.installLoc = installLoc;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIsInstall() {
        return isInstall;
    }

    public void setIsInstall(int isInstall) {
        this.isInstall = isInstall;
    }
}
