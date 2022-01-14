package com.done.RegistrationService.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggerUtil {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void logInfo(
            Class<?> clazz,
            String message
    ) {
        LOGGER.info(String.format("[%s]: %s", clazz.getSimpleName(), message));
    }

    public static void warn(
            Class<?> clazz,
            String message
    ) {
        LOGGER.warning(String.format("[%s]: %s", clazz.getSimpleName(), message));
    }

    public static void logError(
            Class<?> clazz,
            String message
    ) {
        LOGGER.severe(String.format("[%s]: %s", clazz.getSimpleName(), message));
    }

    public static void logError(
            Class<?> clazz,
            Throwable exception
    ) {
        String errorStackTrace = stackTraceToString(exception);
        LOGGER.severe(String.format("[%s]: %s", clazz.getSimpleName(), errorStackTrace));
    }

    public static void logError(
            Class<?> clazz,
            String message,
            Throwable exception
    ) {
        String errorStackTrace = stackTraceToString(exception);
        LOGGER.severe(String.format("[%s]: %s\n%s", clazz.getSimpleName(), message, errorStackTrace));
    }

    private static String stackTraceToString(Throwable exception) {
        StringWriter sw = new StringWriter();
        exception.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
