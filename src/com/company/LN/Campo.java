package com.company.LN;

import com.company.comun.itfPersistable;
import com.company.comun.itfProperty;

import java.sql.ResultSet;

import static com.company.comun.clsConstantes.*;

/**
 * Clase para gestionar los campos en los que se juegan los partidos
 * guardando su nombre, dirección y aforo
 */
public class Campo implements itfProperty, Comparable<Campo>, itfPersistable {
    /**
     * Atributo id del campo
     */
    private int id;
    /**
     * Atributo nombre del campo
     */
    private String nombre;
    /**
     * Atributo ciudad del campo
     */
    private String ciudad;
    /**
     * Atributo calle del campo
     */
    private String calle;
    /**
     * Atributo número del campo
     */
    private String numero;
    /**
     * Atributo código postal del campo
     */
    private String cp;
    /**
     * Atributo aforo del campo
     */
    private int aforo;


    public Campo() {
    }

    /**
     * Este metodo, va a recoger todos los datos necesarios para identificar un campo.
     *
     * @param id id
     * @param nombre nombre
     * @param ciudad ciudad
     * @param calle calle
     * @param numero numero
     * @param cp cp
     * @param aforo aforo
     */
    public Campo(int id, String nombre, String ciudad, String calle, String numero, String cp, int aforo) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.aforo = aforo;
    }

    /**
     * constructor
     *
     * @param nombre nombre
     * @param ciudad ciudad
     * @param calle calle
     * @param numero numero
     * @param cp cp
     * @param aforo aforo
     */

    public Campo(String nombre, String ciudad, String calle, String numero, String cp, int aforo) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.aforo = aforo;
    }

    public void resultsetLoad(ResultSet rs) throws Exception {
        id = rs.getInt(BD_CAMPO_ID);
        aforo = rs.getInt(BD_CAMPO_AFORO);
        nombre = rs.getString(BD_CAMPO_NOMBRE);
        ciudad = rs.getString(BD_CAMPO_CIUDAD);
        calle = rs.getString(BD_CAMPO_CALLE);
        numero = rs.getString(BD_CAMPO_NUMERO);
        cp = rs.getString(BD_CAMPO_CP);
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
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
            case CAMPO_ID:
                return this.id;
            case CAMPO_NOMBRE:
                return this.nombre;
            case CAMPO_CIUDAD:
                return this.ciudad;
            case CAMPO_CALLE:
                return this.calle;
            case CAMPO_NUMERO:
                return this.numero;
            case CAMPO_CP:
                return this.cp;
            case CAMPO_AFORO:
                return this.aforo;
            default:
                 throw new RuntimeException();
        }
    }

    @Override
    public int compareTo(Campo o) {
        return 0;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}


