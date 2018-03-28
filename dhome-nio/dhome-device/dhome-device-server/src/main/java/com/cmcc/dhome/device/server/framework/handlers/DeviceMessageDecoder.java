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
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceBaseMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DevicePingMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DevicePongMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceReportMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceRequestMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceResponseMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

/**
 * 从JSON请求解码为响应的对象
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年5月4日 - 下午4:27:58
 * @history
 *          2016年5月4日 - 下午4:27:58 liujianliang@chinamobile.com create.
 */
public class DeviceMessageDecoder extends MessageToMessageDecoder<String> {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    /*
     * (non-Javadoc)
     * 
     * @see
     * io.netty.handler.codec.MessageToMessageDecoder#decode(io.netty.channel.
     * ChannelHandlerContext, java.lang.Object, java.util.List)
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        log.debug("Received msg: {}", msg);
        if (StringUtils.isEmpty(msg)) {
            log.warn("receive nothing");
        } else {
            DeviceBaseMessage message = JSONObject.parseObject(msg, DeviceBaseMessage.class);
            switch (message.getMsgType()) {
                case PING:
                    DevicePingMessage pingMessage = JSONObject.parseObject(msg, DevicePingMessage.class);
                    out.add(pingMessage);
                    break;
                case PONG:
                    DevicePongMessage pongMessage = JSONObject.parseObject(msg, DevicePongMessage.class);
                    out.add(pongMessage);
                    break;
                case REQUEST:
                    DeviceRequestMessage requestMessage = JSONObject.parseObject(msg, DeviceRequestMessage.class);
                    out.add(requestMessage);
                    break;
                case RESPONSE:
                    DeviceResponseMessage responseMessage = JSONObject.parseObject(msg, DeviceResponseMessage.class);
                    out.add(responseMessage);
                    break;
                case REPORT:
                    DeviceReportMessage reportMessage = JSONObject.parseObject(msg, DeviceReportMessage.class);
                    out.add(reportMessage);
                    break;
                default:
                    log.warn("！丢弃未知类型数据包: {}", msg.toString());
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (cause instanceof JSONException) {
            log.warn("网关报文解析异常！问题原因: {}", cause.toString());
        } else {
            ctx.fireExceptionCaught(cause);
        }
    }

}
