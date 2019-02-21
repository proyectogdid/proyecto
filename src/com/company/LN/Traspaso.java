package com.company.Modelo;

public class Traspaso {
    private int id;
    private int precio;
    private Jugador jugador;
    private Equipo equipoPrevio;
    private Equipo equipoPosterior;

    public Traspaso() {
    }

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
}
