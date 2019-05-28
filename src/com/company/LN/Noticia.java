package com.company.LN;

import com.company.Excepciones.PropiedadIncorrecta;
import com.company.comun.itfProperty;

import java.util.Date;

import static com.company.comun.clsConstantes.*;

public  class Noticia implements itfProperty,Comparable<Noticia> {
    private Date fecha;
    private String text;
    private int equipoRelativo;

    public int getEquipoRelativo() {
        return equipoRelativo;
    }

    public void setEquipoRelativo(int equipoRelativo) {
        this.equipoRelativo = equipoRelativo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getFecha() {

        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    @Override
    public int compareTo(Noticia o) {

        return -fecha.compareTo(o.getFecha());
    }

    @Override
    public Object getProperty(String prop) {
        switch (prop){
            case NOTICIA_FECHA :
                return this.fecha;
            case NOTICIA_TEXTO:
                return this.text;
            case NOTICIA_EQUIPO_RELATIVO:
                return this.equipoRelativo;
                default:
                    throw new PropiedadIncorrecta(prop);
        }

    }

    @Override
    public String toString() {
        return this.text;
    }
}
