package com.company.LN.Comparator;

import com.company.LN.Equipo;
import com.company.comun.itfProperty;
import static com.company.comun.clsConstantes.EQUIPO_PARTIDOS_GANADOS;

public class Participantes extends Equipo implements itfProperty {

    private int partidosGanados;




    public Participantes(String nombre,int partidosGanados) {
        super(nombre);
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    @Override
    public Object getProperty(String prop) {
        switch (prop) {
            case EQUIPO_PARTIDOS_GANADOS:return this.partidosGanados;
            default:return null;
        }
    }


}
