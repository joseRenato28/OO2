package com.example.joserenato.aula14.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.joserenato.aula14.Model.Tarefa;
import com.example.joserenato.aula14.Model.TarefaModel;

/**
 * Created by JoseRenato on 24/05/2017.
 */

public class TarefaController {
    private TarefaModel tarefaModel;

    public TarefaController(Context context){
        this.tarefaModel = new TarefaModel(context);
    }


    public void insert(Tarefa tarefa) throws Exception{
        final ContentValues values = new ContentValues();
        values.put("tarefa", tarefa.getTarefa());
        tarefaModel.insert(values);
    }

    public void delete(int id)throws Exception{
        tarefaModel.delete(""+id);
    }

    public Cursor list(){
        Cursor c = tarefaModel.list();
        return c;
    }
}
