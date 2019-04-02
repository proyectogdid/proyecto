package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * clase que gestionara los distintos estados en los que pueda encontrarse un jugador en BD
 */
public class EstadoBD extends  Conexion{
    private static final String TEMPLATE = "estd.id, estd.nombre";

    /**
     * seleccionar estados de bd
     * @param con
     * @return
     * @throws Exception
     */
    public static ResultSet getAll(Connection con) throws Exception{
        return select(con, "SELECT "+TEMPLATE+" FROM estados estd");
    }
}
