package com.litdgz.puppy.pojo;

import android.widget.ImageView;
import android.widget.TextView;

public class Mascota {

    private int foto;
    private String nombre;
    private  int numeroFavoritos;

    public Mascota(int foto, String nombre, int numeroFavoritos) {
        this.foto = foto;
        this.nombre = nombre;
        this.numeroFavoritos = numeroFavoritos;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroFavoritos() {
        return numeroFavoritos;
    }

    public void setNumeroFavoritos(int numeroFavoritos) {
        this.numeroFavoritos = numeroFavoritos;
    }
}
