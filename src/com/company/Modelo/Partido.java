package com.company.Modelo;

import java.util.Date;

public class Partido {
    private int id;
    private Date fecha;
    private int ptosLocal;
    private int ptosVisitante;
    private Equipo local;
    private Equipo visitante;
    private Temporada temporada;
    private Campo campo;

    public Partido() {
    }

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
