package com.cmcc.dhome.device.server.framework.util;

import com.cmcc.dhome.app.device.bean.framework.common.DeviceChannelMap;

public class DeviceCounter implements Runnable {

    @Override
    public void run() {
        System.out.println("=========当前TCP连接数: " + DeviceChannelMap.get() + ", " + DeviceChannelMap.size());
    }

}
