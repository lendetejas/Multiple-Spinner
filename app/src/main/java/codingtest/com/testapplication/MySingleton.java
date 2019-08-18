package codingtest.com.testapplication;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

class MySingleton {
    private static Context ctx;
    private static MySingleton mInstance;
    private RequestQueue requestQueue;

    private MySingleton(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized MySingleton getInstance(Context context) {

        if (mInstance == null){
            mInstance = new MySingleton(context);
        }

        return mInstance;
    }

    public RequestQueue getRequestQueue() {

        if (requestQueue == null){

            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T>void addToRequest(Request request){

        requestQueue.add(request);
    }

}




