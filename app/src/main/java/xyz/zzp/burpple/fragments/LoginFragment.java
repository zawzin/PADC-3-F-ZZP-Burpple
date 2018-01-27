package xyz.zzp.burpple.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.zzp.burpple.R;
import xyz.zzp.burpple.data.model.LoginUserModel;
import xyz.zzp.burpple.events.SuccessLoginEvent;

/**
 * Created by Lenovo on 1/26/2018.
 */

public class LoginFragment extends Fragment {

    @BindView(R.id.et_email_or_phone)
    EditText etPhoneNo;

    @BindView(R.id.et_login_password)
    EditText etPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.btn_login)
    public void onTapToLogin(View view){
        String phoneNo = etPhoneNo.getText().toString();
        String password = etPassword.getText().toString();
        LoginUserModel.getsObjectInstance().loginUser(phoneNo,password);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLoginEvent event){
        if(getActivity() != null){
            getActivity().onBackPressed();
        }
    }
}
