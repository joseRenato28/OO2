package com.example.joserenato.trabalhog1;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);

       Button create_btn = (Button)findViewById(R.id.movie_save);

        create_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ControllerDb crud = new ControllerDb(getBaseContext());

                EditText title = (EditText)findViewById(R.id.movie_name);
                EditText description = (EditText)findViewById(R.id.movie_description);
                EditText rate = (EditText)findViewById(R.id.movie_rate);

                String title_movie = title.getText().toString();
                String description_movie = description.getText().toString();
                String rate_movie = rate.getText().toString();
                String result;

                result = crud.Create(title_movie, description_movie, rate_movie);

                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });

    }
}
