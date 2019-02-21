package com.company.LN;
/** Clase la cual se utilizará para determinar
 * las posiciones de los diferentes jugadores.
 * Tenuendo exclusivamente los atributos de id y nombre
 * de la posición.
 */


public class Posicion {
    /**
     * Atributo id de la posición
     */
    private int id;
    /**
     * Atributo nombre de la posición
     */
    private String nombre;

    public Posicion() {
    }

    /**
     * Este método recogerá todos los datos necesarios para poder identificar la posición de cada jugador.
     * @param id
     * @param nombre
     */
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
