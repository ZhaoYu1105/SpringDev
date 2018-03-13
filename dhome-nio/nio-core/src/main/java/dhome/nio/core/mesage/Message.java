package dhome.nio.core.mesage;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * 基础消息体
 * 
 * @author 缪云海[miaoyunhai@cmhi.chinamobile.com]
 * @date 2018年3月13日 - 上午8:55:51
 * @history
 *          2018年3月13日 - 上午8:55:51 缪云海[miaoyunhai@cmhi.chinamobile.com] create.
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 8233538858844913171L;

    @NotNull(message = "缺少头信息")
    private MsgHeader         header;

    private MsgBody           data;

    public MsgHeader getHeader() {
        return header;
    }

    public void setHeader(MsgHeader header) {
        this.header = header;
    }

    public MsgBody getData() {
        return data;
    }

    public void setData(MsgBody data) {
        this.data = data;
    }

}
