package com.example.barberapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MediaActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private MediaRecorder recorder;
    private String outputFile;
    Button btnGrabar, btnPausar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        drawerLayout= findViewById(R.id.drawer_layout);
        btnGrabar = findViewById(R.id.btnGrabar);
        btnPausar = findViewById(R.id.btnPausar);

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat .requestPermissions(MediaActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
        }

        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grabar(v);
            }
        });

        btnPausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopRecording();
            }
        });
    }


    public void grabar(View view){
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Grabacion.mp3";
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(outputFile);
        try{
            recorder.prepare();
            recorder.start();
        } catch(IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "grabando", Toast.LENGTH_SHORT);
    }

    public void stopRecording() {
        recorder.stop();
        recorder.release();
        recorder = null;
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
        recreate();
    }

    public void clickReservas(View view){
        MenuActivity.redirecActivity(this, ReservasActivity.class);
    }

    public void clickAjustes(View view){MenuActivity.redirecActivity(this, AjustesActivity.class);}


    public void clickCards(View view){MenuActivity.redirecActivity(this, CardActivity.class);}

    public void ClickLogout(View view){
        MenuActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MenuActivity.closeDrawer(drawerLayout);
    }
}