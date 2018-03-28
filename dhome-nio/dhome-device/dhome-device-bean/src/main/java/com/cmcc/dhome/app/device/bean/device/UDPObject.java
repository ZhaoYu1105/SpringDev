package com.cmcc.dhome.app.device.bean.device;

import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP对象
 * 
 * @author 徐海涛[xuhaitao@chinamobile.com]
 * @date 2017年9月6日 - 下午6:24:52
 * @history
 *          2017年9月6日 - 下午6:24:52 徐海涛[xuhaitao@chinamobile.com] create.
 */
public class UDPObject {

    private DatagramSocket socket;
    private InetAddress    address;
    private int            port;

    public UDPObject(DatagramSocket socket, InetAddress address, int port) {
        super();
        this.socket = socket;
        this.address = address;
        this.port = port;
    }

    public DatagramSocket getSocket() {
        return socket;
    }

    public void setSocket(DatagramSocket socket) {
        this.socket = socket;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
