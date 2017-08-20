package devLib.mq.jms.v2;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;

import org.apache.activemq.artemis.api.jms.ActiveMQJMSClient;

/**
 * 
 * @author 缪云海[miaoyunhai@cmhi.chinamobile.com]
 *
 */
public class JMSReceiverV2 extends BaseMessage {

	private Queue queue;
	private JMSContext context;
	private JMSConsumer consumer;

	public JMSReceiverV2(String url) {
		super(url);
	}

	public JMSReceiverV2(String url, String user, String password) {
		super(url, user, password);
	}

	public void init() {
		queue = ActiveMQJMSClient.createQueue("exampleQueue");
		context = super.getContext();
		consumer = context.createConsumer(queue);
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {

			}
		});
	}

	public void close() {
		consumer.close();
		context.close();
	}

	public static void main(String[] args) {
		JMSReceiverV2 receiver = new JMSReceiverV2("tcp://localhost:61616");
		receiver.init();
	}

}
