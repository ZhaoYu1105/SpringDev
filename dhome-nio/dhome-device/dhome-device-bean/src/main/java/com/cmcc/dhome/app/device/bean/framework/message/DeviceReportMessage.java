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
import com.cmcc.dhome.app.device.bean.enums.DevMethodType;
import com.cmcc.dhome.app.device.bean.enums.DeviceCodeType;
import com.cmcc.dhome.app.device.bean.framework.common.DeviceMessageType;
import com.cmcc.zeus.base.core.message.MessagePush;

/**
 * 插件TCP主动上报对象，接收到该类型对象，不写响应
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年4月29日 - 上午9:23:17
 * @history
 *          2016年4月29日 - 上午9:23:17 liujianliang@chinamobile.com create.
 */
public class DeviceReportMessage extends DeviceMessage {

    /**
     * 
     */
    private static final long serialVersionUID = 7392418985963207059L;
    @JSONField(name = "Parameter")
    private Object            param;

    public DeviceReportMessage() {
        super();
        setMsgType(DeviceMessageType.REPORT);
    }

    /**
     * 从插件请求对象中构造响应对象，即复制协议体中相同属性
     */
    public DeviceResponseMessage toPluginResponse() {
        DeviceResponseMessage response = new DeviceResponseMessage();
        response.setPluginName(this.pluginName);
        response.setMethod(this.method);
        response.setSeqId(this.seqId);
        response.setDid(this.did);
        response.setOsgiName(this.osgiName);
        return response;
    }

    /**
     * 将插件数据格式转化为推送给APP的格式
     * 
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2016年5月12日 - 上午10:49:49
     * @history
     *          2016年5月12日 - 上午10:49:49 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public MessagePush toPushMessage() {
        MessagePush push = new MessagePush();
        push.setType(this.pluginName + "_" + this.method);
        push.setSeqId(this.seqId);
        push.setDid(this.did);
        push.setData(this.param);
        return push;
    }

    /**
     * 网关基础功能接口格式转化为推送给APP的格式
     * 
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2016年5月12日 - 上午10:49:49
     * @history
     *          2016年5月12日 - 上午10:49:49 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public MessagePush deviceToPushMessage() {
        MessagePush push = new MessagePush();
        push.setType(DevMethodType.getByCmd(this.method));
        push.setSeqId(this.seqId);
        push.setData(this.param);
        push.setCode(DeviceCodeType.SUCCESS.getCode());
        push.setDid(this.did);
        return push;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }
}
