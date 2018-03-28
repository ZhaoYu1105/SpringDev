package com.cmcc.dhome.app.device.bean.device;

/**
 * 存储网关连接信息
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年12月27日 - 上午11:22:17
 * @history
 *          2017年12月27日 - 上午11:22:17 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class GatewayAddressBo {

    private String provinceCode;
    private String provinceName;
    private String connectType;
    private String address;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getConnectType() {
        return connectType;
    }

    public void setConnectType(String connectType) {
        this.connectType = connectType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
