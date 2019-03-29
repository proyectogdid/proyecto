package com.company.LN;

import com.company.comun.itfProperty;

import java.util.ArrayList;
import java.util.Date;

import static com.company.comun.clsConstantes.*;

/**
 * Esta clase gestiona las temporadas que almacenara nuestra applicacion
 * ademas de esto añadiremos un atributo que almacene los partidos de la temporada
 */
public class Temporada implements itfProperty {
    /**
     * atributo id de la temporada
     */
    private int id;
    /**
     * atributo año de la temporada
     */
    private Date ano;
    /**
     * partidos que se jugaran en la temporada
     */
    private ArrayList<Partido> partidos;

    public Temporada() {
    }

    /**
     * Este método va a recoger los datos de la temporada, tanto la id como el año en cuestión
     *
     * @param id
     * @param ano
     */
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

    /**
     * metodo get property de la interfaz itfProperty
     *
     * @param prop
     * @return
     */
    @Override
    public Object getProperty(String prop) {
        switch (prop) {
            case TEMPORADA_ID:
                return this.id;
            case TEMPORADA_ANO:
                return this.ano;
            case TEMPORADA_PARTIDOS:
                return this.partidos;
            default:
                return null;
        }
    }
}
