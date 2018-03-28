/**
 * @ home-protocol-coap
 * @ com.cmcc.home.protocol.coap.processor
 * @ DeviceMessageReceiveProcessor.java
 * 
 * @author 缪云海[miaoyunhai@chinamobile.com] 2015年8月15日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.device.server.framework.processor;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmcc.dhome.app.device.bean.framework.common.DeviceChannelMap;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceMessage;
import com.cmcc.zeus.base.processor.MessageContext;
import com.cmcc.zeus.base.processor.basic.BasicMessageProcessor;
import com.cmcc.zeus.base.utils.StringUtil;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * 将从JMS中接收到的APP端插件请求，转成TCP包，发给网关插件
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年5月10日 - 下午1:35:03
 * @history
 *          2016年5月10日 - 下午1:35:03 liujianliang@chinamobile.com create.
 */
public class DeviceMessageReceiveProcessor extends BasicMessageProcessor {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    protected boolean canProcess(MessageContext context) throws Exception {
        return context.getContent() instanceof DeviceMessage;
    }

    @Override
    protected void doProcess(MessageContext context) throws Exception {
        Object obj = context.getContent();
        DeviceMessage message = DeviceEncryptProcessor.checkEncrypt((DeviceMessage) obj);// 判断是否需要加密
        final String gwid = StringUtil.toUpper(message.getDid() + "_" + message.getOsgiName());
        final String sn = StringUtil.nullOrBlank(message.getSn()) ? "EMPTY" : message.getSn();

        log.debug("该消息的OsgiName为{}", message.getOsgiName());
        SocketChannel channel = DeviceChannelMap.get(gwid, sn);
        if (channel != null) {
            if (channel.isOpen() && channel.isActive()) {
                log.debug("Recevied a device message and will be send to 网关[{}]: {}", gwid, message);
                ChannelFuture future = channel.writeAndFlush(message);
                future.addListener(new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture future) throws Exception {
                        log.debug("The device request sent to 网关[{}-{}] completed!", gwid, sn);
                    }
                });
            } else {
                DeviceChannelMap.remove(gwid, sn);
                log.warn("网关[{}-{}-{}]和服务器连接已经断开，清理连接信息...网关状态:active-{}，上一次读操作时间为{}", gwid, sn, channel.remoteAddress(), channel.isActive(),
                        getLastReadTime(channel));
                ChannelFuture future = channel.close();
                log.debug("开始清理已经断开的网关[{}-{}-{}]连接...", gwid, sn, channel.remoteAddress());
                future.addListener(new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture future) throws Exception {
                        // 从redis中清理连接信息
                        // RedisUtil.hdel(DeviceAuthResponseHandler.GATEWAY_CONNECTION_HASH
                        // + gwid, sn);
                        log.warn("清理已经断开的网关[{}-{}-{}]连接信息成功!", gwid, sn, future.channel().remoteAddress());
                    }
                });
            }
        } else {
            // log.debug("网关[{}]和device server服务器的连接SocketChannel不在本节点上...",
            // gwid);
        }
    }

    /**
     * 向JMS队列发送消息的公共方法
     * 
     * @param message
     *            消息内容
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2016年6月8日 - 下午1:56:32
     * @history
     *          2016年6月8日 - 下午1:56:32 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public void sendMessage(DeviceMessage message) {
        MessageContext context = new MessageContext();
        context.setContent(message);
        // String type = message.getType();
        // String cmdType = message.getMethod();
        // IMessageProcessor jmsSender;
        // if("response".equals(type) &&
        // !"SAVE_BUNDLE_VERSION".equals(cmdType)){
        // jmsSender =
        // SpringContextUtil.getBean("deviceServerJmsToBpProcessor");
        // }else{
        // log.debug("消息{}被放入serverReportJsmToBpProcessor队列中",cmdType);
        // jmsSender =
        // SpringContextUtil.getBean("serverReportJsmToBpProcessor");
        // }
        // try {
        // jmsSender.process(context);
        // } catch (Exception e) {
        // log.error("！！！向队列deviceServerJmsToBpProcessor发送消息失败", e);
        // }
    }

    /**
     * 获取通道上一次读操作的时间
     * 
     * @param ch
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年11月21日 - 下午6:52:28
     * @history
     *          2017年11月21日 - 下午6:52:28 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public String getLastReadTime(Channel ch) {
        long duration = 86400000L;// 设置为24小时，保证异常时能根据日期区分异常数据
        try {
            ChannelPipeline pipeline = ch.pipeline();
            ReadTimeoutHandler readTimeoutHandler = pipeline.get(ReadTimeoutHandler.class);

            Field lastReadTimeField = ReadTimeoutHandler.class.getSuperclass().getDeclaredField("lastReadTime");
            lastReadTimeField.setAccessible(true);
            long lastReadTime = (long) lastReadTimeField.get(readTimeoutHandler);
            lastReadTimeField.setAccessible(false);

            duration = TimeUnit.MILLISECONDS.convert(System.nanoTime() - lastReadTime, TimeUnit.NANOSECONDS);

        } catch (Exception e) {
            log.error("！！！获取通道上一次读操作时间出错,{}", e);
        }

        Date lastTime = new Date(System.currentTimeMillis() - duration);
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(lastTime);
    }

}
