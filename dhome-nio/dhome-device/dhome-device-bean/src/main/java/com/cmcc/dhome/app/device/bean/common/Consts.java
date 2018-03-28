package com.cmcc.dhome.app.device.bean.common;

/**
 * 常量类
 * 
 * @author zhuqun[zhuqun@chinamobile.com]
 * @date 2016年11月30日 - 上午9:24:42
 * @history
 *          2016年11月30日 - 上午9:24:42 zhuqun[zhuqun@chinamobile.com] create.
 */
public class Consts {

    // 小溪相关常量
    public final static String  MSGBIZTYPE                   = "EHOME_NOTIFY_PUSH"; // 消息业务类型
    public final static String  MSG_PORT                     = "9090";              // 小溪消息服务器端口
    /**
     * 离线处理方式
     */
    public final static String  IOS_PUSH                     = "1";                 // 0:离线不发送消息;1:离线存储消息并ios推送;2:离线存储消息且ios不推送
    public final static String  IOS_NOT_PUSH                 = "2";
    public final static String  HTTP_OPERATE_TYPE            = "type";              // 操作标记
    public final static String  HTTP_OPERATE_ACTION          = "action";
    public final static String  HTTP_OPERATE_TYPE_ADD        = "add";               // 添加操作
    public final static String  HTTP_OPERATE_TYPE_DELETE     = "delete";            // 删除操作
    public final static String  HTTP_OPERATE_TYPE_UPDATE     = "update";            // 修改操作
    public final static String  HTTP_OPERATE_TYPE_SEARCH     = "search";            // 查询操作
    public final static String  SUC                          = "1";                 // 成功
    public final static String  FAIL                         = "0";                 // 失败
    // public final static int CODE = 2; // 小溪用户存在
    // public final static String PROJECT = "/plugins/openservice/userforappid";
    // public final static String NEW_PROJECT = "/plugins/openservice/userv2";
    // public final static String GLOBAL_USER_PASSWORD = "eHomePasswd";
    // //所有用户登录小溪的公用密码

    // 用户任务
    public final static String  INVITE                       = "invite";            // 邀请家庭成员
    public final static String  UPLOAD_PHOTO                 = "uploadPhoto";       // 上传家庭照片
    public final static String  VIOCE_CALL                   = "voiceCall";         // 与家人进行语音通话
    public final static String  VIDEO_CALL                   = "videoCall";         // 与家人进行视频通话
    public final static String  NEW_ACTIVE                   = "newActive";         // 新人激活
    public final static String  SIGN                         = "sign";              // 首次/连续第二天签到
    public final static String  CONTINUOUS_SIGN              = "continuousSign";    // 连续第三天及以上签到
    public final static String  JOIN_FMLY                    = "joinFamily";        // 加入家庭

    // 任务领取积分阈值
    public final static int     TASK_SCORE_LIMIT_NO          = 0;                   // 该任务领取积分未达上限
    public final static int     TASK_SCORE_LIMIT_IN          = 1;                   // 该任务领取积分已达上限
    public final static int     TASK_SCORE_LIMIT_TO          = 2;                   // 该任务该次领取积分后达上限
    public final static int     TASK_SCORE_USER_LIMIT        = 1;                   // 该任务达个人领取上限
    public final static int     TASK_SCORE_FMLY_LIMIT        = 2;                   // 该任务达家庭领取上限（优先个人领取上限）

    // 任务卡执行状态
    public final static int     TASK_STATUS_FIRST            = 1;                   // 单日首次任务
    public final static int     TASK_STATUS_GET_SCORE        = 2;                   // 有执行未领取积分记录
    public final static int     TASK_STATUS_NOT_FIRST        = 3;                   // 单日非首次任务，且执行记录积分都已被领取，还未达领取上限
    public final static int     TASK_STATUS_UP_LIMIT         = 4;                   // 单日达领取积分上限(个人或家庭)

    // 任务执行领取积分状态
    public final static int     TASK_SCORE_NOT_ADDED         = 0;                   // 任务执行未领取积分
    public final static int     TASK_SCORE_ADDED             = 1;                   // 任务执行已领取积分

    // 首页配置相关常量
    public final static String  IDX_GETDATA_BY_CLIENT        = "CLIENT";            // 需要客户端获取数据
    public final static String  IDX_GETDATA_BY_PLATFORM      = "PLATFORM";          // 需要平台获取数据
    public final static String  IDX_DATAPART_IMGURL          = "IMGURL";            // 展示图片需要获取数据
    public final static String  IDX_DATAPART_SUBTITLE        = "SUBTITLE";          // 副标题需要获取数据
    public final static String  IDX_DATAPART_IMGURL_SUBTITLE = "IMGURL_SUBTITLE";   // 展示图片、副标题需要获取数据

    /**
     * 系统消息
     */
    public static final String  SYSMSG                       = "01";

    /**
     * 设备消息
     */
    public static final String  DEVICEMSG                    = "02";
    /**
     * 当前执行的操作：绑定、解绑、一键绑定
     */
    public static final String  BIND_OPERATOR_BIND           = "1";
    public static final String  BIND_OPERATOR_UNBIND         = "2";
    public static final String  BIND_OPERATOR_KEYBIND        = "3";
    /**
     * 绑定方式：普通绑定、一键绑定、预绑定
     */
    public static final int     BIND_TYPE_NORMAL             = 0;
    public static final int     BIND_TYPE_KEYBIND            = 1;
    public static final int     BIND_TYPE_PREBIND            = 2;

    /**
     * 网关绑定状态
     */
    public static final int     BINDSTATUS_BIND              = 0;
    public static final int     BINDSTATUS_UNBIND            = 1;

    public static long          TIME                         = 24 * 60 * 60 * 1000;
    /**
     * 安装插件的最大数量
     */
    public final static Integer MAXNUM                       = 50;

    /**
     * 插件类型
     */
    public static final Integer PLUGIN_TYPE_APP              = 1;
    public static final Integer PLUGIN_TYPE_GATEWAY          = 2;

    /**
     * 插件状态
     */
    public static final String  PLUGIN_STATUS_ON             = "on";
    public static final String  PLUGIN_STATUS_OFF            = "off";

    /**
     * 插件操作类型 pluginInstall、pluginUninstall、pluginStart、pluginStop
     */
    public static final String  PLUGIN_PLUGININSTALL         = "pluginInstall";
    public static final String  PLUGIN_PLUGINUNINSTALL       = "pluginUninstall";
    public static final String  PLUGIN_PLUGINSTART           = "pluginStart";
    public static final String  PLUGIN_PLUGINSTOP            = "pluginStop";

    /**
     * 是否参见活动
     */
    public static final int     IS_NOT_JOIN                  = 0;
    public static final int     IS_JOIN                      = 1;

    /**
     * JsonBaby 默认值
     */
    public static final String  DEFALUT_BODY                 = "{}";

    public static final int     MAXUSERSIZE                  = 20;                  // 查询最大用户数(根据macs查询用户信息)

    public static final int     MAX_QUERY_USER_SIZE          = 30;

}
