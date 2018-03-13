package dhome.nio.server.framework.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dhome.nio.core.mesage.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class EchoServerHandler extends SimpleChannelInboundHandler<Message> {

    final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        log.info(msg.getHeader().getMac());
    }

}
