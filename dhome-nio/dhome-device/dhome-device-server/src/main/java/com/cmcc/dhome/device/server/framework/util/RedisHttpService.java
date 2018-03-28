package com.cmcc.dhome.device.server.framework.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cmcc.zeus.base.utils.HttpUtils;

/**
 * 封装对远程redis的操作
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年9月15日 - 下午8:18:15
 * @history
 *          2017年9月15日 - 下午8:18:15 徐海涛[xuhaitao@chinamobile.com] create.
 */
@Service
public class RedisHttpService {

    private Logger log     = LoggerFactory.getLogger(this.getClass().getName());

    private String baseUrl = "http://127.0.0.1:8080";
    
    private String status = "0";//为1时允许将数据同步给远程redis
    
    private String place;//服务器所在机房shiqiao,hongshan,sichuan,xiaoshan等

    /**
     * 远程hget调用
     * 
     * @param key
     * @param field
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年9月15日 - 下午8:30:31
     * @history
     *          2017年9月15日 - 下午8:30:31 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public String hgetHttp(String key, String field) {
        if("0".equals(status)){
            log.info("不进行远程redis调用");
            return null;
        }
        Map<String, String> param = new HashMap<>();
        param.put("key", key);
        param.put("field", field);
        Map<String, Object> response = HttpUtils.doGet(baseUrl + "/transfer/device/hget", param);
        int sttsCode = (int) response.get("httpStts");
        if (sttsCode == 200) {
            String responseData = (String) response.get("responseData");
            return responseData;
        }else {
            log.info("hgetHttp请求返回结果为：{}", sttsCode);
            return null;
        }
    }
    
    /**
     * 远程hdel调用
     * 
     * @param key
     * @param field
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年9月15日 - 下午8:30:31
     * @history
     *          2017年9月15日 - 下午8:30:31 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public String hdelHttp(String key, String field) {
        if("0".equals(status)){
            log.info("不进行远程redis调用");
            return null;
        }
        Map<String, String> param = new HashMap<>();
        param.put("key", key);
        param.put("field", field);
        Map<String, Object> response = HttpUtils.doGet(baseUrl + "/transfer/device/hdel", param);
        int sttsCode = (int) response.get("httpStts");
        if (sttsCode == 200) {
            String responseData = (String) response.get("responseData");
            return responseData;
        }else {
            log.info("hdelHttp请求返回结果为：{}", sttsCode);
            return null;
        }
    }
    
    /**
     * 远程hset调用
     * 
     * @param key
     * @param field
     * @param value
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年9月15日 - 下午8:30:31
     * @history
     *          2017年9月15日 - 下午8:30:31 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public boolean hsetHttp(String key, String field, String value) {
        if("0".equals(status)){
            log.info("不进行远程redis调用");
            return false;
        }
        Map<String, String> param = new HashMap<>();
        param.put("key", key);
        param.put("field", field);
        param.put("value", value);
        param.put("place", place);
        Map<String, Object> response = HttpUtils.doGet(baseUrl + "/transfer/device/hset", param);
        int sttsCode = (int) response.get("httpStts");
        if (sttsCode == 200) {
            String responseData = (String) response.get("responseData");
            if("true".equals(responseData)){
                return true;
            }
        }else {
            log.info("hsetHttp请求返回结果为：{}", sttsCode);
        }
        return false;
    }
    
    /**
     * 远程set/setex调用
     * 
     * @param key
     * @param value
     * @param time 为空时调用set方法，不为空时调用setex
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年9月15日 - 下午8:30:31
     * @history
     *          2017年9月15日 - 下午8:30:31 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public boolean setHttp(String key, String value, String time) {
        if("0".equals(status)){
            log.info("不进行远程redis调用");
            return false;
        }
        Map<String, String> param = new HashMap<>();
        param.put("key", key);
        param.put("value", value);
        if(time != null){
            param.put("time", time);
        }
        Map<String, Object> response = HttpUtils.doGet(baseUrl + "/transfer/device/set", param);
        int sttsCode = (int) response.get("httpStts");
        if (sttsCode == 200) {
            String responseData = (String) response.get("responseData");
            if("true".equals(responseData)){
                return true;
            }
        }else {
            log.info("setHttp请求返回结果为：{}", sttsCode);
        }
        return false;
    }
    
    /**
     * 远程获取TCP重连消息的发送状态
     * 
     * @param did
     * @param osgi
     * @param sn 非问题网关填EMPTY
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年9月15日 - 下午8:30:31
     * @history
     *          2017年9月15日 - 下午8:30:31 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public boolean tcpReStatusHttp(String did, String osgi, String sn) {
        if("0".equals(status)){
            log.info("不进行远程redis调用");
            return false;
        }
        Map<String, String> param = new HashMap<>();
        param.put("did", did);
        param.put("osgi", osgi);
        param.put("sn", sn);
        Map<String, Object> response = HttpUtils.doGet(baseUrl + "/transfer/device/tcpReStatus", param);
        int sttsCode = (int) response.get("httpStts");
        if (sttsCode == 200) {
            String responseData = (String) response.get("responseData");
            if("true".equals(responseData)){
                return true;
            }
        }else {
            log.info("tcpReStatusHttp请求返回结果为：{}", sttsCode);
        }
        return false;
    }
    
    /**
     * 远程初始化清理redis中数据
     * 
     * @param ip
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年9月15日 - 下午8:30:31
     * @history
     *          2017年9月15日 - 下午8:30:31 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public boolean initCleanHttp(String ip) {
        if("0".equals(status)){
            log.info("不进行远程redis调用");
            return false;
        }
        Map<String, String> param = new HashMap<>();
        param.put("ip", ip);
        Map<String, Object> response = HttpUtils.doGet(baseUrl + "/transfer/device/init", param);
        int sttsCode = (int) response.get("httpStts");
        if (sttsCode == 200) {
            String responseData = (String) response.get("responseData");
            if("true".equals(responseData)){
                return true;
            }
        }else {
            log.info("initCleanHttp请求返回结果为：{}", sttsCode);
        }
        return false;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getPlace() {
        return place;
    }
    
    public void setPlace(String place) {
        this.place = place;
    }
    
    public static void main(String[] args){
        RedisHttpService rph = new RedisHttpService();
        boolean res = rph.initCleanHttp("127.0.0.1");
        System.out.println(res);
    }
}
