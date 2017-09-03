package devLib.mq.jms.v2;

import java.util.concurrent.atomic.AtomicInteger;

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

    private Queue       queue;
    private JMSContext  context;
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
        // consumer.setMessageListener(new MessageListener() {
        //
        // @Override
        // public void onMessage(Message message) {
        //
        // }
        // });
    }

    public void receive() {
        final AtomicInteger counters = new AtomicInteger(0);
        while (true) {
            Message msg = consumer.receive(1000);
            
            if (msg != null) {
                if (0 == counters.incrementAndGet() % 500) {
                    double ts = ((double) (System.currentTimeMillis() / 100) / 10);
                    System.out.println("receive: " + ts + ", total :" + counters.get());
                }
            }
            else
                System.out.println("no message......");
        }
    }

    public void close() {
        consumer.close();
        context.close();
    }

    public static void main(String[] args) {
        String url = "";
        url = "tcp://172.16.229.131:61616";
        // 新座压测机器
        url = "tcp://192.168.192.198:61616";
        JMSReceiverV2 receiver = new JMSReceiverV2(url);
        receiver.init();
        receiver.receive();
    }

}
