package com.company.comun;

import com.company.LN.Equipo;

import static com.company.comun.clsConstantes.*;

/**
 * Clase para asignar participantes a la liga. Estos tienen el nombre de los equipos, ademas de nuevos atributos creados.
 */

public class Participantes extends Equipo implements itfProperty {

    private int partidosGanados;
    private int partidosJugados;
    private int partidosPerdidos;
    private int puntosAFavor;
    private int puntosEnContra;

    /**
     * Este metodo recogerá todos los datos necesarios para identificar los diferentes participantes.
     *
     * @param nombre           nombre
     * @param patrocinador     patrocinador
     * @param partidosGanados  partidosGanados
     * @param partidosJugados  partidosJugados
     * @param partidosPerdidos partidosPerdidos
     * @param puntosAFavor     puntosAFavor
     * @param puntosEnContra   puntosEnContra
     */

    public Participantes(String nombre, String patrocinador, int partidosGanados, int partidosJugados, int partidosPerdidos, int puntosAFavor, int puntosEnContra) {
        super(nombre, patrocinador);
        this.partidosGanados = partidosGanados;
        this.partidosJugados = partidosJugados;
        this.partidosPerdidos = partidosPerdidos;
        this.puntosAFavor = puntosAFavor;
        this.puntosEnContra = puntosEnContra;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getPuntosAFavor() {
        return puntosAFavor;
    }

    public void setPuntosAFavor(int puntosAFavor) {
        this.puntosAFavor = puntosAFavor;
    }

    public int getPuntosEnContra() {
        return puntosEnContra;
    }

    public void setPuntosEnContra(int puntosEnContra) {
        this.puntosEnContra = puntosEnContra;
    }

    /**
     * Metodo getproperty de la interfaz itfProperty
     *
     * @param prop prop
     * @return return
     */

    @Override
    public Object getProperty(String prop) {
        switch (prop) {
            case PARTICIPANTES_PARTIDOS_GANADOS:
                return this.partidosGanados;
            case PARTICIPANTES_PARTIDOS_JUGADOS:
                return this.partidosJugados;
            case PARTICIPANTES_PARTIDOS_PERDIDOS:
                return this.partidosPerdidos;
            case PARTICIPANTES_PUNTOS_A_FAVOR:
                return this.puntosAFavor;
            case PARTICIPANTES_PUNTOS_EN_CONTRA:
                return this.puntosEnContra;
            default:
                throw new RuntimeException();
        }
    }

    /**
     * Metodo para mostrar los datos de los participantes.
     *
     * @return return
     */
    @Override
    public String toString() {
        return getNombre() + "" + partidosJugados + "" + partidosGanados + "" + partidosPerdidos + "" + puntosAFavor + "" + puntosEnContra + "\n";
    }


}
