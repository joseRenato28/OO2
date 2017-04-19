package com.example.joserenato.trabalhog1;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CreateMovie extends AppCompatActivity {

    public EditText movie_name;
    public EditText movie_description;
    public EditText movie_rate;

    public Movies movie;
    public static int id = 1;


    ListMovies movies = new ListMovies();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);

        movie_name = (EditText)findViewById(R.id.movie_name);
        movie_description = (EditText)findViewById(R.id.movie_description);
        movie_rate = (EditText)findViewById(R.id.movie_rate);
    }

    public void save(View v) {
        movie = new Movies();

        movie.setId(this.id++);
        movie.setTitle(movie_name.getText().toString());
        movie.setDescription(movie_description.getText().toString());
        movie.setRate(movie_rate.getText().toString());
        movies.listMovies.add(movie);

        Toast.makeText(this, "Filme salvo com sucesso", Toast.LENGTH_SHORT).show();

        Intent intent;
        intent = new Intent(this, ListMovies.class);

        startActivity(intent);
    }
}
