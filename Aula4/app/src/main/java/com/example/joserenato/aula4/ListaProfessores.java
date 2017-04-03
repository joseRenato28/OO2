package com.example.joserenato.aula4;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListaProfessores extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lista_professores);

        setListAdapter(new ProfessorAdapter(this, ProfessorActivity.listarProfessores));
    }

}
