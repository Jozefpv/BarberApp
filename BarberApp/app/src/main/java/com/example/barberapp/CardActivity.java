package com.example.barberapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

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
                new DatosPeinado("clasico", "corte normal", R.drawable.clasico),
                new DatosPeinado("largo", "cabellos largos", R.drawable.largo),
                new DatosPeinado("rapado", "corte rapado", R.drawable.rapado),
                new DatosPeinado("rastas", "corte con dreads", R.drawable.dreads),
                new DatosPeinado("afro", "corte afro", R.drawable.afro)

        };

        PeinadoAdapter adapter = new PeinadoAdapter(datosPeinados, CardActivity.this);
        recyclerView.setAdapter(adapter);
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

    public void clickDashboard(View view){
        recreate();
    }
    public void clickMedia(View view){
        MenuActivity.redirecActivity(this, MediaActivity.class);
    }


    public void clickAboutUs(View view){
        MenuActivity.redirecActivity(this, Setting.class);
    }

    public void ClickLogout(View view){
        MenuActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MenuActivity.closeDrawer(drawerLayout);
    }
}