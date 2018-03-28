/**
 * @ dhome-device-bp
 * @ com.cmcc.dhome.device.bp.bean.device
 * @ IconBo.java
 * 
 * @author  chenzhongya[chenzhongya@cmhi.chinamobile.com] 2018年3月14日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

import java.util.List;

/**
 * 查找设备图标实体类
 * 
 * @author chenzhongya[chenzhongya@cmhi.chinamobile.com]
 * @date 2018年3月14日 - 下午7:46:33
 * @history
 *          2018年3月14日 - 下午7:46:33 chenzhongya[chenzhongya@cmhi.chinamobile.com]
 *          create.
 */
public class IconBo {
    String       mac;
    String       sn;
    List<String> list;

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

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

}
