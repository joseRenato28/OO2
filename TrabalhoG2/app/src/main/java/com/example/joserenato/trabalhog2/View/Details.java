package com.example.joserenato.trabalhog2.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.joserenato.trabalhog2.Controller.MoviesController;
import com.example.joserenato.trabalhog2.Model.Movies;
import com.example.joserenato.trabalhog2.R;

public class Details extends AppCompatActivity {

    private EditText d_movie_title;
    private Spinner d_movie_rate;
    private EditText d_movie_description;
    private int id;

    private MoviesController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.controller = new MoviesController(this);

        this.d_movie_title = (EditText) findViewById(R.id.d_movie_title);
        this.d_movie_description = (EditText) findViewById(R.id.d_movie_description);

        this.d_movie_rate = (Spinner)findViewById(R.id.d_movie_rate);
        String[] items = new String[]{"Ruim", "Bom", "Ótimo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        this.d_movie_rate.setAdapter(adapter);

        if(getIntent().hasExtra("id_movie")){
            this.id = Integer.parseInt(getIntent().getStringExtra("id_movie"));
            this.d_movie_title.setText(getIntent().getStringExtra("movie_title")
            );

            this.d_movie_description.setText(getIntent().getStringExtra("movie_description")
            );
            try{
                ArrayAdapter myAdap = (ArrayAdapter)this.d_movie_rate.getAdapter();

                int spinnerPosition = myAdap.getPosition(getIntent().getStringExtra("movie_rate"));

                this.d_movie_rate.setSelection(spinnerPosition);
            }catch (Exception e){
                Toast.makeText(Details.this, "Não foi possivel setar o valor da nota\n"+e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static Intent getActivtyIntent(Context context, String id_movie, String movie_title, String movie_rate, String movie_description){
        return new Intent(context,
                Details.class)
                .putExtra("id_movie",id_movie)
                .putExtra("movie_title", movie_title)
                .putExtra("movie_rate", movie_rate)
                .putExtra("movie_description", movie_description);
    }

    public void delete(View v){
        try{
            this.controller.delete(this.id);
            Toast.makeText(Details.this, "Filme deletado com sucesso", Toast.LENGTH_SHORT).show();
            this.redirect(v);
        }catch (Exception e){
            Toast.makeText(Details.this, "Ocorreu algum erro para deletar o filme \n" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void update(View v){
        try{
            Movies movies = new Movies();

            movies.setId(this.id);
            movies.setTitle(this.d_movie_title.getText().toString());
            movies.setRate(this.d_movie_rate.getSelectedItem().toString());
            movies.setDescription(this.d_movie_description.getText().toString());

            this.controller.update(movies);

            Toast.makeText(Details.this, "Filme alterado com sucesso", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(Details.this, "Ocorreu algum erro para alterar o filme \n" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void redirect(View v){
        Intent intent;
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
