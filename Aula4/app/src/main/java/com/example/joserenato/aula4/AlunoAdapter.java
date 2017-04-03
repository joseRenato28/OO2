package com.example.joserenato.aula4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.joserenato.aula4.Aluno;

import java.util.List;

/**
 * Created by JoseRenato on 22/03/2017.
 */

public class AlunoAdapter extends BaseAdapter {

    private Context context;
    private List<Aluno> list;


    public AlunoAdapter(Context context, List<Aluno> alunos){
        this.context = context;
        this.list = alunos;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId_pessoa();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.activity_lista_alunos, null);

        TextView alunoNome = (TextView)layout.findViewById(R.id.AlunoNome);
        alunoNome.setText(list.get(position).getNome_pessoa());

        Button editarAluno = (Button)layout.findViewById((R.id.EditarAluno));
        editarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AlunoActivity.class);
                intent.putExtra("id", list.get(auxPosition).getId_pessoa());
                intent.putExtra("nome", list.get(auxPosition).getNome_pessoa());
                intent.putExtra("matricula", list.get(auxPosition).getMatricula_aluno());
                intent.putExtra("cgu", list.get(auxPosition).getCgu_pessoa());
                context.startActivity(intent);
            }
        });

        return layout;
    }
}
