package com.example.barberapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.IOException;

public class MediaActivity extends AppCompatActivity {
    static int MICROPHONE_PERMISSION_CODE = 200;
    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private DrawerLayout drawerLayout;
    private SeekBar seekBarVolumen, seekBarFrecuencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        drawerLayout = findViewById(R.id.drawer_layout);

        if(microfonoPresente()){
            getPermisosMicrofono();
        }

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolumen = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int actualVolumen = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekBarVolumen = (SeekBar) findViewById(R.id.seekBarVolumen);
        seekBarVolumen.setMax(maxVolumen);
        seekBarVolumen.setProgress(actualVolumen);
        seekBarVolumen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarFrecuencia = (SeekBar) findViewById(R.id.seekBarFrecuencia);
        seekBarFrecuencia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                float speed = (float) progress / 10.0f;
                PlaybackParams params = new PlaybackParams();
                params.setSpeed(speed);
                mediaPlayer.setPlaybackParams(params);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void onGrabarAction(View view){
       try {
           mediaRecorder = new MediaRecorder();
           mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
           mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
           mediaRecorder.setOutputFile(getRecordingFilePath());
           mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
           mediaRecorder.prepare();
           mediaRecorder.start();

           Toast.makeText(this, "Grabando...", Toast.LENGTH_LONG).show();
       } catch (Exception e){
           e.printStackTrace();
       }
    }
    public void onPausarAction(View view){
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
        Toast.makeText(this, "Grabación pausada", Toast.LENGTH_LONG).show();

    }
    public void onReproducirAction(View view){
        try{
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(getRecordingFilePath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            Toast.makeText(this, "Reproduciendo grabación", Toast.LENGTH_LONG).show();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private boolean microfonoPresente(){
        if(this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)){
            return true;
        } else {
            return false;
        }
    }

    private void getPermisosMicrofono(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, MICROPHONE_PERMISSION_CODE);
        }
    }

    private String getRecordingFilePath(){
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File musicDirectory = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file = new File(musicDirectory, "grabacion" + ".mp3");
        return file.getPath();
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

    public void clickCards(View view){MenuActivity.redirecActivity(this, CardActivity.class);}

    public void clickMedia(View view){
        recreate();
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