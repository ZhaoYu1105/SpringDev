package dhome.nio.server.run;

import dhome.nio.server.framework.TCPServer;

public class ServerRun {

    public static void main(String[] args) {
        final TCPServer server = new TCPServer();

        new Thread() {
            @Override
            public void run() {
                server.initServer();
            }
        }.start();
    }

}
