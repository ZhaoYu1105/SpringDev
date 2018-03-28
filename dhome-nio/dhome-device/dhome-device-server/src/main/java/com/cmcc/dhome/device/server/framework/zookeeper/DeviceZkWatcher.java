/**
 * @ dhome-device-server
 * @ com.cmcc.dhome.device.server.framework.zookeeper
 * @ DeviceZkWatcher.java
 * 
 * @author liujianliang@chinamobile.com 2016年6月29日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.device.server.framework.zookeeper;

import java.text.NumberFormat;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmcc.zeus.base.utils.StringUtil;

/**
 * 监听zookeeper节点事件
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年6月29日 - 上午10:08:05
 * @history
 *          2016年6月29日 - 上午10:08:05 liujianliang@chinamobile.com create.
 */
public class DeviceZkWatcher implements Watcher {

    private Logger        log = LoggerFactory.getLogger(this.getClass().getName());

    private ZooKeeper     zk;
    private String        rootNode;
    private String        subNode;
    private StringBuilder clusterInfo;
    private StringBuilder nodeInfo;

    /**
     * 设备节点变化监听
     * 
     * @param zk
     *            zk
     * @param rootNode
     *            上级节点
     * @param subNode
     *            当前节点
     */
    public DeviceZkWatcher(ZooKeeper zk, String rootNode, String subNode) {
        super();
        this.zk = zk;
        this.rootNode = rootNode;
        this.subNode = subNode;
        clusterInfo = new StringBuilder();
        nodeInfo = new StringBuilder();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.zookeeper.Watcher#process(org.apache.zookeeper.WatchedEvent)
     */
    @Override
    public void process(WatchedEvent event) {

        // 监控所有被触发的事件
        // 当对目录节点监控状态打开时，一旦目录节点的状态发生变化，Watcher 对象的 process 方法就会被调用。
        // log.debug("ZooKeeper EVENT: " + event.getType() + ", Path: {}",
        // event.getPath());
        // 父节点：更新
        if (rootNode.equals(event.getPath())) {
            try {
                // 清空字符串缓存
                clusterInfo.delete(0, clusterInfo.length());
                nodeInfo.delete(0, nodeInfo.length());
                // 获取总连接数
                String totalStr = new String(zk.getData(rootNode, this, null));
                int total = 0;
                if (StringUtil.notNullAndBlank(totalStr)) {
                    total = Integer.parseInt(totalStr);
                }

                List<String> childrens = zk.getChildren(rootNode, false);
                if (childrens.size() > 0) {
                    // 统计子节点数据
                    for (String child : childrens) {
                        String sdata = new String(zk.getData(rootNode + "/" + child, this, null));
                        nodeInfo.append("[" + child + "], 连接数=" + sdata + " | ");
                    }
                } else {
                    log.error("！！！根节点[{}]下没有子节点，服务器启动不正常！");
                }

                clusterInfo.append("服务器集群信息：节点服务器数=" + childrens.size() + ", 网关总连接数=" + NumberFormat.getIntegerInstance().format(total) + " | ");
                clusterInfo.append(nodeInfo);
                log.info(clusterInfo.toString());
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if ((rootNode + "/" + subNode).equals(event.getPath())) {
            // 子节点：更新、删除

            // 触发父节点进行数据统计汇总更新
            try {
                List<String> childrens = zk.getChildren(rootNode, false);
                // 汇总子节点数据，得到总连接数
                int total = 0;
                for (String child : childrens) {
                    String sdata = new String(zk.getData(rootNode + "/" + child, this, null));
                    total += Integer.parseInt(sdata);
                }

                // 并更新父节点数据
                zk.setData(rootNode, ("" + total).getBytes(), -1);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else if (event.getType().getIntValue() == EventType.NodeDeleted.getIntValue()) {
            /*
             * 子节点删除事件，说明有其它子节点挂掉了
             */
//            String diedNodePath = event.getPath();
//            String diedNode = diedNodePath.substring(diedNodePath.lastIndexOf("/") + 1, diedNodePath.length());
            // log.warn("服务器节点{}已经停止服务，请联系管理员处理！", diedNode);
//            /*
//             * 服务器节点停止后，自动从zookeeper中删除，然后要从redis缓存中清除保存在该节点中的所有连接信息
//             */
//            Map<String, String> all = RedisUtil.hgetAll(DeviceAuthResponseHandler.GATEWAY_CONNECTION_HASH);
//            int num = 0;
//            for (Map.Entry<String, String> entry : all.entrySet()) {
//                if (entry.getValue().equals(diedNode)) {
//                    num++;
//                    RedisUtil.hdel(DeviceAuthResponseHandler.GATEWAY_CONNECTION_HASH, entry.getKey());
//                }
//            }
//            log.warn("节点服务器[{}]宕机，从redis缓存中删除节点服务器[{}]上的连接信息，共[{}]条", diedNode, diedNode, num);
            // }
        }
    }

}
