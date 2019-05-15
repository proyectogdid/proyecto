package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Clase que se usara para obtener informacion sobre las posiciones de los jugadores de la BD
 */
public class PosicionBD extends Conexion {
    public static final String TEMPLATE="pscn.id, pscn.nombre";

    /**
     * metodo para recuperar las ditintas posiciones que puede tener un jugador
     * @param con conexion de BD
     * @return result set de datos
     * @throws Exception cualquier fallo que pueda tener la select
     */
    public static ResultSet getAll(Connection con)throws Exception{
        String query = "SELECT "  +TEMPLATE +" FROM posiciones pscn";
        ResultSet rs= select(con,query);
        return rs;
    }


    /**
     * Metodo para insertar las posiciones a la BD
     * @param con con
     * @param nombre nombre
     * @return return
     * @throws Exception Exception
     */
    public static int insertarPosicion(Connection con, String nombre)throws Exception{
        Object[] parametros = {nombre};
        return insert(con,"INSERT INTO posiciones (nombre) VALUES(?) ",parametros);
    }


}
