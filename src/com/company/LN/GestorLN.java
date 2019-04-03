package com.company.LN;

import com.company.Excepciones.DorsalRepetidoException;
import com.company.LD.clsDatos;
import com.company.comun.itfProperty;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Clase que va a gestionar la comunicacion entre el paquete LN y el paquete LP
 */
public class GestorLN {

    /**
     * Este va a ser el ArrayList que va a contener los campos de los diferentes equipos
     */
    ArrayList<Campo> campos = new ArrayList<>();
    /**
     * Este va a ser el ArrayList que va a contener los participantes de la liga
     */
    ArrayList<Equipo> equipos = new ArrayList<>();

    /**
     * Este va a ser el ArrayList que va a contener los estados en los que pueda estar un jugador
     */
    ArrayList<Estado> estados = new ArrayList<>();
    /**
     * Este va a ser el ArrayList que va a contener los jugadores de la liga
     */
    ArrayList<Jugador> jugadores = new ArrayList<>();

    /**
     * array que guardara posiciones en memoria
     */
    ArrayList<Posicion> posiciones = new ArrayList<>();
    /**
     * comunicacion con capa de datos en LN
     */
    private clsDatos objDatos = new clsDatos();

    /**
     * Este metodo se va a utilizar para añadir los campos en el Array de los campos
     *
     * @param nombre nombre
     * @param ciudad ciudad
     * @param calle  calle
     * @param numero numero
     * @param cp     cp
     * @param aforo  aforo
     */
    public void anadirCampo(String nombre, String ciudad, String calle, String numero, String cp, int aforo) {
        try {
            objDatos.conectarBD();
            Campo campo = new Campo(nombre, ciudad, calle, numero, cp, aforo);

            campo.setId(objDatos.insertarCampo(nombre, ciudad, calle, numero, cp, aforo));
            campos.add(campo);
            objDatos.desconectarBD();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(campos);

    }


    /**
     * Este metodo lo vamos a emplear para leer los campos de los equipos
     *
     * @return return
     */
    public ArrayList<itfProperty> leerCampos() {
        System.out.println("entro aqui");
        ArrayList<itfProperty> retorno = new ArrayList<>();
        try {

            for (Campo c : campos) {
                retorno.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

    /**
     * Metodo para cargar los datos de los campos de la BD
     */
    public void cargarDatosCampos() throws Exception {
        ResultSet rs = objDatos.buscarCampos();
        while (rs.next()) {
            Campo c = new Campo();
            c.resultsetLoad(rs);
            campos.add(c);
        }

    }

    /**
     * Metodo para añadir equipos al array de equipos
     *
     * @param nombre       nombre
     * @param patrocinador patrocinador
     * @param campo        campo
     */
    public void anadirEquipo(String nombre, String patrocinador, int campo) {
        try {
            objDatos.conectarBD();
            Equipo equipo = new Equipo(nombre, patrocinador);

            equipo.setId(objDatos.insertarEquipo(nombre, patrocinador, campo));
            equipos.add(equipo);
            objDatos.desconectarBD();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * Este metodo lo vamos a emplear para leer los equipos
     *
     * @return return
     */
    public ArrayList<itfProperty> leerEquipos() {
        System.out.println("entro aqui");
        ArrayList<itfProperty> retorno = new ArrayList<>();
        try {

            for (Equipo e : equipos) {
                retorno.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

    /**
     * Metodo para cargar los datos de los quipos previamente introducidos a la BD
     */
    public void cargarDatosEquipos() throws Exception {

        ResultSet rs = objDatos.buscarEquipo();
        while (rs.next()) {

            Equipo e = new Equipo();
            e.resultSetToEquipo(rs);
            equipos.add(e);
        }

    }

    /**
     * Metodo para añadir jugador al array de jugadores
     *
     * @param nombre        nombre
     * @param apellido1     apellido1
     * @param apellido2     apellido2
     * @param fechaNac      fechaNac
     * @param dorsal        dorsal
     * @param textoCamiseta textoCamiseta
     * @param equipo        equipo
     * @param posicion      posicion
     * @param estado        estado
     */
    public void anadirJugador(String nombre, String apellido1, String apellido2, Date fechaNac, String dorsal, String textoCamiseta, int equipo, int posicion, int estado) throws DorsalRepetidoException {

        try {
            objDatos.conectarBD();
            Jugador jugador = new Jugador(nombre, apellido1, apellido2, fechaNac, dorsal, textoCamiseta);

            jugador.setId(objDatos.insertarJugador(nombre, apellido1, apellido2, fechaNac, dorsal, textoCamiseta, equipo, posicion, estado));
            jugadores.add(jugador);

            objDatos.desconectarBD();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo para leer los jugadores
     *
     * @return return
     */
    public ArrayList<itfProperty> leerJugadores() {
        System.out.println("entro aqui");
        ArrayList<itfProperty> retorno = new ArrayList<>();
        try {

            for (Jugador j : jugadores) {
                retorno.add(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public void cargarDatosJugadores() throws Exception {

        ResultSet rs = objDatos.buscarJugador();
        while (rs.next()) {

            Jugador j = new Jugador();
            j.resultSetToJugador(rs);
            jugadores.add(j);
        }

    }

    public void cargarDatosEstados() throws Exception {
        ResultSet rs = objDatos.buscarEstados();
        while (rs.next()) {
            Estado e = new Estado();
            e.resultsetLoad(rs);
            estados.add(e);
        }
    }

    public void cargarDatosPosiciones() throws Exception {
        ResultSet rs = objDatos.buscarPosiciones();
        while (rs.next()) {
            Posicion p = new Posicion();
            p.resultsetLoad(rs);
            posiciones.add(p);
        }


    }
    public void cargarDatosTraspasos() throws Exception{
        ResultSet rs = objDatos.buscarTraspasos();
        while (rs.next()) {
            Posicion p = new Posicion();
            p.resultsetLoad(rs);
            posiciones.add(p);
        }

}


    public void cargarDatos() throws Exception {
        objDatos.conectarBD();
        cargarDatosCampos();
        cargarDatosEquipos();
        cargarDatosEstados();
        cargarDatosJugadores();
        cargarDatosPosiciones();
        cargarDatosTraspasos();
        objDatos.desconectarBD();
    }
}