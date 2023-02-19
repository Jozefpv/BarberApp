package com.example.firstapp;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

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
        Log.d(msg, "Estoy en el estado onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "Estoy en el estado onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "Estoy en el estado onResume");
        TextView textEdad = (TextView) findViewById(R.id.textEdad);
        String edad = null;
        edad = getIntent().getStringExtra("edadUsu");
        if(edad != null){
            textEdad.setText("Edad: " + edad);
        }
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, Actividad2.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra("nomUsu", message);
        startActivity(intent);

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