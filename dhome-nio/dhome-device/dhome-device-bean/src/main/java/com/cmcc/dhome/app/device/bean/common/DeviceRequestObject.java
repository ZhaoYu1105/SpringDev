/**
 * @ platform-base-bean
 * @ com.cmcc.zeus.base.bean.jsonbean
 * @ DeviceRequestObject.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年3月2日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.common;

import java.util.Map;

import com.cmcc.dhome.app.device.bean.enums.DevMethodType;

/**
 * 封装向设备子系统发送的请求参数
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年3月2日 - 下午7:33:19
 * @history
 *          2016年3月2日 - 下午7:33:19 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class DeviceRequestObject {

    private String              did;
    private String              responseurl;
    private String              rpcMethod;
    private String              cmdType;
    private String              sequenceId;
    private String              actionId;
    private Map<String, Object> body;

    public DeviceRequestObject() {
    }

    public DeviceRequestObject(String did, String sequenceId, String responseurl, DevMethodType devMethodType, Map<String, Object> body) {
        super();
        this.did = did;
        this.responseurl = responseurl;
        this.rpcMethod = devMethodType.getRpcMethod();
        this.cmdType = devMethodType.getCmdType();
        this.sequenceId = sequenceId;
        this.body = body;
        this.actionId = devMethodType.getActionId();
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getResponseurl() {
        return responseurl;
    }

    public void setResponseurl(String responseurl) {
        this.responseurl = responseurl;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public String getRpcMethod() {
        return rpcMethod;
    }

    public void setRpcMethod(String rpcMethod) {
        this.rpcMethod = rpcMethod;
    }

    public String getCmdType() {
        return cmdType;
    }

    public void setCmdType(String cmdType) {
        this.cmdType = cmdType;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

}
