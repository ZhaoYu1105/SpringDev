package devLib.mq.jms.v1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 
 * @author 缪云海[miaoyunhai@cmhi.chinamobile.com]
 *
 */
public class MQSender {

	static int size = 1000000;
	static Connection connection;
	static Session session;
	static MessageProducer producer;
	static Topic topic;
	static String str = "[{'flag':'1','value':'8854c92e92404b188e63c4031db0eac9','label':'交换机(虚机)'},{'flag':'1','value':'8854c92e92404b188e63c4031db0eac9','label':'交换机(虚机)'}]";

	public static void initConnection() throws Exception {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://172.16.229.131:61616");
		connection = factory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = session.createTopic("java.activemq.tps");
		// producer = session.createProducer(topic);
		Queue queue = session.createQueue("exampleQueue");
		producer = session.createProducer(queue);
		// producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		System.out.println("Connection is established......");
	}

	public static void sendMessage(String msg) {
		TextMessage message;
		try {
			message = session.createTextMessage();
			message.setText(str);
			message.setJMSExpiration(1000);

			producer.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void close() throws Exception {
		connection.close();
	}

	public static void main(String[] arg) throws Exception {

		initConnection();

		final AtomicInteger counters = new AtomicInteger(0);
		ExecutorService es = Executors.newFixedThreadPool(10);
		final CountDownLatch cdl = new CountDownLatch(size);
		long start = System.currentTimeMillis();
		for (int a = 0; a < size; a++) {
			es.execute(new Runnable() {
				@Override
				public void run() {
					sendMessage(str);
					cdl.countDown();

					if (0 == counters.incrementAndGet() % 10000) {
						double ts = ((double) (System.currentTimeMillis() / 100) / 10);
						System.out.println(ts + ", total :" + counters.get());
					}
				}
			});
		}
		cdl.await();
		es.shutdown();

		long time = System.currentTimeMillis() - start;
		System.out.println("插入" + size + "条JSON，共消耗：" + (double) time / 1000 + " s");
		System.out.println("平均：" + size / ((double) time / 1000) + " 条/秒");
		close();
	}
}