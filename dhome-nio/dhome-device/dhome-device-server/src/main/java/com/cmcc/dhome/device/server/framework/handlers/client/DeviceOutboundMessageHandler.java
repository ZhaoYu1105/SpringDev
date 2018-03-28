/**
 * @ platform-plugin-framework
 * @ com.cmcc.dhome.device.server.framework.handlers.client
 * @ DeviceOutboundMessageHandler.java
 * 
 * @author liujianliang@chinamobile.com 2016年5月3日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.device.server.framework.handlers.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmcc.dhome.app.device.bean.framework.message.DeviceMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceRequestMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceResponseMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年5月3日 - 上午11:24:15
 * @history
 *          2016年5月3日 - 上午11:24:15 liujianliang@chinamobile.com create.
 */
public class DeviceOutboundMessageHandler extends SimpleChannelInboundHandler<DeviceMessage> {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DeviceMessage msg) throws Exception {
        log.info("！！！开始对消息进行回复处理：{}", msg);
        if (msg instanceof DeviceRequestMessage) {
//            String pluginName = msg.getPluginName();
//            String cmdType = msg.getMethod();
            DeviceResponseMessage resMsg = null;
//            if ("WifiConfig".equals(pluginName) && "SET_WIFI_SSID_INFO".equals(cmdType)) {
//                resMsg = ((DeviceRequestMessage) msg).toResponseMessage();
//                resMsg.setResult("1000000");
//            }
            resMsg = ((DeviceRequestMessage) msg).toResponseMessage();
            resMsg.setResult("1000000");
            ctx.writeAndFlush(resMsg);
        } else if (msg instanceof DeviceResponseMessage) {
            DeviceResponseMessage response = (DeviceResponseMessage) msg;
            log.debug(response.getResult());
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
