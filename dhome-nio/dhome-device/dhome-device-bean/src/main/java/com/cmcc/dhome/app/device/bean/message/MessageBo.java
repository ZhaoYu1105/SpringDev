package com.cmcc.dhome.app.device.bean.message;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息表
 * 
 * @author 顾欣
 * @date 2016年5月11日 - 上午11:22:54
 * @history
 *          2016年5月11日 - 上午11:22:54 lenovo create.
 */
public class MessageBo implements Serializable {
    private static final long  serialVersionUID     = 152168246677403316L;

    /**
     * message.msg_id:
     * <p>
     * <code>
     * 消息ID<br>
     * </code>
     */
    private long               msgId;

    /**
     * message.msg_type:
     * <p>
     * <code>
     * 系统类型（01，系统消息  02，设备消息）<br>
     * </code>
     */
    private String             msgType;

    /**
     * message.msg_index:
     * <p>
     * <code>
     * 模块<br>
     * </code>
     */
    private String             msgIndex;

    /**
     * message.msg_scene:
     * <p>
     */
    private String             msgScene;

    /**
     * message.creater:
     * <p>
     * <code>
     * 触发者<br>
     * </code>
     */
    private String             creater;

    /**
     * message.reciever:
     * <p>
     * <code>
     * 接收者<br>
     * </code>
     */
    private String             reciever;

    /**
     * message.create_time:
     * <p>
     * <code>
     * 创建时间<br>
     * </code>
     */
    private Date               createTime;

    /**
     * message.update_time:
     * <p>
     * <code>
     * 更新时间<br>
     * </code>
     */
    private Date               updateTime;

    /**
     * message.context:
     * <p>
     * <code>
     * 消息体<br>
     * </code>
     */
    private String             context;

    /**
     * message.status:
     * <p>
     * <code>
     * 状态(0:未读,1:已读)<br>
     * </code>
     */
    private String             status;

    /**
     * message.url:
     * <p>
     */
    private String             url;

    /**
     * message.ext_info:
     * <p>
     */
    private String             extInfo;

    /**
     * 未读消息数量
     */
    private String             count;

    // 一级消息分类（type）
    public final static String TYPE_SYSMSG          = "01";               // 系统消息
    public final static String TYPE_DEVICEMSG       = "02";               // 设备消息
    public final static String TYPE_OPERATIONMSG    = "03";               // 运营消息

    // 系统消息-二级消息分类
    public final static String INDEX_FAMILY         = "01";               // 家庭群组
    public final static String INDEX_FRIEND         = "02";               // 亲友
    public final static String INDEX_BIRTHDAY       = "03";               // 生日（未使用）
    public final static String INDEX_INTIMACY       = "04";               // 亲密度(已废弃)
    public final static String INDEX_SYSTEM         = "05";               // 系统公告(未使用)
    public final static String INDEX_EXPENSE        = "06";               // 流量话费(未使用)
    public final static String INDEX_FAMILY_REMIND  = "07";               // 家庭提醒
    public final static String INDEX_LIFE           = "08";               // 生活

    // 设备消息-二级消息分类（index）
    public final static String INDEX_DEVICE         = "01";               // 设备
    public final static String INDEX_GATEWAY        = "02";               // 网关
    public final static String INDEX_BLACKLIST      = "03";               // 黑名单
    public final static String INDEX_MEDAL          = "04";               // 勋章
    public final static String INDEX_GATEWAY_SHARE  = "05";               // 网关分享

    // 运营消息-二级消息分类
    public final static String INDEX_OPERATION      = "01";               // 运营活动

    // 系统消息-家庭群组-三级分类（scene）
    public final static String SCENE_CREAT          = "01";               // 创建家庭
    public final static String SCENE_INVITE         = "02";               // 邀请加入家庭
    public final static String SCENE_RECEIVE        = "03";               // 成员加入家庭，家庭其他成员包括管理者，都可在消息的系统消息列表中收到提醒
    public final static String SCENE_MEMBER         = "04";               // 管理员删除成员时，家庭其他成员（不包括管理者），可在消息的系统消息列表中收到提醒
    public final static String SCENE_DISSOLUTION    = "05";               // 管理员解散家庭，家庭其他成员在消息的系统消息列表中收到提醒
    public final static String SCENE_EXIT           = "06";               // 成员退出家庭，其他成员包括管理者，在消息的系统消息列表中收到提醒
    public final static String SCENE_INSERT         = "07";               // 成员主动申请加入家庭
    public final static String SCENE_REFUSE         = "08";               // 成员拒绝管理员加入家庭的邀请
    public final static String SCENE_DELETE         = "09";               // 当成员被删除时，被删除成员app当前页面收到弹窗提醒
    public final static String SCENE_NEW            = "10";               // 被管理员加入家庭或主动申请加入家庭，被管理员接收后，新成员接受到消息提醒
    public final static String SCENE_UPDATEFNAME    = "11";               // 当管理员修改家庭名称时，推送修改后的名字
    public final static String SCENE_UPDATEFLOGO    = "12";               // 更新家庭logo
    public final static String SCENE_INVITE_MSG     = "13";               // 已在其他家庭中的成员收到别的家庭邀请
    public final static String SCENE_BULLETIN_MSG   = "14";               // 已在其他家庭中的成员收到别的家庭邀请
    public final static String SCENE_TRANS_ADMIN    = "15";               // 管理员转让，新管理员消息
    public final static String BIND_TV              = "16";               // 家庭绑定TV时，向家庭所有成员推送消息
    public final static String UN_BIND_TV           = "17";               // 家庭解绑TV时，向家庭所有成员推送消息
    public final static String SCENE_MSG_FLOW_PUSH  = "18";               // 消息流推送

    // 系统消息-照片-三级分类（scene）
    public final static String SCENE_UPLOAD         = "01";               // 照片上传
    public final static String SCENE_COMMENT        = "02";               // 照片评论

    // 系统消息-生日-三级分类（scene）
    public final static String SCENE_REMIND         = "01";               // 生日提醒（未使用）
    public final static String SCENE_BLESSING       = "02";               // 生日祝福（未使用）

    // 系统消息-亲密度-三级分类（scene）
    public final static String SCENE_INTIMACY       = "01";               // 已废弃

    // 系统消息-系统公告-三级分类（scene）
    public final static String SCENE_UPDATE         = "01";               // 版本更新（未使用）
    public final static String SCENE_SUSPEND        = "02";               // 暂停服务（未使用）

    // 系统消息-流量话费-三级分类（scene）
    public final static String SCENE_SEND           = "01";               // 为成员充（未使用）
    public final static String SCENE_RECEIVED       = "02";               // 收到他人充（未使用）

    // 系统消息-家庭提醒-三级分类（scene）
    public final static String SCENE_FAMILY_REMIND  = "01";               // 家庭提醒

    // 设备消息-设备-三级分类（scene）
    public final static String SCENE_ONLINE         = "01";               // 设备上线提醒
    public final static String SCENE_OFFLINE        = "02";               // 设备下线提醒
    public final static String SCENE_REFRESH        = "03";               // 下挂设备列表刷新提醒
    public final static String SCENE_EXCEPTION      = "04";               // 设备异常上线

    // 设备消息-网关-三级分类（scene）
    public final static String SCENE_BIND           = "01";               // 网关绑定通知
    public final static String SCENE_UNBIND         = "02";               // 网关解绑通知
    public final static String SCENE_HEALTHCHANGE   = "03";               // 健康模式设置变更通知
    public final static String SCENE_HEALTHCLOSE    = "04";               // 健康模式启用通知
    public final static String SCENE_WEEKREPORT     = "05";               // 网络周报通知
    public final static String SCENE_PLUGIN_UPDATE  = "06";               // 插件更新推送

    // 设备消息-网关共享-三级分类（scene）
    public final static String SCENE_SHARE_ADD      = "01";               // 加入网关共享
    public final static String SCENE_SHARE_DEL      = "02";               // 被移出网关共享
    public final static String SCENE_SHARE_EXIT     = "03";               // 自主退出网关共享
    public final static String SCENE_APPLY_SHARE    = "04";               // 申请网关的共享

    // 设备消息-黑名单-三级分类（scene）
    public final static String SCENE_BLACKLIST      = "01";

    // 设备消息-勋章-三级分类（scene）
    public final static String SCENE_MEDALGET       = "01";               // 获得勋章
    public final static String SCENE_MEDAL_PUSH     = "02";               // 获得勋章推送有勋章的网关

    // 运营消息-三级消息分类（scene）
    public final static String SCENE_OPERATING_PUSH = "01";

    // 亲友消息-三级消息分类（scene）

    public final static String SCENE_RE_APPLY       = "01";               // 申请好友,自身在对方好友列表中
    public final static String SCENE_APPLY_FRIEND   = "02";               // 申请好友
    public final static String SCENE_AGREE          = "03";               // 同意好友申请
    public final static String SCENE_DELETE_FRIEND  = "04";               // 删除好友

    public MessageBo(long msgId, String msgType, String msgIndex, String msgScene, String creater, Date updateTime, String context, String url,
            String extInfo) {
        super();
        this.msgId = msgId;
        this.msgType = msgType;
        this.msgIndex = msgIndex;
        this.creater = creater;
        this.msgScene = msgScene;
        this.updateTime = updateTime;
        this.context = context;
        this.url = url;
        this.extInfo = extInfo;
    }

    public MessageBo(String msgType, String msgIndex, String msgScene, String creater, String reciever, String context, String url, String extInfo) {
        this.msgType = msgType;
        this.msgIndex = msgIndex;
        this.creater = creater;
        this.reciever = reciever;
        this.msgScene = msgScene;
        this.context = context;
        this.url = url;
        this.extInfo = extInfo;
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    public MessageBo() {
        super();
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    public String getMsgIndex() {
        return msgIndex;
    }

    public void setMsgIndex(String msgIndex) {
        this.msgIndex = msgIndex == null ? null : msgIndex.trim();
    }

    public String getMsgScene() {
        return msgScene;
    }

    public void setMsgScene(String msgScene) {
        this.msgScene = msgScene == null ? null : msgScene.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever == null ? null : reciever.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo == null ? null : extInfo.trim();
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

}
