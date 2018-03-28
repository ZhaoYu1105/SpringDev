/**
 * @ platform-plugin-framework
 * @ com.cmcc.dhome.device.server.framework.handlers
 * @ DeviceAuthRequestHandler.java
 * 
 * @author liujianliang@chinamobile.com 2016年4月29日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.device.server.framework.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmcc.dhome.app.device.bean.framework.common.DeviceChannelMap;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceBaseMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DevicePingMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DevicePongMessage;
import com.cmcc.zeus.base.utils.StringUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

/**
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年4月29日 - 上午9:39:48
 * @history
 *          2016年4月29日 - 上午9:39:48 liujianliang@chinamobile.com create.
 */
public class DeviceHeartBeatResponseHandler extends SimpleChannelInboundHandler<DeviceBaseMessage> {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    /*
     * (non-Javadoc)
     * 
     * @see io.netty.channel.SimpleChannelInboundHandler#channelRead0(io.netty.
     * channel.ChannelHandlerContext, java.lang.Object)
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DeviceBaseMessage msg) throws Exception {
        if (msg instanceof DevicePingMessage) {
            String did = msg.getDid();
            if(did != null){
                String sn = msg.getSn();
                final String gwid = StringUtil.toUpper(did + "_" + msg.getOsgiName());
                SocketChannel channelActive = DeviceChannelMap.get(gwid, sn);
                if(channelActive != null){
                    // 客户端心跳ping, 返回心跳ping
                    log.debug("收到网关[{}-{}-{}]心跳包(ping)，并发送响应心跳包(pong)...目前连接数：{}", did, sn, ctx.channel().remoteAddress(), DeviceChannelMap.size());
                    ctx.writeAndFlush(DevicePongMessage.newPluginPongMessage(did, msg.getOsgiName(), sn, "60"));
                }else{
                    log.warn("网关{}-{}未登录，发送心跳，不合法！", did);
                    return;
                }
            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }

}
