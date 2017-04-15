package com.example.joserenato.trabalhog1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JoseRenato on 12/04/2017.
 */

public class CreateDb extends SQLiteOpenHelper {

    private static final String DB_NAME = "movies.db";
    public static final String table = "movies";
    public static final String id_movie = "id_movie";
    public static final String title_movie = "title_movie";
    public static final String description_movie = "description_movie";
    public static final String rate_movie = "rate_movie";
    private static final int VERSAO = 1;

    public CreateDb(Context context){
        super(context, DB_NAME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE"+table+"("
                +id_movie+ "integer primary key autoincrement,"
                +title_movie+ "text,"
                +description_movie+ "text,"
                +rate_movie+ "text"
                +");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ table);
        onCreate(db);
    }
}
