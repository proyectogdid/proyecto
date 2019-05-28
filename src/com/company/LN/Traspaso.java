package com.company.LN;

import com.company.Excepciones.PropiedadIncorrecta;
import com.company.comun.itfPersistable;
import com.company.comun.itfProperty;

import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.*;

/**
 * clase que gestionara los traspasos de los jugadores entre distintos equipos
 * teniendo como atributos el equipo anterior y posterior para poder guardar un historico de la trayectoria
 */
public class Traspaso extends Noticia implements itfProperty, itfPersistable {
    /**
     * atributo id del traspaso
     */
    private int id;

    /**
     * atributo que especifica el jugador objeto del traspaso
     */
    private int jugador;
    /**
     * equipo que traspasa al jugador
     */
    private int equipoPrevio;
    /**
     * equipo que ficha al jugador
     */
    private int equipoPosterior;

    /**
     * metodo que generara el texto que se mostrará al mostrar la noticia
     * @param jugadores array jugadores
     * @param equipos array equipos
     */
    public void generarTexto(ArrayList<Jugador> jugadores, ArrayList<Equipo>equipos) {
        Jugador j=null;
        for (int i = 0; i <jugadores.size() ; i++) {
            if(jugadores.get(i).getId()==this.jugador){
                j=jugadores.get(i);
                break;
            }
        }
        Equipo previo=null,post = null;
        int cont=0;
        for (int i = 0; i <equipos.size() && cont<2 ; i++) {
            if(equipos.get(i).getId()==this.equipoPrevio){
                previo=equipos.get(i);
                cont++;

            }
            if(equipos.get(i).getId()==this.equipoPosterior){
                post=equipos.get(i);
                cont++;
            }
        }

        this.setText(j.getNombre()+" "+j.getApellido1()+"  ficha por el "+post.getNombre()+" desde el "+previo.getNombre());

    }

    /**
     * Este metodo va a recoger los datos de todos los traspasos que se vayan reslizando
     *
     * @param id              id
     * @param jugador         jugador
     * @param equipoPrevio    equipoPRevio
     * @param equipoPosterior equipoPosterior
     */
    public Traspaso(int id, int jugador, int equipoPrevio, int equipoPosterior) {
        this.id = id;

        this.jugador = jugador;
        this.equipoPrevio = equipoPrevio;
        this.equipoPosterior = equipoPosterior;
    }

    public Traspaso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    public int getEquipoPrevio() {
        return equipoPrevio;
    }

    public void setEquipoPrevio(int equipoPrevio) {
        this.equipoPrevio = equipoPrevio;
    }

    public int getEquipoPosterior() {
        return equipoPosterior;
    }

    public void setEquipoPosterior(int equipoPosterior) {
        this.equipoPosterior = equipoPosterior;
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
            case TRASPASO_ID:
                return this.id;

            case TRASPASO_JUGADOR:
                return this.jugador;
            case TRASPASO_EQUIPO_PREVIO:
                return this.equipoPrevio;
            case TRASPASO_EQUIPO_POSTERIOR:
                return this.equipoPosterior;
            case NOTICIA_TIPO:
                return NOTICIA_TIPO_TRASPASO;
            default:

                return super.getProperty(prop);
        }
    }

    /**
     * MEtodo para cargar los traspasos en el resultset
     *
     * @param rs rs
     * @throws Exception throws Exception
     */
    @Override
    public void resultsetLoad(ResultSet rs) throws Exception {
        id = rs.getInt(BD_TRASPASO_ID);
        jugador = rs.getInt(BD_TRASPASO_JUGADOR);
        this.setFecha(rs.getDate(BD_TRASPASO_FECHA));
        equipoPrevio = rs.getInt(BD_TRASPASO_EQUIPO_PREVIO);
        equipoPosterior = rs.getInt(BD_TRASPASO_EQUIPO_POSTERIOR);
        this.setEquipoRelativo(equipoPosterior);

    }
}
