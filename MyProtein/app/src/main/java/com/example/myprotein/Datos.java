package com.example.myprotein;

import android.media.Image;

public class Datos {
    private String producto;
    private String descripcion;
    private String informacion;
    private int imagen;
    private int imagenProducto;

    public Datos(int imagenProducto, int imagen, String producto, String descripcion, String informacion){
        this.imagenProducto = imagenProducto;
        this.producto = producto;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.informacion = informacion;
    }

    public int getImagenProducto(){
        return imagenProducto;
    }

    public String getInformacion(){
        return informacion;
    }

    public String getProducto(){
        return producto;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public int getImagen(){
        return imagen;
    }
}
