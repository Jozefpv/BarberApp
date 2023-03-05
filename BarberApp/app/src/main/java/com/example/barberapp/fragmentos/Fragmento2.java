package com.example.barberapp.fragmentos;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.barberapp.BatteryBroadcastReceiver;
import com.example.barberapp.R;


public class Fragmento2 extends Fragment {

    private BatteryBroadcastReceiver batteryBroadcastReceiver;
    private TextView nivelBateriaTextView;
    private TextView estadoBateriaTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragmento2, container, false);
        nivelBateriaTextView = rootView.findViewById(R.id.nivelBateriaTextView);
        estadoBateriaTextView = rootView.findViewById(R.id.estadoBateriaTextView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        batteryBroadcastReceiver = new BatteryBroadcastReceiver(nivelBateriaTextView, estadoBateriaTextView);
        requireActivity().registerReceiver(batteryBroadcastReceiver, intentFilter);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (batteryBroadcastReceiver != null) {
            requireActivity().unregisterReceiver(batteryBroadcastReceiver);
            batteryBroadcastReceiver = null;
        }
    }
}