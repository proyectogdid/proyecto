package com.company.LN;

import com.company.Excepciones.PropiedadIncorrecta;
import com.company.comun.itfPersistable;
import com.company.comun.itfProperty;

import java.sql.ResultSet;

import static com.company.comun.clsConstantes.*;

/**
 * Clase la cual se utilizará para determinar
 * las posiciones de los diferentes jugadores.
 * Tenuendo exclusivamente los atributos de id y nombre
 * de la posición.
 */


public class Posicion implements itfProperty, itfPersistable {
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
     * Este metodo recogera todos los datos necesarios para poder identificar la posición de cada jugador.
     *
     * @param id     id
     * @param nombre nombre
     */
    public Posicion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Posicion(String nombre) {
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

    /**
     * Metodo get property de la interfaz itfProperty
     *
     * @param prop prop
     * @return return
     */
    @Override
    public Object getProperty(String prop) {
        switch (prop) {
            case POSICION_ID:
                return this.id;
            case POSICION_NOMBRE:
                return this.nombre;
            default:
                throw new PropiedadIncorrecta(prop);
        }
    }

    /**
     * Metodo para cargar los datos de las posiciones en el resultset
     *
     * @param rs rs
     * @throws Exception throws Exception
     */
    @Override
    public void resultsetLoad(ResultSet rs) throws Exception {
        id = rs.getInt(BD_POSICION_ID);
        nombre = rs.getString(BD_POSICION_NOMBRE);
    }

    /**
     * @return nombre de la posciion
     */
    public String toString() {
        return this.nombre;
    }
}
