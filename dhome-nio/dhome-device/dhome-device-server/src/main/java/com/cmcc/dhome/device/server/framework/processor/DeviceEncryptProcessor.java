/**
 * @ dhome-device-server
 * @ com.cmcc.dhome.device.server.framework.processor
 * @ DeviceEncryptProcessor.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年9月29日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.device.server.framework.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceRequestMessage;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceResponseMessage;
import com.cmcc.zeus.base.utils.Encrypt;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年9月29日 - 下午7:43:58
 * @history
 *          2016年9月29日 - 下午7:43:58 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class DeviceEncryptProcessor {

    private static Logger log = LoggerFactory.getLogger(DeviceEncryptProcessor.class);

    /**
     * 用于判断message是否需要进行加/解密操作
     * 
     * @param message
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @throws Exception
     * @date 2016年9月29日 - 下午7:07:46
     * @history
     *          2016年9月29日 - 下午7:07:46 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public static DeviceMessage checkEncrypt(DeviceMessage message) throws Exception {
        String cmdType = message.getMethod();
        String type = message.getType();
        String plugin = message.getPluginName();
        log.debug("消息type为{}，cmdType为{}", type, cmdType);
        if ("response".equals(type)) {
            Object data = ((DeviceResponseMessage) message).getData();
            if ("GET_WIFI_SSID_INFO".equals(cmdType)) {
                if (data != null) {
                    String jsonArr = ((JSONObject) data).getString("WIFIList");
                    if (jsonArr != null) {
                        JSONArray jsonList = JSONArray.parseArray(jsonArr);
                        for (int i = 0; i < jsonList.size(); i++) {
                            JSONObject wifi = (JSONObject) jsonList.get(i);
                            String pwd = wifi.getString("PWD");
                            if (!StringUtils.isEmpty(pwd)) {
                                pwd = Encrypt.decryption(pwd);// 解密
                                log.debug("pwd解密后为{}", pwd);
                                // 封装
                                wifi.put("PWD", pwd);
                                jsonList.set(i, wifi);
                            }
                        }
                        ((JSONObject) data).put("WIFIList", jsonList);
                        ((DeviceResponseMessage) message).setData(data);
                    }
                }
                log.debug("wifi数据解密完成，{}", message.toString());
            } else if(("getInfo".equals(cmdType) || "setSwitch".equals(cmdType)) && "guestWifi".equals(plugin)){
                if (data != null) {
                    JSONObject jsonObj = JSONObject.parseObject(data.toString());
                    String pwd = jsonObj.getString("pwd");
                    if (!StringUtils.isEmpty(pwd)) {
                        pwd = Encrypt.decryption(pwd);// 解密
                        log.debug("pwd解密后为{}", pwd);
                        // 封装
                        jsonObj.put("pwd", pwd);
                    }
                    ((DeviceResponseMessage) message).setData(jsonObj);
                }
                log.debug("wifi数据解密完成，{}", message.toString());
            }
        } else if ("request".equals(type)) {
            Object param = ((DeviceRequestMessage) message).getParam();
            JSONObject jsonObj = new JSONObject();
            if ("SET_WIFI_SSID_INFO".equals(cmdType)) {
                if (param != null) {
                    jsonObj = (JSONObject) param;
                    String pwd = jsonObj.getString("PWD");
                    if (!StringUtils.isEmpty(pwd)) {
                        pwd = Encrypt.encryption(pwd);// 加密
                        log.debug("pwd加密后为{}", pwd);
                        // 封装
                        jsonObj.put("PWD", pwd);
                    }
                }
                ((DeviceRequestMessage) message).setParam(jsonObj);
                log.debug("wifi数据加密完成，{}", message.toString());
            }else if("setWifi".equals(cmdType) && "guestWifi".equals(plugin)){
                if (param != null) {
                    jsonObj = (JSONObject) param;
                    String pwd = jsonObj.getString("pwd");
                    if (!StringUtils.isEmpty(pwd)) {
                        pwd = Encrypt.encryption(pwd);// 加密
                        log.debug("pwd加密后为{}", pwd);
                        // 封装
                        jsonObj.put("pwd", pwd);
                    }
                }
                ((DeviceRequestMessage) message).setParam(jsonObj);
                log.debug("wifi数据加密完成，{}", message.toString());
            }
        } 
        return message;
    }
}
