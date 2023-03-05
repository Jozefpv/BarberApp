package com.example.barberapp.fragmentos;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.barberapp.R;


public class Fragmento3 extends Fragment {
    private TextView lightSituationTextView;

    private SensorManager sensorManager;
    private Sensor lightSensor;
    private SensorEventListener lightSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float light = event.values[0];
            String situation;

            if (light < 100) {
                situation = "Oscuro";
            } else if (light < 2000) {
                situation = "Normal";
            } else {
                situation = "Brillante";
            }

            lightSituationTextView.setText("Situación lumínica: " + situation);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // No se utiliza en este ejemplo
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragmento3, container, false);

        lightSituationTextView = rootView.findViewById(R.id.light_situation_text_view);
        sensorManager = (SensorManager) requireActivity().getSystemService(Context.SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (lightSensor != null) {
            sensorManager.registerListener(lightSensorListener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        sensorManager.unregisterListener(lightSensorListener);
    }
}
