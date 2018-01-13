package xyz.zzp.burpple.data.model;

import xyz.zzp.burpple.network.GuideOkHttpDataAgent;

/**
 * Created by Lenovo on 1/13/2018.
 */

public class GuideModel {
    private static GuideModel sObjectInstance;
    private GuideOkHttpDataAgent mGuideOkHttpDataAgent;

    private GuideModel(){
    mGuideOkHttpDataAgent = GuideOkHttpDataAgent.getsObjectInstance();
    }

    public static GuideModel getsObjectInstance() {
        if(sObjectInstance == null){
            sObjectInstance = new GuideModel();
        }
        return sObjectInstance;
    }
    public void loadGuide(){
        mGuideOkHttpDataAgent.loadGuide();
    }
}
