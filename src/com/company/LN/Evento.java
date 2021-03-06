package com.company.LN;

import com.company.comun.itfPersistable;
import com.company.comun.itfProperty;

import java.sql.ResultSet;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.*;


/**
 * Esta clase va a gestionar los diferentes eventos o noticias
 * referidas a los jugadores. En concreto, en que estado se
 * encuentran tanto previamente como posteriormente.
 */
public class Evento extends Noticia implements itfProperty, itfPersistable{
    /**
     * Atributo id del evento
     */
    private int id;
    /**
     * Atributo jugador dek evento
     */
    private int jugador;
    /**
     * Atributo estado previo del evento
     */
    private int estadoPrevio;
    /**
     * Atributo estado posterior del evento
     */
    private int estadoPosterior;

    public Evento() {
    }
    /**
     * metodo que generara el texto que se mostrará al mostrar la noticia
     * @param jugadores array jugadores
     * @param estados array equipos
     */


    public void generarTexto(ArrayList<Jugador> jugadores, ArrayList<Estado>estados) {
        Jugador j=null;
        for (int i = 0; i <jugadores.size() ; i++) {
            if(jugadores.get(i).getId()==this.jugador){
                j=jugadores.get(i);
                break;
            }
        }
        Estado previo=null,post = null;
        int cont=0;
        for (int i = 0; i <estados.size() && cont<2 ; i++) {
            if(estados.get(i).getId()==this.estadoPrevio){
                previo=estados.get(i);
                cont++;

            }
            if(estados.get(i).getId()==this.estadoPosterior){
                post=estados.get(i);
                cont++;
            }
        }

        this.setText(j.getNombre()+" "+j.getApellido1()+"  pasa de estar "+previo.getNombre()+" a "+post.getNombre());

    }
    /**
     * Este metodo sirve para recoger todos los datos referentes a evento.
     *
     * @param id              id
     * @param jugador         jugador
     * @param estadoPrevio    estadoPRevio
     * @param estadoPosterior estadoPosterior
     */
    public Evento(int id, int jugador, int estadoPrevio, int estadoPosterior) {
        this.id = id;
        this.jugador = jugador;
        this.estadoPrevio = estadoPrevio;
        this.estadoPosterior = estadoPosterior;
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

    public int getEstadoPrevio() {
        return estadoPrevio;
    }

    public void setEstadoPrevio(int estadoPrevio) {
        this.estadoPrevio = estadoPrevio;
    }

    public int getEstadoPosterior() {
        return estadoPosterior;
    }

    public void setEstadoPosterior(int estadoPosterior) {
        this.estadoPosterior = estadoPosterior;
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
            case EVENTO_ID:
                return this.id;
            case EVENTO_ESTADO_PREVIO:
                return this.estadoPrevio;
            case EVENTO_ESTADO_POSTERIOR:
                return this.estadoPosterior;
            case EVENTO_JUGADOR:
                return this.jugador;
            case NOTICIA_TIPO:
                return NOTICIA_TIPO_EVENTO;
            default:
              return  super.getProperty(prop);
        }
    }

    /**
     * Metodo para cargar los datos de los eventos en el resultset
     *
     * @param rs rs
     * @throws Exception throws Exception
     */
    @Override
    public void resultsetLoad(ResultSet rs) throws Exception {
        id = rs.getInt(BD_EVENTO_ID);
        estadoPrevio = rs.getInt(BD_EVENTO_ESTADO_PREVIO);
        estadoPosterior = rs.getInt(BD_EVENTO_ESTADO_POSTERIOR);
        jugador = rs.getInt(BD_EVENTO_JUGADOR);
        this.setFecha(rs.getDate(BD_EVENTO_FECHA));
        this.setEquipoRelativo(jugador);

    }
}

