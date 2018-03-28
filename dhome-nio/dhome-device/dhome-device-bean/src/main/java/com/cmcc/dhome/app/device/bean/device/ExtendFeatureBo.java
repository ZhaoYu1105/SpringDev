/**
 * @ dhome-device-bean
 * @ com.cmcc.dhome.app.device.bean.device
 * @ ExtendFeatureBo.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2017年7月7日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.device;

/**
 * 扩展插件功能对象
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年7月7日 - 上午11:30:36
 * @history
 *          2017年7月7日 - 上午11:30:36 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class ExtendFeatureBo {

    private String tag;
    private String name;
    private String url;
    private String version;
    private String status = "0";// 默认不可用状态

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 根据当前版本号判断该功能是否可用
     * 
     * @param currentVer
     * @return
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2017年7月7日 - 下午2:21:26
     * @history
     *          2017年7月7日 - 下午2:21:26 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public boolean checkStatus(String currentVer) throws Exception {
        String[] least = version.split("\\.");// 功能支持的最低版本
        String[] current = currentVer.split("\\.");// 扩展插件当前版本
        if (least.length == 2 && current.length == 2) {
            int least1 = Integer.parseInt(least[0]);
            int least2 = Integer.parseInt(least[1]);
            int current1 = Integer.parseInt(current[0]);
            int current2 = Integer.parseInt(current[1]);
            if (least1 < current1 || least1 == current1 && least2 <= current2) {
                setStatus("1");
            }
            return true;
        } else {
            return false;
        }
    }

}
