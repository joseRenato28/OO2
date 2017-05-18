package com.example.joserenato.aula12;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListaContatos extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lista_contatos);

        ContatosDB contatosDB = new ContatosDB(this);

        setListAdapter(new ContatosAdapter(this, contatosDB.list()));
    }
}
