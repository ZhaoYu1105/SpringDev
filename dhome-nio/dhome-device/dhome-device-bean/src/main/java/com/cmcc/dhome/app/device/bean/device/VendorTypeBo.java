package com.cmcc.dhome.app.device.bean.device;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 厂家商家类型
 * 
 * @author 杨丽[yanglizd@chinamobile.com]
 * @date 2018年3月12日 - 下午5:20:52
 * @history
 *          2018年3月12日 - 下午5:20:52 杨丽[yanglizd@chinamobile.com] create.
 */
public class VendorTypeBo implements Serializable {
    private static final long serialVersionUID = -1785059089869600033L;
    @NotNull(message = "缺少参数devMac")
    @NotBlank(message = "设备id不能为空")
    String                    devMac;                                  // 设备id
    String                    vendorE;                                 // 厂商英文名
    @NotNull(message = "缺少参数typeE")
    @NotBlank(message = "类型（英文）不能为空")
    String                    typeE;                                   // 设备英文名
    String                    typeC;                                   // 设备中文名
    String                    vendorC;                                 // 厂商中文名
    String                    icon;                                    // 图标路径
    @NotNull(message = "缺少参数gatewayId")
    @NotBlank(message = "网关id不能为空")
    String                    gatewayId;                               // 网关id
    String                    gatewaySn;                               // 网关sn

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getGatewaySn() {
        return gatewaySn;
    }

    public void setGatewaySn(String gatewaySn) {
        this.gatewaySn = gatewaySn;
    }

    public String getVendorE() {
        return vendorE;
    }

    public void setVendorE(String vendorE) {
        this.vendorE = vendorE;
    }

    public String getTypeE() {
        return typeE;
    }

    public void setTypeE(String typeE) {
        this.typeE = typeE;
    }

    public String getTypeC() {
        return typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC;
    }

    public String getVendorC() {
        return vendorC;
    }

    public void setVendorC(String vendorC) {
        this.vendorC = vendorC;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDevMac() {
        return devMac;
    }

    public void setDevMac(String devMac) {
        this.devMac = devMac;
    }

}
