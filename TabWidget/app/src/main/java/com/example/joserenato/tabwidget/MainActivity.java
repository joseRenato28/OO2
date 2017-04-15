package com.example.joserenato.tabwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabhost = (TabHost)findViewById(R.id.tabHost);

        tabhost.setup();

        TabHost.TabSpec aba1 = tabhost.newTabSpec("Dados");
        aba1.setContent(R.id.layout1);
        aba1.setIndicator("Dados");

        TabHost.TabSpec aba2 = tabhost.newTabSpec("Disciplinas");
        aba2.setContent(R.id.layout2);
        aba2.setIndicator("Disciplinas");

        tabhost.addTab(aba1);
        tabhost.addTab(aba2);
    }
}
