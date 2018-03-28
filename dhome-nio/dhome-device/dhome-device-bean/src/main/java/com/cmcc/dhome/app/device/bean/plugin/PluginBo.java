package com.cmcc.dhome.app.device.bean.plugin;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.cmcc.zeus.base.core.BaseBo;

/**
 * 插件对象
 * 
 * @author 李露[lilu@chinamobile.com]
 * @date 2016年3月1日 - 上午11:22:31
 * @history
 *          2016年3月1日 - 上午11:22:31 李露[lilu@chinamobile.com] create.
 */
public class PluginBo extends BaseBo {

    private static final long serialVersionUID = -6997691765339850102L;
    @NotNull(message = "缺少参数userId")
    @NotBlank(message = "userId不能为空")
    private String            userId;
    private String            did;

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

}
