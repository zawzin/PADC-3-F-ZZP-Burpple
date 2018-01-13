package xyz.zzp.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 1/12/2018.
 */

public class ShopVO {

    @SerializedName("burpple-shop-id")
    private String id;
    @SerializedName("burpple-shop-name")
    private String name;
    @SerializedName("burpple-shop-area")
    private String area;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }
}
