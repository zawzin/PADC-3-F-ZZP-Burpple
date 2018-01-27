package xyz.zzp.burpple.data.model;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xyz.zzp.burpple.data.vo.LoginUserVO;
import xyz.zzp.burpple.events.SuccessLoginEvent;
import xyz.zzp.burpple.events.SuccessLogoutEvent;
import xyz.zzp.burpple.network.BurppleDataAgent;
import xyz.zzp.burpple.network.RetrofitDataAgent;

/**
 * Created by Lenovo on 1/26/2018.
 */

public class LoginUserModel {

    private static LoginUserModel sObjectInstance;
    private BurppleDataAgent mDataAgent;
    private LoginUserVO mLoginUser;

    private LoginUserModel(){
        mDataAgent = RetrofitDataAgent.getsObjectInstance();
        EventBus.getDefault().register(this);
    }

    public static LoginUserModel getsObjectInstance() {
        if (sObjectInstance == null){
            sObjectInstance = new LoginUserModel();
        }
        return sObjectInstance;
    }
    public boolean isUserLogin(){
        return mLoginUser != null;
    }

    public void logOut(){
        mLoginUser = null;
        SuccessLogoutEvent event = new SuccessLogoutEvent();
        EventBus.getDefault().post(event);
    }

    public void loginUser(String phoneNo, String password){
        mDataAgent.loginUser(phoneNo,password);
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoginUserSuccess(SuccessLoginEvent event){
        mLoginUser = event.getmLoginUser();
    }
}
