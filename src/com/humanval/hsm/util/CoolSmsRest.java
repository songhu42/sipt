package com.humanval.hsm.util;

import java.util.Properties;
import java.util.HashMap;

import org.json.simple.JSONObject;

/*
 * Coolsms Class
 * RestApi JAVA 
 * v1.1 
 * POST?GET REQUEST
 */
public class CoolSmsRest extends Https {
	private String api_key;
	private String api_secret;	
	private Https https = new Https();
	Properties properties = System.getProperties();

	/*
	 * Set api_key, api_secret
	 */
	public CoolSmsRest(String api_key, String api_secret) {
		this.api_key = api_key;
		this.api_secret = api_secret;
	}
	
	/*
	 * Send messages
	 * @param set : HashMap<String, String>
	 */
	@SuppressWarnings("unchecked")
	public JSONObject send(HashMap<String, String> params) {
		JSONObject response = new JSONObject();

		try {
			// 기본정보 입력
			params.put("api_secret", this.api_secret);
			params.put("api_key", this.api_key);
			params.put("os_platform", properties.getProperty("os_name"));
			params.put("dev_lang", "JAVA " + properties.getProperty("java.version"));
			params.put("sdk_version", "JAVA SDK 1.1");

			// Send message 
			response = https.postRequest("send", params);	
		} catch (Exception e) {
			response.put("status", false);
			response.put("message", e.toString());
		}
		return response;
	}
	
	/*
	 * Sent messages
	 * @param set : HashMap<String, String>
	 */
	@SuppressWarnings("unchecked")
	public JSONObject sent(HashMap<String, String> params) {
		JSONObject response = new JSONObject();

		try {
			// 기본정보 입력
			params.put("api_secret", this.api_secret);
			params.put("api_key", this.api_key);
			
			response = https.request("sent", params); // GET방식 전송	
		} catch (Exception e) {
			response.put("status", false);
			response.put("message", e.toString());
		}
		return response;
	}

	/*
	 * Reserve message cancel 
	 * @param set : HashMap<String, String>
	 */
	@SuppressWarnings("unchecked")
	public JSONObject cancel(HashMap<String, String> params) {
		JSONObject response = new JSONObject();

		try {
			// 기본정보 입력
			params.put("api_secret", this.api_secret);
			params.put("api_key", this.api_key);
			
			// Cancel reserve message 
			response = https.postRequest("cancel", params);	
		} catch (Exception e) {
			response.put("status", false);
			response.put("message", e.toString());
		}
		return response;
	}

	/*
	 * Balance info
	 */
	@SuppressWarnings("unchecked")
	public JSONObject balance() {
		JSONObject response = new JSONObject();
		
		try {
			// 기본정보 입력
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("api_secret", this.api_secret);
			params.put("api_key", this.api_key);

			// GET방식 전송	
			response = https.request("balance", params); // GET방식 전송	
		} catch (Exception e) {
			response.put("status", false);
			response.put("message", e.toString());
		}
		return response;
	}
}
