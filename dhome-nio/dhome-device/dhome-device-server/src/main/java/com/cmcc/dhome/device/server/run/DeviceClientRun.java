package com.cmcc.dhome.device.server.run;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmcc.dhome.device.server.framework.handlers.DeviceMessageDecoder;
import com.cmcc.dhome.device.server.framework.handlers.DeviceMessageEncoder;
import com.cmcc.dhome.device.server.framework.handlers.StringToByteEncoder;
import com.cmcc.dhome.device.server.framework.handlers.client.DeviceAuthRequestHandler;
import com.cmcc.dhome.device.server.framework.handlers.client.DeviceHeartBeatRequestHandler;
import com.cmcc.dhome.device.server.framework.handlers.client.DeviceOutboundMessageHandler;
import com.cmcc.zeus.base.core.logback.LogBackConfigLoader;
import com.cmcc.zeus.base.net.tcp.TcpClientListener;
import com.cmcc.zeus.base.utils.StringUtil;

import ch.qos.logback.core.joran.spi.JoranException;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

/**
 * 初始化TCP服务器
 * 
 * @author liujianliang@chinamobile.com
 * @date 2015年11月12日 - 下午3:25:03
 * @history
 *          2015年11月12日 - 下午3:25:03 liujianliang@chinamobile.com create.
 */
public class DeviceClientRun extends TcpClientListener implements Runnable {

    private static Logger log  = LoggerFactory.getLogger(DeviceClientRun.class);

    String                host = "172.18.38.56";
    int                   port = 15683;

    public static void main(String[] args) throws IOException, JoranException {

        String osType = System.getProperty("os.name").toLowerCase();
        /*
         * /opt/device-run
         */
        String homePath = System.getProperty("smart.home");
        /*
         * /opt/device-run/conf/
         */
        String confPath = homePath + File.separator + "conf" + File.separator;

        // String logbackConfFile = confPath + "logback.xml";
        // LogBackConfigLoader.load(logbackConfFile);

        log.info(String.format("Operating Systerm: %s", osType));
        log.info(String.format("Smart Home Dir: %s", homePath));

        int total = 10000;
        for (int i = 0; i < total; i++) {
            DeviceClientRun client = new DeviceClientRun();
            client.setServerName("Device");
            client.setTimeoutSeconds(60);

            new Thread(client).start();
        }
    }

    @Override
    protected void initConnection(String host, int port) throws InterruptedException {

        Bootstrap bootstrap = new Bootstrap();
        bossGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors());

        bootstrap.group(bossGroup).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, true).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();

                // 随机模拟网关MAC地址
                String gwid = StringUtil.randomMACAddress(null);

                pipeline.addLast("idleStateHandler", new IdleStateHandler(0, 0, timeoutSeconds));
                pipeline.addLast("lineBasedFrameDecoder-8192", new LineBasedFrameDecoder(8192));// 按行('\n')解析成命令ByteBuf
                pipeline.addLast("stringPluginMessageDecoder", new StringDecoder(CharsetUtil.UTF_8));
                pipeline.addLast("stringToByteEncoder", new StringToByteEncoder());// 将JSON字符串类型消息转换成ByteBuf
                pipeline.addLast("deviceMessageDecoder", new DeviceMessageDecoder());// 将JSON字符串消息转成deviceMessage对象
                pipeline.addLast("deviceMessageEncoder", new DeviceMessageEncoder());// 将deviceMessage对象转成JSON字符串
                pipeline.addLast("deviceAuthRequestHandler", new DeviceAuthRequestHandler(gwid, null));
                pipeline.addLast("deviceHeartBeatHandler", new DeviceHeartBeatRequestHandler(gwid, null));
                pipeline.addLast("deviceOutboundMessageHandler", new DeviceOutboundMessageHandler());
            }
        });

        // Start the server. Bind and start to accept incoming connections.
        this.channelFuture = bootstrap.connect(host, port).sync();
        // Random random = new Random();
        // for (int i = 0; i < 1; i++) {
        // this.channelFuture = bootstrap.connect(host, port).sync();
        // Thread.sleep(random.nextInt(500));
        // }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        startConnect(host, port);
    }
}
