package com.litdgz.puppy.restApi.model;

public class UsuarioResponse {
    private String id;
    private String token;
    private String instagram;


    public UsuarioResponse(String id, String token, String instagram) {
        this.id = id;
        this.token = token;
        this.instagram = instagram;
    }

    public UsuarioResponse() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
