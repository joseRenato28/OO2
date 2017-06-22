package com.example.joserenato.trabalhog2.View;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.joserenato.trabalhog2.Adapter.ReleaseAdapter;
import com.example.joserenato.trabalhog2.Model.Release;
import com.example.joserenato.trabalhog2.Services.NewsServices;
import com.example.joserenato.trabalhog2.Useful.JsonCorrect;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class News extends ListActivity {
    public static final String api_url = "http://172.29.2.13:80/api-oo2/";

    private ReleaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_news);

        Gson g = new GsonBuilder().registerTypeAdapter(Release.class, new JsonCorrect()).create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api_url)
                .addConverterFactory(GsonConverterFactory.create(g))
                .build();

        NewsServices service  = retrofit.create(NewsServices.class);

        Call<List<Release>> news = service.getNews();

        news.enqueue(new Callback<List<Release>>() {
            @Override
            public void onResponse(Call<List<Release>> call, Response<List<Release>> response) {
                if(response.isSuccessful()){
                    List<Release> news_response = response.body();

                    adapter = new ReleaseAdapter(News.this, news_response);
                    setListAdapter(adapter);
                }else{
                    Toast.makeText(getApplicationContext(), "Nao conectou "+response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Release>> call, Throwable t){
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), "Erro "+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
