package org.minbox.framework.logging.client.global;

import com.alibaba.ttl.TransmittableThreadLocal;
import org.minbox.framework.logging.core.NonRequestLog;
import org.springframework.util.ObjectUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Use threadLocal to store all {@link NonRequestLog} in a request that need to be saved
 *
 * @author 恒宇少年
 */
public class NonRequestLogThreadLocal {
    /**
     * GlobalLog {@link ThreadLocal} define
     */
    private static final TransmittableThreadLocal<List<NonRequestLog>> NON_REQUEST_LOGS = new TransmittableThreadLocal();

    /**
     * Get {@link NonRequestLog} List from ThreadLocal
     *
     * @return {@link NonRequestLog}
     */
    public static List<NonRequestLog> getGlobalLogs() {
        return NON_REQUEST_LOGS.get();
    }

    /**
     * Add {@link NonRequestLog} to ThreadLocal
     *
     * @param globalLog {@link NonRequestLog}
     */
    public static void addNonRequestLog(NonRequestLog globalLog) {
        List<NonRequestLog> globalLogs = getGlobalLogs();
        if (ObjectUtils.isEmpty(globalLogs)) {
            globalLogs = new LinkedList();
        }
        globalLogs.add(globalLog);
        NON_REQUEST_LOGS.set(globalLogs);
    }

    /**
     * Delete {@link NonRequestLog} list in ThreadLocal
     */
    public static void remove() {
        NON_REQUEST_LOGS.remove();
    }
}
