package com.cmcc.dhome.app.device.bean.device;

/**
 * 网关安装版本号
 * 
 * @author 蔡洁[caijiehy@cmhi.chinamobile.com]
 * @date 2018年1月8日 - 下午3:04:30
 * @history
 *          2018年1月8日 - 下午3:04:30 蔡洁[caijiehy@cmhi.chinamobile.com] create.
 */
public class InstalledVersionBo {
    private String mac;
    private String sn;
    private String preset;
    private String extend;

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

    public String getPreset() {
        return preset;
    }

    public void setPreset(String preset) {
        this.preset = preset;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

}
