package com.example.joserenato.aula15.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JoseRenato on 23/06/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Aula15";
    private static final int DB_VERSION = 1;

    private static final String DB_TABLE = "CREATE TABLE ALUNOS(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT," +
            "matricula TEXT);";

    public DataBaseHelper(Context context){
        super(context,DB_NAME, null,DB_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE ALUNOS");
        onCreate(db);
    }
}
