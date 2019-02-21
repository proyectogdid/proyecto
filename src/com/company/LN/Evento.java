package com.company.LN;

/** Esta clase va a gestionar los diferentes eventos o noticias
 *  referidas a los jugadores. En concreto, en que estado se
 *  encuentran tanto previamente como posteriórmente.
 */
public class Evento {
    /**
     * Atributo id del evento
     */
    private int id;
    /**
     * Atributo jugador dek evento
     */
    private Jugador jugador;
    /**
     * Atributo estado previo del evento
     */
    private Estado estadoPrevio;
    /**
     * Atributo estado posterior del evento
     */
    private Estado estadoPosterior;

    public Evento() {
    }

    /**
     * Este método sirve para recoger todos los datos referentes a evento.
     * @param id
     * @param jugador
     * @param estadoPrevio
     * @param estadoPosterior
     */
    public Evento(int id, Jugador jugador, Estado estadoPrevio, Estado estadoPosterior) {
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

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Estado getEstadoPrevio() {
        return estadoPrevio;
    }

    public void setEstadoPrevio(Estado estadoPrevio) {
        this.estadoPrevio = estadoPrevio;
    }

    public Estado getEstadoPosterior() {
        return estadoPosterior;
    }

    public void setEstadoPosterior(Estado estadoPosterior) {
        this.estadoPosterior = estadoPosterior;
    }
}

