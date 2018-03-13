package dhome.nio.core.util;

import java.io.File;
import java.io.IOException;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class LogBackConfigLoader {
	public static void load(String extCfg) throws IOException, JoranException {

		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

		File externalConfigFile = new File(extCfg);
		if (!externalConfigFile.exists()) {
			throw new IOException("logback config file: [" + extCfg + "] is not exist!");
		}
		if (!externalConfigFile.isFile()) {
			throw new IOException("logback config file: [" + extCfg + "] is invalid!");
		}
		if (!externalConfigFile.canRead()) {
			throw new IOException("logback config file: [" + extCfg + "] unavailable to read！");
		}

		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(lc);
		lc.reset();
		configurator.doConfigure(extCfg);
		StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
	}
}
