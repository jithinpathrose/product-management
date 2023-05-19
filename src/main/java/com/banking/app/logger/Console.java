package com.banking.app.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Console {

    private static final Logger logger = LogManager.getLogger(Console.class);

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logDebug(String message) {
        logger.debug(message);
    }

    public static void logWarn(String message) {
        logger.warn(message);
    }

    public static void logError(String message, Exception e) {
        logger.error(message, e);
    }

    public static void logError(String message) {
        logger.error(message);
    }
}
