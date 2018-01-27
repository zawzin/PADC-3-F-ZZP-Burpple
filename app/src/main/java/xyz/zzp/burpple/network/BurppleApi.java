package xyz.zzp.burpple.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.zzp.burpple.network.responses.LoginResponse;

/**
 * Created by Lenovo on 1/26/2018.
 */

public interface BurppleApi {

    @FormUrlEncoded
    @POST("v1/login.php")
    Call<LoginResponse> loginUser(@Field("phoneNo")String phoneNo,
                                  @Field("password")String password);

}
