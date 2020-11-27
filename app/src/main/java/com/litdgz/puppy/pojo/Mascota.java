package com.litdgz.puppy.pojo;

import android.widget.ImageView;
import android.widget.TextView;

public class Mascota {
    private int idGrid;
    private int id;
    private int foto;
    private String nombre;
    private  int numeroFavoritos;

    private String idPerfil;
    private String nombreCompleto;
    private String urlFoto;
    private int likes = 0;


    public Mascota(int foto, String nombre, int numeroFavoritos) {
        this.foto = foto;
        this.nombre = nombre;
        this.numeroFavoritos = numeroFavoritos;
    }

    public Mascota(int foto, int numeroFavoritos) {
        this.foto = foto;
        this.numeroFavoritos = numeroFavoritos;
    }

    public Mascota(String urlFoto, String nombreCompleto, int likes){
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.likes = likes;
    }

    public Mascota() {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGrid() {
        return idGrid;
    }

    public void setIdGrid(int idGrid) {
        this.idGrid = idGrid;
    }


    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
