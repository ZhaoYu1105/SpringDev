package com.cmcc.dhome.app.device.bean.extend;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.alibaba.fastjson.JSON;
import com.cmcc.dhome.app.device.bean.enums.OsgiNameType;
import com.cmcc.dhome.app.device.bean.framework.common.DeviceMessageType;
import com.cmcc.dhome.app.device.bean.framework.message.DeviceRequestMessage;
import com.cmcc.zeus.base.core.BaseBo;

/**
 * 用于查询拓展插件状态的bean类
 * 
 * @author jsh[jiasonghao@cmhi.chinamobile.com]
 * @date 2018年1月8日 - 下午4:27:59
 * @history
 *          2018年1月8日 - 下午4:27:59 jsh[jiasonghao@cmhi.chinamobile.com] create.
 */
public class FeatureStatusBean extends BaseBo {
    /**
     * 
     */
    private static final long serialVersionUID = 4538533570113670642L;

    @NotNull(message = "缺少参数seqId")
    @NotBlank(message = "seqId不能为空")
    private String            seqId;

    @NotNull(message = "缺少参数mac")
    @NotBlank(message = "mac不能为空")
    private String            mac;

    private String            sn;

    @NotNull(message = "缺少参数userId")
    @NotBlank(message = "userId不能为空")
    @Pattern(regexp = "^[1-9][0-9]*", message = "userId只能包含数字")
    private String            userId;

    private Object            param;

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    /**
     * 封装入request中
     * 
     * @return
     * @author jsh[jiasonghao@cmhi.chinamobile.com]
     * @date 2018年1月9日 - 上午11:49:57
     * @history
     *          2018年1月9日 - 上午11:49:57 jsh[jiasonghao@cmhi.chinamobile.com]
     *          create.
     */
    public DeviceRequestMessage toRequestMsg() {
        DeviceRequestMessage msg = new DeviceRequestMessage();
        msg.setDid(this.mac);
        msg.setSn(this.sn);
        msg.setMsgType(DeviceMessageType.REQUEST);
        msg.setOsgiName(OsgiNameType.getByCode("Feature"));
        msg.setType("request");
        msg.setPluginName("Feature");
        msg.setMethod("GET_FEATURE_STATUS");
        msg.setUserId(this.userId);
        msg.setRpcMethod("get");
        msg.setSeqId(this.seqId);
        return msg;

    }
}
