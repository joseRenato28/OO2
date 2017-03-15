package com.example.joserenato.aula1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    TextView textView;
    TextView textView_opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        textView = (TextView)findViewById(R.id.textView2);
        textView_opt = (TextView)findViewById(R.id.textView_opt);
    }

    public void copy(View v){
        editText2.setText(editText.getText().toString());
    }

    public void add(View v){
        int result = 0;
        result = Integer.parseInt(editText.getText().toString()) + Integer.parseInt(editText2.getText().toString());
        textView.setText(String.valueOf(result));
    }

    public void text_add(View v){
        textView_opt.setText("+");
    }
    public void text_sub(View v){
        textView_opt.setText("-");
    }
    public void text_mult(View v){
        textView_opt.setText("*");
    }
    public void text_div(View v){
        textView_opt.setText("/");
    }

    public void calculator(View v){
        String op =  textView_opt.getText().toString();
        int value1 = Integer.parseInt(editText.getText().toString());
        int value2 = Integer.parseInt(editText2.getText().toString());
        int result = 0;
        if(op.equals("+")){
            result = value1 + value2;
            textView.setText(String.valueOf(result));
        }else if(op.equals("-")){
            result = value1 - value2;
            textView.setText(String.valueOf(result));
        }else if(op.equals("*")){
            result = value1 * value2;
            textView.setText(String.valueOf(result));
        }else if(op.equals("/")){
            result = value1 / value2;
            textView.setText(String.valueOf(result));
        }else{
            textView.setText("Operação não encontrada");
        }
    }
}
