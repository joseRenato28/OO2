package com.example.joserenato.trabalhog1;

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
 * Created by JoseRenato on 19/04/2017.
 */

public class MoviesAdapter extends BaseAdapter {

    private Context context;
    private List<Movies> list;

    public MoviesAdapter(Context context, List<Movies> listMovies1) {
        this.context = context;
        this.list = listMovies1;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final int aux = position;

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.activity_list_movies, null);

        TextView title = (TextView)layout.findViewById(R.id.movie_title_list);
        TextView rate = (TextView)layout.findViewById(R.id.movie_rate_list);

        title.setText(list.get(position).getTitle());
        rate.setText(list.get(position).getRate());

        Button details = (Button)layout.findViewById(R.id.edit_movie);

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MoviesDetails.class);
                intent.putExtra("id", list.get(aux).getId());
                intent.putExtra("title", list.get(aux).getTitle());
                intent.putExtra("description", list.get(aux).getDescription());
                intent.putExtra("rate", list.get(aux).getRate());
                context.startActivity(intent);
            }
        });

        return layout;
    }
}
