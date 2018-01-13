package xyz.zzp.burpple.network.responses;

import java.util.List;

import xyz.zzp.burpple.data.model.FeatureModel;
import xyz.zzp.burpple.data.vo.FeaturesVO;

/**
 * Created by Lenovo on 1/13/2018.
 */

public class GetFeatureResponse {
    private int code;
    private String message;
    private String apiVersion;
    private int page;
    private List<FeaturesVO> featured;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<FeaturesVO> getFeatured() {
        return featured;
    }
}
