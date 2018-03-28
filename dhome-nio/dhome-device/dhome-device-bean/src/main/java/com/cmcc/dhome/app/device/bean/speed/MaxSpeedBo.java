package com.cmcc.dhome.app.device.bean.speed;

import java.util.Date;

/**
 * 速率统计bo
 * 
 * @author majinjin[majinjin@cmhi.chinamobile.com]
 * @date 2017年3月19日 - 下午1:59:03
 * @history
 *          2017年3月19日 - 下午1:59:03 majinjin[majinjin@cmhi.chinamobile.com]
 *          create.
 */
public class MaxSpeedBo {

    private long   id;
    private String mac;
    private String sn;
    private Date   date;
    private long   maxSpeed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

}
