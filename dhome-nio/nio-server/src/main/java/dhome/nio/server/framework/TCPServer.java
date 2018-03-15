package dhome.nio.server.framework;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import dhome.nio.server.framework.handler.EchoServerHandler;
import dhome.nio.server.framework.handler.InMessageDecoder;
import dhome.nio.server.framework.handler.OutMessageEncoder;
import dhome.nio.server.framework.handler.StringToByteEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.CharsetUtil;

public class TCPServer {

    final Logger             log             = LoggerFactory.getLogger(this.getClass().getName());

    private String           serverName      = "nio";
    private int              maxLength       = 20480;
    private int              port            = 15683;

    private int              numberOfThreads = Runtime.getRuntime().availableProcessors() * 2;

    protected EventLoopGroup bossGroup;
    protected EventLoopGroup workerGroup;

    @SuppressWarnings("deprecation")
    public void initServer() {
        ThreadFactory bossThreadFactory = new ThreadFactoryBuilder().setNameFormat(getServerName() + " Server Acceptor NIO Thread#%d").build();
        ThreadFactory workerThreadFactory = new ThreadFactoryBuilder().setNameFormat(getServerName() + " Server Reactor NIO Thread#%d").build();

        bossGroup = new NioEventLoopGroup(numberOfThreads, bossThreadFactory);
        workerGroup = new NioEventLoopGroup(numberOfThreads, workerThreadFactory);

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT).childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .option(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT).handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("readTimeoutHandler", new ReadTimeoutHandler(3, TimeUnit.SECONDS));
                            pipeline.addLast("lineBasedFrameDecoder-" + maxLength, new LineBasedFrameDecoder(maxLength));// 按行('\n')解析成命令ByteBuf
                            pipeline.addLast("stringPluginMessageDecoder", new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast("strToByteEncoder", new StringToByteEncoder());
                            pipeline.addLast("msgDecoder", new InMessageDecoder());
                            pipeline.addLast("msgEncoder", new OutMessageEncoder());
                            pipeline.addLast("echoHandler", new EchoServerHandler());
                        }
                    });
            // .option(ChannelOption.SO_KEEPALIVE,
            // true).option(ChannelOption.TCP_NODELAY, true)

            log.info("starting...");
            ChannelFuture future = bootstrap.bind(getPort()).sync();
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getNumberOfThreads() {
        return numberOfThreads;
    }

    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
}
