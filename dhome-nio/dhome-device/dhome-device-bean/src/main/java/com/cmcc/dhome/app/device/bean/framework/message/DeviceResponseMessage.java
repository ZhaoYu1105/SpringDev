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
import com.cmcc.dhome.app.device.bean.framework.common.DeviceMessageType;
import com.cmcc.zeus.base.core.message.MessagePush;

/**
 * 插件TCP响应对象
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年4月29日 - 上午9:23:17
 * @history
 *          2016年4月29日 - 上午9:23:17 liujianliang@chinamobile.com create.
 */
public class DeviceResponseMessage extends DeviceMessage {
    /**
     * 
     */
    private static final long serialVersionUID = -6296590052078929696L;
    @JSONField(name = "Result")
    private String            result;
    @JSONField(name = "ResultData")
    private Object            data;

    public DeviceResponseMessage() {
        super();
        setMsgType(DeviceMessageType.RESPONSE);
    }

    /**
     * 从插件响应对象中构造请求对象，即复制协议体中相同属性
     */
    public DeviceRequestMessage toRequestMessage() {
        DeviceRequestMessage request = new DeviceRequestMessage();
        request.setPluginName(this.pluginName);
        request.setMethod(this.method);
        request.setSeqId(this.seqId);
        request.setDid(this.did);
        request.setOsgiName(this.osgiName);
        return request;
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
        push.setSeqId(this.seqId);
        push.setCode(this.result);
        push.setType(this.pluginName + "_" + this.method);
        push.setDid(this.did);
        push.setSn(this.sn);
        push.setData(this.data);
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
        push.setCode(this.result);
        push.setDid(this.did);
        push.setSn(this.sn);
        push.setData(this.data);
        return push;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 设置错误时（result != 0）的响应内容
     * 
     * @param result
     *            错误码
     * @param reason
     *            错误描述
     * @author liujianliang@chinamobile.com
     * @date 2016年5月4日 - 下午8:28:18
     * @history
     *          2016年5月4日 - 下午8:28:18 liujianliang@chinamobile.com create.
     */
    public void setFailedResult(String result, String reason) {
        if (!"1000000".equals(result)) {
            this.setResult(result);
            JSONObject reasonJson = new JSONObject();
            reasonJson.put("FailReason", reason);
            this.setData(reasonJson);
        }
    }

    /**
     * 设置成功响应消息
     * 
     * @author liujianliang@chinamobile.com
     * @date 2016年5月5日 - 下午1:27:36
     * @history
     *          2016年5月5日 - 下午1:27:36 liujianliang@chinamobile.com create.
     */
    public void setSuccessResult() {
        this.setResult("1000000");
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
