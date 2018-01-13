package xyz.zzp.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.zzp.burpple.R;
import xyz.zzp.burpple.viewholders.NewAndTrendingViewHolder;

/**
 * Created by Lenovo on 1/5/2018.
 */

public class NewAndTrendingAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_new_and_trending, parent, false);
        NewAndTrendingViewHolder newAndTrendingViewHolder = new NewAndTrendingViewHolder(view);
        return newAndTrendingViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
