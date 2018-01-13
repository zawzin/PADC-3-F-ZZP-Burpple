package xyz.zzp.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 1/12/2018.
 */

public class PromotionVO {

    @SerializedName("burpple-promotion-id")
    private String id;
    @SerializedName("burpple-promotion-image")
    private String image;
    @SerializedName("burpple-promotion-title")
    private String title;
    @SerializedName("burpple-promotion-until")
    private String until;
    @SerializedName("burpple-promotion-shop")
    private ShopVO shop;
    @SerializedName("is-burpple-exclusive")
    private boolean exclusive;
    @SerializedName("burpple-promotion-terms")
    private String[] terms;

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getUntil() {
        return until;
    }

    public ShopVO getShop() {
        return shop;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public String[] getTerms() {
        return terms;
    }
}
