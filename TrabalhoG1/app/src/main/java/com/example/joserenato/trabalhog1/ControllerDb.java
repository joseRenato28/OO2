package com.example.joserenato.trabalhog1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by JoseRenato on 12/04/2017.
 */

public class ControllerDb {

    private SQLiteDatabase db;
    private CreateDb base;

    public ControllerDb(Context context){
        base = new CreateDb(context);
    }

    public String Create(String title, String description, String rate){
        ContentValues values;
        long result;

        db = base.getWritableDatabase();
        values = new ContentValues();

        values.put(CreateDb.title_movie, title);
        values.put(CreateDb.description_movie, description);
        values.put(CreateDb.rate_movie, rate);

        result = db.insert(CreateDb.table, null, values);
        db.close();

        if(result == -1){
            return "Ocorreu algum erro para inserir o filme";
        }else{
            return "Filme cadastrado com sucesso";
        }
    }

    public Cursor Get(){
        Cursor cursor;
        String[] fields = {base.title_movie, base.description_movie, base.rate_movie};

        db = base.getReadableDatabase();

        cursor = db.query(base.table, fields, null, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        db.close();

        return cursor;
    }
}
