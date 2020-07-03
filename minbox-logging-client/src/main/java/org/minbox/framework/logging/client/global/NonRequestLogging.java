/*
 *  Copyright 2020. [恒宇少年 - 于起宇]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.minbox.framework.logging.client.global;

import org.minbox.framework.logging.core.LogLevel;

/**
 * Unsolicited log method definition interface
 * <p>
 * Provide debug, info, warn, and error log collection
 *
 * @author 恒宇少年
 */
public interface NonRequestLogging {
    /**
     * Collect Debug Level Logs
     *
     * @param msg log content
     */
    void debug(String msg);

    /**
     * Collect Debug Level Logs
     *
     * @param format    Unformatted log content
     * @param arguments List of parameters corresponding to log content
     */
    void debug(String format, Object... arguments);

    /**
     * Collect Info Level Logs
     *
     * @param msg log content
     */
    void info(String msg);

    /**
     * Collect Info Level Logs
     *
     * @param format    Unformatted log content
     * @param arguments List of parameters corresponding to log content
     */
    void info(String format, Object... arguments);

    /**
     * Collect {@link LogLevel#warn} level logs
     *
     * @param msg log content
     */
    void warn(String msg);

    /**
     * Collect {@link LogLevel#warn} level logs
     * <p>
     * Support to use "{}" placeholder to format log content
     *
     * @param format    Unformatted log content
     * @param arguments Parameters corresponding to placeholders
     */
    void warn(String format, Object... arguments);

    /**
     * Collect Error Level Logs
     *
     * @param msg log content
     */
    void error(String msg);

    /**
     * Collect Error Level Logs
     *
     * @param msg       log content
     * @param throwable Exception object instance
     */
    void error(String msg, Throwable throwable);

    /**
     * Collect Error Level Logs
     *
     * @param format    Unformatted log content
     * @param arguments List of parameters corresponding to log content
     */
    void error(String format, Object... arguments);
}
