package com.company.LN;

import com.company.Excepciones.PropiedadIncorrecta;
import com.company.comun.itfPersistable;
import com.company.comun.itfProperty;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import static com.company.comun.clsConstantes.*;

/**
 * Esta clase gestiona las temporadas que almacenara nuestra applicacion
 * ademas de esto añadiremos un atributo que almacene los partidos de la temporada
 */
public class Temporada implements itfProperty, itfPersistable {
    /**
     * Atributo id de la temporada
     */
    private int id;
    /**
     * Atributo año de la temporada
     */
    private Date ano;
    /**
     * Partidos que se jugaran en la temporada
     */
    private ArrayList<Integer> partidos;

    public Temporada() {
    }

    /**
     * Este metodo va a recoger los datos de la temporada, tanto la id como el ano en cuestion
     *
     * @param id  id
     * @param ano ano
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

    public ArrayList<Integer> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Integer> partidos) {
        this.partidos = partidos;
    }

    /**
     * Metodo get property de la interfaz itfProperty
     *
     * @param prop prop
     * @return return
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
                throw new PropiedadIncorrecta(prop);
        }
    }

    /**
     * Metodo para cargar los datos de la temporada en el resutlset
     *
     * @param rs rs
     * @throws Exception throws Exception
     */
    @Override
    public void resultsetLoad(ResultSet rs) throws Exception {
        id = rs.getInt(BD_TEMPORADA_ID);
        ano = rs.getDate(BD_TEMPORADA_ANO);

    }
}
