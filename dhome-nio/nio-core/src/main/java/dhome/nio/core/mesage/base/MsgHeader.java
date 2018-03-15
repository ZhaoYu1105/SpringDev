package dhome.nio.core.mesage.base;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 固定消息头，不允许扩展
 * 
 * @author 缪云海[miaoyunhai@cmhi.chinamobile.com]
 * @date 2018年3月13日 - 上午8:57:23
 * @history 2018年3月13日 - 上午8:57:23 缪云海[miaoyunhai@cmhi.chinamobile.com] create.
 */
public final class MsgHeader implements Serializable {

    private static final long serialVersionUID = -6363083563957752216L;

    private long              timestamp        = System.currentTimeMillis();
    private String            mac;
    private String            sn;
    private String            type;
    @JSONField(serialize = false)
    private EnumMsgType       msgType;

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

    public long getTimestamp() {
        return timestamp;
    }

    public EnumMsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(EnumMsgType msgType) {
        this.msgType = msgType;
        setType(msgType.getValue());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
