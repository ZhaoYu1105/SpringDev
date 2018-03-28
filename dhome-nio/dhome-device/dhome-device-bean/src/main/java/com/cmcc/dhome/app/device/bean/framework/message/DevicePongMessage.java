/**
 * @ platform-plugin-framework
 * @ com.cmcc.dhome.device.server.framework.pojo
 * @ DeviceMessage.java
 * 
 * @author liujianliang@chinamobile.com 2016年5月4日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.framework.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.cmcc.dhome.app.device.bean.framework.common.DeviceMessageType;

/**
 * 插件消息对象，封装插件消息通用部分
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年5月4日 - 下午4:44:42
 * @history
 *          2016年5月4日 - 下午4:44:42 liujianliang@chinamobile.com create.
 */
public class DevicePongMessage extends DeviceBaseMessage {
    /**
     * 
     */
    private static final long serialVersionUID = -1810145854146698838L;
    
    @JSONField(name = "Parameter")
    private String param = "60";//心跳间隔时间，默认60秒

    public DevicePongMessage() {
        super();
        setMsgType(DeviceMessageType.PONG);
    }

    /**
     * 构造一个到指定网关gwid的心跳pong消息
     * 
     * @param did
     *            网关ID
     * @param osgiName
     *            插件类型
     * @param time
     *            心跳间隔时间
     * @return 心跳pong消息
     * @author liujianliang@chinamobile.com
     * @date 2016年5月6日 - 下午4:14:00
     * @history
     *          2016年5月6日 - 下午4:14:00 liujianliang@chinamobile.com create.
     */
    public static DevicePongMessage newPluginPongMessage(String did, String osgiName, String sn, String time) {
        DevicePongMessage pongMessage = new DevicePongMessage();
        pongMessage.setDid(did);
        pongMessage.setOsgiName(osgiName);
        pongMessage.setSn(sn);
        pongMessage.setParam(time);
        return pongMessage;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
