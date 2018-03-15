package dhome.nio.server.framework.handler;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import dhome.nio.core.mesage.base.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

public class InMessageDecoder extends MessageToMessageDecoder<String> {

    @Override
    protected void decode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        Message message = JSONObject.parseObject(msg, Message.class);
        out.add(message);
    }

}
