/**
 * @ dhome-device-bean
 * @ com.cmcc.dhome.app.device.bean.constant
 * @ Constants.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2017年6月28日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.constant;

/**
 * 全局常量定义
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年6月28日 - 上午11:10:32
 * @history
 *          2017年6月28日 - 上午11:10:32 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class Constants {

    public static final String REDIS_PROJECT_PREFIX = "device.";                              // 工程前缀

    public static final String ONLINE_REPORT_TIME   = REDIS_PROJECT_PREFIX + "onlineReport_"; // 下挂设备上线消息上报时间（为APP侧过滤）

    public static final String ONLINE_SAVE_TIME     = REDIS_PROJECT_PREFIX + "onlineSave_";   // 下挂设备上线消息存储时间

    public static final String MESSAGE_REPORT_TIME  = REDIS_PROJECT_PREFIX + "msgReport_";    // 网关上报消息时间

    public static final String SPEED_REPORT_STATUS  = REDIS_PROJECT_PREFIX + "speedStatus";   // 网速上报状态

    public static final String SPEED_CONTROL_STATUS = REDIS_PROJECT_PREFIX + "speedControl_"; // 用户是否需要查看网速
}
