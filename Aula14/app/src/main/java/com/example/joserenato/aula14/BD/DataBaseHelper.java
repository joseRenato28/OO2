package com.example.joserenato.aula14.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JoseRenato on 24/05/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "tarefas";
    private static final int DB_VERSION = 1;
    private static String DB_TABLE = "CREATE TABLE tarefas" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "tarefa TEXT";

    public DataBaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(DB_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE"+DB_TABLE+";");
        onCreate(db);
    }
}
