package com.cmcc.dhome.app.device.bean.user;

import java.io.Serializable;
import java.util.Date;

/**
 * Appbase接受用户
 * 
 * @author 杨丽[yanglizd@chinamobile.com]
 * @date 2017年9月14日 - 下午5:53:18
 * @history
 *          2017年9月14日 - 下午5:53:18 杨丽[yanglizd@chinamobile.com] create.
 */
public class AppbaseUserBo implements Serializable {
    private static final long serialVersionUID = 33840197132280L;

    private String            passId;

    private String            mobileNumber;

    private String            province;

    private String            city;

    private String            nickname;

    private String            updateTime;

    private String            sex;

    private String            registerTime;

    private String            headImg;

    private String            bob;

    private Date              syncTime;

    public String getPassId() {
        return passId;
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getBob() {
        return bob;
    }

    public void setBob(String bob) {
        this.bob = bob;
    }

}
