package com.example.joserenato.aula4;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AlunoActivity extends AppCompatActivity {
    public TextView idAluno;
    public EditText nomeAluno;
    public EditText cguAluno;
    public EditText matriculaAluno;

    public Aluno aluno;
    public static  int id = 1;
    public static boolean novo = true;
    public static List<Aluno> listaAlunos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        nomeAluno = (EditText)findViewById(R.id.editTextNomeAluno);
        cguAluno = (EditText)findViewById(R.id.editTextCguAluno);
        matriculaAluno = (EditText)findViewById(R.id.editTextMatriculaAluno);

        idAluno = (TextView)findViewById(R.id.Idprofessor);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                aluno = new Aluno();

                aluno.setId_pessoa(bundle.getInt("id"));
                aluno.setMatricula_aluno(bundle.getString("matricula"));
                aluno.setNome_pessoa(bundle.getString("nome"));
                aluno.setCgu_pessoa(bundle.getString("cgu"));

                idAluno.setText(String.valueOf(aluno.getId_pessoa()));
                nomeAluno.setText(aluno.getNome_pessoa());
                cguAluno.setText(aluno.getCgu_pessoa());
                matriculaAluno.setText(aluno.getMatricula_aluno());
                novo = false;
            }
        }
    }

    public void salvar(View v){
        if(novo){
            aluno = new Aluno();

            aluno.setId_pessoa(Integer.parseInt(idAluno.getText().toString()));
            aluno.setNome_pessoa(nomeAluno.getText().toString());
            aluno.setCgu_pessoa(cguAluno.getText().toString());
            aluno.setMatricula_aluno(matriculaAluno.getText().toString());

            listaAlunos.add(aluno);

            Toast.makeText(this, "Aluno salvo com sucesso", Toast.LENGTH_SHORT).show();
        }else{
            for(int i = 0; i < listaAlunos.size(); i++){
                if(listaAlunos.get(i).getId_pessoa() == aluno.getId_pessoa()){
                    aluno.setNome_pessoa(nomeAluno.getText().toString());
                    aluno.setCgu_pessoa(cguAluno.getText().toString());
                    aluno.setMatricula_aluno(matriculaAluno.getText().toString());

                    listaAlunos.set(i, aluno);

                    Toast.makeText(this, "Aluno alterado com sucesso", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }

    public void excluir(View v){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Exclusão de aluno");
        alertDialog.setMessage("Tem certeza que deseja excluir?");
        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i = 0; i < listaAlunos.size(); i++){
                    if(listaAlunos.get(i).getId_pessoa() == aluno.getId_pessoa()){
                        listaAlunos.remove(i);
                        break;
                    }
                }
            }
        });
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void novo(View v){
        id++;
        idAluno.setText(String.valueOf(id));
        nomeAluno.setText("");
        cguAluno.setText("");
        matriculaAluno.setText("");
        novo = true;
    }

    public void listar(View v){
        Intent intent = new Intent(this, ListaAlunos.class);
        startActivity(intent);
    }

}
