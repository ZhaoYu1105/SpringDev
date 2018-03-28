/**
 * @ platform-base-bean
 * @ com.cmcc.zeus.base.bean.jsonbean
 * @ AuthenticationRequest.java
 * 
 * @author ZX441587960@qq.com 2016年3月5日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.common;

import java.util.Map;

/**
 * 认证平台的请求对象
 * 
 * @author ZX441587960@qq.com
 * @date 2016年3月5日 - 下午2:51:22
 * @history
 *          2016年3月5日 - 下午2:51:22 ZX441587960@qq.com create.
 */
public class Authentication {

    private Map<String, Object> header;
    private Map<String, Object> body;

    public Map<String, Object> getHeader() {
        return header;
    }

    public void setHeader(Map<String, Object> header) {
        this.header = header;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

}
