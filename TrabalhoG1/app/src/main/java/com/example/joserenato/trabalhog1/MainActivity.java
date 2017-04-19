package com.example.joserenato.trabalhog1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void new_movie_activity(View v){
        Intent intent;
        intent = new Intent(this, CreateMovie.class);

        startActivity(intent);
    }

    public void list_movie(View v){
        Intent intent = new Intent(this, ListMovies.class);
        startActivity(intent);
    }
}
