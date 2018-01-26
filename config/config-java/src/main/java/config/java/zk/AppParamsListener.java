package config.java.zk;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import config.java.api.AppConfig;

public class AppParamsListener extends Thread {

    private ZkClient        _client      = null;

    private IZkDataListener dataListener = null;

    /**
     * zookeeper连接地址
     */
    private String          zkURL        = "";

    /**
     * 连接超时时间
     */
    private int             connTimeout  = 5000;

    /**
     * 监听节点
     */
    private String          nodePath     = "";

    public AppParamsListener() {
        this.dataListener = new IZkDataListener() {

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {

            }

            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                AppConfig.Instance = (AppConfig)data;
                System.out.println(AppConfig.Instance);
            }
        };
    }

    @Override
    public synchronized void start() {
        try {
            _client = new ZkClient(getZkURL(), getConnTimeout());
            System.out.println("ZK 成功建立连接！");
        } catch (Exception e) {
            _client = null;

            while (_client == null) {
                try {
                    sleep(1000);
                    _client = new ZkClient(getZkURL(), getConnTimeout());
                    System.out.println("ZK 成功建立连接！");
                } catch (Exception e2) {
                    _client = null;
                }
            }
        } finally {
            if (_client != null) {
                _client.subscribeDataChanges(getNodePath(), dataListener);
                System.out.println("监听数据变化！");
            }
        }
        
        super.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                _client.wait(100);
            } catch (Exception e) {
            }
        }
    }

    public String getZkURL() {
        return zkURL;
    }

    public void setZkURL(String zkURL) {
        this.zkURL = zkURL;
    }

    public int getConnTimeout() {
        return connTimeout;
    }

    public void setConnTimeout(int connTimeout) {
        this.connTimeout = connTimeout;
    }

    public String getNodePath() {
        return nodePath;
    }

    public void setNodePath(String nodePath) {
        this.nodePath = nodePath;
    }

    public static void main(String[] args) {
        AppParamsListener listener = new AppParamsListener();
        
        listener.setZkURL("127.0.0.1:2181");
        listener.setNodePath("/zk/cf");
        listener.start();
    }
}
