package com.example.appconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String msg = "Android";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "Estoy en el estado onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Log.d(msg, "Estoy en el estado onResume");
        // TextView textEdad = (TextView) findViewById(R.id.textEdad);
        //String edad = null;
        //edad = getIntent().getStringExtra("edadUsu");
        // if(edad != null){
        //    textEdad.setText("Edad: " + edad);
        // }
    }

    public void sendData(View view){
        Intent intent = new Intent(this, ActividadResultado.class);
        intent.putExtra("result", calcular() + " ");
        startActivity(intent);

    }

    private double calcular(){
        EditText millas = (EditText) findViewById(R.id.millaValue);
        EditText pies = (EditText) findViewById(R.id.pieValue);
        EditText pulgadas = (EditText) findViewById(R.id.pulgadaValue);
        double millasData = 1069.3 * (Integer.parseInt(millas.getText().toString()));
        double piesData = 0.384 * (Integer.parseInt(pies.getText().toString()));
        double pulgadasData = 0.0254 * (Integer.parseInt(pulgadas.getText().toString()));
        double resultado = millasData + piesData + pulgadasData;
        return resultado;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "Estoy en el estado onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "Estoy en el estado onStop");
    }
}
