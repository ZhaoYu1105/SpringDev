package dhome.nio.core.mesage;

import dhome.nio.core.mesage.base.EnumMsgType;
import dhome.nio.core.mesage.base.Message;
import dhome.nio.core.mesage.base.MsgHeader;

public class PongMessage extends Message {

    private static final long serialVersionUID = 6069144542294595055L;

    private PongMessage(String mac, String sn) {
        MsgHeader header = new MsgHeader();
        header.setMac(mac);
        header.setSn(sn);
        header.setMsgType(EnumMsgType.EnumMsgPong);

        super.setHeader(header);
    }

    public static PongMessage create(String mac, String sn) {
        return new PongMessage(mac, sn);
    }

}
