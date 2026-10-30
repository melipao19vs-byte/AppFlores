package com.example.galeriaflores;

public class Flor {
    private String nombre;
    private String descripcion;
    private int imagenResId;

    public Flor(String nombre, String descripcion, int imagenResId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenResId = imagenResId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagenResId() {
        return imagenResId;
    }
}