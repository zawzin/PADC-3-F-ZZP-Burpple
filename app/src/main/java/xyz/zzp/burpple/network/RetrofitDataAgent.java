package xyz.zzp.burpple.network;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.zzp.burpple.events.SuccessLoginEvent;
import xyz.zzp.burpple.network.responses.LoginResponse;

/**
 * Created by Lenovo on 1/26/2018.
 */

public class RetrofitDataAgent implements BurppleDataAgent {

    private static RetrofitDataAgent sObjectInstance;
    private BurppleApi mBurppleApi;

    private RetrofitDataAgent(){
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mBurppleApi = retrofit.create(BurppleApi.class);

    }

    public static RetrofitDataAgent getsObjectInstance() {
        if(sObjectInstance == null){
            sObjectInstance = new RetrofitDataAgent();
        }
        return sObjectInstance;
    }

    @Override
    public void loginUser(String phoneNo, String password) {

        Call<LoginResponse> getUserLoginResponseCall = mBurppleApi.loginUser(phoneNo,password);
        getUserLoginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse =response.body();

                if (loginResponse != null){
                    SuccessLoginEvent event = new SuccessLoginEvent(loginResponse.getLoginUser());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }
}
