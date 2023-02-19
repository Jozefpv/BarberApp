package com.example.barberapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.barberapp.adaptadores.ListaContactosAdapter;
import com.example.barberapp.db.DbContactos;
import com.example.barberapp.db.DbHelper;
import com.example.barberapp.entidades.Contactos;

import java.util.ArrayList;

public class Setting extends AppCompatActivity {

    //Button boton;
    Button boton2;
    DrawerLayout drawerLayout;
    RecyclerView listaContactos;
    ArrayList<Contactos> listaArrayContactos;
    ListaContactosAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        drawerLayout = findViewById(R.id.drawer_activity);

        //boton = findViewById(R.id.button3);

        //boton.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View v) {
        //DbHelper dbHelper = new DbHelper(Setting.this);
        //SQLiteDatabase db = dbHelper.getWritableDatabase();
        //if(db != null){
        //  Toast.makeText(Setting.this, "creada", Toast.LENGTH_LONG).show();
        //} else {
        //  Toast.makeText(Setting.this, "error", Toast.LENGTH_LONG).show();
        //}
        //}
        //});

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

        DbContactos dbContactos = new DbContactos(Setting.this);
        listaArrayContactos = new ArrayList<>();

        adapter = new ListaContactosAdapter(dbContactos.mostrarContactos());
        listaContactos.setAdapter(adapter);

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

    public void clickAboutUs(View view){recreate();}

    public void ClickLogout(View view){
        MenuActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MenuActivity.closeDrawer(drawerLayout);
    }
}