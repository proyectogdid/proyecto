package com.company.LN;

import com.company.comun.itfProperty;

import static com.company.comun.clsConstantes.TRASPASO_ID;
import static com.company.comun.clsConstantes.TRASPASO_PRECIO;
import static com.company.comun.clsConstantes.TRASPASO_JUGADOR;
import static com.company.comun.clsConstantes.TRASPASO_EQUIPO_PREVIO;
import static com.company.comun.clsConstantes.TRASPASO_EQUIPO_POSTERIOR;

/**
 * clase que gestionara los traspasos de los jugadores entre distintos equipos
 * teniendo como atributos el equipo anterior y posterior para poder guardar un historico de la trayectoria
 */
public class Traspaso implements itfProperty {
    /**
     * atributo id del traspaso
     */
    private int id;
    /**
     * atributo precio por el que se ha realizado el traspaso
     */
    private int precio;
    /**
     * atributo que especifica el jugador objeto del traspaso
     */
    private Jugador jugador;
    /**
     * equipo que traspasa al jugador
     */
    private Equipo equipoPrevio;
    /**
     * equipo que ficha al jugador
     */
    private Equipo equipoPosterior;

    public Traspaso() {
    }

    /**
     * Este método va a recoger los datos de todos los traspasos que se vayan reslizando
     *
     * @param id
     * @param precio
     * @param jugador
     * @param equipoPrevio
     * @param equipoPosterior
     */
    public Traspaso(int id, int precio, Jugador jugador, Equipo equipoPrevio, Equipo equipoPosterior) {
        this.id = id;
        this.precio = precio;
        this.jugador = jugador;
        this.equipoPrevio = equipoPrevio;
        this.equipoPosterior = equipoPosterior;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Equipo getEquipoPrevio() {
        return equipoPrevio;
    }

    public void setEquipoPrevio(Equipo equipoPrevio) {
        this.equipoPrevio = equipoPrevio;
    }

    public Equipo getEquipoPosterior() {
        return equipoPosterior;
    }

    public void setEquipoPosterior(Equipo equipoPosterior) {
        this.equipoPosterior = equipoPosterior;
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
            case TRASPASO_ID:
                return this.id;
            case TRASPASO_PRECIO:
                return this.precio;
            case TRASPASO_JUGADOR:
                return this.jugador;
            case TRASPASO_EQUIPO_PREVIO:
                return this.equipoPrevio;
            case TRASPASO_EQUIPO_POSTERIOR:
                return this.equipoPosterior;

            default:
                return null;
        }
    }
}
