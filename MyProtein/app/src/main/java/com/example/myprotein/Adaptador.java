package com.example.myprotein;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends ArrayAdapter<Datos> {
    private Datos[] datos;

    public Adaptador(Context context, Datos[] datos){
        super(context, R.layout.listdesing, datos);
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.listdesing, parent, false);
        ImageView imagen = (ImageView) elemento.findViewById(R.id.imageSuplementos);
        imagen.setImageResource(datos[position].getImagen());

        TextView textoSuplemento = (TextView) elemento.findViewById(R.id.suplementosText);
        textoSuplemento.setText(datos[position].getProducto());
        TextView textoDescripcion = (TextView) elemento.findViewById(R.id.descripcionText);
        textoDescripcion.setText(datos[position].getDescripcion());

        return elemento;
    }

}
