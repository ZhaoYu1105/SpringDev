package com.cmcc.dhome.app.device.bean.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * 
 * @author 顾欣
 * @date 2016年5月11日 - 下午1:42:05
 * @history
 *          2016年5月11日 - 下午1:42:05 lenovo create.
 */
public class UserBo implements Serializable {
    private static final long serialVersionUID = 33840197132280L;

    private String            passId;                            // 用户ID

    private String            mobileNumber;                      // 电话号码

    private String            province;                          // 省份

    private String            city;                              // 城市

    private String            nickname;                          // 昵称

    private Date              lastactivetime;                    // 最后一次登录时间

    private String            deviceUuid;                        // 用户登录的设备ID

    private Date              authtime;

    private Date              updateTime;                        // 更新时间

    private String            sex;                               // 性别

    private String            registerTime;                      // 用户注册用户子系统时间

    private String            headImg;                           // 头像

    private String            bob;                               // 生日

    private Date              syncTime;                          // 用户注册和家亲时间

    private String            provCode;                          // 省份代码

    private String            cityCode;                          // 城市代码

    private String            msisdnType;                        // 用户归属运营商，0-中国移动，1-中国电信，2-中国联通，99-未知

    private String            location;                          // 用户位置信息

    private String            channelId;                         // app下载渠道号
    /*
     * 冗余字段
     */
    private String            fid;                               // 家庭ID
    private String            fname;                             // 家庭名称
    private boolean           firstloginflag;                    // 是否首次登陆标志
    private int               roleflag         = -1;             // 冗余字段，保证兼容1.9.0版本登录

    private String            isFriend;                          // 是否亲友

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

    public Date getLastactivetime() {
        return lastactivetime;
    }

    public void setLastactivetime(Date lastactivetime) {
        this.lastactivetime = lastactivetime;
    }

    public Date getAuthtime() {
        return authtime;
    }

    public void setAuthtime(Date authtime) {
        this.authtime = authtime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public boolean isFirstloginflag() {
        return firstloginflag;
    }

    public void setFirstloginflag(boolean firstloginflag) {
        this.firstloginflag = firstloginflag;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    public String getProvCode() {
        return provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDeviceUuid() {
        return deviceUuid;
    }

    public void setDeviceUuid(String deviceUuid) {
        this.deviceUuid = deviceUuid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
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

    public String getMsisdnType() {
        return msisdnType;
    }

    public void setMsisdnType(String msisdnType) {
        this.msisdnType = msisdnType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(String isFriend) {
        this.isFriend = isFriend;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public int getRoleflag() {
        return roleflag;
    }

    public void setRoleflag(int roleflag) {
        this.roleflag = roleflag;
    }

}
