package com.example.pruebamaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TabLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        com.google.android.material.tabs.TabLayout tabs = (com.google.android.material.tabs.TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Op 1"));
        tabs.addTab(tabs.newTab().setText("Op 2"));
        tabs.addTab(tabs.newTab().setText("Op 3"));
        tabs.addTab(tabs.newTab().setIcon(android.R.drawable.btn_plus));
    }
}