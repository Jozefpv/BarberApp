package com.example.barberapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class AjustesActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private TextView resolutionTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        drawerLayout = findViewById(R.id.drawer_layout);

        resolutionTextView = findViewById(R.id.resolutionTextView);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int screenWidthPx = displayMetrics.widthPixels;
        int screenHeightPx = displayMetrics.heightPixels;
        float density = displayMetrics.density;
        int screenWidthDp = (int) (screenWidthPx / density);
        int screenHeightDp = (int) (screenHeightPx / density);

        String resolution = "Screen resolution: " + screenWidthPx + "x" + screenHeightPx + " px (" + screenWidthDp + "x" + screenHeightDp + " dp)";
        resolutionTextView.setText(resolution);
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

    public void clickAjustes(View view){MenuActivity.redirecActivity(this, AjustesActivity.class);}


    public void clickReservas(View view){
        MenuActivity.redirecActivity(this, ReservasActivity.class);
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