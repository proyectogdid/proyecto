package com.company.LN;

import com.company.comun.itfProperty;

import static com.company.comun.clsConstantes.EVENTO_JUGADOR;
import static com.company.comun.clsConstantes.EVENTO_ID;
import static com.company.comun.clsConstantes.EVENTO_ESTADO_PREVIO;
import static com.company.comun.clsConstantes.EVENTO_ESTADO_POSTERIOR;


/**
 * Esta clase va a gestionar los diferentes eventos o noticias
 * referidas a los jugadores. En concreto, en que estado se
 * encuentran tanto previamente como posteriormente.
 */
public class Evento implements itfProperty {
    /**
     * Atributo id del evento
     */
    private int id;
    /**
     * Atributo jugador dek evento
     */
    private int jugador;
    /**
     * Atributo estado previo del evento
     */
    private int estadoPrevio;
    /**
     * Atributo estado posterior del evento
     */
    private int estadoPosterior;

    public Evento() {
    }

    /**
     * Este metodo sirve para recoger todos los datos referentes a evento.
     *
     * @param id id
     * @param jugador jugador
     * @param estadoPrevio estadoPRevio
     * @param estadoPosterior estadoPosterior
     */
    public Evento(int id, int jugador, int estadoPrevio, int estadoPosterior) {
        this.id = id;
        this.jugador = jugador;
        this.estadoPrevio = estadoPrevio;
        this.estadoPosterior = estadoPosterior;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    public int getEstadoPrevio() {
        return estadoPrevio;
    }

    public void setEstadoPrevio(int estadoPrevio) {
        this.estadoPrevio = estadoPrevio;
    }

    public int getEstadoPosterior() {
        return estadoPosterior;
    }

    public void setEstadoPosterior(int estadoPosterior) {
        this.estadoPosterior = estadoPosterior;
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
            case EVENTO_ID:
                return this.id;
            case EVENTO_ESTADO_PREVIO:
                return this.estadoPrevio;
            case EVENTO_ESTADO_POSTERIOR:
                return this.estadoPosterior;
            case EVENTO_JUGADOR:
                return this.jugador;
            default:
                return null;
        }
    }
}

