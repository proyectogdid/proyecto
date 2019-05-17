package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * clase que gestionara los distintos estados en los que pueda encontrarse un jugador en BD
 */
public class EstadoBD extends Conexion {
    private static final String TEMPLATE = "estd.id, estd.nombre";

    /**
     * seleccionar estados de bd
     *
     * @param con con
     * @return resultset estados
     * @throws Exception fallos en la select
     */
    public static ResultSet getAll(Connection con) throws Exception {
        return select(con, "SELECT " + TEMPLATE + " FROM estados estd");
    }

    /**
     * Metodo para insertar estado en la BD
     *
     * @param con    con
     * @param nombre nombre
     * @return return
     * @throws Exception excepcion
     */
    public static int insertarEstado(Connection con, String nombre) throws Exception {
        Object[] parametros = {nombre};
        return insert(con, "INSERT INTO estados (nombre) VALUES(?) ", parametros);
    }
}
