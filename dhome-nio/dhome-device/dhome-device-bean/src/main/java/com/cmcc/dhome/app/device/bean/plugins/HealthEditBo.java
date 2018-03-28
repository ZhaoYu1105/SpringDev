package com.cmcc.dhome.app.device.bean.plugins;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.cmcc.zeus.base.core.BaseBo;

/**
 * 编辑WiFi信息BO
 * 
 * @author 陈向君[chenxiangjun@chinamobile.com]
 * @date 2016年11月11日 - 下午5:44:56
 * @history
 *          2016年11月11日 - 下午5:44:56 陈向君[chenxiangjun@chinamobile.com] create.
 */
public class HealthEditBo extends BaseBo {

    private static final long serialVersionUID = -2596407516328773211L;

    @NotNull(message = "缺少参数netTimeId")
    @NotBlank(message = "netTimeId不能为空")
    private String            netTimeId;
    @NotNull(message = "缺少参数bTime")
    @Min(value = 0, message = "bTime值不能小于0")
    private Long              bTime;
    @NotNull(message = "缺少参数eTime")
    @Min(value = 0, message = "eTime值不能小于0")
    private Long              eTime;
    @NotNull(message = "缺少参数week")
    @Min(value = 0, message = "week值不能小于0")
    @Max(value = 127, message = "week值不能大于127")
    private Integer           week;

    public String getNetTimeId() {
        return netTimeId;
    }

    public void setNetTimeId(String netTimeId) {
        this.netTimeId = netTimeId;
    }

    /**
     * 
     * 
     * @return
     * @author 陈向君[chenxiangjun@chinamobile.com]
     * @date 2016年11月14日 - 上午11:05:33
     * @history
     *          2016年11月14日 - 上午11:05:33 陈向君[chenxiangjun@chinamobile.com]
     *          create.
     */
    public Long getbTime() {
        return bTime;
    }

    /**
     * 
     * 
     * @param bTime
     * @author 陈向君[chenxiangjun@chinamobile.com]
     * @date 2016年11月14日 - 上午11:05:37
     * @history
     *          2016年11月14日 - 上午11:05:37 陈向君[chenxiangjun@chinamobile.com]
     *          create.
     */
    public void setbTime(Long bTime) {
        this.bTime = bTime;
    }

    /**
     * 
     * 
     * @return
     * @author 陈向君[chenxiangjun@chinamobile.com]
     * @date 2016年11月14日 - 上午11:05:41
     * @history
     *          2016年11月14日 - 上午11:05:41 陈向君[chenxiangjun@chinamobile.com]
     *          create.
     */
    public Long geteTime() {
        return eTime;
    }

    /**
     * 
     * 
     * @param eTime
     * @author 陈向君[chenxiangjun@chinamobile.com]
     * @date 2016年11月14日 - 上午11:05:45
     * @history
     *          2016年11月14日 - 上午11:05:45 陈向君[chenxiangjun@chinamobile.com]
     *          create.
     */
    public void seteTime(Long eTime) {
        this.eTime = eTime;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

}
