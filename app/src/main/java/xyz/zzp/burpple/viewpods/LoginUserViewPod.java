package xyz.zzp.burpple.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.zzp.burpple.R;
import xyz.zzp.burpple.data.vo.LoginUserVO;
import xyz.zzp.burpple.delegates.LoginUserDelegate;

/**
 * Created by Lenovo on 1/25/2018.
 */

public class LoginUserViewPod extends RelativeLayout {

    @BindView(R.id.iv_user_img)
    ImageView ivUserImg;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_user_phone_no)
    TextView tvPhoneNo;

    @BindView(R.id.iv_cover_img)
    ImageView ivCoverImg;

    private LoginUserDelegate mDelegate;

    public LoginUserViewPod(Context context) {
        super(context);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }
    public void bindData(LoginUserVO loginUser){
        Glide.with(ivUserImg.getContext())
                .load(loginUser.getProfileUrl())
                .into(ivUserImg);
        Glide.with(ivCoverImg.getContext())
                .load(loginUser.getCoverUrl())
                .into(ivCoverImg);
        tvName.setText(loginUser.getName());
        tvPhoneNo.setText(loginUser.getPhoneNo());
    }
    public void setDelegate(LoginUserDelegate delegate){
        mDelegate = delegate;
    }
    @OnClick(R.id.btn_logout)
    public void onTapToLogout(View view){
        mDelegate.onTaptoLogout();
    }
}
