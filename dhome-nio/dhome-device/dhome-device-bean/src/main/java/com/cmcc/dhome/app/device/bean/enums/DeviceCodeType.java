/**
 * @ dhome-device-bean
 * @ com.cmcc.dhome.app.device.bean.enums
 * @ DeviceCodeType.java
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com] 2016年10月26日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.enums;

import com.cmcc.zeus.base.bean.common.BaseCodeType;
import com.cmcc.zeus.base.bean.common.CommonCodeMessage;

/**
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2016年10月26日 - 下午4:53:51
 * @history
 *          2016年10月26日 - 下午4:53:51 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class DeviceCodeType extends BaseCodeType {

    /**
     * 用户子系统返回错误码
     */
    public static final CommonCodeMessage PARA_NULL_ERROR              = new CommonCodeMessage("2101002", "必填参数为空");
    public static final CommonCodeMessage CHECK_MD5_SIGN_ERROR         = new CommonCodeMessage("2202002", "MD5校验失败");
    public static final CommonCodeMessage NOT_EXISTS_GAEWAY            = new CommonCodeMessage("2202003", "当前连接网关未激活，请联系装维人员");
    public static final CommonCodeMessage GATEWAY_IS_BOUND             = new CommonCodeMessage("2202004", "网关已被用户%s绑定");
    public static final CommonCodeMessage REQTYPE_NOTEXISTS_ERROR      = new CommonCodeMessage("2202021", "输入参数错误");
    public static final CommonCodeMessage USER_NOTINSTALL_PLUGIN_ERROR = new CommonCodeMessage("2202022", "用户未安装该插件");
    public static final CommonCodeMessage PLUGIN_HASINSTALLED_ERROR    = new CommonCodeMessage("2202023", "插件已安装");
    public static final CommonCodeMessage PARAM_INPUT_ERROR            = new CommonCodeMessage("2202024", "输入参数错误");
    public static final CommonCodeMessage PLUGIN_EXTEND_LIMITS_ERROR   = new CommonCodeMessage("2202025", "用户安装的插件个数已达到上限");
    public static final CommonCodeMessage GATEWAY_BIND_EXCEED          = new CommonCodeMessage("2202028", "您最多可以绑定10台网关");
    public static final CommonCodeMessage GATEWAY_IS_BINDING           = new CommonCodeMessage("2202031", "网关正在绑定，请勿多次点击");

    /**
     * 设备子系统返回错误码
     */
    public static final CommonCodeMessage GATEWAY_UNSYNC               = new CommonCodeMessage("3202003", "未获取到设备信息，请联系装维人员");
    public static final CommonCodeMessage GATEWAY_UPDATING             = new CommonCodeMessage("3202005", "网关正在升级中");

    /**
     * 客户端子系统错误码
     */
    public static final CommonCodeMessage INVALID_PARAMS               = new CommonCodeMessage("5100000", "输入参数不合法");
    public static final CommonCodeMessage INVOKE_DEVICESYS_ERROR       = new CommonCodeMessage("5201001", "无法连接设备管理子系统");
    public static final CommonCodeMessage INVOKE_USERSYS_ERROR         = new CommonCodeMessage("5201002", "无法连接用户管理子系统");
    public static final CommonCodeMessage INVOKE_PLUGINSYS_ERROR       = new CommonCodeMessage("5201003", "无法连接插件管理子系统");
    public static final CommonCodeMessage ACQUIRE_ACCESSTOKEN_FAIL     = new CommonCodeMessage("5201004", "无有效ACCESS_TOKEN");
    public static final CommonCodeMessage GATEWAY_DISCONNECT           = new CommonCodeMessage("5201006", "网关未连接到平台");
    public static final CommonCodeMessage GATEWAY_EXTEND_DISCONNECT    = new CommonCodeMessage("5201008", "扩展插件功能不可用");
    public static final CommonCodeMessage NOT_FAMILY_MEMBER            = new CommonCodeMessage("5212131", "用户不是家庭的成员，操作失败");

    /**
     * 预置插件错误码
     */
    public static final CommonCodeMessage UNKNOW_PLUGINTYPE            = new CommonCodeMessage("7100002", "没有对应的插件");

    /**
     * 网关分享
     */
    public static final CommonCodeMessage GATEWAY_SHARE_EXCEED         = new CommonCodeMessage("5219001", "网关分享数量达到上线");
    public static final CommonCodeMessage GATEWAY_SHARE_NOT_OPER       = new CommonCodeMessage("5219002", "登录用户无法操作");
    public static final CommonCodeMessage USER_EXIT                    = new CommonCodeMessage("5219003", "该用户已经共享此设备");
    public static final CommonCodeMessage IS_ADMIN                     = new CommonCodeMessage("5219004", "该用户是管理员无法申请共享");
    public static final CommonCodeMessage ADMIN_CHANGED                = new CommonCodeMessage("5219005", "管理员换人了");
    public static final CommonCodeMessage APPLY_OVER_DATE              = new CommonCodeMessage("5219006", "申请过期了");

}
