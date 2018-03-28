package com.cmcc.dhome.app.device.bean.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 设备子系统同步接口请求参数封装
 * 
 * @author zhuqun[zhuqun@chinamobile.com]
 * @date 2016年3月7日 - 下午3:04:42
 * @history
 *          2016年3月7日 - 下午3:04:42 zhuqun[zhuqun@chinamobile.com] create.
 */
public class DeviceRequestParams {

    private JSONObject filter;
    private JSONObject gwfilter;

    /**
     * 构造函数
     */
    public DeviceRequestParams() {
        super();
    }

    /**
     * 根据网关id封装请求参数
     * 
     * @param did
     *            网关ID(列表)
     */
    public DeviceRequestParams(String did) {
        filter = new JSONObject();
        gwfilter = new JSONObject();
        filter.put("did", did);
        gwfilter.put("rsp_all", "1"); // 返回所有信息（不含插件）
        gwfilter.put("plugin", "0"); // 不返回插件信息
    }

    public DeviceRequestParams(JSONArray jsonArray) {
        filter = new JSONObject();
        gwfilter = new JSONObject();
        filter.put("gateways", jsonArray);
        gwfilter.put("rsp_all", "1"); // 返回所有信息（不含插件）
        gwfilter.put("plugin", "0"); // 不返回插件信息
    }

    /**
     * 根据网关id封装获取订阅点的请求参数
     * 
     * @param did
     *            网关ID
     * @author 徐海涛[xuhaitao@chinamobile.com]
     * @date 2016年5月11日 - 下午2:08:52
     * @history
     *          2016年5月11日 - 下午2:08:52 徐海涛[xuhaitao@chinamobile.com] create.
     */
    public void subscribeRequest(String did) {
        filter = new JSONObject();
        gwfilter = new JSONObject();
        filter.put("did", did);
    }

    /**
     * 封装请求参数为json
     * 
     * @return json String
     * @author zhuqun[zhuqun@chinamobile.com]
     * @date 2016年3月7日 - 下午4:55:09
     * @history
     *          2016年3月7日 - 下午4:55:09 zhuqun[zhuqun@chinamobile.com] create.
     */
    public String toJSONString() {
        JSONObject jo = new JSONObject();
        jo.put("filter", filter);
        jo.put("gwfilter", gwfilter);
        return jo.toJSONString();
    }

}
