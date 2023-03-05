package com.example.barberapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.example.barberapp.adaptadores.MiViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class AjustesActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MiViewPagerAdapter miViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        drawerLayout = findViewById(R.id.drawer_layout);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.view_pager);
        miViewPagerAdapter = new MiViewPagerAdapter(this);
        viewPager2.setAdapter(miViewPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.dialogo, null))
                .setPositiveButton(android.R.string.ok, null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void ClickLogo(View view){
        MenuActivity.closeDrawer(drawerLayout);
    }

    public void Clickhome(View view){
        MenuActivity.redirecActivity(this, MenuActivity.class);
    }

    public void clickAcerca(View view){
        showAboutDialog();
    }

    public void ClickMenu(View view){
        MenuActivity.openDrawer(drawerLayout);
    }

    public void clickCards(View view){MenuActivity.redirecActivity(this, CardActivity.class);}

    public void clickMedia(View view){
        MenuActivity.redirecActivity(this, MediaActivity.class);
    }

    public void clickAjustes(View view){recreate();}

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