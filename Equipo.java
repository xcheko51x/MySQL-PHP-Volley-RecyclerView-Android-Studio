package com.example.ejemplovolleyrecyclerview;

public class Equipo {

    private String nombre;
    private String escudo;

    public Equipo(String nombre, String escudo) {
        this.nombre = nombre;
        this.escudo = escudo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }
}
