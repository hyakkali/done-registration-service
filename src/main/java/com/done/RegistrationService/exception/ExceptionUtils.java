package com.done.RegistrationService.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtils {
    public static String stackTraceToString(Throwable exception) {
        StringWriter sw = new StringWriter();
        exception.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
