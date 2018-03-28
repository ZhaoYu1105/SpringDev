package com.cmcc.dhome.app.device.bean.framework.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.cmcc.zeus.base.utils.StringUtil;

/**
 * 存储UDP心跳时间
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年9月11日 - 上午9:50:14
 * @history
 *          2017年9月11日 - 上午9:50:14 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class DeviceUDPHeartMap {

    // private static Logger log =
    // LoggerFactory.getLogger(DeviceUDPHeartMap.class);

    // private static SortedMap<String, String> map = new TreeMap<>();
    
    // public static ConcurrentHashMap<String, Long> conMap = new ConcurrentHashMap<>();
    public static Map<String, ConcurrentHashMap<String, Long>> conMap = new ConcurrentHashMap<String, ConcurrentHashMap<String, Long>>();

    /**
     * 记录UDP的心跳时间
     * 
     * @param did
     * @param osgiName
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年9月11日 - 上午9:57:45
     * @history
     *          2017年9月11日 - 上午9:57:45 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public static void add(String did, String osgiName, String sn) {
        if (StringUtil.notNullAndBlank(did)) {
            if (StringUtil.nullOrBlank(sn)) {
                sn = "EMPTY";
            }
            did = StringUtil.toUpper(did);
            String key = did + "_" + osgiName;
            ConcurrentHashMap<String, Long> existMap = conMap.get(key);
            if (null == existMap) {
                existMap = new ConcurrentHashMap<String, Long>();
            }
            long now = System.currentTimeMillis();
            existMap.put(sn, now);
            conMap.put(key, existMap);
        }
    }

    /**
     * 移除UDP心跳
     * 
     * @param key
     * @param sn
     * @author 蔡洁[caijie@chinamobile.com] 
     * @date 2017年10月24日 - 上午9:50:20
     * @history 
     * 		 2017年10月24日 - 上午9:50:20 蔡洁[caijie@chinamobile.com] create.
     */
    public static void remove(String key, String sn) {
        if (StringUtil.nullOrBlank(sn)) {
            sn = "EMPTY";
        }
        ConcurrentHashMap<String, Long> existMap = conMap.get(key);
        if (null != existMap) {
            existMap.remove(sn);
            if (existMap.isEmpty()) {
                conMap.remove(key);
            }
        }
    }

    // /**
    // * 清除超期的记录并返回这些数据
    // *
    // * @param time udp超期时间(3倍udp心跳时间)
    // * @author 徐海涛[xuhaitao@chinamobile.com]
    // * @date 2017年9月11日 - 下午2:07:59
    // * @history
    // * 2017年9月11日 - 下午2:07:59 徐海涛[xuhaitao@chinamobile.com] create.
    // */
    // public static ArrayList<String> clean(int time){
    // ConcurrentHashMap<String, Long> temp = new ConcurrentHashMap<>();
    // ArrayList<String> result = new ArrayList<>();
    // long now = System.currentTimeMillis();
    // long expired = now-1000*time;
    // temp.putAll(conMap);
    // log.info("MAP总大小：{}",conMap.size());
    // Set<Entry<String, Long>> entry = temp.entrySet();
    // Iterator<Entry<String, Long>> it = entry.iterator();
    // long start = System.currentTimeMillis();
    // while(it.hasNext()){
    // Entry<String, Long> element = it.next();
    // String key = element.getKey();
    // long value = element.getValue();
    // if(value < expired){
    // conMap.remove(key);
    // result.add(key);
    // }
    // }
    // long end = System.currentTimeMillis();
    // log.info("MAP中过期数据：{}",result.size());
    // log.info("清理操作耗时：{}ms",end-start);
    // log.info("MAP清理后大小：{}",conMap.size());
    // return result;
    // }
}
