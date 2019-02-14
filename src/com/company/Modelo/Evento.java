package com.company.Modelo;

public class Evento {
    private int id;
    private Jugador jugador;
    private Estado estadoPrevio;
    private Estado estadoPosterior;

    public Evento() {
    }

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

