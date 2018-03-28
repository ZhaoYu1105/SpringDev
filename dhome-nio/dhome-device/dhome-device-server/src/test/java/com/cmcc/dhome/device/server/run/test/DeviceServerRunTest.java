package com.cmcc.dhome.device.server.run.test;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cmcc.dhome.device.server.framework.DeviceServerListener;
import com.cmcc.dhome.device.server.framework.thread.ShutDownWork;
import com.cmcc.dhome.device.server.run.DeviceServerRun;
import com.cmcc.zeus.base.core.logback.LogBackConfigLoader;

import ch.qos.logback.core.joran.spi.JoranException;

/**
 * 设备接入服务器启动程序
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年4月26日 - 上午11:13:00
 * @history
 *          2016年4月26日 - 上午11:13:00 liujianliang@chinamobile.com create.
 */
@Service
public class DeviceServerRunTest {

    private static Logger log = LoggerFactory.getLogger(DeviceServerRun.class);

    public static void main(String[] args) throws Exception {

        // 添加程序结束监听
        Runtime.getRuntime().addShutdownHook(new ShutDownWork());

        ApplicationContext context = initApplicationContext();

        final DeviceServerListener tcpListener = context.getBean(DeviceServerListener.class);
        // }.start();
        // new Thread() {
        // public void run() {
        tcpListener.startListener();
        // }
        // }.start();
    }

    /**
     * 初始化应用程序
     * 
     * @return 应用程序上下文
     * @author liujianliang@chinamobile.com
     * @throws JoranException
     * @throws IOException
     * @date 2015年11月12日 - 下午2:53:03
     * @history
     *          2015年11月12日 - 下午2:53:03 liujianliang@chinamobile.com create.
     */
    public static ApplicationContext initApplicationContext() throws IOException, JoranException {
        String basePath = Class.class.getClass().getResource("/").getPath();

        String logbackConfFile = basePath + "logback.xml";
        LogBackConfigLoader.load(logbackConfFile);

        String springConfFile = basePath + "spring-config-device.xml";
        if (!(new File(springConfFile)).exists()) {
            log.error("！！！Cannot found Spring config file: spring-config-device.xml");
            System.exit(1);
        }

        log.info("Smart Home Dir: {}", basePath);
        log.info("Loaded logback.xml: {}", logbackConfFile);
        log.info("Loaded sping config file: {}", springConfFile);

        return new FileSystemXmlApplicationContext("file:" + springConfFile);
    }

}
