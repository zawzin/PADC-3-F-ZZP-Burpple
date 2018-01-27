package xyz.zzp.burpple.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.burpple.R;
import xyz.zzp.burpple.data.vo.GuideVO;

/**
 * Created by Lenovo on 1/5/2018.
 */

public class GuideViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_guide_img)
    ImageView ivGuideImage;

    @BindView(R.id.tv_guide_title)
    TextView tvGuideTitle;

    public GuideViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void setGuide(GuideVO guide){
        Glide.with(ivGuideImage.getContext())
                .load(guide.getImage())
                .into(ivGuideImage);
        tvGuideTitle.setText(guide.getTitle());
    }
}
