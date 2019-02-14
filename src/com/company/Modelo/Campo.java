package com.company.Modelo;

public class Campo {
    private int id;
    private String nombre;
    private String ciudad;
    private String calle;
    private String numero;
    private String cp;
    private int aforo;

    public Campo() {
    }

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
}
