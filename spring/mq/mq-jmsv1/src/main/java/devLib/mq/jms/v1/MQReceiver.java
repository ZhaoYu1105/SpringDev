package devLib.mq.jms.v1;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 
 * @author 缪云海[miaoyunhai@cmhi.chinamobile.com]
 *
 */
public class MQReceiver extends Thread {

	private volatile boolean running = true;
	private Connection connection;
	private Session session;
	private MessageConsumer consumer;

	private AtomicInteger counters = new AtomicInteger(0);

	public MQReceiver() {

	}

	public boolean init() {
		try {
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue("exampleQueue");
			consumer = session.createConsumer(queue);

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public void close() {

	}

	@Override
	public void run() {
		System.out.println("Message receiver is running.......");

		while (running) {
			try {
				consumer.receive(100);
				if (0 == counters.incrementAndGet() % 10000) {
					double ts = ((double) (System.currentTimeMillis() / 100) / 10);
					System.out.println(ts + ", total :" + counters.get());
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MQReceiver receiver = new MQReceiver();
		receiver.init();
		receiver.start();
	}

}