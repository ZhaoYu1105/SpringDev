/**
 * @ dhome-device-bean
 * @ com.cmcc.dhome.app.device.bean.device
 * @ DeviceInfoBo.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2017年5月26日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年5月26日 - 下午5:13:13
 * @history
 *          2017年5月26日 - 下午5:13:13 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class DeviceInfoBo {

    private long   seqId;      // 主键
    private String gatewayId;  // 网关id
    private String deviceMac;  // 下挂设备mac
    private String hostName;
    private String connectType;// 设备连接方式：0有线，1无线
    private String ssidIndex;  // 无线信道
    private String gatewaySn;  // 网关SN

    public long getSeqId() {
        return seqId;
    }

    public void setSeqId(long seqId) {
        this.seqId = seqId;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
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

    public String getGatewaySn() {
        return gatewaySn;
    }

    public void setGatewaySn(String gatewaySn) {
        this.gatewaySn = gatewaySn;
    }

}
