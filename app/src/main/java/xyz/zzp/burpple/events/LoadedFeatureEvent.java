package xyz.zzp.burpple.events;

import java.util.List;

import xyz.zzp.burpple.data.vo.FeaturesVO;

/**
 * Created by Lenovo on 1/13/2018.
 */

public class LoadedFeatureEvent {
    private List<FeaturesVO> featureList;

    public LoadedFeatureEvent(List<FeaturesVO> featureList) {
        this.featureList = featureList;
    }

    public List<FeaturesVO> getFeatureList() {
        return featureList;
    }
}
