package com.example.joserenato.aula7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
    }

    public void erro(View v){
        try{
            switch (radioGroup.getCheckedRadioButtonId()){
                case R.id.radioArray:
                    List<String> arreizera = new ArrayList<>();
                    arreizera.add("rs");
                    arreizera.get(-1);
                    break;
                case R.id.radioAri:
                    break;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            Toast.makeText(this,R.string.trataErro, Toast.LENGTH_SHORT).show();
        }
    }
}
