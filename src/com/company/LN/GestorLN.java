package com.company.LN;

import com.company.Excepciones.EquiposInsuficientesException;
import com.company.LD.clsDatos;

import com.company.comun.Utilidades;
import com.company.comun.itfProperty;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static com.company.comun.clsConstantes.*;

/**
 * Clase que va a gestionar la comunicacion entre el paquete LN y el paquete LP
 */
public class GestorLN {
    /**
     * objeto con los datos del usuario logeado
     */
    Usuario logeado;
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
     * array que guardara los traspsos en memoria
     */
    ArrayList<Traspaso> traspasos = new ArrayList<>();
    /**
     * array que guardara los usuarios en memoria
     */
    ArrayList<Usuario> usuarios = new ArrayList<>();

    //ArrayList<ArrayList<Partido>> partidos=new ArrayList<>();
    /**
     * array que guardara los partidos en memoria
     */

    ArrayList<Partido> partidos = new ArrayList<>();
    /**
     * array que guarda los participantes en memoria
     */
    ArrayList<Participantes> participantes = new ArrayList<>();
    /**
     * comunicacion con capa de datos en LN
     */

    ArrayList<Noticia> noticias = new ArrayList<>();
    private clsDatos objDatos = new clsDatos();


    /**
     * Metodo que se usará para generar los distintos partidos que tendrá una temporada
     * basado en algoritmo Round Robin
     * https://en.wikipedia.org/wiki/Round-robin_scheduling
     */
    public void generarCalendario(int temporada_) throws EquiposInsuficientesException, Exception {

        final int LOCAL = 0;
        final int VISITANTE = 1;
        final int FECHA = 2;
        final int TEMPORADA = 3;
        final int CAMPO = 4;
        final int JORNADA = 5;
        ArrayList<Equipo> locales = new ArrayList<>();
        ArrayList<Equipo> visitantes = new ArrayList<>();
        int n = equipos.size();
        int npartidos = Utilidades.factorial(n) / (Utilidades.factorial(n - 2) * 2);
        /*
         n!/(n-2)!*2
         es la formula para saber cuantos partidos habra en una liga
         */
        Object[][] datos = new Object[npartidos * 2][6];//6 es el numero de columnas necesarias que tiene partido

        for (int i = 0; i < equipos.size(); i++) {
            locales.add(equipos.get(i));
        }

        if (locales.size() % 2 != 0) {
            //aqui habra que mandar una excepcion
            throw new EquiposInsuficientesException();

        } else {
            int jornadas = locales.size() - 1;
            int mitad = (locales.size() / 2) - 1;
            int r = 0;
            for (int i = locales.size() - 1; i > mitad; i--) {
                visitantes.add(locales.get(i));
                locales.remove(i);
            }
            Equipo fijo = locales.get(0);
            locales.remove(0);


            for (int k = 0; k < jornadas * 2; k++) {
                datos[r][LOCAL] = fijo.getId();
                datos[r][VISITANTE] = visitantes.get(0).getId();
                datos[r][FECHA] = new Date();
                datos[r][TEMPORADA] = temporada_;
                datos[r][CAMPO] = fijo.getCampo();
                datos[r][JORNADA] = k;
                r++;
                for (int x = 0; x < locales.size(); x++) {

                    datos[r][LOCAL] = locales.get(x).getId();
                    datos[r][VISITANTE] = visitantes.get(x).getId();
                    datos[r][FECHA] = new Date();
                    datos[r][TEMPORADA] = temporada_;
                    datos[r][CAMPO] = locales.get(x).getCampo();
                    datos[r][JORNADA] = k;
                    r++;
                }
                locales.add(0, visitantes.get(0));
                visitantes.remove(0);
                visitantes.add(locales.get(locales.size() - 1));
                locales.remove(locales.size() - 1);
            }
            //si contador es igual a n!/(n-2)!*2 es que todo va bien
            ArrayList<Integer> claves = objDatos.insertPartidos(datos);
            for (int i = 0; i < claves.size(); i++) {
                Partido p = new Partido(claves.get(i), (Date) datos[i][FECHA], (int) datos[i][LOCAL], (int) datos[i][VISITANTE], (int) datos[i][TEMPORADA], (int) datos[i][CAMPO], (int) datos[i][JORNADA]);
                partidos.add(p);
            }

        }
    }

    /**
     * Metodo para registrar un nuevo usuario
     * @param usuario nombre de usuaario
     * @param passw   contrsensa
     * @param equipo  equipo favorito del usuario
     * @param correo  correo del usuario
     * @return id
     * @throws Exception SQLException
     */
    public void registrarUsuario(String usuario, String passw, int equipo, String correo) throws Exception {
        objDatos.conectarBD();
        int id = objDatos.insertarUsuario(usuario, passw, equipo, USUARIO_TIPO_AFICIONADO, correo);//todos los usuarios que se registren seran aficionados, los admins los dara de alta un admin de sistemas
        Aficionado a = new Aficionado(id, usuario, passw, correo, USUARIO_TIPO_AFICIONADO, equipo);
        logeado = a;//entra directamente logrado
        objDatos.desconectarBD();
    }

    /**
     * Metodo para actualizar el usuario de la BD
     *
     * @param id
     * @throws Exception
     */
    public void updateUsuario(int id) throws Exception {
        if (!isAdmin()) {
            objDatos.conectarBD();
            ((Aficionado) logeado).setFavorito(id);
            id = objDatos.updateUsuario(id, logeado.getId());

            objDatos.desconectarBD();
        }


    }

    /**
     * Metodo para actualizar el partido de la BD
     *
     *
     * @throws Exception
     */
    public void updatePartido(itfProperty partido, int local,int visitante) throws Exception {
    		if(partido instanceof Partido) {
    			Partido p=(Partido) partido;
    			objDatos.conectarBD();
    			p.setPtosLocal(local);
    			p.setVisitante(visitante);
    			objDatos.actualizarPartido(p.getId(), local, visitante);
    			objDatos.desconectarBD();
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

    /**
     * Metodo para anadir la temporada a la BD
     *
     * @throws Exception Exception
     * @throws EquiposInsuficientesException si no hay equipos suficientes no se generara el calendario de la temporada
     */
    public void anadirTemporada() throws Exception, EquiposInsuficientesException {
        objDatos.conectarBD();
        Temporada t = new Temporada();
        t.setAno(new Date());
        t.setId(objDatos.insertTemporada(t.getAno()));
        temporadas.add(t);
        //objDatos.desconectarBD();
        generarCalendario(t.getId());
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
    public void anadirJugador(String nombre, String apellido1, String apellido2, Date fechaNac, String dorsal, String textoCamiseta, int equipo, int posicion, int estado) throws Exception {


        objDatos.conectarBD();
        Jugador jugador = new Jugador(nombre, apellido1, apellido2, fechaNac, dorsal, textoCamiseta);

        jugador.setId(objDatos.insertarJugador(nombre, apellido1, apellido2, fechaNac, dorsal, textoCamiseta, equipo, posicion, estado));
        jugadores.add(jugador);

        objDatos.desconectarBD();


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

     * @param estado        estado
     */
    public void actualizarJugador(itfProperty jugador,String nombre, String apellido1, String apellido2, Date fechaNac, String dorsal, String textoCamiseta, int equipo, int estado) throws Exception {

    if(jugador instanceof  Jugador) {
        objDatos.conectarBD();
        Jugador j = (Jugador) jugador;
        j.setApellido1(apellido1);
        j.setApellido2(apellido2);
        j.setNombre(nombre);
        j.setDorsal(dorsal);
        j.setFechaNac(fechaNac);
        j.setTextoCamiseta(textoCamiseta);
        j.setEquipo(equipo);

        j.setEstado(estado);
       objDatos.actualizarJugador(nombre, apellido1, apellido2, fechaNac, dorsal, textoCamiseta, equipo, estado,j.getId());


        objDatos.desconectarBD();
    }

    }



    /**
     * metodo para borrar jugador de memoria y bd
     * @param jugador jugadoritfprop
     * @throws Exception excepcion
     */
    public void borrarJugador(itfProperty jugador) throws Exception {
        System.out.println(jugador.getProperty(JUGADOR_NOMBRE));
        if( jugadores.remove(jugador)){
            objDatos.conectarBD();
            objDatos.borrarJugador((int)jugador.getProperty(JUGADOR_ID));
            objDatos.desconectarBD();
        }
    }

    /**
     * Este metodo lo vamos a emplear para introducir las posiciones en la BD
     *
     * @param nombre nombre
     * @throws Exception exception
     */
    public void anadirPosicion(String nombre) throws Exception {

        objDatos.conectarBD();
        Posicion posicion = new Posicion(nombre);

        posicion.setId(objDatos.insertarPosicion(nombre));
        posiciones.add(posicion);

        objDatos.desconectarBD();


    }

    /**
     * Metodo para introducir los estados en la BD
     *
     * @param nombre nombre
     * @throws Exception excepcion
     */
    public void anadirEstado(String nombre) throws Exception {

        objDatos.conectarBD();
        Estado estado = new Estado(nombre);

        estado.setId(objDatos.insertarEstado(nombre));
        estados.add(estado);

        objDatos.desconectarBD();


    }

    /**
     * Metodo para devolver las noticias a LP ordenadas por fecha
     *
     * @return array itfProperty
     */
    public ArrayList<itfProperty> leerNoticias() {
        Collections.sort(noticias);
        ArrayList<itfProperty> retorno = new ArrayList<>();
        for (Noticia n : noticias) {
            retorno.add(n);
        }
        return retorno;
    }

    /**
     * metodo para devolver los partidos especificos de una jornada

     * @return array itfProperty
     */
    public ArrayList<itfProperty> leerJornadas(){
        ArrayList<itfProperty> retorno=new ArrayList<>();
        for (Partido p:partidos) {

                retorno.add(p);


        }
        return retorno;
    }

    /**
     * Este metodo lo vamos a emplear para leer los campos de los equipos
     *
     * @return return
     */
    public ArrayList<itfProperty> leerCampos() {

        ArrayList<itfProperty> retorno = new ArrayList<>();


        for (Campo c : campos) {
            retorno.add(c);
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
     * Este metodo lo vamos a emplear para leer la clasificacion de la liga
     *
     * @return return
     */
    public ArrayList<itfProperty> leerClasificacion() {

        ArrayList<itfProperty> retorno = new ArrayList<>();
        for (Participantes e : participantes) {
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
     * Metodo para cargar los datos de los jugadores
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
     * Metodo para cargar los datos de los estados
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
     * Metodo para cargar los datos de las posiciones
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
     * Metodo para cargar los datos de los traspasos
     *
     * @throws Exception fallos en la query
     */
    public void cargarDatosTraspasos() throws Exception {
        ResultSet rs = objDatos.buscarTraspasos();
        while (rs.next()) {
            Traspaso p = new Traspaso();
            p.resultsetLoad(rs);
            p.generarTexto(jugadores, equipos);
            traspasos.add(p);
            noticias.add(p);
        }

    }

    /**
     * Metodo para cargar los datos de las temporadas
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
     * Metodo para cargar los datos de los eventos
     *
     * @throws Exception fallos en la query
     */
    public void cargarDatosEventos() throws Exception {
        ResultSet rs = objDatos.buscarEventos();
        while (rs.next()) {
            Evento e = new Evento();
            e.resultsetLoad(rs);
            e.generarTexto(jugadores, estados);
            eventos.add(e);
            noticias.add(e);
        }
    }

    /**
     * Metodo para cargar los datos de los partidos
     *
     * @throws Exception sql excption
     */
    public void cargarDatosPartidos() throws Exception {
        ResultSet rs = objDatos.buscarPartidos();
        while (rs.next()) {
            Partido e = new Partido();
            e.resultsetLoad(rs);
            e.generarTexto(equipos);
            partidos.add(e);
        }
    }

    /**
     * Metodo para cargar los datos de los resultados de los partidos
     *
     * @throws Exception sql excption
     */
    public void cargarClasificacion() throws Exception {
        ResultSet rs = objDatos.buscarEstadisticas();
        while (rs.next()) {
            Participantes e = new Participantes();
            e.resultsetLoad(rs);
            participantes.add(e);
        }
        ordenarClasificacion();
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
        cargarDatosPosiciones();
        cargarClasificacion();
        objDatos.desconectarBD();
    }

    /**
     * Metodo para ordenar la clasificacion de los participantes
     */
    public void ordenarClasificacion() {
        Clasificacion c = new Clasificacion();
        Collections.sort(participantes, c);


    }

    /**
     * @return boolean para saber si es admin el usuario logeado
     */
    public boolean isAdmin() {
        return logeado.isAdmin();
    }

    /**
     * Metodo para saber cual es el equipo favorito del usuario logeado
     *
     * @return idequipo
     */
    public itfProperty getEquipoFav() {
        if (logeado instanceof Aficionado) {

            int favorito = ((Aficionado) logeado).getFavorito();
            for (Equipo e : equipos) {
                if (e.getId() == favorito) {
                    return e;
                }
            }


        }
        return null;

    }

    /**
     * metodo para logearse
     * @param username usuario
     * @param password contrasena
     * @return se ha encontrado usuario o no
     * @throws Exception excepcion
     */
    public boolean login(String username, String password) throws Exception {
        objDatos.conectarBD();
        ResultSet rs = objDatos.login(username, password);
        if (rs.next()) {
            if (rs.getString(BD_USUARIO_TIPO).equals(USUARIO_TIPO_AFICIONADO)) {
                logeado = new Aficionado();
            } else {
                logeado = new Usuario();
            }
            logeado.resultsetLoad(rs);
            objDatos.desconectarBD();

            return true;
        } else {
            objDatos.desconectarBD();
            return false;
        }
    }

    /**
     * devuelve los datos del usuario logeado
     * @return usuario logeado
     */
    public itfProperty getLogeado(){
        return logeado;
    }
}

