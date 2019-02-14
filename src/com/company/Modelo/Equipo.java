package com.company.Modelo;

public class Equipo {

    private int id;
    private String nombre;
    private String patrocinador;

    public Equipo() {
    }

    public Equipo(int id, String nombre, String patrocinador) {
        this.id = id;
        this.nombre = nombre;
        this.patrocinador = patrocinador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }
}
