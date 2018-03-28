package com.cmcc.dhome.app.device.bean.plugin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.cmcc.zeus.base.core.BaseBo;

/**
 * 操作插件列表输入参数
 * 
 * @author 李露[lilu@chinamobile.com]
 * @date 2016年3月4日 - 下午2:02:00
 * @history
 *          2016年3月4日 - 下午2:02:00 李露[lilu@chinamobile.com] create.
 */
public class PluginOperationBo extends BaseBo {

    private static final long serialVersionUID = -5692454631976244485L;
    @NotNull(message = "缺少参数seqId")
    @Pattern(regexp = "[a-fA-F0-9]{8}", message = "seqId必须为8位16进制")
    private String            seqId;
    @NotBlank(message = "userId不能为空")
    @NotNull(message = "缺少参数userId")
    private String            userId;
    @NotBlank(message = "did不能为空")
    @NotNull(message = "缺少参数did")
    private String            did;
    @Range(min = 1, max = 6, message = "reqType值取值范围为1-6")
    private int               reqType;
    private int               area;
    @NotBlank(message = "installLoc不能为空")
    @Range(min = 1, max = 3, message = "installLoc值取值范围为1-3")
    private String            installLoc;

    public String getInstallLoc() {
        return installLoc;
    }

    public void setInstallLoc(String installLoc) {
        this.installLoc = installLoc;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
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

    public int getReqType() {
        return reqType;
    }

    public void setReqType(int reqType) {
        this.reqType = reqType;
    }
}
