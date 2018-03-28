/**
 * @ dhome-device-server
 * @ com.cmcc.dhome.device.server.framework.processor
 * @ OnoffMessageProcessor.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2017年8月17日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.device.server.framework.processor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.cmcc.dhome.app.device.bean.constant.Constants;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceReportMessage;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年8月17日 - 下午2:38:39
 * @history 
 * 		 2017年8月17日 - 下午2:38:39 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class OnoffMessageProcessor {

    private static Logger log      = LoggerFactory.getLogger(OnoffMessageProcessor.class);

    static int      INTERVAL_PARAM  = 300;// 上报消息的间隔时间，单位秒（实际在配置文件中设置）
    
    
    /**
     * 过滤过于频繁的设备上线消息
     * 
     * @param report 设备上线消息
     * @return true为推送
     * @author 徐海涛[xuhaitao@chinamobile.com] 
     * @date 2017年8月17日 - 下午5:20:32
     * @history 
     * 		 2017年8月17日 - 下午5:20:32 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public static boolean onlineMsgFilter(DeviceReportMessage report){
        String mac = report.getDid();
        Object data = report.getParam();
        if(data != null){
            JSONObject json = (JSONObject) data;
            String deviceMac = json.getString("DeviceMAC");
            if(deviceMac != null){
                return deviceMsgRecentlyReported(mac, deviceMac, 0);
            }
        }
        return false;
    }
    
    /**
     * 过滤过于频繁的设备下线消息
     * 
     * @param report 设备下线消息
     * @return true为推送
     * @author 徐海涛[xuhaitao@chinamobile.com] 
     * @date 2017年8月17日 - 下午5:25:03
     * @history 
     * 		 2017年8月17日 - 下午5:25:03 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public static boolean offlineMsgFilter(DeviceReportMessage report){
        String mac = report.getDid();
        Object data = report.getParam();
        if(data != null){
            JSONObject json = (JSONObject) data;
            String deviceMac = json.getString("devMac");
            if(deviceMac != null){
                return deviceMsgRecentlyReported(mac, deviceMac, 1);
            }
        }
        return false;
    }
    
    /**
     * 判断网关下挂设备最近是否上报过上线消息
     * 
     * @param mac
     *            网关mac
     * @param deviceMac
     *            下挂设备mac
     * @param msgType
     *            消息类型：0上线消息，1下线消息
     * @return true可以上报消息，false暂时不上报
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年6月28日 - 上午10:52:54
     * @history
     *          2017年6月28日 - 上午10:52:54 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public static boolean deviceMsgRecentlyReported(String mac, String deviceMac, int msgType) {

        if(INTERVAL_PARAM == 0){
            return true;  // 为0时不做任何过滤
        }else if (INTERVAL_PARAM == -1) {
            return false; // 为-1时全部过滤
        }
        
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = df.format(now);
        String key = Constants.MESSAGE_REPORT_TIME + msgType + ":" + mac + ":" + deviceMac;
        String lastReportTime = null;//RedisUtil.get(key);// 上线消息上次上报时间
        log.debug("{}类型消息上次上报时间{}", msgType, lastReportTime);
        if (lastReportTime == null) {
            /**
             * 距上一次上报已超过间隔时间,重设上报时间
             */
//            RedisUtil.setex(key, time, INTERVAL_PARAM);
            return true;
        }
        return false;
    }

    public static int getIntervalParam() {
        return INTERVAL_PARAM;
    }

    public static void setIntervalParam(int intervalParam) {
        INTERVAL_PARAM = intervalParam;
    }
    
}
