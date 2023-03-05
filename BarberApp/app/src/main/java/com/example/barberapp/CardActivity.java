package com.example.barberapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.barberapp.adaptadores.PeinadoAdapter;

public class CardActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);


    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        drawerLayout = findViewById(R.id.drawer_layout);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DatosPeinado[] datosPeinados = new DatosPeinado[] {
                new DatosPeinado("Clásico", "Peinado formal y elegante adecuado para todo tipo de cabellos", R.drawable.clasico),
                new DatosPeinado("Largo", "Peinado para cabellos largos y alisados", R.drawable.largo),
                new DatosPeinado("Rapado", "Peinado estilo militar para cabellos extremadamente corto", R.drawable.rapado),
                new DatosPeinado("Dreadlocks", "Peinado formado por cabello enredado y tejido, característico de los rastafaris.", R.drawable.dreads),
                new DatosPeinado("Afro", "Peinado propio de los cabellos rizados y secos", R.drawable.afro)

        };

        PeinadoAdapter adapter = new PeinadoAdapter(datosPeinados, CardActivity.this);
        recyclerView.setAdapter(adapter);
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

    public void clickCards(View view){recreate();}

    public void clickMedia(View view){
        MenuActivity.redirecActivity(this, MediaActivity.class);
    }

    public void clickAjustes(View view){MenuActivity.redirecActivity(this, AjustesActivity.class);}

    public void clickReservas(View view){MenuActivity.redirecActivity(this, ReservasActivity.class);}

    public void ClickLogout(View view){
        MenuActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MenuActivity.closeDrawer(drawerLayout);
    }
}