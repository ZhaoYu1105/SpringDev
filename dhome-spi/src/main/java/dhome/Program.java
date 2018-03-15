package dhome;

import java.io.IOException;
import java.util.ServiceLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.joran.spi.JoranException;
import dhome.spi.MessageProcessor;

public class Program {

	static final Logger log = LoggerFactory.getLogger(Program.class.getName());

	public static void main(String[] args) throws IOException, JoranException {
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String file = path + "logback.xml";
		LogBackConfigLoader.load(file);

		ServiceLoader<MessageProcessor> msgProcessors = ServiceLoader.load(MessageProcessor.class);
		for (MessageProcessor processor : msgProcessors) {
			log.info(processor.getName());
		}
	}

}
