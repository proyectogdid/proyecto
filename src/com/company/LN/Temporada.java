package com.company.LN;

import java.util.ArrayList;
import java.util.Date;

/**
 * Esta clase gestiona las temporadas que almacenara nuestra applicacion
 * ademas de esto añadiremos un atributo que almacene los partidos de la temporada
 */
public class Temporada {
    private int id;
    private Date ano;
    private ArrayList<Partido> partidos;
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

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
}
