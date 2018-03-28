package com.cmcc.dhome.app.device.bean.common;

import com.cmcc.zeus.base.bean.common.BaseCodeType;
import com.cmcc.zeus.base.bean.common.CommonCodeMessage;

/**
 * 返回结果
 * 
 * @author 柯丹[kedanhz@139.com]
 * @date 2016年5月18日 - 下午12:30:46
 * @history
 *          2016年5月18日 - 下午12:30:46 柯丹[kedanhz@139.com] create.
 */
public class UnityCodeType extends BaseCodeType {

    public static final CommonCodeMessage FLOW_SUC_NEXT_MON                = new CommonCodeMessage("1000001", "月末三天流量下月初到账");

    public static final CommonCodeMessage PARAM_FAIL                       = new CommonCodeMessage("5100000", "参数校验失败");
    public static final CommonCodeMessage SESSION_INVALID                  = new CommonCodeMessage("5101001", "session不存在");
    public static final CommonCodeMessage SESSION_NOT_EXSIST               = new CommonCodeMessage("5101002", "用户session信息不存在");
    public static final CommonCodeMessage SESSION_NOT_MATCH                = new CommonCodeMessage("5101003", "sessionId与passId不匹配");
    public static final CommonCodeMessage INTERCEPTER                      = new CommonCodeMessage("5101004", "接口被拦截");
    public static final CommonCodeMessage AUTHENTICODE_INVALIDATE          = new CommonCodeMessage("5101005", "验证码不合法");
    public static final CommonCodeMessage AUTHENTICODE_FREQUENTLY          = new CommonCodeMessage("5101006", "验证码获取太频繁");

    public static final CommonCodeMessage MEMBER_NUMBER_MAX                = new CommonCodeMessage("5212001", "成员数量已达到上限，无法再加入咯");
    public static final CommonCodeMessage ALREADY_IN_FAMILY                = new CommonCodeMessage("5212011", "您已加入家庭，无法再创建家庭咯");
    public static final CommonCodeMessage CREATE_FAMILY_FAIL               = new CommonCodeMessage("5212012", "创建失败");
    public static final CommonCodeMessage USER_NOT_EXIST                   = new CommonCodeMessage("5212013", "用户不存在哦");
    public static final CommonCodeMessage NOT_FAMILY_MEMBER                = new CommonCodeMessage("5212131", "用户不是家庭的成员，操作失败");
    public static final CommonCodeMessage UPDATE_FAIL                      = new CommonCodeMessage("5212132", "修改小溪群组失败");
    public static final CommonCodeMessage DELETE_FAIL                      = new CommonCodeMessage("5212112", "解散家庭失败");

    public static final CommonCodeMessage PHONE_NOT_EXIST                  = new CommonCodeMessage("5212141", "该用户不存在哦");
    public static final CommonCodeMessage PHONE_NOT_MANAGER_FAMILY         = new CommonCodeMessage("5212142", "该账号未创建家庭，无法加入哦");
    public static final CommonCodeMessage SUG_EMPTY                        = new CommonCodeMessage("5111041", "意见不能为空");
    public static final CommonCodeMessage PHOTO_UPLOAD_FAIL                = new CommonCodeMessage("5214011", "照片上传失败");
    public static final CommonCodeMessage PHOTO_COMPRESS_FAIL              = new CommonCodeMessage("5214012", "照片压缩异常，上传失败");

    public static final CommonCodeMessage PHOTO_DELETE_FAIL_ONE            = new CommonCodeMessage("5214021", "照片不存在咯");
    public static final CommonCodeMessage PHOTO_DELETE_FAIL_TWO            = new CommonCodeMessage("5214022", "删除失败");
    public static final CommonCodeMessage PHOTO_GETBATCH_FAIL              = new CommonCodeMessage("5214041", "家庭上传照片已达到上限，获取批次失败");
    public static final CommonCodeMessage PHOTO_QUERY_AUTH_FAIL            = new CommonCodeMessage("5214001", "无操作权限，查询失败");
    public static final CommonCodeMessage JOIN_FAIMILY_FAIL_ONE            = new CommonCodeMessage("5212021", "该家庭不存在，无法加入");

    public static final CommonCodeMessage JOIN_FAIMILY_FAIL_TWO            = new CommonCodeMessage("5212022", "您已加入家庭，无法重复加入");
    public static final CommonCodeMessage JOIN_FAIMILY_FAIL_THREE          = new CommonCodeMessage("5212023", "数据保存异常");
    public static final CommonCodeMessage JOIN_FAIMILY_FAIL_FOUR           = new CommonCodeMessage("5212024", "您的申请记录还未过期，请等待管理员处理");
    public static final CommonCodeMessage DELETE_MEMBER_FAIL_ONE           = new CommonCodeMessage("5212071", "不是家庭的成员，删除失败");
    public static final CommonCodeMessage DELETE_MEMBER_FAIL_TWO           = new CommonCodeMessage("5212072", "数据清除异常");

    public static final CommonCodeMessage DELETE_MEMBER_FAIL_THREE         = new CommonCodeMessage("5212073", "不能删除自己哦");
    public static final CommonCodeMessage DELETE_MEMBER_FAIL_FOUR          = new CommonCodeMessage("5212074", "家庭不存在或者您不是管理员，无权删除成员");
    public static final CommonCodeMessage ADMIN_CONFIRM_FAIL_ONE           = new CommonCodeMessage("5212091", "申请记录不存在，加入失败");
    public static final CommonCodeMessage ADMIN_CONFIRM_FAIL_TWO           = new CommonCodeMessage("5212092", "该成员已加入别的家庭");
    public static final CommonCodeMessage ADMIN_CONFIRM_FAIL_THREE         = new CommonCodeMessage("5212093", "加入失败");
    public static final CommonCodeMessage ADMIN_CONFIRM_FAIL_FOUR          = new CommonCodeMessage("5212094", "该成员已加入了您的家庭");

    public static final CommonCodeMessage GET_MEMBERS_FAIL                 = new CommonCodeMessage("5212032", "获取成员列表失败");
    public static final CommonCodeMessage UPDATW_MEMBERS_NOT_MEMBER        = new CommonCodeMessage("5212041", "信息修改失败，请刷新后重试哦");
    public static final CommonCodeMessage UPDATW_MEMBERS_FAIL              = new CommonCodeMessage("5212042", "修改失败，请重试哦");
    public static final CommonCodeMessage EXIT_FAMILY_ADMIN                = new CommonCodeMessage("5212081", "用户为家庭管理员，不能退出");

    public static final CommonCodeMessage EXIT_FAMILY_FAIL                 = new CommonCodeMessage("5212083", "退出家庭失败，请稍后再试");
    public static final CommonCodeMessage ADD_TCOMMENT_FAIL                = new CommonCodeMessage("5215011", "您无权评论照片哦");
    public static final CommonCodeMessage ADD_VCOMMENT_FAIL                = new CommonCodeMessage("5215021", "您无权评论照片哦");
    public static final CommonCodeMessage ADD_VCOMMENT_UPLOAD_FAIL         = new CommonCodeMessage("5215023", "语音文件上传失败");

    public static final CommonCodeMessage ADD_VCOMMENT_UPLOAD_EXCEPTION    = new CommonCodeMessage("5215024", "语音文件读取异常");
    public static final CommonCodeMessage DELETE_COMMENT_NOT_MEMBER        = new CommonCodeMessage("5215051", "您无权删除评论哦");
    public static final CommonCodeMessage DELETE_COMMENT_NOT_EXIST         = new CommonCodeMessage("5215052", "评论删除失败");
    public static final CommonCodeMessage QUERY_COMMENT_NO_PHOTO           = new CommonCodeMessage("5215031", "照片已删除");
    public static final CommonCodeMessage QUERY_COMMENT_NO_AUTH            = new CommonCodeMessage("5215032", "无权查看评论");
    public static final CommonCodeMessage UPDATE_STATUS_NO_COMMENT         = new CommonCodeMessage("5215041", "评论已删除");
    public static final CommonCodeMessage UPDATE_STATUS_NO_AUTH            = new CommonCodeMessage("5215042", "您无操作权限哦");

    public static final CommonCodeMessage UPDATE_STATUS_FAIL_TWO           = new CommonCodeMessage("5215042", "评论信息不正确，更新失败（请使用其他成员的passId更新该条语音的查看状态）");
    public static final CommonCodeMessage MEMBER_CONFIRM_PHOEN_NULL        = new CommonCodeMessage("5212067", "向管理员发消息时查询出被邀请者手机号码为空");
    public static final CommonCodeMessage MEMBER_CONFIRM_MESSAGE_FAIL      = new CommonCodeMessage("5212069", "被邀请成员确认消息系统异常");
    public static final CommonCodeMessage MEMBER_CONFIRM_MESSAGE_EXCEPTION = new CommonCodeMessage("5212060", "被邀请成员确认, 新增成员异常!");
    public static final CommonCodeMessage QUERY_RETURN_NULL                = new CommonCodeMessage("5200001", "数据库返回为空");
    public static final CommonCodeMessage MEMBER_INVITE_MESSAGE_FAIL       = new CommonCodeMessage("5212058", "邀请家庭成员调用短信网关异常!");
    public static final CommonCodeMessage UNDO_TASK                        = new CommonCodeMessage("5216002", "未做过该任务!");
    public static final CommonCodeMessage DO_TASK                          = new CommonCodeMessage("5216003", "已做过该任务!");

    public static final CommonCodeMessage QUERY_RETURN_FAIL                = new CommonCodeMessage("5212053", "查询数据库返回结果不是预期结果!");
    public static final CommonCodeMessage USER_NOT_ADMIN                   = new CommonCodeMessage("5212051", "用户不是管理员");
    public static final CommonCodeMessage USER_IN_FAMILY                   = new CommonCodeMessage("5212052", "对方已加入您的家庭，无法邀请");
    public static final CommonCodeMessage USER_IN_OTHER_FAMILY             = new CommonCodeMessage("5212054", "对方已加入别的家庭，无法邀请");
    public static final CommonCodeMessage QUERY_APPLASTEST_FAIL            = new CommonCodeMessage("5217011", "当前无任何版本，检测失败");

    public static final CommonCodeMessage UPLOAD_APPLASTEST_FAIL           = new CommonCodeMessage("5217021", "APP新版本上传失败");
    public static final CommonCodeMessage DELETE_APPLASTEST_FAIL_ONE       = new CommonCodeMessage("5217031", "APP版本不存在，删除失败");
    public static final CommonCodeMessage DELETE_APPLASTEST_FAIL_TWO       = new CommonCodeMessage("5217032", "APP版本删除失败");
    public static final CommonCodeMessage FAMILY_NOT_EXIST                 = new CommonCodeMessage("5212025", "家庭不存在");
    public static final CommonCodeMessage FAMILY_DELETED                   = new CommonCodeMessage("5212026", "家庭已被解散");
    public static final CommonCodeMessage REPEAT_SIGN                      = new CommonCodeMessage("5216001", "重复签到");

    public static final CommonCodeMessage NOT_SAME_FAMILY                  = new CommonCodeMessage("5212181", "您与对方不在同一家庭中");
    public static final CommonCodeMessage MEMBER_NOT_EXIST                 = new CommonCodeMessage("5212182", "成员不存在");

    public static final CommonCodeMessage RESPONSE_USERSYS_ERROR           = new CommonCodeMessage("5201005", "用户管理子系统响应异常");
    public static final CommonCodeMessage INVOKE_USERSYS_ERROR             = new CommonCodeMessage("5201002", "无法连接用户管理子系统");
    public static final CommonCodeMessage INVOKE_SCCHARGE_ERROR            = new CommonCodeMessage("5201006", "四川能力平台异常");

    public static final CommonCodeMessage LOGO_OVERSIZE                    = new CommonCodeMessage("5212201", "头像大小超过限制");
    public static final CommonCodeMessage NO_FAMILY_LOGO                   = new CommonCodeMessage("5212211", "该家庭还未设置头像");
    public static final CommonCodeMessage TASKEXEC_WITHOUT_SCORE           = new CommonCodeMessage("5216071", "该次任务执行不能获取积分");

    public static final CommonCodeMessage USER_NOT_IN_FAMILY               = new CommonCodeMessage("5212231", "该用户未在家庭中");
    public static final CommonCodeMessage GREY_NO_WHITE_USER               = new CommonCodeMessage("5217012", "新版本是灰度版本，并且该用户不在白名单中");
    public static final CommonCodeMessage ALREADY_GREY_USER                = new CommonCodeMessage("5217041", "Ta已经是体验用户啦");

    public static final CommonCodeMessage NO_QUALIFICATION                 = new CommonCodeMessage("5222031", "用户没有资格领取");
    public static final CommonCodeMessage ALREADY_OVER_DATE                = new CommonCodeMessage("5222032", "活动已经过期");
    public static final CommonCodeMessage ACTIVITY_NOT_EXIST               = new CommonCodeMessage("5222033", "活动id不存在");
    public static final CommonCodeMessage ACTIVITY_NOT_START               = new CommonCodeMessage("5222034", "活动未开始");
    public static final CommonCodeMessage TOO_MANY_DEVICE_OPERATION        = new CommonCodeMessage("5222035", "尊敬的用户，您的手机已为两个号码领取过奖励，不要贪心哦~！");
    public static final CommonCodeMessage DEVICE_UUID_NOT_EXIST            = new CommonCodeMessage("5222036", "设备id不存在");
    public static final CommonCodeMessage NOT_SAME_DEVICE_UUID             = new CommonCodeMessage("5222037", "领取和兑换流量券必须在同一个设备");
    public static final CommonCodeMessage EXCHANGE_TIME_NOT_REACH          = new CommonCodeMessage("5222038", "领取流量券24小时后才可以进行兑换");

    public static final CommonCodeMessage NO_QUALIFICATION_PARTICIPATE     = new CommonCodeMessage("5222041", "用户没有资格参与活动");
    public static final CommonCodeMessage UN_RECEIVE                       = new CommonCodeMessage("5222042", "用户还未领取");
    public static final CommonCodeMessage ALREADY_EXCHANGE                 = new CommonCodeMessage("5222043", "已经兑换");
    public static final CommonCodeMessage NOT_MATCH_PROV                   = new CommonCodeMessage("5222044", "用户所属省份无法参加活动");

    public static final CommonCodeMessage WECHAT_NOT_BIND                  = new CommonCodeMessage("5222045", "微信公众号用户未绑定手机");
    public static final CommonCodeMessage WECHAT_NOT_ATTENTION             = new CommonCodeMessage("5222046", "未关注微信公众号");
    public static final CommonCodeMessage WECHAT_PHONE_ALREADY_BINDED      = new CommonCodeMessage("5222047", "手机已被其他微信绑定");
    public static final CommonCodeMessage WECHAT_WXID_ALREADY_BINDED       = new CommonCodeMessage("5222048", "微信号已绑定其他手机号");
    public static final CommonCodeMessage WECHAT_ALREADY_BINDED            = new CommonCodeMessage("5222049", "微信号与该手机号已绑定");

    public static final CommonCodeMessage ONLY_MOBILE_USER                 = new CommonCodeMessage("5222050", "活动仅限移动号码参与");
    public static final CommonCodeMessage CHANCE_REACHE_MAX                = new CommonCodeMessage("5222051", "用户今日抽奖机会已到上限");
    public static final CommonCodeMessage CHANCE_USED_UP                   = new CommonCodeMessage("5222052", "用户今日抽奖机会已用完");
    public static final CommonCodeMessage STAFF_NOT_ALLOW                  = new CommonCodeMessage("5222053", "员工不能参与");

    /**
     * 网关相关码
     */
    public static final CommonCodeMessage ACQUIRE_ACCESSTOKEN_FAIL         = new CommonCodeMessage("5201004", "无有效ACCESS_TOKEN");
    public static final CommonCodeMessage INVOKE_DEVICESYS_ERROR           = new CommonCodeMessage("5201001", "无法连接设备管理子系统");
    public static final CommonCodeMessage INVOKE_PLUGINSYS_ERROR           = new CommonCodeMessage("5201003", "无法连接插件管理子系统");
    public static final CommonCodeMessage NOT_EXISTS_GAEWAY                = new CommonCodeMessage("2202003", "当前连接网关%s未激活，请联系装维人员");
    public static final CommonCodeMessage CHECK_MD5_SIGN_ERROR             = new CommonCodeMessage("2202002", "MD5校验失败");
    public static final CommonCodeMessage PLUGIN_EXTEND_LIMITS_ERROR       = new CommonCodeMessage("2202025", "用户安装的插件个数已达到上限");
    public static final CommonCodeMessage PLUGIN_HASINSTALLED_ERROR        = new CommonCodeMessage("2202023", "插件已安装");
    public static final CommonCodeMessage USER_NOTINSTALL_PLUGIN_ERROR     = new CommonCodeMessage("2202022", "用户未安装该插件");
    public static final CommonCodeMessage PARA_NULL_ERROR                  = new CommonCodeMessage("2101002", "必填参数为空");
    public static final CommonCodeMessage PARAM_INPUT_ERROR                = new CommonCodeMessage("2202024", "输入参数错误");
    public static final CommonCodeMessage REQTYPE_NOTEXISTS_ERROR          = new CommonCodeMessage("2202021", "输入参数错误");
    public static final CommonCodeMessage USER_BIND_GATEWAYNUM_OUTOFLIMIT  = new CommonCodeMessage("2202028", "您绑定的网关数量已达上限");
    public static final CommonCodeMessage GATEWAY_BINDED                   = new CommonCodeMessage("2202004", "当前网关%s已被%s绑定");
    public static final CommonCodeMessage NOT_EXISTS_BINDMAP               = new CommonCodeMessage("2202001", "用户和MAC不存在绑定关系");
    public static final CommonCodeMessage USER_NO_EXIST                    = new CommonCodeMessage("2201002", "该用户不存在");
    public static final CommonCodeMessage RESULTCODE_OTHER_FORMAT_ERROR    = new CommonCodeMessage("2101004", "其他报文格式错误(请求格式没有按照约定)");
    public static final CommonCodeMessage GATEWAY_HAS_ACTIVATED            = new CommonCodeMessage("2202007", " 网关已激活，勿重复激活");
    public static final CommonCodeMessage GATEWAY_HAS_CLOSE_ACCOUNT        = new CommonCodeMessage("2202030", " 网关已销户");
    public static final CommonCodeMessage GATEWAY_IS_BINDING               = new CommonCodeMessage("2202031", "网关%s正在绑定，请勿多次点击");
    public static final CommonCodeMessage GATEWAY_BIND_FAIL                = new CommonCodeMessage("2202034", "网关绑定失败");
    public static final CommonCodeMessage GATEWAY_NOT_BELONG_USER          = new CommonCodeMessage("2202035", "网关%s不属于电话号码为%s的用户名下");

    public static final CommonCodeMessage AUTH_ACCESSTOKEN_ILLEGAL         = new CommonCodeMessage("5301002", "ACCESS_TOKEN非法");
    public static final CommonCodeMessage AUTH_ACCESSTOKEN_EXPRIED         = new CommonCodeMessage("5301003", "ACCESS_TOKEN过期");

    public static final CommonCodeMessage MAX_USER_NUM                     = new CommonCodeMessage("5211071", "查询数量超过最大值");

    public static final CommonCodeMessage USER_QBAO_NOT_MATCH              = new CommonCodeMessage("5218001", "当前用户和亲宝不匹配");
    public static final CommonCodeMessage USER_REMIND_NOT_MATCH            = new CommonCodeMessage("5218002", "当前用户和设置的家庭提醒不匹配");
    public static final CommonCodeMessage USER_REMIND_NOT_EXIST            = new CommonCodeMessage("5218003", "用户未设置该条提醒");
    public static final CommonCodeMessage USER_REMIND_SET_ERROR            = new CommonCodeMessage("5218004", "用户设置提醒时不能将提醒人员设置为他人");
    public static final CommonCodeMessage USER_QBAO_NOT_EXIST              = new CommonCodeMessage("5218005", "亲宝信息不存在");

    public static final CommonCodeMessage NO_BIND_TV                       = new CommonCodeMessage("5225021", "您未绑定过任何设备,解绑失败");
    public static final CommonCodeMessage ALREADY_BIND_TV                  = new CommonCodeMessage("5225022", "您已绑定过同类设备");
    public static final CommonCodeMessage TV_BINDED                        = new CommonCodeMessage("5225023", "设备已被其他家庭绑定");
    public static final CommonCodeMessage TV_NOT_MATCH                     = new CommonCodeMessage("5225024", "解绑设备与绑定设备不一致");
    /**
     * 设备子系统返回错误码
     */
    public static final CommonCodeMessage GATEWAY_UNSYNC                   = new CommonCodeMessage("3202003", "网关数据未同步到设备子系统");
    public static final CommonCodeMessage GATEWAY_UPDATING                 = new CommonCodeMessage("3202005", "网关正在升级中");

    public static final CommonCodeMessage FRIEND_APPLY_NOT_EXIST           = new CommonCodeMessage("2703001", "亲友申请记录不存在");
    public static final CommonCodeMessage ALREADY_FRIEND                   = new CommonCodeMessage("2703002", "已经是好友");
    public static final CommonCodeMessage ALREADY_REFUSE                   = new CommonCodeMessage("2703003", "已经拒绝");
    public static final CommonCodeMessage ALREADY_BE_AGREE                 = new CommonCodeMessage("2703004", "已经被同意");
    public static final CommonCodeMessage NOT_FRIEND                       = new CommonCodeMessage("2706005", "好友关系不存在");
    public static final CommonCodeMessage APPLY_OUT_OF_TIME                = new CommonCodeMessage("2706006", "申请已经过期");
    public static final CommonCodeMessage FRIEND_NUM_LIMIT                 = new CommonCodeMessage("2706007", "好友数量达到上限");

    public static final CommonCodeMessage GATEWAY_NOT_IMPORT               = new CommonCodeMessage("2906001", "网关信息未导入");
    public static final CommonCodeMessage GATEWAY_NOT_ACTIVE               = new CommonCodeMessage("2906002", "网关未激活");

    public static final CommonCodeMessage JOB_ACT_RELATION_NOEXIST         = new CommonCodeMessage("5231041", "活动任务关联关系不存在");

    public static final CommonCodeMessage USER_ALREADY_REGISTERED          = new CommonCodeMessage("5232001", "用户已经是和家亲用户");

}
