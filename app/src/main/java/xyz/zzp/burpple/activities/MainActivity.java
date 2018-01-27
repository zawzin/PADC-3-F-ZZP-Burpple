package xyz.zzp.burpple.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
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
import xyz.zzp.burpple.data.model.LoginUserModel;
import xyz.zzp.burpple.data.model.PromotionModel;
import xyz.zzp.burpple.delegates.BeforeLoginUserDelegate;
import xyz.zzp.burpple.delegates.LoginUserDelegate;
import xyz.zzp.burpple.events.LoadedFeatureEvent;
import xyz.zzp.burpple.events.LoadedGuideEvent;
import xyz.zzp.burpple.events.LoadedPromotionEvent;
import xyz.zzp.burpple.viewpods.AccountControlViewPod;

public class MainActivity extends AppCompatActivity implements LoginUserDelegate,BeforeLoginUserDelegate{

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

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private AccountControlViewPod vpAccountControl;

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

        vpAccountControl = (AccountControlViewPod) navigationView.getHeaderView(0);
        vpAccountControl.setDelegate((BeforeLoginUserDelegate)this);
        vpAccountControl.setDelegate((LoginUserDelegate)this);

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

    @Override
    public void onTaptoLogout() {
        LoginUserModel.getsObjectInstance().logOut();
    }

    @Override
    public void onTapToLogin() {
        Intent intent = AccountControlActivity.newInterntLogin(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapToRegister() {
        Intent intent = AccountControlActivity.newInterntRegister(getApplicationContext());
        startActivity(intent);
    }
}
