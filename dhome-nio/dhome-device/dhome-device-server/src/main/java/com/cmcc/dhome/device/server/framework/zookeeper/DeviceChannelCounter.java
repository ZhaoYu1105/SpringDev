/**
 * @ dhome-device-bean
 * @ com.cmcc.dhome.app.device.bean.framework.common
 * @ DeviceChannelCounter.java
 * 
 * @author liujianliang@chinamobile.com 2016年6月20日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.device.server.framework.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.KeeperException.ConnectionLossException;
import org.apache.zookeeper.KeeperException.NoNodeException;
import org.apache.zookeeper.KeeperException.SessionExpiredException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmcc.dhome.app.device.bean.framework.common.DeviceChannelMap;
import com.cmcc.zeus.base.utils.NetUtil;
import com.cmcc.zeus.base.utils.StringUtil;

/**
 * 用于定时监视网关连接数量
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年6月20日 - 下午12:57:55
 * @history
 *          2016年6月20日 - 下午12:57:55 liujianliang@chinamobile.com create.
 */
public class DeviceChannelCounter implements Runnable, Watcher {

    private Logger         log                = LoggerFactory.getLogger(this.getClass().getName());

    private String         zkurl;
    private int            timeout;
    private int            port;

    private ZooKeeper      zk                 = null;
    private CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private String         rootNode           = "/dhome/clusterServer/devices";
    private String         subNode            = "device-server";

    private Watcher        deviceWatcher;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        // 没有zookeeper环境，不使用zookeeper，统计时仅仅是当前实例中的连接数
        if (StringUtil.nullOrBlank(getZkurl())) {
            log.info("当前服务器节点[{}]网关连接数量：{}", subNode, DeviceChannelMap.size());
        } else {
            // 如果zookeeper连接是alive的
            if (zk != null) {
                if (zk.getState().isAlive()) {
                    try {
                        log.debug("当前服务器节点[{}]网关连接数量：{}", subNode, DeviceChannelMap.size());
                        // 定时将当前实例中的连接数量更新到zookeeper节点上，子节点数据更新，触发父节点进行汇总统计
                        zk.setData(rootNode + "/" + subNode, ("" + DeviceChannelMap.size()).getBytes(), -1);
                    } catch (KeeperException e) {
                        log.error("更新节点[{}]上网关连接数量({})数据失败，尝试恢复中...，失败原因：{}", rootNode + "/" + subNode, DeviceChannelMap.size(), e);
                        if (e instanceof SessionExpiredException) {
                            /*
                             * 连接不可用，关闭旧连接并重连，然后创建当前临时子节点
                             */
                            closeAndReConnectionAndCreateCurrNode();
                        } else if (e instanceof ConnectionLossException) {
                            /*
                             * 连接不可用，关闭旧连接并重连，然后创建当前临时子节点
                             */
                            closeAndReConnectionAndCreateCurrNode();
                        } else if (e instanceof NoNodeException) {
                            /*
                             * 创建并监听当前节点
                             */
                            createCurrNode();
                        }
                    } catch (InterruptedException e) {
                        log.error("更新节点[{}]上网关连接数量({})数据失败，原因：{}", rootNode + "/" + subNode, DeviceChannelMap.size(), e);
                    }
                } else {
                    /*
                     * 连接不可用，关闭旧连接并重连，然后创建当前临时子节点
                     */
                    closeAndReConnectionAndCreateCurrNode();
                }
            } else {
                log.warn("zookeeper未连接！准备进行重连...");
                connectedSemaphore = new CountDownLatch(1);
                // 创建zookeeper连接，使用CountDownLatch进行同步操作
                createConnection(getZkurl(), getTimeout());
            }
        }
    }

    /**
     * 初始化zookeeper，包括建立连接和注册节点监听
     * 
     * @author liujianliang@chinamobile.com
     * @date 2016年6月29日 - 上午10:22:01
     * @history
     *          2016年6月29日 - 上午10:22:01 liujianliang@chinamobile.com create.
     */
    public void init() {
        // 获取本机内网IP地址
        String localAddress = NetUtil.getServerInstanceName();
        subNode = localAddress + ":" + port;
        log.debug("subNodeName={}", subNode);

        // 没有zookeeper环境，不使用zookeeper，统计时仅仅是当前实例中的连接数
        if (StringUtil.nullOrBlank(getZkurl())) {
            return;
        }

        // 创建zookeeper连接，使用CountDownLatch进行同步操作
        createConnection(getZkurl(), getTimeout());

        deviceWatcher = new DeviceZkWatcher(zk, rootNode, subNode);

        /*
         * 创建持久化的根目录节点 , 并给它设置数据=当前服务器连接总数，初始化为0；
         */
        createPath(rootNode, "0", CreateMode.PERSISTENT);
        try {
            /*
             * 监听：父节点自身的删除、数据更新
             */
            zk.getData(rootNode, deviceWatcher, null);
        } catch (KeeperException e) {
            log.error("节点[{}]注册事件监听失败，原因：{}", rootNode, e);
        } catch (InterruptedException e) {
            log.error("节点[{}]注册事件监听失败，原因：{}", rootNode, e);
        }

        /*
         * 创建并监听当前节点
         */
        createCurrNode();
    }

    /**
     * 创建ZK连接
     *
     * @param zkurl
     *            ZK服务器地址列表
     * @param sessionTimeout
     *            Session超时时间
     */
    private void createConnection(String zkurl, int sessionTimeout) {
        try {
            log.debug("开始创建zookeeper[{}]连接...", zkurl);
            zk = new ZooKeeper(zkurl, sessionTimeout, this);
            connectedSemaphore.await();
        } catch (InterruptedException e) {
            log.error("zookeeper连接创建失败，发生 InterruptedException", e);
        } catch (IOException e) {
            log.error("zookeeper连接创建失败，发生 IOException", e);
        }
    }

    /**
     * 关闭就zookeeper连接，并且重连
     * 
     * @author liujianliang@chinamobile.com
     * @date 2016年9月21日 - 下午4:26:41
     * @history
     *          2016年9月21日 - 下午4:26:41 liujianliang@chinamobile.com create.
     */
    private void closeAndReConnection() {
        if (zk != null) {
            log.warn("zookeeper连接连接有问题或者已经断开！先关闭旧连接，再准备进行重连...");
            try {
                // 1、关闭旧连接
                zk.close();
                zk = null;
            } catch (InterruptedException e) {
            }
            /*
             * 2、重连
             */
            connectedSemaphore = new CountDownLatch(1);
            // 创建zookeeper连接，使用CountDownLatch进行同步操作
            createConnection(getZkurl(), getTimeout());
        }
    }

    /**
     * 关闭就zookeeper连接，并且重连，然后创建当前临时子节点
     * 
     * @author liujianliang@chinamobile.com
     * @date 2016年9月21日 - 下午4:26:41
     * @history
     *          2016年9月21日 - 下午4:26:41 liujianliang@chinamobile.com create.
     */
    private void closeAndReConnectionAndCreateCurrNode() {
        /*
         * 关闭就zookeeper连接，并且重连
         */
        closeAndReConnection();

        /*
         * 创建并监听当前节点
         */
        createCurrNode();
    }

    /**
     * 创建并监听当前节点
     * 
     * @author liujianliang@chinamobile.com
     * @date 2016年9月21日 - 下午4:28:40
     * @history
     *          2016年9月21日 - 下午4:28:40 liujianliang@chinamobile.com create.
     */
    private void createCurrNode() {
        /*
         * 创建临时子节点，节点值表示当前节点连接数，初始化为0
         */
        createNode(rootNode + "/" + subNode, "0", CreateMode.EPHEMERAL);
        try {
            /*
             * 监听：子节点自身的删除、数据更新
             */
            zk.getData(rootNode + "/" + subNode, deviceWatcher, null);
            /*
             * 监听：监听根节点的删除和创建子节点事件。
             * 用于当当前服务器子节点关闭后，其它子节点能够收到该节点删除事件，从而可以删除redis缓存中的连接数据
             */
            zk.getChildren(rootNode, deviceWatcher, null);
        } catch (KeeperException e) {
            log.error("节点[{}]注册事件监听失败，原因：{}", rootNode + "/" + subNode, e);
        } catch (InterruptedException e) {
            log.error("节点[{}]注册事件监听失败，原因：{}", rootNode + "/" + subNode, e);
        }
    }

    /**
     * 创建明确子节点
     *
     * @param path
     *            节点path
     * @param data
     *            初始数据内容
     * @param mode
     *            CreateMode 标识有四种形式的目录节点，分别是：
     *            PERSISTENT：持久化目录节点，这个目录节点存储的数据不会丢失；
     *            PERSISTENT_SEQUENTIAL：顺序自动编号的目录节点，这种目录节点会根据当前已近存在的节点数自动加1，
     *            然后返回给客户端已经成功创建的目录节点名；
     *            EPHEMERAL：临时目录节点，一旦创建这个节点的客户端与服务器端口也就是 session 超时，这种节点会被自动删除；
     *            EPHEMERAL_SEQUENTIAL：临时自动编号节点
     * @return 新节点路径
     */
    private String createNode(String path, String data, CreateMode mode) {
        try {
            // 不是临时节点
            // if (!mode.isEphemeral()) {
            Stat stat = zk.exists(path, false);
            if (stat != null) {
                log.warn("zookeeper节点已经存在, Path: {}", path);
                return path;
            }
            // }
            String node = this.zk.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, mode);
            log.debug("zookeeper节点创建成功, Path: " + node + ", content: " + data);
            return node;
        } catch (KeeperException e) {
            log.error("zookeeper节点[{}]创建失败，{}", path, e);
        } catch (InterruptedException e) {
            log.error("zookeeper节点[{}]创建失败，{}", path, e);
        }
        return null;
    }

    /**
     * 创建节点路径，可以递归创建上级节点
     *
     * @param path
     *            节点path
     * @param data
     *            初始数据内容
     * @param mode
     *            CreateMode 标识有四种形式的目录节点，分别是：
     *            PERSISTENT：持久化目录节点，这个目录节点存储的数据不会丢失；
     *            PERSISTENT_SEQUENTIAL：顺序自动编号的目录节点，这种目录节点会根据当前已近存在的节点数自动加1，
     *            然后返回给客户端已经成功创建的目录节点名；
     *            EPHEMERAL：临时目录节点，一旦创建这个节点的客户端与服务器端口也就是 session 超时，这种节点会被自动删除；
     *            EPHEMERAL_SEQUENTIAL：临时自动编号节点
     * @return
     */
    private boolean createPath(String path, String data, CreateMode mode) {
        try {
            // 上级节点路径
            String parent = path.substring(0, path.lastIndexOf("/"));
            // 上级节点不是空，并且上级节点不存在，先创建上级节点
            if (StringUtil.notNullAndBlank(parent) && zk.exists(parent, false) == null) {
                log.debug("zookeeper节点[{}]上级节点不存在，先创建上级节点: {}", path, parent);
                createPath(parent, "", CreateMode.PERSISTENT);
            }
            createNode(path, data, mode);
        } catch (KeeperException e) {
            log.error("zookeeper节点[{}]创建失败，{}", path, e);
        } catch (InterruptedException e) {
            log.error("zookeeper节点[{}]创建失败，{}", path, e);
        }
        return true;
    }

    /**
     * 收到来自Server的Watcher通知后的处理。
     */
    @Override
    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {
            log.debug("连接zookeeper成功!");
            connectedSemaphore.countDown();
        }
    }

    /**
     * 去掉url之间的空格，空格会导致zookeeper连接异常
     * 
     * @return
     * @author liujianliang@chinamobile.com
     * @date 2016年6月28日 - 下午9:14:40
     * @history
     *          2016年6月28日 - 下午9:14:40 liujianliang@chinamobile.com create.
     */
    public String getZkurl() {
        return zkurl.replaceAll(" ", "");
    }

    public void setZkurl(String zkurl) {
        this.zkurl = zkurl;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        String path = "/dhome/abc/edf";
        String parent = path.substring(0, path.lastIndexOf("/"));
        System.out.println(parent);
    }
}
