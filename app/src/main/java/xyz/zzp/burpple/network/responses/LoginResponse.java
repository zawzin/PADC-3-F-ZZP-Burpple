package xyz.zzp.burpple.network.responses;

import com.google.gson.annotations.SerializedName;

import xyz.zzp.burpple.data.vo.LoginUserVO;

/**
 * Created by Lenovo on 1/26/2018.
 */

public class LoginResponse {

    private int code;
    private String message;
    @SerializedName("login_user")
    private LoginUserVO loginUser;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LoginUserVO getLoginUser() {
        return loginUser;
    }
}
