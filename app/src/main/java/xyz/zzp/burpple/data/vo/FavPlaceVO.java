package xyz.zzp.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 1/25/2018.
 */

public class FavPlaceVO {

    @SerializedName("favourite_food_place_id")
    private int favourtieFoodPlaceId;
    private String title;
    private String address;
    private String photoUrl;

    public int getFavourtieFoodPlaceId() {
        return favourtieFoodPlaceId;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
