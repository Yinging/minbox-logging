package org.minbox.framework.logging.client.global.support;

import org.minbox.framework.logging.client.global.AbstractNonRequestLogging;
import org.minbox.framework.logging.client.global.NonRequestLogThreadLocal;
import org.minbox.framework.logging.core.LogLevel;
import org.minbox.framework.util.StackTraceUtil;
import org.springframework.util.ObjectUtils;
import org.minbox.framework.logging.core.NonRequestLog;

/**
 * {@link NonRequestLog} memory mode storage implementation
 *
 * @author 恒宇少年
 */
public class NonRequestLoggingMemoryStorage extends AbstractNonRequestLogging {
    /**
     * collection debug level log
     *
     * @param msg log content
     */
    @Override
    public void debug(String msg) {
        NonRequestLog nonRequestLog = buildNonRequestLog(LogLevel.debug, msg);
        NonRequestLogThreadLocal.addNonRequestLog(nonRequestLog);
    }

    /**
     * collection debug level log
     * for example:
     * this is test log,value is {}
     *
     * @param format    Unformatted log content
     * @param arguments List of parameters corresponding to log content
     */
    @Override
    public void debug(String format, Object... arguments) {
        String log = replacePlaceholder(format, arguments);
        NonRequestLog nonRequestLog = buildNonRequestLog(LogLevel.debug, log);
        NonRequestLogThreadLocal.addNonRequestLog(nonRequestLog);
    }

    @Override
    public void info(String msg) {
        NonRequestLog nonRequestLog = buildNonRequestLog(LogLevel.info, msg);
        NonRequestLogThreadLocal.addNonRequestLog(nonRequestLog);
    }

    @Override
    public void info(String format, Object... arguments) {
        String log = replacePlaceholder(format, arguments);
        NonRequestLog nonRequestLog = buildNonRequestLog(LogLevel.info, log);
        NonRequestLogThreadLocal.addNonRequestLog(nonRequestLog);
    }

    @Override
    public void warn(String msg) {
        NonRequestLog nonRequestLog = buildNonRequestLog(LogLevel.warn, msg);
        NonRequestLogThreadLocal.addNonRequestLog(nonRequestLog);
    }

    @Override
    public void warn(String format, Object... arguments) {
        String log = replacePlaceholder(format, arguments);
        NonRequestLog nonRequestLog = buildNonRequestLog(LogLevel.warn, log);
        NonRequestLogThreadLocal.addNonRequestLog(nonRequestLog);
    }

    @Override
    public void error(String msg) {
        this.error(msg, java.util.Optional.ofNullable(null));
    }

    @Override
    public void error(String msg, Throwable throwable) {
        NonRequestLog nonRequestLog = buildNonRequestLog(LogLevel.error, msg);
        if (!ObjectUtils.isEmpty(throwable)) {
            String exceptionStack = StackTraceUtil.getStackTrace(throwable);
            nonRequestLog.setExceptionStack(exceptionStack);
        }
        NonRequestLogThreadLocal.addNonRequestLog(nonRequestLog);
    }

    @Override
    public void error(String format, Object... arguments) {
        String log = replacePlaceholder(format, arguments);
        NonRequestLog globalLog = buildNonRequestLog(LogLevel.error, log);
        NonRequestLogThreadLocal.addNonRequestLog(globalLog);
    }
}
