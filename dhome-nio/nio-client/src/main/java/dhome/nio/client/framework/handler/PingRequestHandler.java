package dhome.nio.client.framework.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 
 * 
 * @author seasail[miaoyunhai@cmhi.chinamobile.com]
 * @date 2018年3月27日 - 下午1:54:35
 * @history 
 * 		 2018年3月27日 - 下午1:54:35 seasail[miaoyunhai@cmhi.chinamobile.com] create.
 */
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
