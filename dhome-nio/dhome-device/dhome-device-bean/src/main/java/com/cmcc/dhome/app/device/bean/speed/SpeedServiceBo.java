package com.cmcc.dhome.app.device.bean.speed;

/**
 * 
 * @author 蔡洁[caijie@chinamobile.com]
 * @date 2016年12月5日 - 下午2:09:25
 * @history
 *          2016年12月5日 - 下午2:09:25 蔡洁[caijie@chinamobile.com] create.
 */
public class SpeedServiceBo {
    private int    id;
    private String serviceId;
    private String serviceName;
    private int    bandwidth;
    private int    time;
    private String description;
    private String period;
    private int    available;
    private int    remain;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

}
