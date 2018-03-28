package com.cmcc.dhome.device.server.run.test;

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

import ch.qos.logback.core.joran.spi.JoranException;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
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
 * @history 2015年11月12日 - 下午3:25:03 liujianliang@chinamobile.com create.
 */
public class DeviceClientTest extends TcpClientListener implements Runnable {

    private static Logger log  = LoggerFactory.getLogger(DeviceClientTest.class);

    String                host = "";
    int                   port = 15683;

    public static void main(String[] args) throws IOException, JoranException {
        String basePath = Class.class.getClass().getResource("/").getPath();

        String logbackConfFile = basePath + "logback.xml";
        LogBackConfigLoader.load(logbackConfFile);
        log.info("Loaded logback.xml: {}", logbackConfFile);

        for (int i = 0; i < 1; i++) {
            DeviceClientTest client = new DeviceClientTest();
            client.setServerName("Device");
            client.setTimeoutSeconds(10);

            new Thread(client).start();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        // host="192.168.192.59";
        // host="192.168.192.124";
        host = "127.0.0.1";
        // host = "172.23.29.56";
        startConnect(host, port);
    }

    @Override
    protected void initConnection(String host, int port) throws InterruptedException {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(bossGroup).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, true).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();

                // 随机模拟网关MAC地址
                // String gwid = StringUtil.randomMACAddress(":");
                String gwid = "TSTLOGWITHSN";
                String sn = "TSTLOGWITHSN";

                pipeline.addLast("idleStateHandler", new IdleStateHandler(0, 0, timeoutSeconds));
                pipeline.addLast("lineBasedFrameDecoder-8192", new LineBasedFrameDecoder(8192));// 按行('\n')解析成命令ByteBuf
                pipeline.addLast("stringPluginMessageDecoder", new StringDecoder(CharsetUtil.UTF_8));
                pipeline.addLast("stringToByteEncoder", new StringToByteEncoder());// 将JSON字符串类型消息转换成ByteBuf
                pipeline.addLast("deviceMessageDecoder", new DeviceMessageDecoder());// 将JSON字符串消息转成deviceMessage对象
                pipeline.addLast("deviceMessageEncoder", new DeviceMessageEncoder());// 将deviceMessage对象转成JSON字符串
                pipeline.addLast("deviceAuthRequestHandler", new DeviceAuthRequestHandler(gwid, sn));
                pipeline.addLast("deviceHeartBeatHandler", new DeviceHeartBeatRequestHandler(gwid, sn));
                pipeline.addLast("deviceOutboundMessageHandler", new DeviceOutboundMessageHandler());
            }
        });

        // Start the server. Bind and start to accept incoming connections.
        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            this.channelFuture = bootstrap.connect(host, port).sync();
            Thread.sleep(random.nextInt(500));
        }
    }

}
