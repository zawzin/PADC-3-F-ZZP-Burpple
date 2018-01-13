package xyz.zzp.burpple.data.model;

import xyz.zzp.burpple.network.PromotionOkHttpDataAgent;

/**
 * Created by Lenovo on 1/12/2018.
 */

public class PromotionModel {

    private static PromotionModel sObjectInstance;
    private PromotionOkHttpDataAgent mPromotionOkHttpDataAgent;

    private PromotionModel() {
        mPromotionOkHttpDataAgent = PromotionOkHttpDataAgent.getsObjectInstance();
    }

    public static PromotionModel getsObjectInstance() {
        if(sObjectInstance == null){
            sObjectInstance = new PromotionModel();
        }
        return sObjectInstance;
    }
    public void loadPromotion(){
            mPromotionOkHttpDataAgent.loadPromotion();
    }
}
