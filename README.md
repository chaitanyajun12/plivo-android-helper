plivo-android-helper
====================

Plivo provides simple and easy-to-use Application Programming Interfaces (APIs) to make and receive calls, send SMSes, make a conference call, and more.

plivo-android-helper Android SDK is just a wrapper on top of Plivo. At present this SDK supports making a call.

Example
=======

The example for making a call 

1. Just create an instance of `HttpFactory` class


    HttpFactory mHttp = new HttpFactory(AUTH_ID, AUTH_TOKEN);
    
2. Create a map of the parameters to be posted.


    `LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
    params.put(CallAttributes.FROM, FROM);
    params.put(CallAttributes.TO, TO);
    params.put(CallAttributes.ANSWER_URL, ANSWER_URL);`

3. Call the API in a thread. 


    Thread callThread = new Thread(callRunnable);
    callThread.start();
    
4. Implement the Runnable interface.


    Runnable callRunnable = new Runnable() {
        @Override
        public void run() {
            try {
              mHttp.makeCall(params);
            } catch (AndroidClientException e) {
              Log.e("plivosdk", "Error: " + e.getMessage());
            }
        }
    };
    
5. We are done! :)
