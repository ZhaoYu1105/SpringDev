/**
 * @ platform-plugin-framework
 * @ com.cmcc.dhome.device.server.framework.pojo
 * @ DeviceRequestMessage.java
 * 
 * @author liujianliang@chinamobile.com 2016年4月29日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.framework.message;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.cmcc.dhome.app.device.bean.framework.common.DeviceMessageType;

/**
 * 插件TCP请求对象
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年4月29日 - 上午9:23:17
 * @history
 *          2016年4月29日 - 上午9:23:17 liujianliang@chinamobile.com create.
 */
public class DeviceRequestMessage extends DeviceMessage {

    /**
     * 
     */
    private static final long serialVersionUID = 7392418985963207059L;
    @JSONField(name = "Parameter")
    private Object            param;

    public DeviceRequestMessage() {
        super();
        setMsgType(DeviceMessageType.REQUEST);
    }

    /**
     * 从插件请求对象中构造响应对象，即复制协议体中相同属性
     */
    public DeviceResponseMessage toResponseMessage() {
        DeviceResponseMessage response = new DeviceResponseMessage();
        response.setPluginName(this.pluginName);
        response.setMethod(this.method);
        response.setSeqId(this.seqId);
        response.setDid(this.did);
        response.setSn(this.sn);
        response.setOsgiName(this.osgiName);
        response.setUserId(this.userId);
        return response;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
