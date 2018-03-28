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

import com.alibaba.fastjson.JSONObject;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceBaseMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceRequestMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceResponseMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年4月29日 - 上午9:39:48
 * @history
 *          2016年4月29日 - 上午9:39:48 liujianliang@chinamobile.com create.
 */
public class DeviceAuthRequestHandler extends SimpleChannelInboundHandler<DeviceBaseMessage> {

    private Logger log  = LoggerFactory.getLogger(this.getClass().getName());
    private String gwid = null;
    private String sn = null;

    /**
     * @param mac
     */
    public DeviceAuthRequestHandler(String gwid, String sn) {
        this.gwid = gwid;
        this.sn = sn;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 连接建立成功后，发送登录login消息
        DeviceRequestMessage login = new DeviceRequestMessage();
        login.setPluginName("authPlugin");
        login.setDid(gwid);
        login.setSn(sn);
        login.setMethod("login");
        JSONObject param = new JSONObject();
        param.put("bundleVersion", "2.0");
        login.setParam(param);

        log.info("网关[{}]连接服务端[{}]成功! 发送登录login服务端请求...", login.getDid(), ctx.channel().remoteAddress());
        ctx.writeAndFlush(login);
    }

    /*
     * (non-Javadoc)
     * 
     * @see io.netty.channel.SimpleChannelInboundHandler#channelRead0(io.netty.
     * channel.ChannelHandlerContext, java.lang.Object)
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DeviceBaseMessage msg) throws Exception {
        gwid = msg.getDid();
        sn = msg.getSn();
        if (msg instanceof DeviceResponseMessage) {
            DeviceResponseMessage response = (DeviceResponseMessage) msg;
            // 登录响应信息
            if (response.getPluginName().equals("authPlugin") && response.getMethod().equals("login")) {
                if (response.getResult().equals("1000000")) {
                    log.debug("网关[{}-{}]登录服务器成功!", gwid, sn);

                    // DeviceRequestMessage request = new
                    // DeviceRequestMessage();
                    // request.setPluginName("test");
                    // request.setMethod("reportInfo");
                    // request.setDid(gwid);
                    // request.setSeqId("abc");
                    //
                    // JSONObject param = new JSONObject();
                    // param.put("up", "100");
                    // param.put("down", "200");
                    // request.setParam(param.toJSONString());
                    //
                    // log.debug("网关[{}]上报数据...", gwid);
                    //
                    // ctx.writeAndFlush(request);

                } else {
                    log.warn("网关[{}-{}]登录失败，错误码: {}，错误原因: {}", gwid, sn, response.getResult(), response.getData());
                }
            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }

}
