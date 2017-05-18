package com.example.joserenato.provag1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.joserenato.provag1.Datas;

import java.util.List;

/**
 * Created by JoseRenato on 26/04/2017.
 */

public class DataAdapter extends BaseAdapter {
    private Context context;
    private List<Datas> list;

    public DataAdapter(Context context, List<Datas> datases){
        this.context = context;
        this.list = datases;
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
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.activity_list, null);

        TextView destiny = (TextView)layout.findViewById(R.id.destinyTxt);
        TextView distance = (TextView)layout.findViewById(R.id.distanceTxt);
        TextView fuel = (TextView)layout.findViewById(R.id.fuelTxt);

        destiny.setText(list.get(position).getDestiny().toString());
        distance.setText(list.get(position).getDisntace().toString());
        fuel.setText(list.get(position).getFuel().toString());

        return layout;
    }
}
