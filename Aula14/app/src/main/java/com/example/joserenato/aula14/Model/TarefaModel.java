package com.example.joserenato.aula14.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.joserenato.aula14.BD.DataBaseHelper;

/**
 * Created by JoseRenato on 24/05/2017.
 */

public class TarefaModel {
    private SQLiteDatabase sqLite;

    public TarefaModel(Context context){
        sqLite = new DataBaseHelper(context).getWritableDatabase();
    }

    public void insert(ContentValues values) throws Exception{
        sqLite.insert("tarefas", null, values);
    }

    public Cursor list(){
        String[] columns = new String[] {"id", "tarefa"};

        Cursor cursor = sqLite.query("tarefas", columns, null, null, null, null, null);
        return cursor;
    }

    public void delete(String argument) throws Exception{
        String where = "id=?";
        String[] arguments = new String[] {argument};
        sqLite.delete("tarefas", where, arguments);
    }
}
