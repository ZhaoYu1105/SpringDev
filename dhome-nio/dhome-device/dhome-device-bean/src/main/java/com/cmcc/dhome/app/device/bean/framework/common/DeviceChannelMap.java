/**
 * @ platform-base-core
 * @ com.cmcc.dhome.core.plugin
 * @ DeviceChannelMap.java
 * 
 * @author liujianliang@chinamobile.com 2016年5月4日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.framework.common;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import com.cmcc.zeus.base.utils.StringUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import io.netty.channel.socket.SocketChannel;

/**
 * 插件长连接channel缓存对象
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年5月4日 - 下午6:50:57
 * @history
 *          2016年5月4日 - 下午6:50:57 liujianliang@chinamobile.com create.
 */
public class DeviceChannelMap {

    /**
     * 缓存网关MAC地址，及其对应的长连接对象
     */
    private static Map<String, ConcurrentHashMap<String, SocketChannel>> channelMap = new ConcurrentHashMap<String, ConcurrentHashMap<String, SocketChannel>>();

    public static LoadingCache<Long, AtomicLong>                         counter    = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.SECONDS)
            .build(new CacheLoader<Long, AtomicLong>() {
                                                                                                @Override
                                                                                                public AtomicLong load(Long seconds) throws Exception {
                                                                                                    return new AtomicLong(0);
                                                                                                }
                                                                                            });

    /**
     * 添加网关MAC地址及其长连接对象至缓存中
     * 
     * @param did
     *            网关MAC地址
     * @param sn
     *            网关SN
     * @param socketChannel
     *            长连接对象
     * @author liujianliang@chinamobile.com
     * @date 2016年5月4日 - 下午6:53:42
     * @history
     *          2016年5月4日 - 下午6:53:42 liujianliang@chinamobile.com create.
     */
    public static void add(String did, String sn, SocketChannel socketChannel) {
        if (StringUtil.nullOrBlank(sn)) {
            sn = "EMPTY";
        }
        ConcurrentHashMap<String, SocketChannel> existChannel = channelMap.get(did);
        if (null == existChannel) {
            existChannel = new ConcurrentHashMap<String, SocketChannel>();
        }
        existChannel.put(sn, socketChannel);
        if (!"EMPTY".equals(sn)) {
            // 清除网关升级等异常情况残留的旧连接
            existChannel.remove("EMPTY");
        }
        channelMap.put(did, existChannel);
    }

    /**
     * 根据网关MAC地址从缓存中获取对应的长连接对象
     * 
     * @param did
     *            网关MAC地址
     * @param sn
     *            网关SN
     * @return 长连接对象
     * @author liujianliang@chinamobile.com
     * @date 2016年5月4日 - 下午6:55:34
     * @history
     *          2016年5月4日 - 下午6:55:34 liujianliang@chinamobile.com create.
     */
    public static SocketChannel get(String did, String sn) {
        if (StringUtil.notNullAndBlank(did)) {
            ConcurrentHashMap<String, SocketChannel> existChannel = channelMap.get(did);
            if (null != existChannel) {
                if (StringUtil.nullOrBlank(sn) || "EMPTY".equals(sn)) {
                    for (Entry<String, SocketChannel> entry : existChannel.entrySet()) {
                        return entry.getValue();
                    }
                } else {
                    return existChannel.get(sn);
                }
            }
        }
        return null;
    }

    /**
     * 从缓存中删除断开的长连接对象
     * 
     * @param did
     *            网关MAC地址
     * @param sn
     *            网关SN
     * @return 返回被删除的连接，如果did不存在，返回null
     * @author liujianliang@chinamobile.com
     * @date 2016年5月4日 - 下午6:55:37
     * @history
     *          2016年5月4日 - 下午6:55:37 liujianliang@chinamobile.com create.
     */
    public static SocketChannel remove(String did, String sn) {
        if (StringUtil.nullOrBlank(sn)) {
            sn = "EMPTY";
        }
        SocketChannel channel = null;
        ConcurrentHashMap<String, SocketChannel> existChannel = channelMap.get(did);
        if (null != existChannel) {
            channel = existChannel.remove(sn);
            if (existChannel.isEmpty()) {
                channelMap.remove(did);
            }
        }
        return channel;
    }

    /**
     * 获取当前服务器保持的连接数量（由于存在Map的嵌套，无法统计精确的连接数）
     * 
     * @return 当前服务器保持的连接数量
     * @author liujianliang@chinamobile.com
     * @date 2016年6月17日 - 上午10:25:13
     * @history
     *          2016年6月17日 - 上午10:25:13 liujianliang@chinamobile.com create.
     */
    public static int size() {
        return channelMap.size();
    }

    /**
     * 获取channelMap的所有key值
     * 
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年10月19日 - 下午6:33:43
     * @history
     *          2017年10月19日 - 下午6:33:43 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public static Set<String> getKeys() {
        return channelMap.keySet();
    }
}
