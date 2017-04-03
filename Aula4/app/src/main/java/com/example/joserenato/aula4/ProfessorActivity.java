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

public class ProfessorActivity extends AppCompatActivity {

    public TextView idProfessor;
    public TextView nomeProfessor;
    public TextView cguProfessor;
    public TextView salarioProfessor;
    public TextView cargaHorariaProfessor;

    public Professor professor;
    public static  int id = 1;
    public static boolean novo = true;
    public static List<Professor> listarProfessores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        nomeProfessor = (EditText)findViewById(R.id.NomeProfessor);
        cguProfessor = (EditText)findViewById(R.id.CguProfessor);
        salarioProfessor = (EditText)findViewById(R.id.SalarioProfessor);
        cargaHorariaProfessor = (EditText)findViewById(R.id.CargaHoraria);

        idProfessor = (TextView)findViewById(R.id.Idprofessor);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                professor = new Professor();

                professor.setId_pessoa(bundle.getInt("id"));
                professor.setSalario(bundle.getString("salario"));
                professor.setNome_pessoa(bundle.getString("nome"));
                professor.setCgu_pessoa(bundle.getString("cgu"));
                professor.setCarga_horaria(bundle.getString("carga"));

                idProfessor.setText(String.valueOf(professor.getId_pessoa()));
                nomeProfessor.setText(professor.getNome_pessoa());
                cguProfessor.setText(professor.getCgu_pessoa());
                salarioProfessor.setText(professor.getSalario());
                cargaHorariaProfessor.setText(professor.getCarga_horaria());
                novo = false;
            }
        }
    }

    public void salvar(View v){
        if(novo){
            professor = new Professor();

            professor.setId_pessoa(Integer.parseInt(idProfessor.getText().toString()));
            professor.setNome_pessoa(nomeProfessor.getText().toString());
            professor.setCgu_pessoa(cguProfessor.getText().toString());
            professor.setSalario(salarioProfessor.getText().toString());
            professor.setCarga_horaria(cargaHorariaProfessor.getText().toString());

            listarProfessores.add(professor);

            Toast.makeText(this, "Professor salvo com sucesso", Toast.LENGTH_SHORT).show();
        }else{
            for(int i = 0; i < listarProfessores.size(); i++){
                if(listarProfessores.get(i).getId_pessoa() == professor.getId_pessoa()){
                    professor.setNome_pessoa(nomeProfessor.getText().toString());
                    professor.setCgu_pessoa(cguProfessor.getText().toString());
                    professor.setSalario(salarioProfessor.getText().toString());
                    professor.setCarga_horaria(cargaHorariaProfessor.getText().toString());

                    listarProfessores.set(i, professor);

                    Toast.makeText(this, "Professor alterado com sucesso", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }

    public void novo(View v){
        id++;
        idProfessor.setText(String.valueOf(id));
        nomeProfessor.setText("");
        cguProfessor.setText("");
        salarioProfessor.setText("");
        cargaHorariaProfessor.setText("");
        novo = true;
    }

    public void listar(View v){
        Intent intent = new Intent(this, ListaProfessores.class);
        startActivity(intent);
    }

    public void excluir(View v){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Exclusão de professor");
        alertDialog.setMessage("Tem certeza que deseja excluir?");
        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i = 0; i < listarProfessores.size(); i++){
                    if(listarProfessores.get(i).getId_pessoa() == professor.getId_pessoa()){
                        listarProfessores.remove(i);
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
}
