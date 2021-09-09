/*
 *  Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.apimgt.gateway.handlers.throttling.custom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext;
import org.wso2.carbon.apimgt.gateway.handlers.throttling.ThrottleHandler;

import java.util.Map;

public class CustomThrottleHandler extends ThrottleHandler {
	private static final Log log = LogFactory.getLog(CustomThrottleHandler.class);

	public CustomThrottleHandler() {
		if (log.isDebugEnabled()) {
			log.debug("Custom Throttle Handler initialized");
		}
	}

	@Override
	public boolean handleRequest(MessageContext messageContext) {
		return super.handleRequest(messageContext);
	}


	@Override
	public boolean handleResponse(MessageContext messageContext) {
		return super.handleResponse(messageContext);
	}

	@Override
	public boolean validateCustomPolicy(String userID, String appKey, String resourceKey, String apiKey,
	                                    String subscriptionKey, String apiContext, String apiVersion, String appTenant,
	                                    String apiTenant, String appId, String clientIp,
	                                    Map<String, String> keyTemplateMap, MessageContext messageContext) {
		if (userID != null && userID.contains("_")) {
			userID = userID.split("_")[0];
		}
		return super.validateCustomPolicy(userID, appKey, resourceKey, apiKey, subscriptionKey, apiContext, apiVersion,
				appTenant, apiTenant, appId, clientIp, keyTemplateMap, messageContext);
	}
}
