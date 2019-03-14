package com.company.LN;

import com.company.comun.itfProperty;
import static com.company.comun.clsConstantes.JUGADOR_ID;
import static com.company.comun.clsConstantes.JUGADOR_NOMBRE;
import static com.company.comun.clsConstantes.JUGADOR_APELLIDO1;
import static com.company.comun.clsConstantes.JUGADOR_APELLIDO2;
import static com.company.comun.clsConstantes.JUGADOR_FECHA_NACIMIENTO;
import static com.company.comun.clsConstantes.JUGADOR_DORSAL;
import static com.company.comun.clsConstantes.JUGADOR_TEXTO_CAMISETA;
import static com.company.comun.clsConstantes.JUGADOR_EQUIPO;
import static com.company.comun.clsConstantes.JUGADOR_POSICION;
import static com.company.comun.clsConstantes.JUGADOR_ESTADO;

import java.util.Date;

/**
 * Clase para gestionar los datos del jugador
 * guardando su nombre completo, fecha de nacimiento,
 * dorsal, texto de camiseta, equipo en el que juega,su posicion y su estado actual
 */
public class Jugador implements itfProperty {
    /**
     * Atributo id del jugador
     */
    private int id;
    /**
     * Atributo nombre del jugador
     */
    private String nombre;
    /**
     * Atributo primer apellido del jugador
     */
    private String apellido1;
    /**
     * Atributo degundo apellido del jugador
     */
    private String apellido2;
    /**
     * Atributo fecha de nacimiento del jugador
     */
    private Date fechaNac;
    /**
     * Atributo número del dorsal del jugador
     */
    private String dorsal;
    /**
     * Atributo texto de la camiseta del jugador
     */
    private String textoCamiseta;
    /**
     * Atributo equipo del jugaror
     */
    private Equipo equipo;
    /**
     * Atributo posición del jugador
     */
    private Posicion posicion;
    /**
     * Atributo estado del jugador
     */
    private Estado estado;

    public Jugador() {
    }

    /**
     * Este método recogerá todos los valores necesarios para identificar cada jugador
     *
     * @param id
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param fechaNac
     * @param dorsal
     * @param textoCamiseta
     * @param equipo
     * @param posicion
     * @param estado
     */

    public Jugador(int id, String nombre, String apellido1, String apellido2, Date fechaNac, String dorsal, String textoCamiseta, Equipo equipo, Posicion posicion, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNac = fechaNac;
        this.dorsal = dorsal;
        this.textoCamiseta = textoCamiseta;
        this.equipo = equipo;
        this.posicion = posicion;
        this.estado = estado;
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

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    public String getTextoCamiseta() {
        return textoCamiseta;
    }

    public void setTextoCamiseta(String textoCamiseta) {
        this.textoCamiseta = textoCamiseta;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    /**
     * metodo get property de la interfaz itfProperty
     * @param prop
     * @return
     */
    @Override
    public Object getProperty(String prop) {
        switch (prop){
            case JUGADOR_ID:return this.id;
            case JUGADOR_NOMBRE:return this.nombre;
            case JUGADOR_APELLIDO1:return this.apellido1;
            case JUGADOR_APELLIDO2:return this.apellido2;
            case JUGADOR_FECHA_NACIMIENTO:return this.fechaNac;
            case JUGADOR_DORSAL:return this.dorsal;
            case JUGADOR_TEXTO_CAMISETA:return this.textoCamiseta;
            case JUGADOR_EQUIPO:return this.equipo;
            case JUGADOR_POSICION:return this.posicion;
            case JUGADOR_ESTADO:return this.estado;
            default:return null;
        }
    }
}
