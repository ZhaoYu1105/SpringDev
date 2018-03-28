package com.cmcc.dhome.app.device.bean.device;

import java.io.Serializable;
import java.sql.Date;

/**
 * 解绑/绑定同步
 * 
 * @author 杨丽[yanglizd@chinamobile.com]
 * @date 2017年9月16日 - 下午6:10:44
 * @history
 *          2017年9月16日 - 下午6:10:44 杨丽[yanglizd@chinamobile.com] create.
 */
public class GatewaySelectBo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String            userId;
    private String            did;
    private Date              operTime;
    private String            sn;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

}
