package de.hshl.isd.restrecipe;


import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nunkesser on 22.08.17.
 */
class HttpGetTask
        extends AsyncHookedTask<HttpUrl, Object, String> {
    public HttpGetTask(
            OnTaskCompleted<String> onComplete) {
        super(onComplete);
    }

    protected String doInBackground(HttpUrl... urls) {
        try {
            OkHttpClient client = new OkHttpClient();
            HttpUrl url = urls[0];
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            onComplete.onError(e);
        }
        return "";
    }

}
