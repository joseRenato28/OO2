package com.example.joserenato.aula12;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JoseRenato on 10/05/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String db_name = "aula12";
    private static final int db_version = 1;
    private static String db_table = "CREATE TABLE contatos(" +
                                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        "nome TEXT, " +
                                        "telefone TEXT);";
    DataBaseHelper (Context context){
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE contatos;");
        onCreate(db);
    }
}
