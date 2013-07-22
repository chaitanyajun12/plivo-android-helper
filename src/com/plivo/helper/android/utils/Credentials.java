package com.plivo.helper.android.utils;


/*
 * This class maintains all the credentials pertaining the Android SDK, for instance the URLs.
 */
public final class Credentials {

	private final String BASE_URL = "https://api.plivo.com/v1";
	private final String VERSION = "v1";
	private String CALL_URL;
	
	private final String AUTH_ID;
	private final String AUTH_TOKEN;
	
	public Credentials(String authID, String authToken) {
		this.AUTH_ID = authID;
		this.AUTH_TOKEN = authToken;
		CALL_URL = BASE_URL+"/Account/"+authID+"/Call/";
	}
	
	public boolean isAuthenticated(int statusCode) {
		
		if(statusCode == StatusCodes.STATUS_AUTH_FAILED) {
			return false;
		}
		
		return true;
	}
	
	public String getCallUri() {
		return CALL_URL;
	}
	
	public String getAuthId() {
		return AUTH_ID;
	}

	public String getAuthToken() {
		return AUTH_TOKEN;
	}

	public String getBaseURL() {
		return BASE_URL;
	}

	public String getApiVersion() {
		return VERSION;
	}
}