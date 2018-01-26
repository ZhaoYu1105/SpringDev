package config.java;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import config.java.api.AppConfig;

public class Application {

    public static void main(String[] args) throws Exception {
        AppConfig config = null;

        ZkClient client = new ZkClient("127.0.0.1:2181", 5000);
        System.out.println("ZK 成功建立连接！");

        System.out.println("根节点数：" + client.countChildren("/"));
        System.out.println("=============================================================");

        String path = "/zk/cf";

        client.subscribeDataChanges(path, new IZkDataListener() {

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println(dataPath);
            }

            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("handleDataChange: " + dataPath);
                System.out.println("handleDataChange: " + data);
            }
        });

        config = AppConfig.Instance;
        config.setValue("url", "http://hsop.komect.com");
        config.setValue("interval", "5");
        config.setValue("time", System.currentTimeMillis() + "");
        System.out.println(config);

        boolean flag = client.exists(path);
        if (!flag) {
            client.createPersistent(path, true);
            client.writeData(path, config);
            System.out.println("创建：" + path);
        } else {
            client.writeData(path, config);

//            Stat st = new Stat();
//            config = client.readData(path, st);
//            System.out.println(config);
//            System.out.println(st);
        }
    }

}
