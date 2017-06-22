package com.example.joserenato.trabalhog2.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.joserenato.trabalhog2.Controller.MoviesController;
import com.example.joserenato.trabalhog2.Model.Movies;
import com.example.joserenato.trabalhog2.R;

public class Add extends AppCompatActivity {

    private EditText movie_title;
    private EditText movie_description;
    private Spinner movie_rate;

    private MoviesController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        this.movie_title = (EditText)findViewById(R.id.movie_title);
        this.movie_description = (EditText)findViewById(R.id.movie_description);

        this.movie_rate = (Spinner)findViewById(R.id.movie_rate);
        String[] items = new String[]{"Ruim", "Bom", "Ótimo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        movie_rate.setAdapter(adapter);

        this.controller = new MoviesController(this);
    }

    public void newMovie(View v){
        try{
            Movies movies = new Movies();

            movies.setTitle(movie_title.getText().toString());
            movies.setDescription(movie_description.getText().toString());
            movies.setRate(movie_rate.getSelectedItem().toString());

            this.controller.insert(movies);

            Toast.makeText(Add.this, "Filme salvo com sucesso \n", Toast.LENGTH_SHORT).show();

            this.redirect(v);

        }catch (Exception e){
            Toast.makeText(Add.this, "Ocorreu algum erro para salvar o filme \n" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void redirect(View v){
        Intent intent;
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
