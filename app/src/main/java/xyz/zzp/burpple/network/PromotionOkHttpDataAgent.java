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
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.zzp.burpple.BurppleApp;
import xyz.zzp.burpple.events.LoadedPromotionEvent;
import xyz.zzp.burpple.network.responses.GetPromotionResponse;

/**
 * Created by Lenovo on 1/13/2018.
 */

public class PromotionOkHttpDataAgent implements PromotionDataAgent {

    private static PromotionOkHttpDataAgent sObjectInstance;

    private PromotionOkHttpDataAgent(){

    }

    public static PromotionOkHttpDataAgent getsObjectInstance() {
        if(sObjectInstance == null){
            sObjectInstance = new PromotionOkHttpDataAgent();
        }
        return sObjectInstance;
    }

    @Override
    public void loadPromotion() {
        new loadPromotionTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getPromotions.php");
    }
    private static class loadPromotionTask extends AsyncTask<String, Void, String>{

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
            GetPromotionResponse getPromotionResponse = gson.fromJson(response, GetPromotionResponse.class);

            LoadedPromotionEvent loadedPromotionEvent = new LoadedPromotionEvent(getPromotionResponse.getPromotions());
            EventBus.getDefault().post(loadedPromotionEvent);
        }
    }
}
