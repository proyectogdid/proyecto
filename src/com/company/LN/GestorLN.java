package com.company.LN;

import com.company.Excepciones.DorsalRepetidoException;
import com.company.Excepciones.EquiposInsuficientesException;
import com.company.LD.clsDatos;
import com.company.comun.Utilidades;
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
     * array que guardara las temporadas en memoria
     */
    ArrayList<Temporada> temporadas = new ArrayList<>();
    /**
     * array que guardara los eventos en memoria
     */
    ArrayList<Evento> eventos = new ArrayList<>();
    /**
     * array que guardara los usuarios en memoria
     */
    ArrayList<Usuario> usuarios = new ArrayList<>();
    /**
     * array que guardara los partidos en memoria
     */

    ArrayList<Partido> partidos = new ArrayList<>();
    /**
     * comunicacion con capa de datos en LN
     */
    private clsDatos objDatos = new clsDatos();

    /**
     * metodo que se usará para generar los distintos partidos que tendrá una temporada
     * basado en algoritmo Round Robin
     * https://en.wikipedia.org/wiki/Round-robin_scheduling
     */
    public void generarCalendario(int temporada_) throws EquiposInsuficientesException,Exception {

        final int LOCAL=0;
        final int VISITANTE=1;
        final int FECHA=2;
        final int TEMPORADA=3;
        final int CAMPO=4;
        final int JORNADA=5;
        ArrayList<Equipo> locales=new ArrayList<>();
        ArrayList<Equipo> visitantes=new ArrayList<>();
        int n=equipos.size();
        int npartidos= Utilidades.factorial(n)/(Utilidades.factorial(n-2) *2);
        /*
         n!/(n-2)!*2
         es la formula para saber cuantos partidos habra en una liga
         */
        System.out.println(npartidos);
        Object[][] datos=new Object[npartidos*2][6];//6 es el numero de columnas necesarias que tiene partido

        for (int i = 0; i <equipos.size() ; i++) {
            locales.add(equipos.get(i));
        }

        if(locales.size()%2!=0){
           //aqui habra que mandar una excepcion
            throw new EquiposInsuficientesException();

        }else{
            int jornadas=locales.size()-1;
            int mitad=(locales.size()/2)-1;
            int r=0;
            for(int i=locales.size()-1;i>mitad;i--){
                visitantes.add(locales.get(i));
                locales.remove(i);
            }
            Equipo fijo=locales.get(0);
            locales.remove(0);



            for(int k=0;k<jornadas*2;k++){
                System.out.println("----JORNADA "+(k +1) +"---------- ");

                System.out.println(fijo.getNombre()+"-"+visitantes.get(0).getNombre());

                datos[r][LOCAL]=fijo.getId();
                datos[r][VISITANTE]=visitantes.get(0).getId();
                datos[r][FECHA]=new Date();
                datos[r][TEMPORADA]=temporada_;
                datos[r][CAMPO]=fijo.getCampo();
                datos[r][JORNADA]=k;
                r++;
                for(int x=0;x<locales.size();x++){
                    System.out.println(locales.get(x).getNombre()+"-"+visitantes.get(x+1).getNombre());

                    datos[r][LOCAL]=locales.get(x).getId();
                    datos[r][VISITANTE]=visitantes.get(x).getId();
                    datos[r][FECHA]=new Date();
                    datos[r][TEMPORADA]=temporada_;
                    datos[r][CAMPO]=locales.get(x).getCampo();
                    datos[r][JORNADA]=k;
                    r++;
                }
                locales.add(0,visitantes.get(0));
                visitantes.remove(0);
                visitantes.add(locales.get(locales.size()-1));
                locales.remove(locales.size()-1);
            }
            System.out.println(r);//si contador es igual a n!/(n-2)!*2 es que todo va bien
            ArrayList<Integer>claves= objDatos.insertPartidos(datos);
            for (int i = 0; i <claves.size() ; i++) {
                Partido p=new Partido(claves.get(i),(Date) datos[i][FECHA],(int)datos[i][LOCAL],(int)datos[i][VISITANTE],(int)datos[i][TEMPORADA],(int)datos[i][CAMPO],(int)datos[i][JORNADA]);
                partidos.add(p);
            }

        }
    }
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

    public void  anadirTemporada()throws Exception, EquiposInsuficientesException{
        objDatos.conectarBD();
        Temporada t=new Temporada();
        t.setAno(new Date());
        t.setId(objDatos.insertTemporada(t.getAno()));
        temporadas.add(t);
        //objDatos.desconectarBD();
        generarCalendario(t.getId());
    }

    /**
     * Metodo para añadir equipos al array de equipos
     *  @param nombre       nombre
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
     * Este metodo lo vamos a emplear para leer los estados de los jugadores
     *
     * @return return
     */
    public ArrayList<itfProperty> leerEstados() {

        ArrayList<itfProperty> retorno = new ArrayList<>();
        for (Estado e : estados) {
            retorno.add(e);
        }

        return retorno;
    }

    /**
     * Este metodo lo vamos a emplear para leer las posiciones de un jugador
     *
     * @return return
     */
    public ArrayList<itfProperty> leerPosiciones() {

        ArrayList<itfProperty> retorno = new ArrayList<>();
        for (Posicion e : posiciones) {
            retorno.add(e);
        }

        return retorno;
    }


    /**
     * Este metodo lo vamos a emplear para leer los equipos
     *
     * @return return
     */
    public ArrayList<itfProperty> leerEquipos() {
        System.out.println("entro aqui");
        ArrayList<itfProperty> retorno = new ArrayList<>();
        for (Equipo e : equipos) {
            retorno.add(e);
        }

        return retorno;
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
     * para cargar los datos de los jugadores
     *
     * @throws Exception fallos en la query
     */

    public void cargarDatosJugadores() throws Exception {

        ResultSet rs = objDatos.buscarJugador();
        while (rs.next()) {

            Jugador j = new Jugador();
            j.resultSetToJugador(rs);
            jugadores.add(j);
        }

    }

    /**
     * para cargar los datos de los estados
     *
     * @throws Exception fallos en la query
     */

    public void cargarDatosEstados() throws Exception {
        ResultSet rs = objDatos.buscarEstados();
        while (rs.next()) {
            Estado e = new Estado();
            e.resultsetLoad(rs);
            estados.add(e);
        }
    }

    /**
     * para cargar los datos de las posiciones
     *
     * @throws Exception fallos en la query
     */

    public void cargarDatosPosiciones() throws Exception {
        ResultSet rs = objDatos.buscarPosiciones();
        while (rs.next()) {
            Posicion p = new Posicion();
            p.resultsetLoad(rs);
            posiciones.add(p);
        }


    }

    /**
     * para cargar los datos de los traspasos
     *
     * @throws Exception fallos en la query
     */
    public void cargarDatosTraspasos() throws Exception {
        ResultSet rs = objDatos.buscarTraspasos();
        while (rs.next()) {
            Posicion p = new Posicion();
            p.resultsetLoad(rs);
            posiciones.add(p);
        }

    }

    /**
     * para cargar los datos de las temporadas
     *
     * @throws Exception fallos en la query
     */
    public void cargarDatosTemporadas() throws Exception {
        ResultSet rs = objDatos.buscarTemporadas();
        while (rs.next()) {
            Temporada t = new Temporada();
            t.resultsetLoad(rs);
            temporadas.add(t);
        }
    }

    /**
     * para cargar los datos de los eventos
     *
     * @throws Exception fallos en la query
     */
    public void cargarDatosEventos() throws Exception {
        ResultSet rs = objDatos.buscarEventos();
        while (rs.next()) {
            Evento e = new Evento();
            e.resultsetLoad(rs);
            eventos.add(e);
        }
    }

    /**
     * para cargar los datos de los partidos
     *
     * @throws Exception sql excption
     */
    public void cargarDatosPartidos() throws Exception {
        ResultSet rs = objDatos.buscarPartidos();
        while (rs.next()) {
            Partido e = new Partido();
            e.resultsetLoad(rs);
            partidos.add(e);
        }
    }


    /**
     * Metodo que se va a encargar de cargar los datos de cada una de las "tablas" de nuestra BD
     *
     * @throws Exception fallos en la carga de datos
     */


    public void cargarDatos() throws Exception {
        objDatos.conectarBD();
        cargarDatosCampos();
        cargarDatosEquipos();
        cargarDatosEstados();
        cargarDatosJugadores();
        cargarDatosPosiciones();
        cargarDatosTraspasos();
        cargarDatosTemporadas();
        cargarDatosEventos();
        cargarDatosPartidos();
        objDatos.desconectarBD();
    }
}

