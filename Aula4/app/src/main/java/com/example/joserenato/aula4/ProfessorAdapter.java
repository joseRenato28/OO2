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

import java.util.List;

/**
 * Created by JoseRenato on 03/04/2017.
 */

public class ProfessorAdapter extends BaseAdapter {

    private Context context;
    private List<Professor> list;

    public ProfessorAdapter(Context context, List<Professor> professores){
        this.context = context;
        this.list = professores;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.activity_lista_professores, null);

        TextView alunoNome = (TextView)layout.findViewById(R.id.ProfessorNome);
        alunoNome.setText(list.get(position).getNome_pessoa());

        Button editarAluno = (Button)layout.findViewById((R.id.EditarProfessor));
        editarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfessorActivity.class);
                intent.putExtra("id", list.get(auxPosition).getId_pessoa());
                intent.putExtra("nome", list.get(auxPosition).getNome_pessoa());
                intent.putExtra("salario", list.get(auxPosition).getSalario());
                intent.putExtra("cgu", list.get(auxPosition).getCgu_pessoa());
                intent.putExtra("carga", list.get(auxPosition).getCarga_horaria());
                context.startActivity(intent);
            }
        });

        return layout;
    }
}
