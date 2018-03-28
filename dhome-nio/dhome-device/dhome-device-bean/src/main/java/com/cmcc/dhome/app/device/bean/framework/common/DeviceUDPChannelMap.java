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
import java.util.concurrent.ConcurrentHashMap;

import com.cmcc.dhome.app.device.bean.device.UDPObject;
import com.cmcc.zeus.base.utils.StringUtil;

/**
 * 插件长连接channel缓存对象
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年5月4日 - 下午6:50:57
 * @history
 *          2016年5月4日 - 下午6:50:57 liujianliang@chinamobile.com create.
 */
public class DeviceUDPChannelMap {

    /**
     * 缓存网关MAC地址，及其对应的长连接对象
     */
    private static Map<String, ConcurrentHashMap<String, UDPObject>> channelMap = new ConcurrentHashMap<String, ConcurrentHashMap<String, UDPObject>>();

    /**
     * 添加网关MAC地址及其长连接对象至缓存中
     * 
     * @param did
     * @param obj
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年9月6日 - 下午6:31:26
     * @history
     *          2017年9月6日 - 下午6:31:26 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public static void add(String did, String sn, UDPObject obj) {
        if (StringUtil.nullOrBlank(sn)) {
            sn = "EMPTY";
        }
        ConcurrentHashMap<String, UDPObject> existUdpObj = channelMap.get(did);
        if (null == existUdpObj) {
            existUdpObj = new ConcurrentHashMap<String, UDPObject>();
        }
        existUdpObj.put(sn, obj);
        channelMap.put(did, existUdpObj);
    }

    /**
     * 根据网关MAC地址从缓存中获取对应的长连接对象
     * 
     * @param did
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年9月6日 - 下午6:31:49
     * @history
     *          2017年9月6日 - 下午6:31:49 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public static UDPObject getChannel(String did, String sn) {
        if (StringUtil.notNullAndBlank(did)) {

            ConcurrentHashMap<String, UDPObject> existUdpObj = channelMap.get(did);
            if (null != existUdpObj) {
                if (StringUtil.nullOrBlank(sn) || "EMPTY".equals(sn)) {
                    for (Entry<String, UDPObject> entry : existUdpObj.entrySet()) {
                        return entry.getValue();
                    }
                } else {
                    return existUdpObj.get(sn);
                }
            }
        }
        return null;
    }

    /**
     * 从缓存中删除断开的长连接对象
     * 
     * @param did
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年9月6日 - 下午6:32:17
     * @history
     *          2017年9月6日 - 下午6:32:17 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public static UDPObject remove(String did, String sn) {
        if (StringUtil.nullOrBlank(sn)) {
            sn = "EMPTY";
        }
        ConcurrentHashMap<String, UDPObject> existUdpObj = channelMap.get(did);
        UDPObject object = null;
        if (null != existUdpObj) {
            object = existUdpObj.remove(sn);
            if (existUdpObj.isEmpty()) {
                channelMap.remove(did);
            }
        }
        return object;
    }

    /**
     * 获取当前服务器保持的连接数量
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
}
