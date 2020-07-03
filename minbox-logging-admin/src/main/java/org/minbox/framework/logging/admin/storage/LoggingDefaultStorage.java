package org.minbox.framework.logging.admin.storage;

import org.minbox.framework.logging.core.NonRequestLog;
import org.minbox.framework.logging.core.RequestLog;
import org.minbox.framework.logging.core.response.LoggingResponse;
import org.minbox.framework.logging.core.response.ServiceResponse;

import java.sql.SQLException;
import java.util.List;

/**
 * The {@link LoggingStorage} default support
 *
 * @author 恒宇少年
 */
public class LoggingDefaultStorage implements LoggingStorage {
    @Override
    public String insertGlobalLog(String requestLogId, NonRequestLog log) throws SQLException {
        return null;
    }

    @Override
    public String insertLog(String serviceDetailId, RequestLog log) throws SQLException {
        return null;
    }

    @Override
    public String insertServiceDetail(String serviceId, String serviceIp, int servicePort) throws SQLException {
        return null;
    }

    @Override
    public String selectServiceDetailId(String serviceId, String serviceIp, int servicePort) throws SQLException {
        return null;
    }

    @Override
    public List<ServiceResponse> findAllService() throws SQLException {
        return null;
    }

    @Override
    public List<LoggingResponse> findTopList(int topCount) throws SQLException {
        return null;
    }

    @Override
    public void updateLastReportTime(String serviceDetailId) throws SQLException {

    }
}
