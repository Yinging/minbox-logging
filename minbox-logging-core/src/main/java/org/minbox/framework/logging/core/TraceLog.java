/*
 * Copyright [2019] [恒宇少年 - 于起宇]
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 *
 */

package org.minbox.framework.logging.core;

import lombok.Data;

import java.io.Serializable;

/**
 * Basic definition of link tracking log
 * <p>
 * Contains common usage fields for request logs and non-request logs
 *
 * @author：恒宇少年 - 于起宇
 */
@Data
public class TraceLog implements Serializable {
    /**
     * trace id
     */
    private String traceId;
    /**
     * span id
     */
    private String spanId;
    /**
     * parent span id
     */
    private String parentSpanId;
    /**
     * service id
     */
    private String serviceId;
    /**
     * service ip address
     */
    private String serviceIp;
    /**
     * service port
     */
    private String servicePort;
    /**
     * start time
     */
    private Long startTime;
    /**
     * end time
     */
    private Long endTime;
    /**
     * this request time consuming
     */
    private long timeConsuming;
    /**
     * exception stack
     */
    private String exceptionStack;
}
