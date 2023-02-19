package com.example.mimenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView textoMensaje = (TextView) findViewById(R.id.tvMensaje);
        switch (item.getItemId()){
            case R.id.op1:
                textoMensaje.setText(getResources().getString(R.string.opcion1_menu_main));
                return true;
            case R.id.op2:
                textoMensaje.setText(getResources().getString(R.string.opcion2_menu_main));
                return true;
            case R.id.op2_1:
                textoMensaje.setText(getResources().getString(R.string.opcion2_1_menu_main));
                return true;
            case R.id.op2_2:
                textoMensaje.setText(getResources().getString(R.string.opcion2_2_menu_main));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}