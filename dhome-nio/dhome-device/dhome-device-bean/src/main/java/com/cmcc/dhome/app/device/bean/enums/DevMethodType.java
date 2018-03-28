/**
 * @ platform-base-bean
 * @ com.cmcc.zeus.base.bean.enums
 * @ DevMethodType.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年3月21日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.enums;

import java.util.HashMap;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年3月21日 - 下午3:42:18
 * @history
 *          2016年3月21日 - 下午3:42:18 徐海涛[xuhaitao@chinamobile.com] create.
 */
public enum DevMethodType {

    WIFI_LIST("Get", "GET_WIFI_SSID_INFO", "GetSSIDInfo", "wifiList"), WIFI_SWITCH("Set", "SET_WIFI_SSID_ONOFF", "SSIDOnOff", "wifiEnable"), WIFI_SET("Set",
            "SET_WIFI_SSID_INFO", "SetSSIDInfo", "wifiConf"), DEVICE_LIST("Get", "GET_LAN_NET_INFO", "GetLanNetInfo", "deviceList"), ONLINE_REMIND("Set",
                    "SET_LAN_DEVICE_ONLINE", "SetLanDevOnline", "deviceOLRemindConf"), NET_CONTROL("Set", "SET_LAN_ACCESS", "SetLanAccess",
                            "deviceNetAccessCtrl"), SPEED_REPORT("Set", "SET_LAN_SPEED_REPORT_POLICY", "SetReportPolicy", "deviceSpeedReportConf"), GET_SPEED(
                                    "Get", "GET_LAN_SPEED_REPORT_POLICY", "GetReportPolicy", "deviceSpeedReportGet"), MESSAGE("Report",
                                            "REPORT_LAN_DEVICE_ONLINE", "ReportDevOnline", "msg"), REFRESH("Report", "REFRESH", "", "refresh"), GEATEWAY_SPEED(
                                                    "Report", "REPORT_LAN_DEVICE_SPEED", "ReportLanDevSpeed", "gatewaySpeed"), SET_HG_REBOOT("set",
                                                            "SET_HG_REBOOT", "HGReboot", "restartCenter"), GET_REMIND("Get", "GET_LAN_DEVICE_ONLINE",
                                                                    "GetLanDevOnline", "deviceOLRemindGet"), SET_HG_NAME("Set", "SET_HG_NAME", "HGRename",
                                                                            "renameGateway"), ACCRESS("report", "increase", "increase", "deviceMsg_refresh");

    private static HashMap<String, DevMethodType> items;

    private final String                          rpcMethod;
    private final String                          cmdType;
    private final String                          actionId;
    private final String                          reqType;

    /**
     * 构造函数
     */
    private DevMethodType(String rpcMethod, String cmdType, String actionId, String reqType) {
        this.rpcMethod = rpcMethod;
        this.cmdType = cmdType;
        this.actionId = actionId;
        this.reqType = reqType;
        putItem(this);
    }

    private static void putItem(DevMethodType item) {
        if (items == null) {
            items = new HashMap<String, DevMethodType>();
        }
        items.put(item.cmdType, item);
    }

    /**
     * 根据cmdType返回reqType
     * 
     * @param cmdType
     *            cmdType
     * @return 对应的reqType
     * @author zhuqun[zhuqun@chinamobile.com]
     * @date 2016年3月5日 - 下午4:29:32
     * @history
     *          2016年3月5日 - 下午4:29:32 zhuqun[zhuqun@chinamobile.com] create.
     */
    public static String getByCmd(String cmdType) {
        if (items.containsKey(cmdType)) {
            return items.get(cmdType).getReqType();
        }
        throw new IllegalArgumentException("无效的cmdType:" + cmdType);
    }

    public String getRpcMethod() {
        return rpcMethod;
    }

    public String getCmdType() {
        return cmdType;
    }

    public String getActionId() {
        return actionId;
    }

    public String getReqType() {
        return reqType;
    }

}
