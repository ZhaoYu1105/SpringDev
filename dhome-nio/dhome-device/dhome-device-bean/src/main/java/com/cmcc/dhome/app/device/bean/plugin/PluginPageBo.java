package com.cmcc.dhome.app.device.bean.plugin;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 * 分页信息
 * 
 * @author 李露[lilu@chinamobile.com]
 * @date 2016年3月4日 - 下午2:03:13
 * @history
 *          2016年3月4日 - 下午2:03:13 李露[lilu@chinamobile.com] create.
 */
public class PluginPageBo {
    @NotBlank(message = "userId不能为空")
    @NotNull(message = "缺少参数userId")
    private String  userId;
    @NotBlank(message = "did不能为空")
    @NotNull(message = "缺少参数did")
    private String  did;
    @Min(1)
    private int     page;
    @Min(1)
    private int     pageSize;
    private int     area;
    @Range(min = 0, max = 4, message = "pluginTypeGw值取值范围为0-4")
    private int     pluginTypeGw;
    @Range(min = 1, max = 3, message = "pluginType值取值范围为1-3")
    private Integer pluginType;

    public Integer getPluginType() {
        return pluginType;
    }

    public void setPluginType(Integer pluginType) {
        this.pluginType = pluginType;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPluginTypeGw() {
        return pluginTypeGw;
    }

    public void setPluginTypeGw(int pluginTypeGw) {
        this.pluginTypeGw = pluginTypeGw;
    }

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

}
