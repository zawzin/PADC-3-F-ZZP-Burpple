package xyz.zzp.burpple.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.zzp.burpple.R;
import xyz.zzp.burpple.delegates.BeforeLoginUserDelegate;

/**
 * Created by Lenovo on 1/25/2018.
 */

public class BeforeLoginUserViewPod extends RelativeLayout {

    private BeforeLoginUserDelegate mDelegate;

    public BeforeLoginUserViewPod(Context context) {
        super(context);
    }

    public BeforeLoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeLoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }
    public void setDelegate(BeforeLoginUserDelegate delegate){
        mDelegate = delegate;
    }
    @OnClick(R.id.btn_to_login)
    public void onTapToLogin(View view){
        mDelegate.onTapToLogin();
    }
    @OnClick(R.id.btn_to_regsister)
    public void onTapToRegister(View view){
        mDelegate.onTapToRegister();
    }
}
