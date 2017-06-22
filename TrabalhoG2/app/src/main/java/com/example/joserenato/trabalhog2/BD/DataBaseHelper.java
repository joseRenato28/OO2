package com.example.joserenato.trabalhog2.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JoseRenato on 11/06/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "trabalhoG2";
    private static final String DB_TABLE = "CREATE TABLE MOVIES" +
            "(_id integer primary key autoincrement," +
            "movie_title TEXT," +
            "movie_description TEXT," +
            "movie_rate TEXT);";
    private static final int DB_VERSION = 1;

    public DataBaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE MOVIES");
        onCreate(db);
    }
}
