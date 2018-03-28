/**
 * @ dhome-plugin-server
 * @ com.cmcc.dhome.device.server.framework.handlers
 * @ StringToByteEncoder.java
 * 
 * @author liujianliang@chinamobile.com 2016年5月23日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.device.server.framework.handlers;

import java.nio.CharBuffer;
import java.util.List;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

/**
 * 字节数组到字符串类型插件消息的编解码
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年5月23日 - 下午1:39:00
 * @history
 *          2016年5月23日 - 下午1:39:00 liujianliang@chinamobile.com create.
 */
public class StringToByteEncoder extends MessageToMessageEncoder<String> {

    /**
     * 将字符串消息（JSON格式）转成字节数组
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        if (msg.length() == 0) {
            return;
        }

        out.add(ByteBufUtil.encodeString(ctx.alloc(), CharBuffer.wrap(msg + "\n"), CharsetUtil.UTF_8));
    }

}
