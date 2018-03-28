package com.cmcc.dhome.app.device.bean.device;

/**
 * 网关具体信息
 * 
 * @author zhuqun[zhuqun@chinamobile.com]
 * @date 2016年3月7日 - 下午3:38:57
 * @history
 *          2016年3月7日 - 下午3:38:57 zhuqun[zhuqun@chinamobile.com] create.
 */
public class GatewayDetail {

    private String did;
    private String name;
    private String online;
    private String productClass;
    private String swversion;
    private String vendor;
    private int    osType;
    private int    provinceCode;
    private String gwsn;
    private String broadbandAccount;
    private String pwd;
    private String nickname;
    private String ponPwd;
    private String presetVersion;   // 预置插件版本

    // private String devType;
    // private String chipClass;
    // private String flashSize;
    // private String ramSize;
    // private String hardwareVersion;
    // private String osgiVersion;
    // private String wifiStandard;
    // private String ipv6Status;
    // private String wanIpv4;
    // private String wanIpv6;

    public String getPresetVersion() {
        return presetVersion;
    }

    public void setPresetVersion(String presetVersion) {
        this.presetVersion = presetVersion;
    }

    private String  phone;

    // private String onlineEnable; // 上线消息推送状态，默认值1
    // private String speedEnable; // 网速推送状态，默认值0
    // private String reportTime; // 网速推送周期，单位秒

    private String  userId;      // 冗余字段

    private int     status;
    private int     macFlag;     // 是否有重复mac，0有重复，1没有重复(可能是写反了)
    private Integer versionFlag; // 0—预置插件版本过低；1-正常

    public int getMacFlag() {
        return macFlag;
    }

    public void setMacFlag(int macFlag) {
        this.macFlag = macFlag;
    }

    public String getPonPwd() {
        return ponPwd;
    }

    public void setPonPwd(String ponPwd) {
        this.ponPwd = ponPwd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = (did == null ? "" : did);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name == null ? "" : name);
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = (online == null ? "" : online);
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = (productClass == null ? "" : productClass);
    }

    public String getSwversion() {
        return swversion;
    }

    public void setSwversion(String swversion) {
        this.swversion = (swversion == null ? "" : swversion);
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = (vendor == null ? "" : vendor);
    }

    public String getGwsn() {
        return gwsn;
    }

    public void setGwsn(String gwsn) {
        this.gwsn = (gwsn == null ? "" : gwsn);
    }

    public String getBroadbandAccount() {
        return broadbandAccount;
    }

    public void setBroadbandAccount(String broadbandAccount) {
        this.broadbandAccount = (broadbandAccount == null ? "" : broadbandAccount);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public int getOsType() {
        return osType;
    }

    public void setOsType(int osType) {
        this.osType = osType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getVersionFlag() {
        return versionFlag;
    }

    public void setVersionFlag(Integer versionFlag) {
        this.versionFlag = versionFlag;
    }

}
