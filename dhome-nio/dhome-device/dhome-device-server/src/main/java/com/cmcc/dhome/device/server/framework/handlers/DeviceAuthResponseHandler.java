/**
 * @ platform-plugin-framework
 * @ com.cmcc.dhome.device.server.framework.handlers
 * @ DeviceAuthRequestHandler.java
 * 
 * @author liujianliang@chinamobile.com 2016年4月29日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.device.server.framework.handlers;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.cmcc.dhome.app.device.bean.framework.common.DeviceChannelMap;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceBaseMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceRequestMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceResponseMessage;
import com.cmcc.dhome.device.server.framework.DeviceServerListener;
import com.cmcc.zeus.base.processor.MessageContext;
import com.cmcc.zeus.base.utils.StringUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.TimeoutException;

/**
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年4月29日 - 上午9:39:48
 * @history
 *          2016年4月29日 - 上午9:39:48 liujianliang@chinamobile.com create.
 */
public class DeviceAuthResponseHandler extends SimpleChannelInboundHandler<DeviceBaseMessage> {

    private Logger             log                     = LoggerFactory.getLogger(this.getClass().getName());
    private int                timeoutSeconds          = 180;
    private String             gwid                    = null;
    private String             sn                      = null;
    private String             serverInstanceName      = "";

    // private RedisHttpService redisHttpService;

    /**
     * 保存：网关mac, 服务器实例名称
     */
    public static final String GATEWAY_CONNECTION_HASH = "tcpconnection:hash:";
    /**
     * 保存重新连接登录的网关MAC地址, 以及是在相同服务器实例上重新登录还是在其它服务器实例上重新登录，Y=相同，N=不同。
     * 在关闭连接时要判断网关MAC是否在此hash中。
     * 在集合中表示是由于重登录而被关闭，不用清除redis中的连接信息，后面直接覆盖连接信息即可
     * 否则是其它方式关闭，需要清除redis中的连接信息
     */
    // public static final String GATEWAY_RECONNECTION_HASH =
    // "gateway:reconnection:hash";

    /**
     * 直接使用F5时使用
     * 
     * @param timeoutSeconds
     *            心跳超时时间
     * @param serverInstanceName
     *            服务器实例名称
     */
    public DeviceAuthResponseHandler(int timeoutSeconds, String serverInstanceName) {
        super();
        this.timeoutSeconds = timeoutSeconds;
        this.serverInstanceName = serverInstanceName;
        log.info(this.serverInstanceName);
        // redisHttpService = SpringContextUtil.getBean("redisService");
    }

    /*
     * (non-Javadoc)
     * 
     * @see io.netty.channel.SimpleChannelInboundHandler#channelRead0(io.netty.
     * channel.ChannelHandlerContext, java.lang.Object)
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DeviceBaseMessage msg) throws Exception {

        String did = msg.getDid();
        if (!DeviceServerListener.authStatus) {
            log.warn("服务即将关闭，不再接受网关{}的登录请求", did);
            return;
        }

        if (StringUtil.nullOrBlank(did)) {
            log.warn("网关MAC地址不合法(did={})，忽略此请求!", did);
            return;
        }

        // request
        if (msg instanceof DeviceRequestMessage && "authPlugin".equals(((DeviceRequestMessage) msg).getPluginName())) {

            // 得到当前秒
            long currentSeconds = System.currentTimeMillis() / 1000;
            if (DeviceChannelMap.counter.get(currentSeconds).incrementAndGet() > DeviceServerListener.loginMax) {
                log.warn("！！！超出流量限制，舍弃该消息");
                return;
            }

            gwid = StringUtil.toUpper(did) + "_" + msg.getOsgiName().toUpperCase();
            sn = StringUtil.nullOrBlank(msg.getSn()) ? "EMPTY" : msg.getSn();

            DeviceRequestMessage request = (DeviceRequestMessage) msg;

            /**
             * 获取插件版本号
             */
            String bundleVersion = null;
            Object reqParam = request.getParam();
            if (reqParam != null) {
                JSONObject jsonObj = (JSONObject) reqParam;
                bundleVersion = jsonObj.getString("bundleVersion");
            }
            String ver = (bundleVersion == null) ? "1.0" : bundleVersion;

            log.info("网关[{}-{}-{}]登录成功，版本号：{}， 当前服务器节点连接数: {}", gwid, sn, ctx.channel().remoteAddress(), ver, DeviceChannelMap.size());
            DeviceResponseMessage response = request.toResponseMessage();
            response.setSuccessResult();
            ctx.writeAndFlush(response);

            // AttributeKey<String> attributeKey = AttributeKey.valueOf("gwid");
            // Attribute<String> attribute = ctx.channel().attr(attributeKey);
            // attribute.set(gwid + "_" + sn);

            // 进行登录认证，将连接保持到当前服务器节点中
            DeviceChannelMap.add(gwid, sn, (SocketChannel) ctx.channel());
            // try (Jedis jedis = RedisUtil.getJedis()) {
            // 将该网关连接信息放到redis中，并记下该网关连接所在服务器实例名称
            // RedisUtil.hset(GATEWAY_CONNECTION_HASH + gwid, sn,
            // serverInstanceName);
            // redisHttpService.hsetHttp(GATEWAY_CONNECTION_HASH + gwid, sn,
            // serverInstanceName);

        } else {
            // response or report
            ctx.fireChannelRead(msg);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // log.debug("gwid值为：{}的连接将断开！", gwid);
        // if (gwid != null) {
         DeviceChannelMap.remove(gwid, sn);
        // String value = RedisUtil.hget(GATEWAY_CONNECTION_HASH + gwid, sn);
        // if (serverInstanceName.equals(value)) {
        // // redis中存储地址与本机相同时才能进行删除操作
        // RedisUtil.hdel(GATEWAY_CONNECTION_HASH + gwid, sn);
        // redisHttpService.hdelHttp(GATEWAY_CONNECTION_HASH + gwid, sn);
        // }
        // log.warn("网关[{}-{}-{}]退出登录！并从redis中清除连接信息。当前服务器节点连接数: {}", gwid, sn,
        // ctx.channel().remoteAddress(), DeviceChannelMap.size());
        // }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (cause instanceof TimeoutException) {
            // 网关建立TCP连接并且正常登录后，心跳超时退出
            if (gwid != null) {
                log.warn("在心跳超时时间[{}]内没有收到网关[{}-{}]任何消息！", timeoutSeconds, gwid, ctx.channel().remoteAddress());
            } else {
                // 网关建立TCP连接，但没有进行登录操作和心跳操作，然后超时
                log.warn("网关[address={}]建立了TCP连接，但没有进行登录和心跳操作，{}s后连接超时退出!", ctx.channel().remoteAddress(), timeoutSeconds);
            }
        } else {
            SocketAddress remoteAddress = ctx.channel().remoteAddress();
            InetSocketAddress socketAddress = (InetSocketAddress) remoteAddress;
            // 没有启用集群，不存在判断的情况，都是网关连接异常断开
            log.warn("网关[{}-{}-{}]连接异常断开, 问题原因: ", gwid, sn, socketAddress.toString(), cause);
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
        // IMessageProcessor jmsSender =
        // SpringContextUtil.getBean("serverReportJsmToBpProcessor");
        // try {
        // log.debug("网关{}-{}的消息SAVE_BUNDLE_VERSION被放入serverReportJsmToBpProcessor队列中",
        // message.getDid(), message.getSn());
        // jmsSender.process(context);
        // } catch (Exception e) {
        // log.error("！！！向队列serverReportJsmToBpProcessor发送消息失败", e);
        // }
    }

}
