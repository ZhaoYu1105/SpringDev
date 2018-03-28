/**
 * @ dhome-device-bean
 * @ com.cmcc.dhome.app.device.bean.enums
 * @ OsgiNameType.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年10月13日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.enums;

import java.util.HashMap;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年10月13日 - 上午11:36:53
 * @history
 *          2016年10月13日 - 上午11:36:53 徐海涛[xuhaitao@chinamobile.com] create.
 */
public enum OsgiNameType {

    WifiConfig("WifiConfig", "default"),

    HgSystem("HgSystem", "default"),

    LanDeviceConfig("LanDeviceConfig", "default"),

    Health("health", "default"),

    NetControl("netControl", "extend01"),

    SmartNet("smartNet", "default"),

    GuestWifi("guestWifi", "extend01"),

    Detection("detection", "extend01"),

    Reboot("reboot", "extend01"),

    Control("control", "extend01"),

    Feature("Feature", "extend01"), Accelerate("accelerate", "extend01");

    private String                               reqCode;
    private String                               reqType;

    private static HashMap<String, OsgiNameType> items;

    /**
     * 构造函数
     * 
     * @param reqCode
     *            reqCode
     * @param reqType
     *            reqCode
     */
    OsgiNameType(String reqCode, String reqType) {
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
    private static void putItem(OsgiNameType item) {
        if (items == null) {
            items = new HashMap<String, OsgiNameType>();
        }
        items.put(item.getReqCode(), item);
    }

    /**
     * 根据code返回类型
     * 
     * @param reqCode
     *            reqCode
     * @return 对应code的reqType
     * @author zhuqun[zhuqun@chinamobile.com]
     * @date 2016年3月5日 - 下午4:29:32
     * @history
     *          2016年3月5日 - 下午4:29:32 zhuqun[zhuqun@chinamobile.com] create.
     */
    public static String getByCode(String reqCode) {
        if (items.containsKey(reqCode)) {
            return items.get(reqCode).getReqType();
        } else {
            return null;
        }
    }

}
