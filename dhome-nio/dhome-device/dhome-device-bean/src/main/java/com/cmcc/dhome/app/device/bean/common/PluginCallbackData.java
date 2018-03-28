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
 * 插件回调数据类
 * 
 * @author chenxian@chinamobile.com
 * @date 2016年3月4日 - 上午10:33:46
 * @history
 *          2016年3月4日 - 上午10:33:46 chenxian@chinamobile.com create.
 */
public class PluginCallbackData {

    private String seqId;
    private int    code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

}
