package com.company.LN;

import com.company.comun.itfProperty;

/**
 * Clase para gestionar los campos en los que se juegan los partidos
 * guardando su nombre, dirección y aforo
 */
public class Campo implements itfProperty {
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
     * Este método, va a recoger todos los datos necesarios para identificar un campo.
     * @param id
     * @param nombre
     * @param ciudad
     * @param calle
     * @param numero
     * @param cp
     * @param aforo
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
     * @param prop
     * @return
     */
    @Override
    public Object getProperty(String prop) {
        switch (prop){
            case "id":return this.id;
            case "nombre":return this.nombre;
            case "ciudad":return this.ciudad;
            case "calle":return this.calle;
            case "numero":return this.numero;
            case "cp":return this.cp;
            case "aforo":return this.aforo;
            default:return null;
        }
    }
}
