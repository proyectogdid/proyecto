package com.company.LN;

import java.util.Date;

public abstract class Noticia {
    private Date fecha;

    public Date getFecha() {

        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
