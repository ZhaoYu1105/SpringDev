package com.cmcc.dhome.device.server.framework.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmcc.dhome.app.device.bean.framework.message.DeviceRequestMessage;
import com.cmcc.zeus.base.utils.StringUtil;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

/**
 * 
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年5月10日 - 下午6:16:03
 * @history
 *          2017年5月10日 - 下午6:16:03 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class EchoClientHandler extends ChannelDuplexHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (IdleStateEvent.class.isAssignableFrom(evt.getClass())) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.WRITER_IDLE) {
                AttributeKey<String> attributeKey = AttributeKey.valueOf("gwid");
                Attribute<String> attribute = ctx.channel().attr(attributeKey);
                String gwid = attribute.get();
                log.info("{}的TCP通道长时间未使用即将关闭", gwid);
                if (gwid != null) {
                    String did = gwid.split("_")[0];
                    String sn = gwid.split("_")[2];
                    DeviceRequestMessage data = new DeviceRequestMessage();
                    data.setDid(did);
                    if (StringUtil.notNullAndBlank(sn) && !"EMPTY".equals(sn)) {
                        data.setSn(sn);
                    }
                    data.setPluginName("HgSystem");
                    data.setMethod("SET_TCP_DISCONNECT");
                    data.setRpcMethod("Set");
                    ctx.writeAndFlush(data);
                }
            }
        }
    }
}
