package com.example.barberapp;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.barberapp.entidades.Contactos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MenuActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        drawerLayout = findViewById(R.id.drawer);
    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
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

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void Clickhome(View view){
        recreate();
    }

    public void clickCards(View view){
        redirecActivity(this, CardActivity.class);
    }

    public void clickReservas(View view){
        redirecActivity(this, ReservasActivity.class);
    }

    public void clickMedia(View view){
        redirecActivity(this, MediaActivity.class);
    }

    public void clickAjustes(View view){
        redirecActivity(this, AjustesActivity.class);
    }

    public void ClickLogout(View view){
        logout(this);
    }

    public static void redirecActivity(Activity activity, Class Class) {
        activity.startActivity(new Intent(activity,Class){{
            setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }});
    }

    public static void logout(Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Salir");
        builder.setMessage("¿Está seguro que desea salir?");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishActivity(which);
                System.exit(0);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}