package com.company.LN;

import java.util.ArrayList;

/**
 * Clase para gestionar los equipos de nuestra liga ademas del
 * y el patrocinador vamos a añadir un atributo jugadores para
 * gestionar la plantilla de cada equipo.
 */
public class Equipo {
    /**
     * Atributo id del equipo
     */
    private int id;
    /**
     * Atributo nombre del equipo
     */
    private String nombre;
    /**
     * Atributo patrocinador del equipo
     */
    private String patrocinador;
    /**
     * Atributo jugagores del equipo
     */
    private ArrayList<Jugador> jugadores;

    public Equipo() {
    }

    /**
     * Este método recogerá todos los datos necesarios para identificar los diferentes equipos.
     * @param id
     * @param nombre
     * @param patrocinador
     */
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

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
