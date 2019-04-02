package com.company.LN;

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
     * Este método, recogerá los datos necesarios para poder identificar cada estado.
     *
     * @param id
     * @param nombre
     */
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

    /**
     * metodo get property de la interfaz itfProperty
     *
     * @param prop
     * @return
     */
    @Override
    public Object getProperty(String prop) {
        switch (prop) {
            case ESTADO_ID:
                return this.id;
            case ESTADO_NOMBRE:
                return this.nombre;
            default:
                return null;
        }
    }

    @Override
    public void resultsetLoad(ResultSet rs) throws Exception {
        id=rs.getInt(BD_ESTADO_ID);
        nombre=rs.getString(BD_ESTADO_NOMBRE);
    }
}
