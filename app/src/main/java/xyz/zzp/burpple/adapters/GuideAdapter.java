package xyz.zzp.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.zzp.burpple.R;
import xyz.zzp.burpple.data.vo.GuideVO;
import xyz.zzp.burpple.viewholders.GuideViewHolder;

/**
 * Created by Lenovo on 1/5/2018.
 */

public class GuideAdapter extends RecyclerView.Adapter<GuideViewHolder> {

    private List<GuideVO> mGuideList;

    public GuideAdapter(){
        mGuideList = new ArrayList<>();
    }

    @Override
    public GuideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_guide,parent,false);
        GuideViewHolder guideViewHolder = new GuideViewHolder(view);
        return guideViewHolder;
    }

    @Override
    public void onBindViewHolder(GuideViewHolder holder, int position) {
        holder.setGuide(mGuideList.get(position));
    }

    @Override
    public int getItemCount() {
        return mGuideList.size();
    }

    public void setGuide(List<GuideVO> guideList){
        mGuideList = guideList;
        notifyDataSetChanged();
    }
}
