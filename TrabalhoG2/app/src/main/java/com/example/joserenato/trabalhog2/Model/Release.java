package com.example.joserenato.trabalhog2.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by JoseRenato on 19/06/2017.
 */

public class Release implements Serializable {

    @SerializedName("title")
    private String title;

    @SerializedName("img")
    private String img;

    @SerializedName("rate")
    private String rate;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
