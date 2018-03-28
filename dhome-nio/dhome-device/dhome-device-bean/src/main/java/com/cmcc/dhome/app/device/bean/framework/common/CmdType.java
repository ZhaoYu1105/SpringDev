/**
 * @ platform-plugin-framework
 * @ com.cmcc.dhome.device.server.framework.annotation
 * @ PluginClass.java
 * 
 * @author liujianliang@chinamobile.com 2016年4月30日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package com.cmcc.dhome.app.device.bean.framework.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 网关功能注解，用于标记功能实现类中的方法，设备接入服务器启动时会自动扫描所有功能实现类中的方法，并建立功能名称和method的关系
 * 
 * @author liujianliang@chinamobile.com
 * @date 2016年4月30日 - 上午10:02:08
 * @history
 *          2016年4月30日 - 上午10:02:08 liujianliang@chinamobile.com create.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CmdType {
    public String value();
}
