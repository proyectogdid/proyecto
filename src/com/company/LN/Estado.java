package com.company.LN;

/** Esta clase va a gestionar los posibles estados
 *  de los difernetes jugadores, teniendo como atributos
 *  la id y el nombre del estado.
 *
 */
public class Estado {
    private int id;
    private String nombre;

    public Estado() {
    }

    public Estado(int id, String nombre) {
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
