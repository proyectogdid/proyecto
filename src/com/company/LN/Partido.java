package com.company.LN;

import com.company.Excepciones.PropiedadIncorrecta;
import com.company.comun.itfPersistable;
import com.company.comun.itfProperty;

import java.sql.ResultSet;
import java.util.Date;

import static com.company.comun.clsConstantes.*;

/**
 * Clase que va a gestionar los datos principales de
 * un partido, tales como la id, fecha, ptsLocal,
 * ptsVisitante, local, visitante, temporada y campo.
 */
public class Partido implements itfProperty, itfPersistable {
    /**
     * Atributo id del partido
     */
    private int id;
    /**
     * Atributo fecha del partido
     */
    private Date fecha;
    /**
     * Atributo resultado local del partido
     */
    private int ptosLocal;
    /**
     * Atributo resultado visitante del partido
     */
    private int ptosVisitante;
    /**
     * Atributo equipo local del partido
     */
    private int local;
    /**
     * Atributo equipo visitante del partido
     */
    private int visitante;
    /**
     * Atributo temporada del partido
     */
    private int temporada;
    /**
     * Atributo campo del partido
     */
    private int campo;

    /**
     * numero de la jornada
     */
    private int jornada;

    public Partido() {
    }

    /**
     * Metodo que utilizaremos para añadir partidos en la BD
     *
     * @param fecha     fecha
     * @param local     local
     * @param visitante visitante
     * @param temporada temporada
     * @param campo     campo
     */
    public Partido(Date fecha, int local, int visitante, int temporada, int campo) {
        this.fecha = fecha;
        this.local = local;
        this.visitante = visitante;
        this.temporada = temporada;
        this.campo = campo;
    }

    /**
     * Este metodo recogera todos los datos necesarios para conocer al detalle dichos datos de cada partido
     *
     * @param id            id
     * @param fecha         fecha
     * @param ptosLocal     ptosLocal
     * @param ptosVisitante ptosVisitante
     * @param local         local
     * @param visitante     visitantes
     * @param temporada     temporada
     * @param campo         campo
     */
    public Partido(int id, Date fecha, int ptosLocal, int ptosVisitante, int local, int visitante, int temporada, int campo, int jornada) {
        this.id = id;
        this.fecha = fecha;
        this.ptosLocal = ptosLocal;
        this.ptosVisitante = ptosVisitante;
        this.local = local;
        this.visitante = visitante;
        this.temporada = temporada;
        this.campo = campo;
        this.jornada = jornada;
    }

    /**
     * El siguiente constructor sera necesario cuando se registren los partidos,
     * ya que en un inicio no necesitaremos los ptsLocal y ptosVisitante.
     * Una vez que comiencen los partidos ya utilizaremos el constructor de arriba,
     * con todos los atributos
     *
     * @param id        id
     * @param fecha     fecha
     * @param local     local
     * @param visitante visitante
     * @param temporada temporada
     * @param campo     campo
     */

    public Partido(int id, Date fecha, int local, int visitante, int temporada, int campo, int jornada) {
        this.id = id;
        this.fecha = fecha;
        this.local = local;
        this.visitante = visitante;
        this.temporada = temporada;
        this.campo = campo;
        this.jornada = jornada;


    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPtosLocal() {
        return ptosLocal;
    }

    public void setPtosLocal(int ptosLocal) {
        this.ptosLocal = ptosLocal;
    }

    public int getPtosVisitante() {
        return ptosVisitante;
    }

    public void setPtosVisitante(int ptosVisitante) {
        this.ptosVisitante = ptosVisitante;
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public int getVisitante() {
        return visitante;
    }

    public void setVisitante(int visitante) {
        this.visitante = visitante;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getCampo() {
        return campo;
    }

    public void setCampo(int campo) {
        this.campo = campo;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
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
            case PARTIDO_ID:
                return this.id;
            case PARTIDO_FECHA:
                return this.fecha;
            case PARTIDO_PTOS_LOCAL:
                return this.ptosLocal;
            case PARTIDO_PTOS_VISITANTE:
                return this.ptosVisitante;
            case PARTIDO_LOCAL:
                return this.local;
            case PARTIDO_VISITANTE:
                return this.visitante;
            case PARTIDO_TEMPORADA:
                return this.temporada;
            case PARTIDO_CAMPO:
                return this.campo;
            case PARTIDO_JORNADA:
                return this.jornada;
            default:
                throw new PropiedadIncorrecta(prop);
        }
    }

    /**
     * Metodo para cargar los datos de los partidos en el resultset
     *
     * @param rs rs
     * @throws Exception throws Exception
     */
    @Override
    public void resultsetLoad(ResultSet rs) throws Exception {
        id = rs.getInt(BD_PARTIDO_ID);
        fecha = rs.getDate(BD_PARTIDO_FECHA);
        ptosLocal = rs.getInt(BD_PARTIDO_PTOS_LOCAL);
        ptosVisitante = rs.getInt(BD_PARTIDO_PTOS_VISITANTE);
        local = rs.getInt(BD_PARTIDO_LOCAL);
        visitante = rs.getInt(BD_PARTIDO_VISITANTE);
        jornada=rs.getInt(BD_PARTIDO_JORNADA);
    }
}
