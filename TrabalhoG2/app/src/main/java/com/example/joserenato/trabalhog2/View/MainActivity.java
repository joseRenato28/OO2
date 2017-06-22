package com.example.joserenato.trabalhog2.View;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.joserenato.trabalhog2.Controller.MoviesController;
import com.example.joserenato.trabalhog2.Model.Movies;
import com.example.joserenato.trabalhog2.R;

public class MainActivity extends AppCompatActivity {

    private ListView lvMovie;
    private Button newMovie;

    private MoviesController controller;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.controller = new MoviesController(this);

        this.lvMovie = (ListView)findViewById(R.id.lvMovie);
        this.newMovie = (Button)findViewById(R.id.newMovie);

        try{
            this.getMovies();
        }catch (Exception e){
            Toast.makeText(MainActivity.this, "Ocorreu algum erro para carregar os filmes" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public void getMovies(){
        String[] fields = {"movie_title", "movie_rate", "_id", "movie_description"};
        int[] idView = new int[]{R.id.text_movie_title, R.id.text_movie_rate};
        final Cursor cursor = controller.list();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this, R.layout.list_movies, cursor, fields, idView, 0);

        this.lvMovie.setAdapter(adapter);

        this.lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.moveToPosition(position);
                try {
                    String id_movie = cursor.getString(cursor.getColumnIndex("_id"));
                    String movie_title = cursor.getString(cursor.getColumnIndex("movie_title"));
                    String movie_rate = cursor.getString(cursor.getColumnIndex("movie_rate"));
                    String movie_description = cursor.getString(cursor.getColumnIndex("movie_description"));

                    startActivity(Details.getActivtyIntent(MainActivity.this, id_movie, movie_title, movie_rate, movie_description));
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Não foi possivel recuperar os dados deste filme\n" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void newMovieView(View v){
        Intent intent;
        intent = new Intent(this, Add.class);
        startActivity(intent);
        finish();
    }

    public void news(View v){
        Intent intent;
        intent = new Intent(this, News.class);
        startActivity(intent);
    }

}
