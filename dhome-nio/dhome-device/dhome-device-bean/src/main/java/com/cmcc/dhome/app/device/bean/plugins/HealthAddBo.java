package com.cmcc.dhome.app.device.bean.plugins;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.cmcc.zeus.base.core.BaseBo;

/**
 * 添加定时WiFi信息BO
 * 
 * @author 陈向君[chenxiangjun@chinamobile.com]
 * @date 2016年11月11日 - 下午5:17:10
 * @history
 *          2016年11月11日 - 下午5:17:10 陈向君[chenxiangjun@chinamobile.com] create.
 */
public class HealthAddBo extends BaseBo {

    private static final long serialVersionUID = 8005278404392398513L;
    @NotNull(message = "缺少参数bTime")
    @Min(value = 0, message = "bTime值不能小于0")
    private Long              bTime;
    @NotNull(message = "缺少参数eTime")
    @Min(value = 0, message = "eTime值不能小于0")
    private Long              eTime;
    @NotNull(message = "缺少参数week")
    @Min(value = 0, message = "week值不能小于0")
    @Max(value = 127, message = "week值不能大于127")
    // @Range(min = 0, max = 127, message = "不在取值范围内")
    private Integer           week;

    /**
     * 获取开始时间
     * 
     * @return Long
     * @author 陈向君[chenxiangjun@cmhi.chinamobile.com]
     * @date 2017年7月5日 - 下午3:09:00
     * @history
     *          2017年7月5日 - 下午3:09:00 陈向君[chenxiangjun@cmhi.chinamobile.com]
     *          create.
     */
    public Long getbTime() {
        return bTime;
    }

    /**
     * 设置开始时间
     * 
     * @param bTime
     * @author 陈向君[chenxiangjun@cmhi.chinamobile.com]
     * @date 2017年7月5日 - 下午3:09:28
     * @history
     *          2017年7月5日 - 下午3:09:28 陈向君[chenxiangjun@cmhi.chinamobile.com]
     *          create.
     */
    public void setbTime(Long bTime) {
        this.bTime = bTime;
    }

    /**
     * 获取结束时间
     * 
     * @return Long
     * @author 陈向君[chenxiangjun@cmhi.chinamobile.com]
     * @date 2017年7月5日 - 下午3:10:31
     * @history
     *          2017年7月5日 - 下午3:10:31 陈向君[chenxiangjun@cmhi.chinamobile.com]
     *          create.
     */
    public Long geteTime() {
        return eTime;
    }

    /**
     * 设置结束时间
     * 
     * @param eTime
     * @author 陈向君[chenxiangjun@cmhi.chinamobile.com]
     * @date 2017年7月5日 - 下午3:10:53
     * @history
     *          2017年7月5日 - 下午3:10:53 陈向君[chenxiangjun@cmhi.chinamobile.com]
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
