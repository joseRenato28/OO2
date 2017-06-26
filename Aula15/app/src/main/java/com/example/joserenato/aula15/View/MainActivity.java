package com.example.joserenato.aula15.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.joserenato.aula15.Controller.AlunosController;
import com.example.joserenato.aula15.Model.Alunos;
import com.example.joserenato.aula15.R;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText matricula;

    private AlunosController alunosController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText)findViewById(R.id.et_nome);
        matricula = (EditText)findViewById(R.id.et_matricula);

        this.alunosController = new AlunosController(this);
    }

    public void listView(View v){

    }

    public void insert(View v){
        try{
            Alunos alunos = new Alunos();

            alunos.setNome(nome.getText().toString());
            alunos.setMatricula(matricula.getText().toString());

            this.alunosController.insert(alunos);
            clearFields();

            Toast.makeText(this, "Aluno cadastrado com sucesso", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "Não foi possivel cadastrar este aluno"+ e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void clearFields(){
        nome.setText("");
        matricula.setText("");
    }

    public void list(View v){
        Intent intent = new Intent(this, ListarAlunos.class);
        startActivity(intent);
        finish();
    }
}
