package com.example.joserenato.aula14;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.joserenato.aula14.Controller.TarefaController;
import com.example.joserenato.aula14.Model.Tarefa;

public class MainActivity extends AppCompatActivity {

    private ListView lvTarefa;
    private Button btNovaTarefa;
    private EditText etNovaTarefa;

    private TarefaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.controller = new TarefaController(this);

        this.lvTarefa = (ListView)findViewById(R.id.lvTarefa);
        this.btNovaTarefa = (Button)findViewById(R.id.bdNovaTarefa);
        this.etNovaTarefa = (EditText)findViewById(R.id.etNovaTarefa);
    }

    public void populaTarefa(){
        String[] FieldsName = {"tarefa"};
        int[] idView = new int[]{R.id.textViewTarefa};
        final Cursor cursor = controller.list();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_tarefas, cursor, FieldsName, idView);
        lvTarefa.setAdapter(adapter);

    }

    public void novaTarefa(View v){
        Tarefa tarefa = new Tarefa();
        tarefa.setTarefa(etNovaTarefa.getText().toString());

        try{
            this.controller.insert(tarefa);
            this.populaTarefa();
        }catch (Exception e){
            Toast.makeText(MainActivity.this, "Ocorreu algum erro pra inserir", Toast.LENGTH_LONG).show();
        }
    }
}
