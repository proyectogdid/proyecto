package com.company.LN;

import com.company.Excepciones.PropiedadIncorrecta;
import com.company.comun.itfPersistable;
import com.company.comun.itfProperty;

import java.sql.ResultSet;

import static com.company.comun.clsConstantes.*;

/**
 * Esta clase va a gestionar los posibles estados
 * de los difernetes jugadores, teniendo como atributos
 * la id y el nombre del estado.
 */
public class Estado implements itfProperty, itfPersistable {
    /**
     * Atributo id del estado
     */
    private int id;
    /**
     * Atributo nombre del estado
     */
    private String nombre;

    public Estado() {
    }

    /**
     * Este metodo, recogera los datos necesarios para poder identificar cada estado.
     *
     * @param id     id
     * @param nombre nombre
     */
    public Estado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Metodo que usaremos para introducir los nombres del estado en la BD
     *
     * @param nombre nombre
     */
    public Estado(String nombre) {
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
            case ESTADO_ID:
                return this.id;
            case ESTADO_NOMBRE:
                return this.nombre;
            default:
                throw new PropiedadIncorrecta(prop);
        }
    }

    /**
     * Metodo para cargar los datos de los estados en el resultset
     *
     * @param rs rs
     * @throws Exception throws Exception
     */
    @Override
    public void resultsetLoad(ResultSet rs) throws Exception {
        id = rs.getInt(BD_ESTADO_ID);
        nombre = rs.getString(BD_ESTADO_NOMBRE);
    }

    /**
     * Devuelve el nombre del estado
     *
     * @return
     */
    public String toString() {
        return this.nombre;
    }
}

