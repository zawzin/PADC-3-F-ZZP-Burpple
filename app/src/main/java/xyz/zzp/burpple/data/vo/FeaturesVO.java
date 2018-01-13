package xyz.zzp.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 1/12/2018.
 */

public class FeaturesVO {

    @SerializedName("burpple-featured-id")
    private String id;
    @SerializedName("burpple-featured-image")
    private String image;
    @SerializedName("burpple-featured-title")
    private String title;
    @SerializedName("burpple-featured-desc")
    private String desc;
    @SerializedName("burpple-featured-tag")
    private String tag;

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

    public String getTag() {
        return tag;
    }
}
