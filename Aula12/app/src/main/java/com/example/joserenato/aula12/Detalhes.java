package com.example.joserenato.aula12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Detalhes extends AppCompatActivity {

    public TextView id;
    public EditText nome;
    public EditText telefone;

    Contatos contato;
    ContatosDB contatosDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        id = (TextView)findViewById(R.id.txtIdDetalhes);
        nome = (EditText)findViewById(R.id.txtNomeDetalhes);
        telefone = (EditText)findViewById(R.id.txtTelefoneDetalhes);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                contato = new Contatos();

                contato.setId(bundle.getInt("id"));
                contato.setNome(bundle.getString("nome"));
                contato.setTelefone(bundle.getString("telefone"));

                id.setText(String.valueOf(contato.getId()));
                nome.setText(contato.getNome());
                telefone.setText(contato.getTelefone());
            }
        }
    }

    public void update(View v){
        contato = new Contatos();

        contato.setId(Integer.parseInt(id.getText().toString()));
        contato.setNome(nome.getText().toString());
        contato.setTelefone(telefone.getText().toString());
        try{
            contatosDB = new ContatosDB(this);
            contatosDB.update(contato);
            Toast.makeText(Detalhes.this, "Contato deletado", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ListaContatos.class);
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(Detalhes.this,e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void deletar(View v){
        contato = new Contatos();
        contato.setId(Integer.parseInt(id.getText().toString()));
        try{
            contatosDB = new ContatosDB(this);
            contatosDB.delete(contato);
            Intent intent = new Intent(this, ListaContatos.class);
            startActivity(intent);
            Toast.makeText(Detalhes.this, "Contato deletado", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(Detalhes.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
