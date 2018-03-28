package com.cmcc.dhome.app.device.bean.framework.message;

import com.cmcc.dhome.app.device.bean.extend.FeatureStatusBean;

/**
 * 查询功能服务状态
 * 
 * @author jsh[jiasonghao@cmhi.chinamobile.com]
 * @date 2018年1月8日 - 下午6:35:24
 * @history
 *          2018年1月8日 - 下午6:35:24 jsh[jiasonghao@cmhi.chinamobile.com] create.
 */
public class FeatureStatusQueryMessage extends DeviceRequestMessage {

    /**
     * 
     */
    private static final long serialVersionUID = 9038569509740949027L;

    private String            mac;
    private String            sn;
    private String            type             = "request";
    private String            osgiName         = "extend";
    private String            pluginName       = "Feature";
    private String            cmdType          = "GET_FEATURE_STATUS";
    private String            userId;
    private String            rpcMethod        = "get";
    private String            id;
    private String            sequenceId;
    private Object            parameter;

    public FeatureStatusQueryMessage(FeatureStatusBean fs) {
        super();
        this.mac = fs.getMac();
        this.sn = fs.getSn();
        this.userId = fs.getUserId();
        this.id = fs.getSeqId();// TODO-j 待定
        this.sequenceId = "待定";
        this.parameter = fs.getParam();
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOsgiName() {
        return osgiName;
    }

    public void setOsgiName(String osgiName) {
        this.osgiName = osgiName;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public String getCmdType() {
        return cmdType;
    }

    public void setCmdType(String cmdType) {
        this.cmdType = cmdType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRpcMethod() {
        return rpcMethod;
    }

    public void setRpcMethod(String rpcMethod) {
        this.rpcMethod = rpcMethod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

}
