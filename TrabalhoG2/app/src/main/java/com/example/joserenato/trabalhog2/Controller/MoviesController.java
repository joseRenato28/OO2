package com.example.joserenato.trabalhog2.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.joserenato.trabalhog2.Model.Movies;
import com.example.joserenato.trabalhog2.Model.MoviesModel;

/**
 * Created by JoseRenato on 11/06/2017.
 */

public class MoviesController {
    private MoviesModel moviesModel;

    public MoviesController(Context context){
        moviesModel = new MoviesModel(context);
    }

    public Cursor list(){
        Cursor cursor = moviesModel.list();
        return cursor;
    }

    public void insert(Movies movies) throws Exception{
        final ContentValues values = new ContentValues();

        values.put("movie_title", movies.getTitle());
        values.put("movie_description", movies.getDescription());
        values.put("movie_rate", movies.getRate());

        moviesModel.insert(values);
    }

    public void update(Movies movies) throws Exception{
        final ContentValues values = new ContentValues();

        values.put("movie_title", movies.getTitle());
        values.put("movie_description", movies.getDescription());
        values.put("movie_rate", movies.getRate());

        moviesModel.update(values, movies.getId());
    }

    public void delete(int id) throws Exception{
        moviesModel.delete(""+id);
    }
}
