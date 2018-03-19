package dhome.nio.client.framework.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class PingRequestHandler extends ChannelInboundHandlerAdapter {

    final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		super.userEventTriggered(ctx, evt);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
	    log.info(msg.toString());
	}
}
