package xyz.zzp.burpple.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.burpple.R;
import xyz.zzp.burpple.data.vo.FeaturesVO;
import xyz.zzp.burpple.viewitems.HighlightImagesView;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class HighlightImagesAdapter extends PagerAdapter {

    private List<FeaturesVO> mFeatureList;

    public HighlightImagesAdapter()
    {
        mFeatureList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mFeatureList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object)  {

        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        HighlightImagesView view = (HighlightImagesView) layoutInflater.inflate(R.layout.items_view_images, container, false);

        view.setData(mFeatureList.get(position));
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
    public void setFeature(List<FeaturesVO> featureList){
        mFeatureList = featureList;
        notifyDataSetChanged();
    }
}
