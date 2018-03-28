package com.cmcc.dhome.app.device.bean.medal;

/**
 * 勋章用户关联Bo
 * 
 * @author majinjin[majinjin@cmhi.chinamobile.com]
 * @date 2017年3月20日 - 下午4:15:41
 * @history
 *          2017年3月20日 - 下午4:15:41 majinjin[majinjin@cmhi.chinamobile.com]
 *          create.
 */
public class MedalGatewayBo {

    private long   id;
    private String mac;
    private String sn;
    private String medalTag;
    private String status;
    private String medalName;
    private String medalIcon;
    private String medalType;
    private String isOwn;    // 0未获得,1获得
    private Object param;

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public String getIsOwn() {
        return isOwn;
    }

    public void setIsOwn(String isOwn) {
        this.isOwn = isOwn;
    }

    public String getMedalName() {
        return medalName;
    }

    public void setMedalName(String medalName) {
        this.medalName = medalName;
    }

    public String getMedalIcon() {
        return medalIcon;
    }

    public void setMedalIcon(String medalIcon) {
        this.medalIcon = medalIcon;
    }

    public String getMedalType() {
        return medalType;
    }

    public void setMedalType(String medalType) {
        this.medalType = medalType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getMedalTag() {
        return medalTag;
    }

    public void setMedalTag(String medalTag) {
        this.medalTag = medalTag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
