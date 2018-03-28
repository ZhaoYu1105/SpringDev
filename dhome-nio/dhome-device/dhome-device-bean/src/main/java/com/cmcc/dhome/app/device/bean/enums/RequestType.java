package com.cmcc.dhome.app.device.bean.enums;

import java.util.HashMap;

/**
 * 请求类型枚举类
 * 
 * @author zhuqun[zhuqun@chinamobile.com]
 * @date 2016年3月5日 - 下午4:27:30
 * @history
 *          2016年3月5日 - 下午4:27:30 zhuqun[zhuqun@chinamobile.com] create.
 */
public enum RequestType {

    WIFI_LIST("1001", "wifiList"), WIFI_ENABLE("1002", "wifiEnable"), WIFI_CONF("1003", "wifiConf"), DEVICE_LIST("2001",
            "deviceList"), DEVICE_ONLINE_REMIND_CONF("2002", "deviceOLRemindConf"), DEVICE_NET_ACCESS_CONTROL("2003",
                    "deviceNetAccessCtrl"), DEVICE_SPEED_REPORT_CONF("2004", "deviceSpeedReportConf"), DEVICE_ONLINE_REMIND_GET("2005",
                            "deviceOLRemindGet"), MESSAGE("3001", "msg"), GEATEWAY_SPEED("4001", "gatewaySpeed"), GATEWAY_RESTART("4002",
                                    "restartCenter"), GATEWAY_RESET("4003", "resetCenter"), GATEWAY_MODIFYPWD("4004", "modifyPassword"), GATEWAY_RENAME("4005",
                                            "renameGateway"), PLUGIN_INSTALL("5001", "pluginInstall"), PLUGIN_UPDATE("5002", "pluginUpdate"), PLUGIN_UNINSTALL(
                                                    "5003", "pluginUninstall"), PLUGIN_STOP("5004", "pluginStop"), PLUGIN_START("5005",
                                                            "pluginStart"), PLUGIN_RESTORE("5006", "pluginRestore"), SYSTEMMSG_FAMILY("0101",
                                                                    "systemMsg_family"), SYSTEMMSG_PHOTO("0102", "systemMsg_photo"), DEVICEMSG_REMIND("0201",
                                                                            "deviceMsg_remind"), DEVICEMSG_BIND("0202", "deviceMsg_bind"), DEVICEMSG_UNBIND(
                                                                                    "0203", "deviceMsg_unbind"), DEVICEMSG_HEALTH_CHANGE("0204",
                                                                                            "deviceMsg_healthChange"), DEVICEMSG_HEALTH_CLOSE("0205",
                                                                                                    "deviceMsg_healthClose"), DEVICEMSG_WEEK_REPORT("0206",
                                                                                                            "deviceMsg_weekReport"), DEVICEMSG_MEDAL_GET("0207",
                                                                                                                    "deviceMsg_medalGet"), DEVICEMSG_OFFLINE_REMIND(
                                                                                                                            "0208",
                                                                                                                            "deviceMsg_offline"), DEVICEMSG_ONLINE_REFRESH(
                                                                                                                                    "0209",
                                                                                                                                    "deviceMsg_refresh"), DEVICEMSG_MEDAL_PUSH(
                                                                                                                                            "0210",
                                                                                                                                            "deviceMsg_medalGetPush"), DEVICEMSG_ONLINE_EXCEPTION(
                                                                                                                                                    "0211",
                                                                                                                                                    "deviceMsg_onlineException"), DEVICEMSG_ADD_GATEWAYSHARE(
                                                                                                                                                            "0212",
                                                                                                                                                            "deviceMsg_addGatewayShare"), DEVICEMSG_DEL_GATEWAYSHARE(
                                                                                                                                                                    "0213",
                                                                                                                                                                    "deviceMsg_delGatewayShare"), DEVICEMSG_EXIT_GATEWAYSHARE(
                                                                                                                                                                            "0214",
                                                                                                                                                                            "deviceMsg_exitGatewayShare"), DEVICEMSG_APPLYGATEWAYSHARE(
                                                                                                                                                                                    "0215",
                                                                                                                                                                                    "deviceMsg_applyGatewayShare"), DEVICEMSG_VERSIONREPORT(
                                                                                                                                                                                            "0216",
                                                                                                                                                                                            "deviceMsg_versionReport");
    private String                              reqCode;
    private String                              reqType;

    private static HashMap<String, RequestType> items;

    /**
     * 构造函数
     * 
     * @param reqCode
     *            reqCode
     * @param reqType
     *            reqCode
     */
    RequestType(String reqCode, String reqType) {
        this.reqCode = reqCode;
        this.reqType = reqType;
        putItem(this);
    }

    public String getReqCode() {
        return reqCode;
    }

    public void setReqCode(String reqCode) {
        this.reqCode = reqCode;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    /**
     * 请求类型Map
     * 
     * @param item
     *            item
     * @author zhuqun[zhuqun@chinamobile.com]
     * @date 2016年3月5日 - 下午4:28:50
     * @history
     *          2016年3月5日 - 下午4:28:50 zhuqun[zhuqun@chinamobile.com] create.
     */
    private static void putItem(RequestType item) {
        if (items == null) {
            items = new HashMap<String, RequestType>();
        }
        items.put(item.getReqCode(), item);
    }

    /**
     * 根据code返回类型
     * 
     * @param reqCode
     *            reqCode
     * @return 对应code的请求类型
     * @author zhuqun[zhuqun@chinamobile.com]
     * @date 2016年3月5日 - 下午4:29:32
     * @history
     *          2016年3月5日 - 下午4:29:32 zhuqun[zhuqun@chinamobile.com] create.
     */
    public static RequestType getByCode(String reqCode) {
        if (items.containsKey(reqCode)) {
            return items.get(reqCode);
        }
        throw new IllegalArgumentException("无效的RequestType.reqCode:" + reqCode);
    }

    /**
     * 重写toString.
     * 
     * @return String
     */
    @Override
    public String toString() {
        String str = String.format("%s(%s, %s)", this.name(), reqCode, reqType);
        return str;
    }

}
