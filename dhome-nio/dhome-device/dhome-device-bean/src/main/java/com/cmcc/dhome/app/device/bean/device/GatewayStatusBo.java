package com.cmcc.dhome.app.device.bean.device;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * 
 * @author lilu@chinamobile.com
 * @date 2017年4月12日 - 上午11:09:25
 * @history
 *          2017年4月12日 - 上午11:09:25 lilu@chinamobile.com create.
 */
public class GatewayStatusBo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2373547677875437814L;
    private String            userId;
    private String            did;
    private int               status;
    private Date              operTime;
    private String            sn;

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

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

}
