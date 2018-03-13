package dhome.nio.core.mesage;

import com.alibaba.fastjson.JSONObject;

public class Program {

    public static void main(String[] args) {
        MsgHeader header = new MsgHeader();
        header.setMac("00BE9EC60C70");
        header.setSn("FHTT21C60C70");

        MsgBody data = new MsgBody();

        Message msg = new Message();
        msg.setHeader(header);
        msg.setData(data);

        String str = JSONObject.toJSONString(msg);
        System.out.println(str);
    }

}
