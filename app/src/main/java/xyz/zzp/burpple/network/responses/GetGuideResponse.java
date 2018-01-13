package xyz.zzp.burpple.network.responses;

import java.util.List;

import xyz.zzp.burpple.data.vo.GuideVO;
import xyz.zzp.burpple.events.LoadedPromotionEvent;

/**
 * Created by Lenovo on 1/13/2018.
 */

public class GetGuideResponse {
    private String code;
    private String message;
    private String apiVersion;
    private int page;
    private List<GuideVO> featured;

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<GuideVO> getFeatured() {
        return featured;
    }

    public String getCode() {

        return code;
    }
}
