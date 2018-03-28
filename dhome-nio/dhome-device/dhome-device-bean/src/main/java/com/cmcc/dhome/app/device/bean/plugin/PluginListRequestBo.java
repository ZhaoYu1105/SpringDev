package com.cmcc.dhome.app.device.bean.plugin;

import javax.validation.constraints.NotNull;

/**
 * 获取插件列表请求体，版本升级检测时使用
 * 
 * @author 蔡洁[caijiehy@cmhi.chinamobile.com]
 * @date 2018年1月29日 - 下午4:12:04
 * @history
 *          2018年1月29日 - 下午4:12:04 蔡洁[caijiehy@cmhi.chinamobile.com] create.
 */
public class PluginListRequestBo {
    private String  userId       = "update-need-user";
    private String  did          = "update-need-did";

    private String  sn;
    @NotNull(message = "缺少参数area")
    private Integer area;
    private String  vendor;
    private String  productClass;
    private String  swversion;

    private int     page         = 1;
    private int     pageSize     = 100;
    private int     pluginTypeGw = 0;
    private int     pluginType   = 2;
    private int     grayScale    = 0;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public int getPluginTypeGw() {
        return pluginTypeGw;
    }

    public void setPluginTypeGw(int pluginTypeGw) {
        this.pluginTypeGw = pluginTypeGw;
    }

    public int getPluginType() {
        return pluginType;
    }

    public void setPluginType(int pluginType) {
        this.pluginType = pluginType;
    }

    public int getGrayScale() {
        return grayScale;
    }

    public void setGrayScale(int grayScale) {
        this.grayScale = grayScale;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public String getSwversion() {
        return swversion;
    }

    public void setSwversion(String swversion) {
        this.swversion = swversion;
    }

}
