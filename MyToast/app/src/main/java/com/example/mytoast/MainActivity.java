package com.example.mytoast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();


        CharSequence[] items = {"opcion1", "opcion2", "opcion3", "opcion4"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Es el titulo")
                .setMessage("hola")
                .setIcon(R.mipmap.ic_launcher)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast mitoast = Toast.makeText(getApplicationContext(), "cerrando la alerta", Toast.LENGTH_SHORT);
                        mitoast.show();
                    }
                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                     @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = Toast.makeText(getApplicationContext(), "pulsando boton positivo", Toast.LENGTH_SHORT);
                        toast.show();
                    }
               // })
                //.setItems(items, new DialogInterface.OnClickListener() {
                  //  @Override
                    //public void onClick(DialogInterface dialogInterface, int i) {
                     //   Toast toast = Toast.makeText(getApplicationContext(), "pulsando un elemento del listado", Toast.LENGTH_SHORT);
                      //  toast.show();
                    //}
                });
        AlertDialog dialogo = builder.create();
        dialogo.show();

        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast mensaje = Toast.makeText(getApplicationContext(), "prueba toast", Toast.LENGTH_SHORT );
                mensaje.show();



            }
        });

    }
}