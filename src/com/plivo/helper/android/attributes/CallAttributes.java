package com.plivo.helper.android.attributes;

import java.util.ArrayList;
import java.util.Map;

import com.plivo.helper.android.exception.AndroidClientException;

/*
 * List of Call Attributes.
 */
public class CallAttributes {

	// Required Parameters
	public static final String FROM = "from";
	public static final String TO = "to";
	public static final String ANSWER_URL = "answer_url";
	
	public static final String CALLBACK_URL = "callback_url";
	public static final String CALLBACK_METHOD = "callback_method";
		
	// Optional Parameters
	public static final String ANSWER_METHOD = "answer_method";
	public static final String RING_URL = "ring_url";
	public static final String RING_METHOD = "ring_method";
	public static final String HANGUP_URL = "hangup_url";
	public static final String HANGUP_METHOD = "hangup_method";	
	public static final String FALLBACK_URL = "fallback_url";
	public static final String FALLBACK_METHOD = "fallback_method";
	public static final String CALLER_NAME = "caller_name";
	public static final String SEND_DIGITS = "send_digits";
	public static final String SEND_ON_PREANSWER = "send_on_preanswer";
	public static final String TIME_LIMIT = "time_limit";
	public static final String HANGUP_ON_RING = "hangup_on_ring";
	public static final String MACHINE_DETECITION = "machine_detection";
	public static final String MACHINE_DETECTION_TIME = "machine_detection_time";
	public static final String SIP_HEAERS = "sip_headers";
	public static final String RING_TIMEOUT = "ring_timeout";
	
	private static ArrayList<String> getRequiredCallAttributes() {
		
		ArrayList<String> attr = new ArrayList<String>();
		attr.add(FROM);
		attr.add(TO);
		attr.add(ANSWER_URL);
		
		return attr;
	}

	public static void checkAttributes(Map<String, String> params) throws AndroidClientException {
		
		ArrayList<String> reqAttr = new ArrayList<String>(params.keySet());
		
		if(!reqAttr.containsAll(getRequiredCallAttributes())){
			throw new AndroidClientException("Error: Missing required attributes");
		}
	}
	
}