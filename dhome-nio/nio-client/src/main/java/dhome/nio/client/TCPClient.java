package dhome.nio.client;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ch.qos.logback.core.joran.spi.JoranException;
import dhome.nio.core.util.LogBackConfigLoader;
import io.netty.bootstrap.Bootstrap;
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

    public static void main(String[] args) throws Exception, IOException, JoranException {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String file = path + "logback.xml";
        LogBackConfigLoader.load(file);

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap boot = new Bootstrap();
            boot.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast("readTimeoutHandler", new ReadTimeoutHandler(3, TimeUnit.SECONDS));
                    pipeline.addLast("lineBasedFrameDecoder-20480", new LineBasedFrameDecoder(20480));// 按行('\n')解析成命令ByteBuf
                    pipeline.addLast("stringPluginMessageDecoder", new StringDecoder(CharsetUtil.UTF_8));
                }
            });

            ChannelFuture future = boot.connect("127.0.0.1", 15600).sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }

    }
}
