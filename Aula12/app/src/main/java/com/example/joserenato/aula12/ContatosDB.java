package com.example.joserenato.aula12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JoseRenato on 10/05/2017.
 */

public class ContatosDB {
    private SQLiteDatabase sqLiteDatabase;

    public ContatosDB(Context context){
        sqLiteDatabase = new DataBaseHelper(context).getWritableDatabase();
    }

    public void insert(Contatos contatos)throws Exception{
        ContentValues values = new ContentValues();

        values.put("nome", contatos.getNome());
        values.put("telefone", contatos.getTelefone());

        sqLiteDatabase.insert("contatos", null, values);
    }

    public List<Contatos> list(){
        List <Contatos> list = new ArrayList<>();

        String[] columns = new String[]{"id", "nome", "telefone"};

        Cursor cursor = sqLiteDatabase.query("contatos", columns, null, null, null, null, "nome Asc");
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                Contatos contato = new Contatos();
                contato.setId(cursor.getInt(cursor.getColumnIndex("id")));
                contato.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                contato.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
                list.add(contato);
            }while(cursor.moveToNext());
        }
        return list;
    }

    public List<Contatos> search(String nome){
        List <Contatos> list = new ArrayList<>();

        String[] columns = new String[]{"id", "nome", "telefone"};
        String where = "nome = ?";
        String[] arguments = new String[]{nome};

        Cursor cursor = sqLiteDatabase.query("contatos", columns, where, arguments, null, null, "nome Asc");
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                Contatos contato = new Contatos();
                contato.setId(cursor.getInt(cursor.getColumnIndex("id")));
                contato.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                contato.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
                list.add(contato);
            }while(cursor.moveToNext());
        }
        return list;
    }

    public void update(Contatos contatos) throws Exception{
        String where = "id = ?";
        String[] arguments = new String[]{""+contatos.getId()};

        ContentValues values = new ContentValues();
        values.put("nome", contatos.getNome());
        values.put("telefone", contatos.getTelefone());

        sqLiteDatabase.update("contatos", values, where, arguments);
    }

    public void delete(Contatos contatos) throws Exception{
        String where = "id = ?";
        String[] arguments = new String[]{""+contatos.getId()};

        sqLiteDatabase.delete("contatos", where, arguments);
    }
}

