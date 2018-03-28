/**
 * @ dhome-device-bean
 * @ com.cmcc.dhome.app.device.bean.device
 * @ DeviceLogBo.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2017年5月22日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年5月22日 - 下午5:27:29
 * @history 
 * 		 2017年5月22日 - 下午5:27:29 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class DeviceLogBo {

    private String did;
    private String sn;
    private String deviceName;
    private String deviceMac;
    private String operationTime;
    private String operation;
    private String connectType;
    private String ssidIndex;

    public String getDid() {
        return did;
    }
    public void setDid(String did) {
        this.did = did;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getDeviceName() {
        return deviceName;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public String getDeviceMac() {
        return deviceMac;
    }
    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }
    public String getOperationTime() {
        return operationTime;
    }
    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
    public String getConnectType() {
        return connectType;
    }
    public void setConnectType(String connectType) {
        this.connectType = connectType;
    }
    public String getSsidIndex() {
        return ssidIndex;
    }
    public void setSsidIndex(String ssidIndex) {
        this.ssidIndex = ssidIndex;
    }
}
