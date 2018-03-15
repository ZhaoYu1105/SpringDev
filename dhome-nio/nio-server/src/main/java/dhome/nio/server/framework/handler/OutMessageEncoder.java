package dhome.nio.server.framework.handler;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import dhome.nio.core.mesage.base.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

public class OutMessageEncoder extends MessageToMessageEncoder<Message> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> out) throws Exception {
        String json = JSONObject.toJSONString(msg);
        out.add(json);
    }

}
