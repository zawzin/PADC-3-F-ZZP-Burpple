package xyz.zzp.burpple.data.model;

import xyz.zzp.burpple.network.FeatureOkHttpDataAgent;

/**
 * Created by Lenovo on 1/12/2018.
 */

public class FeatureModel {

    private static FeatureModel sObjectInstance;
    private FeatureOkHttpDataAgent featureOkHttpDataAgent;
    private FeatureModel() {
        featureOkHttpDataAgent = FeatureOkHttpDataAgent.getsObjectInstance();
    }

    public static FeatureModel getsObjectInstance() {
        if(sObjectInstance == null){
            sObjectInstance = new FeatureModel();
        }
        return sObjectInstance;
    }
    public void loadFeature(){
        featureOkHttpDataAgent.loadFeature();
    }

}
