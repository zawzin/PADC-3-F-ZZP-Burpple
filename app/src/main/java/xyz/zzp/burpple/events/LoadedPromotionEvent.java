package xyz.zzp.burpple.events;

import java.util.List;

import xyz.zzp.burpple.data.vo.PromotionVO;

/**
 * Created by Lenovo on 1/13/2018.
 */

public class LoadedPromotionEvent {
    private List<PromotionVO> promotionList;

    public LoadedPromotionEvent(List<PromotionVO> promotionList) {
        this.promotionList = promotionList;
    }

    public List<PromotionVO> getPromotionList() {
        return promotionList;
    }
}
