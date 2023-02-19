package com.example.animaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView miTexto = (TextView) findViewById(R.id.saludo);
        //Animation miAnimacion = AnimationUtils.loadAnimation(this, R.anim.transicion);
        //Animation miAnimacion = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        Animation miAnimacion = AnimationUtils.loadAnimation(this, R.anim.alpha);

        miAnimacion.setRepeatCount(Animation.RESTART);
        miAnimacion.setRepeatCount(20);
        miTexto.startAnimation(miAnimacion);


    }
}