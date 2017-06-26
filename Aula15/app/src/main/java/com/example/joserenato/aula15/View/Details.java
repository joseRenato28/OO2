package com.example.joserenato.aula15.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.joserenato.aula15.Controller.AlunosController;
import com.example.joserenato.aula15.Model.Alunos;
import com.example.joserenato.aula15.R;

public class Details extends AppCompatActivity {

    private int id;
    private EditText nome;
    private EditText matricula;


    private AlunosController alunosController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.alunosController = new AlunosController(this);

        this.nome = (EditText)findViewById(R.id.d_nome);
        this.matricula = (EditText)findViewById(R.id.d_matricula);

        if(getIntent().hasExtra("id_aluno")){
            this.id = Integer.parseInt(getIntent().getStringExtra("id_aluno"));
            this.nome.setText(getIntent().getStringExtra("nome"));
            this.matricula.setText(getIntent().getStringExtra("matricula"));
        }

    }

    public static Intent getActivtyIntent(Context context, String id_aluno, String nome, String matricula){
        return new Intent(context,
                Details.class)
                .putExtra("id_aluno", id_aluno)
                .putExtra("nome", nome)
                .putExtra("matricula", matricula);
    }

    public void delete(View v){
        try{
            this.alunosController.delete(this.id);
            Toast.makeText(this, "Aluno deletado com sucesso", Toast.LENGTH_SHORT).show();
            this.redirectList(v);
            finish();
        }catch (Exception e){
            Toast.makeText(this, "Não foi possivel deletar este aluno"+ e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void update(View v){
        try{
            Alunos alunos = new Alunos();

            alunos.setId(this.id);
            alunos.setNome(nome.getText().toString());
            alunos.setMatricula(matricula.getText().toString());

            this.alunosController.update(alunos);

            Toast.makeText(this, "Aluno alterado com sucesso", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "Não foi possivel alterar este aluno"+ e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void redirectList(View v){
        Intent intent = new Intent(this, ListarAlunos.class);
        startActivity(intent);
    }

    public void redirectInsert(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
