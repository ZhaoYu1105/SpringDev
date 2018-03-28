/**
 * @ home-web-api
 * @ com.cmcc.home.web.api.jsonbean
 * @ Response.java
 * 
 * @author 张鑫441587960@qq.com 2015年11月17日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.common;

/**
 * 设备回调数据类
 * 
 * @author chenxian@chinamobile.com
 * @date 2016年3月4日 - 上午10:31:13
 * @history
 *          2016年3月4日 - 上午10:31:13 chenxian@chinamobile.com create.
 */
public class DeviceCallbackData {

    private String did;
    private String msgid;
    private Object gwdp;
    private Object datapoints;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public Object getGwdp() {
        return gwdp;
    }

    public void setGwdp(Object gwdp) {
        this.gwdp = gwdp;
    }

    public Object getDatapoints() {
        return datapoints;
    }

    public void setDatapoints(Object datapoints) {
        this.datapoints = datapoints;
    }
}
