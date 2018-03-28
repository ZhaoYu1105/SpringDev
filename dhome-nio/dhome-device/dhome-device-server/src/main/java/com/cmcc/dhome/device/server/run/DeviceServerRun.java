package com.cmcc.dhome.device.server.run;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cmcc.dhome.device.server.framework.DeviceServerListener;
import com.cmcc.dhome.device.server.framework.thread.ShutDownWork;
import com.cmcc.zeus.base.core.logback.LogBackConfigLoader;

/**
 * 插件服务器启动程序
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年4月26日 - 上午11:13:00
 * @history
 *          2016年4月26日 - 上午11:13:00 liujianliang@chinamobile.com create.
 */
@Service
public class DeviceServerRun {

    private static Logger log = LoggerFactory.getLogger(DeviceServerRun.class);

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {

        // 添加程序结束监听
        Runtime.getRuntime().addShutdownHook(new ShutDownWork());

        String osType = System.getProperty("os.name").toLowerCase();
        /*
         * /opt/device-run
         */
        String homePath = System.getProperty("smart.home");
        /*
         * /opt/device-run/conf/
         */
        String confPath = homePath + File.separator + "conf" + File.separator;
        String logbackConfFile = confPath + "logback.xml";
        LogBackConfigLoader.load(logbackConfFile);

        String springConfFile = confPath + "spring-config-device.xml";
        if (!(new File(springConfFile)).exists()) {
            log.error("！！！Cannot found Spring config file:spring-config-device.xml");
            System.exit(1);
        }

        log.info("Operating Systerm: {}", osType);
        log.info("Smart Home Dir: {}", homePath);
        log.info("Loaded logback.xml: {}", logbackConfFile);
        log.info("Loaded sping config file: {}", springConfFile);

        ApplicationContext context = new FileSystemXmlApplicationContext("file:" + springConfFile);
        final DeviceServerListener tcpListener = context.getBean(DeviceServerListener.class);

        new Thread() {
            public void run() {
                log.debug("！！！tcpListener开始启动");
                tcpListener.startListener();
            }
        }.start();
    }
}
