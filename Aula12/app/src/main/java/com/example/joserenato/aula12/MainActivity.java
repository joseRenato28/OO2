package com.example.joserenato.aula12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nome;
    EditText telefone;

    Contatos contatos;
    ContatosDB contatosDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText)findViewById(R.id.editText_nome);
        telefone = (EditText)findViewById(R.id.editText_telefone);

        contatosDB = new ContatosDB(this);
    }

    public void insert(View v){
        contatos = new Contatos();

        contatos.setNome(nome.getText().toString());
        contatos.setTelefone(telefone.getText().toString());

        try{
            contatosDB.insert(contatos);
            Toast.makeText(MainActivity.this, "Contato salvo", Toast.LENGTH_LONG).show();
            limpar();
        }catch (Exception e){
            Toast.makeText(MainActivity.this, "Ocorreu algum erro", Toast.LENGTH_LONG).show();
        }
    }

    public void listView (View v){
        Intent intent = new Intent(this, ListaContatos.class);
        startActivity(intent);
    }

    public void limpar(){
        nome.setText("");
        telefone.setText("");
    }


}
