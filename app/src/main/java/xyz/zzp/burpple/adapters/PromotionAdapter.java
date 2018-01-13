package xyz.zzp.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.zzp.burpple.R;
import xyz.zzp.burpple.data.vo.PromotionVO;
import xyz.zzp.burpple.network.PromotionDataAgent;
import xyz.zzp.burpple.viewholders.PromotionViewHolder;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class PromotionAdapter extends RecyclerView.Adapter<PromotionViewHolder>{

    private List<PromotionVO> mPromotionList;

    public PromotionAdapter(){
        mPromotionList = new ArrayList<>();
    }
    @Override
    public PromotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_promotion,parent,false);
        PromotionViewHolder promotionViewHolder = new PromotionViewHolder(view);
        return promotionViewHolder;
    }

    @Override
    public void onBindViewHolder(PromotionViewHolder holder, int position) {
        holder.setPromotion(mPromotionList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPromotionList.size();
    }

    public void setPromotion(List<PromotionVO> promotionList){
        mPromotionList = promotionList;
        notifyDataSetChanged();
    }
}
