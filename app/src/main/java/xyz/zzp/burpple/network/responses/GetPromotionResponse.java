package xyz.zzp.burpple.network.responses;

import java.util.List;

import xyz.zzp.burpple.data.vo.PromotionVO;

/**
 * Created by Lenovo on 1/13/2018.
 */

public class GetPromotionResponse {
    private int code;
    private String message;
    private String apiVersion;
    private int page;
    private List<PromotionVO> promotions;

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

    public List<PromotionVO> getPromotions() {
        return promotions;
    }
}
