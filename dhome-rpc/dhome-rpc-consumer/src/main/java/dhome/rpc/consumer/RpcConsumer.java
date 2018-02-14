package dhome.rpc.consumer;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import dhome.rpc.spi.RpcInterface;

public class RpcConsumer {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        String springConfFile = "classpath:spring-config.xml";
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(springConfFile);
        context.start();

        AtomicInteger atomic = new AtomicInteger(0);
        RpcInterface rpc = (RpcInterface) context.getBean("rpcService");
        while (true) {
            System.out.println(atomic.incrementAndGet() + "\t" + rpc.getName());
            Thread.sleep(500);
        }
    }
}
