package com.cmcc.dhome.app.device.bean.enums;

/**
 * 返回结果(提示代码)枚举
 * 
 * @author 张鑫441587960@qq.com
 * @date 2015年11月11日 - 上午10:11:32
 * @history
 *          2015年11月11日 - 上午10:11:32 张鑫441587960@qq.com create.
 */
public enum CodeType {

    SUCCESS("1000000", "成功"),

    ERROR("5000001", "系统错误"),

    INVALID_PARAMS("5100000", "输入参数不合法"),

    SESSION_INVALID("5101001", "session不存在"),

    INVOKE_DEVICESYS_ERROR("5201001", "无法连接设备管理子系统"),

    INVOKE_USERSYS_ERROR("5201002", "无法连接用户管理子系统"),

    INVOKE_PLUGINSYS_ERROR("5201003", "无法连接插件子系统"),

    ACQUIRE_ACCESSTOKEN_FAIL("5201004", "无有效ACCESS_TOKEN"),

    RESPONSE_USERSYS_ERROR("5201005", "用户管理子系统响应异常"),

    GATEWAY_DISCONNECT("5201006", "网关未连接到平台"),

    UNKNOW_PLUGINTYPE("7100002", "没有对应的插件"),

    PLUGIN_IS_INSTALLED("2202023", "用户已安装该插件"),

    PLUGIN_NOT_INSTALLED("2202022", "用户未安装该插件");

    private final String code;
    private final String desc;

    /**
     * 构造函数.
     * 
     * @param code
     *            code
     * @param desc
     *            message
     */
    CodeType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
