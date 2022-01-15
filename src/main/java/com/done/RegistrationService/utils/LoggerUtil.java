package com.done.RegistrationService.utils;

import java.util.logging.Logger;

public class LoggerUtil {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void logInfo(
            Class<?> clazz,
            String message
    ) {
        LOGGER.info(String.format("[%s]: %s", clazz.getSimpleName(), message));
    }
}
