package com.cmcc.dhome.app.device.bean.message;

/**
 * 查询未读消息数量使用
 * @author kedan[kedanhz@139.com]
 * @date 2017年1月12日 - 上午10:57:42
 * @history 
 * 		 2017年1月12日 - 上午10:57:42 kedan[kedanhz@139.com] create.
 */
public class MsgParam {
    
    /**
     * 消息类型
     */
    private String msgType;
    
    /**
     * 未读消息数量
     */
    private int counts;

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }
    
    

}
