package com.company.LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.LD.constantesBD.*;

/**
 * clase encargada de gestionar comunicacion entre LD y LN
 */
public class clsDatos {
    /**
     * atributo de conexion con la BBDD
     */
    private Connection con;


    /**
     * Metodo empleado para conectarnos con la BD
     *
     * @return return
     * @throws SQLException throws Exception
     */
    public void conectarBD() throws SQLException {
        //Ruta de la base de datos (jdbc:mysql://localhost:3306/alumnoBD?useTimezone=true&serverTimezone=GMT&useSSL=false)
        String url = "jdbc:mysql://" + DIRECCION + ":" + PUERTO + "/" + NAME + "?useTimezone=true&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";
        //Connection co = null;
        con = DriverManager.getConnection(url, USUARIO, PASS);
        //return objConn;
    }

    /**
     * Metodo para desconectarnos de la BD
     *
     * @param
     * @throws SQLException throws SQLException
     */
    public void desconectarBD() throws SQLException {
        con.close();
    }

    /**
     * metodo para insertar un nuevo campo
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
     * Metodo para insertar un nuevo Equipo
     *
     * @param nombre       nombre
     * @param patrocinador patrocinador
     * @param campo        campo
     * @return return
     * @throws Exception fallos en la query
     */
    public int insertarEquipo(String nombre, String patrocinador, int campo) throws Exception {
        return EquipoBD.insertar(con, nombre, patrocinador, campo);
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
     * MEtodo para insertar jugadores a la BD
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
        return JugadoresBD.insertar(con, nombre, apellido1, apellido2, fechaNac, dorsal, textoCamiseta, equipo, estado, posicion);
    }

    /**
     * gestionar select de jugadores
     *
     * @return resultset jugadores
     * @throws Exception fallos en la query
     */
    public ResultSet buscarJugador() throws Exception {
        return JugadoresBD.getAll(con);
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
     * metodo para gestionar la carga de posiciones
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
     * @return resultset eventos
     * @throws Exception fallos en la query
     */
    public ResultSet buscarEventos() throws Exception {
        return EventoBD.getAll(con);
    }
}
