/**
 * @ platform-base-bean
 * @ com.cmcc.zeus.base.bean.enums
 * @ SubscribeType.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年3月11日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.enums;

import java.util.HashMap;

/**
 * 订阅消息类型的枚举
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年3月11日 - 下午2:15:51
 * @history
 *          2016年3月11日 - 下午2:15:51 徐海涛[xuhaitao@chinamobile.com] create.
 */
public enum SubscribeType {

    ONLINE_REMIND("1", "ReportDevOnline"),

    GATEWAY_SPEED("2", "ReportLanDevSpeed");

    private static HashMap<String, SubscribeType> items; // code、message

    /**
     * 构造函数
     * 
     * @param item
     *            map
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2016年3月11日 - 下午2:15:51
     * @history
     *          2016年3月11日 - 下午2:15:51 徐海涛[xuhaitao@chinamobile.com] create.
     */
    private static void putItem(SubscribeType item) {
        if (items == null) {
            items = new HashMap<String, SubscribeType>();
        }
        items.put(item.getCode(), item);
    }

    public static SubscribeType getByCode(String code) {
        if (items.containsKey(code)) {
            return items.get(code);
        }
        throw new IllegalArgumentException("无效的CodeType.code:" + code);
    }

    private final String code;
    private final String reqType;

    /**
     * 构造函数.
     * 
     * @param code
     *            code
     * @param reqType
     *            reqType
     */
    SubscribeType(String code, String reqType) {
        this.code = code;
        this.reqType = reqType;
        putItem(this);
    }

    public String getCode() {
        return code;
    }

    public String getReqType() {
        return reqType;
    }

    /**
     * 重写toString.
     * 
     * @return String
     */
    public String toString() {
        String str = String.format("%s(%s, %s)", this.name(), code, reqType);
        return str;
    }
}
