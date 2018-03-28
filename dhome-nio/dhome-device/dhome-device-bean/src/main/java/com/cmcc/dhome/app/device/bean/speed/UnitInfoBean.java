package com.cmcc.dhome.app.device.bean.speed;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 亚信获取初始带宽 Request Bean
 * 
 * @author 蔡洁[caijie@chinamobile.com]
 * @date 2017年1月6日 - 下午2:12:17
 * @history
 *          2017年1月6日 - 下午2:12:17 蔡洁[caijie@chinamobile.com] create.
 */
@XStreamAlias("info")
public class UnitInfoBean {
    private String            taskcode;
    private String            taskname;
    private String            password;
    private UnitInfoInnerBean request;

    public String getTaskcode() {
        return taskcode;
    }

    public void setTaskcode(String taskcode) {
        this.taskcode = taskcode;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UnitInfoInnerBean getRequest() {
        return request;
    }

    public void setRequest(UnitInfoInnerBean request) {
        this.request = request;
    }
}
