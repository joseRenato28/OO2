package com.example.joserenato.aula15.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.joserenato.aula15.BD.DataBaseHelper;

/**
 * Created by JoseRenato on 23/06/2017.
 */

public class AlunosModel {
    private SQLiteDatabase sqLiteDatabase;

    public AlunosModel(Context context){
        sqLiteDatabase = new DataBaseHelper(context).getWritableDatabase();
    }

    public void insert(ContentValues values) throws  Exception{
        sqLiteDatabase.insert("ALUNOS", null, values);
    }

    public Cursor list(){
        String[] columns = new String[] {"_id", "nome", "matricula"};
        Cursor cursor = sqLiteDatabase.query("ALUNOS", columns, null, null, null, null, null);

        return cursor;
    }

    public void update(ContentValues values, int id) throws  Exception{
        String where = "_id=?";
        String[] arguments = new String[]{""+id};

        sqLiteDatabase.update("ALUNOS", values, where, arguments);
    }

    public void delete(String argment) throws Exception{
        String where = "_id=?";
        String[] arguments = new String[]{argment};
        sqLiteDatabase.delete("ALUNOS", where, arguments);
    }

}
