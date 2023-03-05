package com.example.barberapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.TextView;

public class BatteryBroadcastReceiver extends BroadcastReceiver {

    private TextView nivelBateriaTextView;
    private TextView estadoBateriaTextView;

    public BatteryBroadcastReceiver(TextView nivelBateriaTextView, TextView estadoBateriaTextView) {
        this.nivelBateriaTextView = nivelBateriaTextView;
        this.estadoBateriaTextView = estadoBateriaTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int bateriaNivel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int bateriaEscala = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float bateriaPorcentaje = bateriaNivel * 100 / (float) bateriaEscala;
        int bateriaEstado = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        String estadoText = "";

        switch (bateriaEstado) {
            case BatteryManager.BATTERY_STATUS_CHARGING:
                estadoText = "Cargando";
                break;
            case BatteryManager.BATTERY_STATUS_DISCHARGING:
                estadoText = "Descargando";
                break;
            case BatteryManager.BATTERY_STATUS_FULL:
                estadoText = "Completa";
                break;
            case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                estadoText = "No cargando";
                break;
            case BatteryManager.BATTERY_STATUS_UNKNOWN:
            default:
                estadoText = "Desconocido";
                break;
        }

        nivelBateriaTextView.setText("Nivel de bateria: " + bateriaPorcentaje + "%");
        estadoBateriaTextView.setText("Estado de la bateria: " + estadoText);
    }
}
