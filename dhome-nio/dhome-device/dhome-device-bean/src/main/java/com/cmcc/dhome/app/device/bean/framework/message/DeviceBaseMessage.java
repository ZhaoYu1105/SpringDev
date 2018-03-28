/**
 * @ platform-plugin-framework
 * @ com.cmcc.dhome.device.server.framework.pojo
 * @ DeviceMessage.java
 * 
 * @author liujianliang@chinamobile.com 2016年5月4日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.framework.message;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.cmcc.dhome.app.device.bean.framework.common.DeviceMessageType;
import com.cmcc.zeus.base.utils.StringUtil;

/**
 * 插件消息对象，封装插件消息通用部分
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年5月4日 - 下午4:44:42
 * @history
 *          2016年5月4日 - 下午4:44:42 liujianliang@chinamobile.com create.
 */
public class DeviceBaseMessage implements Serializable {
    /**
     * 
     */
    private static final long   serialVersionUID = -7186774327856713788L;
    @JSONField(name = "MAC")
    @NotNull(message = "缺少参数did")
    @NotBlank(message = "did不能为空")
    protected String            did;
    @JSONField(name = "SN")
    protected String            sn;
    @JSONField(name = "Type")
    protected String            type;

    @JSONField(name = "OsgiName")
    protected String            osgiName         = "DEFAULT";            // 用于标识插件类型

    @JSONField(serialize = false)
    protected DeviceMessageType msgType;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

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
        if (type.equals(DeviceMessageType.PING.getValue())) {
            this.msgType = DeviceMessageType.PING;
        } else if (type.equals(DeviceMessageType.PONG.getValue())) {
            this.msgType = DeviceMessageType.PONG;
        } else if (type.equals(DeviceMessageType.REQUEST.getValue())) {
            this.msgType = DeviceMessageType.REQUEST;
        } else if (type.equals(DeviceMessageType.RESPONSE.getValue())) {
            this.msgType = DeviceMessageType.RESPONSE;
        } else if (type.equals(DeviceMessageType.REPORT.getValue())) {
            this.msgType = DeviceMessageType.REPORT;
        }
    }

    public DeviceMessageType getMsgType() {
        return msgType;
    }

    public void setMsgType(DeviceMessageType msgType) {
        this.msgType = msgType;
        this.type = msgType.getValue();
    }

    public String getOsgiName() {
        return osgiName;
    }

    public void setOsgiName(String osgiName) {
        if (StringUtil.notNullAndBlank(osgiName)) {
            this.osgiName = osgiName;
        }
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
