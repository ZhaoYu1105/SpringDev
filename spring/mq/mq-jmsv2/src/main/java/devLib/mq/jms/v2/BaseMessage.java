package devLib.mq.jms.v2;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

/**
 * 定义JMS消息的基础类
 * @author 缪云海[miaoyunhai@cmhi.chinamobile.com]
 *
 */
public class BaseMessage {
	private ConnectionFactory factory;

	public BaseMessage(String url) {
		factory = new ActiveMQConnectionFactory(url);
	}

	public BaseMessage(String url, String user, String password) {
		factory = new ActiveMQConnectionFactory(url, user, password);
	}

	public ConnectionFactory getConnectionFactory() {
		return factory;
	}
	
	public JMSContext getContext() {
		return factory.createContext();
	}
}
