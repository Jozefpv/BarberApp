package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra("nomUsu");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText("Hola " + message);
    }
    public void returnMessage(View view){
        Intent intentBack = new Intent(this, MainActivity.class);
        EditText numero = (EditText) findViewById(R.id.editTextNumberSigned);
        String mensaje = numero.getText().toString();
        intentBack.putExtra("edadUsu", mensaje);
        startActivity(intentBack);

    }
}