/**
 * @ home-protocol-coap
 * @ com.cmcc.home.protocol.coap.processor
 * @ DeviceMessageReceiveProcessor.java
 * 
 * @author 缪云海[miaoyunhai@chinamobile.com] 2015年8月15日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.device.server.framework.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmcc.dhome.app.device.bean.framework.common.DeviceChannelMap;
import com.cmcc.dhome.device.server.framework.DeviceServerListener;
import com.cmcc.zeus.base.processor.MessageContext;
import com.cmcc.zeus.base.processor.basic.BasicMessageProcessor;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.SocketChannel;

/**
 * 接收订阅消息，处理过期废弃的channel连接
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年5月10日 - 下午1:35:03
 * @history
 *          2016年5月10日 - 下午1:35:03 liujianliang@chinamobile.com create.
 */
public class DeviceChannelDiscardProcessor extends BasicMessageProcessor {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.cmcc.zeus.base.processor.basic.BasicMessageProcessor#canProcess(com.
     * cmcc.zeus.base.processor.MessageContext)
     */
    @Override
    protected boolean canProcess(MessageContext context) throws Exception {
        return context.getContent() == null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.cmcc.zeus.base.processor.basic.BasicMessageProcessor#doProcess(com.
     * cmcc.zeus.base.processor.MessageContext)
     */
    @Override
    protected void doProcess(MessageContext context) throws Exception {
        final String gwid = context.getProperty("gwid").toString();
        final String sn = context.getProperty("sn").toString();
        final String serverInstanceName = context.getProperty("serverInstanceName").toString();

        SocketChannel channel = DeviceChannelMap.get(gwid, sn);
        // 如果该废弃的连接是在当前实例上
        if (serverInstanceName.equals(DeviceServerListener.serverInstanceName) && channel != null) {
            log.debug("节点[{}]收到关闭并删除已废弃网关连接的发布消息，删除并关闭网关旧连接[{}-{}-{}]", serverInstanceName, gwid, sn, channel.remoteAddress());
            DeviceChannelMap.remove(gwid, sn);
            ChannelFuture future = channel.close();
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        log.warn("网关[{}-{}-{}]旧连接关闭成功!", gwid, sn, future.channel().remoteAddress());
                    } else {
                        log.error("网关[{}-{}-{}]旧连接关闭失败! 异常信息: ", gwid, sn, future.channel().remoteAddress(), future.cause().getMessage());
                    }
                }
            });
        } else {
            // log.debug("网关[{}]和device server服务器的连接SocketChannel不在本节点[{}]上...",
            // gwid, DeviceServerListener.serverInstanceName);
            // TODO 推送错误消息给APP
        }
    }

}
