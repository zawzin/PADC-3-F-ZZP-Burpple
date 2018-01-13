package xyz.zzp.burpple.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.burpple.R;
import xyz.zzp.burpple.adapters.NewFoodAdapter;

/**
 * Created by Lenovo on 1/5/2018.
 */

public class NewAndTrendingViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.rv_new_opened)
    RecyclerView rvshops;
    private NewFoodAdapter mNewFoodAdapter;

    public NewAndTrendingViewHolder(View itemView) {

        super(itemView);

        ButterKnife.bind(this,itemView);
        mNewFoodAdapter = new NewFoodAdapter();
        LinearLayoutManager lLMShops = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false);
        rvshops.setLayoutManager(lLMShops);
        rvshops.setAdapter(mNewFoodAdapter);
    }
}
