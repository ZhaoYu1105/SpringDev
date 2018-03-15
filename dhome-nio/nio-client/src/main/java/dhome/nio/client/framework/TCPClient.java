package dhome.nio.client.framework;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import dhome.nio.client.framework.handler.PingRequestHandler;
import dhome.nio.core.mesage.base.Message;
import dhome.nio.server.framework.handler.InMessageDecoder;
import dhome.nio.server.framework.handler.OutMessageEncoder;
import dhome.nio.server.framework.handler.StringToByteEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.CharsetUtil;

public class TCPClient {

    final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private EventLoopGroup      group;
    private ChannelFuture       future;
    private Channel             channel;

    public boolean connect(String ipAddr, int port) {
        group = new NioEventLoopGroup();
        try {
            Bootstrap boot = new Bootstrap();
            boot.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast("readTimeoutHandler", new ReadTimeoutHandler(3, TimeUnit.SECONDS));
                    pipeline.addLast("lineBasedFrameDecoder-20480", new LineBasedFrameDecoder(20480));// 按行('\n')解析成命令ByteBuf
                    pipeline.addLast("stringPluginMessageDecoder", new StringDecoder(CharsetUtil.UTF_8));
                    pipeline.addLast("strToByteEncoder", new StringToByteEncoder());
                    pipeline.addLast("msgDecoder", new InMessageDecoder());
                    pipeline.addLast("msgEncoder", new OutMessageEncoder());
                    pipeline.addLast("pingRequestHandler", new PingRequestHandler());
                }
            });

            future = boot.connect("127.0.0.1", 15683).sync();
            channel = future.channel();

            return true;
        } catch (Exception e) {
            channel = null;
            future = null;

            e.printStackTrace();
        }

        return false;
    }

    public void close() throws Exception {
        if (channel != null) {
            channel.closeFuture().sync();
        }

        if (group != null) {
            group.shutdownGracefully();
        }
    }

    /**
     * 发送数据
     * 
     * @param msg
     * @author seasail
     * @date 2018年3月15日 - 上午10:20:06
     * @history
     *          2018年3月15日 - 上午10:20:06 seasail create.
     */
    public void sendMsg(Message msg) {
        String strMsg = JSONObject.toJSONString(msg);
        channel.writeAndFlush(strMsg);
    }

}
