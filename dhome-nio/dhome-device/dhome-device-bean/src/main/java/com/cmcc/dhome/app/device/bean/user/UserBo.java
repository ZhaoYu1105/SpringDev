package com.cmcc.dhome.app.device.bean.user;

import java.util.Date;

import com.cmcc.zeus.base.core.BaseBo;

/**
 * 用户
 * 
 * @author 张鑫441587960@qq.com
 * @date 2015年11月10日 - 上午11:02:16
 * @history
 *          2015年11月10日 - 上午11:02:16 张鑫441587960@qq.com create.
 */
public class UserBo extends BaseBo {

    private static final long serialVersionUID = -6504025431225558401L;

    private String            userId;
    private String            tel;
    private String            userName;
    private String            province;
    private String            city;
    private Date              createTime;
    private Date              logonDate;                               // 最近登录时间

    private String            version;
    private String            url;                                     // 安卓APP版本在线升级地址
    private String            remark;                                  // 版本升级备注

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Date getLogonDate() {
        return logonDate;
    }

    public void setLogonDate(Date logonDate) {
        this.logonDate = logonDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
