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
package org.minbox.framework.logging.core;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Non-request log entity
 * <p>
 * Unsolicited logs are mainly for asynchronous scenarios.
 * Examples:
 * message queues, scheduled tasks, and thread pools.
 *
 * @author 恒宇少年
 */
@Data
@Accessors(chain = true)
public class NonRequestLog extends TraceLog {
    /**
     * Global log level
     * {@link LogLevel}
     */
    private LogLevel level;
    /**
     * all level's log content
     */
    private String content;
    /**
     * caller class name
     * {@link StackTraceElement#getClassName()}
     */
    private String callerClass;
    /**
     * caller method name
     * {@link StackTraceElement#getMethodName()}
     */
    private String callerMethod;
    /**
     * caller code line number
     * {@link StackTraceElement#getLineNumber()}
     */
    private int callerCodeLineNumber;
    /**
     * Parameter json string when calling method
     */
    private String parameterJsonValue;
    /**
     * Return json string when calling method
     */
    private String returnJsonValue;
}
