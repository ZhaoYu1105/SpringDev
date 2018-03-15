package dhome.nio.core.mesage;

import com.alibaba.fastjson.JSONObject;

import dhome.nio.core.mesage.base.EnumMsgType;
import dhome.nio.core.mesage.base.Message;
import dhome.nio.core.mesage.base.MsgBody;
import dhome.nio.core.mesage.base.MsgHeader;

public class Program {

	public static void main(String[] args) {
		MsgHeader header = new MsgHeader();
		header.setMac("00BE9EC60C70");
		header.setSn("FHTT21C60C70");
		header.setMsgType(EnumMsgType.EnumMsgPing);

		MsgBody data = new MsgBody();

		JSONObject param = new JSONObject();
		param.put("age", 13);
		param.put("gender", "male");

		Message msg = new Message();
		msg.setHeader(header);
		msg.setData(data);
		msg.setParam(param);

		String str = msg.toString();
		System.out.println(str);
	}

}
