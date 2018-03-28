/**
 * @ platform-base-bean
 * @ com.cmcc.zeus.base.bean.bo
 * @ DeviceInfoBo.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年5月5日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年5月5日 - 下午4:00:49
 * @history
 *          2016年5月5日 - 下午4:00:49 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class DeviceDetailBo {

    private String id;
    private String devMac;
    private String name;   // 设备别名
    private long   onDate;
    private long   offDate;
    private String devName;// 设备名
    private String did;    // 网关ID
    private int    status; // 上线提醒状态

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOnDate() {
        return onDate;
    }

    public void setOnDate(long onDate) {
        this.onDate = onDate;
    }

    public long getOffDate() {
        return offDate;
    }

    public void setOffDate(long offDate) {
        this.offDate = offDate;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDevMac() {
        return devMac;
    }

    public void setDevMac(String devMac) {
        this.devMac = devMac;
    }

}
