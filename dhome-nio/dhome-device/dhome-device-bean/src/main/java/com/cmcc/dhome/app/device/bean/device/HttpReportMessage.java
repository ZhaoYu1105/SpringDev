/**
 * @ dhome-device-bean
 * @ com.cmcc.dhome.app.device.bean.device
 * @ HttpReportMessage.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2017年4月19日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年4月19日 - 下午3:31:40
 * @history
 *          2017年4月19日 - 下午3:31:40 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class HttpReportMessage implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6457268259550664425L;

    @JsonProperty(value = "MAC")
    @NotNull(message = "缺少参数MAC")
    @NotBlank(message = "MAC不能为空")
    private String            did;
    @JsonProperty(value = "SN")
    private String            sn;
    @JsonProperty(value = "Type")
    @NotNull(message = "缺少参数Type")
    @NotBlank(message = "Type不能为空")
    private String            type;
    @JsonProperty(value = "OsgiName")
    private String            osgiName         = "DEFAULT";            // 用于标识插件类型
    @JsonProperty(value = "PluginName")
    @NotNull(message = "缺少参数PluginName")
    @NotBlank(message = "PluginName不能为空")
    private String            pluginName;
    @JsonProperty(value = "CmdType")
    private String            cmdType;
    @JsonProperty(value = "UserId")
    private String            userId;
    @JsonProperty(value = "RPCMethod")
    @NotNull(message = "缺少参数RPCMethod")
    @NotBlank(message = "RPCMethod不能为空")
    private String            rpcMethod;
    @JsonProperty(value = "ID")
    private String            id;
    @JsonProperty(value = "SequenceId")
    private String            sequenceId;
    @JsonProperty(value = "Parameter")
    @NotNull(message = "缺少参数Parameter")
    private Object            param;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOsgiName() {
        return osgiName;
    }

    public void setOsgiName(String osgiName) {
        this.osgiName = osgiName;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public String getCmdType() {
        return cmdType;
    }

    public void setCmdType(String cmdType) {
        this.cmdType = cmdType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRpcMethod() {
        return rpcMethod;
    }

    public void setRpcMethod(String rpcMethod) {
        this.rpcMethod = rpcMethod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

}
