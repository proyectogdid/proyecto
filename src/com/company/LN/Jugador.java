package com.company.LN;

import com.company.comun.itfProperty;

import java.sql.ResultSet;
import java.util.Date;

import static com.company.comun.clsConstantes.*;

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
    private int equipo;
    /**
     * Atributo posición del jugador
     */
    private int posicion;
    /**
     * Atributo estado del jugador
     */
    private int estado;

    public Jugador(String dorsal) {
    }

    public Jugador() {
    }

    /**
     * Este metodo recogerá todos los valores necesarios para identificar cada jugador
     *
     * @param id            id
     * @param nombre        nombre
     * @param apellido1     apellido1
     * @param apellido2     apellido2
     * @param fechaNac      fechaNAc
     * @param dorsal        dorsal
     * @param textoCamiseta textoCamiseta
     * @param equipo        equipo
     * @param posicion      posicion
     * @param estado        estado
     */

    public Jugador(int id, String nombre, String apellido1, String apellido2, Date fechaNac, String dorsal, String textoCamiseta, int equipo, int posicion, int estado) {
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

    /**
     * Metodo que emplearemos para añadir jugadores a la BD
     *
     * @param nombre        nombre
     * @param apellido1     apellido1
     * @param apellido2     apellido2
     * @param fechaNac      fechaNac
     * @param dorsal        dorsal
     * @param textoCamiseta textoCamiseta
     */
    public Jugador(String nombre, String apellido1, String apellido2, Date fechaNac, String dorsal, String textoCamiseta) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNac = fechaNac;
        this.dorsal = dorsal;
        this.textoCamiseta = textoCamiseta;
    }

    /**
     * MEtodo para cargar los datos de los jugadores en el resultset
     * @param rs rs
     * @throws Exception throws Exception
     */
    public void resultSetToJugador(ResultSet rs) throws Exception {
        id = rs.getInt(BD_JUGADOR_ID);
        nombre = rs.getString(BD_JUGADOR_NOMBRE);
        apellido1 = rs.getString(BD_JUGADOR_APELLIDO1);
        apellido2 = rs.getString(BD_JUGADOR_APELLIDO2);
        fechaNac = rs.getDate(BD_JUGADOR_FECHA_NACIMIENTO);
        dorsal = rs.getString(BD_JUGADOR_DORSAL);
        textoCamiseta = rs.getString(BD_JUGADOR_TEXTO_CAMISETA);
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

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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
            case JUGADOR_ID:
                return this.id;
            case JUGADOR_NOMBRE:
                return this.nombre;
            case JUGADOR_APELLIDO1:
                return this.apellido1;
            case JUGADOR_APELLIDO2:
                return this.apellido2;
            case JUGADOR_FECHA_NACIMIENTO:
                return this.fechaNac;
            case JUGADOR_DORSAL:
                return this.dorsal;
            case JUGADOR_TEXTO_CAMISETA:
                return this.textoCamiseta;
            case JUGADOR_EQUIPO:
                return this.equipo;
            case JUGADOR_POSICION:
                return this.posicion;
            case JUGADOR_ESTADO:
                return this.estado;
            default:
                throw new RuntimeException();
        }
    }
}
