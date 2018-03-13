package dhome.nio.core.mesage;

import java.io.Serializable;

/**
 * 消息头
 * 
 * @author 缪云海[miaoyunhai@cmhi.chinamobile.com]
 * @date 2018年3月13日 - 上午8:57:23
 * @history
 *          2018年3月13日 - 上午8:57:23 缪云海[miaoyunhai@cmhi.chinamobile.com] create.
 */
public class MsgHeader implements Serializable {

    private static final long serialVersionUID = -6363083563957752216L;

    private String            mac;
    private String            sn;
    private long              timestamp        = System.currentTimeMillis();

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

}
