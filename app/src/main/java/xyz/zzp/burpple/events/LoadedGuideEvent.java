package xyz.zzp.burpple.events;

import java.util.List;

import xyz.zzp.burpple.data.vo.GuideVO;

/**
 * Created by Lenovo on 1/13/2018.
 */

public class LoadedGuideEvent {
    private List<GuideVO> guidelist;

    public LoadedGuideEvent(List<GuideVO> guidelist) {
        this.guidelist = guidelist;
    }

    public List<GuideVO> getGuidelist() {
        return guidelist;
    }
}
