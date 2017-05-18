package com.example.joserenato.provag1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    TextView welcome;
    EditText destiny;
    EditText distance;
    EditText fuel;

    public Datas datas;
    public static List<Datas> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        welcome = (TextView)findViewById(R.id.welcomeTxt);

        destiny = (EditText)findViewById(R.id.destiny);
        distance = (EditText)findViewById(R.id.distance);
        fuel = (EditText)findViewById(R.id.fuel);

        Intent intent = getIntent();
        if(intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                welcome.setText("Seja bem vindo "+bundle.getString("name"));
            }else{
                welcome.setText("Seja bem vindo sem nome");
            }
        }
    }

    public void insert(View v){
       datas = new Datas();

        datas.setDestiny(destiny.getText().toString());
        datas.setDisntace(Double.parseDouble(distance.getText().toString()));
        datas.setFuel(Double.parseDouble(fuel.getText().toString()));

        list.add(datas);

        Toast.makeText(this, "Registro salvo com sucesso", Toast.LENGTH_SHORT).show();

        clearFields();
    }

    public void clearFields(){
        destiny.setText("");
        distance.setText("");
        fuel.setText("");
    }

    public void list(View v){
        Intent intent = new Intent(this, com.example.joserenato.provag1.List.class);
        startActivity(intent);
    }

    public void avg(View v){
        double avg = 0;
        double sun_distance = 0;
        double sun_fuel = 0;

        for(int i = 0; i < list.size(); i++){
            sun_distance += list.get(i).getDisntace();
            sun_fuel += list.get(i).getFuel();
        }

        avg = sun_fuel/sun_distance;

        Toast.makeText(this, "A média de Km por L é: "+avg, Toast.LENGTH_SHORT).show();
    }

}
