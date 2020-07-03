package org.minbox.framework.logging.client.global;

import org.minbox.framework.logging.core.LogLevel;
import org.minbox.framework.logging.core.NonRequestLog;
import org.springframework.util.ObjectUtils;

/**
 * The {@link NonRequestLogging} abstract implementation
 * <p>
 * Provide public methods required for log acquisition
 *
 * @author 恒宇少年
 */
public abstract class AbstractNonRequestLogging implements NonRequestLogging {
    /**
     * Get the StackTrace of the initial calling method
     * caller class name {@link StackTraceElement#getClassName()}
     * caller method name {@link StackTraceElement#getMethodName()}
     * caller code line number {@link StackTraceElement#getLineNumber()}
     * <p>
     * Why is the index of the Get StackTraceElement 5?
     * info、debug、error level log method invocation process：
     * 0. {@link #getCallMethodStackTrace()}
     * 1. {@link #getCallerClassName()} or {@link #getCallerMethodName()} or {@link #getCallerCodeLineNumber()}
     * 2. {@link #instanceNonRequestLog()}
     * 3. {@link #buildNonRequestLog(LogLevel, String)}
     * 4. {@link NonRequestLogging#info(String)}
     * 5. Real business call method
     * </p>
     *
     * @return {@link StackTraceElement}
     */
    private StackTraceElement getCallMethodStackTrace() {
        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
        return stackTraceElements[5];
    }

    /**
     * get caller class name
     *
     * @return {@link StackTraceElement#getClassName()}
     */
    protected String getCallerClassName() {
        return getCallMethodStackTrace().getClassName();
    }

    /**
     * get caller method name
     *
     * @return {@link StackTraceElement#getMethodName()}
     */
    protected String getCallerMethodName() {
        return getCallMethodStackTrace().getMethodName();
    }

    /**
     * get caller code line number
     *
     * @return {@link StackTraceElement#getLineNumber()}
     */
    protected int getCallerCodeLineNumber() {
        return getCallMethodStackTrace().getLineNumber();
    }

    /**
     * create the {@link NonRequestLog} object instance
     * initialization set call information
     *
     * @return {@link NonRequestLog}
     */
    protected NonRequestLog instanceNonRequestLog() {
        NonRequestLog nonRequestLog = new NonRequestLog();
        nonRequestLog.setCallerClass(getCallerClassName());
        nonRequestLog.setCallerMethod(getCallerMethodName());
        nonRequestLog.setCallerCodeLineNumber(getCallerCodeLineNumber());
        return nonRequestLog;
    }

    /**
     * Build {@link NonRequestLog} instance
     *
     * @param level   {@link LogLevel}
     * @param content {@link NonRequestLog#getContent()}
     * @return {@link NonRequestLog}
     */
    protected NonRequestLog buildNonRequestLog(LogLevel level, String content) {
        NonRequestLog nonRequestLog = instanceNonRequestLog();
        nonRequestLog.setLevel(level);
        nonRequestLog.setContent(content);
        return nonRequestLog;
    }

    /**
     * Replace placeholders for log content
     *
     * @param format    Unformatted log content
     * @param arguments List of parameters corresponding to log content
     * @return formatted log
     */
    protected String replacePlaceholder(String format, Object[] arguments) {
        if (!ObjectUtils.isEmpty(arguments)) {
            for (int i = 0; i < arguments.length; i++) {
                format = format.replaceFirst("\\{\\}", String.valueOf(arguments[i]));
            }
        }
        return format;
    }
}
