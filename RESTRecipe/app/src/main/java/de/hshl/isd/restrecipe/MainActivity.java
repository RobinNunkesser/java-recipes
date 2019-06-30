package de.hshl.isd.restrecipe;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.HttpUrl;

public class MainActivity extends Activity {

    public static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("httpbin.org")
                .addEncodedPathSegments("/get")
                .build();

        new HttpGetTask(new AsyncHookedTask.OnTaskCompleted<String>() {
            @Override
            public void onTaskCompleted(String s) {
                Log.i(LOG_TAG, s);
                try {
                    JSONObject json = new JSONObject(s);
                    Log.i(LOG_TAG, json.getString("origin"));
                } catch (JSONException e) {
                    // Intentionally ignored
                }
            }

            @Override
            public void onError(Exception e) {
                Log.i(LOG_TAG, e.getLocalizedMessage());
            }
        }).execute(url);
    }
}
