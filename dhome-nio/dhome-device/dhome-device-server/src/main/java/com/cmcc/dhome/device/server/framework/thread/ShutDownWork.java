/**
 * @ dhome-device-server
 * @ com.cmcc.dhome.device.server.framework.thread
 * @ ShutDownWork.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2017年10月19日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.device.server.framework.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmcc.dhome.device.server.framework.DeviceServerListener;
import com.cmcc.zeus.base.utils.NetUtil;

/**
 * 服务关闭前的操作
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年10月19日 - 下午4:24:12
 * @history
 *          2017年10月19日 - 下午4:24:12 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class ShutDownWork extends Thread {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public void run() {

        DeviceServerListener.authStatus = false;// 缓存清理期间拒绝所有新连接

        // Set<String> keys = DeviceChannelMap.getKeys();

        String localIp = NetUtil.getServerInstanceName();
        log.info("开始清理{}的缓存数据！！！！", localIp);

        // Iterator<String> it = keys.iterator();
        // while (it.hasNext()) {
        // String gwid = it.next();
        // String ip = RedisUtil.get("tcpconnection:hash:" + gwid);
        // if (ip != null && ip.contains(localIp)) {
        // RedisUtil.deleteKey("tcpconnection:hash:" + gwid);
        // }
        // }
        log.warn("！！！{}的缓存清理完成服务即将关闭", localIp);
    }
}
