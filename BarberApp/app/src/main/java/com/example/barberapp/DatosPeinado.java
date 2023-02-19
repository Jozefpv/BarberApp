package com.example.barberapp;

public class DatosPeinado {

    private String nombrePeinado;
    private String descripcionPeinado;
    private Integer fotoPeinado;

    public DatosPeinado(String nombrePeinado, String descripcionPeinado, Integer fotoPeinado) {
        this.nombrePeinado = nombrePeinado;
        this.descripcionPeinado = descripcionPeinado;
        this.fotoPeinado = fotoPeinado;
    }

    public String getNombrePeinado() {
        return nombrePeinado;
    }

    public void setNombrePeinado(String nombrePeinado) {
        this.nombrePeinado = nombrePeinado;
    }

    public String getDescripcionPeinado() {
        return descripcionPeinado;
    }

    public void setDescripcionPeinado(String descripcionPeinado) {
        this.descripcionPeinado = descripcionPeinado;
    }

    public Integer getFotoPeinado() {
        return fotoPeinado;
    }

    public void setFotoPeinado(Integer fotoPeinado) {
        this.fotoPeinado = fotoPeinado;
    }
}
