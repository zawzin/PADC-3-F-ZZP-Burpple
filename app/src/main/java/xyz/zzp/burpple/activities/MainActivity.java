package xyz.zzp.burpple.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.burpple.R;
import xyz.zzp.burpple.adapters.GuideAdapter;
import xyz.zzp.burpple.adapters.HighlightImagesAdapter;
import xyz.zzp.burpple.adapters.NewAndTrendingAdapter;
import xyz.zzp.burpple.adapters.NewFoodAdapter;
import xyz.zzp.burpple.adapters.PromotionAdapter;
import xyz.zzp.burpple.data.model.FeatureModel;
import xyz.zzp.burpple.data.model.GuideModel;
import xyz.zzp.burpple.data.model.PromotionModel;
import xyz.zzp.burpple.events.LoadedFeatureEvent;
import xyz.zzp.burpple.events.LoadedGuideEvent;
import xyz.zzp.burpple.events.LoadedPromotionEvent;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vp_images)
    ViewPager vpImages;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_promotion)
    RecyclerView rvPromotion;

    @BindView(R.id.rv_guide)
    RecyclerView rvGuide;

    @BindView(R.id.rv_new_and_trending)
    RecyclerView rvNewAndTrending;

    private HighlightImagesAdapter mHighlightImagesAdapter;
    private PromotionAdapter mPromotionAdapter;
    private GuideAdapter mGuideAdapter;
    private NewAndTrendingAdapter mNewAndTrendingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this,this);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        mHighlightImagesAdapter = new HighlightImagesAdapter();
        vpImages.setAdapter(mHighlightImagesAdapter);

        mPromotionAdapter = new PromotionAdapter();
        LinearLayoutManager lLmPromotion= new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvPromotion.setLayoutManager(lLmPromotion);
        rvPromotion.setAdapter(mPromotionAdapter);

        mGuideAdapter = new GuideAdapter();
        LinearLayoutManager lLmGuide = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvGuide.setLayoutManager(lLmGuide);
        rvGuide.setAdapter(mGuideAdapter);

//        mNewFoodAdapter = new NewFoodAdapter();
//        LinearLayoutManager lLMShops = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
//        rvshops.setLayoutManager(lLMShops);
//        rvshops.setAdapter(mNewFoodAdapter);

        mNewAndTrendingAdapter = new NewAndTrendingAdapter();
        LinearLayoutManager lLmNewAndTrending = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvNewAndTrending.setLayoutManager(lLmNewAndTrending);
        rvNewAndTrending.setAdapter(mNewAndTrendingAdapter);

        FeatureModel.getsObjectInstance().loadFeature();
        PromotionModel.getsObjectInstance().loadPromotion();
        GuideModel.getsObjectInstance().loadGuide();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loadFeature(LoadedFeatureEvent loadedFeatureEvent){
        mHighlightImagesAdapter.setFeature(loadedFeatureEvent.getFeatureList());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loadPromotion(LoadedPromotionEvent loadedPromotionEvent){
        mPromotionAdapter.setPromotion(loadedPromotionEvent.getPromotionList());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loadGuide(LoadedGuideEvent loadedGuideEvent){
        mGuideAdapter.setGuide(loadedGuideEvent.getGuidelist());
    }
}
