package xyz.zzp.burpple.viewpods;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.burpple.R;
import xyz.zzp.burpple.data.model.LoginUserModel;
import xyz.zzp.burpple.delegates.BeforeLoginUserDelegate;
import xyz.zzp.burpple.delegates.LoginUserDelegate;
import xyz.zzp.burpple.events.SuccessLoginEvent;
import xyz.zzp.burpple.events.SuccessLogoutEvent;

/**
 * Created by Lenovo on 1/25/2018.
 */

public class AccountControlViewPod extends FrameLayout {

    @BindView(R.id.vp_before_login)
    BeforeLoginUserViewPod vpBeforeLogin;

    @BindView(R.id.vp_login_user)
    LoginUserViewPod vpLogin;

    public AccountControlViewPod(@NonNull Context context) {
        super(context);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);

        refreshUserSession();
        EventBus.getDefault().register(this);
    }
    public void setDelegate(BeforeLoginUserDelegate delegate){
        vpBeforeLogin.setDelegate(delegate);
    }
    public void setDelegate(LoginUserDelegate delegate){
        vpLogin.setDelegate(delegate);
    }
    private void refreshUserSession(){

        if(LoginUserModel.getsObjectInstance().isUserLogin()){
            vpBeforeLogin.setVisibility(View.GONE);
            vpLogin.setVisibility(View.VISIBLE);
        }
        else {
            vpBeforeLogin.setVisibility(View.VISIBLE);
            vpLogin.setVisibility(View.GONE);
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLoginEvent event){
        vpBeforeLogin.setVisibility(View.GONE);
        vpLogin.setVisibility(View.VISIBLE);

        vpLogin.bindData(event.getmLoginUser());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLogoutUserSuccess(SuccessLogoutEvent event){
        vpBeforeLogin.setVisibility(View.VISIBLE);
        vpLogin.setVisibility(View.GONE);
    }
}
