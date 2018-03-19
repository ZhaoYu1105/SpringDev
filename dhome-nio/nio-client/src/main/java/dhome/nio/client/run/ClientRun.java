package dhome.nio.client.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dhome.nio.client.framework.TCPClient;
import dhome.nio.core.mesage.PingMessage;
import dhome.nio.core.util.LogBackConfigLoader;

public class ClientRun {
    static final Logger log = LoggerFactory.getLogger(ClientRun.class.getName());

    public static void main(String[] args) throws Exception {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String file = path + "logback.xml";
        LogBackConfigLoader.load(file);

        TCPClient client = new TCPClient();
        boolean connected = client.connect("127.0.0.1", 15683);
        if (connected) {
            for (int i = 0; i < 100; i++) {
                PingMessage msg = PingMessage.create("00BE9EC60C70", "FHTT21C60C70");
                client.sendMsg(msg);
            }
        }

        client.close();
    }

}
