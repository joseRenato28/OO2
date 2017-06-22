package com.example.joserenato.trabalhog2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.joserenato.trabalhog2.Helper.ImageHelper;
import com.example.joserenato.trabalhog2.Model.Release;
import com.example.joserenato.trabalhog2.R;

import java.util.List;

/**
 * Created by JoseRenato on 20/06/2017.
 */

public class ReleaseAdapter extends BaseAdapter {

    private Context context;
    private List<Release> list;

    public  ReleaseAdapter (Context context, List<Release> list){
        this.context = context;
        this.list  = list;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.list_release,null);

        TextView title_news = (TextView)layout.findViewById(R.id.title_news);
        TextView rate_news = (TextView)layout.findViewById(R.id.rate_news);

        ImageView img_news = (ImageView)layout.findViewById(R.id.img_news);

        title_news.setText(list.get(position).getTitle());
        rate_news.setText(list.get(position).getRate());
        new ImageHelper(img_news).execute(list.get(position).getImg());
        return layout;
    }
}
