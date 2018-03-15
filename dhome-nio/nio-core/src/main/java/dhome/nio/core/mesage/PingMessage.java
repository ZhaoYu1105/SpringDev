package dhome.nio.core.mesage;

import dhome.nio.core.mesage.base.EnumMsgType;
import dhome.nio.core.mesage.base.Message;
import dhome.nio.core.mesage.base.MsgHeader;

public class PingMessage extends Message {

    private static final long serialVersionUID = 3621345704077354479L;

    private PingMessage(String mac, String sn) {
        MsgHeader header = new MsgHeader();
        header.setMac(mac);
        header.setSn(sn);
        header.setMsgType(EnumMsgType.EnumMsgPing);

        super.setHeader(header);
    }

    public static PingMessage create(String mac, String sn) {
        return new PingMessage(mac, sn);
    }

}
