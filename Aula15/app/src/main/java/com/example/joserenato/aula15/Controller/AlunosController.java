package com.example.joserenato.aula15.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.joserenato.aula15.Model.Alunos;
import com.example.joserenato.aula15.Model.AlunosModel;

/**
 * Created by JoseRenato on 24/06/2017.
 */

public class AlunosController {
    private AlunosModel alunosModel;

    public AlunosController(Context context){
        alunosModel = new AlunosModel(context);
    }

    public void insert(Alunos alunos)throws Exception{
        final ContentValues values = new ContentValues();

        values.put("nome", alunos.getNome());
        values.put("matricula", alunos.getMatricula());

        alunosModel.insert(values);
    }

    public Cursor list(){
        Cursor cursor = alunosModel.list();
        return cursor;
    }

    public void update(Alunos alunos)throws Exception{
        final ContentValues values = new ContentValues();

        values.put("nome", alunos.getNome());
        values.put("matricula", alunos.getMatricula());

        alunosModel.update(values, alunos.getId());
    }
    public void delete(int id)throws Exception{
        alunosModel.delete(""+id);
    }
}
