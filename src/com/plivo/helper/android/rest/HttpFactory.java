package com.plivo.helper.android.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.util.Log;

import com.google.gson.Gson;
import com.plivo.helper.android.attributes.CallAttributes;
import com.plivo.helper.android.exception.AndroidClientException;
import com.plivo.helper.android.response.CallResponse;
import com.plivo.helper.android.utils.Credentials;
import com.plivo.helper.android.utils.StatusCodes;

/*
 * Core class for performing API requests and handling the responses.
 */

public class HttpFactory {

	private Credentials creds;
	private Gson gson;

	public HttpFactory(String authID, String authToken) {

		creds = new Credentials(authID, authToken);
		gson = new Gson();
	}

	private String postRequest(String url, Map<String, String> parameters)
			throws AndroidClientException {

		String resp = "";
		try {
			
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);
			post.addHeader("Content-Type", "application/json");

			JSONObject json = new JSONObject(parameters);
			StringEntity params = new StringEntity(json.toString());
			post.setEntity(params);
			
			HttpResponse response = httpClient.execute(post);
			int statusCode = response.getStatusLine().getStatusCode();
			
			if(response.getEntity() != null && (statusCode == StatusCodes.STATUS_SUCCESS)) {
			
				resp = inputStreamToString(response.getEntity().getContent());
				resp.replaceFirst("\\{", "{ \"response_code\": \"" + statusCode + "\", ");

			} else {
				
				resp = " {\"response_code\": \"" + statusCode + "\"} ";
			}

			Log.d("plivosdk", "Response: "+statusCode);
			return resp;
			
		} catch (UnsupportedEncodingException e) {
			throw new AndroidClientException("UnsupportedEncodingException : " + e.getLocalizedMessage());
		} catch (ClientProtocolException e) {
			throw new AndroidClientException("ClientProtocolExcepstion : " + e.getLocalizedMessage());
		} catch (IOException e) {
			throw new AndroidClientException("IOException : " + e.getLocalizedMessage());
		} 
	}

	private String inputStreamToString(InputStream istream) 
            throws IOException {
        
		BufferedReader breader = new BufferedReader(new InputStreamReader(istream));
        	StringBuilder responseString = new StringBuilder();
        	String line = "";
        	while ((line = breader.readLine()) != null) {
            		responseString.append(line);
        	}
        	
        	breader.close();
        	return responseString.toString();
    	}

	public CallResponse makeCall(Map<String, String> params)
			throws AndroidClientException {

		Log.d("plivosdk", params.get(CallAttributes.FROM));
		Log.d("plivosdk", params.get(CallAttributes.TO));
		Log.d("plivosdk", params.get(CallAttributes.ANSWER_URL));
		Log.d("", "Call URL: "+creds.getCallUri()); 
		
		CallAttributes.checkAttributes(params);
		String response = postRequest(creds.getCallUri(), params);
		return gson.fromJson(response, CallResponse.class);
	}
}
