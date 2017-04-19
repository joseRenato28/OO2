package com.example.joserenato.trabalhog1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MoviesDetails extends AppCompatActivity {

    EditText title;
    EditText description;
    EditText rate;

    public static int get_id;
    public Movies movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_details);

        title = (EditText)findViewById(R.id.movie_name);
        description = (EditText)findViewById(R.id.movie_description);
        rate = (EditText)findViewById(R.id.movie_rate);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                movie = new Movies();
                get_id = bundle.getInt("id");
                movie.setTitle(bundle.getString("title"));
                movie.setDescription(bundle.getString("description"));
                movie.setRate(bundle.getString("rate"));

                title.setText(movie.getTitle());
                description.setText(movie.getDescription());
                rate.setText(movie.getRate());
                System.out.println(get_id);
            }
        }
    }

    public void edit(View v){
        movie = new Movies();

        movie.setTitle(title.getText().toString());
        movie.setDescription(description.getText().toString());
        movie.setRate(rate.getText().toString());

        ListMovies list = new ListMovies();
        for(int i = 0; i < list.listMovies.size(); i++) {
            if (list.listMovies.get(i).getId() == get_id) {
                list.listMovies.set(i, movie);
            }
        }

        Toast.makeText(this, "Filme alterado com sucesso", Toast.LENGTH_SHORT).show();
    }

    public void delete(View v){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Exlcuir filme");

        alertDialog.setMessage("Tem certeza que deseja exlcuir o filme?");

        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ListMovies list = new ListMovies();
                for(int i = 0; i < list.listMovies.size(); i++){
                    if(list.listMovies.get(i).getId() == get_id){
                        list.listMovies.remove(i);
                        Toast.makeText(MoviesDetails.this, "Filme excluido com sucesso", Toast.LENGTH_SHORT).show();

                        Intent intent;
                        intent = new Intent(MoviesDetails.this, ListMovies.class);

                        startActivity(intent);
                        break;
                    }
                }

            }

        });
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }
}
