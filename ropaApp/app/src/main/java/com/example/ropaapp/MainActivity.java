package com.example.ropaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Datos [] datos = new Datos []{
            new Datos("Nike", "tenis y deportivas"),
            new Datos("Adidas", "ropa y calzado"),
            new Datos("QuickSilver", "bañadores y tablas"),
            new Datos("GymShark", "gimnasio y complementos")
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listado = (ListView) findViewById(R.id.marcas);
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);
    }
}