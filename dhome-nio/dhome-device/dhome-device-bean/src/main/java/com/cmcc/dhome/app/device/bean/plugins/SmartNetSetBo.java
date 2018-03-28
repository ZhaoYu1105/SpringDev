package com.cmcc.dhome.app.device.bean.plugins;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.cmcc.zeus.base.core.BaseBo;

/**
 * 智能上网请求参数BO
 * 
 * @author 陈向君[chenxiangjun@chinamobile.com]
 * @date 2016年11月11日 - 下午4:28:52
 * @history
 *          2016年11月11日 - 下午4:28:52 陈向君[chenxiangjun@chinamobile.com] create.
 */
public class SmartNetSetBo extends BaseBo {

    private static final long serialVersionUID = 8103364283511799184L;
    @NotNull(message = "缺少参数devMac")
    @NotBlank(message = "devMac不能为空")
    private String            devMac;
    @NotNull(message = "缺少参数download")
    @Min(value = 0, message = "下载限速不能小于0")
    private Integer           download;
    @NotNull(message = "缺少参数upload")
    @Min(value = 0, message = "上载限速不能小于0")
    private Integer           upload;

    public String getDevMac() {
        return devMac;
    }

    public void setDevMac(String devMac) {
        this.devMac = devMac;
    }

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }

    public Integer getUpload() {
        return upload;
    }

    public void setUpload(Integer upload) {
        this.upload = upload;
    }

}
