package xyz.zzp.burpple.viewitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.burpple.R;
import xyz.zzp.burpple.data.model.FeatureModel;
import xyz.zzp.burpple.data.model.GuideModel;
import xyz.zzp.burpple.data.vo.FeaturesVO;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class HighlightImagesView extends RelativeLayout {
    @BindView(R.id.iv_feature_img)
    ImageView ivFeatureImage;

    @BindView(R.id.tv_feature_tag)
    TextView tvFeatureTag;

    @BindView(R.id.tv_feature_title)
    TextView tvFeatureTitle;

    @BindView(R.id.tv_feature_desc)
    TextView tvFeatureDesc;

    public HighlightImagesView(@NonNull Context context) {
        super(context);
    }

    public HighlightImagesView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HighlightImagesView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }
    public void setData(FeaturesVO feature){

        tvFeatureTag.setText(feature.getTag());
        tvFeatureTitle.setText(feature.getTitle());
        tvFeatureDesc.setText(feature.getDesc());
        Glide.with(ivFeatureImage.getContext())
                .load(feature.getImage())
                .into(ivFeatureImage);
    }

}
