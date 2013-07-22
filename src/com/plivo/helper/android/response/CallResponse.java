package com.plivo.helper.android.response;

import com.google.gson.annotations.SerializedName;

/*
 * Call Response model object.
 */

public class CallResponse {

	@SerializedName("response_code")
	private int responseCode;
	
	@SerializedName("message")
	private String message;
	
	@SerializedName("request_uuid")
	private String requestUUID;
	
	@SerializedName("api_id")
	private String apiID;
	
	@SerializedName("error")
	private String error;
		
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getRequestUUID() {
		return requestUUID;
	}
	public void setRequestUUID(String requestUUID) {
		this.requestUUID = requestUUID;
	}
	
	public String getApiID() {
		return apiID;
	}
	public void setApiID(String apiID) {
		this.apiID = apiID;
	}
	
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

}