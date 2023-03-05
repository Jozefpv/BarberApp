package com.example.barberapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.barberapp.adaptadores.ListaContactosAdapter;
import com.example.barberapp.db.DbContactos;
import com.example.barberapp.entidades.Contactos;

import java.util.ArrayList;

public class ReservasActivity extends AppCompatActivity {

    //Button boton;
    Button boton2;
    DrawerLayout drawerLayout;
    RecyclerView listaContactos;
    ArrayList<Contactos> listaArrayContactos;
    ListaContactosAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);
        drawerLayout = findViewById(R.id.drawer_activity);

        boton2 = findViewById(R.id.nuevoButton);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(v.getContext(), NuevaActivity.class);
                startActivity(e);
            }
        });

        listaContactos = findViewById(R.id.listaContactos);
        listaContactos.setLayoutManager(new LinearLayoutManager(this));

        DbContactos dbContactos = new DbContactos(ReservasActivity.this);
        listaArrayContactos = new ArrayList<>();

        adapter = new ListaContactosAdapter(dbContactos.mostrarContactos());
        listaContactos.setAdapter(adapter);

    }
    private void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.dialogo, null))
                .setPositiveButton(android.R.string.ok, null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void clickAcerca(View view){
        showAboutDialog();
    }

    public void ClickMenu(View view){
        MenuActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        MenuActivity.closeDrawer(drawerLayout);
    }

    public void Clickhome(View view){
        MenuActivity.redirecActivity(this, MenuActivity.class);
    }

    public void clickMedia(View view){
        MenuActivity.redirecActivity(this, MediaActivity.class);
    }

    public void clickCards(View view){MenuActivity.redirecActivity(this, CardActivity.class);}

    public void clickAjustes(View view){MenuActivity.redirecActivity(this, AjustesActivity.class);}


    public void clickReservas(View view){recreate();}

    public void ClickLogout(View view){
        MenuActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MenuActivity.closeDrawer(drawerLayout);
    }
}