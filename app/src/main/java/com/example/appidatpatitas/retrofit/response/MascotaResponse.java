package com.example.appidatpatitas.retrofit.response;

public class MascotaResponse {

    private  String nommascota;
    private String fechaperdida;
    private  String lugar;
    private String urlimagen;
    private String contacto;

    public String getNommascota() {
        return nommascota;
    }

    public void setNommascota(String nommascota) {
        this.nommascota = nommascota;
    }

    public String getFechaperdida() {
        return fechaperdida;
    }

    public void setFechaperdida(String fechaperdida) {
        this.fechaperdida = fechaperdida;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
