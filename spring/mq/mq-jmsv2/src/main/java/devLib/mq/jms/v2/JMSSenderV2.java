package devLib.mq.jms.v2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.CompletionListener;
import javax.jms.DeliveryMode;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;

import org.apache.activemq.artemis.api.jms.ActiveMQJMSClient;

/**
 * 
 * @author 缪云海[miaoyunhai@cmhi.chinamobile.com]
 *
 */
public class JMSSenderV2 extends BaseMessage {

	private Queue queue;
	private JMSContext context;
	private JMSProducer producer;
	private String msg = "[{'flag':'1','value':'8854c92e92404b188e63c4031db0eac9','label':'交换机(虚机)'},{'flag':'1','value':'8854c92e92404b188e63c4031db0eac9','label':'交换机(虚机)'}]";

	public JMSSenderV2(String url) {
		super(url);
	}

	public JMSSenderV2(String url, String user, String password) {
		super(url, user, password);
	}

	public void init() {
		queue = ActiveMQJMSClient.createQueue("exampleQueue");
		context = super.getContext();
		producer = context.createProducer();
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//		producer.setAsync(new CompletionListener() {
//			
//			@Override
//			public void onException(Message message, Exception exception) {
//				
//			}
//			
//			@Override
//			public void onCompletion(Message message) {
//				
//			}
//		});
		
		System.out.println("JMS Connection established......");
	}

	public void sendMessage() {
		TextMessage message = context.createTextMessage(msg);
		producer.send(queue, message);
	}

	public void close() {
		context.close();
	}

	public static void main(String[] args) throws Exception {
		JMSSenderV2 sender = new JMSSenderV2("tcp://172.16.229.131:61616");
		sender.init();

		int threads = 1;
		int size = 1000000;
		AtomicInteger counters = new AtomicInteger(0);

		ExecutorService es = Executors.newFixedThreadPool(threads);
		final CountDownLatch cdl = new CountDownLatch(size);

		long start = System.currentTimeMillis();
		for (int a = 0; a < size; a++) {
			es.execute(new Runnable() {
				@Override
				public void run() {
					sender.sendMessage();
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
	}

}
