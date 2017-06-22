package com.example.joserenato.trabalhog2.Services;

import com.example.joserenato.trabalhog2.Model.Release;
import com.example.joserenato.trabalhog2.View.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by JoseRenato on 19/06/2017.
 */

public interface NewsServices {
    @GET("news.php")
    Call<List<Release>> getNews();
}
