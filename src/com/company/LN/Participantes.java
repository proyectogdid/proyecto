package com.company.LN;

import com.company.Excepciones.PropiedadIncorrecta;
import com.company.LN.Equipo;
import com.company.comun.itfPersistable;
import com.company.comun.itfProperty;

import java.sql.ResultSet;

import static com.company.comun.clsConstantes.*;

/**
 * Clase para asignar participantes a la liga. Estos tienen el nombre de los equipos, ademas de nuevos atributos creados.
 */

public class Participantes extends Equipo implements itfProperty , itfPersistable {

    private int partidosGanados;
    private int partidosJugados;
    private int partidosPerdidos;
    private int puntosAFavor;
    private int puntosEnContra;
    private int ptosClasificacion;

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

    public Participantes() {
    }

    public int getPtosClasificacion() {
        return ptosClasificacion;
    }

    public void setPtosClasificacion(int ptosClasificacion) {
        this.ptosClasificacion = ptosClasificacion;
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
            case PARTICIPANTES_PTOS:
                return this.ptosClasificacion;

            default:
                return super.getProperty(prop);
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


    @Override
    public void resultsetLoad(ResultSet rs) throws Exception {
        partidosGanados=rs.getInt("victorias");
        partidosPerdidos=rs.getInt("derrotas");
        this.setNombre(rs.getString("e.nombre"));
        this.ptosClasificacion=partidosGanados*PTOS_VICTORIA;
        this.partidosJugados=partidosGanados+partidosPerdidos;
    }
}
