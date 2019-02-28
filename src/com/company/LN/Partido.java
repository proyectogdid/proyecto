package com.company.LN;

import java.util.Date;

/**
 * Clase que va a gestionar los datos principales de
 * un partido, tales como la id, fecha, ptsLocal,
 * ptsVisitante, local, visitante, temporada y campo.
 */
public class Partido {
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
    private Equipo local;
    /**
     * Atributo equi`po visitante del partido
     */
    private Equipo visitante;
    /**
     * Atributo temporada del partido
     */
    private Temporada temporada;
    /**
     * Atributo campo del partido
     */
    private Campo campo;

    public Partido() {
    }

    /**
     * Este método recogerá todos los datos necesarios para conocer al detalle dichos datos de cada partido
     *
     * @param id
     * @param fecha
     * @param ptosLocal
     * @param ptosVisitante
     * @param local
     * @param visitante
     * @param temporada
     * @param campo
     */
    public Partido(int id, Date fecha, int ptosLocal, int ptosVisitante, Equipo local, Equipo visitante, Temporada temporada, Campo campo) {
        this.id = id;
        this.fecha = fecha;
        this.ptosLocal = ptosLocal;
        this.ptosVisitante = ptosVisitante;
        this.local = local;
        this.visitante = visitante;
        this.temporada = temporada;
        this.campo = campo;
    }

    /**
     * El siguiente constructor será necesario cuando se registren los partidos,
     * ya que en un inicio no necesitaremos los ptsLocal y ptosVisitante.
     * Una vez que comiencen los partidos ya utilizaremos el constructor de arriba,
     * con todos los atributos
     *
     * @param id
     * @param fecha
     * @param local
     * @param visitante
     * @param temporada
     * @param campo
     */

    public Partido(int id, Date fecha, Equipo local, Equipo visitante, Temporada temporada, Campo campo) {
        this.id = id;
        this.fecha = fecha;
        this.local = local;
        this.visitante = visitante;
        this.temporada = temporada;
        this.campo = campo;
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

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }
}
