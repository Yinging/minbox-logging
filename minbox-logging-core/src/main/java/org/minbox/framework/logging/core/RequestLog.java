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

import java.util.Map;

/**
 * Request log entity
 * <p>
 * Define the relevant fields of request and response
 *
 * @author 恒宇少年
 */
@Data
@Accessors(chain = true)
public class RequestLog extends TraceLog {
    /**
     * request uri
     */
    private String requestUri;
    /**
     * request method
     */
    private String requestMethod;
    /**
     * http status code
     */
    private int httpStatus;
    /**
     * request ip
     */
    private String requestIp;
    /**
     * request headers
     */
    private Map<String, String> requestHeaders;
    /**
     * request param
     */
    private String requestParam;
    /**
     * request body
     */
    private String requestBody;
    /**
     * response headers
     */
    private Map<String, String> responseHeaders;
    /**
     * response body
     */
    private String responseBody;
}
