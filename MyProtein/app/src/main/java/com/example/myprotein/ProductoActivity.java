package com.example.myprotein;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProductoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Se recoge y muestra el texto pasado de la Actividad principal
        TextView producto = (TextView) findViewById(R.id.productoText);
        TextView descripcion = (TextView) findViewById(R.id.descripcionText);
        ImageView imagen = (ImageView) findViewById(R.id.imageSuple);
        Intent recibirDato = getIntent();
        producto.setText(recibirDato.getStringExtra("textoProducto"));
        descripcion.setText(recibirDato.getStringExtra("informacionProducto"));
        imagen.setImageResource(recibirDato.getIntExtra("imagenProducto", 1));
    }

    // Método para inflar el OptionsMenu del recurso inicio.xml en la Actividad
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.inicio_menu, menu);
        return true;
    }


    public void onBackProductAction(View view){
        Intent i = new Intent(this, TiendaActivity.class);
        startActivity(i);
    }

    // Listener del OptionsMenu que inciará la Actividad principal
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent cambiarActividad;
        cambiarActividad = new Intent(this, MainActivity.class);
        switch (item.getItemId()) {
            case R.id.Inicio:
                startActivity(cambiarActividad);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
