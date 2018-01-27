package xyz.zzp.burpple.events;

import xyz.zzp.burpple.data.vo.LoginUserVO;

/**
 * Created by Lenovo on 1/26/2018.
 */

public class SuccessLoginEvent {

    private LoginUserVO mLoginUser;

    public SuccessLoginEvent(LoginUserVO mLoginUser) {
        this.mLoginUser = mLoginUser;
    }

    public LoginUserVO getmLoginUser() {
        return mLoginUser;
    }
}
