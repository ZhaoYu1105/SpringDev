package com.cmcc.dhome.app.device.bean.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户令牌
 * 
 * @author 张鑫441587960@qq.com
 * @date 2015年11月10日 - 上午11:02:41
 * @history
 *          2015年11月10日 - 上午11:02:41 张鑫441587960@qq.com create.
 */
public class UserTokenBo implements Serializable {

    private static final long serialVersionUID = 6930942838759193821L;

    private int               id;
    private String            userId;
    private String            imei;
    private String            token;
    private String            os;
    private Date              activeDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

}
