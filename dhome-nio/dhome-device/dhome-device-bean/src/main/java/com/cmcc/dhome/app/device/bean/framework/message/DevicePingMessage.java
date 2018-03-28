/**
 * @ platform-plugin-framework
 * @ com.cmcc.dhome.device.server.framework.pojo
 * @ DeviceMessage.java
 * 
 * @author liujianliang@chinamobile.com 2016年5月4日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.framework.message;

import com.cmcc.dhome.app.device.bean.framework.common.DeviceMessageType;

/**
 * 插件消息对象，封装插件消息通用部分
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年5月4日 - 下午4:44:42
 * @history
 *          2016年5月4日 - 下午4:44:42 liujianliang@chinamobile.com create.
 */
public class DevicePingMessage extends DeviceBaseMessage {
    /**
     * 
     */
    private static final long serialVersionUID = -1810145854146698838L;

    public DevicePingMessage() {
        super();
        setMsgType(DeviceMessageType.PING);
    }

    /**
     * 构造一个到指定网关gwid的心跳ping消息
     * 
     * @param did
     *            网关ID
     * @return 心跳ping消息
     * @author liujianliang@chinamobile.com
     * @date 2016年5月6日 - 下午4:14:00
     * @history
     *          2016年5月6日 - 下午4:14:00 liujianliang@chinamobile.com create.
     */
    public static DevicePingMessage newPluginPingMessage(String did, String sn) {
        DevicePingMessage pingMessage = new DevicePingMessage();
        pingMessage.setDid(did);
        pingMessage.setSn(sn);
        return pingMessage;
    }
}
