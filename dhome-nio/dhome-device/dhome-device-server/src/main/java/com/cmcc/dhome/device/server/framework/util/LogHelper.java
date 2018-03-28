package com.cmcc.dhome.device.server.framework.util;

import org.slf4j.Logger;

public class LogHelper {
    
    public void info(Logger log, String format, Object... arguments) {
        log.info(format, arguments);
    }
    
    public void debug(Logger log, String format, Object... arguments) {
        log.debug(format, arguments);
    }
    
    public void warn(Logger log, String format, Object... arguments) {
        log.warn(format, arguments);
    }
    
    public void error(Logger log, String format, Object... arguments) {
        log.error(format, arguments);
    }
}
