package com.example.joserenato.aula15.View;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.joserenato.aula15.Controller.AlunosController;
import com.example.joserenato.aula15.R;

public class ListarAlunos extends AppCompatActivity {


    private AlunosController alunosController;
    private ListView list_alunos;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alunos);

        alunosController = new AlunosController(this);

        try{
            this.getAlunos();
        }catch (Exception e){
            Toast.makeText(this, "Não foi possivel listar os alunos"+ e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public void getAlunos(){
        String[] fields = {"nome", "matricula", "_id"};
        int[] idView = new int[]{R.id.nome_aluno};
        final Cursor cursor = alunosController.list();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(ListarAlunos.this, R.layout.list_alunos, cursor, fields, idView, 0);

        this.list_alunos = (ListView)findViewById(R.id.list_alunos);

        this.list_alunos.setAdapter(adapter);

        this.list_alunos.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.moveToPosition(position);
                try{
                    String id_aluno = cursor.getString(cursor.getColumnIndex("_id"));
                    String nome = cursor.getString(cursor.getColumnIndex("nome"));
                    String matricula = cursor.getString(cursor.getColumnIndex("matricula"));

                    startActivity(Details.getActivtyIntent(ListarAlunos.this, id_aluno, nome, matricula));
                }catch (Exception e){
                    Toast.makeText(ListarAlunos.this, "Não foi possivel abrir os detlahes"+ e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
