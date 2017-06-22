package com.example.joserenato.trabalhog2.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.joserenato.trabalhog2.BD.DataBaseHelper;

/**
 * Created by JoseRenato on 11/06/2017.
 */

public class MoviesModel {

    private SQLiteDatabase sqLiteDatabase;

    public MoviesModel(Context context){
        sqLiteDatabase = new DataBaseHelper(context).getWritableDatabase();
    }

    public void insert (ContentValues values) throws Exception{
        sqLiteDatabase.insert("MOVIES", null, values);
    }

    public Cursor list(){
        String[] columns = new String[] {"_id", "movie_title", "movie_rate", "movie_description"};
        Cursor cursor = sqLiteDatabase.query("MOVIES", columns, null, null, null, null, null);
        return cursor;
    }

    public void update(ContentValues values, int id)throws Exception{
        String where = "_id=?";
        String[] arguments = new String[]{""+id};

        sqLiteDatabase.update("MOVIES", values, where, arguments);
    }
    public void delete(String argument) throws Exception{
        String where = "_id=?";
        String[] arguments = new String[]{argument};
        sqLiteDatabase.delete("MOVIES", where, arguments);
    }
}
