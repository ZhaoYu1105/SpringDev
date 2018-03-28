package com.cmcc.dhome.device.server.framework;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import com.cmcc.dhome.device.server.framework.handlers.DeviceAuthResponseHandler;
import com.cmcc.dhome.device.server.framework.handlers.DeviceHeartBeatResponseHandler;
import com.cmcc.dhome.device.server.framework.handlers.DeviceMessageDecoder;
import com.cmcc.dhome.device.server.framework.handlers.DeviceMessageEncoder;
import com.cmcc.dhome.device.server.framework.handlers.DeviceMessageHandler;
import com.cmcc.dhome.device.server.framework.handlers.EchoClientHandler;
import com.cmcc.dhome.device.server.framework.handlers.StringToByteEncoder;
import com.cmcc.dhome.device.server.framework.zookeeper.DeviceChannelCounter;
import com.cmcc.zeus.base.core.spring.SpringContextUtil;
import com.cmcc.zeus.base.net.tcp.TcpServerListener;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.CharsetUtil;

/**
 * 初始化TCP服务器
 * 
 * @author liujianliang@chinamobile.com
 * @date 2015年11月12日 - 下午3:25:03
 * @history
 *          2015年11月12日 - 下午3:25:03 liujianliang@chinamobile.com create.
 */
public class DeviceServerListener extends TcpServerListener {

    // private static Logger log =
    // LoggerFactory.getLogger(DeviceServerListener.class.getName());

    private boolean       lvsEnable;
    private String        serverDip;
    // private String ip;
    private String        maxLength;         // 可解析消息的最大长度
    private int           tcpTimeOut;        // TCP超期时间
    public static long    loginMax = 800;    //登录请求每秒最大处理量

    public static boolean authStatus = true; // 当前是否接受网关登录

    @Override
    protected void initServer() throws InterruptedException {

        // 开启netty selectKey优化
        System.setProperty("io.netty.noKeySetOptimization", "true");

        ThreadFactory bossThreadFactory = new ThreadFactoryBuilder().setNameFormat(getServerName() + " Server Acceptor NIO Thread#%d").build();
        ThreadFactory workerThreadFactory = new ThreadFactoryBuilder().setNameFormat(getServerName() + " Server Reactor NIO Thread#%d").build();
        this.executor = new ScheduledThreadPoolExecutor(1);

        // 定时输出当前连接数量信息
//        DeviceChannelCounter watcher = SpringContextUtil.getBean(DeviceChannelCounter.class);
//        watcher.setPort(serverPort);// 用于标识服务器实例
//        watcher.init();
//        this.executor.scheduleAtFixedRate(watcher, 60, 60, TimeUnit.SECONDS);

        this.bossGroup = new NioEventLoopGroup(numberOfThreads, bossThreadFactory);
        this.workerGroup = new NioEventLoopGroup(numberOfThreads, workerThreadFactory);

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast("readTimeoutHandler", new ReadTimeoutHandler(DeviceServerListener.this.timeoutSeconds));
                pipeline.addLast("lineBasedFrameDecoder-" + maxLength, new LineBasedFrameDecoder(Integer.parseInt(maxLength)));// 按行('\n')解析成命令ByteBuf
                pipeline.addLast("stringPluginMessageDecoder", new StringDecoder(CharsetUtil.UTF_8));
                pipeline.addLast("stringToByteEncoder", new StringToByteEncoder());// 将JSON字符串类型消息转换成ByteBuf
                pipeline.addLast("deviceMessageDecoder", new DeviceMessageDecoder());// 将JSON字符串消息转成deviceMessage对象
                pipeline.addLast("deviceMessageEncoder", new DeviceMessageEncoder());// 将deviceMessage对象转成JSON字符串
                pipeline.addLast("deviceHeartBeatResponseHandler", new DeviceHeartBeatResponseHandler());
                pipeline.addLast("idleStateHandler", new IdleStateHandler(0, DeviceServerListener.this.tcpTimeOut, 0));
                pipeline.addLast("deviceAuthResponseHandler",
                        new DeviceAuthResponseHandler(DeviceServerListener.this.timeoutSeconds, DeviceServerListener.serverInstanceName));
                pipeline.addLast("echoClientHandler", new EchoClientHandler());
                pipeline.addLast("deviceMessageHandler", new DeviceMessageHandler());
            }
        }).option(ChannelOption.SO_BACKLOG, 1024).option(ChannelOption.SO_KEEPALIVE, true).option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT).childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .option(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT);

        // Start the server. Bind and start to accept incoming connections.
        this.channelFuture = bootstrap.bind(serverPort).sync();
    }

    public boolean isLvsEnable() {
        return lvsEnable;
    }

    public void setLvsEnable(boolean lvsEnable) {
        this.lvsEnable = lvsEnable;
    }

    public String getServerDip() {
        return serverDip;
    }

    public void setServerDip(String serverDip) {
        this.serverDip = serverDip;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength;
    }

    public int getTcpTimeOut() {
        return tcpTimeOut;
    }

    public void setTcpTimeOut(int tcpTimeOut) {
        this.tcpTimeOut = tcpTimeOut;
    }

    public static long getLoginMax() {
        return loginMax;
    }

    public static void setLoginMax(long loginMax) {
        DeviceServerListener.loginMax = loginMax;
    }

}
