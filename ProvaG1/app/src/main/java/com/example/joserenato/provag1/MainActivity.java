package com.example.joserenato.provag1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView)findViewById(R.id.name);
    }

    public void next(View v){
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("name", name.getText().toString());
        startActivity(intent);
    }
}
