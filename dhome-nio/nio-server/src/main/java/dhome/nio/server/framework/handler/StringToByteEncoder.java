package dhome.nio.server.framework.handler;

import java.nio.CharBuffer;
import java.util.List;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

public class StringToByteEncoder extends MessageToMessageEncoder<String> {

    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        if (msg.length() == 0)
            return;

        out.add(ByteBufUtil.encodeString(ctx.alloc(), CharBuffer.wrap(msg + "\n"), CharsetUtil.UTF_8));

    }

}
