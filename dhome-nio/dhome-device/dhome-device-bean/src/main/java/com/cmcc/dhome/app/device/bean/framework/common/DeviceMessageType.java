/**
 * @ platform-base-core
 * @ com.cmcc.dhome.core.plugin
 * @ DeviceMessageType.java
 * 
 * @author liujianliang@chinamobile.com 2016年5月4日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.framework.common;

/**
 * 插件消息类型，主要有5类：ping, pong, request, response, report
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年5月4日 - 下午7:43:52
 * @history
 *          2016年5月4日 - 下午7:43:52 liujianliang@chinamobile.com create.
 */
public enum DeviceMessageType {
    PING("ping"), PONG("pong"), REQUEST("request"), RESPONSE("response"), REPORT("report");

    private String value;

    /**
     * 消息类型
     */
    private DeviceMessageType(String value) {
        this.value = value;
    }

    /**
     * 获取消息类型
     * 
     * @return 消息类型
     * @author liujianliang@chinamobile.com
     * @date 2016年5月4日 - 下午8:03:32
     * @history
     *          2016年5月4日 - 下午8:03:32 liujianliang@chinamobile.com create.
     */
    public String getValue() {
        return value;
    }
}
