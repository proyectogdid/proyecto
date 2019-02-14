package com.company.Modelo;

import java.util.Date;

public class Temporada {
    private int id;
    private Date ano;

    public Temporada() {
    }

    public Temporada(int id, Date ano) {
        this.id = id;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }
}
