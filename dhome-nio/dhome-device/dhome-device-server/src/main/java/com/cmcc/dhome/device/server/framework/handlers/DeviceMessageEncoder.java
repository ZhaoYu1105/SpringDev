/**
 * @ platform-plugin-framework
 * @ com.cmcc.dhome.device.server.framework.handlers
 * @ DeviceMessageDecoder.java
 * 
 * @author liujianliang@chinamobile.com 2016年5月4日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.device.server.framework.handlers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceBaseMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

/**
 * 插件消息编码
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年5月4日 - 下午4:27:58
 * @history
 *          2016年5月4日 - 下午4:27:58 liujianliang@chinamobile.com create.
 */
public class DeviceMessageEncoder extends MessageToMessageEncoder<DeviceBaseMessage> {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * io.netty.handler.codec.MessageToMessageEncoder#encode(io.netty.channel.
     * ChannelHandlerContext, java.lang.Object, java.util.List)
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, DeviceBaseMessage msg, List<Object> out) throws Exception {
        String json = JSONObject.toJSONString(msg);
        out.add(json);
        log.debug("Encode msg: {}", json);
    }

}
