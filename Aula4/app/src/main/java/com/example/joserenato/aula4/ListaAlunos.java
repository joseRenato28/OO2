package com.example.joserenato.aula4;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListaAlunos extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lista_alunos);

        setListAdapter(new AlunoAdapter(this, AlunoActivity.listaAlunos));
    }
}
