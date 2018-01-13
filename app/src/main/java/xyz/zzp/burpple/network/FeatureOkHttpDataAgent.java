package xyz.zzp.burpple.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import xyz.zzp.burpple.BurppleApp;
import xyz.zzp.burpple.events.LoadedFeatureEvent;
import xyz.zzp.burpple.network.responses.GetFeatureResponse;

/**
 * Created by Lenovo on 1/13/2018.
 */

public class FeatureOkHttpDataAgent implements FeatureDataAgent {
    private static FeatureOkHttpDataAgent sObjectInstance;

    private FeatureOkHttpDataAgent() {

    }

    public static FeatureOkHttpDataAgent getsObjectInstance() {
        if (sObjectInstance == null) {
            sObjectInstance = new FeatureOkHttpDataAgent();
        }
        return sObjectInstance;
    }

    @Override
    public void loadFeature() {
        new LoadFeatureTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getFeatured.php");
    }

    private static class LoadFeatureTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String url = urls[0];

            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(15, TimeUnit.SECONDS)
                    .build();

            RequestBody formBody = new FormBody.Builder()
                    .add("access_token", "b002c7e1a528b7cb460933fc2875e916")
                    .add("page", "1")
                    .build();

            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            String responseString = null;
            try {
                Response response = httpClient.newCall(request).execute();
                if (response.isSuccessful() && response.body() != null) {
                    responseString = response.body().string();
                }
            } catch (IOException e) {
                Log.e(BurppleApp.LOG_TAG, e.getMessage());
            }
            return responseString;
        }

        @Override
        protected void onPostExecute(String response) {

            super.onPostExecute(response);
            Gson gson = new Gson();
            GetFeatureResponse getFeatureResponse = gson.fromJson(response, GetFeatureResponse.class);

            LoadedFeatureEvent event = new LoadedFeatureEvent(getFeatureResponse.getFeatured());
            EventBus eventBus = EventBus.getDefault();
            eventBus.post(event);
        }
    }
}