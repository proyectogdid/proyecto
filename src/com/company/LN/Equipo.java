package com.company.LN;

import com.company.comun.itfProperty;

import java.sql.ResultSet;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.*;


/**
 * Clase para gestionar los equipos de nuestra liga ademas del
 * y el patrocinador vamos a añadir un atributo jugadores para
 * gestionar la plantilla de cada equipo.
 */
public class Equipo implements itfProperty {
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

    public Equipo(String nombre, String patrocinador) {
    }

    /**
     * Este método recogerá todos los datos necesarios para identificar los diferentes equipos.
     *  */
    public Equipo() {
        this.id = id;
        this.nombre = nombre;
        this.patrocinador = patrocinador;


    }

    public void resultSetToEquipo(ResultSet rs)throws Exception{
        nombre=rs.getString(BD_EQUIPO_NOMBRE);
        patrocinador=rs.getString(BD_EQUIPO_PATROCINADOR);

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

    /**
     * metodo get property de la interfaz itfProperty
     *
     * @param prop
     * @return
     */
    @Override
    public Object getProperty(String prop) {
        switch (prop) {
            case EQUIPO_ID:
                return this.id;
            case EQUIPO_NOMBRE:
                return this.nombre;
            case EQUIPO_PATROCINADOR:
                return this.patrocinador;
            case EQUIPO_JUGADORES:
                return this.jugadores;
            default:
                return null;
        }
    }
}
