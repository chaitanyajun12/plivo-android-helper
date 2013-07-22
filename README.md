plivo-android-helper
====================

Plivo provides simple and easy-to-use Application Programming Interfaces (APIs) to make and receive calls, send SMSes, make a conference call, and more.

plivo-android-helper Android SDK is just a wrapper on top of Plivo. At present this SDK supports making a call.

Example
=======

The example for making a call 

1. Just create an instance of `HttpFactory` class

    <code> HttpFactory mHttp = new HttpFactory(AUTH_ID, AUTH_TOKEN); </code>
    
2. Create a map of the parameters to be posted.

    <code> LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();</code>
    
    <code> params.put(CallAttributes.FROM, FROM);  </code>
    
    <code> params.put(CallAttributes.TO, TO);  </code>
    
    <code> params.put(CallAttributes.ANSWER_URL, ANSWER_URL); </code>

3. Call the API in a thread. 

    <code> Thread callThread = new Thread(callRunnable);  </code>
    
    <code> callThread.start();  </code>
    
4. Implement the Runnable interface.

    <code> Runnable callRunnable = new Runnable() {  </code>
    
    <code>    @Override  </code>
    
    <code>    public void run() {  </code>
    
    <code>      try { </code>
    
    <code>          mHttp.makeCall(params); </code>
    
    <code>      } catch (AndroidClientException e) { </code>
    
    <code>          Log.e("plivosdk", "Error: " + e.getMessage()); </code>
    
    <code>    } </code>
    
    <code>  } </code>
    
    <code> }; </code>
        
5. We are done! :)
