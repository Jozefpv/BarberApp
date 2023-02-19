package com.example.myprotein;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class TiendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Datos[] datos = new Datos[] {
                new Datos(R.drawable.wheymp,R.drawable.whey, getString(R.string.whey_protein), getString(R.string.descripcion_whey_protein), getString(R.string.informacion_whey_protein)),
                new Datos(R.drawable.gainermp, R.drawable.gainer,getString(R.string.ganadores_peso), getString(R.string.descripcion_ganadores_peso), getString(R.string.informacion_ganadores_peso)),
                new Datos(R.drawable.premp, R.drawable.preentreno,getString(R.string.pre_entrenos), getString(R.string.descripcion_whey_protein), getString(R.string.informacion_pre_entrenos)),
                new Datos(R.drawable.multimp, R.drawable.mulitvitaminico,getString(R.string.multivitaminicos), getString(R.string.descripcion_multivitaminicos) , getString(R.string.informacion_multivitaminicos)),
                new Datos(R.drawable.snackmp, R.drawable.snack,getString(R.string.snack), getString(R.string.descripcion_snack), getString(R.string.informacion_snack)),
                new Datos(R.drawable.omegamp, R.drawable.omega,getString(R.string.omega), getString(R.string.descripcion_omega), getString(R.string.informacion_omega))

        };

        ListView listadoProductos = (ListView) findViewById(R.id.listado_suplementos);

        View cabecera = getLayoutInflater().inflate(R.layout.cabecera, null);
        listadoProductos.addHeaderView(cabecera);
        Adaptador adaptador = new Adaptador(this, datos);
        listadoProductos.setAdapter(adaptador);
        Intent cambiarActividad;
        cambiarActividad = new Intent(this, ProductoActivity.class);
        listadoProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String producto = ((Datos)adapterView.getItemAtPosition(i)).getProducto();
                String informacion = ((Datos)adapterView.getItemAtPosition(i)).getInformacion();
                int imagen = ((Datos)adapterView.getItemAtPosition(i)).getImagenProducto();
                cambiarActividad.putExtra("textoProducto", producto);
                cambiarActividad.putExtra("informacionProducto", informacion);
                cambiarActividad.putExtra("imagenProducto", imagen);
                startActivity(cambiarActividad);

            }
        });

    }

    public void onBackAction(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}