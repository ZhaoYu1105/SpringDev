/**
 * @ platform-plugin-framework
 * @ com.cmcc.dhome.device.server.framework.pojo
 * @ DeviceMessage.java
 * 
 * @author liujianliang@chinamobile.com 2016年5月4日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.framework.message;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 插件消息对象，封装插件消息通用部分
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年5月4日 - 下午4:44:42
 * @history
 *          2016年5月4日 - 下午4:44:42 liujianliang@chinamobile.com create.
 */
public class DeviceMessage extends DeviceBaseMessage {
    /**
     * 
     */
    private static final long serialVersionUID = -7186774327856713788L;
    @JSONField(name = "PluginName")
    protected String          pluginName;
    @JSONField(name = "CmdType")
    protected String          method;
    @JSONField(name = "SequenceId")
    @NotNull(message = "缺少参数seqId")
    @NotBlank(message = "seqId不能为空")
    @Pattern(regexp = "[a-fA-F0-9]{8}", message = "seqId必须为8位16进制")
    protected String          seqId;
    @JSONField(name = "UserId")
    @NotBlank(message = "userId不能为空")
    @NotNull(message = "缺少参数userId")
    protected String          userId;
    @JSONField(name = "RPCMethod")
    protected String          rpcMethod;
    @JSONField(name = "ID")
    protected String          id;

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
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

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
