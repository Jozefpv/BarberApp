package com.example.barberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imagen = (ImageView) findViewById(R.id.logoImage);
        Button boton = (Button) findViewById(R.id.inicioButton);
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animacion);

        animacion.setRepeatCount(Animation.RESTART);
        imagen.startAnimation(animacion);
        boton.startAnimation(animacion);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onInicioAction(View view){
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }
}
