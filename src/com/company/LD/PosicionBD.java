package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;

public class PosicionBD extends Conexion {
    public static final String TEMPLATE="pscn.id, pscn.nombre";

    /**
     * metodo para recuperar las ditintas posiciones que puede tener un jugador
     * @param con conexion de BD
     * @return result set de datos
     * @throws Exception cualquier fallo que pueda tener la select
     */
    public static ResultSet getAll(Connection con)throws Exception{
        return select(con, "SELECT "+TEMPLATE+" FROM posiciones pscn");
    }
}
