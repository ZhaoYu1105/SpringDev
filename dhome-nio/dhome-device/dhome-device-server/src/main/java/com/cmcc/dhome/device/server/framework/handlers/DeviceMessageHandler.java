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

import com.cmcc.dhome.app.device.bean.framework.message.DeviceBaseMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceReportMessage;
import com.cmcc.dhome.device.server.framework.processor.DeviceEncryptProcessor;
import com.cmcc.dhome.device.server.framework.processor.OnoffMessageProcessor;
import com.cmcc.zeus.base.processor.MessageContext;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 插件消息业务逻辑处理
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年4月29日 - 上午9:39:48
 * @history
 *          2016年4月29日 - 上午9:39:48 liujianliang@chinamobile.com create.
 */
public class DeviceMessageHandler extends SimpleChannelInboundHandler<DeviceBaseMessage> {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    /*
     * (non-Javadoc)
     * 
     * @see io.netty.channel.SimpleChannelInboundHandler#channelRead0(io.netty.
     * channel.ChannelHandlerContext, java.lang.Object)
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DeviceBaseMessage msg) throws Exception {
        if (msg instanceof DeviceMessage) {
            DeviceMessage message = (DeviceMessage) msg;

            if (message instanceof DeviceReportMessage) {
                DeviceReportMessage report = (DeviceReportMessage) message;
                /**
                 * 对上线提醒和下线提醒消息做过滤处理
                 */
                String msgType = message.getMethod();
                boolean result = true;
                if ("REPORT_LAN_DEVICE_ONLINE".equals(msgType)) {
                    result = OnoffMessageProcessor.onlineMsgFilter(report);
                } else if ("reportOffline".equals(msgType)) {
                    result = OnoffMessageProcessor.offlineMsgFilter(report);
                }

                if (!result) {
                    log.debug("过滤过于频繁的设备上/下线消息{}", report.toString());
                    return;
                }
            }

            log.debug("调用加解密方法！！！");
            message = DeviceEncryptProcessor.checkEncrypt(message);// 判断是否需要解密
            MessageContext context = new MessageContext();
            context.setContent(message);

            // String type = message.getType();
            // String cmdType = message.getMethod();
            // IMessageProcessor jmsSender;
            // if("response".equals(type)){
            // jmsSender =
            // SpringContextUtil.getBean("deviceServerJmsToBpProcessor");
            // }else{
            // log.debug("消息{}被放入serverReportJsmToBpProcessor队列中",cmdType);
            // jmsSender =
            // SpringContextUtil.getBean("serverReportJsmToBpProcessor");
            // }
            // if("GET_LAN_NET_INFO".equals(cmdType)){
            // context.setPriority(9);//提高获取下挂设备列表方法的优先级
            // }
            // try {
            // jmsSender.process(context);
            // } catch (Exception e) {
            // log.error("！！！", e);
            // }
        } else {
            log.warn("！丢弃未知类型数据包: {}", msg.toString());
            // ctx.fireChannelRead(msg);
        }
    }

}
