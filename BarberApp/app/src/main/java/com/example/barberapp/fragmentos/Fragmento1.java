package com.example.barberapp.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.barberapp.R;


public class Fragmento1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragmento1, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView resolucionTextView = view.findViewById(R.id.resolucion_textview);

        // Obtener las dimensiones de la pantalla del dispositivo
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int anchoPixeles = displayMetrics.widthPixels;
        int altoPixeles = displayMetrics.heightPixels;

        // Calcular la resolución del dispositivo
        int densidadDpi = displayMetrics.densityDpi;
        double anchoPulgadas = (double) anchoPixeles / (double) densidadDpi;
        double altoPulgadas = (double) altoPixeles / (double) densidadDpi;
        double diagonalPulgadas = Math.sqrt(Math.pow(anchoPulgadas, 2) + Math.pow(altoPulgadas, 2));
        int diagonalPixeles = (int) (diagonalPulgadas * (double) densidadDpi);

        // Mostrar la resolución del dispositivo en el TextView
        resolucionTextView.setText("Resolución: " + anchoPixeles + " x " + altoPixeles + " (" + diagonalPixeles + " píxeles)");
    }
}