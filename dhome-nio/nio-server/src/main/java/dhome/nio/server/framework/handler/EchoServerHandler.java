package dhome.nio.server.framework.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dhome.nio.core.mesage.PongMessage;
import dhome.nio.core.mesage.base.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class EchoServerHandler extends SimpleChannelInboundHandler<Message> {

    private String mac;
    final Logger   log = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        mac = msg.toString();

        PongMessage ponMsg = PongMessage.create(msg.getHeader().getMac(), msg.getHeader().getSn());
        log.info(ponMsg.toString());
        ctx.writeAndFlush(ponMsg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("EchoServerHandler：exceptionCaught");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("mac: " + mac + ", 断开连接！");
        ctx.channel().close().sync();
    }

}
