package dhome.nio.server.run;

import java.io.IOException;

import ch.qos.logback.core.joran.spi.JoranException;
import dhome.nio.core.util.LogBackConfigLoader;
import dhome.nio.server.framework.TCPServer;

public class ServerRun {

    public static void main(String[] args) throws IOException, JoranException {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String file = path + "logback.xml";
        LogBackConfigLoader.load(file);

        final TCPServer server = new TCPServer();
        new Thread() {
            @Override
            public void run() {
                server.initServer();
            }
        }.start();
    }

}
