package com.company.Modelo;
/** Clase la cual se utilizará para determinar
 * las posiciones de los diferentes jugadores.
 * Tenuendo exclusivamente los atributos de id y nombre
 * de la posición.
 */


public class Posicion {
    private int id;
    private String nombre;

    public Posicion() {
    }

    public Posicion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
