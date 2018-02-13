package dhome.rpc.provider;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class RpcRun {

	public static void main(String[] args) throws Exception {
		initApplicationContext();

		// 防止jvm关闭
		Object obj = new Object();
		synchronized (obj) {
			while (true) {
				obj.wait();
			}
		}
	}

	/**
	 * 初始化spring及相关配置
	 * 
	 * @return
	 * @throws IOException
	 * @throws JoranException
	 * @author majinjin[majinjin@cmhi.chinamobile.com]
	 * @date 2017年6月1日 - 下午5:22:54
	 * @history 2017年6月1日 - 下午5:22:54 majinjin[majinjin@cmhi.chinamobile.com]
	 *          create.
	 */
	public static ApplicationContext initApplicationContext() throws IOException {
		String osType = System.getProperty("os.name").toLowerCase();

		String springConfFile = "classpath:spring-config.xml";

		System.out.println("Operating Systerm: " + osType);
		System.out.println("Loaded sping config file: " + springConfFile);

		return new FileSystemXmlApplicationContext(springConfFile);
	}
}
