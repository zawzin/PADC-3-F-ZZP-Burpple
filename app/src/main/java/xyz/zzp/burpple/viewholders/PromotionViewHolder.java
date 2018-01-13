package xyz.zzp.burpple.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.burpple.R;
import xyz.zzp.burpple.data.vo.PromotionVO;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class PromotionViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_promotion_title)
    TextView tvPromotionTitle;

    @BindView(R.id.tv_promotion_until)
    TextView tvPromotionUntil;

    @BindView(R.id.iv_promotion_image)
    ImageView ivPromotionImage;

    @BindView(R.id.tv_shop_name)
    TextView tvShopName;

    @BindView(R.id.tv_shop_area)
    TextView tvShopArea;

    @BindView(R.id.lbl_burpple_exclusive)
    TextView tvExclusive;
    public PromotionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void setPromotion(PromotionVO promotion){

        if(promotion.isExclusive()){
            tvExclusive.setVisibility(View.VISIBLE);
        }
        else tvExclusive.setVisibility(View.INVISIBLE);

        Glide.with(ivPromotionImage.getContext())
                .load(promotion.getImage())
                .into(ivPromotionImage);

        tvPromotionTitle.setText(promotion.getTitle());
        tvPromotionUntil.setText(promotion.getUntil());
        tvShopName.setText(promotion.getShop().getName());
        tvShopArea.setText(promotion.getShop().getArea());
    }
}
