package com.example.joserenato.aula12;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by JoseRenato on 10/05/2017.
 */

public class ContatosAdapter extends BaseAdapter {
    private Context context;
    private List<Contatos> list;
    ContatosAdapter(Context context, List<Contatos> list){
        this.context = context;
        this.list = list;
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
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int aux = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.activity_lista_contatos, null);

        TextView Txtnome = (TextView)layout.findViewById(R.id.textViewNome);
        Txtnome.setText(list.get(position).getNome());

        Button deletarContato = (Button)layout.findViewById((R.id.buttonDetalhes));
        deletarContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Detalhes.class);
                intent.putExtra("id", list.get(aux).getId());
                intent.putExtra("nome", list.get(aux).getNome());
                intent.putExtra("telefone", list.get(aux).getTelefone());
                context.startActivity(intent);
            }
        });

        return layout;
    }
}
