package xyz.zzp.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 1/13/2018.
 */

public class GuideVO {

    @SerializedName("burpple-guide-id")
    private String id;
    @SerializedName("burpple-guide-image")
    private String image;
    @SerializedName("burpple-guide-title")
    private String title;
    @SerializedName("burpple-guide-desc")
    private String desc;

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
