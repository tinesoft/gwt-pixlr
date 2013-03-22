
package com.tinesoft.gwt.pixlr.showcase.client.util;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.i18n.client.NumberFormat;

/**
 * Facade to GWT-Log logging framework.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 */
public final class GWTLog {

    private static final String PATTERN = "{}";

    private static int traceId = 0;

    /**
     * Log debug messages.
     * 
     * @param message the message.
     */
    public static void debug(final String message) {
        Log.debug(message);
    }

    /**
     * Log debug messages.
     * 
     * @param pattern the pattern.
     * @param objects the objects to replace in the pattern.
     */
    public static void debug(final String pattern, final Object ... objects) {
        debug(compute(pattern, objects));
    }

    /**
     * Log error messages.
     * 
     * @param message the message.
     */
    public static void error(final String message) {
        Log.error(message);
    }

    /**
     * Log error messages.
     * 
     * @param pattern the pattern.
     * @param objects the objects to replace in the pattern.
     */
    public static void error(final String pattern, final Object ... objects) {
        error(compute(pattern, objects));
    }

    /**
     * Log error messages.
     * 
     * @param message the message.
     * @param ex the exception.
     */
    public static void error(final String message, final Throwable ex) {
        Log.error(message, ex);
    }

    /**
     * Log info messages.
     * 
     * @param message the message.
     */
    public static void info(final String message) {
        Log.info(message);
    }

    /**
     * Log info messages.
     * 
     * @param pattern the pattern.
     * @param objects the objects to replace in the pattern.
     */
    public static void info(final String pattern, final Object ... objects) {
        info(compute(pattern, objects));
    }

    /**
     * Check for debugging mode.<br>
     * This can be used as code guard e.g. <code>if (Log.isDebugEnabled() {...}</code> to ensure
     * unnecessary code is compiled out when <code>log_level=OFF</code> or any log_level higher than
     * DEBUG.
     * 
     * @return true if <code>log_level=DEBUG</code>
     */
    public static boolean isDebugEnabled() {
        return Log.isDebugEnabled();
    }

    /**
     * Activates the uncaught exception handler.
     */
    public static void setUncaughtExceptionHandler() {
        Log.setUncaughtExceptionHandler();
    }

    /**
     * Log an automatically generated trace message. The message contains a unique identifier, the
     * class and the method name, as well as the line number where the trace was executed.
     */
    public static void trace() {
        final StringBuilder str = new StringBuilder();

        str.append("TRACE #");
        str.append(NumberFormat.getFormat("000").format(++traceId));

        final Throwable e = new Throwable();
        if (e.getStackTrace().length >= 2) {
            final StackTraceElement stack = e.getStackTrace()[1];
            str.append(" : ");
            str.append(stack.getClassName());
            str.append(" - ");
            str.append(stack.getMethodName());
            str.append(" [");
            str.append(stack.getLineNumber());
            str.append("]");
        }
        Log.trace(str.toString());
    }

    /**
     * Log trace messages.
     * 
     * @param message the message.
     */
    public static void trace(final String message) {
        Log.trace(message);
    }

    /**
     * Log trace messages.
     * 
     * @param pattern the pattern.
     * @param objects the objects to replace in the pattern.
     */
    public static void trace(final String pattern, final Object ... objects) {
        trace(compute(pattern, objects));
    }

    /**
     * Log warn messages.
     * 
     * @param message the message.
     */
    public static void warn(final String message) {
        Log.warn(message);
    }

    /**
     * Log warn messages.
     * 
     * @param pattern the pattern.
     * @param objects the objects to replace in the pattern.
     */
    public static void warn(final String pattern, final Object ... objects) {
        warn(compute(pattern, objects));
    }

    /**
     * Replaces all placeholders in the pattern with the corresponding element.
     * 
     * @param pattern the pattern.
     * @param objects the objects to replace in the pattern.
     * @return the message to print.
     */
    private static String compute(final String pattern, final Object ... objects) {
        final StringBuilder builder = new StringBuilder(pattern);
        for (final Object o : objects) {
            final int start = builder.indexOf(PATTERN);
            if (start != -1) {
                builder.replace(start, start + 2, null != o ? o.toString() : "null");
            }
        }
        return builder.toString();
    }

    /**
     * Utility Class. No public constructor.
     */
    private GWTLog() {}
}
