package xyz.zzp.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.zzp.burpple.R;
import xyz.zzp.burpple.viewholders.NewFoodViewHolder;

/**
 * Created by Lenovo on 1/7/2018.
 */

public class NewFoodAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View newFoodView = layoutInflater.inflate(R.layout.item_new_opened,parent,false);
        NewFoodViewHolder newFoodViewHolder = new NewFoodViewHolder(newFoodView);
        return newFoodViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
