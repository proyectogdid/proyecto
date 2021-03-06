package com.company.LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import static com.company.LD.constantesBD.*;

/**
 * Clase encargada de gestionar comunicacion entre LD y LN
 */
public class clsDatos {
    /**
     * Atributo de conexion con la BBDD
     */
    private Connection con;


    /**
     * Metodo empleado para conectarnos con la BD
     *
     * @throws SQLException throws Exception
     */
    public void conectarBD() throws SQLException {
        //Ruta de la base de datos (jdbc:mysql://localhost:3306/alumnoBD?useTimezone=true&serverTimezone=GMT&useSSL=false)
        String url = "jdbc:mysql://" + DIRECCION + ":" + PUERTO + "/" + NAME + "?useTimezone=true&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";
        con = DriverManager.getConnection(url, USUARIO, PASS);

    }

    /**
     * Metodo para desconectarnos de la BD
     *
     * @throws SQLException throws SQLException
     */
    public void desconectarBD() throws SQLException {
        con.close();
    }

    /**
     * Metodo para insertar un nuevo campo
     *
     * @param nombre nombre
     * @param ciudad ciudad
     * @param calle  calle
     * @param numero numero
     * @param cp     cp
     * @param aforo  aforo
     * @return devuelve el id que tenga en BD
     * @throws Exception fallos en la query
     */
    public int insertarCampo(String nombre, String ciudad, String calle, String numero, String cp, int aforo) throws Exception {
        return CampoBD.insertar(con, nombre, ciudad, calle, numero, cp, aforo);
    }
    
    public int actualizarPartido(int idPartido,int ptosLocal, int ptosVisitante) throws Exception {
    	Object[] datos= {ptosLocal,ptosVisitante,idPartido};
    	return PartidoBD.actualizarPartido(con,datos);
    }

    /**
     * Metedo para buscar campos
     *
     * @return resultset campos
     * @throws Exception fallos en la query
     */
    public ResultSet buscarCampos() throws Exception {
        return CampoBD.getAll(con);

    }


    /**
     * Metodo para insertar usuario en BD
     *
     * @param usuario nombre de usuaario
     * @param passw   contrsensa
     * @param equipo  equipo favorito del usuario
     * @param tipo    tipo de usuario
     * @param correo  correo del usuario
     * @return id
     * @throws Exception SQLException
     */
    public int insertarUsuario(String usuario, String passw, int equipo, String tipo, String correo) throws Exception {
        return UsuarioBD.registrarUsuario(con, usuario, passw, equipo, tipo, correo);
    }

    /**
     * Metodo para insertar un nuevo Equipo
     *
     * @param nombre       nombre
     * @param patrocinador patrocinador
     * @param campo        campo
     * @return return
     * @throws Exception fallos en la query
     */
    public int insertarEquipo(String nombre, String patrocinador, int campo) throws Exception {
        return EquipoBD.insertarEquipo(con, nombre, patrocinador, campo);
    }

    /**
     * Metodo para actualizar los usuarios
     *
     * @param id id
     * @return return
     * @throws Exception Exception
     */
    public int updateUsuario(int id, int iduser) throws Exception {
        return UsuarioBD.updateUsuario(con, id, iduser);
    }

    /**
     * Metodo para buscar equipos
     *
     * @return resultset equipos
     * @throws Exception fallos en la query
     */
    public ResultSet buscarEquipo() throws Exception {
        return EquipoBD.getAll(con);
    }

    /**
     * Metodo para insertar jugadores a la BD
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
     * @return return
     * @throws Exception fallos en la query
     */

    public int insertarJugador(String nombre, String apellido1, String apellido2, java.util.Date fechaNac, String dorsal, String textoCamiseta, int equipo, int posicion, int estado) throws Exception {
        return JugadorBD.insertar(con, nombre, apellido1, apellido2, fechaNac, dorsal, textoCamiseta, equipo, estado, posicion);
    }

    /**
     * Metodo para actualizar jugadores a la BD
     *
     * @param nombre        nombre
     * @param apellido1     apellido1
     * @param apellido2     apellido2
     * @param fechaNac      fechaNac
     * @param dorsal        dorsal
     * @param textoCamiseta textoCamiseta
     * @param equipo        equipo

     * @param estado        estado
     * @return return
     * @throws Exception fallos en la query
     */
    public int actualizarJugador(String nombre, String apellido1, String apellido2, java.util.Date fechaNac, String dorsal, String textoCamiseta, int equipo, int estado,int id) throws Exception {
        return JugadorBD.actualizar(con, nombre, apellido1, apellido2, fechaNac, dorsal, textoCamiseta, equipo, estado,id);
    }


    /**
     * Metodo para insertar nueva temporada
     *
     * @param ano date de la temporada
     * @return id
     * @throws Exception sql exception
     */
    public int insertTemporada(Date ano) throws Exception {
        return TemporadaBD.insertTemporada(con, ano);
    }

    /**
     * Metodo para insertar partidos de la temporada
     *
     * @param datos matriz de datos
     * @return ids
     * @throws Exception SQL exception
     */
    public ArrayList<Integer> insertPartidos(Object[][] datos) throws Exception {
        return PartidoBD.insertarPartidos(con, datos);
    }

    /**
     * Metodo para insertar posiciones de los jugadores
     *
     * @param nombre nombre
     * @return return
     * @throws Exception Excepcion
     */
    public int insertarPosicion(String nombre) throws Exception {
        return PosicionBD.insertarPosicion(con, nombre);
    }

    /**
     * Metodo para insertar los estados de los jugadores
     *
     * @param nombre nombre
     * @return return
     * @throws Exception excepcion
     */
    public int insertarEstado(String nombre) throws Exception {
        return EstadoBD.insertarEstado(con, nombre);
    }

    /**
     * Metodo para gestionar el select de jugadores
     *
     * @return resultset jugadores
     * @throws Exception fallos en la query
     */
    public ResultSet buscarJugador() throws Exception {
        return JugadorBD.getAll(con);
    }

    /**
     * metodo para eliminar jugadores
     * @param id idjugadore
     * @return numfilas
     * @throws Exception sql
     */
    public int borrarJugador(int id)throws Exception{
        return JugadorBD.borrarJugador(con,id);
    }
    /**
     * gestionar select de estados
     *
     * @return resultset estados
     * @throws Exception fallos en la query
     */
    public ResultSet buscarEstados() throws Exception {
        return EstadoBD.getAll(con);
    }

    /**
     * Metodo para gestionar la carga de posiciones
     *
     * @return resultset posiciones
     * @throws Exception fallos de la query
     */
    public ResultSet buscarPosiciones() throws Exception {
        return PosicionBD.getAll(con);
    }

    /**
     * Metodo para gestionar la carga de traspasos
     *
     * @return resultset traspasos
     * @throws Exception fallos de la query
     */
    public ResultSet buscarTraspasos() throws Exception {
        return TraspasoBD.getAll(con);
    }

    /**
     * Metodo para gestionar la carga de temporadas
     *
     * @return resultset temporadas
     * @throws Exception fallos de la query
     */
    public ResultSet buscarTemporadas() throws Exception {
        return TemporadaBD.getAll(con);
    }

    /**
     * Metodo para gestionar la carga de los eventos
     *
     * @return resultset eventos
     * @throws Exception fallos en la query
     */
    public ResultSet buscarEventos() throws Exception {
        return EventoBD.getAll(con);
    }

    /**
     * Metodo para gestionar la carga de los partidos
     *
     * @return resultset partidos
     * @throws Exception fallos en la query
     */
    public ResultSet buscarPartidos() throws Exception {
        return PartidoBD.getAll(con);
    }

    /**
     * Metodo para gestionar la carga de los eventos
     *
     * @return resultset victorias, empates y derrotas
     * @throws Exception fallos en la query
     */
    public ResultSet buscarEstadisticas() throws Exception {
        return ClasificacionBD.cargarClasificacion(con);
    }

    /**
     * Metodo para recuperar el usuario logeado
     *
     * @param username username
     * @param passw    passw
     * @return return
     * @throws Exception Exception
     */
    public ResultSet login(String username, String passw) throws Exception {
        return UsuarioBD.getLogin(con, username, passw);
    }
}
