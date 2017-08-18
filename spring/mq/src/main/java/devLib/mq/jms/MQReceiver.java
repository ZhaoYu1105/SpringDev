package devLib.mq.jms;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MQReceiver extends Thread {

    private volatile boolean running = true;
    private Connection       connection;
    private Session          session;
    private MessageConsumer  consumer;

    public MQReceiver() {

    }

    public boolean init() {
        try {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("myQueue");
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
        while (running) {
            try {
                consumer.receive(100);
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