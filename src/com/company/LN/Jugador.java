package com.company.LN;

import java.util.Date;

/**
 * Clase para gestionar los datos del jugador
 * guardando su nombre completo, fecha de nacimiento,
 * dorsal, texto de camiseta, equipo en el que juega,su posicion y su estado actual
 */
public class Jugador {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNac;
    private String dorsal;
    private String textoCamiseta;
    private Equipo equipo;
    private Posicion posicion;
    private Estado estado;

    public Jugador() {
    }

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
}
