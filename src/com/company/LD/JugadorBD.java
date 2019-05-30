package com.company.LD;

import java.util.Date;
import java.sql.Connection;

import java.sql.ResultSet;

/**
 * Esta clase la utilizaremos para insertar y obtener informacion de los partidos de la BD
 */
public class JugadorBD extends Conexion {

    private static final String TEMPLATE = "jug.id,jug.nombre,jug.apellido1,jug.apellido2,jug.fechaNac,jug.dorsal,jug.textoCamiseta, jug.equipo, jug.posicion, jug.estado";

    /**
     * Metodo para insertar jugadores a nuestra BD
     *
     * @param con           con
     * @param nombre        nombre
     * @param apellido1     apellido1
     * @param apellido2     apellido2
     * @param fechaNac      fechaNac
     * @param dorsal        dorsal
     * @param textoCamiseta textoCamiseta
     * @param equipo        equipo
     * @param estado        estado
     * @param posicion      posicion
     * @return return
     * @throws Exception fallos en el insert
     */
    public static int insertar(Connection con, String nombre, String apellido1, String apellido2, Date fechaNac, String dorsal, String textoCamiseta, int equipo, int estado, int posicion) throws Exception {

        Object[] parametros = {nombre, apellido1, apellido2, fechaNac, dorsal, textoCamiseta, equipo, estado, posicion};
        return insert(con, "INSERT INTO jugadores (nombre,apellido1,apellido2,fechaNac,dorsal,textoCamiseta,equipo,estado,posicion)VALUES(?,?,?,?,?,?,?,?,?)", parametros);
    }

    /**
     * Metodo para obtener informcacion de los jugadores de la BD
     *
     * @param con con
     * @return resultset jugadores
     * @throws Exception fallos en la select
     */
    public static ResultSet getAll(Connection con) throws Exception {
        String query = "SELECT " + TEMPLATE + " FROM jugadores jug";
        ResultSet rs = select(con, query);
        return rs;
    }
}
