package xyz.zzp.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 1/24/2018.
 */

public class FavFoodVO {
    @SerializedName("favourite_food_id")
    private int favouriteFoodId;
    private String title;
    private String photoUrl;

    public int getFavouriteFoodId() {
        return favouriteFoodId;
    }

    public String getTitle() {
        return title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
