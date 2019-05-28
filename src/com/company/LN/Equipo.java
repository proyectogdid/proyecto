package com.company.LN;

import com.company.Excepciones.PropiedadIncorrecta;
import com.company.comun.itfProperty;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;

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
    private ArrayList<Integer> jugadores;
    /**
     * atributo campo de equipo
     */
    private Object campo;

    /**
     * Este método recogera todos los datos necesarios para identificar los diferentes equipos.
     */
    public Equipo(String nombre, String patrocinador) {
        this.nombre = nombre;
        this.patrocinador = patrocinador;

    }

    public Equipo() {

    }

    /**
     * Metodo para cargar datos de los quipos en el resultset
     *
     * @param rs rs
     * @throws Exception throws Exception
     */
    public void resultSetToEquipo(ResultSet rs) throws Exception {
        id = rs.getInt(BD_EQUIPO_ID);
        nombre = rs.getString(BD_EQUIPO_NOMBRE);
        patrocinador = rs.getString(BD_EQUIPO_PATROCINADOR);
        campo = rs.getObject(BD_EQUIPO_CAMPO);

    }

    public Object getCampo() {
        return campo;
    }

    public void setCampo(int campo) {
        this.campo = campo;
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

    public ArrayList<Integer> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Integer> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * metodo get property de la interfaz itfProperty
     *
     * @param prop prop
     * @return return
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
            case EQUIPO_CAMPO:
                return this.campo;
            default:
                throw new PropiedadIncorrecta(prop);
        }
    }

    /**
     * Metodo toString de itfProperty
     *
     * @return return
     */
    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return id == equipo.id ;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, patrocinador, jugadores, campo);
    }
}
