package com.example.myprotein;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView miTexto = (TextView) findViewById(R.id.mainText);
        Button tiendaButton = (Button) findViewById(R.id.tiendaButton);
        Button contactoButton = (Button) findViewById(R.id.contactoButton);
        Button listaButton = (Button) findViewById(R.id.listaButton);
        Animation miAnimacion = AnimationUtils.loadAnimation(this, R.anim.animacion);

        miAnimacion.setRepeatCount(Animation.RESTART);
        //miAnimacion.setRepeatCount(1);
        miTexto.startAnimation(miAnimacion);
        tiendaButton.startAnimation(miAnimacion);
        contactoButton.startAnimation(miAnimacion);
        listaButton.startAnimation(miAnimacion);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onTiendaAction(View view){
        Intent i = new Intent(this, TiendaActivity.class);
        startActivity(i);
    }

    public void onContactoAction(View view){
        Intent contacto = new Intent(this, ContactoActivity.class);
        startActivity(contacto);
    }

    public void onListaAction(View view){
        Intent lista = new Intent(this, Todo.class);
        startActivity(lista);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Intent contacto = new Intent(this, ContactoActivity.class);
        switch (item.getItemId()) {
            case R.id.op1:
                Toast.makeText(this, "prueba", Toast.LENGTH_SHORT).show();
                startActivity(contacto);
                return true;
            case R.id.op2_1:

                return true;
            case R.id.op2_2:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}