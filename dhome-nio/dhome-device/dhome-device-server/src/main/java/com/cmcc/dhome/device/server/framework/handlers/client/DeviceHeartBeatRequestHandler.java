/**
 * @ platform-plugin-framework
 * @ com.cmcc.dhome.device.server.framework.handlers
 * @ DeviceAuthRequestHandler.java
 * 
 * @author liujianliang@chinamobile.com 2016年4月29日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.device.server.framework.handlers.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmcc.dhome.app.device.bean.framework.message.DevicePingMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DevicePongMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * 网关插件心跳
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年4月29日 - 上午9:39:48
 * @history
 *          2016年4月29日 - 上午9:39:48 liujianliang@chinamobile.com create.
 */
public class DeviceHeartBeatRequestHandler extends ChannelInboundHandlerAdapter {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private String gwid;
    private String sn;

    /**
     * @param mac
     */
    public DeviceHeartBeatRequestHandler(String gwid, String sn) {
        this.gwid = gwid;
        this.sn = sn;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case ALL_IDLE:
                    DevicePingMessage ping = DevicePingMessage.newPluginPingMessage(gwid, sn);
                    log.debug("网关[{}-{}]发送心跳ping到服务端[{}]...", gwid, sn, ctx.channel().remoteAddress());
                    ctx.writeAndFlush(ping);

                    // DeviceResponseMessage response = new
                    // DeviceResponseMessage();
                    // response.setDid("ABC12345");
                    // response.setPluginName("LanDeviceConfig");
                    // response.setMethod("GET_LAN_NET_INFO");
                    // response.setUserId("5757989027845");
                    // ctx.writeAndFlush(response);
                    // log.debug("网关{}的消息{}已发送至服务端",gwid ,response.getMethod());

                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof DevicePongMessage) {
            DevicePongMessage response = (DevicePongMessage) msg;
            log.debug("网关[{}]收到到服务端[{}]pong消息，连接正常!", response.getDid(), ctx.channel().remoteAddress());
        } else {
            ctx.fireChannelRead(msg);
        }
    }

}
